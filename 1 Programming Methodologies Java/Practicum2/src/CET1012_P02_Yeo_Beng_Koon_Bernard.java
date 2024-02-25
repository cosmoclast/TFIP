
public class CET1012_P02_Yeo_Beng_Koon_Bernard {
    public static void main(String[] args) {
        //declaration of variables
        Double simpleFinal;
        Double compoundFinal;

        //depending on input is simple or compound, do different calculations
        switch (args[0].strip().toUpperCase()) {
            case "SIMPLE":
                //nested switch to check number of inputs and to perform calculation if correct number of inputs
                switch (args.length){
                    case 4:
                        //declaration of simple interest variables
                        Double principal = Double.parseDouble(args[1]);
                        Double interestRate = Double.parseDouble(args[2]) / 100;
                        Double timePeriod = Double.parseDouble(args[3]);

                        //simple interest formula
                        simpleFinal = principal * (1 + interestRate * timePeriod);
                        
                        //print simple interest output up to 2 decimal places
                        System.out.printf("Final amount is $%.2f", simpleFinal); 
                        break;
                    default:
                        //print error message for missing/extra inputs
                        System.out.println("You did not enter the correct number of inputs");
                }
                break;

            case "COMPOUND":
                //nested switch to check number of inputs and to perform calculation if correct number of inputs
                switch (args.length){
                    case 5:
                        //declaration of compound interest variables
                        Double principal = Double.parseDouble(args[1]);
                        Double interestRate = Double.parseDouble(args[2]) / 100;
                        Integer timePeriod = Integer.parseInt(args[3]);
                        Integer timesPerYear = Integer.parseInt(args[4]);
                        Double base = 1 + interestRate / timesPerYear;

                        //for loop for exponentiation operation
                        for (int exponent = 1; exponent < (timesPerYear * timePeriod); exponent++){
                            base *= (1 + (interestRate / timesPerYear));
                        }

                        //compound interest formula
                        compoundFinal = principal * base;
                        
                        //print simple interest output up to 2 decimal places
                        System.out.printf("Final amount is $%.2f", compoundFinal); 
                        break;
                    default:
                        //print error message for missing/extra inputs
                        System.out.println("You did not enter the correct number of inputs");
                }
                break;

            default:
                //print error message for misspelling of command
                System.out.println("Command not found");
        }

    }
}