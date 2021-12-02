package day02

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var tempValue: Int

        input
            .forEach {
                tempValue = it.substringAfter(" ").toInt()

                when (it.substringBefore(" ")) {
                    "forward" -> {
                        horizontalPosition += tempValue
                    }
                    "down" -> {
                        depth += tempValue
                    }
                    "up" -> {
                        depth -= tempValue
                    }
                }
            }

        return horizontalPosition * depth
    }

    fun part2(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0
        var tempValue: Int

        input
            .forEach {
                tempValue = it.substringAfter(" ").toInt()

                when (it.substringBefore(" ")) {
                    "forward" -> {
                        horizontalPosition += tempValue
                        depth += aim * tempValue
                    }
                    "down" -> {
                        aim += tempValue
                    }
                    "up" -> {
                        aim -= tempValue
                    }
                }
            }

        return horizontalPosition * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
