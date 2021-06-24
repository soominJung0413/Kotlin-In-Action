package kotiin_code.chap05.`interface`

interface Focusable {
    fun setFocus(b:Boolean) = println("I ${if (b) "got" else "lost"} focus") // default 함수

    fun showOff() = println("I'm Focusable!") // default 함수
}

/**
 * 구현할 함수 시그니쳐가 동일할 경우, 반드시 해당 함수를 재정의 해야만한다.
 */
class Btn:Clickable,Focusable { // 다중 구현
    override fun click() = println("I was clicked") // open 함수의 재정의는 override 키워드로 한다.
    override fun showOff() {
        // 구현할 함수의 이름이 같다 -> 반드시 재정의 해야한다.

        // super<SuperClass>.method() 로 기존 super 클래스의 함수를 가져올 수 있다.
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(args: Array<String>) {
    val multiImpl = Btn()

    multiImpl.click()
    multiImpl.showOff() // 중복되는 구현 함수는 반드시 재정의한다.
    """
        I'm Clickable
        I'm Focusable!
    """.trimIndent()
}