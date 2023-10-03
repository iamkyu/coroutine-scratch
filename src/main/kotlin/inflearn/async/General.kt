package inflearn.async

import inflearn.printWithThread
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {

    // launch 와 달리 함수의 실행 결과를 반환받을 수 있는 코루틴 빌더
    val deferred: Deferred<Int> = async {
        1 + 2
    }

    printWithThread(deferred.await())
}