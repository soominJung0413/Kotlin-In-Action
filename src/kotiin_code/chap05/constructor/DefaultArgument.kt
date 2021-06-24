package kotiin_code.chap05.constructor

/**
 * 함수와 같이 생성자에서 기본 값을 추가하여 오버로딩 중복을 회피할 수 있다.
 */
class UserDefaultArgs(val nickname:String, val isSubscribed:Boolean = true)

fun main(args: Array<String>) {
    val uda = UserDefaultArgs("onlyNickname")
    println("UserDefaultArgs={${uda.nickname}, ${uda.isSubscribed}}")


    val other = UserDefaultArgs("nickname",false)
    println("UserDefaultArgs={${other.nickname}, ${other.isSubscribed}}")

    val another = UserDefaultArgs("defaultArgs",isSubscribed = true)
}

/**
 * 생성자 파라미터에 기본 값을 전부 넘겨주면, 코틀린 컴파일러가 기본 생성자를 만들어준다.
 * - Spring 등의 프레임워크 객체 생성에는 기본 생성자가 필요한 경우가 종종 있으므로, 기본 생성자
 */
class AllDefaultParameter(val nickname: String = "Anonymous", val isSubscribed: Boolean = false)
