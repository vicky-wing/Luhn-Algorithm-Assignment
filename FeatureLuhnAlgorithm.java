// This file is a draft.



class FeatureLuhnAlgorithm {
    public static void main (String[] args){ // NOT MAIN
        String cardNum = "5500 0000 0000 0004";
        boolean validCardNum = validateCreditCard(cardNum);

        if (validCardNum){
            System.out.println("This card is valid.");
        }
        else{
            System.out.println("This card is invalid.");
        }
    }

    /*
     * This method ensures that the inputted 16-digit credit/debit card number is legitimate.
     * 
     * @param String num - This is the 16-digit number inputted by the user
     * @return boolean that indicates if the user has inputted a valid card or not
     */
    public static boolean validateCreditCard(String num){
        num = num.replaceAll(" ", ""); // Removes spaces in the card number

        boolean correctInputCard = correctInputCard(num);

        if (correctInputCard){
            return true;
        }
        else{
            return false; // False returned because the card does not pass the Luhn algorithm
        }   
    }

    /*
     * Ensures that only numbers were inputted for the 16-digit credit/debit card.
     * 
     * @param - 
     * @return - 
     */
    public static boolean correctInputCard(String cardInput){
        try{
            double inputCorrect = Double.parseDouble(cardInput)/2; // Converting the String into a double
            System.out.println(inputCorrect); // To ignore the error message
            return true; // True returned because the user has inputted numbers (A calculation is able to occur)
        }
        catch (Exception e){
            return false; // False returned because the user inputted other types of characteres (A calculation cannot occur)
        }
    }
}
