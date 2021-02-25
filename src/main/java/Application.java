import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Operation operation = new Operation(input);
        List<Integer> operands = operation.getOperands();
        List<Character> operators = operation.getOperators();

        Calculator calculator = new Calculator();
        double result = calculator.calculate(operands, operators);
        System.out.println("result = " + result);
    }
}
