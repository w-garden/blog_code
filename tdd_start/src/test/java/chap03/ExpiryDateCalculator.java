package chap03;

import java.time.LocalDate;

/**
 * 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한달 뒤가 서비스 만료일이 된다.
 * 2개월 이상 요금을 납부할 수 있다.
 * 10만 원을 납부하면 서비스를 1년 제공한다.
 */
public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        if (payData.getFirstBillingDate() != null) {
          LocalDate candidateExp = payData.getBillingDate().plusMonths(1);
          if(payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()){
              return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
          }
        }

        return payData.getBillingDate().plusMonths(1);
    }
}
