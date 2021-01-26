package Kotlin

//14.Collection
//Collection 중 List set map 세가지만

fun main(args: Array<String>){
    //list 중복허용
    var list = listOf<Int>(1,2,3);
    println(list.get(0));
    //set ->중복허용x, 순서가 없음
    var set = setOf<Int>(1,2,3,3,3,3,3);

    //map key:value 값으로 저장
    var map = mapOf<String,Int>("one" to 1, "two" to 2);
    println(map.get("one"));

    var mlist = mutableListOf<Int>(1,2,3);

}