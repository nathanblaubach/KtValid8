package parsers

/**
 * A parser to parse a String value to a Long value
 * @constructor Creates a Parser for Long values
 */
class LongParser : Parser<Long> {
    /**
     * Parses a Long from the given String
     * @param value to parse
     * @return the parsed Long, null if could not parse
     */
    override fun parse(value: String): Long? = value.toLongOrNull()
}
