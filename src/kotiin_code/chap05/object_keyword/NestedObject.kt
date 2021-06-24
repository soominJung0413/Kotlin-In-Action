package kotiin_code.chap05.object_keyword

/**
 * 일반 클래스의 내부에 객체선언을 할 수 있다.
 * 1. 일반 클래스의 객체가 몇개가 만들어지던 객체선언 인스턴스는 '단 하나' 이다.
 */
data class Person(val name:String) { // data class 규칙에 의하여 , 주생성자의 name 프로퍼티만 가지고 equals, hashCode 가 정의된다.

    //객체선언을 일반 클래스 내부에 해도 만들어진 내부 객체는 언제나 하나다.
    object NameComparator: Comparator<Person> { // 구현하는 객체선언은 구현 인터페이스에 데이터가 없을 때에 좋다.
        override fun compare(o1: Person, o2: Person): Int = o1.name.compareTo(o2.name)
    }
}

fun main(args: Array<String>) {
    val persons = listOf(Person("Bob"), Person("Alice"))

    println(persons.sortedWith(Person.NameComparator)) // 도트연산자로 내부 객체선언에 진입한다.
}