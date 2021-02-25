
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationTest {

    private Operation operation;

    @BeforeEach
    void setUp() {
        operation = null;
    }

    @Test
    void validateMixed() {
        String wrongInput = "2/ 3";

        assertThatThrownBy(() -> operation = new Operation(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 String에 숫자와 연산자가 함께 있거나, ");
    }

    @Test
    void validateOtherSymbols() {
        String wrongInput = "( 3 - 4";

        assertThatThrownBy(() -> operation = new Operation(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 연산자 이외의 입력입니다");
    }

    @Test
    void validateFirstIndex() {
        String wrongInput = "- 2 + 1";

        assertThatThrownBy(() -> operation = new Operation(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로 시작해야 합니다.");
    }

    @Test
    void validateDuplicate() {
        String wrongInput = "2 * / 1 + 3";

        assertThatThrownBy(() -> operation = new Operation(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("기호나 숫자가 두 번 연속");
    }

    @Test
    void splitOperation() {
        String input = "2 + -3 * 4 / 2";

        operation = new Operation(input);

        assertThat(operation.getOperands()).isEqualTo(Arrays.asList(2, -3, 4, 2));
        assertThat(operation.getOperators()).isEqualTo(Arrays.asList('+', '*', '/'));
    }
}