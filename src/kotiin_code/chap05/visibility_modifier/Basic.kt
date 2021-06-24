package kotiin_code.chap05.visibility_modifier

import kotiin_code.chap05.`interface`.Focusable

/**
 * 코틀린의 패키지는 작업공간을 정의할 뿐, 접근제한자와는 관계가 없다는 사실을 기억하라.
 *
 * 코틀린의 접근 제한자는 다음과 같다.
 * - public > 기본 접근제한자, 모든 공간에서 import 가 가능하다.
 * - protected > 상속관계, 자식 클래스만이 접근할 수 있다.
 * - private > 비공개, 해당 클래스에서만 접근할 수 있다.
 * - internal > 모듈 접근제한자, 패키징되는 모듈에서만 접근할 수 있으며, 코틀린의 완벽한 캡슐화를 위한 접근자 이다.
 *
 *  -- 최상위 함수,프로퍼티의 경우 private 접근자는 해당 파일에서만 접근할 수 있다는 점을 기억하라.
 */
internal open class TalkativeButton: Focusable {
    private fun yell() = println("Hey!")

    protected fun whisper() = println("Let's talk!")

    internal fun call() = println("Called!")
}

// 해당 클래스는 접근자의 규칙을 모두 위반한다.
//fun TalkativeButton.giveSpeech() { // public' member exposes its 'internal' receiver type TalkativeButton
    // public 함수가 internal 함수를 확장하고 있다.

    //yell() // Cannot access 'yell': it is private in 'TalkativeButton'
    // private 함수를 다른 함수에서 호출하고 있다.

    //whisper() // Cannot access 'whisper': it is protected in 'TalkativeButton'
    // protected 함수를 다른 함수에서 로출하고 있다.
//}

val Kotlin_In_Action: String = ""

/**
 * 코틀린 protected 멤버는 오로지 자식클래스에서만 참조 가능하다.
 * 확장함수의 경우 수신객체를 인자로 받기 때문에, private & protected 멤버에는 접근할 수 없다.
 *
 * internal 접근자는 자바에서는 public 으로 컴파일된다 > internal 접근자를 외부모듈에서 import 하는 것을 막기위해서
 * Kotlinc 는 internal 멤버의 이름을 의도적으로 바꾸어 놓는다.
 */
// internal 멤버를 Kotlinc 가 메소드명$프로젝트명으로 변경시킴
val javaCode = """
    public class Internal접근자호출 {
        public static void main(String[] args) {
            TalkativeButton tb = new TalkativeButton();

            tb.call\$Kotlin_In_Action(); 
        }
    }
""".trimIndent()