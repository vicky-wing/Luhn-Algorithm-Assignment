// This file is a draft



class FeatureLuhnAlgorithm {
    public static void main (String[] args){
        String num = "5500000000000004";
        String reverse = reverseOrder(num);
        int sum1 = algorithm1(reverse);
        int sum2 = algorithm2(reverse);
        int grandSum = sum1 + sum2;

        boolean luhnAlgorithm = algorithm3(grandSum);

        if (luhnAlgorithm){
            System.out.println("This card is valid");
        }
        else{
            System.out.println("This card is invalid");
        }
    }
   
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

    public static boolean algorithm3 (int grandSum){
        String number1 = Integer.toString(grandSum); // Converts int (num) to string (number)
        int length = number1.length();

        char character = number1.charAt(length-1);
        String number2 = Character.toString(character);

        if (number2.equals("0")){
            return true;
        }
        else{
            return false;
        }
    }
}

/*

    public static boolean checkCardNum(String input){
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
    
            // If counter == parameter's character length after for loop above, it indicates that only numbers were entered
            if (counter == length){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false; // False returned because card has less than 9 digits
        }
    }
*/