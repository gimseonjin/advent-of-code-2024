package me.gimseonjin.aoc2024.day1.problem2

fun main() {
    val inputLines: List<String> =
        me.gimseonjin.aoc2024.day1.problem1.readFile("main/src/me/gimseonjin/aoc2024/day1/problem1/input.txt")

    val (sortedLeftList, sortedRightList) = me.gimseonjin.aoc2024.day1.problem1.splitAndSort(
        inputLines
    )

    val totalSimilarityScores = sortedLeftList
        .map { left ->
            val similarityScore = sortedRightList.count { right -> left.toInt() == right.toInt() }
            left.toInt() * similarityScore
        }
        .sum()

    print(totalSimilarityScores)
}