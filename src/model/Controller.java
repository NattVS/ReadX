package model;
import java.util.ArrayList;

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
		if (users instanceof PremiumUser ){
			return true;
		}else{
			return false;
		}
	}

	public boolean editUser(int userPosition, int modifyOption, String newName, int categoryOption) {
		String name = users[userPosition].getName();
		if (users[userPosition] instanceof PremiumUser) {
			PremiumUser premiumUser = (PremiumUser) users[userPosition];
			if (newName.equals("")){
				users[userPosition].setName(name);
			}else{
				users[userPosition].setName(newName);
			}
			UserCategory newCategory = UserCategory.DOESNT_APPLY;
			switch (categoryOption) {
				case 1:
					newCategory = UserCategory.SILVER;
				break;
				case 2:
					newCategory = UserCategory.GOLD;
				break;
				case 3:
					newCategory = UserCategory.DIAMOND;
				break;
				default:
					newCategory = UserCategory.DOESNT_APPLY;
				break;
			}
			premiumUser.setUserCategory(newCategory);
			return true;
		}else if (users[userPosition] instanceof RegularUser) {
			users[userPosition].setName(newName);
			return true;
		}
		return false;
	}

	public boolean deleteUser(int userPosition) {
		users[userPosition]=null;
		return true;
	}

	public String getUserInfo(int option) {
		String msg = "";
		msg += users[option].toString();
		return msg;
	}

	public String getAllUsersInfo(int userTypeOp, int categoryOp) {
		String msg ="";
		int countRegulars = 0;
		int countPremium = 0;
		int countSilver = 0;
		int countGold = 0;
		int countDiamond = 0;
		for(int i=0;i<users.length;i++){
			if(users[i] != null){
				if (users[i] instanceof RegularUser){
					countRegulars ++;
				}else if  (users[i] instanceof PremiumUser) {
					countPremium ++;
					PremiumUser thisPremiumUser = (PremiumUser) users[i];
					if (thisPremiumUser.getUserCategory() == UserCategory.SILVER){
						countSilver ++;
					}else if (thisPremiumUser.getUserCategory() == UserCategory.GOLD){
						countGold ++;
					}else if (thisPremiumUser.getUserCategory() == UserCategory.DIAMOND){
						countDiamond ++;
					}
				}
			}
		}
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
