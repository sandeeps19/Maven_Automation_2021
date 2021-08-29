package Day2_071121;

public class For_loop_with_Array {

    public static void main(String[] args) {

        //iterate through different countries value and print them out in the loop
        String[] countries = new String [5];
        countries[0] = "usa";
        countries[1] = "canada";
        countries[2] = "china";
        countries[3] = "mexico";
        countries[4] = "japan";

        //using for loop to iterate through these values
        for (int i = 0; i < countries.length; i++){

            //print statement
            System.out.println("My country is " + countries[i]);

        }

    }//end of loop


}//end of java class
