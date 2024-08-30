package zfwk.zutils

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe

data class TestSet(val value: String, val length: Int)
class StringUtilsTest : FunSpec({

    test("onlyAlphabet check") {
        "12309oiuadf.  w- $ !".onlyAlphabet() shouldBe "oiuadfw"
    }

    context("onlyAlphabet multi check") {
        withData(
            TestSet("abc", 3), TestSet("123a", 1)
        ) { (str, len) ->
            str.onlyAlphabet().length shouldBe len

        }
    }

    test("removeSpace check") {
        "1 1".removeSpace() shouldBe "11"
    }



})
