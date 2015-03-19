package com.twu.refactor;

import java.util.ArrayList;

/**
 * Created by tprashan on 3/17/2015.
 */
public class Statement {
    private String name = "";
    private ArrayList<Rental> rentalList=null;

    public Statement(String name, ArrayList<Rental> rentalList) {
        this.name=name;
        this.rentalList=rentalList;
    }

    public Statement() {

    }

    public String getSummary(double totalAmount, int frequentRenterPoints, String result) {
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    private String getHeader(){
        return "Rental Record for " + name + "\n";
    }
    public String toString() {
        Customer customer = new Customer(rentalList);
        String statement = getHeader();
        int frequentRenterPoints = customer.getFrequentRenterPoints();
        for (Rental rental : rentalList) {
            statement = rental.getRentalSubTotal(statement, rental.getRentalAmount());
        }
        statement = getSummary(customer.getTotalAmount(), frequentRenterPoints, statement);
        return statement;
    }

    public String toHTML(){
        Customer customer = new Customer(rentalList);
        int frequentRenterPoints = customer.getFrequentRenterPoints();
        String statement = "<H1>Rentals for <EM>" + name + "</EM></H1><P>";
        for (Rental rental:rentalList){
            statement+=rental.getMovie().getTitle()+": "+rental.getRentalAmount()+"<BR>";
        }
        statement+="<P>You owe <EM>"+customer.getTotalAmount()+"</EM><P>On this rental you earned <EM>"+frequentRenterPoints+"</EM> frequent renter points<P>";
        return statement;
    }
}
