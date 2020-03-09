package checks

import java.util.Date

/**
 * A check to ensure that a Date complies with a minimum
 * @property minimum the maximum Date
 * @constructor Creates a Check for a minimum Date
 */
class DateMin(private val minimum: Date): Check<Date> {
    /**
     * Determines whether the given value violates the minimum
     * @param value to check
     * @return true if less than the minimum, false if not
     */
    override fun fails(value: Date): Boolean = value.before(minimum)

    /**
     * Creates an error message with the value and the minimum
     * @return the error message
     */
    override fun errorMessage(value: Date): String = "$value is before the earliest valid date of $minimum"
}
