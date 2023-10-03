package inflearn

import kotlinx.coroutines.*


fun main(): Unit =
    // 새로운 코루틴을 만들고 루틴 세계와 코루틴 세계를 이어줌. aka 코루틴 빌더
    // 또한 runBlocking은 내부에서 실행되는 모든 코루틴이 완료될때까지 스레드를 block 함에 주의
    runBlocking {

        printWithThread("START")
        launch() {
            newRoutine()
        }

        yield()

        printWithThread("END")
    }

suspend fun newRoutine() {
    val num1 = 1
    val num2 = 2

    yield()

    printWithThread("${num1 + num2}")
}
