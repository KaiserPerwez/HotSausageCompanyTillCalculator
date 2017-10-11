package com.hotsausagecompany.app.hotsausagecompanytillcalculator.model;

/**
 * Created by Admin on 06-10-2017.
 */

public class SalesDataModel {
    private int status;
    private String  datecol, timecol, site,
            regular, regular_and_cheese,
            large, large_and_cheese,
            footlong, footlong_and_cheese,
            special, special_and_cheese,
            drink, extra_cheese, no_bun,
            half_regular, half_regular_and_cheese,
            half_large, half_large_and_cheese,
            half_footlong, half_footlong_and_cheese,
            half_special, half_special_and_cheese,
            half_drink,
            full_regular, full_regular_and_cheese,
            full_large, full_large_and_cheese,
            full_footlong, full_footlong_and_cheese,
            full_special, full_special_and_cheese,
            full_drink,
            staff_regular, staff_regular_and_cheese,
            staff_large, staff_large_and_cheese,
            staff_footlong, staff_footlong_and_cheese, staff_special, staff_special_and_cheese, staff_drink,
            regular_waste, large_waste, footlong_waste, special_waste, small_bun_waste, large_bun_waste,
            total;

    public SalesDataModel() {
    }

    public SalesDataModel(int status, String datecol, String timecol, String site, String regular, String regular_and_cheese, String large, String large_and_cheese, String footlong, String footlong_and_cheese, String special, String special_and_cheese, String drink, String extra_cheese, String no_bun, String half_regular, String half_regular_and_cheese, String half_large, String half_large_and_cheese, String half_footlong, String half_footlong_and_cheese, String half_special, String half_special_and_cheese, String half_drink, String full_regular, String full_regular_and_cheese, String full_large, String full_large_and_cheese, String full_footlong, String full_footlong_and_cheese, String full_special, String full_special_and_cheese, String full_drink, String staff_regular, String staff_regular_and_cheese, String staff_large, String staff_large_and_cheese, String staff_footlong, String staff_footlong_and_cheese, String staff_special, String staff_special_and_cheese, String staff_drink, String regular_waste, String large_waste, String footlong_waste, String special_waste, String small_bun_waste, String large_bun_waste, String total) {
        this.status = status;
        this.datecol = datecol;
        this.timecol = timecol;
        this.site = site;
        this.regular = (regular==null || regular.length()==0)?"0":regular;
        this.regular_and_cheese = (regular_and_cheese==null || regular_and_cheese.length()==0)?"0":regular_and_cheese;
        this.large = (large==null || large.length()==0)?"0":large;
        this.large_and_cheese = (large_and_cheese==null || large_and_cheese.length()==0)?"0":large_and_cheese;
        this.footlong = (footlong==null || footlong.length()==0)?"0":footlong;
        this.footlong_and_cheese = (footlong_and_cheese==null || footlong_and_cheese.length()==0)?"0":footlong_and_cheese;
        this.special = (special==null || special.length()==0)?"0":special;
        this.special_and_cheese = (special_and_cheese==null || special_and_cheese.length()==0)?"0":special_and_cheese;
        this.drink = (drink==null || drink.length()==0)?"0":drink;
        this.extra_cheese = (extra_cheese==null || extra_cheese.length()==0)?"0":extra_cheese;
        this.no_bun = (no_bun==null || no_bun.length()==0)?"0":no_bun;
        this.half_regular = (half_regular==null || half_regular.length()==0)?"0":half_regular;
        this.half_regular_and_cheese = (half_regular_and_cheese==null || half_regular_and_cheese.length()==0)?"0":half_regular_and_cheese;
        this.half_large = (half_large==null || half_large.length()==0)?"0":half_large;
        this.half_large_and_cheese = (half_large_and_cheese==null || half_large_and_cheese.length()==0)?"0":half_large_and_cheese;
        this.half_footlong = (half_footlong==null || half_footlong.length()==0)?"0":half_footlong;
        this.half_footlong_and_cheese = (half_footlong_and_cheese==null || half_footlong_and_cheese.length()==0)?"0":half_footlong_and_cheese;
        this.half_special = (half_special==null || half_special.length()==0)?"0":half_special;
        this.half_special_and_cheese = (half_special_and_cheese==null || half_special_and_cheese.length()==0)?"0":half_special_and_cheese;
        this.half_drink = (half_drink==null || half_drink.length()==0)?"0":half_drink;
        this.full_regular = (full_regular==null || full_regular.length()==0)?"0":full_regular;
        this.full_regular_and_cheese = (full_regular_and_cheese==null || full_regular_and_cheese.length()==0)?"0":full_regular_and_cheese;
        this.full_large = (full_large==null || full_large.length()==0)?"0":full_large;
        this.full_large_and_cheese = (full_large_and_cheese==null || full_large_and_cheese.length()==0)?"0":full_large_and_cheese;
        this.full_footlong = (full_footlong==null || full_footlong.length()==0)?"0":full_footlong;
        this.full_footlong_and_cheese = (full_footlong_and_cheese==null || full_footlong_and_cheese.length()==0)?"0":full_footlong_and_cheese;
        this.full_special = (full_special==null || full_special.length()==0)?"0":full_special;
        this.full_special_and_cheese = (full_special_and_cheese==null || full_special_and_cheese.length()==0)?"0":full_special_and_cheese;
        this.full_drink = (full_drink==null || full_drink.length()==0)?"0":full_drink;
        this.staff_regular = (staff_regular==null || staff_regular.length()==0)?"0":staff_regular;
        this.staff_regular_and_cheese = (staff_regular_and_cheese==null || staff_regular_and_cheese.length()==0)?"0":staff_regular_and_cheese;
        this.staff_large = (staff_large==null || staff_large.length()==0)?"0":staff_large;
        this.staff_large_and_cheese = (staff_large_and_cheese==null || staff_large_and_cheese.length()==0)?"0":staff_large_and_cheese;
        this.staff_footlong = (staff_footlong==null || staff_footlong.length()==0)?"0":staff_footlong;
        this.staff_footlong_and_cheese = (staff_footlong_and_cheese==null || staff_footlong_and_cheese.length()==0)?"0":staff_footlong_and_cheese;
        this.staff_special = (staff_special==null || staff_special.length()==0)?"0":staff_special;
        this.staff_special_and_cheese = (staff_special_and_cheese==null || staff_special_and_cheese.length()==0)?"0":staff_special_and_cheese;
        this.staff_drink =(staff_drink==null || staff_drink.length()==0)?"0": staff_drink;
        this.regular_waste = (regular_waste==null || regular_waste.length()==0)?"0":regular_waste;
        this.large_waste =(large_waste==null || large_waste.length()==0)?"0": large_waste;
        this.footlong_waste = (footlong_waste==null || footlong_waste.length()==0)?"0":footlong_waste;
        this.special_waste = (special_waste==null || special_waste.length()==0)?"0":special_waste;
        this.small_bun_waste = (small_bun_waste==null || small_bun_waste.length()==0)?"0":small_bun_waste;
        this.large_bun_waste = (large_bun_waste==null || large_bun_waste.length()==0)?"0":large_bun_waste;
        this.total = (total==null || total.length()==0)?"0":total;
    }

