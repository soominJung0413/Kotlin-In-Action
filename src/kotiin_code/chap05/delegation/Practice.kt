package kotiin_code.chap05.delegation


/**
 * innerSet 프로퍼티 : 위임 객체 < by
 * innerSet 타입 : 위임 객체 타입
 * 구현 인터페이스 : MutableCollection<T>
 */
class CountingSet<E> (private val innerSet:MutableCollection<E> = HashSet<E>()):MutableCollection<E> by innerSet {
    // 필요한 것만 새로 작성
    var objectAdded = 0

    override fun add(element: E): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<E>): Boolean {
        objectAdded =+ elements.size
        return innerSet.addAll(elements)
    }
}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()

    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectAdded} objects were added, ${cset.size} remain")

    //3 objects were added, 2 remain
}