package kotiin_code.chap05.`interface`

/**
 * 추상 클래스 선언 -> abstract class -> : 상속()
 * 추상 함수 선언 -> abstract fun -> override fun
 */
abstract class Animated {
    abstract fun animate()
    
    open fun stopAnimating() {
        println("""
            open fun -> 재정의 가능한 함수
        """.trimIndent())
    }
    
    fun animateTwice(){
        println("""
            fun -> 재정의 불가 함수, final
        """.trimIndent())
    }
}

// 추상 클래스는 super 생성자 호룰해야함.
class ExtensionAnimated():Animated() {
    override fun animate() {
        println("""
            abstract fun 함수의 구현
        """.trimIndent())
    }

    override fun stopAnimating() {
        println("""
            open fun 함수의 재정의
        """.trimIndent())
    }
}

fun main(args: Array<String>) {
    val ea = ExtensionAnimated()
    
    ea.animate() // 추상함수 구현
    ea.stopAnimating() // open 함수 재정의
    ea.animateTwice() // 추상함수 고유 함수
}