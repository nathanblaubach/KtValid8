package parsers

import org.junit.Test

class BooleanParserTests {
    private val defaultParser = BooleanParser()
    private val customParser = BooleanParser(listOf("Y"), listOf("N"))

    @Test
    fun validTrueStringsAreConvertedToBooleanTrue() {
        listOf(
            "TRUE", "True", "true", "truE", "TrUe",
            "T", "t",
            "YES", "Yes", "yes", "yES",
            "Y", "y"
        ).map(defaultParser::parse).forEach { assert(it == true) }

        listOf(
            "Y", "y"
        ).map(customParser::parse).forEach { assert(it == true) }
    }

    @Test
    fun validFalseStringsAreConvertedToBooleanFalse() {
        listOf(
            "FALSE", "False", "false",
            "F", "f",
            "NO", "No", "no",
            "N", "n"
        ).map(defaultParser::parse).forEach { assert(it == false) }

        listOf(
            "N", "n"
        ).map(customParser::parse).forEach { assert(it == false) }
    }

    @Test
    fun invalidStringsAreConvertedToNull() {
        listOf(
            "", "Hello", "12345", "123.45", "01/01/2020",
            "Tru", "Yep", "Yeah", "FLASE", "Nope", "Fa", "fals"
        ).map(defaultParser::parse).forEach { assert(it == null) }

        listOf(
            "", "Hello", "12345", "123.45", "01/01/2020",
            "Tru", "Yep", "Yeah", "FLASE", "Nope", "Fa", "fals",
            "TRUE", "True", "true",
            "T", "t",
            "YES", "Yes", "yes",
            "FALSE", "False", "false",
            "F", "f",
            "NO", "No", "no"
        ).map(customParser::parse).forEach { assert(it == null) }
    }
}