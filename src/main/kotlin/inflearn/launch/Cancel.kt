package inflearn.launch

import inflearn.printWithThread
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    // launch 역시 코루틴 빌더
    // 반환값이 없는 코루틴을 실행할때 사용
    // 만들어진 코루틴, Job 이라는 객체를 반환. 이 객체를 통해 코루틴을 제어할 수 있음
    // 아래와 같이 start 값을 전달하여 시작을 제어할 수 있음
    // val job = launch(start = CoroutineStart.LAZY) {  }
    // job.start() or job.cancel()
    val job: Job = launch {
        (1..5).forEach {
            printWithThread(it)
            delay(500)
        }
    }

    delay(1000)

    // 1..5 출력 도중 종료됨. cancel 을 호출했기 때문.
    job.cancel()
}