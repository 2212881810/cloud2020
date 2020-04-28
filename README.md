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

现gigthub上有配置文件:config-dev.yml

config server启动之后,浏览访问http://127.0.0.1:3344/master/config-dev.yml成功.说明config server自测通过

config-client-3355 启动之后,就可以由本地配置中心获取配置文件的信息. 浏览器发送请求:http://127.0.0.1:3355/getMsg

如果github上的config-dev.yml配置内容发生变化, config-server可以立马感知到变化,
但是config-client-3355不能,即便是添加以下两个配置
```

# 暴露的端口
management:
  endpoints:
    web:
      exposure:
        include: "*"
```

```$xslt
@RefreshScope  // 刷新注解
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String msg;

    @GetMapping("/getMsg")
    public String getMsg() {
        return msg;
    }
}

```

解决方案,需要手动调用config-client-3355 刷新接口
```$xslt
curl -X POST http://127.0.0.1:3355/actuator/refresh
```

