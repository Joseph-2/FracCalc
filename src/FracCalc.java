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
            if(equation.equals("quit")){quit = true;}
            else{FracCalc.produceAnswer(equation);}
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
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] parseFraction(String input){
        //declaring all variables that will be returned
        int wholeOne;
        int wholeTwo;
        String[] split = input.split(" ");
        String fractionOne = split[0];
        String fractionTwo = split[2];
        int fracOneNum = 0;
        int fracOneDen = 1;
        int fracTwoNum = 0;
        int fracTwoDen = 1;

        //checks if the fraction input is not just a whole number
        if(fractionTwo.contains("/")){
            //checks if a fraction contains a whole number and parses it accordingly
            if(fractionTwo.contains("_")){
                String[] whole2Split = fractionTwo.split("_");
                wholeTwo = Integer.parseInt(whole2Split[0]);
                fractionTwo = whole2Split[1];
            }else{
                //if fraction does not contain a whole number, set it to zero
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
    }

    public static int[] math(String symbol, int numer1, int denom1, int wholeNum1, int numer2, int denom2, int wholeNum2){
        numer1 += (wholeNum1 * denom1);
        numer2 += (wholeNum2 * denom2);
        int wholeProduct = 0;
        int numProduct = 0;
        int denomProduct;

        if (symbol.equals("+") && denom1 != denom2){
            numer1 *=denom2;
            numer2 *=denom1;
            numProduct = (numer1+numer2);
            denomProduct = (denom1*denom2);
        }else{
            numProduct += (numer1+numer2);
            denomProduct = denom1;
        }
        return new int[]{wholeProduct,numProduct,denomProduct};
    }
    public static int toProper(int wholeNumber, int numer, int denom){

    }
}
