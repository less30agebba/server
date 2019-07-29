package com.taoleg.serverweb.common.controller;

import com.taoleg.servercore.common.base.BaseController;
import com.taoleg.servercore.common.base.BaseResponse;
import com.taoleg.servercore.common.base.ResponseCode;
import com.taoleg.serverservice.service.AuthService;
import com.taoleg.serverweb.common.api.auth.ResponseAdminLogin;
import com.taoleg.serverweb.common.api.auth.ResquestLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

/**
 * Restful API Auth
 */
@RestController("ManagerAuthController")
@RequestMapping("/manager/auth")
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;

    @RequestMapping("/login")
    public ResponseAdminLogin login(@RequestBody ResquestLogin request, HttpServletResponse reponse) {
        ResponseAdminLogin response = new ResponseAdminLogin();
        return response;
    }

    @RequestMapping("/logout")
    public BaseResponse logout(HttpServletRequest request) {
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SECCESS.getCode());
        return response;
    }

}
