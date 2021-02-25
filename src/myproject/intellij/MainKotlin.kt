package myproject.intellij

import java.io.*
import java.math.*
import java.util.*
import java.lang.*

import kotlin.math.sqrt

public fun main(args: Array<String>) {
    MainKotlin().run()
}

private class MainKotlin {

    private fun solve() {
        val length: Int = readInt()
        out!!.println("You have entered number: $length")
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private fun sqrtLong(x: Long): Long {
        var root = sqrt(x.toDouble()).toLong()
        while (root * root > x) --root
        while ((root + 1) * (root + 1) <= x) ++root
        return root
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private fun readLong(): Long {
        return readString()!!.toLong()
    }

    private fun readInt(): Int {
        return readString()!!.toInt()
    }

    private fun readChar(): Char {
        return readString()!!.single()
    }

    private fun readBigInteger(): BigInteger {
        return BigInteger.valueOf(readLong())
    }

    private fun readString(): String? {
        while (!tok!!.hasMoreTokens()) {
            val nextLine = readLine()
            tok = StringTokenizer(nextLine)
        }
        return tok!!.nextToken()
    }

    private fun readLine(): String {
        return try {
            `in`!!.readLine()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private var `in`: BufferedReader? = null
    private var tok: StringTokenizer? = null
    private var out: PrintWriter? = null

    @Throws(FileNotFoundException::class)
    private fun initFileIO(inputFileName: String, outputFileName: String) {
        `in` = BufferedReader(FileReader(inputFileName))
        out = PrintWriter(outputFileName)
    }

    @Throws(IOException::class)
    private fun initConsoleIO() {
        `in` = BufferedReader(InputStreamReader(System.`in`))
        out = PrintWriter(System.out)
    }

    @Throws(IOException::class)
    private fun initIO() {
        Locale.setDefault(Locale.US)
        val fileName = ""
        if (fileName.isNotEmpty()) {
            initFileIO("$fileName.in", "$fileName.out")
        } else {
            if (File("input.txt").exists()) {
                initFileIO("input.txt", "output.txt")
            } else {
                initConsoleIO()
            }
        }
        tok = StringTokenizer("")
    }

    //=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    fun run() {
        try {
            initIO()
            solve()
            out!!.close()
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException(e)
        }
    }
}