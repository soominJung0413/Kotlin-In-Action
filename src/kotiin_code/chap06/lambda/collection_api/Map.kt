package kotiin_code.chap06.lambda.collection_api

/**
 * 코틀린 map 컬렉션 API 는 "Key" , "Value" 따로 나누는 함수가 존재한다.
 */
fun main(args: Array<String>) {
    val map = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four") // 중위함수 infix fun Any.to(Any):Pair

    /**
     * Filter+Keys => Key 를 가져와서 Predicate 에 맞는 entry 를 가진 컬렉션을 리턴한다.
     */
    val filterKeys = map.filterKeys { it < 3 } // API이름 + Keys => 해당 API 를 Key 요소만 가지고 실행한다.
    println(filterKeys) // {1=one, 2=two}


    /**
     * Map+Keys => Entry 를 가져와서 Key 값을 변동 시킨다.
     */
    val mapKeys = map.mapKeys { "Hello " + it.key }
    println(mapKeys) // {Hello 1=one, Hello 2=two, Hello 3=three, Hello 4=four} 키가 바뀌었다.

    /**
     * filter+Values => Value 를 가져와서 Predicate 에 맞는 entry 를 가진 컬렉션을 라턴한다.
     */
    val filterValues = map.filterValues { it == "one" }
    println(filterValues) // {1=one}

    /**
     * map+Values => Entry 를 가져와서 Value 값을 변동 시킨다.
     */
    val mapValues = map.mapValues { "Hello " + it.value }
    println(mapValues) // {1=Hello one, 2=Hello two, 3=Hello three, 4=Hello four} 값이 바뀌었다.
}