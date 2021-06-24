package kotiin_code.chap05.data_class

/**
 *  앞서 재정의한 toString, equals, hashCode 는 VO 에 반드시 필요한 메서드들이며, 반드시 재정의해야한다.
 *
 *  data 키워드를 class 앞에 붙이면, 컴파일러가 자동으로 toString, equals, hashCode, copy 를 재정의해주며, 이를 '데이터 클래스' 라고 부른다.
 */
data class ClientData(val name:String, val postCode:Int) // 주 생성자에 프로퍼티 선언


// 데이터 클래스는 [주생성자에 정의된 프로퍼티]를 기준으로 hashCode, Equals 를 구현한다.
// 주생성자에 선언한 모든 프로퍼티 값이 일치해야, 객체의 동등함이 증명되는 것이다.

// 반대로, [주생성자에 정의하지않은 프로퍼티]는 hashCode, Equals 의 동등성 고려대상이 아니다.
fun main(args: Array<String>) {
    val data = ClientData("Holoman",15060)
    val data1 = ClientData("Holoman",15060)

    //ClientData(name=Holoman, postCode=15060)
    println(data.toString())

    //true
    println(data == data1) // == > equals

    //true
    println(hashSetOf(data).contains(data1)) // hashSet 내부 규칙으로 hash 비교
}