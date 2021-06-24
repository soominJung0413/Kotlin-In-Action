package kotiin_code.chap05.constructor

/**
 * 부모 클래스의 생성자를 호출해야할 경우, '상속키워드에서 명시하는 생성자' 에 인자를 제공해야한다.
 */
open class UserAddParameter(val nickname:String)


// 인자만 기술 : 부모생성자에 인자 대입
class TwitterUser(nickname: String): UserAddParameter(nickname)

/**
 * 클래스에 생성자를 작성하지않으면, 기본생성자만 만들어진다.
 */
open class UserBasicConstructor


// 상속에는 반드시 super 생성자를 기입해야한다.
class ExtensionUser:UserBasicConstructor()

