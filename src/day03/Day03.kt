package day03

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var gamaRate = ""
        var epsilonRate = ""

        for (i in 0..input.first().lastIndex) {
            input.groupBy { it[i] }.run {
                if (this['1']?.size!! > this['0']?.size!!) {
                    gamaRate += "1"
                    epsilonRate += "0"
                } else {
                    gamaRate += "0"
                    epsilonRate += "1"
                }
            }
        }

        return gamaRate.toInt(radix = 2) * epsilonRate.toInt(radix = 2)
    }

    fun part2(input: List<String>): Int {
        val oxygenGeneratorRatingList = ArrayList(input)
        val co2ScrubberRatingList = ArrayList(input)
        var tempIndex = 0

        while (true) {
            if (oxygenGeneratorRatingList.size == 1) {
                tempIndex = 0
                break
            }

            oxygenGeneratorRatingList.groupBy { it[tempIndex] }.run {
                if (this['1']?.size!! >= this['0']?.size!!) {
                    this['0']?.forEach {
                        oxygenGeneratorRatingList.remove(it)
                    }
                } else {
                    this['1']?.forEach {
                        oxygenGeneratorRatingList.remove(it)
                    }
                }
            }

            if (tempIndex == input.first().lastIndex) {
                tempIndex = 0
            } else {
                tempIndex++
            }
        }

        while (true) {
            if (co2ScrubberRatingList.size == 1) {
                tempIndex = 0
                break
            }

            co2ScrubberRatingList.groupBy { it[tempIndex] }.run {
                if (this['1']?.size!! >= this['0']?.size!!) {
                    this['1']?.forEach {
                        co2ScrubberRatingList.remove(it)
                    }
                } else {
                    this['0']?.forEach {
                        co2ScrubberRatingList.remove(it)
                    }
                }
            }

            if (tempIndex == input.first().lastIndex) {
                tempIndex = 0
            } else {
                tempIndex++
            }
        }

        return oxygenGeneratorRatingList.first().toInt(radix = 2) * co2ScrubberRatingList.first().toInt(radix = 2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
