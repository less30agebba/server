package com.taoleg.servercore.common.signatrue;


import com.taoleg.servercore.common.base.data.JsonDataTemplate;

public class Signature extends JsonDataTemplate<Signature> {

    private String serviceId;
    private String timestamp;
    private String sign;

    @Override
    public String toString() {
        return this.format();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
