package com.gec.pojo;

public class Pvs {
    private String daystr;

    private Long pvs;

    public String getDaystr() {
        return daystr;
    }

    public void setDaystr(String daystr) {
        this.daystr = daystr == null ? null : daystr.trim();
    }

    public Long getPvs() {
        return pvs;
    }

    public void setPvs(Long pvs) {
        this.pvs = pvs;
    }
}