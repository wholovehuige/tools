package com.roy.tools.rest;

import com.roy.tools.services.impl.DbConnection;
import com.roy.tools.services.impl.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roy on 2018/1/4.
 */
@RestController
public class RestApi {
    @Autowired
    private DbConnection connection;

    @Autowired
    private Search search;

    @GetMapping(path = "/testConn")
    public String testConn() {
        String duns = "610329";
        String jndi = search.getJndi(duns);
        connection.testOracle(jndi,duns);
        return "1";
    }

    @GetMapping(path = "/changStatusToTwo")
    public String inString() {
        search.updateColAndType("610329");

        return "1";
    }


    @GetMapping(path = "/getjndi")
    public String getJndi() {

        return search.getJndi("610329");
    }
}
