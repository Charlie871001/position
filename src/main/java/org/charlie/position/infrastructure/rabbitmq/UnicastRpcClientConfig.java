package org.charlie.position.infrastructure.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.charlie.position.infrastructure.enums.RabbitInfoEnum.RPC_CLIENT_UNICAST;
import static org.charlie.position.infrastructure.utils.Common.getHostName;

/**
 * @author mah
 * @description 单播客户端队列声明
 * @title UnicastRpcClientConfig
 * @date 2025/3/9 15:33
 **/
@Configuration
public class UnicastRpcClientConfig {

    /**
     * @Description 声明队列名称
     * @Date  2025/3/9
     * @Param []
     * @return org.springframework.amqp.core.Queue
     * @Author Charlie
     **/
    @Bean
    public Queue unicastRpcClientQueue(){
        String queue = RPC_CLIENT_UNICAST.getQueue() + getHostName();
        return new Queue(queue,true,false,RPC_CLIENT_UNICAST.getAutoDelee());
    }
}
