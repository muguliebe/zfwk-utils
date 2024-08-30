package zfwk.zutils

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.positiveInt
import io.kotest.property.checkAll
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

@ExperimentalTime
class EtcUtilsTest : FunSpec({
    invocationTimeout = 2.milliseconds.toLong(DurationUnit.MILLISECONDS)

    test("hostName could not be null or empty") {
        val hostName = EtcUtils.hostName()
        println("hostName=$hostName")
        hostName.isEmpty() shouldBe false
    }

    test("hostName length check") {
        Arb.positiveInt(6).checkAll { i ->
            val hostName = EtcUtils.hostName(i)
            hostName.length shouldBeLessThanOrEqual i
            println("hostName = $hostName")
        }
    }

})
