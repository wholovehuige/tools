package com.roy.tools.poi.impl.consumer;


import com.roy.tools.poi.IExcelConsumer;
import com.roy.tools.poi.model.RecordPoi;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by roy on 2017/11/30.
 */
public class RecordComsumer implements IExcelConsumer {
    @Override
    public void consume(Sheet sheet) {
        List<RecordPoi> recordPois = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            if (i % 500 == 0) {
                //在这里 处理 提取出来的数据
//                recordPoiMapper.batchInsert(recordPois);
                System.out.println("Excel解析出 size:" + recordPois.size() + "recordPois:" + recordPois.toString());
                recordPois = null;
                recordPois = new ArrayList<>();
            }
            Row row = sheet.getRow(i);
            RecordPoi recordPoi = new RecordPoi();

            recordPoi.setRecordId(Integer.parseInt(row.getCell(0).getStringCellValue()));
            recordPoi.setCname(row.getCell(1).getStringCellValue());
            recordPoi.setCbank(row.getCell(2).getStringCellValue());
            recordPoi.setCnum(row.getCell(3).getStringCellValue());
            recordPoi.setMoney(Integer.parseInt(row.getCell(4).getStringCellValue()));
            recordPoi.setType(Integer.parseInt(row.getCell(5).getStringCellValue()));
            recordPoi.setComment(row.getCell(6).getStringCellValue());

            recordPois.add(recordPoi);
        }
        if (recordPois != null && recordPois.size() > 0) {
            //在这里 处理 500除余,提取出来的数据
//            recordPoiMapper.batchInsert(recordPois);
            System.out.println("Excel解析出 size:" + recordPois.size() + "recordPois:" + recordPois.toString());
            recordPois = null;
        }
    }
}
