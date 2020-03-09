package parsers

import org.junit.Test

class StringParserTests {
    private val parser = StringParser()

    @Test
    fun stringsAreWhateverTheyWerePassedInAs() {
        listOf("How", "Many", "Strings", "Do", "I", "Need", "To", "Convince", "You", "That", "It's", "True", "?")
            .forEach{ assert(it == this.parser.parse(it)) }
    }
}