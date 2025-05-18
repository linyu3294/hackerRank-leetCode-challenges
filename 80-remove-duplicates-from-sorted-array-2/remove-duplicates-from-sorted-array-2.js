function removeDuplicates(nums) {
    var i = 2;
    var k = 0;
    for (var j = 2; j < nums.length; j++) {
        if (nums[j] !== nums[i - 2]) {
            nums[i] = nums[j];
            i++;
            k++;
        }
    }
    for (var h = 0; h < nums.length; h++) {
        if (h >= k) {
            nums[h] = -1;
        }
    }
    return nums;
}
;
var result1 = removeDuplicates([1, 1, 1, 2, 2, 3]);
var expectedResult1 = [1, 1, 2, 2, 3, -1];
console.log("Test 1 expecting: ".concat(expectedResult1, " | Actual result: ").concat(result1));
var result2 = removeDuplicates([0, 0, 1, 1, 1, 1, 2, 3, 3]);
var expectedResult2 = [0, 0, 1, 1, 2, 3, 3, -1, -1];
console.log("Test 2 expecting: ".concat(expectedResult2, " | Actual result: ").concat(result2));
