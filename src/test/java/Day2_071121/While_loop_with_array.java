package Day2_071121;

public class While_loop_with_array {
    public static void main(String[] args) {

       //iterate through different countries values and print them out in the loop
       String[] countries = new String[5];
       countries[0] = "usa";
       countries[1] = "canada";
       countries[2] = "japan";
       countries[3] = "china";
       countries[4] = "india";


       //set the initialzer first
        int i  = 0;
        //call the while loop and define the end point
        while(i < countries.length){
            System.out.println("My country is " + countries[i]);

            //incrementation
            i = i + 1;// same as i++
        }// end of while loop

    }//end of while loop

}// end of java
