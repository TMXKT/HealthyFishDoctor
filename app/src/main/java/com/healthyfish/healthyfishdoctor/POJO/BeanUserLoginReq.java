package com.healthyfish.healthyfishdoctor.POJO;

public class BeanUserLoginReq extends BeanBaseReq {
    private String  mobileNo;
    private String  pwdSHA256;
    //...

    public BeanUserLoginReq(){super(BeanUserLoginReq.class.getSimpleName());}

    public String getMobileNo() {return mobileNo;}
    public void setMobileNo(String mobileNo) {this.mobileNo = mobileNo;}
    public String getPwdSHA256() {return pwdSHA256;}
    public void setPwdSHA256(String pwdSHA256) {this.pwdSHA256 = pwdSHA256;}
}
