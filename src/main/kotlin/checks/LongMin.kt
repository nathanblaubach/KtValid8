package checks

import interfaces.IValueChecker

/**
 * A check to ensure that a Long complies with a minimum
 * @property minimum the maximum Long
 * @constructor Creates a Check for a minimum Long
 */
class LongMin(private val minimum: Long): IValueChecker<Long> {
    /**
     * Determines whether the given value violates the minimum
     * @param value to check
     * @return true if less than the minimum, false if not
     */
    override fun fails(value: Long): Boolean = value < minimum

    /**
     * Creates an error message with the value and the minimum
     * @return the error message
     */
    override fun errorMessage(value: Long): String = "$value is below the minimum valid value of $minimum"
}
