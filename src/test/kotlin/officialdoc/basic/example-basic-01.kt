package officialdoc.basic

import io.kotest.core.spec.style.AnnotationSpec

class SampleTest : AnnotationSpec() {

    @Test
    fun test() {
        println("foobar")
    }
}