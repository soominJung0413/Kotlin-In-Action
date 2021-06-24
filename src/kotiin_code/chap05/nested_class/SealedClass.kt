package kotiin_code.chap05.nested_class

/**
 * when 등의 분기 식에서 조건을 명시할 경우, 클래스 상속에 따른 펙토리 메서드 등을 작성할 때에 개발자 스스로 조건을 생각하고 작성해야했다.
 * - 코틀린에서는 sealed 키워드를 이용하여 '클래스의 상속을 중첩 클래스로 제한시킨다.'
 * - 반드시, sealed class 로 봉인된 클래스 내부의 중첩 클래스에서만 상속을 할 수 있으며, 이는 '컴파일러가 스스로 조건을 제한하게 해준다.'
 *
 * > when 식 등의 분기구문에서 조건을 모두 추론하여 , 불필요한 else 문을 작성하지 않을 수 있다.
 * > 상속을 해야하는 특성에따라, sealed class 도 open class 이다.
 */
sealed class Expr {
    //sealed class 의 생성자는 private 이다. 이는 외부에서 sealed class 를 상속해도 'super 생성자를 사용하지 못하게 하여 상속을 금지시키는 기법' 이다.
    class Num(val value:Int):Expr()
    class Sum(val left:Expr, val right:Expr):Expr()
}

// 중요한 점은 컴파일러가 상속 관계를 파악하고 있다는 것이다.
fun eval(e:Expr): Int = when(e) {
    is Expr.Num -> e.value
    is Expr.Sum -> eval(e.left) + eval(e.right)
}

fun main(args: Array<String>) {
    val num1:Expr = Expr.Num(1)
    val num2:Expr = Expr.Num(2)
    val num4:Expr = Expr.Num(4)

    val sum = Expr.Sum(num1,num2)

    val sumTotal = Expr.Sum(sum,num4)

    val result = eval(sumTotal)

    println(result)
}