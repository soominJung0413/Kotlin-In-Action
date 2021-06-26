package kotiin_code.chap06.lambda.member_reference.variable_capture

/**
 *
 */
fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    val test = 9
    responses.forEach {
        if(it.startsWith("4")) { // 람다의 유일인자 : String => it
            clientErrors ++ // 람다식 내부에서 var 변수 포획가능
            println(test) // val 변수도 사용 가능
        } else if (it.startsWith("5")){
            serverErrors ++
        }
    }
    println("${clientErrors} client errors, ${serverErrors} server errors")
}
fun main(args: Array<String>) {
    val responses = listOf("200 OK","418 I'm  a teapot","500 Internal Server Error")
    println(printProblemCounts(responses))
    //1 client errors, 1 server errors
}