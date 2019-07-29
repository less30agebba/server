package com.taoleg.serverdao.dao;

import com.taoleg.servercore.common.base.page.Page;
import com.taoleg.servercore.common.base.page.Pager;
import com.taoleg.servercore.common.entity.AgentImgEntity;

import java.util.List;

/**
 * @author chenqing
 * @date 2017/4/28
 */
public interface AgentDao {

    Page<AgentImgEntity> queryImgs(Pager pager, Integer length, String state, String tags);

}
