package kotiin_code.chap06.lambda.collection_api.lazy

/**
 * 컬렉션에 대한 API 는 하나의 과정을 넘기고, 도출된 컬렉션을 다시 다음 과정으로 넘기는 방식이다.
 *
 * 하지만, Sequence 에 대한 API 는 원소를 하나꺼내 모든 체인 메서드를 실행하고, 다음 원소를 꺼내 모든 체인메서드를 실행하는 방법을 가진다.
 *   그러므로 find 같은 함수를 최종연산에 기술했을 때 등의 경우에는 모든 요소가 처리되지 않고 결과 값만 도출하고 연산이 멈출 수 있다.
 */
fun main(args: Array<String>) {
    // 기본 컬렉션 연산은 리턴 값을 도출하고, 리턴된 값을 가지고 다음 체인으로 넘어가기 떄문에, "모든 원소에 연산이 수행된다."
    val CollectionAPIChain = listOf(1, 2, 3, 4)
        .map { it * it }.firstOrNull { it > 3 }
    println(CollectionAPIChain)

    // Sequence 연산은 원소를 하나씩 꺼내 모든 체인 메서드 연산을 수행하고 다음 원소를 꺼내 모든 체인 메서드 연산을 한다.
    // "결과 값의 원소를 찾으면, 다음 원소들의 연산은 하지 않는다,"
    val SequenceAPIChain = listOf(1, 2, 3, 4).asSequence()
        .map { println("map: ${it} ");it * it }.firstOrNull { println("find: ${it} ");it > 3 }
    println("\n${SequenceAPIChain}")
    /** 로그
      map: 1
      find: 1
      map: 2
      find: 4

      4
     => 원소를 꺼내 체인 메소드의 모든 연산을 수행 후 다음 원소를 꺼내어 체인 메소드의 모든 연산을 수행했음,
     => 그러므로 결과가 도출되자마자 3, 4 원소는 계산하지 않고 종료됨
     */

}