    public int getStatus() {
        return status;
    }

    public String getDatecol() {
        return datecol;
    }

    public String getTimecol() {
        return timecol;
    }

    public String getSite() {
        return site;
    }

    public String getRegular() {
        return regular;
    }

    public String getRegular_and_cheese() {
        return regular_and_cheese;
    }

    public String getLarge() {
        return large;
    }

    public String getLarge_and_cheese() {
        return large_and_cheese;
    }

    public String getFootlong() {
        return footlong;
    }

    public String getFootlong_and_cheese() {
        return footlong_and_cheese;
    }

    public String getSpecial() {
        return special;
    }

    public String getSpecial_and_cheese() {
        return special_and_cheese;
    }

    public String getDrink() {
        return drink;
    }

    public String getExtra_cheese() {
        return extra_cheese;
    }

    public String getNo_bun() {
        return no_bun;
    }

    public String getHalf_regular() {
        return half_regular;
    }

    public String getHalf_regular_and_cheese() {
        return half_regular_and_cheese;
    }

    public String getHalf_large() {
        return half_large;
    }

    public String getHalf_large_and_cheese() {
        return half_large_and_cheese;
    }

    public String getHalf_footlong() {
        return half_footlong;
    }

    public String getHalf_footlong_and_cheese() {
        return half_footlong_and_cheese;
    }

    public String getHalf_special() {
        return half_special;
    }

    public String getHalf_special_and_cheese() {
        return half_special_and_cheese;
    }

    public String getHalf_drink() {
        return half_drink;
    }

    public String getFull_regular() {
        return full_regular;
    }

    public String getFull_regular_and_cheese() {
        return full_regular_and_cheese;
    }

    public String getFull_large() {
        return full_large;
    }

    public String getFull_large_and_cheese() {
        return full_large_and_cheese;
    }

    public String getFull_footlong() {
        return full_footlong;
    }

    public String getFull_footlong_and_cheese() {
        return full_footlong_and_cheese;
    }

    public String getFull_special() {
        return full_special;
    }

    public String getFull_special_and_cheese() {
        return full_special_and_cheese;
    }

    public String getFull_drink() {
        return full_drink;
    }

    public String getStaff_regular() {
        return staff_regular;
    }

    public String getStaff_regular_and_cheese() {
        return staff_regular_and_cheese;
    }

    public String getStaff_large() {
        return staff_large;
    }

    public String getStaff_large_and_cheese() {
        return staff_large_and_cheese;
    }

    public String getStaff_footlong() {
        return staff_footlong;
    }

    public String getStaff_footlong_and_cheese() {
        return staff_footlong_and_cheese;
    }

    public String getStaff_special() {
        return staff_special;
    }

    public String getStaff_special_and_cheese() {
        return staff_special_and_cheese;
    }

    public String getStaff_drink() {
        return staff_drink;
    }

    public String getRegular_waste() {
        return regular_waste;
    }

    public String getLarge_waste() {
        return large_waste;
    }

    public String getFootlong_waste() {
        return footlong_waste;
    }

    public String getSpecial_waste() {
        return special_waste;
    }

    public String getSmall_bun_waste() {
        return small_bun_waste;
    }

    public String getLarge_bun_waste() {
        return large_bun_waste;
    }

    public String getTotal() {
        return total;
    }
}