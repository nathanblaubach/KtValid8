package checks

import interfaces.IValueChecker

/**
 * A check to ensure that an Int complies with a maximum
 * @property maximum the maximum Int
 * @constructor Creates a Check for a maximum Int
 */
class IntMax(private val maximum: Int): IValueChecker<Int> {
    /**
     * Determines whether the given value violates the maximum
     * @param value to check
     * @return true if greater than the maximum, false if not
     */
    override fun fails(value: Int): Boolean = value > maximum

    /**
     * Creates an error message with the value and the maximum
     * @return the error message
     */
    override fun errorMessage(value: Int): String = "$value is above the maximum valid value of $maximum"
}
