package Day2_071121;

public class Action_Item {
    public static void main(String[] args) {


        //Setup variables for dynamic array
        String[] zipcode;
        int[] street;
        zipcode = new String[5];
        zipcode[0] = "11122";
        zipcode[1] = "23988";
        zipcode[2] = "39987";
        zipcode[3] = "39993";
        zipcode[4] = "38777";

        street = new int[5];
        street[0] = 129;
        street[1] = 130;
        street[2] = 128;
        street[3] = 5;
        street[4] = 50;

        for (int i = 0; i < 5; i++){

            //getting the length of the variable
            System.out.println(" My street is " + street[i] + " my zipcode is " + zipcode[i]);

        }
    }//end of main
}//end of Action Item