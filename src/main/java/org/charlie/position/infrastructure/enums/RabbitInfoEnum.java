package org.charlie.position.infrastructure.enums;

/**
 * @author mah
 * @description mq枚举类
 * @title RabbitInfoEnum
 * @date 2025/3/8 9:41
 */
public enum RabbitInfoEnum {

    RPC_CLIENT_UNICAST("","","rpc-client-unicast","",false),
    RPC_SERVER_UNICAST("","","rpc-server-unicast","",false),
    RPC_CLIENT_MULTICAST("exchange-rpc-client-multicast","fanout","queue-rpc-client-multicast","",false),
    RPC_SERVER_MULTICAST("exchange-rpc-server-multicast","fanout","queue-rpc-server-multicast","",false),
    DEFAULT("","","","",true);

    private final String exchange;
    private final String exchangeType;
    private final String queue;
    private final String routingKey;
    private final boolean autoDelee;

    RabbitInfoEnum(String exchange, String exchangeType, String queue, String routingKey, boolean autoDelee) {
        this.exchange = exchange;
        this.exchangeType = exchangeType;
        this.queue = queue;
        this.routingKey = routingKey;
        this.autoDelee = autoDelee;
    }

    public String getExchange() {
        return exchange;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public String getQueue() {
        return queue;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public boolean getAutoDelee() {
        return autoDelee;
    }
}
