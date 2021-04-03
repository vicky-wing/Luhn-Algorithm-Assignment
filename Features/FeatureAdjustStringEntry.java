// This file is a draft

class FeatureAdjustStringEntry {
    public static void main(String[] args){
        String entry = "cARL";
        int length = entry.length();

        String firstChar = entry.substring(0,1); // Takes the string's first character
        firstChar = firstChar.toUpperCase(); // Capitalizes the string's first character

        String restChar = entry.substring(1,length); // Takes the string's remaining characters
        restChar = restChar.toLowerCase(); // Sets the remaining characters to lower case

        String adjusted = firstChar + restChar;

        System.out.println(adjusted);
    }
}
