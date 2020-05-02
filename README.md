# iofmap-root
 

定向越野城市地图共享平台
 - 后端部分

### 主要功能

* 提供登录与注册接口
* 地图文件管理与查询

### 所用技术

* 使用 maven 进行项目管理与外部依赖管理
* 基于内置了 Tomcat 容器的 Springboot 框架搭建轻量级的应用
* 使用 MySQL 建立关系性数据库
* 使用 MybatisORM 框架完成与数据库的安全交互，可极大程度上防止 sql 注入攻击


### 目录结构

```
├─account               账号模块
│  └─account-bo        账号BO模块（Business Object）
├─common                公共模块
│  ├─common-facade     公共接口类
│  └─common-util       公共工具类
├─customer              消费者模块
│  ├─doc               接口文档
│  └─service-customer  服务消费者
└─mapfile               地图模块
    └─mapfile-bo        地图BO模块（Business Object）
```