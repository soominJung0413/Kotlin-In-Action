package kotiin_code.chap06.lambda.member_reference.variable_capture

/**
 *  "변수 포획" 이란, 람다식 안에서  [외부_파라미터], [외부_로컬변수] 를 사용하는 것을 말한다.
 */
fun printMessageWithPrefix(messages:Collection<String>, prefix:String) {

    // 외부 함수의 파라미터 prefix 를 가져올 수 있다.
    messages.forEach{ println("${prefix} ${it}") } // 람다식 타입추론가능 :String + 유일인자
}

fun main(args: Array<String>) {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(messages = errors, prefix = "Error:")
    // 람다식 외부 함수의 prefix 를 이용한 최상위 함수
    /**
     * Error: 403 Forbidden
     * Error: 404 Not Found
     */
}