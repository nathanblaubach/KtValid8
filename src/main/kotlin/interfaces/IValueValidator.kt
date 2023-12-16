package interfaces

import validators.ValidationResult

/**
 * A validator to parse and validate a String value
 * @param T the type of the value to parse and validate
 */
interface IValueValidator<T> {
    /**
     * Parses a value from the given String
     * @param id of the value to parse and validate
     * @param value to parse and validate
     * @return the result of the parsing and validating
     * @see ValidationResult
     */
    fun validate(id: String, value: String?): ValidationResult<T>
}
