/*
    * @author - Vicky Li
    * Ensures that the postal code 3 or more characters – validation is required
    */
public class validatePostalCodeTest{
    public static void main(String[] args){
        Scanner kb = new Scanner (System.in);
        System.out.println("Please enter postalcode:");
        while (kb.hasNext()){
            String posCode = kb.next();
            if (posCode.length() > 7)
                System.out.println("\nInvalid");
            if (posCode.length() < 6)
                System.out.println("\nInvalid");
            if (posCode.length() == 7){
                boolean valid = true;
                for (int i = 0; i < posCode.length(); i++){
                    char a = posCode.charAt(0);
                    char b = posCode.charAt(2);
                    char c = posCode.charAt(4);
                    char d = posCode.charAt(1);
                    char e = posCode.charAt(5);
                    char f = posCode.charAt(6);
                    char g = posCode.charAt(3);
                    if(! Character.isLetter(b))
                        valid = false;
                    else if (! Character.isDigit(c))
                        valid = false;
                    else if (! Character.isDigit(d))
                        valid = false;
                    else if (! Character.isDigit(e))
                        valid = false;
                    else if (! Character.isDigit(f))
                        valid = false;
                    else if (! Character.isWhitespace(g))
                        valid = false;
                    break;
                }
                if (valid) System.out.println("\nvalid");
                else System.out.println("\nInvalid");
            }
            if (posCode.length()== 6){
                boolean valid = true;
                for (int i = 0; i < posCode.length(); i++){
                    char a = posCode.charAt(0);
                    char b = posCode.charAt(2);
                    char c = posCode.charAt(4);
                    char d = posCode.charAt(1);
                    char e = posCode.charAt(3);
                    char f = posCode.charAt(5);
                    if(! Character.isLetter(a))
                        valid = false;
                    else if (! Character.isLetter(b))
                        valid = false;
                    else if (! Character.isLetter(b))
                        valid = false;
                    else if (! Character.isLetter(c))
                        valid = false;
                    else if (! Character.isLetter(d))
                        valid = false;
                    else if (! Character.isLetter(e))
                        valid = false;
                    else if (! Character.isLetter(f))
                        valid = false;
                    break;
                }
                if (valid) System.out.println("\nValid");
                else System.out.println("\nInvalid");
            }
            System.out.println("\nPlease enter a postalcode");
         }
         System.out.println("Program ending due to end-of-file");
        }
    }
}

































    
