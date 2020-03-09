package parsers

import org.junit.Test

class IntParserTests {
    private val parser = IntParser()

    @Test
    fun validStringsAreConvertedToInts() {
        listOf(
            "-2147483648", // Minimum Int Value
            "-2147483647", // Just Above Minimum Int Value
            "0",           // Zero
            "2147483646",  // Just Below Maximum Int Value
            "2147483647"   // Maximum Int Value
        ).map(parser::parse).forEach { assert(it != null) }
    }

    @Test
    fun invalidStringsAreConvertedToNull() {
        listOf(
            "", "Hello", "12.3", "01/01/2020", "true", "false",
            "-2147483649", // Just Below Minimum Int Value
            "2147483648"   // Just Above Maximum Int Value
        ).map(parser::parse).forEach { assert(it == null) }
    }
}