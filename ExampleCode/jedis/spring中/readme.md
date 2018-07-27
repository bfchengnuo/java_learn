此种实现方式并没有依赖于 spring，作为工具类自己封装的；因为 spring 提供的配置并不支持分片式连接池。

在 applicationContext-spring-session 配置文件中整合 SpringSession 的时候使用了 spring 对 Redis 的一些支持

-----

spring-redisTemplate 内的配置参考：https://blog.csdn.net/qq_34021712/article/details/75949706