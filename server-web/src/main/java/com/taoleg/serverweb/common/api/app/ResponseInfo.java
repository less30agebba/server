package com.taoleg.serverweb.common.api.app;

import com.taoleg.servercore.common.base.ResponseBean;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ResponseInfo extends ResponseBean<ResponseInfo.ResponseData> {

  @Data
  public static class ResponseData{

      String appImgUrl;

      String appName;

      String appAlias;

      Double minimumWithdrawal;

      /**
       * 有序列表
       */
      List<Set<String>> power;

      boolean qrCode;

      boolean newFrame;

      int [] roles;

  }

}
