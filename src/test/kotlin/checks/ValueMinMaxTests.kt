package checks

import org.junit.Test
import java.text.SimpleDateFormat

class ValueMinMaxTests {
    private val dateFormat = SimpleDateFormat("MM/dd/yyyy")

    private val dateBelow = this.dateFormat.parse("06/07/2930")
    private val dateBound = this.dateFormat.parse("06/08/2930")
    private val dateAbove = this.dateFormat.parse("06/09/2930")
    private val dateMinCheck = DateMin(this.dateBound)
    private val dateMaxCheck = DateMax(this.dateBound)

    private val doubleBelow = 174.4828
    private val doubleBound = 174.4829
    private val doubleAbove = 174.4830
    private val doubleMinCheck = DoubleMin(this.doubleBound)
    private val doubleMaxCheck = DoubleMax(this.doubleBound)

    private val intBelow = 173
    private val intBound = 174
    private val intAbove = 175
    private val intMinCheck = IntMin(this.intBound)
    private val intMaxCheck = IntMax(this.intBound)

    private val longBelow = 2147483649
    private val longBound = 2147483650
    private val longAbove = 2147483651
    private val longMinCheck = LongMin(this.longBound)
    private val longMaxCheck = LongMax(this.longBound)

    @Test
    fun valuesBelowMinAreInvalid() {
        assert(dateMinCheck.fails(dateBelow))
        assert(doubleMinCheck.fails(doubleBelow))
        assert(intMinCheck.fails(intBelow))
        assert(longMinCheck.fails(longBelow))
    }

    @Test
    fun valuesAtOrAboveMinAreValid() {
        assert(!dateMinCheck.fails(dateBound))
        assert(!doubleMinCheck.fails(doubleBound))
        assert(!intMinCheck.fails(intBound))
        assert(!longMinCheck.fails(longBound))

        assert(!dateMinCheck.fails(dateAbove))
        assert(!doubleMinCheck.fails(doubleAbove))
        assert(!intMinCheck.fails(intAbove))
        assert(!longMinCheck.fails(longAbove))
    }

    @Test
    fun valuesBelowOrAtMaxAreValid() {
        assert(!dateMaxCheck.fails(dateBelow))
        assert(!doubleMaxCheck.fails(doubleBelow))
        assert(!intMaxCheck.fails(intBelow))
        assert(!longMaxCheck.fails(longBelow))

        assert(!dateMaxCheck.fails(dateBound))
        assert(!doubleMaxCheck.fails(doubleBound))
        assert(!intMaxCheck.fails(intBound))
        assert(!longMaxCheck.fails(longBound))
    }

    @Test
    fun valuesAboveMaxAreInvalid() {
        assert(dateMaxCheck.fails(dateAbove))
        assert(doubleMaxCheck.fails(doubleAbove))
        assert(intMaxCheck.fails(intAbove))
        assert(longMaxCheck.fails(longAbove))
    }
}