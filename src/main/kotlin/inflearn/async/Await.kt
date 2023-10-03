package inflearn.async

import inflearn.api1
import inflearn.api2
import inflearn.printWithThread
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking {
    val elapsedTimeMillis = measureTimeMillis {
        val deferred1: Deferred<Int> = async { api1() }
        val deferred2: Deferred<Int> = async { api2() }
        printWithThread("Result: ${deferred1.await() + deferred2.await()}")
    }

    assert(elapsedTimeMillis < 2_000)
    printWithThread("END in ${elapsedTimeMillis}ms")
}