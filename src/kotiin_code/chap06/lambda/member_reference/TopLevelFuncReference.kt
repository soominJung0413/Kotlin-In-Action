package kotiin_code.chap06.lambda.member_reference

/**
 *  멤버 참조 구문으로 최상위 함수, 최상위 프로퍼티를 참조하려면, 참조 클래스 없이 :: 뒤에만 기술한다.
 */
fun salute() = println("Salute!")

val topLevelProp = "TopLevelProp: String"

fun main(args: Array<String>) {

    // 1. 함수의 마지막 인자가 멤버참조라면, () 안에 기술
    run(::salute)
    // 2. 함수의 마지막 인자가 람다라면. () 밖에 기술 가능 + 힘수의 유일한 인자가 람다라면, () 생략가능
    run {println("Salute!")}
    // 3. 최상위 프로퍼티 참조도 ::뒤에 기술한다.
    println(::topLevelProp)
    // 4. 해석하면 다음과 같다.
    println {topLevelProp }

}