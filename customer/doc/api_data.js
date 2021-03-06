define({ "api": [
  {
    "type": "post",
    "url": "/zhihao/account/login",
    "title": "账号登录",
    "group": "Account",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号【必填】</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码【必填】</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Request:",
          "content": "{\n    phone:18320444515\npassword:abc123\n}",
          "type": "json"
        },
        {
          "title": "Success-Response:",
          "content": "{\n    \"resultCode\": 200,\n    \"resultMsg\": \"成功\",\n    \"data\": {\n        \"id\": 1,\n        \"name\": \"zty\",\n        \"phone\": \"18320444515\",\n        \"roleId\": null,\n        \"iofAge\": 1,\n        \"organization\": \"广州中医药大学定向越野协会\",\n        \"createTime\": \"2020-04-19T12:36:42.000+0000\",\n        \"updateTime\": \"2020-04-19T12:36:42.000+0000\"\n    },\n    \"count\": 0\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "resultCode",
            "description": "<p>响应结果</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "resultMsg",
            "description": "<p>结果描述</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>数据主体</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "count",
            "description": "<p>总数据量</p>"
          }
        ]
      }
    },
    "error": {
      "examples": [
        {
          "title": "Error-Respinse-有空:",
          "content": "{\n    \"resultCode\": 403,\n    \"resultMsg\": \"登录密码不能为空\",\n    \"data\": null,\n    \"count\": 0\n}",
          "type": "json"
        },
        {
          "title": "Error-Respinse-错误:",
          "content": "{\n    \"resultCode\": 444,\n    \"resultMsg\": \"手机号或密码错误\",\n    \"data\": null,\n    \"count\": 0\n}",
          "type": "json"
        },
        {
          "title": "Error-Respinse-异常:",
          "content": "{\n    \"resultCode\": 500,\n    \"resultMsg\": \"密码加密时出错，请联系管理员\",\n    \"data\": null,\n    \"count\": 0\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "./customer-web/src/main/java/com/zhihao/customer/account/controller/AccountController.java",
    "groupTitle": "账号",
    "name": "PostZhihaoAccountLogin"
  },
  {
    "type": "post",
    "url": "/zhihao/account/register",
    "title": "注册账号",
    "group": "Account",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名/昵称【必填】</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号【必填】</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码【必填】</p>"
          },
          {
            "group": "Parameter",
            "type": "float",
            "optional": false,
            "field": "iofAge",
            "description": "<p>定向年龄</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "organization",
            "description": "<p>所属组织/机构</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Request:",
          "content": "{\n    name:zty\nphone:18320444515\npassword:abc123\niofAge:1.5\norganization:广州中医药大学定向越野协会\n}",
          "type": "json"
        },
        {
          "title": "Success-Response:",
          "content": "{\n    \"resultCode\": 200,\n    \"resultMsg\": \"成功\",\n    \"data\": 1,\n    \"count\": 0\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "resultCode",
            "description": "<p>响应结果</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "resultMsg",
            "description": "<p>结果描述</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>数据主体</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "count",
            "description": "<p>总数据量</p>"
          }
        ]
      }
    },
    "error": {
      "examples": [
        {
          "title": "Error-Respinse-有空值:",
          "content": "{\n    \"resultCode\": 403,\n    \"resultMsg\": \"登录手机号不能为空\",\n    \"data\": null,\n    \"count\": 0\n}",
          "type": "json"
        },
        {
          "title": "Error-Respinse-已存在:",
          "content": "{\n    \"resultCode\": 444,\n    \"resultMsg\": \"注册失败，手机号已存在\",\n    \"data\": null,\n    \"count\": 0\n}",
          "type": "json"
        },
        {
          "title": "Error-Respinse-未知原因:",
          "content": "{\n    \"resultCode\": 500,\n    \"resultMsg\": \"注册失败，未知原因\",\n    \"data\": null,\n    \"count\": 0\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "./customer-web/src/main/java/com/zhihao/customer/account/controller/AccountController.java",
    "groupTitle": "账号",
    "name": "PostZhihaoAccountRegister"
  },
  {
    "type": "post",
    "url": "/zhihao/account/update",
    "title": "修改账号信息",
    "group": "Account",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>用户id【必填】</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名/昵称【可选】</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>手机号【可选】</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码【可选】</p>"
          },
          {
            "group": "Parameter",
            "type": "float",
            "optional": false,
            "field": "iofAge",
            "description": "<p>定向年龄【可选】</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "organization",
            "description": "<p>所属组织/机构【可选】</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Request:",
          "content": "{\n    id:1\n}",
          "type": "json"
        },
        {
          "title": "Success-Response:",
          "content": "{\n    \"resultCode\": 200,\n    \"resultMsg\": \"成功\",\n    \"data\": 1,\n    \"count\": 0\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "resultCode",
            "description": "<p>响应结果</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "resultMsg",
            "description": "<p>结果描述</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>数据主体</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "count",
            "description": "<p>总数据量</p>"
          }
        ]
      }
    },
    "error": {
      "examples": [
        {
          "title": "Error-Respinse-有空:",
          "content": "{\n    \"resultCode\": 403,\n    \"resultMsg\": \"用户id不可为空或为0\",\n     \"data\": null,\n     \"count\": 0\n}",
          "type": "json"
        },
        {
          "title": "Error-Respinse:",
          "content": "{\n    \"resultCode\": 500,\n    \"resultMsg\": \"修改失败，密码加密时出错，请联系管理员\",\n    \"data\": null,\n    \"count\": 0\n}",
          "type": "json"
        },
        {
          "title": "Error-Respinse:",
          "content": "{\n    \"resultCode\": 500,\n    \"resultMsg\": \"修改失败，未知原因\",\n    \"data\": null,\n    \"count\": 0\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "./customer-web/src/main/java/com/zhihao/customer/account/controller/AccountController.java",
    "groupTitle": "账号",
    "name": "PostZhihaoAccountUpdate"
  },
  {
    "type": "get",
    "url": "/zhihao/map/detail",
    "title": "获取地图详情(含作者信息)",
    "group": "MapFile",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "mapId",
            "description": "<p>地图编号</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Request:",
          "content": "{\n    mapId:1\n}",
          "type": "json"
        },
        {
          "title": "Success-Response:",
          "content": "{\n    \"resultCode\": 200,\n    \"resultMsg\": \"成功\",\n    \"data\": {\n        \"mapInfo\": {\n            \"id\": 1,\n            \"province\": \"广东省\",\n            \"city\": \"阳春市\",\n            \"cityCode\": \"0662\",\n            \"name\": \"wxQRC.jpg\",\n            \"publicUrl\": \"/zhihao/map/download?filename=1587304658351.jpg\",\n            \"privateUrl\": \"F:\\\\study\\\\jidi\\\\project\\\\iofmap\\\\iofmap-root\\\\files\\\\map/1587304658351.jpg\",\n            \"downloadTime\": 0,\n            \"likeTime\": 0,\n            \"createBy\": 1,\n            \"createTime\": \"2020-04-19T13:57:38.000+0000\"\n        },\n        \"author\": {\n            \"id\": null,\n            \"name\": \"zty\",\n            \"phone\": \"18320444515\",\n            \"roleId\": null,\n            \"iofAge\": 1,\n            \"organization\": \"广州中医药大学定向越野协会\",\n            \"createTime\": \"2020-04-19T12:36:42.000+0000\",\n            \"updateTime\": null\n        }\n    },\n    \"count\": 0\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "resultCode",
            "description": "<p>响应结果</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "resultMsg",
            "description": "<p>结果描述</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>数据主体</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "count",
            "description": "<p>总数据量</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./customer-web/src/main/java/com/zhihao/customer/mapfile/controller/MapFileController.java",
    "groupTitle": "地图",
    "name": "GetZhihaoMapDetail"
  },
  {
    "type": "get",
    "url": "/zhihao/map/listByCityCode",
    "title": "按城市获取地图",
    "group": "MapFile",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "cityCode",
            "description": "<p>城市电话区号</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Request:",
          "content": "{\n    cityCode:0662\n}",
          "type": "json"
        },
        {
          "title": "Success-Response:",
          "content": "{\n    \"resultCode\": 200,\n    \"resultMsg\": \"成功\",\n    \"data\": [\n        {\n            \"id\": 1,\n            \"province\": \"广东省\",\n            \"city\": \"阳春市\",\n            \"cityCode\": \"0662\",\n            \"name\": \"wxQRC.jpg\",\n            \"publicUrl\": \"/zhihao/map/download?filename=1587304658351.jpg\",\n            \"privateUrl\": \"F:\\\\study\\\\jidi\\\\project\\\\iofmap\\\\iofmap-root\\\\files\\\\map/1587304658351.jpg\",\n            \"downloadTime\": 0,\n            \"likeTime\": 0,\n            \"createBy\": 1,\n            \"createTime\": \"2020-04-19T13:57:38.000+0000\"\n        },\n        {\n            \"id\": 2,\n            \"province\": \"广东省\",\n            \"city\": \"阳春市\",\n            \"cityCode\": \"0662\",\n            \"name\": \"dog_long1.png\",\n            \"publicUrl\": \"/zhihao/map/download?filename=1587304924796.png\",\n            \"privateUrl\": \"F:\\\\study\\\\jidi\\\\project\\\\iofmap\\\\iofmap-root\\\\files\\\\map/1587304924796.png\",\n            \"downloadTime\": 0,\n            \"likeTime\": 0,\n            \"createBy\": 1,\n            \"createTime\": \"2020-04-19T14:02:04.000+0000\"\n        }\n    ],\n    \"count\": 0\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "resultCode",
            "description": "<p>响应结果</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "resultMsg",
            "description": "<p>结果描述</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>数据主体</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "count",
            "description": "<p>总数据量</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./customer-web/src/main/java/com/zhihao/customer/mapfile/controller/MapFileController.java",
    "groupTitle": "地图",
    "name": "GetZhihaoMapListbycitycode"
  },
  {
    "type": "get",
    "url": "/zhihao/map/listByUserId",
    "title": "根据用户获取图片",
    "group": "MapFile",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Request:",
          "content": "{\n    userId:1\n}",
          "type": "json"
        },
        {
          "title": "Success-Response:",
          "content": "{\n    \"resultCode\": 200,\n    \"resultMsg\": \"成功\",\n    \"data\": [\n        {\n            \"id\": 1,\n            \"province\": \"广东省\",\n            \"city\": \"阳春市\",\n            \"cityCode\": \"0662\",\n            \"name\": \"wxQRC.jpg\",\n            \"publicUrl\": \"/zhihao/map/download?filename=1587304658351.jpg\",\n            \"privateUrl\": \"F:\\\\study\\\\jidi\\\\project\\\\iofmap\\\\iofmap-root\\\\files\\\\map/1587304658351.jpg\",\n            \"downloadTime\": 0,\n            \"likeTime\": 0,\n            \"createBy\": 1,\n            \"createTime\": \"2020-04-19T13:57:38.000+0000\"\n        },\n        {\n            \"id\": 2,\n            \"province\": \"广东省\",\n            \"city\": \"阳春市\",\n            \"cityCode\": \"0662\",\n            \"name\": \"dog_long1.png\",\n            \"publicUrl\": \"/zhihao/map/download?filename=1587304924796.png\",\n            \"privateUrl\": \"F:\\\\study\\\\jidi\\\\project\\\\iofmap\\\\iofmap-root\\\\files\\\\map/1587304924796.png\",\n            \"downloadTime\": 0,\n            \"likeTime\": 0,\n            \"createBy\": 1,\n            \"createTime\": \"2020-04-19T14:02:04.000+0000\"\n        }\n    ],\n    \"count\": 0\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "resultCode",
            "description": "<p>响应结果</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "resultMsg",
            "description": "<p>结果描述</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>数据主体</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "count",
            "description": "<p>总数据量</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./customer-web/src/main/java/com/zhihao/customer/mapfile/controller/MapFileController.java",
    "groupTitle": "地图",
    "name": "GetZhihaoMapListbyuserid"
  },
  {
    "type": "post",
    "url": "/zhihao/map/upload",
    "title": "上传地图",
    "group": "MapFile",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "province",
            "description": "<p>省份文字</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "city",
            "description": "<p>城市文字</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "cityCode",
            "description": "<p>城市电话区号【必传】</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "createBy",
            "description": "<p>当前用户的id【必传】</p>"
          },
          {
            "group": "Parameter",
            "type": "File",
            "optional": false,
            "field": "pictureFile",
            "description": "<p>地图文件【必传】</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Request:",
          "content": "{\n    createBy:1\nprovince:广东省\ncity:阳春市\ncityCode:0662\n    pictureFile: 阳春中心公园.jpg\n}",
          "type": "json"
        },
        {
          "title": "Success-Response:",
          "content": "{\n    \"resultCode\": 200,\n    \"resultMsg\": \"成功\",\n    \"data\": 1,\n    \"count\": 0\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "resultCode",
            "description": "<p>响应结果</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "resultMsg",
            "description": "<p>结果描述</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "data",
            "description": "<p>数据主体</p>"
          },
          {
            "group": "Success 200",
            "type": "Integer",
            "optional": false,
            "field": "count",
            "description": "<p>总数据量</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "./customer-web/src/main/java/com/zhihao/customer/mapfile/controller/MapFileController.java",
    "groupTitle": "地图",
    "name": "PostZhihaoMapUpload"
  }
] });
