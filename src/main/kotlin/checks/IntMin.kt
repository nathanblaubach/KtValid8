package checks

import interfaces.IValueChecker

/**
 * A check to ensure that a Int complies with a minimum
 * @property minimum the maximum Int
 * @constructor Creates a Check for a minimum Int
 */
class IntMin(private val minimum: Int) : IValueChecker<Int> {
    /**
     * Determines whether the given value violates the minimum
     * @param value to check
     * @return true if less than the minimum, false if not
     */
    override fun fails(value: Int): Boolean = value < minimum

    /**
     * Creates an error message with the value and the minimum
     * @return the error message
     */
    override fun errorMessage(value: Int): String = "$value is below the minimum valid value of $minimum"
}
