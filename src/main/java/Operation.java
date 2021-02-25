
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operation {
    private final String[] operation;
    private List<Integer> operands;
    private List<Character> operators;

    public Operation(String input) {
        this.operation = input.split(" ");
        validateOperation();
        splitOperation();
    }

    public void validateOperation() {
        validateOtherSymbols();
        validateFirstIndex();
        validateDuplicate();
    }

    public void validateOtherSymbols() {
        for (String tempStr : operation) {
            if (!(tempStr.matches("^[0-9]*$") || tempStr.matches("^\\-[1-9]\\d*$") || tempStr.matches("[+*/-]")))
                throw new IllegalArgumentException("한 String에 숫자와 연산자가 함께 있거나, 숫자 연산자 이외의 입력입니다.");
        }
    }

    public void validateFirstIndex() {
        if (operation[0].matches("[+*/-]")) {
            throw new IllegalArgumentException("숫자로 시작해야 합니다.");
        }
    }

    public void validateDuplicate() {
        for (int i = 0; i < operation.length - 1; i++) {
            if ((!operation[i].matches("[+*/-]") && !operation[i + 1].matches("[+*/-]"))
                    || (operation[i].matches("[+*/-]") && operation[i + 1].matches("[+*/-]"))) {
                throw new IllegalArgumentException("기호나 숫자가 두 번 연속 입력되었습니다.");
            }
        }
    }

    public void splitOperation() {
        operands = Arrays.stream(this.operation)
                .filter(operand -> operand.matches("^[0-9]*$") || operand.matches("^\\-[1-9]\\d*$"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        operators = Arrays.stream(this.operation)
                .filter(operator -> operator.matches("[+*/-]"))
                .map(operator -> operator.charAt(0))
                .collect(Collectors.toList());
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public List<Character> getOperators() {
        return operators;
    }
}
