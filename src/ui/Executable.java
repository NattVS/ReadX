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

	/**
	 * <pre>
	 *<strong>Description:</strong> The main method generates an instance for Executable and calls the menu method
	 * </pre>
	 */
	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	/**
	 * <pre>
	 *<strong>Description:</strong> The menu method holds access to all the functionalities that the program is going to implement
	 * </pre>
	 */
	private void menu() {

		System.out.println("Welcome to ReadX!");

		boolean flag = false;

		while (!flag) {
			System.out.println("Please choose one of the following options:");
			System.out.println("1. Register an user");
			System.out.println("2. Register a product");
			System.out.println("3. Modify the information of a product");
			System.out.println("4. Delete a product");
			System.out.println("5. Buy a book or subscribe to a magazine");
			System.out.println("6. Unsubscribe to a magazine");
			System.out.println("7. View the library");
			System.out.println("8. Generate reports");
			System.out.println("9. Exit");
			int option = reader.nextInt();
			switch (option) {
			case 1:
				registerUser();
				break;
			case 2:
				registerProduct();
				break;
			case 3:
				modifyBibliograficProduct();
				break;
			case 4:
				deleteBibliograficProduct();
				break;
			case 5:
				buyAProduct();
				break;
			case 6:
				cancelMagazineSubscription();
			break;	
			case 7:
				showMatrix();
				break;
			case 8:
				generateReports();
			break;	
			case 9:
				System.out.println("Thanks for using ReadX's services! \nHope we'll see you again, goodbye");
				flag = true;
				break;
			default:
				System.out.println("Please choose a valid option");
				break;
			}

		}

	}

	/**
	 * <pre>
	 *<strong>Description:</strong> The registerUser method creates users by reciving the users information via console, and shows 
	 * a confirmation message informing if the user was registered or not
	 * @param: id String represents the user's id
	 * @param: name String represents the user's name
	 * @return: msg String the validation message 
	 * </pre>
	 */
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

	/**
	 * <pre>
	 *<strong>Description:</strong> The registerProduct method creates products by reciving the product information via console, and shows 
	 * a confirmation message informing if the product was registered or not
	 * @param: producType int representrs the type of product that  is going to be registered
	 * @param: id String represents the ID of the product that is going to be registered
	 * @param: name String represents the name of the product that is going to be registered
	 * @param: pages int represent the number of pages that the product has
	 * @param: day int represent the day part of the registration date for the product
	 * @param: month int represent the month part of the registration date for the product
	 * @param: year int represent the year part of the registration date for the product
	 * @param: url String represent the url of the cover image for either a book or a magazine
	 * @param: price double represent the price in dolars that the products have
	 * @param: review String represent a short description for the book
	 * @param: genre int represent a number that later is going to be applied to the ennumeration Genre to asign the proper genre of book
	 * @param: category int represent a number that later is going to be aplied to the ennumeration Category to asign the proper category of magazine
	 * @param: emmisionfrecuency String represents how often a magazine is going to be published
	 * @return: msg String the validation  method 
	 * </pre>
	 */
    private void registerProduct(){
        String msg = "";
        String review = "";
        int genre = 0;
        int category = 0;
        String emmisionFrecuency = "";
		System.out.println("Please, enter the information of the new user:");
		System.out.println("Enter the type of product \n1. Book \n2. Magazine");
		int productType = reader.nextInt();
		//Buffer
		reader.nextLine();
		System.out.println("Enter the product's ID");
		String id = reader.nextLine();
		System.out.println("Enter the product's name");
		String name = reader.nextLine();
        System.out.println("How many pages does the product have?");
		int pages = reader.nextInt();
        System.out.println("Enter the product's publication date:");
		System.out.println("-Enter the day ");
		int day = reader.nextInt();
		System.out.println("-Enter the month ");
		int month = reader.nextInt();
		System.out.println("-Enter the year ");
		int year = reader.nextInt();
		//Buffer
		reader.nextLine();
        System.out.println("Enter the cover's URL");
		String url = reader.nextLine();
        System.out.println("Enter the product's price in dolars");
		Double price = reader.nextDouble();
		//Buffer
		reader.nextLine();
        if (productType == 1){
            System.out.println("Enter a short review of the book");
			review = reader.nextLine();
			System.out.println("Enter the book's genre: \n1. Science Fiction \n2. Fantacy \n3. Historic Novel");
			genre = reader.nextInt();
		}else if (productType == 2){
            System.out.println("Enter the magazine's catogory: \n1. Varieties \n2. Design \n3. Science");
            category = reader.nextInt();
            System.out.println("How often is this magazine going to be emmited?");
            emmisionFrecuency = reader.nextLine();
        }
		msg = rXSystem.registerProduct(productType, id, name, pages, day, month, year, url, price, review, genre, category, emmisionFrecuency);

        System.out.println(msg);
    }

	/**
	 * <pre>
	 *<strong>Description:</strong> The modifyBibliograficProduct method allows an interface that is able to modify the information of a product
	 * @param: option int represents the position of the product that is going to be modified
	 * @param: modifyOption int represents what aspect of the product it wants to be modified
	 * @param: proceed Boolean represent the validation of a condition
	 * @param: modification String represents the new information
	 * @param: newDay int represents the new day for the modified date
	 * @param: newMonth int represents the new month for the modified date
	 * @param: newYear int represents the new year for the modified date
	 * @return: confirmation message
	 * </pre>
	 */
	private void modifyBibliograficProduct(){
		String query = rXSystem.getProductsList();

		if (query.equals("")) {
			System.out.println("There aren't any bibliografic products registered");
		} else {

			System.out.println("\nThis are the registered products: ");
			System.out.println(query);

			System.out.println("\nEnter the number that corresponds to the product you wish to modify");
			int option = reader.nextInt();
			
			System.out.println("\nWhat do you wish to modify?: \n1. Edit Id \n2. Edit Name  \n3. Edit Number of pages  \n4. Edit Publishing Date  \n5. Edit Url  \n6. Edit Price \n7. Edit review (Only for Books) \n8. Edit Genre (Only for Books):\n    ->1. Science Fiction, 2. Fantacy, 3. Historic Novel  \n9. Edit Category (Only for Magazines)\n    ->1. Varieties, 2. Design, 3. Science \n10. Edit Emmision Frecuency (Only for Magazines)");
			int modifyOption = reader.nextInt();
			//Buffer
			reader.nextLine();
			Boolean bookOrMagazine = rXSystem.bookOrMagazine(option-1);
			Boolean proceed = false;
			while (proceed == false){
				if (bookOrMagazine == true && (modifyOption == 9 || modifyOption == 10 )){
					System.out.println("The product you're trying to edit is a book and the modification you wish to do is only for magazines \n Choose another modification:");
					modifyOption = reader.nextInt();
				}else if (bookOrMagazine == false && (modifyOption == 7 || modifyOption == 8)){
					System.out.println("The product you're trying to edit is a book and the modification you wish to do is only for magazines \n Choose another modification:");
					modifyOption = reader.nextInt();
				}else {
					proceed = true;
				}
			}
			System.out.println("Enter the modification:");
			String modification = "";
			int newDay = 0;
			int newMonth = 0;
			int newYear = 0;
			if (modifyOption == 4){
				System.out.println("-Enter the day ");
				newDay = reader.nextInt();
				System.out.println("-Enter the month ");
				newMonth = reader.nextInt();
				System.out.println("-Enter the year ");
				newYear = reader.nextInt();
			}else {
				modification = reader.nextLine();
			}

			if(rXSystem.modifyProduct(option-1, modifyOption, newDay, newMonth, newYear, modification)){

				System.out.println("The product has been succesfully modified");

			}else{
			
				System.out.println("There was a mistake and the product coulnd't be modified");
			}
		}
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> The deleteBibliograficProduct method allows an interfase that can delete a product from the system
	 * @param: option int represents the position of the product that is going to be deleted 
	 * @return: confirmation message
	 * </pre>
	 */
	private void deleteBibliograficProduct(){

		String query = rXSystem.getProductsList();
		if (query.equals("")) {
			System.out.println("There aren't any bibliografic products registered");
		} else {
			System.out.println("\nThis are the registered products: ");
			System.out.println(query);

			System.out.println("\nEnter the number that corresponds to the product you wish to delete");
			int option = reader.nextInt();

			if (rXSystem.deleteBibliograficProduct(option-1)) {

				System.out.println("The product was succesfully deleted");

			} else {

				System.out.println("There was a mistake and the product couldn't be modified");
			}
		}	
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> The buyAProduct method allows a user to buy a product if the user and the product are regsitered in the system
	 * @param: option int represents the position of the user that is going to buy a product
	 * @param: option2 int represents the position of the product that is going to be bought
	 * @return: msg String represents the confirmation message
	 * </pre>
	 */
    private void buyAProduct(){
		String usersQuery = rXSystem.getUsersList();
		String productsQuery = rXSystem.getProductsList();
		if (usersQuery.equals("")|| productsQuery.equals("")) {
			System.out.println("There aren't any users registered or there aren't any bibliografic products registered");
		} else {
			System.out.println("\nThis are the registered users: ");
			System.out.println(usersQuery);
			System.out.println("\nEnter the number that corresponds to the user that is going to buy the product");
			int option = reader.nextInt();

			System.out.println("\nThis are the registered products: ");
			System.out.println(productsQuery);
			System.out.println("\nEnter the number that corresponds to the product that is going to be bought");
			int option2 = reader.nextInt();

			String msg = rXSystem.buyAProduct(option-1, option2-1);

        	System.out.println(msg);
		}
    }

	/**
	 * <pre>
	 *<strong>Description:</strong> The cancelMagazineSubscription method allows the user to cancel the suscription of a magazine that previously was bought
	 * @param: option int represents the position of the user that is going to cancel its subscription to a magazine
	 * @param: option2 int represents the position of the magazine that is going to be cancelled
	 * @return: msg confirmation message
	 * </pre>
	 */
	private void cancelMagazineSubscription(){
		String usersQuery = rXSystem.getUsersList();
		if (usersQuery.equals("")) {
			System.out.println("There aren't any users registered");
		} else {
			System.out.println("\nThis are the registered users: ");
			System.out.println(usersQuery);
			System.out.println("\nEnter the number that corresponds to the user that is going to cancel their subcription");
			int option = reader.nextInt();
			String productsQuery = rXSystem.getUsersProducts(option-1);
			System.out.println("\nThis are the products that this user has bought: ");
			System.out.println(productsQuery);
			System.out.println("\nEnter the number that corresponds to the magazine the user is goint to cancel their subscription to");
			int option2 = reader.nextInt();

			String msg = rXSystem.cancelMagazineSubscription(option-1, option2+5);

        	System.out.println(msg);
		}
    }

	/**
	 * <pre>
	 *<strong>Description:</strong> The showMatrix method is used to show the inventory or collection owned by an user, it shows the ID's of the products
	 * via matix and also allows the user to start a reading session or simulation
	 * @param: option int represents the position of the user which collection the system is going to show 
	 * @param: flag Boolean represent the validation of a condition
	 * @param: flag2 Boolean represent the validation of a condition
	 * @param: option2 int represents the users option to start a reading session or go back to the main menu
	 * @param: letterOption String represents the user's movility in the simulation
	 * @return: confirmation message
	 * </pre>
	 */
	private void showMatrix(){
		String usersQuery = rXSystem.getUsersList();
		if (usersQuery.equals("")) {
			System.out.println("There aren't any users registered ");
		} else {
			System.out.println("\nThis are the registered users: ");
			System.out.println(usersQuery);
			System.out.println("\nEnter the number that corresponds to the user who's library you wish to view");
			int option = reader.nextInt();
			Boolean flag = false;
			while (!flag){
				System.out.println("\nThis is the current user's book collection sorted by oldest to newest \n\n" + rXSystem.showUserMatrix(option-1));
				System.out.println("\nWhat do you wish to do? \n1. Start a reading session \n2. Go back to main menu");
				int option2 = reader.nextInt();
				String readingProduct = "";
				if (option2 == 1){
					System.out.println("Enter the id of the product you wish to read");
					//Buffer
					reader.nextLine();
					readingProduct = reader.nextLine();
					int pageCounter = 1;
					System.out.println("\nStarting reading session...");
					String msg = rXSystem.readingSession(option2, readingProduct, pageCounter);
					System.out.println(msg);
					Boolean flag2 = false;
					while (!flag2){
						System.out.println("Enter A for previous page");
						System.out.println("Enter S for next page");
						System.out.println("Enter B for returning to libary page");
						String letterOption = reader.nextLine();
						switch (letterOption) {
							case "A":
								pageCounter--;
								msg = rXSystem.readingSession(option-1, readingProduct, pageCounter);
								System.out.println(msg);
								break;
							case "S":
								pageCounter++;
								msg = rXSystem.readingSession(option2-1, readingProduct, pageCounter);
								System.out.println(msg);
								break;
							case "B":
								flag2 = true;
								System.out.println("Reading session finished...\nReturning to library");
								flag = false;
								break;
							default:
								System.out.println("Please choose a valid option");
								break;
						}
					}	
				} else if (option2 == 2){
					System.out.println("Returning to main menu...");
					flag = true;
				}
			}	
		}	
	}

	/**
	 * <pre>
	 *<strong>Description:</strong> The power method calculates the power of any given number using a given exponent.
	 * @param: 
	 * @param: 
	 * @param: 
	 * @param: 
	 * @return: resultPower the result of the power of a number
	 * </pre>
	 */
	public void generateReports() {
		System.out.println("We are sorry to inform that we are still working on this feature");	
	}
}

