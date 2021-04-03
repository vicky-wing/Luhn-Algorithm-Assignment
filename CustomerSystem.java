// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
// More packages may be imported in the space below

class CustomerSystem{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below
        // String customerInfo;

        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                enterCustomerInfo(reader); // Scanner reader gets sent to method enterCustomerInfo()
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile();
                // Probably need a method to check if the user inputted anything invalid?
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }

    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }

    /*
     * @author - Carl Wang
     * User will enter their personal information here.
     * 
     * @param reader - Scanner from main.
     * May need to switch into a return string?
    */
    public static void enterCustomerInfo(Scanner reader) { 

        System.out.println("Enter your information below.");
        System.out.println("First name:");
        String firstName = reader.nextLine();

        System.out.println("Last name:");
        String lastName = reader.nextLine();

        System.out.println("City:");
        String city = reader.nextLine();

        System.out.println("Postal code:");
        String postalCode = reader.nextLine();

        System.out.println("Credit card number:");
        String cardNum = reader.nextLine();

        // Adjusts capitalizations of entries (sends to method)
        firstName = adjustStringEntry(firstName);
        lastName = adjustStringEntry(lastName);
        city = adjustStringEntry(city);
        
        // Ensures that only alphabet characters were inputted (sends to method)
        firstName = checkStringEntry(firstName);
        lastName = checkStringEntry(lastName);
        city = checkStringEntry(city);

        // Ensures that postal code and card number are valid
        validatePostalCode(postalCode);
        validateCreditCard(cardNum);

        // Prints the entered information
        System.out.println("Returning to main menu.");
        System.out.println("----------------");
        System.out.println("Your entered information:");
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("City: " + city);
        System.out.println("Postal Code: " + postalCode);
        System.out.println("Credit/Debit card number: " + cardNum);
        System.out.println("----------------");

        //return firstName + " " + lastName + " " + city + " " + postalCode + " " + cardNum;
    }

    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(String x){
    }

    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validateCreditCard(String x){
    }

    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(){
    }

    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/

    /*
     * @author - Carl Wang
     * Adjusts the capitalization of the following strings: firstName, lastName and city
     * to follow adaquate capitalization.
     * 
     * @param input - A string that should only consist of alphabet-characters
     * @return String firstChar + restChar - String that contains proper capitalization
     *                                       of first name/last name/city name
    */
    public static String adjustStringEntry(String input){ 
        int length = input.length();

        String firstChar = input.substring(0,1); // Takes the string's first character
        firstChar = firstChar.toUpperCase(); // Capitalizes the string's first character

        String restChar = input.substring(1,length); // Takes the string's remaining characters
        restChar = restChar.toLowerCase(); // Sets the remaining characters to lower case

        return firstChar + restChar;
    }

    /*
     * @author - Carl Wang
     * Checks the strings: firstName, lastName and city to verify if only alphabet characters
     * were used during input.
     * 
     * @param input - A string that should only consistent of alphabet-characters
     * @return (String) - returns parameter as a String untouched, or a sentence indicating input error 
     *                    (user inputted a non-alphabet character).
    */
    public static String checkStringEntry (String input){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphabet2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int counter = 0;
        int length = input.length();

        for (int i = 0; i < 26; i++){
            String letterCheck = alphabet.substring(i,i+1); // Takes the character in index i from the lower case alphabet string
            String letterCheck2 = alphabet2.substring(i,i+1); // Take the character in index i from the upper case alphabet string
           
            for (int j = 0; j < length; j++){
                String characterInput = input.substring(j, j+1); // Takes the character in index j from parameter

                // If an alphabet is found in index, add 1 to integer variable counter.
                if (characterInput.equals(letterCheck)){ // Checks for lowercase
                    counter++;
                }
                if (characterInput.equals(letterCheck2)){ // Checks for uppercase
                    counter++;
                }
            }
        }

        // If the counter is equal to the number of characters in parameter, return parameter untouched
        // If the counter is not equal, it indicates that the user has entered a character such as 123 or !@#
        if (counter == length){
            return input;
        }
        else {
            return "INVALID ENTRY, PLEASE TRY AGAIN";
        }
    }
}