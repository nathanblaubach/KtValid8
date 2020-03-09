package checks

/**
 * A check to make against a value of a given type
 * @param T the type of the value to check
 */
interface Check<T> {
    /**
     * Determines whether the given value fails the check
     * @param value to check
     * @return true if fails, false if passes
     */
    fun fails(value: T): Boolean

    /**
     * Creates an error message that specifies why the value failed the check
     * @return the error message
     */
    fun errorMessage(value: T): String
}
