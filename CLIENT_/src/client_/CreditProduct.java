/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_;

import java.io.Serializable;

/**
 *
 * @author Benutzer
 */
public class CreditProduct extends BankProdukt implements Serializable {


    private int maturity_date;//срок погашения
    private double interest_rate;//процентная ставка
    private double recurring_payments;//размер переодических платежей
    private boolean  early_repayment; //возможность досрочного погашения
    
    public boolean isEarly_repayment() {
        return early_repayment;
    }

    public void setEarly_repayment(boolean early_repayment) {
        this.early_repayment = early_repayment;
    }
    
    public int getMaturity_date() {
        return maturity_date;
    }

    public double getRecurring_payments() {
        return recurring_payments;
    }

    public void setRecurring_payments(double recurring_payments) {
        this.recurring_payments = recurring_payments;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public void setMaturity_date(int maturity_date) {
        this.maturity_date = maturity_date;
    }

}
