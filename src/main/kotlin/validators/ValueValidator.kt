package validators

import ValidationResult
import checks.Check
import parsers.Parser

/**
 * A validator to parse and validate a String value to a value of type T
 * @param T the type of the value to parse and validate
 * @property required if nulls and blanks should be invalid
 * @property parser to parse the string to an object of type T
 * @property checks to run against the parsed value
 * @constructor Creates a validator for a value of type T
 */
class ValueValidator<T>(
    private val required: Boolean,
    private val parser: Parser<T>,
    private val checks: List<Check<T>> = ArrayList()
): Validator<T> {
    private fun getNonBlankValue(value: String?) = if (value?.isBlank() == false) value else null

    /**
     * Parses a value from the given String
     *  -> Fails if the value is null or blank and the value is required
     *  -> Succeeds if the value is null or blank and the value is not required
     *  -> Fails if a non-blank value is not parse-able
     *  -> Fails if any Checks fail
     *  -> Succeeds
     * @param id of the value to parse and validate
     * @param value to parse and validate
     * @return the result of the parsing and validating
     * @see ValidationResult
     */
    override fun validate(id: String, value: String?): ValidationResult<T> {
        val nonBlankValue = getNonBlankValue(value)
            ?: return ValidationResult(null, !this.required, if (this.required) "$id: $value: A value is required" else "$id: $value: No value is required")

        val parsedValue = this.parser.parse(nonBlankValue)
            ?: return ValidationResult(null, false, "$id: $value: Could not parse value")

        return this.checks.firstOrNull { it.fails(parsedValue) }
            ?.let { ValidationResult<T>(null, false, it.errorMessage(parsedValue)) }
            ?: ValidationResult(parsedValue, true, "$id: $value: Successfully parsed to $parsedValue")
    }
}