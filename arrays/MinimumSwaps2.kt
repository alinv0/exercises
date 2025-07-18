package arrays

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */

fun main() {
    var arr = intArrayOf(1, 4, 2, 3)
    minimumSwaps(arr.toTypedArray())
}

fun minimumSwaps(arr: Array<Int>): Int {
    var unordered = false;
    var swaps = 0;
    while(!unordered) {
        unordered = true;
        for (i in arr.indices) {
            if (arr[i] != i + 1) {
                unordered = false
                swap(arr, i)
                swaps++
            }
        }
    }

    println(swaps)
    return swaps
}

private fun swap(arr: Array<Int>, i: Int) {
    val tmpPosition = arr[i]-1
    val tmp = arr[i]
    arr[i] = arr[tmpPosition]
    arr[tmpPosition] = tmp
} 