package zfwk.zutils

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.types.shouldBeTypeOf
import java.time.LocalDateTime

class DateUtilsBehaviorTest : BehaviorSpec({

    given("DateUtils") {
        `when`("now") {
            then("LocalDateTime") {
                DateUtils.now().shouldBeTypeOf<LocalDateTime>()
            }
        }
    }
})
