package zfwk.zutils

import io.kotest.core.spec.style.FunSpec
import kotlin.time.Duration.Companion.milliseconds

class DateUtilsTest : FunSpec({

    test("각 함수들 정상 확인") {
        DateUtils.now()
        DateUtils.currentDateTimeFormat("yyyyMMdd")
        DateUtils.currentDateString()
        DateUtils.currentTimeStamp()
        DateUtils.currentTimestampString()
    }

    test("함수 속도 확인")
        .config(
            timeout = 15.milliseconds,
            invocations = 10,
            invocationTimeout = 1.milliseconds
        ) {
            DateUtils.now()
        }
})
