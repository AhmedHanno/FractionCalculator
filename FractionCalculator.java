import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Welcome the user
        System.out.println("Welcome to Fraction Calculator!");
        System.out.println("It will add, subtract, multiply and divide fraction until you type Q to quit.");
        System.out.println("Please enter your fraction in the form a/b, where a and b are integers.");
        System.out.println("-----------------------------------------------------------------------------");

        String Operator = "";
        while(!Operator.equalsIgnoreCase("Q") || !Operator.equalsIgnoreCase("=")) {
            Operator = getOperation(input);
            if (Operator.equalsIgnoreCase("Q") || Operator.equalsIgnoreCase("=")) {
                System.exit(0);
            }
        Fraction frac1 = getFraction(input);
        Fraction frac2 = getFraction(input);
        if (Operator.equalsIgnoreCase("+")) {
            System.out.println(frac1.toString() + " " + Operator + " " + frac2.toString() + " = " + frac1.add(frac2));
        } else if(Operator.equalsIgnoreCase("-")) {
            System.out.println(frac1.toString() + " " + Operator + " " + frac2.toString() + " = " + frac1.subtract(frac2));
        } else if(Operator.equalsIgnoreCase("*")) {
            System.out.println(frac1.toString() + " " + Operator + " " + frac2.toString() + " = " + frac1.multiply(frac2));
        } else if(Operator.equalsIgnoreCase("/")) {
            System.out.println(frac1.toString() + " " + Operator + " " + frac2.toString() + " = " + frac1.divide(frac2));
        }
        }
    }

    public static String getOperation(Scanner input) {
        System.out.print("Please, enter an operation (+, -, /, *, =) or Q to quit: ");
        String Operator = input.nextLine();
        while(!Operator.equalsIgnoreCase("Q") && !Operator.equals("+")&& !Operator.equals("-")&& !Operator.equals("*")&& !Operator.equals("/")&& !Operator.equals("=")) {
            System.out.print("Please, enter an operation (+, -, /, *, =) or Q to quit: ");
            Operator = input.nextLine();
        }
        return Operator;
    }
    public static boolean validFraction(String input) {
        if(input.charAt(0) == '-') {
            int slash = input.indexOf('/');
            if (slash >= 0) {
                return isNum(input.substring(1,slash)) && isNum(input.substring(slash +1)) && !input.substring(slash+1).equals(0);
            } else {
                return isNum(input.substring(1));
            }
        } else {
            int slash = input.indexOf('/');
            if (slash >= 0) {
                return isNum(input.substring(0,slash)) && isNum(input.substring(slash +1)) && !input.substring(slash+1).equals(0);
            } else {
                return isNum(input);
            }
        }
    }
    private static boolean isNum(String subString) {
        int cont = 0;
        if(subString.length() == 0) {
            return false;
        } else {
            for (int i = 0; i < subString.length(); i++) {
                if ((int)subString.charAt(i) < 58 && (int)subString.charAt(i) > 47) {
                    cont++;
                }
            }
            //shows if all the chars are numbers
            return cont == subString.length();
        }
    }
    public static Fraction getFraction(Scanner input) {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String frac = input.nextLine();
        while(!validFraction(frac)) {
            System.out.print("Invalid fraction. ");
            System.out.print("Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            frac = input.next();
        }
        if(frac.contains("/")) {
            int num = Integer.parseInt(frac.substring(0,frac.indexOf('/')));
            int denom = Integer.parseInt(frac.substring(frac.indexOf('/') + 1));
            return new Fraction(num,denom);
        } else {
            int num = Integer.parseInt(frac);
            return new Fraction(num);
        }
    }
}
