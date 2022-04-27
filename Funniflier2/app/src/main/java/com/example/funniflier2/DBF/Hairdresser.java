package com.example.funniflier2.DBF;

public class Hairdresser {
    private int b_id;
    private int n_barbers;

    public Hairdresser(int b_id, int n_barbers) {
        this.b_id = b_id;
        this.n_barbers = n_barbers;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getN_barbers() {
        return n_barbers;
    }

    public void setN_barbers(int n_barbers) {
        this.n_barbers = n_barbers;
    }
}
