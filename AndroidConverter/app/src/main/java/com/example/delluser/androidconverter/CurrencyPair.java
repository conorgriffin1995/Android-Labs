package com.example.delluser.androidconverter;

/**
 * Created by Conor Griffin on 30/04/2018.
 */

public class CurrencyPair {

    private String code;
    public String GetCode(){return code;}

    private double rate;

    private String currencySymbol;
    public String GetCurrencySymbol(){ return currencySymbol;}


    public CurrencyPair(String code, double rate, String symbol) {
        this.code = code;
        this.rate = rate;
        this.currencySymbol = symbol;
    }

    public double convert(double amount){
        double result = 0.0;
        result = amount * rate;
        return result;
    }
}
