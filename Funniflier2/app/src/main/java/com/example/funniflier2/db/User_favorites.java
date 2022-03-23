package com.example.funniflier2.db;

public class User_favorites {
    private String id;
    private String business_id;
    private String customer_id;

    public User_favorites(String id, String business_id, String customer_id){
        this.id = id;
        this.business_id = business_id;
        this.customer_id = customer_id;
    }


    // getter functions

    public String getId() {
        return id;
    }

    public String getBusiness_id() {
        return business_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    // setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
}
