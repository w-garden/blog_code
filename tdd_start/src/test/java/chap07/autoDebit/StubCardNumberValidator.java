package chap07.autoDebit;

import static chap07.autoDebit.CardValidity.INVALID;
import static chap07.autoDebit.CardValidity.VALID;

public class StubCardNumberValidator extends CardNumberValidator {
    private String invalidNo;

    public void setInvalidNo(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    @Override
    public CardValidity validate(String cardNumber) {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return INVALID;
        }
        return VALID;
    }
}
