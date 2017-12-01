package com.roy.tools.poi.impl.consumer;


import com.roy.tools.poi.IExcelConsumer;
import com.roy.tools.poi.model.RecordPoi;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by roy on 2017/11/30.
 */
@Service
public class RecordComsumer implements IExcelConsumer {
    @Override
    public void consume(Sheet sheet) {
        System.out.println("当前sheet页总行数:"+sheet.getLastRowNum());
        System.out.println("当前sheet页总列数:"+sheet.getPhysicalNumberOfRows());
        List<RecordPoi> recordPois = new ArrayList<>();

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            if (i % 500 == 0) {
                //在这里 处理 提取出来的数据
//                recordPoiMapper.batchInsert(recordPois);
                System.out.println("Excel解析出 size:" + recordPois.size() + "recordPois:" + recordPois.toString());
                recordPois = null;
                recordPois = new ArrayList<>();
            }
            Row row = sheet.getRow(i);
            if(row != null) {
                int columnNum = row.getPhysicalNumberOfCells();
                System.out.println("总列数:" + columnNum);
                for (int j = 0; j < columnNum; j++) {
                    System.out.println("第" + (i + 1) + "行第" + (j + 1) + "列是：" + row.getCell(j));
                }
            }

//            int aaa = row.getCell(i).getCellComment().getColumn();
            System.out.println("==================");
//            RecordPoi recordPoi = new RecordPoi();
//
//            recordPoi.setRecordId(Integer.parseInt(row.getCell(0).getStringCellValue()));
//            recordPoi.setCname(row.getCell(1).getStringCellValue());
//            recordPoi.setCbank(row.getCell(2).getStringCellValue());
//            recordPoi.setCnum(row.getCell(3).getStringCellValue());
//            recordPoi.setMoney(Integer.parseInt(row.getCell(4).getStringCellValue()));
//            recordPoi.setType(Integer.parseInt(row.getCell(5).getStringCellValue()));
//            recordPoi.setComment(row.getCell(6).getStringCellValue());
//
//            recordPois.add(recordPoi);
        }
        if (recordPois != null && recordPois.size() > 0) {
            //在这里 处理 500除余,提取出来的数据
//            recordPoiMapper.batchInsert(recordPois);
            System.out.println("Excel解析出 size:" + recordPois.size() + "recordPois:" + recordPois.toString());
            recordPois = null;
        }
    }
}
