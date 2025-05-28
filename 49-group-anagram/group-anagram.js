function groupAnagrams(strs) {
    var anagrams = {};
    for (var _i = 0, strs_1 = strs; _i < strs_1.length; _i++) {
        var word = strs_1[_i];
        var sortedWord = word.split('').sort().join();
        if (!anagrams[sortedWord]) {
            anagrams[sortedWord] = [];
        }
        anagrams[sortedWord].push(word);
    }
    var result = [];
    for (var key in anagrams) {
        result.push(anagrams[key]);
    }
    return result;
}
;
var result1 = groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]);
var expectedResult1 = [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]];
console.log("Test 1 expecting: ".concat(JSON.stringify(expectedResult1), " | Actual result: ").concat(JSON.stringify(result1)));
// const result2 = groupAnagrams([""]);
// const expectedResult2 = [[""]];
// console.log(
//   `Test 2 expecting: ${expectedResult2} | Actual result: ${JSON.stringify(result2)}`
// );
// const result3 = groupAnagrams(["a"]);
// const expectedResult3 = [["a"]];
// console.log(
//   `Test 3 expecting: ${expectedResult3} | Actual result: ${JSON.stringify(result3)}`
// );
