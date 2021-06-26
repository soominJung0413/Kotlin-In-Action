package kotiin_code.chap06.lambda.member_reference.variable_capture

/**
 * 코틀린은 람다 바깥 함수의 var, val 변수를 참조할 수 있다.
 *  - 람다 바깥함수의 변수가 var 일경우, 데이터를 변경할 수 있으며, val 일경우 가지고 있을 수 있다.
 *
 *  ? 만약 함수가 로컬변수를 포획한 람다를 리턴한다면 어떻게 되는가 ?
 *   - 람다의 본문 코드에 여전히 포획한 변수가 들어있다.
 *   - val 변수의 경우, 람다 코드와함께 "변수의 값"을 저장한다.
 *   - var 변수의 경우, 변수를 Wrapper 로 감싸고 Wrapper 의 참조 값을 람다에 저장하는 것이다.
 */
fun testProcessOfLambda(): () -> Unit {
    var variable = 0
    val value = 0

    return { println("람다에 포확된 변수 , val : ${value} / var : ${variable + 1}")}
}

fun main(args: Array<String>) {
    val isCaptured = testProcessOfLambda()

    isCaptured() // 람다에 포확된 변수 , val : 0 / var : 1
}