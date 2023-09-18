package chap07.autoDebit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static chap07.autoDebit.CardValidity.INVALID;
import static chap07.autoDebit.CardValidity.VALID;

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
        Assertions.assertEquals(INVALID, result.getValidity());
    }
}
//https://github.com/madvirus/tddb/blob/master/chap07/src/test/java/autodebit/StubAutoDebitInfoRepository.java