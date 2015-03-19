package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

    public Customer(ArrayList<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	private String getName() {
		return name;
	}

	public Statement getStatement() {
        return new Statement(name,rentalList);
	}

    public String htmlStatement() {
        return getStatement().toHTML();
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentalList){
            frequentRenterPoints += rental.getNewReleaseRental();
        }
        return frequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentalList) {
            totalAmount += rental.getRentalAmount();
        }
        return totalAmount;
    }
}
