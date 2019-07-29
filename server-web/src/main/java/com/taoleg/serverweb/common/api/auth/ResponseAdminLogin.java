package com.taoleg.serverweb.common.api.auth;

import com.pengpenghuyu.supportplat.common.base.ResponseBean;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 管理员登陆接口_返回结果
 * @author chenqing
 * @date 2017/4/28
 */
@Data
public class ResponseAdminLogin extends ResponseBean<ResponseAdminLogin.ResponseData> {

    @Data
    public static class ResponseData {

        private String id;
        private String username;
        private String email;
        private String phone;
        private Integer sex;
        private String createTime;
        private Map<String, List<PermissionInfo>> route;
        private Map<String, List<PermissionInfo>> api;
        private List<AppInfo> apps;

    }
    @Data
    public static class PermissionInfo implements Serializable {
        private String appKey;
        private String route;
        private String icon;//图标名称
        private String permissionName;
        private Integer id;
        private Integer pid;
        private Integer level;//树节点所在的层级，即该节点的深度，从0开始
    }
    @Data
    public static class AppInfo {

        private String name;
        private String alias;
//        private String appName;
//        private String appKey;
//        private String appImg;
    }
}
