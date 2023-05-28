package model;
import java.util.Calendar;

public class Magazine extends BibliograficProduct{
    private Category category;
    private String emmisionFrecuency;
    private int activeSuscriptions = 0;
    public Magazine (int productType, String id, String name, int pages, Calendar publishingDate, String url, Double price, Category category, String emmisionFrecuency){
        super(productType, id, name, pages, publishingDate, url, price);
        this.category = category;
        this.emmisionFrecuency = emmisionFrecuency;
        this.activeSuscriptions = 0;
    }
    
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getEmmisionFrecuency() {
        return emmisionFrecuency;
    }
    public void setEmmisionFrecuency(String emmisionFrecuency) {
        this.emmisionFrecuency = emmisionFrecuency;
    }
    public int getActiveSuscriptions() {
        return activeSuscriptions;
    }
    public void setActiveSuscriptions(int activeSuscriptions) {
        this.activeSuscriptions = activeSuscriptions;
    }  
}
