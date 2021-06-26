package kotiin_code.chap06.lambda.member_reference

import kotiin_code.chap05.object_keyword.Person

fun sendMail(person: Person, message:String) = println("Mail send To ${person}, Meessage: ${message}") // 최상위함수
fun Person.greeting() = println("Hello, ${name}") // 확장함수

/**
 *  람다식 내부에서 단순히 다른 함수만을 호출한다면, 멤버참조가 알맞다.
 */
fun main(args: Array<String>) {

    val action = {p:Person, message:String -> sendMail(p,message) } // 단순히 람다 내부에서 메서드 위임호출만을 한다면
    val referenceAction = ::sendMail // 멤버참조가 알맞다.

    // 생성자 함수도 참조하여 저장할 수 있다.
    val constructorReference = ::Person// 생성자 참조는 "::클래스명" 으로한다.
    val soomin = constructorReference("soomin")
    println(soomin) // Person(name=soomin)

    // 확장함수 참조는 멤버 함수 호출과 문법이 같다.
    val greetingFunc = Person::greeting
    greetingFunc(soomin) // Hello, soomin

    /**
     * "바운드 멤버 참조" 를 사용하여, 객체의 함수, 프로퍼티를 저장할 수 있다.
     */
    val holo = Person("Holoman")
    val boundGetNameReference = holo::name

    println(boundGetNameReference()) // Holoman
}