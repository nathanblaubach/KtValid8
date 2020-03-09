package checks

import org.junit.Test

class LengthTests {
    /**
     * Booleans and Dates can be used with these Checks, but it doesn't really make sense to
     *  -> Booleans only have two possible values: 4 or 5
     *  -> Dates only have one possible value: 28
     */

    private val doubleMinLengthCheck = LengthMin<Double>(5)
    private val doubleMaxLengthCheck = LengthMax<Double>(5)

    private val intMinLengthCheck = LengthMin<Int>(5)
    private val intMaxLengthCheck = LengthMax<Int>(5)

    private val longMinLengthCheck = LengthMin<Long>(5)
    private val longMaxLengthCheck = LengthMax<Long>(5)

    private val stringMinLengthCheck = LengthMin<String>(5)
    private val stringMaxLengthCheck = LengthMax<String>(5)

    @Test
    fun doubleLengthTests() {
        assert(this.doubleMinLengthCheck.fails(12.3))    // Just shorter than the Min
        assert(!this.doubleMinLengthCheck.fails(12.34))  // At The Min
        assert(!this.doubleMinLengthCheck.fails(12.345)) // Just longer than the Min

        assert(!this.doubleMaxLengthCheck.fails(12.3))   // Just shorter than the Max
        assert(!this.doubleMaxLengthCheck.fails(12.34))  // At The Max
        assert(this.doubleMaxLengthCheck.fails(12.345))  // Just longer than the Max

        assert(this.doubleMinLengthCheck.fails(12.30))   // Trailing Zeroes don't count
        assert(!this.doubleMinLengthCheck.fails(123.0))  // unless next to the decimal

        assert(this.doubleMinLengthCheck.fails(012.3))   // Leading Zeroes don't count (See exception below)
        assert(!this.doubleMinLengthCheck.fails(0.123))  // unless next to the decimal
    }

    @Test
    fun intLengthTests() {
        assert(this.intMinLengthCheck.fails(1234))    // Just shorter than the Min
        assert(!this.intMinLengthCheck.fails(12345))  // At The Min
        assert(!this.intMinLengthCheck.fails(123456)) // Just longer than the Min

        assert(!this.intMaxLengthCheck.fails(1234))   // Just shorter than the Max
        assert(!this.intMaxLengthCheck.fails(12345))  // At The Max
        assert(this.intMaxLengthCheck.fails(123456))  // Just longer than the Max
    }

    @Test
    fun longLengthTests() {
        assert(this.longMinLengthCheck.fails(1234))    // Just shorter than the Min
        assert(!this.longMinLengthCheck.fails(12345))  // At The Min
        assert(!this.longMinLengthCheck.fails(123456)) // Just longer than the Min

        assert(!this.longMaxLengthCheck.fails(1234))   // Just shorter than the Max
        assert(!this.longMaxLengthCheck.fails(12345))  // At The Max
        assert(this.longMaxLengthCheck.fails(123456))  // Just longer than the Max
    }

    @Test
    fun stringLengthTests() {
        assert(this.stringMinLengthCheck.fails("1234"))    // Just shorter than the Min
        assert(!this.stringMinLengthCheck.fails("12345"))  // At The Min
        assert(!this.stringMinLengthCheck.fails("123456")) // Just longer than the Min

        assert(!this.stringMaxLengthCheck.fails("1234"))   // Just shorter than the Max
        assert(!this.stringMaxLengthCheck.fails("12345"))  // At The Max
        assert(this.stringMaxLengthCheck.fails("123456"))  // Just longer than the Max
    }
}