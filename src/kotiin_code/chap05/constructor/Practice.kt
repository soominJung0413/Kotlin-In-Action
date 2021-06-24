package kotiin_code.chap05.constructor

open class Practice constructor(_name:String = "Anonymous", _age:Int = -1 ) {
    val name:String
    val age:Int
    init {
        name = _name
        age = _age
    }

    override fun toString(): String {
        return "Practice = {name=${name}, age=${age}}"
    }

    open fun hello() = println("Hello!")
}

class Child(_name:String, _age: Int,val info:String):Practice(_name,_age) {
    override fun hello() = println("Hello! I'm Child!")
}

fun main(args: Array<String>) {
    val p = Practice(_age = 28)

    p.hello()
    println(p.toString())

    val c:Practice = Child(_name = "soomin",_age = 28,info = "Holoman :)")

    c.hello()
    println(c.toString())
}