package checks

/**
 * A check to ensure that a value complies with a maximum String length
 * @param T type of value
 * @property maximum the maximum length of the string representation of the value
 * @constructor Creates a Check for maximum String length
 */
class LengthMax<T>(private val maximum: Int) : Check<T> {
    /**
     * Determines whether the given value violates the maximum length
     * @param value to check
     * @return true if greater than the maximum length, false if not
     */
    override fun fails(value: T): Boolean = value.toString().length > maximum

    /**
     * Creates an error message with the value and the maximum length
     * @return the error message
     */
    override fun errorMessage(value: T): String = "$value is longer than the maximum valid length of $maximum"
}
