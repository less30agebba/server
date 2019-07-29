package com.taoleg.serverdao.dao.impl;

import com.taoleg.servercore.common.base.page.Page;
import com.taoleg.servercore.common.base.page.Pager;
import com.taoleg.servercore.common.entity.AgentImgEntity;
import com.taoleg.servercore.common.entity.vo.AgentInfoVo;
import com.taoleg.serverdao.dao.AgentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqing
 * @date 2017/5/26
 */
@Repository
public class AgentDaoImpl extends BaseDaoImpl<AgentInfoVo> implements AgentDao {


    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public Page<AgentImgEntity> queryImgs(Pager pager, Integer length, String state, String tags){

        StringBuilder query = new StringBuilder();
        StringBuilder totalSql = new StringBuilder();
        List totalParams = new ArrayList();
        List params = new ArrayList();

        RowMapper<AgentImgEntity> rowMapper = new BeanPropertyRowMapper<>(AgentImgEntity.class);
        List<AgentImgEntity> entities = jdbcTemplate.query(query.toString(), params.toArray(), rowMapper);
        int total = jdbcTemplate.queryForObject(totalSql.toString(),totalParams.toArray(),Integer.class);

        Page<AgentImgEntity> page = new Page<>();
        page.setPageDatas(entities);
        page.setPageIndex(pager.getCurrent());
        page.setTotalSize(total);
        page.setPageSize(pager.getSize());
        return page;

    }





}
