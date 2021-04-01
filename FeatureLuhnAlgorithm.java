
class FeatureLuhnAlgorithm {
    public static void main (String[] args){
        String cardNum = "5500 0000 0000 0004";
        boolean validCardNum = validateCreditCard(cardNum);

        correctInputCard(cardNum);

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
     * @return 
     */
    public static boolean validateCreditCard(String num){
        num = num.replaceAll(" ", ""); // Removes spaces in the card number
        if ((Double.parseDouble(num))/2 > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static void correctInputCard(String num){
        
    }
}
