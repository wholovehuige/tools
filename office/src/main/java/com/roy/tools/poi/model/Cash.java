package com.roy.tools.poi.model;

/**
 * Created by roy on 2017/11/30.
 */
public class Cash {
    private Integer id;
    private String name;
    private String bank;
    private String cardNo;
    private String payCash;
    private String type;
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPayCash() {
        return payCash;
    }

    public void setPayCash(String payCash) {
        this.payCash = payCash;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
