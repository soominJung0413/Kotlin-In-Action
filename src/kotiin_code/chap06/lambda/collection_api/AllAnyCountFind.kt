package kotiin_code.chap06.lambda.collection_api

/**
 * Predicate 함수를 인자로 하는 컬렉션 API 에 대해 알아보자
 *
 * 1. all => 컬렉션의 모든 원소가 람다[Predicate] 조건을 만족하는지 검사
 * 2. any => 컬렉션의 원소 중 하나라도 람다[Predcate] 조건을 만족하는지 검사
 * 3. count => 컬렉션에서 람다[Predicate] 조건을 만족하는 원소 수를 리턴
 * 4. find => 컬렉션에서 람다[Predicate] 조건을 만족하는 첫 번째 원소를 리턴
 */
fun main(args: Array<String>) {
    val people = listOf(Person("HoloMan", 27), Person("SooMin", age = 28), Person("JungJin", 29),Person("SangHyeok", 29), Person("MinHo", 30))

    /**
     * all => 컬렉션을 내부 순회하며, 컬렉션의 모든 요소가 람다식의 조건을 만족하는지 검사 : Boolean
     */
    val canBeInClub27 = {p:Person -> p.age <= 27} // 나이를 검사하는 함수저장
    var result = people.all(canBeInClub27)
    println(result) // false

    /**
     * any => 컬렉션을 내부 순회하며, 컬렉션의 요소 중 하나라도 람다식의 조건을 만족하는지 검사 : Boolean
     */
    val anyPredicate = {p:Person -> p.age == 30}
    result = people.any(anyPredicate)
    println(result) // true

    /**
     * count(predicate) => 컬렉션 내부를 순회하며, 요소 중 람다식의 조건을 만족하는 원소의 수를 리턴 : Int
     * count() => 컬렉션의 원소 수를 리턴 : Int
     */
    val countPredicate = {p:Person -> p.age >= 28}
    var countResult = people.count(countPredicate)
    println(countResult) // 4
    countResult = people.count()
    println(countResult) // 5

    /**
     * find => 컬렉션 내부를 순회하며, 요소 중 람다식의 조건을 만족하는 첫번째 원소를 리턴 : T
     * findLast => 컬렉션 내부를 순회하며, 요소 중 람다식의 조건을 만족하는 마지막 원소를 리턴 : T
     *
     * --- 두 함수 모두 원소가 없을 경우 null 을 리턴한다.
     */
    val findPredicate = {p:Person -> p.age == 29}
    var findResult = people.find(findPredicate)
    println(findResult) // Person(name=JungJin, age=29)

    findResult = people.findLast(findPredicate)
    println(findResult) // Person(name=SangHyeok, age=29)

    println(people.find { it.age > 40 }) // null
    println(people.findLast { it.age > 40 } ) // null

    /**
     * firstOrNull(Predicate) => 컬렉션 내부를 순회하며, 요소 중 람다식의 조건을 만족하는 첫번째 원소를 리턴 : T
     * lastOrNull(Predicate) => 컬렉션 내부를 순회하며, 요소 중 람다식의 조건을 만족하는 마지막 원소를 리턴 : T
     *
     * firstOrNull() => 컬렉션의 첫번째 요소를 리턴
     * lastOrNull() => 컬렉션의 마지막 요소를 리턴
     */
    var firstOrNullResult = people.firstOrNull(findPredicate)
    println(firstOrNullResult) // Person(name=JungJin, age=29)

    var lastOrNullResult = people.lastOrNull(findPredicate)
    println(lastOrNullResult) // Person(name=SangHyeok, age=29)

    firstOrNullResult = people.firstOrNull()
    println(firstOrNullResult) // Person(name=HoloMan, age=27)

    lastOrNullResult = people.lastOrNull()
    println(lastOrNullResult) // Person(name=MinHo, age=30)
}