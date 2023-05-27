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

		users.add(new PremiumUser(1, "1234", "John Smith"));
		users.add(new RegularUser(2, "5678", "Pocahontas"));
		products.add(new Book(1, "Book 1", "Giant squids that conquer the world", 54, Calendar.getInstance(), "https//:Gigantsquidsthatconquertheworld.jpg", 20.5, "On a normal day the squids rose from the oceans and began to invade the cities", Genre.SCIENCE_FICTION));
		products.add(new Magazine(2, "Magazine 1", "SCIENCE WOW!", 24, Calendar.getInstance(), "https//:sciencewow.jpg", 14.5, Category.SCIENTIFIC, "Daily"));
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

}
