package com.gec.pojo;

/**
 * Description:
 * Author: HPL
 * Date 2022/12/25
 */
public class ResultFlowVo {
    private String[] dates;
    private String[] uvs;
    private String[] new_uvs;
    public String[] getDates() {
        return dates;
    }

    public void setDates(String[] dates) {
        this.dates = dates;
    }

    public Object[] getUvs() {
        return uvs;
    }

    public void setUvs(String[] uvs) {
        this.uvs = uvs;
    }

    public Object[] getNew_uvs() {
        return new_uvs;
    }

    public void setNew_uvs(String[] new_uvs) {
        this.new_uvs = new_uvs;
    }
}
