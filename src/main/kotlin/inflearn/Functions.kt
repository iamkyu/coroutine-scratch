package inflearn

import kotlinx.coroutines.delay

// vm option 에 `-Dkotlinx.coroutines.debug` 를 추가하면 어떤 코루틴에서 출력이 일어났는지도 확인 가능
fun printWithThread(str: Any) {
    println("[${Thread.currentThread().name}] $str")
}

suspend fun api1(): Int {
    delay(1000)
    return 1
}

suspend fun api2(): Int {
    delay(1000)
    return 2
}