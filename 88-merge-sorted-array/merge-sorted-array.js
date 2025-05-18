/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1, m, nums2, n) {
    var j = 0;
    var k = 0;
    if (n < 1) {
        return nums1;
    }
    if (m < 1 && n >= 1) {
        for (var l = 0; l < nums2.length; l++) {
            nums1.splice(l, 0, nums2[l]);
        }
        return nums1.splice(0, n);
    }
    for (var i = 0; i < n + m + n; i++) {
        if (nums2[k] <= nums1[j]) {
            nums1.splice(j, 0, nums2[k]);
            j++;
            k++;
            continue;
        }
        if (j - k === m) {
            console.log("j: ".concat(j, " | k: ").concat(k, " | nums2[k+1]: ").concat(nums2[k]));
            nums1.splice(j, 0, nums2[k]);
            j++;
            k++;
            continue;
        }
        j++;
    }
    return nums1.splice(0, m + n);
}
;
var test = function () {
    var result1 = merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3);
    var expectedResult1 = [1, 2, 2, 3, 5, 6];
    console.log("Test 1 expecting: ".concat(expectedResult1, " | Actual result: ").concat(result1));
    var result2 = merge([1], 1, [], 0);
    var expectedResult2 = [1];
    console.log("Test 2 expecting: ".concat(expectedResult2, " | Actual result: ").concat(result2));
    var result3 = merge([0], 0, [1], 1);
    var expectedResult3 = [1];
    console.log("Test 3 expecting: ".concat(expectedResult3, " | Actual result: ").concat(result3));
    var result4 = merge([2, 0], 1, [1], 1);
    var expectedResult4 = [1, 2];
    console.log("Test 4 expecting: ".concat(expectedResult4, " | Actual result: ").concat(result4));
    var result6 = merge([1, 2, 3, 0, 0, 0], 3, [4, 5, 6], 3);
    var expectedResult6 = [1, 2, 3, 4, 5, 6];
    console.log("Test 6 expecting: ".concat(expectedResult6, " | Actual result: ").concat(result6));
    var result7 = merge([0, 0, 0, 0, 0], 0, [1, 2, 3, 4, 5], 5);
    var expectedResult7 = [1, 2, 3, 4, 5];
    console.log("Test 7 expecting: ".concat(expectedResult7, " | Actual result: ").concat(result7));
    var result8 = merge([-1, 0, 0, 3, 3, 3, 0, 0, 0], 6, [1, 2, 2], 3);
    var expectedResult8 = [-1, 0, 0, 1, 2, 2, 3, 3, 3];
    console.log("Test 8 expecting: ".concat(expectedResult8, " | Actual result: ").concat(result8));
};
test();
