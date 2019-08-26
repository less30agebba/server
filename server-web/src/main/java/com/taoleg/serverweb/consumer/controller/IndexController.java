package com.taoleg.serverweb.consumer.controller;

import com.taoleg.servercore.common.base.BaseController;
import com.taoleg.servercore.common.base.ResponseCode;
import com.taoleg.servercore.common.entity.vo.IndexGoodsVo;
import com.taoleg.serverservice.service.IndexService;
import com.taoleg.serverweb.consumer.api.RequestIndexGoods;
import com.taoleg.serverweb.consumer.api.ResponseIndexGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController("ConsumerIndexController")
@RequestMapping("/consumer/index")
public class IndexController extends BaseController {

    @Autowired
    IndexService indexService;

    @RequestMapping("/getGoods")
    public ResponseIndexGoods getGoods(@RequestBody(required=false) RequestIndexGoods request) {
        ResponseIndexGoods response = new ResponseIndexGoods();
        List<IndexGoodsVo> indexGoods = indexService.getGoods();
        ResponseIndexGoods.ResponseData data = new ResponseIndexGoods.ResponseData();
        List<String> topTitleList = new ArrayList<>();
        List<List<IndexGoodsVo.sub>> subs = new ArrayList<>();
        List<List<IndexGoodsVo.leftGood>> leftGoods = new ArrayList<>();
        List<Map<String, List<IndexGoodsVo.rightGood>>> rightGoods = new ArrayList<>();

        indexGoods.forEach(indexGood -> {
            topTitleList.add(indexGood.getTitle());
            subs.add(indexGood.getSubs());
            leftGoods.add(indexGood.getLeftGoods());
            rightGoods.add(indexGood.getRightGoods());
        });
        data.setTopTitleList(topTitleList);
        data.setSubsList(subs);
        data.setLeftGoodsList(leftGoods);
        data.setRightGoodsList(rightGoods);

        response.setData(data);
        response.setSubCode(ResponseCode.SECCESS.getMsg());
        return response;
    }

}
