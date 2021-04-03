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
        String algorithmInput = cardNum.replaceAll(" ", ""); // Removes spaces in the card number

        boolean numbersOnly = checkNumsOnly(algorithmInput); // Checks if String only contains numbers and has 9+ characters

        if (numbersOnly){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkNumsOnly(String input){
        String numbers = "0123456789";
        int length = input.length();
        int counter = 0;

        if (length >= 9){
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
}
  