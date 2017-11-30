package com.roy.tools.poi.api;

import com.roy.tools.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roy on 2017/11/30.
 */
@RestController
@RequestMapping(value = "/poi")
public class rest {


    @Autowired
    private ExcelUtil excelUtil;

    @RequestMapping(value = "/get")
    public String importExcel() {
        try {
            String filePath = "C:/Users/soabs/Desktop/data.xlsx";
            excelUtil.excelImport(filePath);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return ";";
    }


}
