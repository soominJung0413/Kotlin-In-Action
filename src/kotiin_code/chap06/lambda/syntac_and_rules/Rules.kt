package kotiin_code.chap06.lambda.syntac_and_rules

/**
 * 코틀린 람다식 세부 규칙에 대해 다룬다.
 */
fun main(args: Array<String>) {
    val people = listOf(Person("one",1), Person("two",2), Person("three",3))

    people.maxByOrNull() {it.age}  // 함수의 마지막 인자가 람다식이라면, 가독성을 위해 () 밖으로 뺄 수 있다.

    people.maxByOrNull { p: Person -> p.age } // 함수의 유일한 인자가 람다식이라면, { ... } 만 쓸 수 있다.

    // .joinToString() 함수의 마지막인자는 "함수"이다. 즉, 람다식을 사용할 수 있다.
    val joinToString = people.joinToString(separator = " ", transform = { it.name }) // 유일인자, 타입 추론
    println(joinToString) //one two three

    // "함수의 마지막 인자가 함수"라면, () 밖으로 함수인자를 뺴낼 수 있다.
    val joinToString1 = people.joinToString(separator = " ") { it.name }
    println(joinToString1) //one two three

    // 함수의 유일한 인자 + 타입추론이 가능 하면 it 을 사용할 수 있다.
    people.maxByOrNull { it.age }

    // 함수를 변수에 저장할 경우, 반드시 파라미터 타입을 명시해야한다 -> 왜? -> 컴파일러가 타입을 추론할 증거가 없어..
    val getAgeFunc ={p: Person -> p.age}

    people.maxByOrNull(getAgeFunc) //함수를 변수를 담아 함수에 인자로 함수를 준다! -> 함수형 프로그래밍!

    // 람다 본문이 여러줄 일경우, 마지막 "식" 이 리턴 값이 된다.
    val multiLineLambda = {
        x:Int , y:Int ->
        println("Computing the sum of ${x} and ${y}...")
        x + y // 블록의의 마지막 식은 리턴 값이다.
    }
}