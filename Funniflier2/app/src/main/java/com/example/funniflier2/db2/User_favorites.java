package com.example.funniflier2.db2;

public class User_favorites {
    long b_id;
    long u_id;

    public User_favorites(long b_id, long u_id) {
        this.b_id = b_id;
        this.u_id = u_id;
    }

    public long getB_id() {
        return b_id;
    }

    public void setB_id(long b_id) {
        this.b_id = b_id;
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }
}
