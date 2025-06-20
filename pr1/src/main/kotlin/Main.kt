package org.example.charset

import java.io.File
import org.example.charset.CharsetUtils

fun main() {
    val inputFile = File("C:/file.txt")
    val encoding = CharsetUtils.guessCharset(inputFile)
    val fileContents = inputFile.readText(encoding)
    println("Charset detected: $encoding")
    println("Contents of the file:\n$fileContents")
}
