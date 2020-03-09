package checks

/**
 * A check to ensure that a value is in a list
 * @param T type of value
 * @property validValues the list of valid values
 * @constructor Creates a Check for a list of valid values
 */
class InList<T>(private val validValues: List<T>) : Check<T> {
    /**
     * Determines whether the given value is not in the valid value list
     * @param value to check
     * @return true if not in list, false if it is
     */
    override fun fails(value: T): Boolean = !validValues.contains(value)

    /**
     * Creates an error message with the value and full list of valid values
     * @return the error message
     */
    override fun errorMessage(value: T): String = "$value was not found in the list of valid values: (${validValues.joinToString(", ")})"
}
