package com.achva.entities;

public class ActiveHirers {
    private Boolean active;
    private int pid;
    private String hirerFN;
    private String hirerLN;
    private int hirerID;
    private String hirerAdress;
    private double AssetPrice;

    public Boolean getActive() {return active;}
    public void setActive(Boolean active){this.active=active;}

    public int getPid() {return pid;}
    public void setPid(int pid){this.pid=pid;}
    public String getHirerFN() {return hirerFN;}
    public void setHirerFN(String hirerFN){this.hirerFN=hirerFN;}
    public String getHirerLN() {return hirerLN;}
    public void setHirerLN(String hirerLN){this.hirerLN=hirerLN;}
    public int getHirerID() {return hirerID;}
    public void setHirerID(int hirerID){this.hirerID=hirerID;}
    public String getHirerAdress() {return hirerAdress;}
    public void setHirerAdress(String hirerAdress){this.hirerAdress=hirerAdress;}
    public double getAssetPrice() {return AssetPrice;}
    public void setAssetPrice(double AssetPrice){this.AssetPrice=AssetPrice;}

}



