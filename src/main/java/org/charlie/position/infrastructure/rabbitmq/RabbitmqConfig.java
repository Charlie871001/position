package org.charlie.position.infrastructure.rabbitmq;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mah
 * @description 监听容器
 * @title RabbitmqConfig
 * @date 2025/3/9 14:48
 **/
@Configuration
public class RabbitmqConfig {

    /**
     * @Description 动态创建队列并监听
     * @Date  2025/3/9
     * @Param [org.springframework.amqp.rabbit.connection.ConnectionFactory]
     * @return org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
     * @Author Charlie
     **/
    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        return container;
    }
}
