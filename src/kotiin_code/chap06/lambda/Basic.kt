package kotiin_code.chap06.lambda.member_reference

import kotiin_code.chap06.lambda.syntac_and_rules.Person

/**
 * - 람다식이란 기본적으로 "함수에 넘길 수 있는 코드의 조각"을 뜻한다.
 * 람다를 이용하면, 함수 수준에서 공통부분을 추상화시킬 수 있고, 컬렉션 처리에 유용하다.
 * 1. 코틀린에는 특별한 경우에 사용하는 "수신객체 지정 람다식"이 있다.
 */

/**
 * 람다 문법
 * {...} = 람다블록
 * x:Int, y:Int = 람다 인자
 * -> = 자바 도일
 * x+y = 리턴 값
 *
 */
fun main(args: Array<String>) {
    val people = listOf(Person("one",1), Person("two",2), Person("three",3))

    // 정석
    people.maxByOrNull({ p: Person -> p.age })
    // 람다 블록 선언 시 메서드 호출 기호 생략 가능
    people.maxByOrNull { p: Person -> p.age }
    // 클래스 참조를 위해서는 (..) 안에 :: 참조기호 작성
    people.maxByOrNull(Person::age)
    // 인자의 타입추론기능으로 타입 선언 미필요
    people.maxByOrNull { p -> p.age }
    // 유일 인자의 경우, "it" 사용가능
    people.maxByOrNull { it.age }
    // run 함수로 인자가 없는 람다 초기화와 동시에 호출 가능
    run { println("인자가 없는 람다 호출")}
    // 변수에 저장 가능
    val sum = { x:Int,y:Int -> x+y }
    // 변수 저장 람다 호출시 () 호출 기호 사용
    sum(1,2);
}