package org.charlie.position.infrastructure.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author mah
 * @description
 * @title Common
 * @date 2025/3/9 15:38
 **/
public class HostNameUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HostNameUtil.class);

    public static String getHostName() {
        String hostName = "unknow host";
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            LOGGER.info("获取主机名失败");
        }
        return hostName;
    }
}
