package checks

/**
 * A check to ensure that a Double complies with a maximum
 * @property maximum the maximum Double
 * @constructor Creates a Check for a maximum Double
 */
class DoubleMax(private val maximum: Double): Check<Double> {
    /**
     * Determines whether the given value violates the maximum
     * @param value to check
     * @return true if greater than the maximum, false if not
     */
    override fun fails(value: Double): Boolean = value > maximum

    /**
     * Creates an error message with the value and the maximum
     * @return the error message
     */
    override fun errorMessage(value: Double): String = "$value is above the maximum valid value of $maximum"
}
