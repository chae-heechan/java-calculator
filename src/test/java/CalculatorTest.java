
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private List<Integer> operands = Arrays.asList(2, 4, 3, 7, 5);
    private List<Character> operators = Arrays.asList('+', '-', '*', '/');

    private Calculator calculator = new Calculator();

    @Test
    void calculate() {
        double result;

        result = calculator.calculate(operands, operators);

        assertThat(result).isEqualTo(4.2);
    }

    @Test
    void 사칙연산() {
        double addition, subtraction, multiplication, division, wrongOperatorResult;

        addition = calculator.fourFundamentalArithmeticOperations(operands.get(0), operators.get(0), operands.get(1));
        subtraction = calculator.fourFundamentalArithmeticOperations(operands.get(0), operators.get(1),
                operands.get(1));
        multiplication = calculator.fourFundamentalArithmeticOperations(operands.get(0), operators.get(2),
                operands.get(1));
        division = calculator.fourFundamentalArithmeticOperations(operands.get(0), operators.get(3), operands.get(1));
        wrongOperatorResult = calculator.fourFundamentalArithmeticOperations(operands.get(0), '?', operands.get(1));

        assertThat(addition).isEqualTo(6.0);
        assertThat(subtraction).isEqualTo(-2.0);
        assertThat(multiplication).isEqualTo(8.0);
        assertThat(division).isEqualTo(0.5);
        assertThat(wrongOperatorResult).isEqualTo(0);
    }
}