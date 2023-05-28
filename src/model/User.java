package model;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {
	private int type;
	private String id;
	private String name;
	private Calendar signUpDate;
	private ArrayList<BibliograficProduct> product;
	private ArrayList<BibliograficProduct> collection;

	public User(int type, String id, String name) {
		this.type = type;
		this.id = id;
		this.name = name;
		this.product = new ArrayList<BibliograficProduct>();
		this.collection = new ArrayList<BibliograficProduct>();
	}
    
	public String addProductToInventory(BibliograficProduct product){
		String msg = "";
		if (collection.contains(product)){
			msg = "You have already bought this product";
		}else {
			collection.add(product);
			msg = "The product was bought succesfully";
		}
		return msg;
	}
	
	//Getters & Setters
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Calendar getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Calendar signUpDate) {
		this.signUpDate = signUpDate;
	}

	public ArrayList<BibliograficProduct> getProduct() {
		return product;
	}

	public void setProduct(ArrayList<BibliograficProduct> product) {
		this.product = product;
	}

	public ArrayList<BibliograficProduct> getCollection() {
		return collection;
	}

	public void setCollection(ArrayList<BibliograficProduct> collection) {
		this.collection = collection;
	}

	

}
