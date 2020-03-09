package validators

import org.junit.Test
import parsers.*

class NullOrBlankTests {
    private val requiredBooleanValidator = ValueValidator(true, BooleanParser())
    private val requiredDateValidator = ValueValidator(true, DateParser())
    private val requiredDoubleValidator = ValueValidator(true, DoubleParser())
    private val requiredIntValidator = ValueValidator(true, IntParser())
    private val requiredLongValidator = ValueValidator(true, LongParser())
    private val requiredStringValidator = ValueValidator(true, StringParser())

    private val nonRequiredBooleanValidator = ValueValidator(false, BooleanParser())
    private val nonRequiredDateValidator = ValueValidator(false, DateParser())
    private val nonRequiredDoubleValidator = ValueValidator(false, DoubleParser())
    private val nonRequiredIntValidator = ValueValidator(false, IntParser())
    private val nonRequiredLongValidator = ValueValidator(false, LongParser())
    private val nonRequiredStringValidator = ValueValidator(false, StringParser())

    private val requiredValidators = listOf(
        this.requiredBooleanValidator,
        this.requiredDateValidator,
        this.requiredDoubleValidator,
        this.requiredIntValidator,
        this.requiredLongValidator,
        this.requiredStringValidator,
        ListValidator(true, ";", this.requiredBooleanValidator),
        ListValidator(true, ";", this.requiredDateValidator),
        ListValidator(true, ";", this.requiredDoubleValidator),
        ListValidator(true, ";", this.requiredIntValidator),
        ListValidator(true, ";", this.requiredLongValidator),
        ListValidator(true, ";", this.requiredStringValidator),
        ListValidator(true, ";", this.nonRequiredBooleanValidator),
        ListValidator(true, ";", this.nonRequiredDateValidator),
        ListValidator(true, ";", this.nonRequiredDoubleValidator),
        ListValidator(true, ";", this.nonRequiredIntValidator),
        ListValidator(true, ";", this.nonRequiredLongValidator),
        ListValidator(true, ";", this.nonRequiredStringValidator)
    )

    private val nonRequiredValidators = listOf(
        this.nonRequiredBooleanValidator,
        this.nonRequiredDateValidator,
        this.nonRequiredDoubleValidator,
        this.nonRequiredIntValidator,
        this.nonRequiredLongValidator,
        this.nonRequiredStringValidator,
        ListValidator(false, ";", this.requiredBooleanValidator),
        ListValidator(false, ";", this.requiredDateValidator),
        ListValidator(false, ";", this.requiredDoubleValidator),
        ListValidator(false, ";", this.requiredIntValidator),
        ListValidator(false, ";", this.requiredLongValidator),
        ListValidator(false, ";", this.requiredStringValidator),
        ListValidator(false, ";", this.nonRequiredBooleanValidator),
        ListValidator(false, ";", this.nonRequiredDateValidator),
        ListValidator(false, ";", this.nonRequiredDoubleValidator),
        ListValidator(false, ";", this.nonRequiredIntValidator),
        ListValidator(false, ";", this.nonRequiredLongValidator),
        ListValidator(false, ";", this.nonRequiredStringValidator)
    )

    private val testCases = listOf(null, "", " ", "      ", "\t", "\n")

    @Test
    fun requiredValidatorsShouldBeInvalidAndNullWhenGivenNullOrBlankValues() {
        this.requiredValidators.forEach { validator ->
            this.testCases.forEach { testCase ->
                val result = validator.validate(testCase ?: "null", testCase)
                println(result)
                assert(result.value == null)
                assert(!result.valid)
            }
        }
    }

    @Test
    fun nonRequiredValidatorsShouldBeValidAndNullWhenGivenNullOrBlankValues() {
        this.nonRequiredValidators.forEach { validator ->
            this.testCases.forEach { testCase ->
                val result = validator.validate(testCase ?: "null", testCase)
                println(result)
                assert(result.value == null)
                assert(result.valid)
            }
        }
    }
}