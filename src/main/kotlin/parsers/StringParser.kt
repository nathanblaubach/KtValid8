package parsers

import interfaces.IValueParser

/**
 * A parser to parse a String value to a String value
 * @constructor Creates a Parser for String values
 */
class StringParser : IValueParser<String> {
    /**
     * Parses a String from the given String
     * @param value to parse
     * @return the given String
     */
    override fun parse(value: String): String = value
}
