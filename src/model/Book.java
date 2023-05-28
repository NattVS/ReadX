package model;
import java.util.Calendar;

public class Book extends BibliograficProduct {
    private String review;
    private Genre genre;
    private int soldUnits = 0;
    public Book (int productType, String id, String name, int pages, Calendar publishingDate, String url, Double price, String review, Genre genre){
        super(productType, id, name, pages, publishingDate, url, price);
        this.review = review;
        this.genre = genre;
        this.soldUnits = 0;
    }
    
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getSoldUnits() {
        return soldUnits;
    }

    public void setSoldUnits(int soldUnits) {
        this.soldUnits = soldUnits;
    }

}
