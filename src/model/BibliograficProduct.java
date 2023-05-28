package model;
import java.util.Calendar;
import java.text.DateFormat;
public abstract class BibliograficProduct implements Comparable<BibliograficProduct>{
    private int productType;
	private String id;
	private String name;
	private int pages;
	private Calendar publishingDate;
	private String url;
	private Double price;
	private DateFormat formatter;
	private double pagesRead;

	public BibliograficProduct(int productType, String id, String name, int pages, Calendar publishingDate, String url, Double price) {
		this.productType = productType;
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.publishingDate = publishingDate;
		this.url = url;
		this.price = price;
		this.pagesRead=0;
	}
    
	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Calendar getPublishingDate(){
		return publishingDate;
	}
	
	public String getPublishingDateFormated() {
		return formatter.format(this.publishingDate.getTime());
	}

	public void setPublishingDate(Calendar publishingDate) {
		this.publishingDate = publishingDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "["+ id + "]";
	}

	@Override
	public int compareTo(BibliograficProduct o) {
		int comparable = 0;
		if(getPublishingDate().before (o.getPublishingDate())){
			comparable = 1;
			return comparable;
		}
		if(getPublishingDate().after (o.getPublishingDate())){
			comparable = -1;
			return comparable;
		}
		return comparable;
	}

	public double getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(double pagesRead) {
        this.pagesRead = pagesRead;
    }
}
