package Day4_071821;

import java.util.SplittableRandom;

public class Split_Command {

    public static void main(String[] args) {

        //using split to extract out keyword john from the string message
        String message = "My name is John_Abc";
        //store the split as array string
        String[] arrayMessage = message.split(" ");
        System.out.println("Name is " + arrayMessage[3]);

        //split arrayMessage[3] to separtate the _ from keyword john
        String[] arrayMessage2 = arrayMessage[3].split("_");
        System.out.println("Actual Name is " + arrayMessage2[0]);
    }//end of main method
}//end of java class
