package me.gimseonjin.aoc2024.day2.problem1

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

fun main(){
    val inputLines: List<String> = readFile("main/src/me/gimseonjin/aoc2024/day2/problem1/input.txt")

    val safeReportCount = inputLines
        .map { it.split(" ").map { it.trim() }.map { it.toInt() } }
        .count { dataInReports ->
            val isAsc = dataInReports.zipWithNext().all { (current, next) ->
                isAscending(current, next)
            }

            val isDsc = dataInReports.zipWithNext().all { (current, next) ->
                isDescending(current, next)
            }

            val isWithin = dataInReports.zipWithNext().all { (current, next) ->
                isWithinRange(current, next, 3)
            }

            (isAsc || isDsc) && isWithin
        }

    print(safeReportCount)
}