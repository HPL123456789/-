package com.gec.pojo;

import org.apache.ibatis.annotations.Lang;

public class ResultVo {
    private String[] dates;
    private Object[] data;

    public String[] getDates() {
        return dates;
    }

    public void setDates(String[] dates) {
        this.dates = dates;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }
}
