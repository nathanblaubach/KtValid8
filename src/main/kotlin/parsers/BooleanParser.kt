package parsers

import interfaces.IValueParser

/**
 * A parser to parse a String value to a Boolean value
 * @property insensitiveTrueValues case-insensitive String values to accept as Boolean true
 * @property insensitiveFalseValues case-insensitive String values to accept as Boolean false
 * @constructor Creates a Parser for Boolean values
 * @param trueValues case-insensitive String values to accept as Boolean true
 * @param falseValues case-insensitive String values to accept as Boolean false
 */
class BooleanParser(
    trueValues: List<String> = listOf("true", "t", "yes", "y"),
    falseValues: List<String> = listOf("false", "f", "no", "n")
) : IValueParser<Boolean> {
    private val insensitiveTrueValues: List<String> = trueValues.map(String::toUpperCase)
    private val insensitiveFalseValues: List<String> = falseValues.map(String::toUpperCase)

    /**
     * Parses a Boolean from the given String
     * @param value to parse
     * @return the parsed Boolean, null if could not parse
     */
    override fun parse(value: String): Boolean? = when (value.toUpperCase()) {
        in insensitiveTrueValues -> true
        in insensitiveFalseValues -> false
        else -> null
    }
}
