package com.example.funniflier2.db;

public class Hairdresser {
    private String b_id;
    private String services;
    private String nbarbers;

    public Hairdresser(String b_id, String services, String nbarbers){
        this.b_id = b_id;
        this.services = services;
        this.nbarbers = nbarbers;
    }

    public String getB_id() {
        return b_id;
    }

    public String getServices() {
        return services;
    }

    public String getNbarbers() {
        return nbarbers;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setNbarbers(String nbarbers){this.nbarbers = nbarbers;}
}
