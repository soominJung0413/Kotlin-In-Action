package kotiin_code.chap05.abstract_property

/**
 * 뒷받침 하는 필드가 있는 접근자 메소드 -> 커스텀 접근자 내부 'field' 선언
 * 뒷받침 하는 필드가 없는 접근자 메소드 -> 커스텀 접근자 내부 'field' 미선언
 */
class Field constructor(val name:String) {
    var address:String = "unspecified"
    get() {
        return field // field 는 뒷받침하는 필드를 의미한다.
    }
    set(value:String) {
        println("""Address was changed for ${name}" "${field}" -> "${value}". """.trimIndent())

        field = value // field 를 커스텀 접근자에 작성한 순간부터 뒷받침하는 필드가 생긴다고 보면된다.
    }
}

fun main(args: Array<String>) {
    val f = Field("Soomin")

    println(f.address) // field 를 선언한 커스텀 게터
    f.address = "Change" // field 를 선언한 커스텀 세터
}