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
    
	public String addProductToCollection(BibliograficProduct product){
		String msg = "";
		if (collection.contains(product)){
			msg = "You have already bought this product";
		}else {
			collection.add(product);
			msg = "The product was bought succesfully";
		}
		return msg;
	}

	public String showUsersCollection(int userPosition){
		String msg = "";
		for (int i = 0; i < collection.size(); i++) {
			msg += "\n" + (i + 1) + ". " + collection.get(i).getId() + " - " + collection.get(i).getName();
		}
		return msg;
	}

	public String deleteMagazineFromCollection(BibliograficProduct product){
		String msg = "";
		if (collection.contains(product)){
			collection.remove(product);
			msg = "You have cancelled you're subscription to this magazine";
		}else {
			msg = "You don't have this magazine in your collection";
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

	public void sortByDate() {

		for (int i = 0; i < collection.size(); i++) {
			BibliograficProduct temp = collection.get(i);
			if(i+1<collection.size()){
				BibliograficProduct temp2 = collection.get(i+1);

				int compared = temp.compareTo(temp2);
				if (compared < 0){
					collection.set(i, temp);
					collection.set(i+1, temp2);
				}else if(compared > 0){
					collection.set(i, temp2);
					collection.set(i+1, temp);
				}
			}
		}
	}

	public String[][] fillMatrix() {
		String[][] matrix = new String[5][5];
		int index = 0;
		for (int x = 0; x < matrix.length; x++) {
			for(int y = 0; y < matrix[x].length; y++){
				if (matrix[x][y]==null){
					if (index < collection.size()){
						matrix[x][y]=collection.get(index).toString();
						index++;
					}
				}
			}

		}
		return matrix;
	}

	public String showMatrix() {

		String[][] matrix = fillMatrix();

		String print = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == null) {
					print += "_____" + " ";
				} else {
					print += matrix[i][j] + " ";
				}

			}
			print += "\n";
		}

		return print;
	}
}
