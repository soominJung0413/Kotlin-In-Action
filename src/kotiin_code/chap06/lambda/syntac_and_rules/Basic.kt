package kotiin_code.chap06.lambda.syntac_and_rules

import java.awt.Button
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

/**
 * 이벤트 발생시 동작을 시행한다 | 데이터 구조의 모든 원소에 공통 연산을 적용한다. 라는 사고를 구현하기 위해서,
 * "동작을 변수에 대입" 하거나, "동작을 다른 함수에 넘겨야하는 경우"가 있다.
 * - 물론 익명 내부 클래스를 사용한다면, 가능하지만 "준비 코드가 많다."
 * - 함수형 프로그래밍에서는 "함수를 값처럼 다루기 떄문에" 함수를 다른 함수의 인자로 넘길 수 있게 된다.
 *
 * 람다사용으로 인해 얻는 이점은 다음과 같다.
 * 1. 코드의 간결성
 * 2. 함수선언 불필요
 * 3. 코드블록의 함수 인자로 전달
 */
fun main(args: Array<String>) {
    val button = Button()

    button.addActionListener(object: ActionListener { //자바의 익명 내부 클래스를 사용한 방법이라고 보면 된다.
        override fun actionPerformed(e: ActionEvent?) {
            println("Action Perform.")
        }
    })

    /**
     * 이 "준비코드를 람다를 통해 대폭 줄일 수 있다."
     */
    button.addActionListener { println("Action Perform.")}

}