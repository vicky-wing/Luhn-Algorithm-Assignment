// This file is a draft.



class FeatureCardValidation {
    public static void main (String[] args){
        String cardNum = "5500 0000 0000 0004";
        boolean validCardNum = validateCreditCard(cardNum); // Sends to method (boolean)

        if (validCardNum){
            System.out.println("This card is valid.");
        }
        else{
            System.out.println("This card is invalid.");
        }
    }

    /*
     * Ensures that the credit/debit card number is valid
     */
    public static boolean validateCreditCard(String cardNum){
        String stringCardInput = cardNum.replaceAll(" ", ""); // Removes spaces in the card number

        boolean numbersOnly = checkNumsOnly(stringCardInput); // Checks if String only contains numbers and has 9+ characters
        boolean luhnAlgorithmTest = luhnAlgorithm(stringCardInput);

        if (numbersOnly && luhnAlgorithmTest){
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * Ensures that only numbers were entered
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
     * Luhn Algorithm - base/main
     */
    public static boolean luhnAlgorithm (String cardNum){
        String reverse = reverseOrder(cardNum);
        int sum1 = algorithm1(reverse);
        int sum2 = algorithm2(reverse);
        int grandSum = sum1 + sum2;

        boolean pass = algorithm3(grandSum);

        if (pass){
            return true;
        }
        else{
            return false;
        }
    }
   
    /*
     * Reverses the card number order
     */
    public static String reverseOrder (String entry){
        int length = entry.length(); // 11
        String reverse = "";
        char character;
        String add;

        for (int i = length-1; i >= 0; i--){
            character = entry.charAt(i);
            add = Character.toString(character);
            reverse = reverse.concat(add);
        }

        return reverse;
    }

    /*
     * Takes the sum of all the digits in the odd position numbers and returns it to algorithm main/base
     */
    public static int algorithm1 (String num){
        int length = num.length(); // 11
        int sum = 0;
        char character;

        for (int i = 0; i < length; i+=2){
            character = num.charAt(i);
            sum += Character.getNumericValue(character); // Converts char (character) to int (sum)
        }
        
        return sum; // 42
    }

    /*
     * Takes the digits from the even position numbers and multiply those values by 2
     * If the product is or exceeds 10, the diits in the ones and tens place will be added together
     * (ex. 10 --> 1 + 0 = 1)
     * If the product is 9 or below, nothing happens to the digit
     * Then, all the digits gets sumed to be returned
     */
    public static int algorithm2 (String num){
        int length = num.length();
        char character;
        int sum = 0;
        int digit;
        String twoDigits = "";
        
        for (int i = 1; i < length; i+=2){
            character = num.charAt(i);
            digit = Character.getNumericValue(character); // Converts char (character) to int (digit)
            digit *= 2;

            if (digit >= 10){ // If the number contains 2(+) digits
                twoDigits = Integer.toString(digit); // Converts int (digit) to string (twoDigits)

                for (int j = 0; j < 2; j++){
                    character = twoDigits.charAt(j);
                    digit = Character.getNumericValue(character);
                    sum += digit;
                }
            }
            else{ // If the number contains 1 digit
                sum += digit;
            }
        }

        return sum; // 28
    }

    /*
     * Takes the grand sum of sum1 and sum2.
     * If there is a 0 in the ones palce, method returns true. 
     */
    public static boolean algorithm3 (int grandSum){
        String number1 = Integer.toString(grandSum); // Converts int (num) to string (number)
        int length = number1.length();

        char character = number1.charAt(length-1); // Takes the last character in the string
        String number2 = Character.toString(character); // Converts char (character) to string (number2)

        if (number2.equals("0")){
            return true;
        }
        else{
            return false;
        }
    }
}
  