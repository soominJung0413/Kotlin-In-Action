package kotiin_code.chap05.`interface`

/**
 * 코틀린 인터페이스는 자바 8의 인터페이스와 유사하다.
 * - 필드를 정의할 수 없다.
 * - 추상 메서드 선언이 가능하다.
 * - default 메서드 구현이 가능하다.
 */
interface Clickable {
    fun click() // 인터페이스에 선언한 함수는 기본적으로 추상 함수이다.
    fun showOff() = println("I'm Clickable") // default 함수는 구현부만 추가하면 된다.
}

class Button: Clickable { // 구현은 상속과 같으나, 부모 생성자를 호출하지 않기 때문에, () 를 붙이지 않는다.
    override fun click() = println("I was clicked") // open 함수의 재정의는 override 키워드로 한다.
}

/**
 * 자바와 같이, 코틀린에서도 다중 상속은 불가능하다.
 */
fun main(args: Array<String>) {
    val btn:Clickable = Button()

    btn.click() // 런타임에 타입을 잡는다 -> 다형성
    // I was clicked

    btn.showOff() // default 함수 호출
    // I'm Clickable
}