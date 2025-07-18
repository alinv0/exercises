package string

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'sherlockAndAnagrams' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun sherlockAndAnagrams(s: String): Int {
    var totalAnagrams = 0;
    for (i in 0..s.length-1) {
        println(s[i])
    }

    return totalAnagrams;
}

fun areAnagrams(s1: String, s2: String): Boolean {
    val tmpStr = "" + s1

    if(s1.length != s2.length) {
        return false
    }

    for (c in s2) {
        val i = tmpStr.indexOf(c)
        if(i>0) {
            tmpStr.removeRange(i, i + 1)
        }
    }

    return tmpStr.isEmpty()
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = sherlockAndAnagrams(s)

        println(result)
    }
} 