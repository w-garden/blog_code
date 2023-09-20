package mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.*;

public class VoidMethodStubTest {
    @Test
    void voidMethodWillThrowTest(){
        List<String> mockList = mock(List.class);
        willThrow(UnsupportedOperationException.class)
                .given(mockList)
                .add("1")
                ;

        Assertions.assertThrows(
                UnsupportedOperationException.class,
                ()->mockList.add("1")
        );
    }
}
