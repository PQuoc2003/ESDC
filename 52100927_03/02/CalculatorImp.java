import java.rmi.RemoteException;

public class CalculatorImp implements Calculator {

    @Override
    public void operation(double num1, double num2, String operand) throws RemoteException {

        double result = 0;

        switch (operand) {
            case "+":
                result = num1 + num2;
                System.out.println("The result of " + num1 + " + " + num2 + " is : " + result);
                break;

            case "-":
                result = num1 - num2;
                System.out.println("The result of " + num1 + " - " + num2 + " is : " + result);
                break;

            case "x":
                result = num1 * num2;
                System.out.println("The result of " + num1 + " x " + num2 + " is : " + result);
                break;

            case "/":
                result = num1 / num2;
                System.out.println("The result of " + num1 + " / " + num2 + " is : " + result);
                break;

            default:
                System.out.println("Wrong operand");
                break;
        }

    }

}
