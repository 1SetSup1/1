package org.example.charset

import java.io.File
import java.nio.charset.Charset

object CharsetUtils {
    fun guessCharset(target: File): Charset {
        val data = target.readBytes()
        return when {
            data.size >= 2 && data[0] == 0xFE.toByte() && data[1] == 0xFF.toByte() -> Charset.forName("UTF-16BE")
            data.size >= 2 && data[0] == 0xFF.toByte() && data[1] == 0xFE.toByte() -> Charset.forName("UTF-16LE")
            else -> Charset.forName("UTF-8")
        }
    }
} 