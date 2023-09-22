package chap07.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRegisterMockOvercaseTest  {
    private UserRegister userRegister;
    private UserRepository mockRepository = Mockito.mock(UserRepository.class);
    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);


    private UserRepository fakeRepository = new MemoryUserRepository();
    @BeforeEach
    void setUp(){
        userRegister= new UserRegister(mockPasswordChecker,fakeRepository,mockEmailNotifier);
        userRegister= new UserRegister(mockPasswordChecker,mockRepository,mockEmailNotifier);
    }
    @Test
    void noDupId_RegisterSuccess(){
        userRegister.register("id", "pw", "email");

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        BDDMockito.then(mockRepository).should().save(captor.capture());

        User savedUser = captor.getValue();
        assertEquals("id",savedUser.getId());
        assertEquals("email", savedUser.getEmail());

    }
    @Test
    void 같은_ID가_없으면_가입(){
        userRegister.register("id", "pw", "email");
        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }

}
