package kotiin_code.chap05.data_class

/**
 * 함수형 프로그래밍의 중요요소 중 하나인 "불변객체"를 만드는 방법을 배운다.
 * - data class 는 toString(), hashCode(), equals(), copy() 함수를 자동으로 만들어준다.
 * - class 키워드 앞에 data 를 붙여 불변객체를 선언한다.
 *
 * 코드의 가독성 + 불필요한 코드제거 + 중복제거 를 철학으로 하는 코틀린에 알맞은 VO 를 만드는 방법이다.
 */
class Client(val name:String, val postCode:Int) // 주 생성자 + 프로퍼티

/**
 * 1. toString
 */
class ClientToString(val name: String, val postCode: Int) {
    override fun toString(): String = "Client (name=${name}, postCode=${postCode})"
}

/**
 * 2. equals()
 * - VO 클래스는 보통 식별자등의 내부데이터를 가지고 동등성을 식별한다.
 * - == 은 코틀린에서 'equals()' 로 컴파일되며, === 은 값 참조 비교 연산자이다.
 */
class ClientEquals(val name: String, val postCode: Int) {
    override fun equals(other: Any?): Boolean { // Any 는 최상위 타입, ? 은 널 가능
        if(other == null || other !is ClientEquals) { // == 은 equals, !is 는 타입비교 부정연산자
            return false
        }
        // !is 에 의해 if 식 바깥구문은 is 로 스마트캐스팅된다.
        return name == other.name && postCode == other.postCode
    }
}

/**
 * 3. hashCode()
 * - 객체의 주소값을 보통 hashCode, 라고하는데, Java 에는 equals 로 동등한 객체는 반드시 hashCode 도 등등해야한다는 규칙이 있다.
 * - hashSet 등의 컬렉션에서 .contains() 를 호출해보면, hashcode 가 맞아떨어지는지 알 수 있다.
 */
class ClientHashCode(val name: String, val postCode: Int) {
    override fun hashCode(): Int {
        return name.hashCode() * 31 + postCode
    }

    override fun equals(other: Any?): Boolean {
        if(other == null || other !is ClientHashCode) {
            return false
        }
        return name == other.name && postCode == other.postCode
    }
}

fun main(args: Array<String>) {
    //1. toString > Client (name=one, postCode=1)
    println(ClientToString("one",1).toString())
    //2. equals > true
    println(ClientEquals("two",2).equals(ClientEquals(name = "two",postCode = 2)))
    //3. hashCode > true
    println(hashSetOf(ClientHashCode("three",3)).contains(ClientHashCode("three",3)))
}