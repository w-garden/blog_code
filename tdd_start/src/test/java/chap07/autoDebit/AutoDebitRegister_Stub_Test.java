package chap07.autoDebit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chap07.autoDebit.CardValidity.INVALID;
import static chap07.autoDebit.CardValidity.THEFT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Stub_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @BeforeEach
    void SetUp(){
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository);
    }
    @Test
    void invalidCard(){
        stubValidator.setInvalidNo("111122223333");
        AutoDebitReq req = new AutoDebitReq("user1","111122223333");
        RegisterResult result = register.register(req);
        assertEquals(INVALID, result.getValidity());
    }

    @Test
    void theftCard(){
        stubValidator.setTheftNo("1234567890123456");

        AutoDebitReq req = new AutoDebitReq("user1","1234567890123456");
        RegisterResult result = this.register.register(req);
        assertEquals(THEFT, result.getValidity());
    }
}
