package kotiin_code.chap05.object_keyword

import java.io.File

/**
 * 코틀린의 object 키워드를 '객체 선언' 이라고 한다.
 * 1.클래스 선언 과 인스턴스 변수 저장을 동시에 수행하는 키워드이다.
 * 2. object 클래스 안에는 '생성자를 정의할 수 없다.'
 * 3. 내부에 프로퍼티, 메서드, 초기화블록이 올 수 있다.
 *
 * - 보통 싱글톤 패턴의 구현에 쓰인다.
 */
object SingleTon {
    val name:String

    init { // object 의 init 블록은 private 생성자의 구현 부이다.
        name = "Anonymious"
    }

    fun printMe() = println("SingleTon(name=${name})")
}

/**
 * 객체 선언도 클래스, 인터페이스를 상속,구현할 수 있다.
 * - 보통 데이터가 없을 경우에 사용된다.
 */
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int { // 인자를 받아 비교하는 메서드를 가진 인터페이스로, 내부 데이터가 없다.
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }

}

fun main(args: Array<String>) {
    val obj = SingleTon.name // 도트연산자로 프로퍼티 접근자를 바로 호출한다.

    SingleTon.printMe() // 도트연산자로 메서드를 바로 호출한다.

    println(obj)

    println(CaseInsensitiveFileComparator.compare(File("/User"),File("/user"))) // 구현하고있는 객체 선언

    val files = listOf(File("/z"), File("/a"))

    val sortedWith = files.sortedWith(CaseInsensitiveFileComparator) // 싱글톤 객체를 인자로 넘긴다!
    println(sortedWith)
}