package kotiin_code.chap06.lambda.collection_api.lazy

/**
 * kotlin 의 Sequence 개념은 Java 의 Stream 개념과 같다.
 * 1. 중간 연산과 최종연산
 * - 중간 연산은 Sequence 구현체를 리턴
 * - 최종 연산은 컬렉션,원소,숫자,객체를 리턴
 *
 * 2. 중간연산은 언제나 지연연산된다.
 * - 최종 연산 전까지 모든 중간연산은 미루어 (Lazy) 진다.
 * - 최종 연산이 되기 전까지는 kotlin Sequence 는 흐르지 않는다.
 */
fun main(args: Array<String>) {
    val result = listOf(1, 2, 3, 4,).asSequence()
        .map {
            print("map ${it} ")
            it * it
        }
        .filter { print("filter ${it} "); it % 2 == 0 } // 람다 코드블록에서 한줄로 여러 줄을 기입하려면 ; 을 붙인다.

    // 최종 연산을 실행하기 전까지는 Sequence 는 작동하지 않고 미루어(lazy)진다.
    println(result) // kotlin.sequences.FilteringSequence@4a574795

    // 최종 연산을 수행해야만 Sequence 연산이 동작하여 결과를 도출한다.
    val resultToFinal = result.toList()
    println("\n${resultToFinal}") // map 1 filter 1 map 2 filter 4 map 3 filter 9 map 4 filter 16 / [4, 16]

}