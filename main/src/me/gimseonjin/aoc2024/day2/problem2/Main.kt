package me.gimseonjin.aoc2024.day2.problem2

import kotlin.math.abs

fun readFile(
    filename: String
): List<String> {
    val inputStream = java.io.File(filename).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    return lineList
}

fun isAscending(
    current:Int,
    next: Int
): Boolean {
    return current < next
}

fun isDescending(
    current:Int,
    next: Int
): Boolean {
    return current > next
}

fun isWithinRange(
    current:Int,
    next: Int,
    range:Int
): Boolean {
    return abs(next - current) <= range
}

fun deleteAt(
    str: List<Int>,
    index: Int
): List<Int> {
    return str.filterIndexed { i, _ -> i != index }
}

fun main(){
    val inputLines: List<String> = readFile("main/src/me/gimseonjin/aoc2024/day2/problem2/input.txt")

    val reports = inputLines.map { it.split(" ").map { it.trim() }.map { it.toInt() } }

    val safeReportCount = reports.count { currentReport ->

            IntRange(0, currentReport.size).any { index ->
                val newReport = deleteAt(currentReport, index)

                val isAsc = newReport.zipWithNext().all { (current, next) ->
                    isAscending(current, next)
                }

                val isDsc = newReport.zipWithNext().all { (current, next) ->
                    isDescending(current, next)
                }

                val isWithin = newReport.zipWithNext().all { (current, next) ->
                    isWithinRange(current, next, 3)
                }

                (isAsc || isDsc) && isWithin
            }
        }

    println(safeReportCount)
}