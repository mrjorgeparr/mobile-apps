package com.example.funniflier2.DBF;

public class User_favorites {
    private int u_id;       //(the primary key will be the tuple of the user id and the business id which by definition will be unique)
    private int b_id;

    public User_favorites(int u_id, int b_id) {
        this.u_id = u_id;
        this.b_id = b_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    @Override
    public String toString() {
        return "User_favorites{" +
                "u_id=" + u_id +
                ", b_id=" + b_id +
                '}';
    }
}
