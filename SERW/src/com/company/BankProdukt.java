package com.company;

import java.io.Serializable;

public class BankProdukt implements Serializable {

    private String name_of_product;
    private  double initial_amount;//начальная сумма

    public double getInitial_amount() {
        return initial_amount;
    }

    public void setInitial_amount(double initial_amount) {
        this.initial_amount = initial_amount;
    }

    public String getName_of_product() {
        return name_of_product;
    }

    public void setName_of_product(String name_of_product) {
        this.name_of_product = name_of_product;
    }
}
