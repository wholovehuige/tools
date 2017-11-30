package com.roy.tools.poi;

import org.springframework.stereotype.Service;

/**
 * Created by roy on 2017/11/30.
 */
@Service
public class TestService {

    public void print() {
        for(int i =0 ; i<10 ;i++)
            System.out.println("test" + i);
    }
}
