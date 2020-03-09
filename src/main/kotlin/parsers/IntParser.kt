package parsers

/**
 * A parser to parse a String value to a Int value
 * @constructor Creates a Parser for Int values
 */
class IntParser : Parser<Int> {
    /**
     * Parses a Int from the given String
     * @param value to parse
     * @return the parsed Int, null if could not parse
     */
    override fun parse(value: String): Int? = value.toIntOrNull()
}
