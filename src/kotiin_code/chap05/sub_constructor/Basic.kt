package kotiin_code.chap05.sub_constructor

import javax.naming.Context
import javax.swing.text.AttributeSet

/**
 * 사싱, 코틀린에서 부 생성자를 늘리는 것은 권장되지 않는 방법이다.
 * - 파라미터의 기본 값 + 이름 붙은 인자를 사용하면 오버로딩을 회피할 수 있다.
 * - 인자대입 생성자 외에 부득이하게 로직이 필요한 생성자가 필요하다면, 사용함이 옳다.
 * - 상속 관계에 의하여 여러 생성자를 받아야할 경우, 사용함이 옳다.
 */
open class View {
    // 부생성자는 java 생성자와 아주 유사하다, 인자에는 프로퍼티선언 없이 이름:타입 만 기술한다.
    constructor(ctx:Context) {

    }
    constructor(ctx: Context?, attr:AttributeSet) {

    }
}

/**
 * 상속 시 자식 클래스의 부생성자에서 super 생성자를 호출할 수 있다.
 */
class MyButton:View { // 주 생성자가 없으므로 상속시 호출하지 않는다.
    constructor(ctx: Context) : super(ctx)  // [자식 생성자 : super 생성자] 형식으로 작성한다.

    constructor(ctx: Context?,attr: AttributeSet): super(ctx, attr)

    constructor(attr: AttributeSet) : this(ctx = null,attr) // 자기자신의 상위 생성자를 이용하여 오버로딩할 수도 있다.
    // [자신의 생성자 : 자신의 상위 생성자] 형식으로 작성한다.
}

