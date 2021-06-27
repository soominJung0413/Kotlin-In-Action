package kotiin_code.chap06.lambda.collection_api.lazy

import kotiin_code.chap06.lambda.collection_api.Person

/**
 * 컬렉션 API 에서는 매 함수마다 새로운 객체를 만들어내는 작업을 하게 된다.
 *  이는 컬렉션 API 체이닝을 걸때마다 새로운 컬렉션이 만들어진다는 뜻이다. 원하는 결과는 하나인데, 중간연산에서 계속 객체가 만들어지는 것이다.
 *  이런 메모낭비를 없애기 위해서, Kotlin 에서는 "Sequence" 라는 인터페이스를 만들었다.
 */
fun main(args: Array<String>) {
    val people = listOf(
        Person("HoloMan", 27), Person("SooMin", age = 28), Person("JungJin", 29),
        Person("SangHyeok", 29), Person("MinHo", 30)
    )

    // 기존 컬렉션 API 는 호출 될 때 마다 결과를 가진 컬렉션을 생성한다.
    val map = people.map(Person::age)
    val filter = people.filter { it.age > 28 }

    // 컬렉션 API 를 그대로 체이닝하면, 중간 객체가 계속 생성되어 메모리가 낭비된다.
    val chain = people.map(Person::age).filter { it > 28 }

    /**
     * kotlin 에서는 Sequence 라는 인터페이스를 가지고 이를 해결한다. 단순히 원소의 값만을 가진  인터페이스를 이용하여 메모리 낭비를 줄이는 것이다.
     *  그러므로 asSequence 로 생성한 컬렉션의 경우, 중간연산에서 생성한 컬렉션이 없기 떄문에, 메모리 낭비가 일어나지 않는다.
     *
     *  - 마지막 결과 값을 얻고 싶을때, 결과 값으로 매핑하는 메서드를 호출하여 마무리한다.
     */
    val chainAsSequence = people.asSequence().map(Person::age).filter { it > 28 }.toList()
    println(chainAsSequence) // [29, 29, 30]

    /**
     *  중간 연산결과가 새로운 컬렉션을 생성하더라도 Sequence 를 사용하지 않는 편이 좋은 경우가 있다. 하지만, 컬렉션의 원소가 많다면, 반드시 Sequence 로 변환해서 사용하라.
     *  - 객체를 생성하는 비용보다 중간원소를 재배열하는 비용이 더 비싸지기 때문이다.
     */
    val intList = listOf(1,2,3,4,5,6,7,8,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40)

    val intListAsSequence = intList.asSequence().map { it * it }.filter { it > 500 }.map { it / it }.toList()
    println(intListAsSequence)

}