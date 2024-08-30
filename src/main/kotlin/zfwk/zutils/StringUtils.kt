package zfwk.zutils

object StringUtils {

    fun onlyAlphabet(input: String): String {
        return input.replace(("[^A-Za-z]").toRegex(), "")
    }

    fun removeSpecialChar(input: String): String {
        return input.replace(("[^A-Za-z0-9]").toRegex(), "")
    }


    fun removeSpace(input: String): String {
        return input.replace(("[ ]").toRegex(), "")
    }

}

fun String.onlyAlphabet() = StringUtils.onlyAlphabet(this)
fun String.removeSpecialChar() = StringUtils.removeSpecialChar(this)
fun String.removeSpace() = StringUtils.removeSpace(this)


