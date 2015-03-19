package com.twu.refactor;

public class Movie {

	private String title;
	private MoviePricingCategory priceCode;

	public Movie(String title, MoviePricingCategory MoviePricingCategory) {
		this.title = title;
		this.priceCode = MoviePricingCategory;
	}

	public MoviePricingCategory getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(MoviePricingCategory arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", priceCode=" + priceCode +
                '}';
    }

    public MoviePricingCategory getPriceCode(Rental rental) {
        return rental.getMovie().getPriceCode();
    }
}

