package mockito;

import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

/**
 * BDDMockito.then() : 메서드 호출 여부를 검증할 모의 객체를 전달받음.
 * should() : should 메서드 다음에 실제로 불려야 할 메서드를 지정
 * 메서드 호출 횟수 검증하기 위해 제공되는 메서드
 *      only() : 한번만 호출
 *      times(int) : 지정한 횟수만큼 호출
 *      never() : 호출하지 않음
 *      atLeast(int) : 적어도 지정한 횟수만큼 호출
 *      alLeastOnce() : atLeast(1)과 동일
 *      atMost(int) : 최대 지정한 횟수만큼 호출
 */
public class GameTest {
    @Test
    void init(){
        GameNumGen genMock = mock(GameNumGen.class);
        Game game = new Game(genMock);
        game.init(GameLevel.EASY);

        then(genMock).should().generate(GameLevel.EASY);
    }
}
