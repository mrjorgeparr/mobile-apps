package com.example.funniflier2.db;




public class Business {
    private String id;
    private String CIF;
    private String name;
    //if type==1 -> Restaurant, if type==2 -> Hairdresser
    private int type;
    private String address;
    private String app_time;
    private double latitude;
    private double longitude;
    private String schedule;
    private double rating;
    public Business(String id, String CIF, String name, int type, String address,
                    String ap_time, double latitude, double longitude, String schedule){
        this.id = id;
        this.CIF = CIF;
        this.name = name;
        this.type = type;
        this.address = address;
        this.app_time = app_time;
        this.latitude = latitude;
        this.schedule = schedule;
    }


    // getter methods
    public String getId(){
        return id;
    }

    public String getCIF(){
        return CIF;
    }


    /*public int getType(){
        type==1 ? return "Restaurant":return "Hairdresser"
    }
    */
    public String getType(){
        if (type==1){return "Restaurant";}
        return "Hairdresser";
    }
    public String getApp_time(){return app_time;}

    public String getName(){ return name;}

    public String getAddress(){
        return address;
    }

    public String getSchedule() {
        return schedule;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public void setName(String name){ this.name = name;}

    public void setAddress(String address) {
        this.address = address;
    }

    public void setApp_time(String app_time){this.app_time = app_time;}

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setType(int type) {
        this.type = type;
    }
}
