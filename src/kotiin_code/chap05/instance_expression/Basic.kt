package kotiin_code.chap05.instance_expression

import kotiin_code.chap05.nested_class.obj
import java.awt.Frame
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

/**
 * object 키워드는 싱글톤 외에도 '익명 객체로 쓸 수 있다.'
 * - 익명 객체의 object 는 '싱글톤이 아니다!'
 *
 * 1. 내부에 선언된 object => 싱글톤
 * 2. 내부에 선언된 companion object => 자바의 정적 멤버와 비슷 , 동반객체
 * 3. 함수나 상위에 선언된 object :상속(),구현 => 익명 객체 식, 싱글톤이 아니므로 함수 호출 시 마다 객체가 생성!!
 */
fun main(args: Array<String>) {
    val window = Window(Frame("Title"))

    // 익명객체의 object 에는 아무런 이름도 없다. Companion 이라는 이름도 붙지않는다.
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            println("Check")
        }

        override fun mouseEntered(e: MouseEvent?) {
            println("Enter")
        }
    })

    // 익명객체를 변수에 담아 사용할 수도 있다.
    val mouseListener = object :MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            println("Clicked")
        }

        override fun mouseEntered(e: MouseEvent?) {
            println("Enter")
        }
    }
    // 자바에서 익명 객체를 변수에 담듯 사용한다.
    window.addMouseListener(mouseListener)
}

/**
 * 자바와 같이 외부 요소를 익명객체에서 참조할 수 있으나, 꼭 final 이 아니라도 된다.
 * - 즉, 익명 객체에서 외부 요소 값을 바꿀 수 있게된다.
 */
fun countClicks(window: Window) {
    var clickCount = 0

    window.addMouseListener(object :MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            clickCount++ // 익명객체에서 외부 요소를 수정해도 된다!.
        }
    })
}