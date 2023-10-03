package inflearn.async

import inflearn.api1
import inflearn.api2
import inflearn.printWithThread
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking {
    val elapsedTimeMillis = measureTimeMillis {

        // 주의!
        // Lazy 옵션을 준 async 의 경우
        // deferred2 의 await 를 호출할때까지 실행되지 않음.
        // 따라서 deferred1 -> deferred2 가 순차적으로 실행되는 상황.
        // 이를 피하고 싶다면 2개의 deferred 를 await 하기 전 1, 2 를 각각 .start() 호출해주어야 함.
        val deferred1: Deferred<Int> = async(start = CoroutineStart.LAZY) { api1() }
        val deferred2: Deferred<Int> = async(start = CoroutineStart.LAZY) { api2() }
        printWithThread("Result: ${deferred1.await() + deferred2.await()}")
    }

    assert(elapsedTimeMillis >= 2_000)
    printWithThread("END in ${elapsedTimeMillis}ms")
}
