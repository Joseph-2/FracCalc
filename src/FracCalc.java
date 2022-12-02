import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        //continues asking for input until sentinel value is entered
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
        //splits input by whitespace to get both the values as well as the operator
        String[] split = input.split(" ");
        //puts first fractions into the parseFraction method to return an array
        //that will have the separated values of the fraction
        int[] frac1Parsed = parseFraction(split[0]);
        int[] frac2Parsed = parseFraction(split[2]);
        String operator = split[1];
        //feeds newly parsed fractions as well as the operator into the math method, which will calculate
        //an answer based on the operator
        int[] product = math(operator,frac1Parsed[0],frac1Parsed[1],frac1Parsed[2],frac2Parsed[0],
                frac2Parsed[1],frac2Parsed[2]);
        //returns just a whole number in the case that it evenly divides
        if (product[2] == 1){
            return String.valueOf(product[0]);
        }
        //returns zero in the case that any zero is present during multiplication
        else if(product[1] == 0&&product[0] == 0){
            return "0";
        }
        //returns just a fraction if there are no whole numbers
        else if(product[0] == 0){
            return product[1] + "/" + product[2];
        }
        //returns a fraction and a whole number in the case that there is a whole number present
        else {
            return product[0] + "_" + product[1] + "/" + product[2];
        }
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] parseFraction(String input){
        //declaring all variables that will be returned/used
        String fraction = input;
        int wholeParsed;
        int parsedNum;
        int parsedDenom = 1;

        //checks if the fraction input is not just a whole number
        if(input.contains("/")){
            //checks if a fraction contains a whole number and parses it accordingly
            if(input.contains("_")){
                String[] wholeSplit = input.split("_");
                wholeParsed = Integer.parseInt(wholeSplit[0]);
                fraction = wholeSplit[1];
            }else{
                //if fraction does not contain a whole number, set it to zero
                wholeParsed = 0;
            }
            //splits fraction and assigns numerator and denominator to new split values
            String[] numSplit = fraction.split("/");
            parsedNum = Integer.parseInt(numSplit[0]);
            parsedDenom = Integer.parseInt(numSplit[1]);

        }else{
            //if it is just a whole number, set the numerator to zero and keep the denominator one
            parsedNum = Integer.parseInt(input);
            wholeParsed = 0;
        }
        //same as above
        //returns fraction fully parsed
        return new int[]{wholeParsed,parsedNum,parsedDenom};
    }

    public static int[] math(String symbol, int wholeNum1, int numer1, int denom1, int wholeNum2, int numer2, int denom2){
        //first changes to improper fractions
        if (wholeNum1 < 0){
            numer1 *= -1;
        }
        numer1 += (wholeNum1 * denom1);
        if (wholeNum2 < 0){
            numer2 *= -1;
        }
        numer2 += (wholeNum2 * denom2);
        //declares items that will be returned in the list
        int wholeProduct;
        int numProduct = 0;
        int denomProduct = 1;
        //if it is addition, do the added method and change numProduct and denomProduct accordingly
        if (symbol.equals("+")){
            int[] added = add(numer1,denom1,numer2,denom2);
            numProduct = added[0];
            denomProduct = added[1];
        }
        if (symbol.equals("-")){
            int[] subtracted = subtract(numer1, denom1, numer2, denom2);
            numProduct = subtracted[0];
            denomProduct = subtracted[1];
        }
        if (symbol.equals("*")){
            int[] multiplied = multiply(numer1,denom1,numer2,denom2);
            numProduct = multiplied[0];
            denomProduct = multiplied[1];
        }
        if (symbol.equals("/")){
            int[] divided = divide(numer1,denom1,numer2,denom2);
            numProduct = divided[0];
            denomProduct = divided[1];
        }
        wholeProduct = numProduct/denomProduct;
        if (Math.abs(numProduct) > denomProduct) {
            numProduct = numProduct - wholeProduct * denomProduct;
        }
        int GCD = euclidGCD(numProduct,denomProduct);
        if(wholeProduct < 0) {
            return new int[]{wholeProduct, Math.abs(numProduct / GCD), Math.abs(denomProduct / GCD)};
        }
        else{return new int[]{wholeProduct, numProduct / GCD, Math.abs(denomProduct / GCD)};}
    }
    public static int euclidGCD(int num1,int num2){
        if (num2==0){return num1;}
        return euclidGCD(num2,num1%num2);
    }

    public static int[] subtract(int numer1, int denom1, int numer2, int denom2){
        int numProduct;
        int denomProduct;
        if(denom1!=denom2) {
            numer1 *= denom2;
            numer2 *= denom1;
            numProduct = (numer1 - numer2);
            denomProduct = (denom1 * denom2);
        }else{
            numProduct = numer1-numer2;
            denomProduct = denom1;
        }
        return new int[]{numProduct, denomProduct};
    }

    public static int[] divide(int numer1, int denom1, int numer2, int denom2){
        int numProduct;
        int denomProduct;
        numProduct = (numer1 * denom2);
        denomProduct = (numer2 * denom1);
        return new int[]{numProduct,denomProduct};
    }

    public static int[] multiply(int numer1, int denom1, int numer2, int denom2){
        int numProduct;
        int denomProduct;
        numProduct = (numer1 * numer2);
        denomProduct = (denom1 * denom2);
        return new int[]{numProduct,denomProduct};
    }
    public static int[] add(int numer1, int denom1, int numer2, int denom2){
        int numProduct;
        int denomProduct;
        if(denom1!=denom2) {
            numer1 *= denom2;
            numer2 *= denom1;
            numProduct = (numer1 + numer2);
            denomProduct = (denom1 * denom2);
        }else{
            numProduct = numer1+numer2;
            denomProduct = denom1;
        }
        return new int[]{numProduct, denomProduct};
    }
}