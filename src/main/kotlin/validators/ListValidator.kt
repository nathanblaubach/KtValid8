package validators

import ValidationResult

/**
 * A validator to parse and validate a String value
 * @param T the type of the value to parse and validate
 * @property required if nulls and blanks should be invalid
 * @property delimiter that separates individual values in the string
 * @property validator that validates each individual value in the string
 * @constructor Creates a validator for a list of values of the same type delimited by a character
 */
class ListValidator<T>(
    private val required: Boolean,
    private val delimiter: String,
    private val validator: ValueValidator<T>
): Validator<List<T?>> {
    private fun getNonBlankValue(value: String?) = if (value?.isBlank() == false) value else null

    /**
     * Parses a value from the given String
     *  -> Fails if the value is null or blank and the value is required
     *  -> Succeeds if the value is null or blank and the value is not required
     *  -> Fails if any of the values in the delimited list fail the validator validate method
     *  -> Succeeds
     * @param id of the value to parse and validate
     * @param value to parse and validate
     * @return the result of the parsing and validating
     * @see ValidationResult
     */
    override fun validate(id: String, value: String?): ValidationResult<List<T?>> {
        val nonBlankValue = getNonBlankValue(value)
            ?: return ValidationResult(null, !this.required, if (this.required) "$id: $value: A value is required" else "$id: $value: No value is required")

        val results = nonBlankValue
            .split(this.delimiter)
            .map{ this.validator.validate(id, it) }

        return ValidationResult(
            results.map{ it.value },
            results.all { it.valid },
            results.joinToString("\n") { it.message }
        )
    }
}
