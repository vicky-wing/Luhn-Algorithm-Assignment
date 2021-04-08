import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class  generateCustomerDataFileCSV {

    public static void generateCustomerDataFile(){
        String firstName = "Rex";
        String lastName = "Chou";
        String city = "Markham";
        String postalCode = "T0A";
        String creditCardNumber = "4111 1111 1111 1111 ";
        String filepath = "cake.txt";

        saveRecord(firstName,lastName,city,postalCode,creditCardNumber,filepath);
    }
    public static void saveRecord(String firstName,String lastName,String city,String postalCode,String creditCardNumber,String filepath)
    {
        try
        {
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(firstName+","+lastName+","+city+","+postalCode+","+creditCardNumber);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null,"Record saved");
        }
        catch(Exception E)
        {
            JOptionPane.showMessageDialog(null,"Record not saved");
        }    
    }
}