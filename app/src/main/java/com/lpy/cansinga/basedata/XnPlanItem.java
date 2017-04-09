package com.lpy.cansinga.basedata;

import java.io.Serializable;

/**
 * Created by liupengyuan on 2017/4/7.
 * 吸能方案item
 */

public class XnPlanItem implements Serializable {
    private String huanchongqi;//缓冲器
    private int fengzhi;//峰值力
    private int xingcheng;//行程

    private String ykg_fpq;//压溃管-防爬器
    private int ykl_ykg;//压溃力-压溃管数值
    private int ykl_fpq;//压溃力-防爬器数值
    private int ykl_zxnq;//压溃力-主吸能器数值
    private int xc_ykg;//行程-压溃管
    private int xc_fpa;//行程-防爬器
    private int xc_zxnq;//行程-主吸能器

    public String getHuanchongqi() {
        return huanchongqi;
    }

    public void setHuanchongqi(String huanchongqi) {
        this.huanchongqi = huanchongqi;
    }

    public int getFengzhi() {
        return fengzhi;
    }

    public void setFengzhi(int fengzhi) {
        this.fengzhi = fengzhi;
    }

    public int getXingcheng() {
        return xingcheng;
    }

    public void setXingcheng(int xingcheng) {
        this.xingcheng = xingcheng;
    }

    public String getYkg_fpq() {
        return ykg_fpq;
    }

    public void setYkg_fpq(String ykg_fpq) {
        this.ykg_fpq = ykg_fpq;
    }

    public int getYkl_ykg() {
        return ykl_ykg;
    }

    public void setYkl_ykg(int ykl_ykg) {
        this.ykl_ykg = ykl_ykg;
    }

    public int getYkl_fpq() {
        return ykl_fpq;
    }

    public void setYkl_fpq(int ykl_fpq) {
        this.ykl_fpq = ykl_fpq;
    }

    public int getYkl_zxnq() {
        return ykl_zxnq;
    }

    public void setYkl_zxnq(int ykl_zxnq) {
        this.ykl_zxnq = ykl_zxnq;
    }

    public int getXc_ykg() {
        return xc_ykg;
    }

    public void setXc_ykg(int xc_ykg) {
        this.xc_ykg = xc_ykg;
    }

    public int getXc_fpa() {
        return xc_fpa;
    }

    public void setXc_fpa(int xc_fpa) {
        this.xc_fpa = xc_fpa;
    }

    public int getXc_zxnq() {
        return xc_zxnq;
    }

    public void setXc_zxnq(int xc_zxnq) {
        this.xc_zxnq = xc_zxnq;
    }

    @Override
    public String toString() {
        return "XnPlanItem{" +
                "huanchongqi='" + huanchongqi + '\'' +
                ", fengzhi=" + fengzhi +
                ", xingcheng=" + xingcheng +
                ", ykg_fpq='" + ykg_fpq + '\'' +
                ", ykl_ykg=" + ykl_ykg +
                ", ykl_fpq=" + ykl_fpq +
                ", ykl_zxnq=" + ykl_zxnq +
                ", xc_ykg=" + xc_ykg +
                ", xc_fpa=" + xc_fpa +
                ", xc_zxnq=" + xc_zxnq +
                '}';
    }
}
