package org.charlie.position.infrastructure.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author mah
 * @description
 * @title Common
 * @date 2025/3/9 15:38
 **/
public class Common {

    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return null;
        }
    }
}
