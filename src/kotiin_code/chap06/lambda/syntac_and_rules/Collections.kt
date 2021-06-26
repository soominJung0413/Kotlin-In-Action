package kotiin_code.chap06.lambda.syntac_and_rules

/**
 * 자바 8 이전 라이브러리는 람다를 지원하지 않아[8 에서는 Stream] 직접 함수를 작성하고는 했다.
 * - 코틀린 언어의 철학에 따라서, "적극적으로 라이브러리를 이용해야만 한다."
 */
data class Person(val name:String, val age:Int)
// Person 객체 List [컬렉션]에서 가장 나이[프로퍼티]가 높은 사람[객체]를 찾기 위해 기존에는 알고리즘 루프를 돌려야했다.
fun findTheOldest(people:List<Person>) {// 최상위 함수
    var maxAge = 0
    var theOldest: Person? = null

    for(person in people) {
        if(person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}
fun main(args: Array<String>) {
    val people = listOf(Person("Alice",29), Person("Bob",31))
    findTheOldest(people) // Person(name=Bob, age=31)

    /**
     * 코틀린 라이브러리는 함수에는 컬렉션의 최댓값을 찾아주는 라이브러리 함수가 있다.
     */
    val maxByOrNull = people.maxByOrNull { it.age } // 코틀린의 { ... } 블록은 "람다식"으로 "인자로 사용되는 함수"이다.
    // it 은 람다의 유일인자를 뜻하며, maxBy 함수에 필요한 데이터를 넘겨주는 {...} 람다함수가 인자로 제공된 것이다.
    println(maxByOrNull) // Person(name=Bob, age=31)

    /**
     * 코틀린도 자바 8 의 :: 클래스 참조기호를 사용할 수 있다.
     */
    val maxByOrNull1 = people.maxByOrNull(Person::age) // 멤버 참조 블록은 ( ... ) "소괄호" 이다.
    println(maxByOrNull1) // Person(name=Bob, age=31)
}