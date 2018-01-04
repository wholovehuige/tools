package com.roy.tools.moduls;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by roy on 2018/1/4.
 */
@Entity
public class EtlHis {
    @Id
    @GeneratedValue
    private String ID;
    private String JNDI;
    private String TYPE;
    private String TABLE_NAME;
    private int STATUS;
    private String PRI_KEY_COL;
    private String COUNT_COL;
    private String COUNT_COL_TYPE;
    private String LAST_VAL;
    private String CHAR_TYPE;
    private Date LASTTIME;
    private String DUNS;
    private String dunsName;
    private String COMX;
    private String JNDI2;
    private String JNDI_COUNT;
    private String JNDI2_COUNT;
    private String JNDI_LAST_VAL;
    private String dunsx;
    private String FETCH_VIEW;
    private String FETCH_COLS;
    private String TABLE_IN_SERVER;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getJNDI() {
        return JNDI;
    }

    public void setJNDI(String JNDI) {
        this.JNDI = JNDI;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public String getPRI_KEY_COL() {
        return PRI_KEY_COL;
    }

    public void setPRI_KEY_COL(String PRI_KEY_COL) {
        this.PRI_KEY_COL = PRI_KEY_COL;
    }

    public String getCOUNT_COL() {
        return COUNT_COL;
    }

    public void setCOUNT_COL(String COUNT_COL) {
        this.COUNT_COL = COUNT_COL;
    }

    public String getCOUNT_COL_TYPE() {
        return COUNT_COL_TYPE;
    }

    public void setCOUNT_COL_TYPE(String COUNT_COL_TYPE) {
        this.COUNT_COL_TYPE = COUNT_COL_TYPE;
    }

    public String getLAST_VAL() {
        return LAST_VAL;
    }

    public void setLAST_VAL(String LAST_VAL) {
        this.LAST_VAL = LAST_VAL;
    }

    public String getCHAR_TYPE() {
        return CHAR_TYPE;
    }

    public void setCHAR_TYPE(String CHAR_TYPE) {
        this.CHAR_TYPE = CHAR_TYPE;
    }

    public Date getLASTTIME() {
        return LASTTIME;
    }

    public void setLASTTIME(Date LASTTIME) {
        this.LASTTIME = LASTTIME;
    }

    public String getDUNS() {
        return DUNS;
    }

    public void setDUNS(String DUNS) {
        this.DUNS = DUNS;
    }

    public String getDunsName() {
        return dunsName;
    }

    public void setDunsName(String dunsName) {
        this.dunsName = dunsName;
    }

    public String getCOMX() {
        return COMX;
    }

    public void setCOMX(String COMX) {
        this.COMX = COMX;
    }

    public String getJNDI2() {
        return JNDI2;
    }

    public void setJNDI2(String JNDI2) {
        this.JNDI2 = JNDI2;
    }

    public String getJNDI_COUNT() {
        return JNDI_COUNT;
    }

    public void setJNDI_COUNT(String JNDI_COUNT) {
        this.JNDI_COUNT = JNDI_COUNT;
    }

    public String getJNDI2_COUNT() {
        return JNDI2_COUNT;
    }

    public void setJNDI2_COUNT(String JNDI2_COUNT) {
        this.JNDI2_COUNT = JNDI2_COUNT;
    }

    public String getJNDI_LAST_VAL() {
        return JNDI_LAST_VAL;
    }

    public void setJNDI_LAST_VAL(String JNDI_LAST_VAL) {
        this.JNDI_LAST_VAL = JNDI_LAST_VAL;
    }

    public String getDunsx() {
        return dunsx;
    }

    public void setDunsx(String dunsx) {
        this.dunsx = dunsx;
    }

    public String getFETCH_VIEW() {
        return FETCH_VIEW;
    }

    public void setFETCH_VIEW(String FETCH_VIEW) {
        this.FETCH_VIEW = FETCH_VIEW;
    }

    public String getFETCH_COLS() {
        return FETCH_COLS;
    }

    public void setFETCH_COLS(String FETCH_COLS) {
        this.FETCH_COLS = FETCH_COLS;
    }

    public String getTABLE_IN_SERVER() {
        return TABLE_IN_SERVER;
    }

    public void setTABLE_IN_SERVER(String TABLE_IN_SERVER) {
        this.TABLE_IN_SERVER = TABLE_IN_SERVER;
    }
}

