package com.taoleg.servercore.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Cookie Utils
 */
public class CookieUtils {

  /**
   * 获取对应Cookie Name的值
   * @param request
   * @param cookieName
   * @return CookieValue
   */
  public static String getCookieValue(HttpServletRequest request, String cookieName) {

    Cookie cookie = getCookie(request, cookieName);
    return cookie != null ? cookie.getValue() : null;

  }

  /**
   * 获取对应cookie
   * @param request
   * @param cookieName
   * @return
   */
  public static Cookie getCookie(HttpServletRequest request, String cookieName) {
    Cookie cookie = null;

    Cookie[] cookies = request.getCookies();
    if(null == cookies){
      return null;
    }

    for(int i=0; i<cookies.length; i++){
      if(cookieName.equals(cookies[i].getName())){
        cookie = cookies[i];
      }
    }

    return  cookie;
  }

}
