/**
 * An object to represent the result of parsing and validating a string
 * @param T type of value
 * @property value the parsed value (null if empty or not valid)
 * @property valid whether the validation passed or failed
 * @property message message that explains why the validation passed or failed
 * @constructor Creates a result
 */
data class ValidationResult<T>(
    val value: T?,
    val valid: Boolean,
    val message: String
)