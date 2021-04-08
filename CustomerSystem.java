// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray

/*
* Date: 2021.04.07 
* Name: Carl Wang and Vicky Li
* Teacher: Mr. Ho
* Description: A program comissioned by a retail company in Canada
*/

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
     * @param Scanner reader - Scanner from main.
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
        //postalCode = validatePostalCode(postalCode); --> I think you might want this line instead once you start working on export file
        cardNum = validateCreditCard(cardNum);

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
     * @author - Carl Wang
     * Ensures that the credit/debit card input number is valid by ensuring that it
     * contains 9 or more digits, and passes Luhn's Algorithm
     * 
     * @param String cardNum - The user's credit/debit card number
     * @return String - Returns a String that is cardNum untouched,
     *                  or INVALID ENTRY, PLEASE TRY AGAIN
     */
    public static String validateCreditCard(String cardNum){
        String stringCardInput = cardNum.replaceAll(" ", ""); // Removes spaces in the card number

        boolean numbersOnly = checkNumsOnly(stringCardInput); // Checks if String only contains numbers and has 9+ characters
        boolean luhnAlgorithm = luhnAlgorithm(stringCardInput); // Checks if cardNum passes Luhn's Algorithm

        if (numbersOnly && luhnAlgorithm){ 
            return cardNum; // cardNum returned because String only contains numbers, and passes Luhn's Algorithm
        }
        else{
            return "INVALID ENTRY, PLEASE TRY AGAIN"; // (Message) returned because String fails requirements
        }
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
     * @param String input - A string that should only consist of alphabet-characters
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
     * @param String input - A string that should only consist of alphabet-characters
     * @return (String) - returns parameter as a String untouched, or a sentence indicating input error 
     *                    (user inputted a non-alphabet character).
    */
    public static String checkStringEntry (String input){
        input = input.replaceAll(" ", ""); // Removes any spaces the string contains, as it only should be one word
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

    /*
     * @author - Carl Wang
     * Ensures that string only contains numbers
     * 
     * @param String input - A string that contains the user's credit/debit card number
     * @return boolean - Returns true if the String only contains digits
     *                   Returns false if the String a or many non-digit character(s)
     */
    public static boolean checkNumsOnly(String input){
        String numbers = "0123456789";
        int length = input.length();
        int counter = 0;

        if (length >= 9){ // Ensures that the number of characters is 9 or greater
            for (int i = 0; i < 10; i++){
                String numCheck = numbers.substring(i,i+1); // Takes the number located at index i from String numbers
                
                for (int j = 0; j < length; j++){
                    String inputDigits = input.substring(j, j+1); // Takes the number located at index j from parameter
    
                    if (inputDigits.equals(numCheck)){ // If the Strings match, add 1 to counter.
                        counter++;
                    }
                }
            }
    
            if (counter == length){
                return true; // String only contains numbers
            }
            else{
                return false; // String contains non-numeric characters
            }
        }
        else{
            return false; // False returned because card has less than 9 digits
        }
    }

    /*
     * @author - Carl Wang
     * Luhn Algorithm - base/main
     * 
     * @param String cardNum - The user's entered card number, a String that only contains digits
     */
    public static boolean luhnAlgorithm (String cardNum){
        String reverse = reverseOrder(cardNum); // Sends cardNum to method to have it's order reversed
        int sum1 = algorithm1(reverse); // Sends the reversed cardNum to check the odd-positioned digits and returns a sum
        int sum2 = algorithm2(reverse); // Sends the reversed cardNum to check the even-positioned digits and returns another sum
        int grandSum = sum1 + sum2; // Adds up the two sums 

        boolean pass = algorithm3(grandSum); // If the ones place contains a 0, then the card number passes Luhn's Algorithm

        if (pass){
            return true; // Card pass Luhn's Algorithm
        }
        else{
            return false; // Card fails Luhn's Algorithm
        }
    }

    /*
     * @author - Carl Wang
     * Reverses the card number order
     * 
     * @param String entry - The user's credit/debt card number
     * @return String reverse - A string that is the card number's digits but reversed in position.
     */
    public static String reverseOrder (String entry){
        int length = entry.length(); 
        String reverse = "";
        char character;
        String add;

        for (int i = length-1; i >= 0; i--){ // Builds a String that will contain the reversed card number
            character = entry.charAt(i);
            add = Character.toString(character);
            reverse = reverse.concat(add);
        }

        return reverse; 
    }

    /*
     * @author - Carl Wang
     * Takes the sum of all the digits in the odd position numbers and returns it to algorithm main/base
     * 
     * @param String num - The reversed card number
     * @return int sum - Integer that is the sum of the odd-positioned numbers
     */
    public static int algorithm1 (String num){
        int length = num.length(); 
        int sum = 0;
        char character;

        for (int i = 0; i < length; i+=2){ // Loop that identifies the odd positioned digits
            character = num.charAt(i);
            sum += Character.getNumericValue(character); // Converts char (character) to int, and adds it to sum
        }
        
        return sum;
    }

    /*
     * @author - Carl Wang
     * Takes the digits from the even position numbers and multiply those values by 2
     * If the product is or exceeds 10, the digits in the ones and tens place will be added together
     * (ex. 10 --> 1 + 0 = 1)
     * If the product is 9 or below, nothing happens to the digit
     * Then, all the digits gets sumed and then returned
     * 
     * @param String num - The reversed credit/debit card number
     * @return int sum - The sum of even positioned digits after specific caluclations
     */
    public static int algorithm2 (String num){
        int length = num.length();
        char character;
        int sum = 0;
        int digit;
        String twoDigits = "";
        
        for (int i = 1; i < length; i+=2){ // Loop that identifies the even positioned digits
            character = num.charAt(i);
            digit = Character.getNumericValue(character); // Converts char (character) to int, sends that value to digit
            digit *= 2; // Multiplies variable by 2

            if (digit >= 10){ // If the number contains 2 digits (has a tens place and an ones place value)
                twoDigits = Integer.toString(digit); // Converts int (digit) to string (twoDigits)

                for (int j = 0; j < 2; j++){ // Loop that separates the ones place value and the tens place value, and adds them
                    character = twoDigits.charAt(j);
                    digit = Character.getNumericValue(character);
                    sum += digit;
                }
            }
            else{ // If the number contains 1 digit
                sum += digit;
            }
        }

        return sum; 
    }

    /*
     * @author - Carl Wang
     * Takes the grand sum of sum1 and sum2.
     * If there is a 0 in the ones palce, method returns true. 
     * The final part of Luhn's Algorithm
     * 
     * @param int grandSum - the sum of part 1 and 2 of Luhn's Algorithm
     * @return boolean - true if the ones place value contain 0
     *                   false if ones palce value does not contain 0
     */
    public static boolean algorithm3 (int grandSum){
        String number1 = Integer.toString(grandSum); // Converts int (num) to string (number)
        int length = number1.length();

        char character = number1.charAt(length-1); // Takes the last character in the string
        String number2 = Character.toString(character); // Converts char (character) to string (number2)

        if (number2.equals("0")){ 
            return true; // True returned because ones place contains 0
        }
        else{
            return false; // False returned because ones place does not contain 0 
        }
    }
}