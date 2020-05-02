package com.zhihao.customer.mapfile.controller;

import com.zhihao.common.DO.MapInfoDO;
import com.zhihao.common.dto.ResultDTO;
import com.zhihao.common.util.FileUtil;
import com.zhihao.customer.mapfile.config.MapPathConfig;
import com.zhihao.mapfile.dto.MapDetailDTO;
import com.zhihao.mapfile.service.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * @author tianyi
 * @date 2020-04-19 17:36
 */
@RestController
@RequestMapping("/map")
public class MapFileController {

    Logger log = LoggerFactory.getLogger(MapFileController.class);

    @Autowired
    private MapService mapService;

    @Autowired
    private MapPathConfig mapPathConfig;

    /**
     * @apiDefine MapFile 地图
     */

    /**
     *  @apiDefine ResultDTO
     *  @apiSuccess {Integer} resultCode 响应结果
     *  @apiSuccess {String} resultMsg 结果描述
     *  @apiSuccess {Object} data 数据主体
     *  @apiSuccess {Integer} count 总数据量
     */

    /**
     * @api {post} /zhihao/map/upload 上传地图
     * @apiGroup MapFile
     * @apiParam {String} province 省份文字
     * @apiParam {String} city 城市文字
     * @apiParam {String} cityCode 城市电话区号【必传】
     * @apiParam {int} createBy 当前用户的id【必传】
     * @apiParam {File} pictureFile 地图文件【必传】
     * @apiSuccessExample Success-Request:
     * {
     *     createBy:1
     * province:广东省
     * city:阳春市
     * cityCode:0662
     *     pictureFile: 阳春中心公园.jpg
     * }
     * @apiUse ResultDTO
     * @apiSuccessExample Success-Response:
     * {
     *     "resultCode": 200,
     *     "resultMsg": "成功",
     *     "data": 1,
     *     "count": 0
     * }
     */
    @PostMapping("/upload")
    public ResultDTO upload(@RequestParam("pictureFile") MultipartFile pictureFile, MapInfoDO mapInfoDO){
        if (pictureFile.isEmpty()) {
            // 判断文件是否为空
            log.error("上传的文件为空");
            return ResultDTO.error(403, "上传的文件为空");
        }else{
            try {
                // 获取文件内容字节数组
                InputStream input = pictureFile.getInputStream();
                byte[] byt = new byte[input.available()];
                input.read(byt);
                // 关闭用完的流
                input.close();

                // 获取原始文件名
                String originalFilename = pictureFile.getOriginalFilename();
                String filename = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
                // 存储路径
                String privateUrl = mapPathConfig.getMapDir() + "/" + filename;
                // 外部访问路径
                String publicUrl = "/zhihao/map/download?filename=" + filename;
                // 存储文件
                FileUtil.saveFile(privateUrl, byt);

                // 存入数据库
                mapInfoDO.setName(originalFilename);
                mapInfoDO.setPrivateUrl(privateUrl);
                mapInfoDO.setPublicUrl(publicUrl);
                mapInfoDO.setCreateTime(new Date());

                int count = mapService.create(mapInfoDO);
                if (count != 0){
                    return ResultDTO.success(count);
                }else{
                    return ResultDTO.error(500, "存入数据库时失败，原因未知");
                }
            } catch (FileNotFoundException e) {
                log.error("系统错误，文件夹不存在, FileNotFoundException, ",e);
                return ResultDTO.error(500, "系统错误，文件夹不存在");
            } catch (IOException e) {
                log.error("系统错误，字节传输时出现异常, IOException, ",e);
                return ResultDTO.error(500, "系统错误，字节传输时出现异常");
            }
        }
    }

    @GetMapping("/download")
    public ResultDTO download(HttpServletResponse response, @RequestParam("filename")String filename){
        // 存储路径
        String filePath = mapPathConfig.getMapDir() + "/" + filename;
        FileInputStream fileInputStream = null;
        byte[] byt = null;
        try {
            fileInputStream = new FileInputStream(new File(filePath));
            byt = new byte[fileInputStream.available()];
            fileInputStream.read(byt);
        } catch (FileNotFoundException e) {
            log.error("系统错误，文件夹不存在, FileNotFoundException, ",e);
            return ResultDTO.error(500, "系统错误，文件夹不存在");
        } catch (IOException e) {
            log.error("系统错误，读取文件字节时出现异常, IOException, ",e);
            return ResultDTO.error(500, "系统错误，读取文件字节时出现异常");
        }
        if (byt != null){
            response.setContentType("image/*");
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            OutputStream out = null;
            try {
                out = response.getOutputStream();
                out.write(byt);
                out.close();
            } catch (IOException e) {
                log.error("系统错误，返回文件字节时出现异常, IOException, ",e);
                return ResultDTO.error(500, "系统错误，返回文件字节时出现异常");
            }
        }else{
            return ResultDTO.error(444, "文件内容为空或不可读");
        }
        return ResultDTO.success();
    }

