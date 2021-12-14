package com.example.smoke_login_firebase;

public class Users {  String dailycigarettes,pack,price,sleep,today;

    public Users() {
    }

    public Users(String dailycigarettes, String pack, String price, String sleep, String today) {
        this.dailycigarettes = dailycigarettes;
        this.pack = pack;
        this.price = price;
        this.sleep = sleep;
        this.today = today;
    }

    public String getDailycigarettes() {
        return dailycigarettes;
    }

    public void setDailycigarettes(String dailycigarettes) {
        this.dailycigarettes = dailycigarettes;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSleep() {
        return sleep;
    }

    public void setSleep(String sleep) {
        this.sleep = sleep;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }
}


