package chap07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterTest {
    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        stubWeakPasswordChecker.setWeak(true); //약한 암호로 설정

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }
    @DisplayName("동일 ID를 가진 회원 존재하면 가입 실패")
    @Test
    void duplicateId(){}
}
