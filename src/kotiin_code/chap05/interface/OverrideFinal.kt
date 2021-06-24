package kotiin_code.chap05.`interface`

open class OverrideFinal: Clickable {
    final override fun click() {
        println("""
            재정의한 함수를 더 이상 재정의하지 못하게하려면 final override 로 선언한다.
        """.trimIndent())
    }

}