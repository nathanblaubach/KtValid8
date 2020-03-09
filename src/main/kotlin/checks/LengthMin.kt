package checks

/**
 * A check to ensure that a value complies with a minimum String length
 * @param T type of value
 * @property minimum the minimum length of the string representation of the value
 * @constructor Creates a Check for minimum String length
 */
class LengthMin<T>(private val minimum: Int) : Check<T> {
    /**
     * Determines whether the given value violates the minimum
     * @param value to check
     * @return true if less than the minimum, false if not
     */
    override fun fails(value: T): Boolean = value.toString().length < minimum

    /**
     * Creates an error message with the value and the minimum
     * @return the error message
     */
    override fun errorMessage(value: T): String = "$value is shorter than the minimum valid length of $minimum"
}
