package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    @Test
    void meetsAllCriteria_then_strong(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG,result);
        PasswordStrength result2 = meter.meter("abc1!ADd");
        assertEquals(PasswordStrength.STRONG,result);

    }
    @Test
    void meetsAllCriteria_then_Normal(){
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL,result);
    }

}
