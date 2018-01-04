package com.roy.tools.moduls;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by roy on 2017/8/14.
 */
@Entity
public class Commodity {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String tableName;
    private String countCol;
    private String countColType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCountCol() {
        return countCol;
    }

    public void setCountCol(String countCol) {
        this.countCol = countCol;
    }

    public String getCountColType() {
        return countColType;
    }

    public void setCountColType(String countColType) {
        this.countColType = countColType;
    }
}
