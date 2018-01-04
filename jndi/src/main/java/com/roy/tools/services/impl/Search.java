package com.roy.tools.services.impl;

import com.roy.tools.moduls.Commodity;
import com.roy.tools.moduls.EtlJndi;
import com.roy.tools.services.CommodityRepository;
import com.roy.tools.services.EtlHisRepository;
import com.roy.tools.services.EtlJndiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by roy on 2017/12/22.
 */
@Service
public class Search {

    @Autowired
    private EtlJndiRepository etlJndiRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Commodity> getEhrModul() {
        String sql = "select * from commodity where TYPE  = 'EHR'";
        RowMapper<Commodity> rowMapper = new BeanPropertyRowMapper<>(Commodity.class);
        return jdbcTemplate.query(sql,rowMapper);
    }

    public void updateColAndType(String duns) {
        List<Commodity> commodities = getEhrModul();
        for(Commodity commodity : commodities){
            String sql = "update etl_his set STATUS = '1' , COUNT_COL = '"+commodity.getCountCol()+"' ,COUNT_COL_TYPE = '"+commodity.getCountColType()+"' where DUNS = '"+duns+"' and table_name = '"+commodity.getTableName()+"'";
            System.out.println(sql);
            jdbcTemplate.update(sql);
        }
    }

    public int updateStatusToTwo(String duns) {
        String sql = "update etl_his set status = '2' where duns = '"+duns+"'";
        System.out.println(sql);
        int res = jdbcTemplate.update(sql);
        return res;
    }

    public String getJndi(String duns) {
        String sql  = "select * from etl_jndi where duns = '"+duns+"'";
        RowMapper<EtlJndi> rowMapper = new BeanPropertyRowMapper<>(EtlJndi.class);
        List<EtlJndi> etlJndi = jdbcTemplate.query(sql,rowMapper);
        System.out.println(etlJndi.get(0).getVAL());
        return etlJndi.get(0).getVAL();
    }

}
