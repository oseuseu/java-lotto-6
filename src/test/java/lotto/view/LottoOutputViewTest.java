package lotto.view;

import lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoOutputViewTest {
    private ByteArrayOutputStream capture;
    private PrintStream old;
    private LottoOutputView outputView;

    @BeforeEach
    void setUp() {
        capture = new ByteArrayOutputStream();
        old = System.out;
        System.setOut(new PrintStream(capture));
        outputView = new LottoOutputView();
    }

    @AfterEach
    void restore() {
        System.setOut(old);
    }

    @Test
    void printBuyingPriceInputRequest_테스트() {
        outputView.printBuyingPriceInputRequest();
        assertEquals("구입금액을 입력해 주세요.", capture.toString().trim());
    }

    @Test
    void printBoughtResult_테스트() {
        Lotto input = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        outputView.printBoughtResult(List.of(input));

        assertThat(capture.toString()).contains(
                "1개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]"
        );
    }
}
