package lotto;

import static lotto.LottoNumberConstant.LOTTO_NUMBER_MAX;
import static lotto.LottoNumberConstant.LOTTO_NUMBER_MIN;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void validateBuyingPrice(String input) {
        if (!LottoUtil.isInteger(input)) {
            throw new IllegalArgumentException("구매가격은 정수만 가능합니다");
        }
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("구매가격은 0보다 큰 값만 가능합니다.");
        }
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("구매가격은 1000의 배수만 가능합니다.");
        }
    }

    public static void validateBonusNumber(String input) {
        if (!LottoUtil.isInteger(input)) {
            throw new IllegalArgumentException("보너스 번호는 정수만 가능합니다.");
        }
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호는 1~45값만 가능합니다.");
        }
    }
}
