package com.company;

import java.io.Serializable;

public class ExpertReview implements Serializable {

    private double[][] review=new double[4][12];
    private int expert_value=0; //число оценивших экспертов


    public void setReview(double[][] review) {
        this.review = review;
    }

    public int getExpert_value() {
        return expert_value;
    }

    public void setExpert_value(int expert_value) {
        this.expert_value = expert_value;
    }

    public double[][] getReview() {
        return review;
    }

    public void setReview(int i,int j,double value) {
        review[i][j]=value;
    }

    public double getReview(int i,int j) {
        return review[i][j];
    }

    public int ExpertValueIncrement(){return ++expert_value;}
}
