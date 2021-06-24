package kotiin_code.chap05.property_visibility_modifier

/**
 * 코틀린의 접근자메소드의 가시성은 기본적으로 , 프로퍼티의 가시성과 같다.
 *
 * 원하는 바에 의하여, 접근자의 가시성을 바꾸고 싶을경우, 접근자메소드 앞에 가시성을 붙여주자
 */
class LengthCounter{
    var counter:Int = 0
    private set // Setter 메서드의 접근자를 private 로 선언

    fun addWord(word:String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val lc = LengthCounter()

    lc.addWord("Kotlin")

    println(lc.counter)
}