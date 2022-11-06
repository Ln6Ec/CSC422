/**
 * CSC422 Software Engineering
 * Week 1 Assignment 1
 * Nathaniel Turner
*/

/** EXPLANATION OF REQUIREMENTS:
* This assignment will give you practice of using version control such as git to manage changes of your code
* and to give you experience of incremental development.
* 
* For the purpose of this assignment, you will create a basic database program for managing information (name and age) about pets.
* The database allows the user to add pet information to the database, remove information, update pet information,
* and search for pets by name or by age.
* You can assume the user only inputs pet names consisting of a single word.
* Error handling is optioal.
* 
* You will build this program incrementally. 
* For each increment, you will create a release that the user can download and run.
* You will use git and GitHub to track the changes and to create releases.
* 
* *THE PROGRAM*
* You will create a pet database program with the following operations incrementally as described in the Milestones section.
* You are not requried to save the pet data into a file.
* You must use appropriate design and make use of Object-Oriented Design.
* See Milestones.
*  Add pets:
*     >Let the user add as many pets as they want.
*      A pet is entered as a single line consisting of a name and an integer which represents the age of the pet.
*      The user types "done" to end reading.
*  Show pets:
*     >Prints a table of all pets in the database.
*      See below or the for the formatting of the table.
*  Update pets:
*     >Shows the user a table of all the pets and reads the pet ID that the user wants to update.
*      ID is the array index of the object.
*      Once the user has selected a pet by typing an ID, it asks the user to enter the new name and new age.
*      It then updates the actual object.
*  Search pets by name or age
*     >Prompts the user for a name and then displays a table showing all pets matching the name.
*      The name is case insensitive.
*      For example, "boomer" will show "Boomer"
*     >Prompts the user for an age and shows a table consisting of pets with that age.
*  Remove a pet
*     >Prompts the user for the index of the pet to delete
* 
* *TABLE FORMATTING*
* Your program will display the results for view all pets, search pet by name and search pet by age using a table as shown below.
* You will need to use System.out.printf() to format the table.
* Below is a sample table with annotations as to which part is the header, rows, and footer.
* A row represents a single record about a pet. The ID is the index in the array the object is located.
* A table consists of zero or more rows. You may use 3 characters for ID, 10 characters for NAME, and 4 characters for AGE.
* 
* +----------------------+ \
* | ID | NAME      | AGE |  } header
* +----------------------+ /
* |  0 | Kitty     |   8 | \
* |  1 | Bruno     |   7 | |
* |  2 | Boomer    |   8 |  } rows
* |  3 | Boomer    |   3 | |
* |  4 | Fiesty    |   3 | /
* +----------------------+ \
* 5 rows in set.            } footer
* 
* *MILESTONES*
* You will create three releases with the functionality described below:
* Release 1: Your program should allow adding and displaying of pets.
* Release 2: Your program should allow searching of pets.
* Release 3: Your program should allow for updating and removing pets.
* 
* *SUBMISSION*
* Copy the URL for your repository and paste it in the document for Assignment 1 part 1.
* You should have three releases.
* 
* *GRADING*
* Your grade will be based on the completion of each release and the quality of your design and code.
* 
*      Grading Rubric
*      Item            Weight
*      Release 1       25%
*      Release 2       25%
*      Release 3       25%
*      Quality         25%
*/

import java.util.Scanner;

class Pet {
    private String name;
    private int age;
    
    Pet(String newName, int newAge) {
        newName = name;
        newAge = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class PetDatabase {
    static int userChoice;
    static int petCount = 0;
    static int i = 0;
    static int j = 0;
    static String[][] pet = new String[100][100];

    public static void main(String[] args) {
        boolean cont = true;
        Scanner s = new Scanner (System.in);

        System.out.println("Pet Database Program");


        while (cont == true) {
            getUserChoice();

            switch (userChoice) {
                default:
                    System.out.println("Input not recognized, try again.");
                    break;
                case 1:
                    showAllPets();
                    break;
                case 2:
                    addPets();
                    break;
                case 3:
                    System.out.println("Work in progress!");
                    break;
                case 4:
                    System.out.println("Work in progress!");
                    break;
                case 5:
                    System.out.println("Work in progress!");
                    break;
                case 6:
                    System.out.println("Work in progress!");
                    break;
                case 7:
                    System.out.println("\nGoodbye!");
                    cont = false;
                    break;
            }
        }
        s.close();
    }

    /** getUserChoice: Code that provides user with main menu and records their choice */
    private static int getUserChoice() {
        Scanner s = new Scanner (System.in);

        System.out.println("\nWhat would you like to do?\n");
        System.out.println("1) View all pets");
        System.out.println("2) Add more pets");
        System.out.println("3) Update an existing pet");
        System.out.println("4) Remove an existing pet");
        System.out.println("5) Search pets by name");
        System.out.println("6) Search pets by age");
        System.out.println("7) Exit program");

        System.out.print("\nYour choice: ");
        userChoice = s.nextInt();

        s.close();
        return userChoice;
    }

    /** showAllPets: runs printTableHeader, printTableRow, and printTableFooter to print out the list of names */
    private static void showAllPets() {
        printTableHeader();
        printTableRow();
        printTableFooter();
    }

    /** addPets: adds the name of a pet and their age to the database as an array pair */
    private static void addPets() {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        String line = "";
        String petName;
        String petAge;

        System.out.println("Type 'done' when finished");
        
        while (run == true) {
            System.out.print("add pet (name, age): ");
            line = input.nextLine().trim();
            
            if (line.equals("done")) {
                run = false;
                break;
            }

            petName = line.substring(0, line.indexOf(" "));
            petAge = line.substring(line.indexOf(" ")+1);

            pet[i][j] = petName;
            j++; // Index to next column in same row (since there's only two columns it didn't seem to make sense to use a loop.)
            pet[i][j] = petAge;
            
            i++; // Index to next row
            j--; // Reset column number for next pet

            petCount++; // Increase petCount number
        }
        input.close();
    }

    /** printTableHeader: prints out the header of the pet database table */
    private static void printTableHeader() {
        System.out.println("+----------------------+");
        System.out.println("| ID | NAME\t| AGE |");
        System.out.println("+----------------------+");
    }

    /** printTableRow: counts how many pets are in the database and prints out a table row for each pet */
    private static void printTableRow() {
        for (int r = 0; r < petCount; r++) {
            System.out.print("| "+r+" |");
            for (int c = 0; c < 2; c++) {
                System.out.print(" " + pet[r][c] + " | ");
            }
            System.out.println("");
        }
    }

    /** printTableFooter: prints the footer of the pet database */
    private static void printTableFooter() {
        System.out.println("+----------------------+");
        System.out.println(petCount + " rows in set.");
    }
}