package com.taoleg.serverweb.consumer.api;

import com.taoleg.servercore.common.base.ResponseBean;
import com.taoleg.servercore.common.entity.vo.IndexGoodsVo;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResponseIndexGoods extends ResponseBean<ResponseIndexGoods.ResponseData> {

    @Data
    public static class ResponseData {

        private List<String> topTitleList;
        private List<List<IndexGoodsVo.sub>> subsList;
        private List<List<IndexGoodsVo.leftGood>> leftGoodsList;
        private List<Map<String, List<IndexGoodsVo.rightGood>>> rightGoodsList;
    }

}
