package kotiin_code.chap05.object_keyword

import kotiin_code.chap05.abstract_property.FacebookUser
import kotiin_code.chap05.abstract_property.SubscribingUser

/**
 * 클래스 외부 정적 Util 함수 => 최상위 함수
 * 클래스 내부 정적 멤버 => 이름없는 companion object
 */
class A {
    companion object {
        fun bar() = println("Companion object called")
    }
}

/**
 * 동반 객체는 자신을 감싸고 있는 외부 클래스의 모든 멤버에 접근 가능하다 [내부 선언이므로]
 * - 펙토리 패턴을 고려한다면, 동반 객체가 알맞다.
 */
class User {
    val nickname:String

    constructor(email:String) {
        nickname = email.substringBefore("@")
    }
    constructor(facebookAccountId:Int) {
        nickname = getFacebookName(facebookAccountId)
    }

    private fun getFacebookName(facebookAccountId: Int) = "Facebook: ${facebookAccountId}"
}
// User 클래스를 펙토리 메서드화 시키기 위해 생성자 대신 펙토리 메서드로 객체를 만든다.
class UserFactory private constructor(val nickname:String) {
    companion object {
        fun newSubscribingUser(email: String) = SubscribingUser(email.substringBefore("@"))
        fun newFaceBookUser(facebookAccountId: Int) = FacebookUser(facebookAccountId)
    }
}

/**
 * JVM 언어의 static 멤버 규칙에 따라서, [companion object 의 멤버는 재정의할 수 없다.]
 */
fun main(args: Array<String>) {
    A.bar() // 동반객체는 정적 멤버를 호출하듯 도트연산자로 호출한다.

    val newFaceBookUser = UserFactory.newFaceBookUser(1)
    val newSubscribingUser = UserFactory.newSubscribingUser("doli0413@gmail.com")

    println(newFaceBookUser.nickname)
    println(newSubscribingUser.nickname)
}