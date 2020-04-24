# cloud2020

## Hystrix Dashboard

## spring cloud gateway

主要有以下三个核心概念

- 路由
- 断言
- 过滤器

具体示例代码可以参考: cloud-gateway-gateway9527模块

spring官网地址: https://cloud.spring.io/spring-cloud-gateway/2.2.x/reference/html/#gateway-starter


## spring cloud 配置中心

spring cloud 配置中心可分为服务端和客户端两部分

服务端代码可参见cloud-config-center-3344模块;客户端代码可参见cloud-config-client-3355模块

git服务器上中,配置文件名格式如下:

```$xslt
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```

