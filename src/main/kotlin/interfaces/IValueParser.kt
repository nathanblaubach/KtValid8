package interfaces

/**
 * A parser to parse a String value to a given type
 * @param T the type of the value to parse
 */
interface IValueParser<T> {
    /**
     * Parses a value from the given String
     * @param value to parse
     * @return the parsed value, null if could not parse
     */
    fun parse(value: String): T?
}
