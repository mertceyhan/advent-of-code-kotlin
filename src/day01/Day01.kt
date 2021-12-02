package day01

import readInput

fun main() {
    fun part1(measurements: List<Int>): Int {
        var counter = 0
        var lastMeasurement = measurements.first()

        measurements.forEach { measurement ->
            if (measurement > lastMeasurement) {
                counter++
            }
            lastMeasurement = measurement
        }

        return counter
    }

    fun part2(measurements: List<Int>): Int {
        val list = arrayListOf<Int>()

        for (i in 0..measurements.lastIndex) {
            if (i + 3 > measurements.lastIndex) {
                list.add(measurements.subList(i, measurements.size).sum())
                break
            } else {
                list.add(measurements.subList(i, i + 3).sum())
            }
        }

        return part1(list)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test").map(String::toInt)
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01").map(String::toInt)
    println(part1(input))
    println(part2(input))
}
