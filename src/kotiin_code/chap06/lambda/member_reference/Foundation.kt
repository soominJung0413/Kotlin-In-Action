package kotiin_code.chap06.lambda.member_reference

import kotiin_code.chap05.object_keyword.Person

/**
 * 람다는 새로운 함수를 블록을 만들어서 인자로 넘기는 방법이다. , 하지만, 이미 선언된 함수는 람다로 넘길 수가 없다.
 * - 이미 클래스에 선언된 함수, 최상위 함수 를함수의 인자로 넘기기 위해서 "::" 멤버참조를 사용한다.
 */
fun main(args: Array<String>) {

    /**
     * getAgeReference 라는 변수에 {p:Person -> p.age} 를 넣은 것
     */
    val getAgeReference = Person::name

    val getAgeReferenceWithLambda = {p: Person -> p.name} // 기존 람다식 방식으로도 사용 가능!

    /**
     * 멤버 참조는 단 하나의 프로퍼티, 함수를 리턴하며, 절대 뒤에 () 를 넣어서는 안된다
     * Person::name() -> X
     * Person::name -> O
     */
    val people = listOf(Person("Soomin"), Person("Jungjin"))
    // 1. 변수에 담은 멤버참조를 인자로 줌
    people.maxByOrNull(getAgeReference)
    // 2. 함수의 유일한 인자라 람다식이므로 , {,,} 만 선언하여 람다식을 인자로 준다.
    people.maxByOrNull{p: Person -> p.name}
    // 3. 유일인자 + 타입추론 이 가능하므로, it 키워드를 사용한다.
    people.maxByOrNull{it.name}
    // 4. 이미 선언된 함수이므로, 멤버참조를 이용하여 함수를 인자로 준다.
    people.maxByOrNull(Person::name)

}