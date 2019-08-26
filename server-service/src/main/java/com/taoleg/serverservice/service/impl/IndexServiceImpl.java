package com.taoleg.serverservice.service.impl;

import com.taoleg.servercore.common.entity.vo.IndexGoodsVo;
import com.taoleg.serverservice.service.IndexService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {

    @Override
    public List<IndexGoodsVo> getGoods() {
        List<IndexGoodsVo> indexGoods = new ArrayList<>();

        //set appliance
        IndexGoodsVo appliance = new IndexGoodsVo();
        //set title
        appliance.setTitle("家电");
        //set subs
        List<IndexGoodsVo.sub> applianceSubs = new ArrayList<>();
        IndexGoodsVo.sub applianceHotSub = new IndexGoodsVo.sub();
        applianceHotSub.setKey("hotGoods");
        applianceHotSub.setName("热门");
        applianceSubs.add(applianceHotSub);
        IndexGoodsVo.sub applianceTVSub = new IndexGoodsVo.sub();
        applianceTVSub.setKey("tv");
        applianceTVSub.setName("电视影音");
        applianceSubs.add(applianceTVSub);
        appliance.setSubs(applianceSubs);
        //set left goods
        List<IndexGoodsVo.leftGood> applianceLeftGoods = new ArrayList<>();
        IndexGoodsVo.leftGood applianceLeftGood = new IndexGoodsVo.leftGood();
        applianceLeftGood.setLink("http://www.mi.com/roomrobot/");
        applianceLeftGood.setImgUrl("./static/imgs/xmjhq2.jpg");
        applianceLeftGoods.add(applianceLeftGood);
        appliance.setLeftGoods(applianceLeftGoods);
        //set right goods
        Map<String, List<IndexGoodsVo.rightGood>> rightGoods = new HashMap<>();
        List<List<IndexGoodsVo.rightGood>> applianceRightGood = new ArrayList<>();
        List<IndexGoodsVo.rightGood> applianceRightHotGood = new ArrayList<>();
        IndexGoodsVo.rightGood rightGood1 = new IndexGoodsVo.rightGood();
        rightGood1.setLink("https://item.mi.com/1170900022.html");
        rightGood1.setImgUrl("./static/imgs/xm4a.png");
        rightGood1.setTitle("小米电视4A 49英寸");
        rightGood1.setPrice(2299);
        rightGood1.setOldPrice(2599);
        rightGood1.setDiscountType("discount");
        rightGood1.setDiscount("享九折");
        rightGood1.setHeat("7.1-7.31 直降300");
        rightGood1.setReviewDesc("外形大方，超大气，安装师傅细心，打完眼还给打扫干净。...");
        rightGood1.setReviewAuthor("贤妻良母");
        rightGood1.setReviewStatus(true);
        applianceRightHotGood.add(rightGood1);
        
        IndexGoodsVo.rightGood rightGood2 = new IndexGoodsVo.rightGood();
        rightGood2.setLink("https://item.mi.com/buy/mitv4a-43");
        rightGood2.setImgUrl("./static/imgs/xmds4a43.png");
        rightGood2.setTitle("小米电视4A 43英寸");
        rightGood2.setPrice(2099);
        rightGood2.setHeat("2GB+8GB 真四核64位高性能处理器");
        rightGood2.setReviewDesc("外形大方，超大气，安装师傅细心，打完眼还给打扫干净。...");
        rightGood2.setReviewAuthor("贤妻良母");
        rightGood2.setReviewStatus(false);
        applianceRightHotGood.add(rightGood2);

        IndexGoodsVo.rightGood rightGood3 = new IndexGoodsVo.rightGood();
        rightGood3.setLink("https://item.mi.com/1170900022.html");
        rightGood3.setImgUrl("./static/imgs/xmbjb13.3.jpg");
        rightGood3.setTitle("小米笔记本Air 13.3英寸");
        rightGood3.setPrice(4999);
        rightGood3.setHeat("独立显卡，全金属机身，超长续航");
        rightGood3.setReviewDesc("是买给老婆的生日礼物！我们一家在我的带领下差不多都是...");
        rightGood3.setReviewAuthor("纷飞泪");
        rightGood3.setReviewStatus(true);
        applianceRightHotGood.add(rightGood3);

        IndexGoodsVo.rightGood rightGood4 = new IndexGoodsVo.rightGood();
        rightGood4.setLink("https://item.mi.com/1170900022.html");
        rightGood4.setImgUrl("./static/imgs/xmbjb12.5.jpg");
        rightGood4.setTitle("小米笔记本Air 12.5英寸");
        rightGood4.setPrice(3599);
        rightGood4.setHeat("集成显卡，全金属机身，超长续航");
        rightGood4.setReviewDesc("忠实米粉，买了小米手机，配了米粉卡，买了小米电视，又...");
        rightGood4.setReviewAuthor("纷飞泪");
        rightGood4.setReviewStatus(true);
        applianceRightHotGood.add(rightGood4);

        IndexGoodsVo.rightGood rightGood5 = new IndexGoodsVo.rightGood();
        rightGood5.setLink("https://www.mi.com/electric-toothbrush/");
        rightGood5.setImgUrl("./static/imgs/ddys.jpg");
        rightGood5.setTitle("米家声波电动牙刷");
        rightGood5.setPrice(199);
        rightGood5.setDiscountType("new");
        rightGood5.setDiscount("新品");
        rightGood5.setHeat("磁悬浮声波马达，定制多种刷牙模式");
        rightGood5.setReviewDesc("外形大方，超大气，安装师傅细心，打完眼还给打扫干净。...");
        rightGood5.setReviewAuthor("贤妻良母");
        rightGood5.setReviewStatus(false);
        applianceRightHotGood.add(rightGood5);

        IndexGoodsVo.rightGood rightGood6 = new IndexGoodsVo.rightGood();
        rightGood6.setLink("https://www.mi.com/dianfanbao/");
        rightGood6.setImgUrl("./static/imgs/mjdfb.jpg");
        rightGood6.setTitle("米家压力IH电饭煲");
        rightGood6.setPrice(999);
        rightGood6.setHeat("智能烹饪，灰铸铁粉体涂层内胆");
        rightGood6.setReviewDesc("中国人终于可以不要到国外去买电饭煲了！坐在家里点点手...");
        rightGood6.setReviewAuthor("姚士祥");
        rightGood6.setReviewStatus(true);
        applianceRightHotGood.add(rightGood6);

        IndexGoodsVo.rightGood rightGood7 = new IndexGoodsVo.rightGood();
        rightGood7.setLink("https://www.mi.com/yeelight-ceilinglamp/");
        rightGood7.setImgUrl("./static/imgs/mjled.png");
        rightGood7.setTitle("Yeelight LED 吸顶灯");
        rightGood7.setPrice(379);
        rightGood7.setHeat("5分钟快装，月光夜灯，IP60 级防尘");
        rightGood7.setReviewDesc("可以改变色温，光暗，有一键夜灯，功能强大。本来不懂磁...");
        rightGood7.setReviewAuthor("冼伟强");
        rightGood7.setReviewStatus(true);
        applianceRightHotGood.add(rightGood7);

        IndexGoodsVo.rightGood rightGood8 = new IndexGoodsVo.rightGood();
        rightGood8.setLink("https://www.mi.com/roomrobot/");
        rightGood8.setImgUrl("./static/imgs/mjsd.jpg");
        rightGood8.setTitle("米家扫地机器人");
        rightGood8.setPrice(1699);
        rightGood8.setHeat("热门");
        rightGood8.setReviewDesc("");
        rightGood8.setMoreUrl("https://www.mi.com/buytv/");
        rightGood8.setReviewAuthor("冼伟强");
        rightGood8.setReviewStatus(false);
        applianceRightHotGood.add(rightGood8);
        applianceRightGood.add(applianceRightHotGood);

        List<IndexGoodsVo.rightGood> applianceRightTVGood = new ArrayList<>();
        IndexGoodsVo.rightGood rightTVGood1 = new IndexGoodsVo.rightGood();
        rightTVGood1.setLink("http://www.mi.com/mitv3s/55/");
        rightTVGood1.setImgUrl("./static/imgs/xmds3s-55.jpg");
        rightTVGood1.setTitle("小米电视3s 55英寸");
        rightTVGood1.setPrice(3599);
        rightTVGood1.setOldPrice(3999);
        rightTVGood1.setDiscountType("discount");
        rightTVGood1.setDiscount("享九折");
        rightTVGood1.setHeat("7月11日-7月14日立减400元");
        rightTVGood1.setReviewDesc("什么都有了就差客服妹子来暖床了，妹子你什么时间来啊");
        rightTVGood1.setReviewAuthor("小红哥哥");
        rightTVGood1.setReviewStatus(true);
        applianceRightTVGood.add(rightTVGood1);

        IndexGoodsVo.rightGood rightTVGood2 = new IndexGoodsVo.rightGood();
        rightTVGood2.setLink("https://item.mi.com/1170900022.html");
        rightTVGood2.setImgUrl("./static/imgs/xmds4a-65.png");
        rightTVGood2.setTitle("电视4A 65英寸标准版");
        rightTVGood2.setPrice(4699);
        rightTVGood2.setOldPrice(5699);
        rightTVGood2.setDiscountType("discount");
        rightTVGood2.setDiscount("享九折");
        rightTVGood2.setHeat("7月11日-7月14日立减1000元");
        rightTVGood2.setReviewAuthor("超大的，就是厚了一点。运费安装费有点贵。");
        rightTVGood2.setReviewAuthor("假の太逼真");
        rightTVGood2.setReviewStatus(true);
        applianceRightTVGood.add(rightTVGood2);

        IndexGoodsVo.rightGood rightTVGood3 = new IndexGoodsVo.rightGood();
        rightTVGood3.setLink("https://item.mi.com/1170900022.html");
        rightTVGood3.setImgUrl("./static/imgs/xmds4a-49.png");
        rightTVGood3.setTitle("电视4A 49英寸 人工智能语音版");
        rightTVGood3.setPrice(2899);
        rightTVGood3.setHeat("7月12日-7月14日立减400元");
        rightTVGood3.setReviewAuthor("外形大方，超大气，安装师傅细心，打完眼还给打扫干净。...");
        rightTVGood3.setReviewAuthor("贤妻良母");
        rightTVGood3.setReviewStatus(false);
        applianceRightTVGood.add(rightTVGood3);

        IndexGoodsVo.rightGood rightTVGood4 = new IndexGoodsVo.rightGood();
        rightTVGood4.setLink("https://item.mi.com/1170900022.html");
        rightTVGood4.setImgUrl("./static/imgs/xmds4a-55.png");
        rightTVGood4.setTitle("电视4A 55英寸 人工智能语音版");
        rightTVGood4.setPrice(3599);
        rightTVGood4.setHeat("7月12日-7月14日立减400元");
        rightTVGood4.setReviewAuthor("外形大方，超大气，安装师傅细心，打完眼还给打扫干净。...");
        rightTVGood4.setReviewAuthor("贤妻良母");
        rightTVGood4.setReviewStatus(false);
        applianceRightTVGood.add(rightTVGood4);

        IndexGoodsVo.rightGood rightTVGood5 = new IndexGoodsVo.rightGood();
        rightTVGood5.setLink("https://item.mi.com/1170900022.html");
        rightTVGood5.setImgUrl("./static/imgs/xmds4a-65.png");
        rightTVGood5.setTitle("电视4A 65英寸 人工智能语音版");
        rightTVGood5.setPrice(6199);
        rightTVGood5.setHeat("7月12日-7月14日立减1000元");
        rightTVGood5.setReviewAuthor("外形大方，超大气，安装师傅细心，打完眼还给打扫干净。...");
        rightTVGood5.setReviewAuthor("贤妻良母");
        rightTVGood5.setReviewStatus(false);
        applianceRightTVGood.add(rightTVGood5);

        IndexGoodsVo.rightGood rightTVGood6 = new IndexGoodsVo.rightGood();
        rightTVGood6.setLink("https://item.mi.com/1170900022.html");
        rightTVGood6.setImgUrl("./static/imgs/xmds4a-55.png");
        rightTVGood6.setTitle("电视4A 55英寸标准版");
        rightTVGood6.setPrice(3199);
        rightTVGood6.setHeat("7月12日-7月14日直降400元");
        rightTVGood6.setReviewAuthor("外形大方，超大气，安装师傅细心，打完眼还给打扫干净。...");
        rightTVGood6.setReviewAuthor("贤妻良母");
        rightTVGood6.setReviewStatus(false);
        applianceRightTVGood.add(rightTVGood6);

        IndexGoodsVo.rightGood rightTVGood7 = new IndexGoodsVo.rightGood();
        rightTVGood7.setLink("https://item.mi.com/1170900022.html");
        rightTVGood7.setImgUrl("./static/imgs/xmhz3s.jpg");
        rightTVGood7.setTitle("小米盒子3s");
        rightTVGood7.setPrice(299);
        rightTVGood7.setHeat("4K超高清机顶盒，64 位处理器");
        rightTVGood7.setReviewAuthor("小目标又实现一小步，大目标是两年内把客服MM都买到我...");
        rightTVGood7.setReviewAuthor("我本疯狂");
        rightTVGood7.setReviewStatus(true);
        applianceRightTVGood.add(rightTVGood7);

        IndexGoodsVo.rightGood rightTVGood8 = new IndexGoodsVo.rightGood();
        rightTVGood8.setLink("https://www.mi.com/roomrobot/");
        rightTVGood8.setImgUrl("./static/imgs/hz3.jpg");
        rightTVGood8.setTitle("盒子3 增强版");
        rightTVGood8.setPrice(399);
        rightTVGood8.setHeat("电视影音");
        rightTVGood8.setReviewAuthor("");
        rightTVGood8.setMoreUrl("https://www.mi.com/buytv/");
        rightTVGood8.setReviewAuthor("冼伟强");
        rightTVGood8.setReviewStatus(false);
        applianceRightTVGood.add(rightTVGood8);
        applianceRightGood.add(applianceRightTVGood);

        for (int i = 0; i < applianceSubs.size(); i++) {
            rightGoods.put(applianceSubs.get(i).getKey(), applianceRightGood.get(i));
        }
        appliance.setRightGoods(rightGoods);

        indexGoods.add(appliance);
        return indexGoods;
    }
}
