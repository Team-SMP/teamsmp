package uk.teamsmp.aetherium.utils

object Utils {
    fun smallCaps(input: String): String {
        val smallCapsMap = mapOf(
            'A' to 'ᴀ', 'B' to 'ʙ', 'C' to 'ᴄ', 'D' to 'ᴅ',
            'E' to 'ᴇ', 'F' to 'ғ', 'G' to 'ɢ', 'H' to 'ʜ',
            'I' to 'ɪ', 'J' to 'ᴊ', 'K' to 'ᴋ', 'L' to 'ʟ',
            'M' to 'ᴍ', 'N' to 'ɴ', 'O' to 'ᴏ', 'P' to 'ᴘ',
            'Q' to 'Q', 'R' to 'ʀ', 'S' to 's', 'T' to 'ᴛ',
            'U' to 'ᴜ', 'V' to 'ᴠ', 'W' to 'ᴡ', 'X' to 'x',
            'Y' to 'ʏ', 'Z' to 'ᴢ',
            'a' to 'ᴀ', 'b' to 'ʙ', 'c' to 'ᴄ', 'd' to 'ᴅ',
            'e' to 'ᴇ', 'f' to 'ғ', 'g' to 'ɢ', 'h' to 'ʜ',
            'i' to 'ɪ', 'j' to 'ᴊ', 'k' to 'ᴋ', 'l' to 'ʟ',
            'm' to 'ᴍ', 'n' to 'ɴ', 'o' to 'ᴏ', 'p' to 'ᴘ',
            'q' to 'q', 'r' to 'ʀ', 's' to 's', 't' to 'ᴛ',
            'u' to 'ᴜ', 'v' to 'ᴠ', 'w' to 'ᴡ', 'x' to 'x',
            'y' to 'ʏ', 'z' to 'ᴢ'
        )

        return input.map { smallCapsMap[it] ?: it }.joinToString("")
    }
}