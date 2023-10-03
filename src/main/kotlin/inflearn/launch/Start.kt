package inflearn.launch

import inflearn.printWithThread
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        (1..5).forEach {
            printWithThread(it)
            delay(500)
        }
    }

    printWithThread("START")

    // start() 를 호출할때까지 job 은 실행되지 않음
    job.start()
}
