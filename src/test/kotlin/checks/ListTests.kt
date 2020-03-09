package checks

import org.junit.Test
import java.text.SimpleDateFormat

class ListTests {
    private val booleanListValues = listOf(true)
    private val booleanOtherListValues = listOf(false)
    private val booleanInListCheck = InList(booleanListValues)
    private val booleanNotInListCheck = NotInList(booleanListValues)

    private val dateFormat = SimpleDateFormat("MM/dd/yyyy")
    private val dateListValues = listOf(dateFormat.parse("01/01/1938"), dateFormat.parse("03/24/2783"))
    private val dateOtherListValues = listOf(dateFormat.parse("01/02/1938"), dateFormat.parse("04/24/2783"))
    private val dateInListCheck = InList(dateListValues)
    private val dateNotInListCheck = NotInList(dateListValues)

    private val doubleListValues = listOf(1.0, 2.0, 3.0, 4.0)
    private val doubleOtherListValues = listOf(0.5, 1.5, 2.5, 3.5, 4.5)
    private val doubleInListCheck = InList(doubleListValues)
    private val doubleNotInListCheck = NotInList(doubleListValues)

    private val intListValues = listOf(1,3,5,7,9)
    private val intOtherListValues = listOf(0,2,4,6,8,10)
    private val intInListCheck = InList(intListValues)
    private val intNotInListCheck = NotInList(intListValues)

    private val longListValues = listOf<Long>(1,3,5,7,9)
    private val longOtherListValues = listOf<Long>(0,2,4,6,8,10)
    private val longInListCheck = InList(longListValues)
    private val longNotInListCheck = NotInList(longListValues)

    private val stringListValues = listOf("This", "Library", "Validates", "Stuff")
    private val stringOtherListValues = listOf("It", "Will", "Also", "Validate", "Things")
    private val stringInListCheck = InList(stringListValues)
    private val stringNotInListCheck = NotInList(stringListValues)

    @Test
    fun listValuesAreValidForInListCheck() {
        assert(this.booleanListValues.none(this.booleanInListCheck::fails))
        assert(this.dateListValues.none(this.dateInListCheck::fails))
        assert(this.doubleListValues.none(this.doubleInListCheck::fails))
        assert(this.intListValues.none(this.intInListCheck::fails))
        assert(this.longListValues.none(this.longInListCheck::fails))
        assert(this.stringListValues.none(this.stringInListCheck::fails))
    }

    @Test
    fun listValuesAreInvalidForNotInListCheck() {
        assert(this.booleanListValues.all(this.booleanNotInListCheck::fails))
        assert(this.dateListValues.all(this.dateNotInListCheck::fails))
        assert(this.doubleListValues.all(this.doubleNotInListCheck::fails))
        assert(this.intListValues.all(this.intNotInListCheck::fails))
        assert(this.longListValues.all(this.longNotInListCheck::fails))
        assert(this.stringListValues.all(this.stringNotInListCheck::fails))
    }

    @Test
    fun otherValuesAreInvalidForInListCheck() {
        assert(this.booleanOtherListValues.all(this.booleanInListCheck::fails))
        assert(this.dateOtherListValues.all(this.dateInListCheck::fails))
        assert(this.doubleOtherListValues.all(this.doubleInListCheck::fails))
        assert(this.intOtherListValues.all(this.intInListCheck::fails))
        assert(this.longOtherListValues.all(this.longInListCheck::fails))
        assert(this.stringOtherListValues.all(this.stringInListCheck::fails))
    }

    @Test
    fun otherValuesAreValidForNotInListCheck() {
        assert(this.booleanOtherListValues.none(this.booleanNotInListCheck::fails))
        assert(this.dateOtherListValues.none(this.dateNotInListCheck::fails))
        assert(this.doubleOtherListValues.none(this.doubleNotInListCheck::fails))
        assert(this.intOtherListValues.none(this.intNotInListCheck::fails))
        assert(this.longOtherListValues.none(this.longNotInListCheck::fails))
        assert(this.stringOtherListValues.none(this.stringNotInListCheck::fails))
    }
}