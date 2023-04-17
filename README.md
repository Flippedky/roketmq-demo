# RocketMq-demo 
整合 SpringCloudAlibaba 2021.x , SpringCloudStream , SpringCloudBus , RocketMq 实现**事件总线**的功能。
>Spring 内置了事件机制 (_SpringBootEvent_)，可以实现JVM 进程内的事件发布与监听。但是如果想要跨 JVM 进程的事件发布与监听，此时它就无法满足我们的诉求了。
因此，Spring Cloud Bus 在 Spring 事件机制的基础之上进行拓展，结合 RabbitMQ、Kafka、RocketMQ 等等消息队列作为事件的“**传输器**”，通过发送事件（消息）到消息队列上，从而广播到订阅该事件（消息）的所有节点上。

## 模块介绍
| 项目                                                                       | 说明          |
|--------------------------------------------------------------------------|-------------|
| `luckyi-spring-boot-starter-mq`                                                     | Mq 框架拓展     |
| `module-rocketmq-consumer`                                                        | 事件消费者(订阅事件) |
| `module-rocketmq-producer`                                                           | 事件生产者(发布事件) |
| `rocketmq-common`                                                    | 工具类及通用代码       |

***

**踩坑**
> 1. @EnableBinding注释在Spring Cloud 2020.0.0版本中已弃用，已被**函数式编程**模型所取代。我们需要在 spring.cloud.function.definition 配置中声明 消费者类/方法 (**_函数式编程 java.util.function.Consumer_**)
> 2. 使用 spring-cloud-starter-bus-rocketmq，需要注意该组件的自动配置可能与 spring.cloud.stream.function.definition 配置冲突，
   导致 spring-cloud-bus 订阅失败。解决办法是通过 stream.function.definition 配置 spring-cloud-stream 的函数定义。 具体可看 bus 默认属性配置  {**org.springframework.cloud.bus.BusEnvironmentPostProcessor**}


