public class Calculator {
    public static double add(double a, double b){
        return a+b;
    }
    public static double sub(double a, double b){
        return a-b;
    }
    public static double multiply(double a, double b){
        return a*b;
    }
    public static double divide(double a, double b) throws ArithmeticException{
            if (b==0){throw new ArithmeticException("Dzielenie przez zero");}
            return a / b;
    }
}
