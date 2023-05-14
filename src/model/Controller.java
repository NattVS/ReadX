package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Controller {
    private ArrayList<User> users;

	public Controller() {

		this.users = new ArrayList<User>();
		testCases();

	}

	public void testCases() {

		users.add(new PremiumUser(1, "1234", "John Smith"));
		users.add(new RegularUser(2, "5678", "Pocahontas"));
	}

	public String getUserList() {

		String msg = "";
		for (int i = 0; i < users.size(); i++) {
			msg += "\n" + (i + 1) + ". " + users.get(i).getId() + " - " + users.get(i).getName();
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

	public boolean isPremium (int option){
		return true;
	}

    public String registerProduct(int productType, String id, String name, int pages, int day, int month, int year, String url, Double price, String review, int genre, int category, String emmisionFrecuency) {
        User newUser = null;
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
            newUser = new RegularUser(productType, id, name);
            msg += "User registered succesfully";
        }else if (productType == 2){
            newUser = new PremiumUser(productType, id, name);
            msg += "User registered succesfully";
        }else {
            msg += "An error ocurred, the user couldn't be registered";
        }
        users.add(newUser);
        return msg;
	}

	public boolean editUser(int userPosition, int modifyOption, String newName, int categoryOption) {
		
		return false;
	}

	public boolean deleteUser(int userPosition) {
		
		return true;
	}

	public String getUserInfo(int option) {
		String msg = "";
		
		return msg;
	}

	public String getAllUsersInfo(int userTypeOp, int categoryOp) {
		String msg ="";
		int countRegulars = 0;
		int countPremium = 0;
		int countSilver = 0;
		int countGold = 0;
		int countDiamond = 0;
		
		if (userTypeOp!= 0){
			if (userTypeOp == 1) {
				msg +="The amount of registered regular users is " + countRegulars;
			}else if (userTypeOp == 2){
				msg +="The amount of registered premium users is " + countPremium;
			}
		}
		if (categoryOp!= 0){
			switch (categoryOp) {
				case 1:
					msg +="The amount of registered premium users in the silver category is " + countSilver;
				break;
				case 2:
					msg +="The amount of registered premium users in the gold category is " + countGold;
				break;
				case 3:
					msg +="The amount of registered premium users in the diamond category is " + countDiamond;
				break;
				default:
					msg +="Wrong option";
				break;
			}
		}
		return msg;
	}
}
