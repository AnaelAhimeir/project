package com.achva.entities;

import java.sql.Date;

public class PassivHirers {
    private Boolean active;
    private int pid;
    private Date startdate;
    private Date enddate;
    private Date LCare;
    private Date NCare;

    public Boolean getActive() {return active;}
    public void setActive(Boolean active){this.active=active;}

    public int getPid() {return pid;}
    public void setPid(int pid){this.pid=pid;}
    public Date getStartdate(){return startdate;}
    public void setStartdate(Date startdate){this.startdate=startdate;}

    public Date getEnddate(){return enddate;}
    public void setEnddate(Date enddate){this.enddate=enddate;}

    public Date getLCare(){return LCare;}
    public void setLCare(Date LCare){this.LCare=LCare;}

    public Date getNCare(){return NCare;}
    public void setNCare(Date NCare){this.NCare=NCare;}
}
