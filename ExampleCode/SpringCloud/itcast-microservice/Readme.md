商品微服务--item--服务方

订单微服务--order--消费方

对于商品微服务而言，商品微服务是服务的提供者，订单微服务是服务的消费者；

对于订单微服务而言，订单微服务是服务的提供者，人是服务的消费者。

---

- Eureka 服务注册中心
  支持面向服务的路由。

- Ribbon 实现客户端负载均衡--order中
  spring-cloud-starter-eureka-server 中已经包含此依赖

- Hystrix 断路器（熔断保护）--order中
  避免雪崩效应，默认值为5秒内的20次故障“电路打开”不进行通讯，直接走设置的调用失败的方法

- Feign 实现声明式的 REST 调用--order中（消费方使用）
  经过 SpringCloud 的封装，可以使用 SpringMVC 的注解。

- Zuul 服务网关，类似拦截器或者过滤器，对应：api-gateway
  支持使用正则来写路由规则。支持配置过滤器。

- SpringCloudConfig 统一配置，对应：config-server
  官方推荐使用 Git，可用 web 钩子自动更新。
  具体使用在 item 模块里。

- SpringCloudBus 消息总线
  实现了对 RabbitMQ 以及 Kafka 的支持。
  具体使用参见 item 模块。