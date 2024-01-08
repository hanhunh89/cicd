package com.springmvc.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetServerIp {
     public static String getServerIpAddress() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }
}