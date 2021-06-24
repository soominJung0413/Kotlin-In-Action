package kotiin_code.chap05.abstract_property

/**
 * 코틀린에는 [추상 프로퍼티] 라는 개념이 존재한다.
 * - 추상 프로퍼티는 말그대로 추상적인 형식이다.
 * - 하위 클래스에서 뒷받침하는 필드가 있던, 커스텀 게터를 선언하던, 초기화 식을 작성하던 방법을 자유롭게 찾는다.
 * - 하지만, 반드시 프로퍼티의 값을 얻는 방법을 정의해야만한다
 */
interface User {
    val nickname:String // 추상 프로퍼티, 하위에서 어떻게든 값을 구하는 방법을 정의해야한다.
}

class PrivateUser(override val nickname: String):User // override 키워드로 재정의, 뒷받침하는 프로퍼티형식으로 작성

class SubscribingUser(val email:String) :User {
    override val nickname: String // override 키워드로 작성
    get() = email.substringBefore("@") // 커스텀 게터로 작성
}


/**
 * 추상 프로퍼티에 초기화 값을 주는 것은, 뒷받침하는 필드에 결과 값을 저장하는 것이 된다.
 * 그러므로, 객체 초기화 시 [단 한번만 호출된다.]
 */
class FacebookUser(val accountId:Int) :User {
    override val nickname: String = getFacebookName(accountId) // override 키워드로 재정의, 다른 함수호출로 작성

    private fun getFacebookName(accountId: Int)  = "SooMin"
}

interface CustomGetter{
    val name:String
    get() = email.substringBefore("@") // 매번 값을 계산해서 넘겨주며, 재정의할 필요가 없다.
    val email:String // 값을 계산하는 방법을 반드시 재정의 해야한다.
}

fun main(args: Array<String>) {
    println(PrivateUser("test@kotlinang.org").nickname)

    println(SubscribingUser("test@kotlinang.org").nickname)
}