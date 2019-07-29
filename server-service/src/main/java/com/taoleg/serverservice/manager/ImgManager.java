package com.taoleg.serverservice.manager;

/**
 * @author chenqing
 * @date 2017/12/8
 */
public interface ImgManager {

    String channelQrcode(Integer appid, String playerId, boolean isMJ);
    String agentImg(Integer id, String playerId);
}
