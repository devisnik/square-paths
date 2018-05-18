package util

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun writeSolutionToFile(path: String, solution: IntArray) {
    Files.write(Paths.get("solutions", path), solution.map(Int::toString), StandardOpenOption.CREATE_NEW)
}

fun readSolutionFromFile(path: String): IntArray =
        Files.readAllLines(Paths.get("solutions", path)).map(Integer::parseInt).toIntArray()
