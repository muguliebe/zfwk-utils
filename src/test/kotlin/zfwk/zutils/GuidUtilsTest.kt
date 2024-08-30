package zfwk.zutils

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldBeTypeOf
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.measureTime

class GuidUtilsTest : FunSpec({

    test("GuidUtils") {
        val guid = GuidUtils.generate()
        guid.shouldBeTypeOf<String>()
        guid shouldNotBe null
        guid.length shouldBeGreaterThan 0
        println("guid = $guid, len=${guid.length}")
    }

    test("GuidUtils length"){
        val CNT = 100000
        val elapsed = measureTime {
            for (i in 0 until CNT) {
                val guid = GuidUtils.generate()
                guid.length shouldBeLessThanOrEqual GuidUtils.LENGTH
            }
        }
        println("Elapsed: $elapsed ms, cnt:$CNT")
    }

    test("GuidUtils cannon each")
        .config(timeout=15.milliseconds, invocations = 10, invocationTimeout = 1.milliseconds) {
            GuidUtils.generate()
        }


})
