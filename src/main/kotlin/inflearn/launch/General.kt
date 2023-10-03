package inflearn.launch

import inflearn.printWithThread
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {

    val elapsedTimeMillis = measureTimeMillis {
        runBlocking {

            launch {
                delay(1000)
                printWithThread("Job 1")
            }

            launch {
                delay(1000)
                printWithThread("Job 2")
            }

        }
    }

    // runBlocking 내부의 모든 루틴이 끝날때까지 기다림
    // 단, 여러 코루틴에서 동시에 실행되기 때문에 총 실행시간은 2초 미만임
    assert(elapsedTimeMillis < 2_000)
    printWithThread("END in ${elapsedTimeMillis}ms")
}