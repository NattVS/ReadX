package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Controller {
    private ArrayList<User> users;
    private ArrayList<BibliograficProduct> products;
	public Controller() {

		this.users = new ArrayList<User>();
		this.products = new ArrayList<BibliograficProduct>();
		testCases();

	}

	public void testCases() {

		users.add(new RegularUser(1, "112345", "Norman Smith"));
		users.add(new PremiumUser(2, "107582", "Juana Of the Sea"));
		products.add(new Book(1, "B01", "Giant squids that conquer the world", 54, Calendar.getInstance(), "https//:Gigantsquidsthatconquertheworld.jpg", 20.5, "On a normal day the squids rose from the oceans and began to invade the cities", Genre.SCIENCE_FICTION));
		products.add(new Book(1, "B02", "Whispers of the forgotten stars", 104, Calendar.getInstance(), "https//:Whispersoftheforgottenstar.jpg", 20.5, "A young stargazer discovers a hidden celestial language in the night sky", Genre.SCIENCE_FICTION));
		products.add(new Magazine(2, "M01", "SCIENCE WOW!", 24, Calendar.getInstance(), "https//:sciencewow.jpg", 14.5, Category.SCIENTIFIC, "Daily"));
	}

	public String getUsersList() {

		String msg = "";
		for (int i = 0; i < users.size(); i++) {
			msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " - " + users.get(i).getName();
		}
		return msg;
	}

	public String getProductsList() {

		String msg = "";
		for (int i = 0; i < products.size(); i++) {
			msg += "\n" + (i + 1) + ". " + products.get(i).getId() + " - " + products.get(i).getName();
		}
		return msg;
	}

	public String registerUser(int type, String id, String name) {
        User newUser = null;
        String msg = "";
        if (type == 1){
            newUser = new RegularUser(type, id, name);
            msg += "User registered succesfully";
        }else if (type == 2){
            newUser = new PremiumUser(type, id, name);
            msg += "User registered succesfully";
        }else {
            msg += "An error ocurred, the user couldn't be registered";
        }
        users.add(newUser);
        return msg;
	}

    public String registerProduct(int productType, String id, String name, int pages, int day, int month, int year, String url, Double price, String review, int genre, int category, String emmisionFrecuency) {
        BibliograficProduct newProduct = null;
        String msg = "";
        Calendar publishingDate = new GregorianCalendar(year, month, day);
        Genre newGenre= Genre.DOESNT_APPLY;
        Category newCategory= Category.DOESNT_APPLY;

		switch (genre) {
			case 1:
				newGenre = Genre.SCIENCE_FICTION;
			break;
			case 2:
				newGenre = Genre.FANTASY;
			break;
			case 3:
				newGenre = Genre.HISTORICAL_NOVEL;
			break;
			default:
				newGenre = Genre.DOESNT_APPLY;
			break;
		}
        switch (category) {
			case 1:
				newCategory = Category.VARIETIES;
			break;
			case 2:
				newCategory = Category.DESIGN;
			break;
			case 3:
				newCategory = Category.SCIENTIFIC;
			break;
			default:
				newCategory = Category.DOESNT_APPLY;
			break;
		}

        if (productType == 1){
            newProduct = new Book(productType, id, name, pages, publishingDate, url, price, review, newGenre);
            msg += "Product registered succesfully";
        }else if (productType == 2){
            newProduct = new Magazine(productType, id, name, pages, publishingDate, url, price, newCategory, emmisionFrecuency);
            msg += "Product registered succesfully";
        }else {
            msg += "An error ocurred, the product couldn't be registered";
        }
        products.add(newProduct);
        return msg;
	}

	public boolean bookOrMagazine (int option){
		if (products.get(option) instanceof Book ){
			return true;
		}else{
			return false;
		}
	}

	public boolean modifyProduct (int productPosition, int modifyOption, int newDay, int newMonth, int newYear, String modification) {

        switch(modifyOption){
	    
			case 1:
				products.get(productPosition).setId(modification);
				return true;
			
			case 2:
				products.get(productPosition).setName(modification);
				return true;
			case 3:
				int newPages = Integer.parseInt(modification);
				products.get(productPosition).setPages(newPages);
				return true;
				
			case 4:
				Calendar newPublishingDate = new GregorianCalendar(newDay, newMonth, newYear);
				products.get(productPosition).setPublishingDate(newPublishingDate);
				return true;
			
			case 5:
				products.get(productPosition).setUrl(modification);
				return true;

			case 6:
				double newPrice = Double.parseDouble(modification);
				products.get(productPosition).setPrice(newPrice);;
				return true;
			case 7:
				((Book)(products.get(productPosition))).setReview(modification);
				return true;
			case 8:
				Genre genre = null;
			
				switch(modification){
					case "1":
						genre = Genre.SCIENCE_FICTION;
					break;
					case "2":
						genre = Genre.FANTASY;
					break;
					case "3":
						genre = Genre.HISTORICAL_NOVEL;
					break;
					default:
						genre = Genre.DOESNT_APPLY;
					break;
				}
				((Book)(products.get(productPosition))).setGenre(genre);
				return true;
			case 9:
				Category category = null;
				
				switch(modification){
					case "1":
						category = Category.VARIETIES;
					break;
					case "2":
						category = Category.DESIGN;
					break;
					case "3":
						category = Category.SCIENTIFIC;
					break;
					default:
						category = Category.DOESNT_APPLY;
					break;
				}
				((Magazine)(products.get(productPosition))).setCategory(category);
				return true;
			case 10:
				((Magazine)(products.get(productPosition))).setEmmisionFrecuency(modification);
				return true;
		}
		return false;
   
	}

	public boolean deleteBibliograficProduct(int productPosition){
		products.remove(productPosition);
		return true;
	}

	public String buyAProduct(int userPosition, int productPosition) {
		String msg = "";
		int productType = 0;
		int maxSizeBooks = 5;
		int maxSizeMagazine = 2;
		
		if (users.get(userPosition) instanceof RegularUser) {
			if (products.get(productPosition) instanceof Book) {
				productType = 1;
			} else if (products.get(productPosition) instanceof Magazine) {
				productType = 2;
			}
			
			for (int i = -1; i < users.get(userPosition).getCollectionSize(); i++){
				int info = (users.get(userPosition).getProductsAmount(productType));
				if (users.get(userPosition).getProductsAmount(productType) > maxSizeBooks) {
					msg += "You have reached the maximum amount of books that you can buy for free, if you want to buy more, become a premium member now!";
				} else if (users.get(userPosition).getProductsAmount(productType) > maxSizeMagazine) {
					msg += "You have reached the maximum amount of magazines that you can subscribe to for free, if you want to subscribe to more, become a premium member now!";
				}else{
					msg += info + " " + users.get(userPosition).addProductToInventory(products.get(productPosition));
				}
			}
			
		} else if (users.get(userPosition) instanceof PremiumUser) {
			msg += users.get(userPosition).addProductToInventory(products.get(productPosition));
		}
		
		return msg;
	}

	public void sortByDate() {
		for (int i = 0; i < products.size(); i++) {

			BibliograficProduct temp = products.get(i);
			if(i+1<products.size()){
				BibliograficProduct temp2 = products.get(i+1);

				int compared = temp.compareTo(temp2);
				if (compared < 0){
					products.set(i, temp);
					products.set(i+1, temp2);
				}else if(compared > 0){
					products.set(i, temp2);
					products.set(i+1, temp);
				}

			}
			
		}
	}

	public String[][] fillMatrix() {

		sortByDate();
		sortByDate();
		String[][] matrix = new String[5][5];
		int index = 0;
		for (int x = 0; x < matrix.length; x++) {
			for(int y = 0; y < matrix[x].length; y++){
				if (matrix[x][y]==null){
					if (index < products.size()){
						matrix[x][y]=products.get(index).toString();
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
