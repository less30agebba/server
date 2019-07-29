package com.taoleg.servercore.common.entity;

import com.taoleg.servercore.common.entity.type.ThirdPartyBindType;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenqing
 * @date 2017/4/27
 */
@Data
@Entity
@Table(name = "agent_user")
public class AgentUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private int appid;
    private Integer pid;
    private String path;
    private Integer role;
    private String nickname;
    @Column(name = "head_img")
    private String headImg;
    private String password;

    @Column(name = "wechat_id")
    private String weChatId;

    private String phone;
    private String email;
    private Integer sex;

    @Column(name = "is_login")
    private Integer isLogin;

    private Integer powers;

    private Integer settle;

    /**
     * 绑定了哪些第三方账号
     */
    @Column(name = "third_party_bind")
    private String thirdPartyBind;

    @Transient
    private List<ThirdPartyBindType> thirdPartyBindTypes;


    //备注
    @Lob
    @Type(type="text")
    private String remark;

    @Column(name = "max_child_count")
    private Integer maxChildCount;

    @Column(name = "conf_income")
    private Double confIncome;

    private Integer status;
    @Column(name = "create_time")
    private Timestamp createTime;

    private String recommender;

    @Column(name = "recommend_income")
    private Double recommendIncome;

    @Column(name = "recommended_income")
    private Double recommendedIncome;
    
    @Column(name = "popularize_url")
    private String popularizeUrl;

    @Column(name = "qr_code_img")
    private String qrCodeImg;

    /**
     * 增加第三方绑定类型
     * @param
     */
    public void addThirdPartyBindType(ThirdPartyBindType thirdPartyBindType) {

        if(this.thirdPartyBindTypes != null && this.thirdPartyBindTypes.contains(thirdPartyBindType)){
            return;
        }

        if(null == this.thirdPartyBind){
            this.thirdPartyBind = String.valueOf(thirdPartyBindType.getValue());
        }else{
            String thirdPartyBindItem = String.valueOf(thirdPartyBindType.getValue());

            List<String> bindList = new ArrayList<>();
            bindList.add(thirdPartyBindItem);
            bindList.addAll(Arrays.asList(this.thirdPartyBind.split(",")));
            this.thirdPartyBind = StringUtils.join(bindList,",");
        }
    }
}
