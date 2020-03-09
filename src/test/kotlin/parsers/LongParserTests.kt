package parsers

import org.junit.Test

class LongParserTests {
    private val parser = LongParser()

    @Test
    fun validStringsAreConvertedToLongs() {
        println(Long.MIN_VALUE)
        println(Long.MAX_VALUE)

        listOf(
            "-9223372036854775808", // Minimum Double Value
            "-9223372036854775807", // Just Above Minimum Double Value
            "0",                    // Zero
            "9223372036854775806",  // Just Below Maximum Double Value
            "9223372036854775807"   // Maximum Double Value
        ).map(parser::parse).forEach { assert(it != null) }
    }

    @Test
    fun invalidStringsAreConvertedToNull() {
        listOf(
            "", "Hello", "12.3", "01/01/2020", "true", "false",
            "-9223372036854775809", // Just Below Double Integer Value
            "9223372036854775808"   // Just Above Double Integer Value
        ).map(parser::parse).forEach { assert(it == null) }
    }
}