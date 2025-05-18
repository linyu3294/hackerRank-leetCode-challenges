/**
 Do not return anything, modify nums1 in-place instead.
 */
function twoSum(numbers, target) {
    // Use a plain object to store number -> index mapping
    var indexMap = {};
    for (var i = 0; i < numbers.length; i++) {
        var num = numbers[i];
        var complement = target - num;
        // Check if complement exists in indexMap
        if (indexMap.hasOwnProperty(complement)) {
            // Return 1-based indices (if needed)
            return [indexMap[complement] + 1, i + 1];
        }
        // Store the current number's index
        indexMap[num] = i;
    }
    return [-1, -1];
}
var result1 = twoSum([2, 7, 11, 15], 9);
var expectedResult1 = [1, 2];
console.log("Test 1 expecting: ".concat(expectedResult1, " | Actual result: ").concat(result1));
var result2 = twoSum([2, 3, 4], 6);
var expectedResult2 = [1, 3];
console.log("Test 2 expecting: ".concat(expectedResult2, " | Actual result: ").concat(result2));
