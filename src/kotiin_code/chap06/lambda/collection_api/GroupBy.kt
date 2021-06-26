package kotiin_code.chap06.lambda.collection_api

import java.util.*
import java.util.stream.Collectors

/**
 *  컬렉션을 어떤 특성에 따라 나누는 함수 => groupBy
 */
fun main(args: Array<String>) {
    val people = listOf(Person("HoloMan", 27), Person("SooMin", age = 28), Person("JungJin", 29),Person("SangHyeok", 29), Person("MinHo", 30))

    /**
     * groupBy 는 하나의 프로퍼티를 Key 로, 컬렉션의 원소를 Value 로 삼아 LinkedHashMap 을 리턴한다.
     */
    val groupBy = people.groupBy { it.age }
    println("Type -> ${groupBy.javaClass.typeName} / Print -> ${groupBy}")
    //Type -> java.util.LinkedHashMap / Print -> {27=[Person(name=HoloMan, age=27)], 28=[Person(name=SooMin, age=28)],
    // 29=[Person(name=JungJin, age=29), Person(name=SangHyeok, age=29)], 30=[Person(name=MinHo, age=30)]}

    /**
     * partition 은 predicate 조건에 맞는 요소와 맞지 않는 요소를 Pair 타입으로 분리
     */
    val partition = people.partition { it.age > 28 }
    println("Type -> ${partition.javaClass.typeName} / Print -> ${partition}") // Pair 타입으로 리턴
    println("True => ${partition.first}") // first == True
    println("False => ${partition.second}") // second == False

    val collect = people.stream().collect(Collectors.partitioningBy({ it.age > 20 }, Collectors.counting()))
    println("Type -> ${collect.javaClass.typeName} / Print -> ${collect}")
    println(collect.get(true))
    println(collect.get(false))

    /**
     * 확장함수를 멤버 참조하여 함수 인자로 줄 수도 있다.
     */
    val list = listOf("ab", "a", "c", "cd")
    val result = list.groupBy(String::first)
    println(result) // {a=[ab, a], c=[c, cd]}
}