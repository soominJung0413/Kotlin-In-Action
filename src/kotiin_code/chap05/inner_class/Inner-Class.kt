@file:JvmName("InnerClass")
package kotiin_code.chap05.inner_class

class InnerButton:View {
    override fun getCurrentState() = InnerButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    // 코틀린에서 바깥 클래스에 대한 참조를 얻기위해서는 inner 키워드를 붙인다 > class ~
    inner class InnerButtonState:State {
        // inner class 에서 바깥클래스를 참조하기 위해서는 this@[바깥클래스] 로 선언한다.
        fun print() = println(this@InnerButton.getCurrentState())
    }
}

fun main(args: Array<String>) {
    val innerButton = InnerButton()

    val innerButtonState = innerButton.InnerButtonState() // inner 클래스를 호출하듯 바깥 인스턴스에서 내부인스턴스를 하나 더 만든다.

    //kotiin_code.chap05.inner_class.InnerButton$InnerButtonState@45ee12a7
    innerButtonState.print() // 바깥 참조가 되고있다.
}