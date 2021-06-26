package kotiin_code.chap06.lambda.collection_api


/**
 * filter 와 map 함수는 컬렉션을 조작하는데 기반이 되어주는 함수이다.
 * - filter => 내부 요소를 순회하며 요소를 람다식에 전달 -> 람다식이 true 가 되는 원소만 저장
 * - map -> 내부 요소를 순회하며 요소를 람다식에 전달 -> 람다식의 코드대로 "값 변환"
 */
data class Person(val name:String, val age:Int)

fun main(args: Array<String>) {
    val people = listOf(Person("SooMin", 29), Person("JungJin",29), Person("Unknown", 40))

    // Iterable<T>.filter 는 내부 요소를 순회, 찾은 요소를 인자 람다식에 넘겨 true 를 리턴하는 요소만으로 구성된 Collection 을 만든다.
    // [ 인자는 Predicate ]
    val filter = people.filter { it.age > 30 }
    println(filter)


    val numberCollection = listOf(1,4,7,9)
    // Iterable<T>.map 은 내부 요소를 순회, 찾은 요소를 람다식에 넘겨 나온 결과 값으로 구성된 Collection 을 만든다. [ 인자는 Transform ]
    val map = numberCollection.map { it * it } // 함수의 유일한 인자가 함수 -> {} 로 람다 선언
    println(map) // [1, 16, 49, 81]

    val names = people.map { it.name }
    println(names) // [SooMin, JungJin, Unknown]
    // 멤버 참조를 이용하면, 더 좋은 람다 코드가 된다.
    val names1 = people.map(Person::name)
    println(names1) // [SooMin, JungJin, Unknown]

    // 함수의 리턴타입이 같으므로, 메서드 체이닝이 가능하다.
    val oldestPersonName = people.filter { it.age > 30 }.map(Person::name)
    println(oldestPersonName) // [Unknown]

    // 컬렉션의 나이가 가장 높은 사람과 동갑인 사람을 찾자.
    val maxAge = people.maxByOrNull { it.age }!!.age
    val oldests = people.filter { it.age == maxAge }
}