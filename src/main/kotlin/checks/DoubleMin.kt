package checks

/**
 * A check to ensure that a Double complies with a minimum
 * @property minimum the maximum Double
 * @constructor Creates a Check for a minimum Double
 */
class DoubleMin(private val minimum: Double): Check<Double> {
    /**
     * Determines whether the given value violates the minimum
     * @param value to check
     * @return true if less than the minimum, false if not
     */
    override fun fails(value: Double): Boolean = value < minimum

    /**
     * Creates an error message with the value and the minimum
     * @return the error message
     */
    override fun errorMessage(value: Double): String = "$value is below the minimum valid value of $minimum"
}
