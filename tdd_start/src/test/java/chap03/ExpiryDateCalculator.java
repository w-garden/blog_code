package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한달 뒤가 서비스 만료일이 된다.
 * 2개월 이상 요금을 납부할 수 있다.
 * 10만 원을 납부하면 서비스를 1년 제공한다.
 */
public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = (payData.getPayAmount() / 100_000) * 12 + (payData.getPayAmount() % 100_000 / 10_000);

        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private static LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        if (isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)) {
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            final int dayLenOfCadiMon = lastDayOfMonth(candidateExp);
            if (dayLenOfCadiMon < dayOfFirstBilling)
                return candidateExp.withDayOfMonth(dayLenOfCadiMon);
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else
            return candidateExp;
    }

    private static int lastDayOfMonth(LocalDate candidateExp) {
        return YearMonth.from(candidateExp).lengthOfMonth();
    }

    private static boolean isSameDayOfMonth(LocalDate date1, LocalDate date2) {
        return date1.getDayOfMonth() != date2.getDayOfMonth();
    }
}
