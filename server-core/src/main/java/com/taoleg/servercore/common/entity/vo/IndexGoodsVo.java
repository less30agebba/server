package com.taoleg.servercore.common.entity.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class IndexGoodsVo {

    private String title;
    private List<sub> subs;
    private List<leftGood> leftGoods;
    private Map<String, List<rightGood>> rightGoods;

    @Data
    public static class sub {
        private String name;
        private String key;
    }

    @Data
    public static class leftGood {
        private String link;
        private String imgUrl;
    }

    @Data
    public static class rightGood {
        private String link;
        private String imgUrl;
        private String title;
        private Integer price;
        private Integer oldPrice;
        private String discountType;
        private String discount;
        private String heat;
        private String reviewDesc;
        private String moreUrl;
        private String reviewAuthor;
        private boolean reviewStatus;
    }
}
