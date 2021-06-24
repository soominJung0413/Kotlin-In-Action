package kotiin_code.chap05.object_keyword

/**
 * 동반 객체는 생성자가 없는 인터페이스만을 구현할 수 있다.
 */
interface JSONFactory<T> {
    fun fromJSON(jsonText:String) : T
}

class InheritPerson(val name:String) {
    companion object :JSONFactory<InheritPerson> { // 동반 객체는 생성자를 정의할 수 없기 때문에, 이름 뒤에 바로 상속한다.
        override fun fromJSON(jsonText: String)   = InheritPerson(jsonText)
    }
}

fun main(args: Array<String>) {

}