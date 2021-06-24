package kotiin_code.chap05.delegation

/**
 * 코틀린에서는 위임 패턴을 쉽게 만들 수 있다.
 * 1. 기존 클래스가 구현하던 인터페이스를 구현하는 새로운 클래스를 작성
 * 2. 새로운 클래스에 기존클래스를 필드로 저장
 * 3. 새로운 클래스의 함수에 새로운 로직을 기술하되, 기존 로직은  필드의 기존 클래스의 함수를 호출
 *
 * - 일부 추가 동작을 위해서 새로운 클래스에 모든 함수를 작성해야하는 큰 단점이 있다.
 */

// 기존의 데코레이터 패턴
class DelegatingCollection<T>:Collection<T> { // 1.기존 구현클래스가 구현하던 인터페이스를 구현하는 클래스를 작성한다.
    private val arrayList = arrayListOf<T>() // 2.기존 구현 클래스를 필드로 삼는다.


    // 3. 기존 로직은 필드로 저장한 기존 구현 클래스 객체를 이용하며, 새로운 작동은 새로운 구현클래스에 작성한다.
    override val size: Int = arrayList.size
    override fun isEmpty(): Boolean = arrayList.isEmpty()
    override fun contains(element: T): Boolean  = arrayList.contains(element)
    override fun iterator(): Iterator<T> = arrayList.iterator()
    override fun containsAll(elements: Collection<T>): Boolean = arrayList.containsAll(elements)
}// 몇가지의 새로운 동작을 위하여, 모든 메서드를 구현하는 준비코드가 많다.



//코틀린의 by 키워드 => 위임패턴을 쉽게 작성
/**
 * 클래스의 주생성자의 파라미터 ->  [위임객체]:[위임 객체 타입]
 * : 구현인터페이스 [by] [위임객체] > by 옆의 위임객체에 구현을 위임하겠습니다.
 *
 * 상속 없이 기존 클래스의 기능을 재정의할 수 있는 클래스를 만드는 것이 위임 패턴의 목적입니다 :)
 */
class DelegatingCollectionWithByKeyword<T>(private val innerList:ArrayList<T>): Collection<T> by innerList {
    override fun contains(element: T): Boolean = innerList.contains(element) // 필요한 함수만 재정의 하자!
}