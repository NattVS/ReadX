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
		products.add(new Book(1, "Libro 1", "Calamares gigantes que conquistan el mundo", 54, Calendar.getInstance(), "https//:Calamaresqueconquistanalmundo.jpg", 20.5, "En un dia normal los calamares se alzaron de los oceanos y comenzaron a invadir las ciudades", Genre.SCIENCE_FICTION));
		products.add(new Magazine(2, "EEE", "SCIENCE WOW!", 24, Calendar.getInstance(), "https//:sciencewow.jpg", 14.5, Category.SCIENTIFIC, "Daily"));
		
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

	
}
