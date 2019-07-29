package com.taoleg.serverservice.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.taoleg.serverservice.manager.ImgManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ImgManagerImpl implements ImgManager {


    @Override
    public String channelQrcode(Integer appid, String playerId, boolean isMJ) {

//        App app = appCache.getApp(appid);
//        AgentUserEntity agent = agentUserRepo.findByUsernameAndAppid(playerId, appid);
//
//        String index = "./images/" + app.getAppKey();
//        File indexDir = new File(index);
//        if(!indexDir.exists()&&indexDir.isDirectory()){//判断文件目录是否存在
//            indexDir.mkdirs();
//        }
//        String baseImgFile = index + "/baseImg.jpg";
//        String qrcodeImgFile = index + "/" + UNIDGenerateUtils.getUnid() + ".png";//二维码图片
//        String headImgFile = index + "/" + UNIDGenerateUtils.getUnid() + ".png";//头像图片
//        String endImgFile = index + "/" + UNIDGenerateUtils.getUnid() + ".png";
//        String shareImgFile = "";//最后合成的图片
//        String temp = "";
//        MultipartFile multipartFile = null;
//        FileInputStream input = null;
//        try {
//            ImageOperation.createQRCodeImg(agent.getPopularizeUrl(), qrcodeImgFile, headImgFile, agent.getHeadImg(),isMJ);
//            if (isMJ) {
//                shareImgFile = ImageOperation.createShareImg(baseImgFile, qrcodeImgFile, "", 180, 20, 2);
//            } else {
//                shareImgFile = ImageOperation.createShareImg(baseImgFile, qrcodeImgFile, "", 127, -12, 2);
//            }
//            File file = new File(shareImgFile);
//            input = new FileInputStream(file);
//            multipartFile = new MockMultipartFile("file", file.getName(), "image/jpeg", input);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (WriterException e) {
//            e.printStackTrace();
//        } finally {
//            ImageOperation.deleteFile(headImgFile);
//            ImageOperation.deleteFile(shareImgFile);
//            ImageOperation.deleteFile(qrcodeImgFile);
//            ImageOperation.deleteFile(temp);
//            ImageOperation.deleteFile(endImgFile);
//        }
//
//        String result = UploadFileClient.uploadFile(appid, multipartFile);
//        JSONObject json = JSONObject.parseObject(result);
//        if (StringUtils.isEmpty(json.getString("imgUrl"))) {
//            throw new ClientException("上传图片失败");
//        }
//        return json.getString("imgUrl");
        return null;
    }



    @Override
    public String agentImg(Integer id, String playerId){
        //拿到图片url 拿到图片
//        AgentImgEntity agentImgEntity = agentImgRepo.findById(id);
//        String imgUrl = agentImgEntity.getImgUrl();
//        File imgFile = new File(imgUrl);
//
//        Integer appid = ContextHelper.getApp().getAppId();
//        App app = appCache.getApp(appid);
//        AgentUserEntity agent = agentUserRepo.findByUsernameAndAppid(playerId, appid);
//
//        String index = "./agentimages";
//        File indexDir = new File(index);
//        if(!indexDir.exists()&&indexDir.isDirectory()){//生成一个文件夹 存放生成的文件
//            indexDir.mkdirs();
//        }
//        //规定图片生成的存放路径
//        String baseImgFile = index + "/" + UNIDGenerateUtils.getUnid() + ".jpg";
//        ImageOperation.writeImageToDisk( ImageOperation.getImageFromNetByUrl(imgUrl), baseImgFile);
//        String qrcodeImgFile = index + "/" + UNIDGenerateUtils.getUnid() + ".png";//二维码图片
//        String headImgFile = index + "/" + UNIDGenerateUtils.getUnid() + ".png";//头像图片
//        String shareImgFile = "";//最后合成的图片
//        File file = null;
//        MultipartFile multipartFile = null;
//        FileInputStream input = null;
//        try {
//            ImageOperation.createQRCodeImgUser(agent.getPopularizeUrl(), qrcodeImgFile, headImgFile, agent.getHeadImg(),agentImgEntity.getLength());
//
//            shareImgFile = ImageOperation.createShareImg(baseImgFile, qrcodeImgFile, "", agentImgEntity.getPositionX(), agentImgEntity.getPositionY(), 2);
//            file = new File(shareImgFile);
//            input = new FileInputStream(file);
//            multipartFile = new MockMultipartFile("file", file.getName(), "image/jpeg", input);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (WriterException e) {
//            e.printStackTrace();
//        } finally {
//            ImageOperation.deleteFile(headImgFile);
//            ImageOperation.deleteFile(shareImgFile);
//            ImageOperation.deleteFile(qrcodeImgFile);
//            ImageOperation.deleteFile(baseImgFile);
//        }
//        String result = UploadFileClient.uploadFile(appid, multipartFile);
//        JSONObject json = JSONObject.parseObject(result);
//        if (StringUtils.isEmpty(json.getString("imgUrl"))) {
//            throw new ClientException("上传图片失败");
//        }
//        return json.getString("imgUrl");
        return null;
    }

}
