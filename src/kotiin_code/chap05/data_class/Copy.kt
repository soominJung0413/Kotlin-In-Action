@file:JvmName("Copy")
package kotiin_code.chap05.data_class

/**
 * data class 의 모든 프로퍼티는 val 로 불변하게 만들 것이 권장된다
 * - 다중 스레드 환경에서 값이 변하지 않아 동기화할 필요가 없다.
 *
 * 기존 객체에서 프로퍼티를 변경한 객체를 얻고 싶은 경우가 있다, 이때 data class 의 .copy() 함수를 호출한다.
 */
data class CopyData(val name:String, val age:Int, val postalCode:Int)


//copy() 함수로 생성된 객체는 기존 객체와는 다른 객체이다. 그러므로 서로 값을 참조하지않아 변동에 영향이 없다.
fun main(args: Array<String>) {
    val cd = CopyData("holoman", 28, 15060)


    // copy() 는 기존 객체의 인자를 기본 인자로 삼고, 바꿀 프로퍼티를 명시해서 작성한다.
    val copy = cd.copy(name = "Soomin")
    println(copy)

    val copy1 = cd.copy(name = "Soomin", age = 29)
    println(copy1)

    val copy2 = cd.copy(name = "Soomin", age = 29, postalCode = 15050)
    println(copy2)


    //참조 주소 비교
    println(cd === copy)
    println(cd === copy1)
    println(cd === copy2)
}
