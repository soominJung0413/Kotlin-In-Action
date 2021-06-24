@file:JvmName("OpenKeywordKt")

package kotiin_code.chap05.`interface`

open class RichButton: Clickable {
    override fun click() {
        println("""
            1. override 함수는 기본적으로 open 이다.
            2. open 함수, open 프로퍼티는 override 키워드로 재정의 가능하다.
        """.trimIndent())
    }
    open fun animate() {
        println("""
            기본 접근자는 final 이며, open 을 해야 재정의할 수 있다.
        """.trimIndent())
    }

    fun disable() {
        println("""
            open 키워드를 붙이지않은 프로퍼티, 함수는 재정의할 수 없다.
        """.trimIndent())
    }
}

fun main(args: Array<String>) {
    val rBtn = RichButton()

    rBtn.click()
    rBtn.animate()
    rBtn.disable()
}
