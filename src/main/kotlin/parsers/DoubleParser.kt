package parsers

import interfaces.IValueParser

/**
 * A parser to parse a String value to a Double value
 * @constructor Creates a Parser for Double values
 */
class DoubleParser : IValueParser<Double> {
    /**
     * Parses a Double from the given String
     * @param value to parse
     * @return the parsed Double, null if could not parse
     */
    override fun parse(value: String): Double? = value.toDoubleOrNull()
}
