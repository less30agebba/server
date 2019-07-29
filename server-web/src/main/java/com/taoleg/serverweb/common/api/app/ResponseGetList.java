package com.taoleg.serverweb.common.api.app;

import com.taoleg.servercore.common.base.ResponseBean;
import lombok.Data;

import java.util.List;

@Data
public class ResponseGetList extends ResponseBean<List<ResponseGetList.AppData>> {

   @Data
    public static class AppData {

        private String name;
        private String alias;
        private String img;
    }

}
