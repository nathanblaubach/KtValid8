package parsers

import interfaces.IValueParser
import java.text.SimpleDateFormat
import java.util.*

/**
 * A parser to parse a String value to a Date value
 * @property validFormats non-lenient SimpleDateFormat objects used to parse dates from strings
 * @constructor Creates a Parser for Date values
 * @param validFormatStrings String formats to be converted to non-lenient SimpleDateFormat objects
 */
class DateParser(
    validFormatStrings: List<String> = listOf("MM/dd/yyyy", "yyyy-MM-dd")
) : IValueParser<Date> {
    private val validFormats = validFormatStrings
        .map { SimpleDateFormat(it) }
        .also { it.forEach { format -> format.isLenient = false } }

    /**
     * Parses a Date from the given String
     * @param value to parse
     * @return the parsed Date, null if could not parse
     */
    override fun parse(value: String): Date? = this.validFormats
        .mapNotNull{ try { it.parse(value) } catch (ex: Exception) { null } }
        .firstOrNull()
}
