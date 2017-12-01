package com.roy.tools;

import com.roy.tools.poi.ExcelUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    private ExcelUtil excelUtil;

    @Test
    public void sendTest() {
        try {
            String filePath = "C:/Users/soabs/Desktop/data.xlsx";
            excelUtil.excelImport(filePath);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
