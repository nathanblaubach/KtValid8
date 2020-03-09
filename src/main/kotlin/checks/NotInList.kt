package checks

/**
 * A check to ensure that a value is not in a list
 * @param T type of value
 * @property invalidValues the list of invalid values
 * @constructor Creates a Check for a list of invalid values
 */
class NotInList<T> (private val invalidValues: List<T>) : Check<T> {
    /**
     * Determines whether the given value is in the invalid value list
     * @param value to check
     * @return true if in list, false if not
     */
    override fun fails(value: T): Boolean = invalidValues.contains(value)

    /**
     * Creates an error message with the value and full list of invalid values
     * @return the error message
     */
    override fun errorMessage(value: T): String = "$value was found in the list of invalid values: (${invalidValues.joinToString(", ")})"
}
