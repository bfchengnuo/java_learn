RabbitMQ 一般学习它的前五种模式就够了，最后的 RPC 它不擅长，一般我们用阿里的

端口 5672，管理端口 15672

## 简单队列

这是最简单的一种消息队列，官方的图示：

![(P) -> [|||] -> (C)](https://www.rabbitmq.com/img/tutorials/python-one.png)

P：消息的生产者

C：消费者

过程：生产者制造消息然后放进消息队列，消费者从其中取出

**示例代码对应在 simple 包下**

## Work模式

官方图示：

![img](https://www.rabbitmq.com/img/tutorials/python-two.png)

两个消费者只有一个能拿到消息

默认的示例代码中，两个消费者虽然获取频率不同但能拿到相同数量的消息

加入： `channel.basicQos(1);` 开启能者多劳模式，同一时刻服务器只会发一条消息给消费者，这样收取频率快的自然收到的消息就多。

默认情况下，消息的确认是自动模式，也就是当消费者获取消息后即认为此消息已被消费，当设置为手动状态时，必须要手动确认：设置 channel 的 basicConsume 方法的第二个参数为 false 开启手动确认，处理消息后调用 channel 的 basicAck 方法。

``` java
// 监听队列，手动返回完成
channel.basicConsume(QUEUE_NAME, false, consumer);
// 获取消息
while (true) {
  QueueingConsumer.Delivery delivery = consumer.nextDelivery();
  String message = new String(delivery.getBody());
  System.out.println(" [x] Received '" + message + "'");
  //休眠
  Thread.sleep(10);
  // 返回确认状态
  channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
}
```

消费者获取消息后会被标记为不可用状态，只有当确认后才会被标记为消费删除

**对应示例代码在 work 包下**

## 订阅模式

官方图示：

![img](https://www.rabbitmq.com/img/tutorials/python-three-overall.png)

X：交换机

当生产者产生消息时，发送给交换机，交换机负责把它交给所有与之绑定的消息队列

> 交换机不具备保存的能力，当没有队列与交换机绑定时，消息将丢失
>
> 客户端将消息队列绑定到交换机必须保证交换机已存在

这样就能实现一个消息被多个消费者同时接收

**对应示例代码中的 ps 包下**

## 路由模式

官方图示：

![img](https://www.rabbitmq.com/img/tutorials/direct-exchange.png)

和订阅模式差不多，唯一的区别是使用了 标签（或者说是 Key），也就是说交换机的型号不一样了！

生产者在发送消息的时候会打上标签，交换机根据不同的标签发送给绑定的队列（队列在绑定的时候也需要确定标签）

关键代码：

``` java
// 绑定交换机的指定标签，多个标签执行多次
channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "name");
channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "name2");

// 生产者确定交换机的类型
channel.exchangeDeclare(EXCHANGE_NAME, "direct");
```

**示例代码在 routing 包下**

## 通配符模式

官方图示：

![img](https://www.rabbitmq.com/img/tutorials/python-five.png)

也是扩展自订阅模式，另一种交换机的类型，特点是可以使用通配符设置标签，这样在消费者端就不需要执行多次 queueBind 代码了

通配符（和正则里的不同一样）：

`#` 匹配一个或多个

`*` 匹配仅一个

其他的也没啥说的，**示例代码在  Topic 包下**

## Spring的支持

在 Spring 官网可以看到 Spring AMQP 项目，一个是抽象的 AMQP 协议的实现，另一个是基于 RabbitMQ 的具体实现

具体的示例代码在 Spring 包下，不要忘了配置文件

其中，队列和交换机默认都是进行持久化的，也就是 durable=true ，设置为持久化的速度要比不持久化的慢一些，即使设置了自动声明（如果没有就自动创建），也是在使用的时候才会执行相关逻辑

> 消息队列和交换机的绑定一般是在管理界面完成的
>
> 因为后台只需要配交换机，前台只需要配消费者的队列，它们无法进行代码绑定（在 Spring 中）
