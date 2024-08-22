package parsers

import interfaces.IValueParser

/**
 * A parser to parse a String value to a Int value
 * @constructor Creates a Parser for Int values
 */
class IntParser : IValueParser<Int> {
    /**
     * Parses an Int from the given String
     * @param value to parse
     * @return the parsed Int, null if it could not parse
     */
    override fun parse(value: String): Int? = value.toIntOrNull()
}
