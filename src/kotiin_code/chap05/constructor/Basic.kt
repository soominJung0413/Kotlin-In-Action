package kotiin_code.chap05.constructor

/**
 * 코틀린의 생성자
 * - 주 생성자 > 클래스 바깥
 * - 부 생성자 > 클래스 내부
 *
 * 모든 생성자에는 '초기화블록' 이 올 수 있다.
 */

// 주 생성자는 프로퍼티 선언 + 인자 + 생성자를 대체한다.
class User(val nickname:String) // 클래스 이름 옆에 바로오는 (), 클래스 본문{} 바깥에 있는 생성자를 '주 생성자' 라고 부른다.


// 해당 클래스를 풀어놓으면 다음과 같다.
// 1. constructor > 부생성자 / 주생성자 키워드
// 2. _프로퍼티 > 생성자 '인자'
// 3. init {} 초기화 블록
// - 주 생성자는 초기화 블록이 없기 때문에, init 과 같이 사용된다.
class UserExplicit constructor(_nickname:String) {
    val nickname:String
    init {
        nickname = _nickname
    }
}

/**
 * init 블록에 단순 값을 대입하는 로직만 필요하다면, 프로퍼티 선언시 생성자 인자로 초기화해주자.
 */
class UserNoneInit(_nickname: String) {
    val nickname = _nickname // 선언하자마자 인자로 초기화 제공
}

/**
 * 단순 값을 제공하기위해서 프로퍼티를 생성자 인자로 초기화하는 것보다, 주 생성자에 프로퍼티를 선언하는 것이 좋다
 */
class UserSimple(val nickname: String)