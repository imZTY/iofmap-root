package com.zhihao.customer.mapfile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * @author tianyi
 * @date 2020-04-19 17:53
 */
@Component
public class MapPathConfig {

    @Value("${filePath.root}")
    private String fileRootDir;

    @Value("${filePath.map}")
    private String mapDir;

    @PostConstruct
    private void init(){
        System.out.println("MapPathConfig初始化文件夹...");
        File rootDir = new File(this.fileRootDir);
        File mapDir = new File(this.mapDir);
        if (!rootDir.exists()){
            rootDir.mkdirs();
        }
        if (!mapDir.exists()){
            mapDir.mkdirs();
        }
        try {
            // 转化为绝对路径
            this.fileRootDir = rootDir.getCanonicalPath();
            this.mapDir = mapDir.getCanonicalPath();
        } catch (IOException e) {
            System.out.println("MapPathConfig初始化文件夹...失败！");
            e.printStackTrace();
        }
    }

    public String getFileRootDir() {
        return fileRootDir;
    }

    public String getMapDir() {
        return mapDir;
    }
}
