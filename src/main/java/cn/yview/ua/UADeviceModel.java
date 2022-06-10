package cn.yview.ua;

public class UADeviceModel {

    //手机系统
    private String mobileSys;

    //手机品牌
    private String mobileBrand;

    //手机型号
    private String mobileModel;

    //系统版本
    private String sysVersion;

    public String getMobileSys() {
        return mobileSys;
    }

    public void setMobileSys(String mobileSys) {
        this.mobileSys = mobileSys;
    }

    public String getMobileBrand() {
        return mobileBrand;
    }

    public void setMobileBrand(String mobileBrand) {
        this.mobileBrand = mobileBrand;
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    public UADeviceModel() {
        this.mobileBrand = "";
        this.mobileModel = "";
        this.mobileSys = "";
        this.sysVersion = "";
    }

    @Override
    public String toString() {
        return "UADeviceModel{" +
                "mobileSys='" + mobileSys + '\'' +
                ", mobileBrand='" + mobileBrand + '\'' +
                ", mobileModel='" + mobileModel + '\'' +
                ", sysVersion='" + sysVersion + '\'' +
                '}';
    }
}
