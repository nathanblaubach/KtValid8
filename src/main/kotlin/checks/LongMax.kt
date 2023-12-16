package checks

import interfaces.IValueChecker

/**
 * A check to ensure that a Long complies with a maximum
 * @property maximum the maximum Long
 * @constructor Creates a Check for a maximum Long
 */
class LongMax(private val maximum: Long): IValueChecker<Long> {
    /**
     * Determines whether the given value violates the maximum
     * @param value to check
     * @return true if greater than the maximum, false if not
     */
    override fun fails(value: Long): Boolean = value > maximum

    /**
     * Creates an error message with the value and the maximum
     * @return the error message
     */
    override fun errorMessage(value: Long): String = "$value is above the maximum valid value of $maximum"
}
