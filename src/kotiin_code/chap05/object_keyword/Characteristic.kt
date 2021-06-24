package kotiin_code.chap05.object_keyword

import jdk.nashorn.internal.parser.JSONParser
import jdk.nashorn.internal.runtime.JSONFunctions

/**
 *  companion object , 동반 객체는 클래스 안에 선언된 '일반 객체' 이다.
 *  0. 이름 정의 가능
 *  1. 인터페이스 구현 가능
 *  2. 확장함수 선언 가능
 *  3. 프로퍼티 선언 가능
 */
class PersonNamedCompanion(val name:String) { // 주생성자에 프로퍼티 선언
    companion object Loader { // 동반 객체 생성자 정의 불가
        fun fromJSON(jsonText:String): Person {
            return Person(jsonText)
        }
    }
}

fun main(args: Array<String>) {
    // 동반 객체에 이름이 있을 경우, 동반객체 이름을 기술하여 접근할 수 있다.
    val p1 = PersonNamedCompanion.fromJSON("{name:SooMin}") // 외부 클래스.동반객체함수()

    println(p1)

    // 외부 클래스.동반객체이름.동반객체함수()
    val p2 = PersonNamedCompanion.Loader.fromJSON("{name:SooMin}")

    println(p2)

    // 동반 객체의 이름을 지정하지 않으면 자동으로 Companion 이 된다.
    UserFactory.Companion.newSubscribingUser("doli0413@daum.net")
}