    /**
     * @api {get} /zhihao/map/listByCityCode 按城市获取地图
     * @apiGroup MapFile
     * @apiParam {String} cityCode 城市电话区号
     * @apiSuccessExample Success-Request:
     * {
     *     cityCode:0662
     * }
     * @apiUse ResultDTO
     * @apiSuccessExample Success-Response:
     * {
     *     "resultCode": 200,
     *     "resultMsg": "成功",
     *     "data": [
     *         {
     *             "id": 1,
     *             "province": "广东省",
     *             "city": "阳春市",
     *             "cityCode": "0662",
     *             "name": "wxQRC.jpg",
     *             "publicUrl": "/zhihao/map/download?filename=1587304658351.jpg",
     *             "privateUrl": "F:\\study\\jidi\\project\\iofmap\\iofmap-root\\files\\map/1587304658351.jpg",
     *             "downloadTime": 0,
     *             "likeTime": 0,
     *             "createBy": 1,
     *             "createTime": "2020-04-19T13:57:38.000+0000"
     *         },
     *         {
     *             "id": 2,
     *             "province": "广东省",
     *             "city": "阳春市",
     *             "cityCode": "0662",
     *             "name": "dog_long1.png",
     *             "publicUrl": "/zhihao/map/download?filename=1587304924796.png",
     *             "privateUrl": "F:\\study\\jidi\\project\\iofmap\\iofmap-root\\files\\map/1587304924796.png",
     *             "downloadTime": 0,
     *             "likeTime": 0,
     *             "createBy": 1,
     *             "createTime": "2020-04-19T14:02:04.000+0000"
     *         }
     *     ],
     *     "count": 0
     * }
     */
    @GetMapping("/listByCityCode")
    public ResultDTO<List<MapInfoDO>> listByCityCode(String cityCode){
        return ResultDTO.success(mapService.listAll(cityCode));
    }

    /**
     * @api {get} /zhihao/map/listByUserId 根据用户获取图片
     * @apiGroup MapFile
     * @apiParam {int} userId 用户id
     * @apiSuccessExample Success-Request:
     * {
     *     userId:1
     * }
     * @apiUse ResultDTO
     * @apiSuccessExample Success-Response:
     * {
     *     "resultCode": 200,
     *     "resultMsg": "成功",
     *     "data": [
     *         {
     *             "id": 1,
     *             "province": "广东省",
     *             "city": "阳春市",
     *             "cityCode": "0662",
     *             "name": "wxQRC.jpg",
     *             "publicUrl": "/zhihao/map/download?filename=1587304658351.jpg",
     *             "privateUrl": "F:\\study\\jidi\\project\\iofmap\\iofmap-root\\files\\map/1587304658351.jpg",
     *             "downloadTime": 0,
     *             "likeTime": 0,
     *             "createBy": 1,
     *             "createTime": "2020-04-19T13:57:38.000+0000"
     *         },
     *         {
     *             "id": 2,
     *             "province": "广东省",
     *             "city": "阳春市",
     *             "cityCode": "0662",
     *             "name": "dog_long1.png",
     *             "publicUrl": "/zhihao/map/download?filename=1587304924796.png",
     *             "privateUrl": "F:\\study\\jidi\\project\\iofmap\\iofmap-root\\files\\map/1587304924796.png",
     *             "downloadTime": 0,
     *             "likeTime": 0,
     *             "createBy": 1,
     *             "createTime": "2020-04-19T14:02:04.000+0000"
     *         }
     *     ],
     *     "count": 0
     * }
     */
    @GetMapping("/listByUserId")
    public ResultDTO<List<MapInfoDO>> listByUserId(int userId){
        return ResultDTO.success(mapService.listMine(userId));
    }

    /**
     * @api {get} /zhihao/map/detail 获取地图详情(含作者信息)
     * @apiGroup MapFile
     * @apiParam {int} mapId 地图编号
     * @apiSuccessExample Success-Request:
     * {
     *     mapId:1
     * }
     * @apiUse ResultDTO
     * @apiSuccessExample Success-Response:
     * {
     *     "resultCode": 200,
     *     "resultMsg": "成功",
     *     "data": {
     *         "mapInfo": {
     *             "id": 1,
     *             "province": "广东省",
     *             "city": "阳春市",
     *             "cityCode": "0662",
     *             "name": "wxQRC.jpg",
     *             "publicUrl": "/zhihao/map/download?filename=1587304658351.jpg",
     *             "privateUrl": "F:\\study\\jidi\\project\\iofmap\\iofmap-root\\files\\map/1587304658351.jpg",
     *             "downloadTime": 0,
     *             "likeTime": 0,
     *             "createBy": 1,
     *             "createTime": "2020-04-19T13:57:38.000+0000"
     *         },
     *         "author": {
     *             "id": null,
     *             "name": "zty",
     *             "phone": "18320444515",
     *             "roleId": null,
     *             "iofAge": 1,
     *             "organization": "广州中医药大学定向越野协会",
     *             "createTime": "2020-04-19T12:36:42.000+0000",
     *             "updateTime": null
     *         }
     *     },
     *     "count": 0
     * }
     */
    @GetMapping("/detail")
    public ResultDTO<MapDetailDTO> detail(int mapId){
        return ResultDTO.success(mapService.detail(mapId));
    }
}
