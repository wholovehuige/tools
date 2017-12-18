package com.roy.tools.rest;

import com.roy.tools.services.MailSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roy on 2017/11/30.
 */
@RestController
@RequestMapping(value = "/mail")
public class rest {

    @Autowired
    private MailSend mailSend;

    @GetMapping(value = "/get")
    public String importExcel() {
        try {
            String fromUser = "soabstract@163.com";
            String toUser = "zhangchenghui@cecdat.com";
            mailSend.sendMail(fromUser,toUser);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return ";";
    }


}
