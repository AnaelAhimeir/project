package com.achva.entities;

import java.sql.Date;

public class Property {
    private int pid;
    private String owner;
    private String address;
    private int price;
    private String district;
    private Boolean path;
    private Date registrdate;
    private Date startdate;
    private Date enddate;


    public int getPid() {return pid;}

    public void setPid(int pid) {this.pid = pid;}

    public String getOwner() {return owner;}

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDistrict(){return district;}
    public void setDistrict(String district){this.district=district;}
    public Boolean getPath(){return path;}
    public void setPath(Boolean path){this.path=path;}
    public Date getregistrdate(){return registrdate;}
    public void setRegistrdate(Date registrdate){this.registrdate=registrdate;}
    public Date getStartdate(){return startdate;}
    public void setStartdate(Date startdate){this.startdate=startdate;}

    public Date getEnddate(){return enddate;}
    public void setEnddate(Date enddate){this.enddate=enddate;}


}
