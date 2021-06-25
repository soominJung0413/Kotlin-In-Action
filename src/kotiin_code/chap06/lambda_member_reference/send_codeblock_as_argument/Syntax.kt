package kotiin_code.chap06.lambda_member_reference.send_codeblock_as_argument

/**
 *  코틀린의 함수는 "일급 시민"
 *  1. 람다식 문법은 { ... } 중괄호 안에 선언된다.
 *  2. 람다식 인자는 자바와 달리 () 로 묶지않는다.
 *  3. 자바와달리 익명객체가 아닌 "함수"라서, ()로 바로 호출한다.
 * - 변수호출 -> ()
 * - 블록호출 -> run 함수
 */
fun main(args: Array<String>) {
   val sum = { x:Int, y:Int -> x + y } // 함수형 인터페이스의 형식에 국한되지않고, 자유롭게 만들 수 있다.

    { println("Hello 42") }() // {...} 로 람다를 선언하자마자 () 로 호출한다. -> Hello 42

    /**
     * 람다 코드블록을 바로 호출해야한다면 run 함수를 써라
     */
    run { println("Run Method") } // inline 함수

    // 코틀린 람다는 "함수"라서 "소괄호"로 호출한다.
    println(sum(1,5)) //6
}