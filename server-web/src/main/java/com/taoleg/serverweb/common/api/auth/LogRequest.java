package com.taoleg.serverweb.common.api.auth;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by mumu on 2017/10/23.
 */

@Data
public class LogRequest {

    private String request;
    private String response;
    private String obj;
    private Long requestTime;
    private Long responseTime;
    private Long duration;
    private String requestIP;
    private String responseIP;
    private String serviceId;
    private String exception;

    public void setResponseIP () throws SocketException {
        Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements() && responseIP == null) {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address) {
                    responseIP = ip.getHostAddress();
                }
            }
        }
    }
    public String toString(){
        return JSON.toJSON(this).toString();
    }

}
