package com.roy.tools.poi;

import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;
/**
 * Created by roy on 2017/11/30.
 */
@Service
public interface IExcelConsumer {
    /**
     * 读取excel
     *
     * @param sheet
     */
    void consume(Sheet sheet);
}
