package com.roy.tools.moduls;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by roy on 2018/1/4.
 */
@Entity
public class EtlJndi {
    @Id
    @GeneratedValue
    private String JNDI;
    private String TYPE;
    private int STATUS;
    private String VAL;
    private String COMX;
    private String DUNS;
    private String DUNSNAME;

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

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public String getVAL() {
        return VAL;
    }

    public void setVAL(String VAL) {
        this.VAL = VAL;
    }

    public String getCOMX() {
        return COMX;
    }

    public void setCOMX(String COMX) {
        this.COMX = COMX;
    }

    public String getDUNS() {
        return DUNS;
    }

    public void setDUNS(String DUNS) {
        this.DUNS = DUNS;
    }

    public String getDUNSNAME() {
        return DUNSNAME;
    }

    public void setDUNSNAME(String DUNSNAME) {
        this.DUNSNAME = DUNSNAME;
    }
}
