package com.taoleg.serverweb.common.api.auth;

import lombok.Data;

/**
 * 管理员登陆接口_请求参数
 * @author chenqing
 * @date 2017/4/28
 */
@Data
public class ResquestLogin {

    private String username;

    private String password;

    private String ticket;

}
