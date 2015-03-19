package com.twu.refactor;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getRentalAmount() {
        return movie.getPriceCode(this).getCostFor(daysRented);
    }

    public boolean isTrue() {
        return isPriceEqual() && getDaysRented() > 1;
    }

    private boolean isPriceEqual() {
        return movie.getPriceCode(this) == MoviePricingCategory.NEW_RELEASE;
    }

    public int getNewReleaseRental() {
        int frequentRenterPoints=1;
        if (isTrue())
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    String getRentalSubTotal(String result, double rentalAmount) {
        result += "\t" + getMovie().getTitle() + "\t"
                + String.valueOf(rentalAmount) + "\n";
        return result;
    }
}