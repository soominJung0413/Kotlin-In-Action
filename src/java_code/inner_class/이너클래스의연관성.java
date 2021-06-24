package java_code.inner_class;

import kotiin_code.chap05.inner_class.State;
import kotiin_code.chap05.inner_class.View;


/**
 * 해당 코드는 java.io.NoSerializableException 을 던진다. 왜일까?
 * - 외부 클래스와 이너클래스의 참조가 연결되어 있다.
 * - 이너 클래스를 직렬화 시킨다
 * - 외부 클래스 참조 연관성으로 인해 외부클래스가 java.io.Serializable 을 구현하지 않아 예외가 터진다.
 * - 이너 클래스와 외부 클래스와 연관성이 분리되어야만 이너 클래스를 단독으로 직렬화할 수 있는 것이다.
 */
public class 이너클래스의연관성 implements View {

    @Override
    public State getCurrentState() {
        return new 내부데이터클래스();
    }

    @Override
    public void restoreState(State state) {
        System.out.println();
    }

    class 내부데이터클래스 implements State {

    }
}
