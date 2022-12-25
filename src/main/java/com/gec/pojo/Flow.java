package com.gec.pojo;

/**
 * Description:
 * Author: HPL
 * Date 2022/12/25
 */
public class Flow {
    private String daystr;

    private String uvs;

    private String new_uvs;

    public String getDaystr() {
        return daystr;
    }

    public void setDaystr(String daystr) {
        this.daystr = daystr == null ? null : daystr.trim();
    }

    public String getUvs() {
        return uvs;
    }

    public void setUvs(String uvs) {
            this.uvs = uvs;
        }

    public String getNew_uvs() {
        return new_uvs;
    }

    public void setNew_uvs(String new_uvs) {
        this.new_uvs = new_uvs;
    }
}
