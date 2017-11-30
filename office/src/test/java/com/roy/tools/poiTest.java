package com.roy.tools;

import com.roy.tools.poi.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by roy on 2017/11/30.
 */
@RunWith(SpringRunner.class)
@SpringBootApplication
@WebAppConfiguration
public class poiTest {

    @Autowired
    TestService testService;

    @Test
    public void sendTest() {
        testService.print();
    }

}
