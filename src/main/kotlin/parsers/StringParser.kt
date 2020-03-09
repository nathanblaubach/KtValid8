package parsers

/**
 * A parser to parse a String value to a String value
 * @constructor Creates a Parser for String values
 */
class StringParser : Parser<String> {
    /**
     * Parses a String from the given String
     * @param value to parse
     * @return the given String
     */
    override fun parse(value: String): String? = value
}
