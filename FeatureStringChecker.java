// This file is a draft



class FeatureStringChecker {
    public static void main(String[] args){
        String fname = "Carl";
        String lname = "Wang";
        String city = "Markham";

        fname = checkStringEntry(fname);
        lname = checkStringEntry(lname);
        city = checkStringEntry(city);

        System.out.println(fname);
        System.out.println(lname);
        System.out.println(city);
    }

    public static String checkStringEntry (String input){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphabet2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int counter = 0;
        int length = input.length();

        for (int i = 0; i < 26; i++){
            String letterCheck = alphabet.substring(i,i+1);
            String letterCheck2 = alphabet2.substring(i,i+1);
           
            for (int j = 0; j < length; j++){
                String characterInput = input.substring(j, j+1);

                if (characterInput.equals(letterCheck)){
                    counter++;
                }
                if (characterInput.equals(letterCheck2)){
                    counter++;
                }
            }
        }

        if (counter == length){
            return input;
        }
        else {
            return "INPUT ERROR, PLEASE TRY AGAIN";
        }
    }
}

/*

*/