package org.charlie.position.infrastructure.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.charlie.position.infrastructure.enums.RabbitInfoEnum.RPC_SERVER_UNICAST;

/**
 * @author mah
 * @description 单播服务端队列声明
 * @title UnicastRpcServerConfig
 * @date 2025/3/9 15:44
 **/
@Configuration
public class UnicastRpcServerConfig {
    /**
     * @Description 声明队列名称
     * @Date  2025/3/9
     * @Param []
     * @return org.springframework.amqp.core.Queue
     * @Author Charlie
     **/
    @Bean
    public Queue unicastRpcServerQueue(){
        return new Queue(RPC_SERVER_UNICAST.getQueue(),true,false,RPC_SERVER_UNICAST.getAutoDelee());
    }
}
