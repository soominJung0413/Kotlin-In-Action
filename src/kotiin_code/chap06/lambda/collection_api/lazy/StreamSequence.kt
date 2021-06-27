package kotiin_code.chap06.lambda.collection_api.lazy

import kotiin_code.chap06.lambda.collection_api.Person
import java.util.stream.Collectors

/**
 *  java8의 Stream 과 kotlin 의 Sequence 는 같은 연산을 진행한다.
 *  - java 8 을 사용 중이라면, Stream 과 Sequence 중 원하는 것을 채택해서 사용하라.
 */
fun main(args: Array<String>) {

    /**
     * Sequence 는 요소를 하나씩 꺼내 모든 연산을 진행하고 다음 요소를 꺼내는 연산을 가지고 있다.
     * - 연산 순서에 따라 성능이 크게 달라진다.
     * - 연산 과정에서 뺄 수 있는[Predicate] 과정이 있다면, 먼저 진행하는 게 좋다.
     */
    val people = listOf(Person("SooMin",28), Person("JungJin",29),Person("MinHo",30))


    // 두 API 체인의 연산결과는 성능의 차이가 확실하게 나타난다.
    /**
     * - 원소가 많을 수록 연산 횟수 차이는 더 커진다.
     * Sequence : Map 함수를 먼저 실행했을 경우의 연산 힛수 : 6
     * Sequence : Filter 함수를 먼저 실행했을 경우의 연산 횟수 : 4
     *
     * 1. Sequence 의 연산방식에 대해 이해한다면 납득 가능하다.
     * 2. 원소를 하나꺼내 모든 연산을 수행하고 다음 원소를 꺼내는 것이 Sequence 연산 방식이다.
     * 3. filter 를 먼저 선언할 경우, 원소를꺼내고 조건에 맞지 않으면 map() 연산 하지 않고 바로 다음 원소로 넘어가게 된다.
     * => age 가 28,29 인 원소를 filter() 연산하고서 Predicate 에 맞지 않아 map() 연산을 하지않고 바로 다음 원소를 꺼내 연산한다.
     */
    var operationCount:Int = 0
    people.asSequence().map { operationCount++;it.age }.filter { operationCount++;it > 29 }.toList()
    println("Sequence : Map 함수를 먼저 실행했을 경우의 연산 힛수 : ${operationCount}")

    operationCount = 0
    people.asSequence().filter { operationCount++;it.age > 29 }.map { operationCount++;it.age }.toList()
    println("Sequence : Filter 함수를 먼저 실행했을 경우의 연산 횟수 : ${operationCount}")

    /**
     * Stream : Map 함수를 먼저 실행했을 경우의 연산 힛수 : 6
     * Stream : Filter 함수를 먼저 실행했을 경우의 연산 횟수 : 4
     *
     * Java.util.Stream 도 Sequence 와 정확히 같은 방식으로 작동한다.
     * 1. 원소 하나를 꺼내 모든 연산을 진행시킨다.
     * 2. 중간의 Predicate 조건에 맞지 않으면 즉각 연산을 멈추고 다음 요소를 꺼내어 연산을 진행한다.
     */
    operationCount = 0
    people.stream().map { operationCount++;it.age }.filter { operationCount++;it > 29 }.collect(Collectors.toList())
    println("Stream : Map 함수를 먼저 실행했을 경우의 연산 힛수 : ${operationCount}")
    operationCount = 0
    people.stream().filter{ operationCount++;it.age > 29 }.map { operationCount++;it.age }.collect(Collectors.toList())
    println("Stream : Filter 함수를 먼저 실행했을 경우의 연산 횟수 : ${operationCount}")


}