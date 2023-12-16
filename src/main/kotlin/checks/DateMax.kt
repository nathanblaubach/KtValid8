package checks

import interfaces.IValueChecker
import java.util.Date

/**
 * A check to ensure that a Date complies with a maximum
 * @property maximum the maximum Date
 * @constructor Creates a Check for a maximum Date
 */
class DateMax(private val maximum: Date): IValueChecker<Date> {
    /**
     * Determines whether the given value violates the maximum
     * @param value to check
     * @return true if greater than the maximum, false if not
     */
    override fun fails(value: Date): Boolean = value.after(maximum)

    /**
     * Creates an error message with the value and the maximum
     * @return the error message
     */
    override fun errorMessage(value: Date): String = "$value is after the latest valid date of $maximum"
}
