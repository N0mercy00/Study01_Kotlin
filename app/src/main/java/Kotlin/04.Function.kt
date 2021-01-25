package Kotlin

//4.함수
//fun 함수명 (변수명: 타입, 변수명 타입..) : 반환형 { return 반환값}

fun plus(first: Int, second: Int): Int {
    val result: Int = first + second;
    return result;
}

//default 값을 갖는 함수 만들기
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second;
    return result;
}

//반환값이 존재하지 않는 함수
fun printPlus(first: Int, second: Int): Unit {
    val result: Int = first + second;
    println(result);
}

//간단하게 함수를 선언하는 방법
fun plusShort(first: Int, second: Int) = first + second;

//가변인자를 갖는 함수를 선언하는 방법
fun plusMany(vararg numbers:Int){
    for(number in numbers){
        println(number);
    }
}

fun main(array: Array<String>) {
    println(plus(2, 34));
    //인수를 명시적으로 넣어 줄 수도 있습니다.
    println(plus(first = 10, second = 20));
    println(plusFive(2));

    plusMany(1,2,3);
}