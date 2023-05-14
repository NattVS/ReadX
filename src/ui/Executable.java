package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller rXSystem;

	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	private void menu() {

		System.out.println("Welcome to ReadX! \nPlease choose one of the following options:");

		boolean flag = false;

		while (!flag) {
			System.out.println("1. Register an user");
			System.out.println("2. Register a product");
			System.out.println("3. Modify the information of a product");
			System.out.println("4. Delete a product");
			System.out.println("5. Buy a product");
			System.out.println("6. Exit");
			int option = reader.nextInt();
			switch (option) {
			case 1:
				registerUser();
				break;
			case 2:
				modifyUser();
				break;
			case 3:
				deleteUser();
				break;
			case 4:
				showUserInfo();
				break;
			case 5:
				showAllUserInfo();
				break;
			case 6:
				flag = true;
				break;
			default:
				System.out.println("Please choose a valid option");
				break;
			}

		}

	}

	private void registerUser() {
        String msg = "";
		System.out.println("Please, enter the information of the new user:");
		System.out.println("Enter the type of user \n1. Regular \n2. Premium");
		int type = reader.nextInt();
		//Buffer
		reader.nextLine();
		System.out.println("Enter the user's ID");
		String id = reader.nextLine();
		System.out.println("Enter the user's name");
		String name = reader.nextLine();
    
		msg = rXSystem.registerUser(type, id, name);

        System.out.println(msg);

	}

	private void modifyUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("There aren't any registered users");
		} else {

			System.out.println("\nThis are the registered users: ");

			System.out.println(query);
			
			System.out.println("\nEnter the user whose information you wish to modify");
			int option = reader.nextInt();
			Boolean isPremium = rXSystem.isPremium(option-1);
			System.out.println("\nEnter the modification you wish to do: \n1. Edit Name \n2. Edit Category");
			int modifyOption = reader.nextInt();
			//Buffer
			reader.nextLine();
			String newName = "";
			int categoryOption = 0;
			if (modifyOption == 1){
				System.out.println("\nEnter the user's new name");
				newName = reader.nextLine();
			} else if (modifyOption == 2){
				if (isPremium == true){
					System.out.println("\nEnter the new category \n1. Silver \n2. Gold \n3. Diamond");
					categoryOption = reader.nextInt();
				}else {
					System.out.println("\nThe user is not a premium user, it's category cannot be edited. ");
					categoryOption = 0;
				}
			}
			if (rXSystem.editUser(option - 1, modifyOption, newName, categoryOption)) {
				if (categoryOption == 0){
					System.out.println("Make sure the user you are choosing is an premium user to change its category");
				}else{
					System.out.println("\nThe user's information has been succesfully modified");
				}

			} else {
				System.out.println("\nError, there user couldn't be modified");
			}
		}
	}

	private void deleteUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {
			System.out.println("There aren't any registered users");
		} else {
			System.out.println("\nThis are the registered users:");

			System.out.println(query);
			
			System.out.println("\nEnter the user you wish to delete");

			int option = reader.nextInt();

			if (rXSystem.deleteUser(option - 1)) {

				System.out.println("\nUser succesfully deleted");

			} else {

				System.out.println("\nError, the user couldn't be deleted");
			}

		}

	}

	private void showUserInfo() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("There aren't any registered users");
		}else {
			System.out.println("\nThis are the registered users:");

			System.out.println(query);
			//Buffer
			reader.nextLine();
			System.out.println("\nEnter the user you wish to see the information");

			int option = reader.nextInt();

			String query2 = rXSystem.getUserInfo(option-1);

			if (query2.equals("")) {
				System.out.println("There was a mistake in the process");
			} else {
				System.out.println(query2);
			}

		}
	}

	private void showAllUserInfo() {
		String query = "";
		int userTypeOp = 0;
		int categoryOp = 0;
		System.out.println("What do you wish to consult?: \n1. The users by type of user \n2. The users by category");
		int option= reader.nextInt();
		if (option == 1) {
			System.out.println("What type of user do you wish to consult?: \n1. The regular users \n2. The premium users");
			userTypeOp = reader.nextInt(); 
			query = rXSystem.getAllUsersInfo(userTypeOp, categoryOp);
		}else if (option == 2){
			System.out.println("What category do you wish to consult?: \n1. The users in the silver category \n2. The users in the gold category \n3. The users in the diamond category");
			categoryOp = reader.nextInt();
			query = rXSystem.getAllUsersInfo(userTypeOp, categoryOp);
		}
		if (query.equals("")) {

			System.out.println("There aren't any registered users");
		} else {
			System.out.println(query);
		}

	}
}

