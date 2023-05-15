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

		System.out.println("Welcome to ReadX!");

		boolean flag = false;

		while (!flag) {
			System.out.println("Please choose one of the following options:");
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
                RegisterProduct();
				break;
			case 3:
				modifyBibliograficProduct();
				break;
			case 4:
                
				break;
			case 5:
				buyAProduct();
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

    private void RegisterProduct(){
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
            System.out.println("How often is this maagazine going to be emmited?");
            emmisionFrecuency = reader.nextLine();
        }
		msg = rXSystem.registerProduct(productType, id, name, pages, day, month, year, url, price, review, genre, category, emmisionFrecuency);

        System.out.println(msg);
    }

	private void modifyBibliograficProduct(){
		String query = rXSystem.getProductsList();

		if (query.equals("")) {
			System.out.println("There aren't any bibliografic products registered");
		} else {

			System.out.println("\nThis are the registered products: ");
			System.out.println(query);

			System.out.println("\nEnter the number that corresponds to the product you wish to modify");
			int option = reader.nextInt();
			
			System.out.println("\nEnter the modification you wish to do: \n1. Edit Id \n2. Edit Name  \n3. Edit Number of pages  \n4. Edit Publishing Date  \n5. Edit Url  \n6. Edit Price \n7. Edit review (Only for Books) \n8. Edit Genre (Only for Books) \n9. Edit Category (Only for Magazines) \n10. Edit Emmision Frecuency (Only for Magazines)");
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
		}
	}

    private void buyAProduct(){
		System.out.println("We are still working on this option, we'll keep you updated");
    }

	
}

