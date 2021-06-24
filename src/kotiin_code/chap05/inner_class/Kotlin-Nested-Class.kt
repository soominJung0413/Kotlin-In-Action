@file:JvmName("KoltinNestedClass")
package kotiin_code.chap05.inner_class

class Button: View {
    override fun getCurrentState() = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    // this 키워드로 바깥클래스를 참조할 수 없다, 자바 규칙에 의해, static 클래스에서는 instance 멤버를 절대 참조할 수 없기 때문이다.
    class ButtonState: State { // 코틀린의 중첩 클래스는 기본적으로 static class 로 외부참조가 끊어져있다.
    }
}
