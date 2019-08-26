package com.taoleg.serverservice.service;

import com.taoleg.servercore.common.entity.vo.IndexGoodsVo;

import java.util.List;

public interface IndexService {
    List<IndexGoodsVo> getGoods();
}
