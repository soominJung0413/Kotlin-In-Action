package kotiin_code.chap05.inner_class

import java.io.Serializable

/**
 * 코틀린의 중첩클래스는 기본적으로 static class 로, 외부 참조를 가지지못한다.
 * - 외부 참조를 가지기 위해서는 inner 키워드를 명시해야한다.
 * - 도우미 클래스와의 연관관계를 분리시킨다.
 */
interface State:Serializable // 도우미 인터페이스로, View 인터페이스 안에서 데이터를 담고 있는 객체를 생성

interface View {
    fun getCurrentState():State // 추상함수

    fun restoreState(state: State) {} // default 함수
}

