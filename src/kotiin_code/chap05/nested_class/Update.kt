package kotiin_code.chap05.nested_class

// sealed class 는 기본적으로 open class 이다.
sealed class Parent() {

    class Child1(): Parent() {}
}

/**
 * 완화된 sealed class 는 같은 파일내에서 상속 가능하다.
 */
class Child2(val age:Int):Parent()
/**
 * public final class Child2 extends Parent {
 *      private final int age;
 *
 *      public Child2(){
 *          super()
 *      }
 *
 *      public Child2(int age) {
 *          this.age = age;
 *      }
 *
 *      public int getAge() {
 *      return this.age;
 * }
 */


/**
 * 완화된 sealed class 는 data class 도 자식으로 삼을 수 있다.
 */
data class obj(val name:String):Parent()

