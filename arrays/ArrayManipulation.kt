package arrays

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val array = LongArray(n) // Initialize the array with zeros

    // Perform operations on the array
    for (query in queries) {
        val leftIndex = query[0] - 1 // Adjust for 1-indexed array
        val rightIndex = query[1] - 1 // Adjust for 1-indexed array
        val valueToAdd = query[2].toLong()

        array[leftIndex] += valueToAdd
        if (rightIndex + 1 < n) {
            array[rightIndex + 1] -= valueToAdd
        }
    }

    // Calculate the maximum prefix sum to find the maximum value in the array
    var maxSum = 0L
    var currentSum = 0L
    for (value in array) {
        currentSum += value
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}

fun main() {
    arrayManipulation(5,
        arrayOf(
            arrayOf(1,2,100),
            arrayOf(2,5,100),
            arrayOf(3,4,100)
        )
    )
} 