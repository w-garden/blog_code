package mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;
/**
 mock 메서드로 모의 객체 생성 -> 클래스, 인터페이스, 추상 클래스에 대해 모의 객체를 생성할 수 있다.
 BDDMockito 클래스를 이용해서 모의 객체에 스텁을 구성
 given() : 스텁을 정의할 모의 객체의 메서드 호출을 전달
 willReturn() : 스텁을 정의한 메서드가 리턴할 값을 지정
 willThrow() : 지정한 값 리턴 대신 익셉션을 발생시킴
 */
public class GameGenMockTest {
    @Test
    void mockTest(){
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(GameLevel.EASY)).willReturn("123");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("123",num);
    }
    @Test
    void mockThrowTest(){
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(null)).willThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> genMock.generate(null));
    }

}


