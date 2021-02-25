
import java.util.List;

public class Calculator {

    public double calculate(List<Integer> operands, List<Character> operators) {
        double result = operands.get(0);
        int numOfOperations = operators.size();
        int times = 0;

        while (times < numOfOperations) {
            result = fourFundamentalArithmeticOperations(result, operators.get(times), operands.get(++times));
        }

        return result;
    }

    public double fourFundamentalArithmeticOperations(double tempResult, char operator, double operand) {
        double result;

        switch (operator) {
            case '+':
                result = tempResult + operand;
                break;
            case '-':
                result = tempResult - operand;
                break;
            case '*':
                result = tempResult * operand;
                break;
            case '/':
                result = tempResult / operand;
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }
}
