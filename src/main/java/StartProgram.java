

import java.util.List;
import java.util.Scanner;

import controller.DogHelper;
import model.Dogs;


public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static DogHelper dh = new DogHelper();

		private static void addADog() {
			// TODO Auto-generated method stub
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter an breed: ");
			String breed = in.nextLine();
			System.out.print("Enter a color: ");
			String color = in.nextLine();
			
			Dogs toAdd = new Dogs(name, breed, color);
			dh.insertDog(toAdd);

		}

		private static void deleteADog() {
			// TODO Auto-generated method stub
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the breed to delete: ");
			String breed = in.nextLine();
			System.out.print("Enter the color to delete: ");
			String color = in.nextLine();
			
			Dogs toDelete = new Dogs(name, breed, color);
			dh.deleteDog(toDelete);

		}

		private static void editADog() {
			
			
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Breed");
			System.out.println("3 : Search by Color");
			int searchBy = in.nextInt();
			in.nextLine();			
			
			List<Dogs> foundDogs;
			
			if(searchBy == 1) {
				System.out.print("Enter the dog's name: ");
				String dogName = in.nextLine();
				foundDogs = dh.searchForDogByName(dogName);
			} else if(searchBy == 2) {
				System.out.print("Enter the dog's breed: ");
				String breedName = in.nextLine();
				foundDogs = dh.searchForDogByBreed(breedName);
			} else {
				System.out.print("Enter the dog's color: ");
				String colorName = in.nextLine();
				foundDogs = dh.searchForDogByColor(colorName);
			}

			if (!foundDogs.isEmpty()) {
				System.out.println("Found Results.");
				for (Dogs d : foundDogs) {
					System.out.println(d.getId() + " : " + d.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Dogs toEdit = dh.searchForDogById(idToEdit);
				System.out.println("Retrieved " + toEdit.getColor() + ", " + toEdit.getBreed() + " from " + toEdit.getName());
				System.out.println("1 : Update Dog's Name");
				System.out.println("2 : Update Dog's Breed");
				System.out.println("3 : Update Dog's Color");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New Breed: ");
					String newBreed = in.nextLine();
					toEdit.setBreed(newBreed);
				} else {
					System.out.print("New Color: ");
					String newColor = in.nextLine();
					toEdit.setColor(newColor);
				}

				dh.updateDog(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// main method
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the dog database! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a Dog");
				System.out.println("*  2 -- Edit a Dog");
				System.out.println("*  3 -- Delete a Dog");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the database");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addADog();
				} else if (selection == 2) {
					editADog();
				} else if (selection == 3) {
					deleteADog();
				} else if (selection == 4) {
					viewTheList();
				} else {
					dh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Dogs> allDogs = dh.showAllDogs();
			for(Dogs singleDog: allDogs) {
				System.out.println(singleDog.returnDogDetails());
			}
			

		}

	}