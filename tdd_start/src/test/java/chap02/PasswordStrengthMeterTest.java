package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    void meetsAllCriteria_then_strong(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!ADd",PasswordStrength.STRONG);
    }
    @Test
    void meetsAllCriteria_then_Normal(){
        assertStrength("ab12!@A",PasswordStrength.NORMAL);
        assertStrength("bc12$afs", PasswordStrength.NORMAL);
    }
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        assertStrength("ab!@Aqwer",PasswordStrength.NORMAL);
    }
    @Test
    void nullInput_Then_Invalid(){
        assertStrength(null,PasswordStrength.INVALID);
    }
    @Test
    void emptyInput_Then_Invalid(){
        assertStrength("",PasswordStrength.INVALID);
    }
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }
    @Test
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("asdfasdg",PasswordStrength.WEAK);
    }
    @Test
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("1233414",PasswordStrength.WEAK);
    }
    @Test
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("SASASD",PasswordStrength.WEAK);
    }
    @Test
    void meetsNoCriteria_Then_Weak(){
        assertStrength("asd",PasswordStrength.WEAK);
    }

}
