package inflearn.launch

import inflearn.printWithThread
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {

    val elapsedTimeMillis = measureTimeMillis {
        runBlocking {

            val job1 = launch {
                delay(1000)
                printWithThread("Job 1")
            }

            // 이 코드로 인해 job1 이 끝날때지 기다림
            // 따라서 전체 코드의 실행 시간은 2k ms+
            job1.join()


            launch {
                delay(1000)
                printWithThread("Job 2")
            }

        }
    }

    assert(elapsedTimeMillis >= 2_000)
    printWithThread("END in ${elapsedTimeMillis}ms")
}
