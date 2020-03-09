package parsers

import org.junit.Test

class DoubleParserTests {
    private val parser = DoubleParser()

    @Test
    fun validStringsAreConvertedToDoubles() {
        listOf(
            "12345", // Integers are ok
            "12.34"  // Doubles can have one decimal
        ).map(parser::parse).forEach { assert(it != null) }
    }

    @Test
    fun invalidStringsAreConvertedToNull() {
        listOf(
            "", "Hello", "12.3.45", "01/01/2020", "true", "false"
        ).map(parser::parse).forEach { assert(it == null) }
    }
}