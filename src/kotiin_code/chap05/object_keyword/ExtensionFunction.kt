package kotiin_code.chap05.object_keyword

/**
 * 동반 객체의 함수의 기능을 클래스 내부에서 빼내어 Util 함수로 사용하고 싶은 경우 '동반 객체의 확장함수' 를 정의한다.
 */
class ExtensionFunction(val num:Int) {
    companion object {
        fun test() = println("test")
    }
}

fun ExtensionFunction.Companion.func() = println("동반 객체의 확장함수를 정의했다.")

fun main(args: Array<String>) {
    ExtensionFunction.func() // 동반 객체의 확장함수 호출은 동반객체 함수 호출과 똑같이 생겼다.
    
    ExtensionFunction.test() // 동반 객체의 함수
}