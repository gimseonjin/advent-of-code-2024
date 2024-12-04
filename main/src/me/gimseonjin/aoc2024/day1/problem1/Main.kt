package me.gimseonjin.aoc2024.day1.problem1

import java.io.File
import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.math.abs

fun readFile(
    filename: String
): List<String> {
    val inputStream = File(filename).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    return lineList
}

fun splitAndSort(
    lineList: List<String>
): Pair<List<String>, List<String>> {
    val leftList = mutableListOf<String>()
    val rightList = mutableListOf<String>()

    lineList.forEach({
        val (left, right) = it.split("  ")

        leftList.add(left.trim())
        rightList.add(right.trim())
    })

    return Pair(leftList.sorted(), rightList.sorted())
}

fun main() {
    val inputLines: List<String> = readFile("main/src/me/gimseonjin/aoc2024/day1/problem1/input.txt")

    val (sortedLeftList, sortedRightList) = splitAndSort(inputLines)

    val listSize = inputLines.size
    val totalDifference = IntStream.range(0, listSize)
        .map { index -> abs(sortedLeftList[index].toInt() - sortedRightList[index].toInt()) }
        .boxed()
        .collect(Collectors.toList())
        .sum()

    print(totalDifference)
}
