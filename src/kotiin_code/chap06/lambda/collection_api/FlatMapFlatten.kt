package kotiin_code.chap06.lambda.collection_api

import java.awt.print.Book

/**
 * flatMap 함수는 map + flatten 함수의 조합이다.
 * 1. map 함수 처럼, 컬렉션의 내부요소를 순회하며 각 요소를 람다식의 결과로 매핑한다.
 * 2. flatten 함수 처럼, 여러개의 컬렉션의 원소를 하나로 합쳐 단일 컬렉션을 리턴한다.
 */
fun main(args: Array<String>) {
    val strings = listOf("abc","def")

    val firstStep = strings.map { it.toList() }
    println(firstStep) // [[a, b, c], [d, e, f]] , List<List<String>>

    /**
     * flatten 함수는 켈렉션 내부 여러개의 컬렉션의 원소를 합쳐 하나의 단일 컬렉션을 리턴한다.
     */
    val twoStep = firstStep.flatten()
    println(twoStep) // [a, b, c, d, e, f]

    /**
     * flatMap 함수는 map -> flatten 절차의 조합이다.
     * - 컬렉션을 내부 순회하며 요소를 람다의 결과로 매핑한 뒤, 결과로 리턴된 여러개의 컬렉션을 합쳐 하나의 컬렉션으로 리턴한다.
     */
    val flatMapResult = strings.flatMap { it.toList() }
    println(flatMapResult) // [a, b, c, d, e, f]

    val books = listOf(
        BookInfo("Thursday Next", listOf("Jasper Fforde")), BookInfo("Mort", listOf("Terry Pratchett")),
        BookInfo("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
    )

    // 각 BookInfo 객체의 저자를 찾아 하나의 컬렉션으로 만들어야한다.
    val authorSet = books.flatMap { it.authors }.toSet()
    println(authorSet) // [Jasper Fforde, Terry Pratchett, Neil Gaiman]

    val map:List<List<String>> = books.map { it.authors }
    // 단순히 여러개의 컬렉션으로 구성된 컬렉션을 하나의 컬렉션으로 결합하고 싶다면 , flatten 함수만 사용하면 된다.
    val flatten = map.flatten()
    println(flatten)
}

data class BookInfo(val title:String, val authors: List<String>)