package com.zhidian.mam.commons;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * 工具类
 */
public class Utils {

	static public String uuid() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}

	/**
	 * 
	 * <br/>Description:获取ip
	 * <p>Author:jmzhang/张际明</p>
	 * @param request
	 * @return
	 */
	static public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equalsIgnoreCase(ip)?"127.0.0.1":ip;
    }

}
