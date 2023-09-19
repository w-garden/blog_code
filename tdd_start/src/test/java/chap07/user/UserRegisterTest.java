package chap07.user;

import chap07.autoDebit.MemoryAutoDebitInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegisterTest {
    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker, fakeRepository);
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
    void duplicateId() {
        //이미 같은 ID가 존재하는 상황 만들기
        fakeRepository.save(new User("id", "pw", "email@email.com"));
        assertThrows(DupIdException.class, () -> {
            userRegister.register("id", "pw2", "email");
        });
    }

    @DisplayName("같은 ID가 없으면 가입 성공함")
    @Test
    void noDupId_RegisterSuccess(){
        userRegister.register("id", "pw", "email"); //가입

        User savedUser = fakeRepository.findById("id"); //가입 결과 확인
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());

    }
}
