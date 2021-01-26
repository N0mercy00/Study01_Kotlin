package Kotlin

//12.코틀린에서 배열 선언방법

fun main(array: Array<String>){
    //코틀린에서의 배열 생성법
    var array1 = arrayOf<Int>(1,2,3,4,5);

    //자료형을 생략하는 경우 다양한 자료형을 넣을 수 있는 배열이 된다
    var array2 = arrayOf(1,2,"hello");

    //get을 이용하여 배열의 요소를 사용할 수 있다.
    array1.get(0);
    //배열에 인덱스를 바로 사용할 수도 있다.
    var number1 = array1[1];

    //set이나 index를 사용하여 배열을 수정할 수도 있다.
    array1.set(0,100);
    array1[1]=200;
}