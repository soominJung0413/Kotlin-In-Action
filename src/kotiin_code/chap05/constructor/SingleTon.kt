package kotiin_code.chap05.constructor

/**
 * 인스턴스 생성을 막기위해서는
 * 생성자의 접근제한자를 private 로 잡으면 된다.
 */
class SingleTon private constructor() {
    val instance
    get() = SingleTon()
}
