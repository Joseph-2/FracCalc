import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        while(!quit) {
            System.out.println("enter equation: ");
            String equation = in.nextLine();
            FracCalc.produceAnswer(equation);
            if(equation.equals("quit")){quit = true;}
        }

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        int[] parsed = parseFraction(input);
        return "whole:" + parsed[3] + " numerator:" + parsed[4] + " denominator:" + parsed[5];
        /*String[] parsed = parseFraction(input);
        String[] fractionOne = parsed[1].split("/");
        String[] fractionTwo = parsed[3].split("/");

        int fracOneWhole = Integer.parseInt(parsed[0]);
        int fracOneNum = Integer.parseInt(fractionOne[0]);
        int fracOneDenom = Integer.parseInt(fractionOne[1]);

        int fracTwoWhole = Integer.parseInt(parsed[3]);
        int fracTwoNum = Integer.parseInt(fractionTwo[0]);
        int fracTwoDenom = Integer.parseInt(fractionTwo[1]);

        return "whole:" + fracTwoWhole + " numerator:"+fracTwoNum+" ";*/
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] parseFraction(String input){
        int wholeOne;
        int wholeTwo;
        String[] split = input.split(" ");
        String fractionOne = split[0];
        String fractionTwo = split[2];
        int fracOneNum = 0;
        int fracOneDen = 1;
        int fracTwoNum = 0;
        int fracTwoDen = 1;

        if(fractionTwo.contains("/")){
            if(fractionTwo.contains("_")){
                String[] whole2Split = fractionTwo.split("_");
                wholeTwo = Integer.parseInt(whole2Split[0]);
                fractionTwo = whole2Split[1];
            }else{
                wholeTwo = 0;
            }
            String[] num2Split = fractionTwo.split("/");
            fracTwoNum = Integer.parseInt(num2Split[0]);
            fracTwoDen = Integer.parseInt(num2Split[1]);

        }else{
            wholeTwo = Integer.parseInt(fractionTwo);
        }

        if(fractionOne.contains("/")){

            if(fractionOne.contains("_")){
                String[] whole1Split = fractionOne.split("_");
                wholeOne = Integer.parseInt(whole1Split[0]);
                fractionOne = whole1Split[1];

            }else{
                wholeOne = 0;
            }
            String[] num1Split = fractionOne.split("/");
            fracOneNum = Integer.parseInt(num1Split[0]);
            fracOneDen = Integer.parseInt(num1Split[1]);

        }else{
            wholeOne = Integer.parseInt(fractionOne);
        }
        return new int[]{wholeOne,fracOneNum,fracOneDen,wholeTwo,fracTwoNum,fracTwoDen};

        /*Scanner fraction = new Scanner(input);
        String wholeOne = "";
        String wholeTwo = "";
        fraction.useDelimiter(" ");
        String fractionOne = fraction.next();
        String operator = fraction.next();
        String fractionTwo = fraction.next();

        if(fractionOne.contains("_")&&fractionOne.contains("/")) {
            Scanner fracOne = new Scanner(fractionOne);
            fracOne.useDelimiter("_");
            wholeOne += fracOne.next();
        }else{wholeOne += "0";}

        if(fractionTwo.contains("_")) {
            Scanner fracTwo = new Scanner(fractionTwo);
            fracTwo.useDelimiter("_");
            wholeTwo += fracTwo.next();
        }else{wholeTwo += "0";}

        return new String[]{wholeOne,fractionOne,operator,wholeTwo,fractionTwo};*/
    }
}
