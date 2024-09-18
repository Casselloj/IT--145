import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // added monkey instance variable
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	initializeDogList();
    	initiliazeMonkeyList();
    	
    	//Created loop for menu traversal
    	boolean acceptingInput = true;
    	Scanner input = new Scanner(System.in);
    	   	
    	do {
    		displayMenu();
    		String option = input.nextLine().trim().toLowerCase();
    		
    		//Created inputs for new dogs, new monkeys and reserve animals
    		switch (choice) {
    		case '1':
    			intakeNewDog(scanner);
    			break;
    		case '2':
    			intakeNewMonkey(scanner);
    			break;
    		case '3':
    			reserveAnimal(scanner);
    			break;
    		case '4':
    			printAnimals();
    			break;
    		case '5':
    			printAnimals();
    			break;
    		case '6':
    			printAnimals();
    			break;
    		case 'q':
    			acceptingInput = false;
    		default:
    			System.out.println("Invalid choice! Please try again.");
    			break;
    		}
    	} while (acceptingInput);
    	System.out.println("Exiting application...Goodbye.");
    	scanner.close();
    }
    
    //Created a method to print all menu options
    public static void displayMenu() {
    	System.out.println("\n\n");
    	System.out.println("\t\t\t\tRescue Animal System Menu");
    	System.out.println("[1] Intake a new dog");
    	System.out.println("[2] Intake a new monkey");
    	System.out.println("[3] Reserve an animal");
    	System.out.println("[4] Print a list of all dogs");
    	System.out.println("[5] Print a list of all monkeys");
    	System.out.println("[6] Print a list of all animals that are not reserved");
    	System.out.println("[q] Quit application");
    	System.out.println();
    	System.out.println("Enter a menu selection:");
    }
    
    //Created a list of dogs for testing
    public static void intializeDogList() {
    	Dog dog1 = new Dog("Seaver", "Golden Retriever", "male", "1", "30.0", "06-01-2021", "United States", "Phase I", false, "United States");
    	Dog dog2 = new Dog("Harvey", "German Shepherd", "male", "5", "27.8", "08-14-2021", "Canada", "Phase III", false, "Canada");
    	Dog dog3 = new Dog("Otis", "Beagle", "male", "3", "23.6", "03-05-2020", "United States", "in service", true, "United States");
    	
    	dogList.add(dog1);
    	dogList.add(dog2);
    	dogList.add(dog3);
    }
    
    //Created a list of monkeys for testing
    public static void intializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Wilmer", "Tamarin", "male", "3", "7.1", "17", "11", "6", "02-25-2019", "United States", "Phase I", false, "United States");
    	Monkey monkey2 = new Monkey("Bob", "Guenon", "male", "1", "14.7", "20", "18", "5", "12-19-2019", "Canada", "Phase IV", false, "Canada");
    	Monkey monkey3 = new Monkey("Xavier", "Capuchin", "male", "5", "16.5", "60", "50", "9", "07-04-2021", "Colombia", "in service", false, "Colombia");
    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    }
    
    //Created intake to add new dog to dogList
    public static void intakeNewDog(Scanner scanner) {
    	System.out.println("What is the dog's name?");
    	String name = scanner.nextLine().trim();
    	
    	for(Dog dog : dogList)
    		if (dog.getName().equalsIgnoreCase(name)) {
    			System.out.println("\n\nThis dog is already in the system\n\n");
    			return;
    		}
    	
    	//Gather information about new dog
    	System.out.println("What is " + name + " 's breed?");
    	String breed = scanner.nextLine().trim();
    	
    	System.out.println("What is " + name + " 's breed? (\"male\", \"female\")");
    	String gender = scanner.nextLine().trim().toLowerCase();
    	
    	System.out.println("What is " + name + " 's age?");
    	String age = scanner.nextLine().trim();
    	
    	System.out.println("What is " + name + " 's weight? (in pounds)");
    	String weight = scanner.nextLine().trim();
    	
    	System.out.println("When was " + name + " 's acquired? (MM-DD-YYYY)");
    	String acquisitionDate = scanner.nextLine().trim();
    	
    	System.out.println("Where was " + name + " 's acquired? (Country)");
    	String acquisitionCountry = scanner.nextLine().trim();
    	
    	System.out.println("What is " + name + " 's training status? (\"intake\, \"in service\", \"phase I/II/III/IV/V\", \"farm\")");
    	String trainingStatus = scanner.nextLine().trim();
    	
    	System.out.println("Is " + name + " reserved? (Y/N)");
    	boolean reserved = scanner.hasNextLine().trim().equalsIgnoreCase("Y");
    	
    	System.out.println("What is " + name + " 's service country?");
    	String inServiceCountry = scanner.nextLine().trim();
    	
    	Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
    	
    	dogList.add(newDog);      	   
    }
    
    //Created intake to add new monkey to monkeyList
    public static void intakeNewMonkey(Scanner scanner) {
    	System.out.println("What is the monkey's name?");
    	String name = scanner.nextLine().trim();
    	
    	for(Monkey monkey : monkeyList)
    		if(monkey.getName().equalsIgnoreCase(name)) {
    			System.out.println("\n\nThis monkey is alread in the system\n\n");
    			return;
    		}
    	
    	boolean invalidSpecies = true;
    	
    	//Confirm the monkeys species 
    	String species;
    	do {
    		System.out.println("What is " + name + "'s species?");
    		species = scanner.nextLine().trim();
    		
    		for(String validSpecies : Monkey.VALID_SPECIES)
    			if(species.equalsIgnoreCase(validSpecies))
    				invalidSpecies = false;
    		
    		if(invalidSpecies)
    			System.out.println("Invalid species option");
    	} while(invalidSpecies);
    	
    	//Gather information for new monkey
    	System.out.println("What is " + name + "'s gender? (\"male\", \"female\")");
    	String gender = scanner.nextLine().trim().toLowerCase();
    	
    	System.out.println("What is " + name + "'s age?");
    	String age = scanner.nextLine().trim();
    	
    	System.out.println("What is " + name + "'s weight? (in pounds)");
    	String weight = scanner.nextLine().trim();
    	
    	System.out.println("What is " + name + "'s height? (head to toe; in inches)");
    	String height = scanner.nextLine().trim();
    	
    	System.out.println("What is " + name + "'s body length? (head to pelvis; in inches)");
    	String bodyLength = scanner.nextLine().trim();
    	
    	System.out.println("What is " + name + "'s tail length? (base to tip; in inches)");
    	String tailLength = scanner.nextLine().trim();
    	
    	System.out.println("When was " + name + "'s acquired? (MM-DD-YYYY)");
    	String acquisitionDate = scanner.nextLine().trim();
    	
    	System.out.println("Where was " + name + "'s acquired? (Country)");
    	String acquisitionCountry = scanner.nextLine().trim();
    	
    	System.out.println("What is " + name + "'s gender? (\"intake\", \"in service\", \"phase I/II/III/IV/V\", \"farm\")");
    	String trainingStatus = scanner.nextLine().trim();
    	
    	System.out.println("Is " + name + " reserved? (Y/N)");
    	boolean reserved = scanner.hasNextLine().trim().equalsIgnoreCase("Y");
    	
    	System.out.println("What is " + name + " 's service country?");
    	String inServiceCountry = scanner.nextLine().trim();
    	
    	Monkey newMonkey = new Monkey(name, species, gender, age, weight, height, bodyLength, tailLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
    	
    	monkeyList.add(newMonkey);
    	}
    	
    	//Created reservation for new animals
    	public static void reserveAnimal(Scanner scanner) {
    		System.out.println("What type of animal will be needed? (\"dog\", \"monkey\")");
    		String animalType = scanner.nextLine().trim();
    		
    		System.out.println("Where will the animal be serving? (country)");
    		String animalServiceCountry = scanner.nextLine().trim();
    		
    		//Reserve dog
    		if(animalType.equalsIgnoreCase("dog"))
    			for(Dog dog : dogList)
    				if(true
    						&& dog.getInServiceLocation().equalsIgnoreCase(animalServiceCountry)
    						&& !dog.getReserved()
    						&& dog.getTrainingStatus().equalsIgnoreCase("in service")) {    						
    					dog.setReserved(true);
    					dog.setInServiceCountry(animalServiceCountry);
    					
    					System.out.println(dog.getName() +" has been reserved");
    					return;    		
    				}
    		
    		//Reserve monkey
    		if(animalType.equalsIgnoreCase("monkey"))
    			for(MOnkey monkey : monketList)
    				if(true
    						&& monkey.getInServiceLocation().equalsIgnoreCase(animalServiceCountry)
    						&& !monkey.getReserved()
    						&& monkey.getTrainingStatus().equalsIgnoreCase("in service")) {    						
    					monkey.setReserved(true);
    					monkey.setInServiceCountry(animalServiceCountry);
    					
    					System.out.println(monkkey.getName() + " has been reserved");
    					return;
    				}
    		System.out.println("Unable to reserve a " + animalType + " from " + animalServiceCountry +" at this time");
    	}
    	
    	//Print list of animals (dog or monkey)
    	public static void printAnimals(String outputType) {
    		System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t %s%n%n", "Name", "Status", "Acquisition Country", "Reserved");
    		
    		switch(outputType) {
    		case "dog":
    			for(Dog dog : dogList) {
    				String name = dog.getName();
    				String status = dog.getTrainedStatus();
    				String acquisitionCountry = dog.getAcquisitionLocation();
    				boolean reserved = dog.getReserved();
    				
    				System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t %s%n", name, status, acquisitionCountry, reserved);
    			}
    			break;
    			
    		case "monkey":
    			for(Monkey monkey : monkeyList) {
    				String name = monkey.getName();
    				String status = monkey.getTrainedStatus();
    				String acquisitionCountry = monkey.getAcquisitionLocation();
    				boolean reserved = monkey.getReserved();
    				
    				System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t %s%n", name, status, acquisitionCountry, reserved);
    			}
    			break;
    		
    		//Print non reserved dogs
    		case "available":
    			for(Dog dog : dogList) {
    				String name = dog.getName();
    				String status = dog.getTrainedStatus();
    				String acquisitionCountry = dog.getAcquisitionLocation();
    				boolean reserved = dog.getReserved();
    				
    				boolean available = !reserved && status.equalsIgnoreCase("in service");
    				if(!available)
    					continue;
    				
    				System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t %s%n", name, status, acquisitionCountry, reserved);
    			}
    			
    			//Print non reserved monkeys
    			for(Monkey monkey : monkeyList) {
    				String name = monkey.getName();
    				String status = monkey.getTrainedStatus();
    				String acquisitionCountry = monkey.getAcquisitionLocation();
    				boolean reserved = monkey.getReserved();
    				
    				boolean available = !reserved && status.equalsIgnoreCase("in service");
    				if(!available)
    					continue;
    				
    				System.out.printf("%-8.15s\t| %-1.15s\t| %-1.15s\t %s%n", name, status, acquisitionCountry, reserved);
    			}
    			break;
    						
    			}
    	}
}