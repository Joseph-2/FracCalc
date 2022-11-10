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
        String[] parsed = parseFraction(input);
        return "whole: " + parsed[0] + "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String[] parseFraction(String input){
        Scanner fraction = new Scanner(input);
        String wholeOne = "";
        String wholeTwo = "";
        fraction.useDelimiter(" ");
        String fractionOne = fraction.next();
        String fractionTwo = fraction.next();

        if(fractionOne.contains("_")) {
            Scanner fracOne = new Scanner(fractionOne);
            fracOne.useDelimiter("_");
            wholeOne += fracOne.next();
        }else{wholeOne += "0";}

        if(fractionTwo.contains("_")) {
            Scanner fracTwo = new Scanner(fractionTwo);
            fracTwo.useDelimiter("_");
            wholeTwo += fracTwo.next();
        }else{wholeTwo += "0";}

        return new String[]{wholeOne,fractionOne,wholeTwo,fractionTwo};
    }
}
