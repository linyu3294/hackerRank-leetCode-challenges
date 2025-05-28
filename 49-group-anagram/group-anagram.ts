function groupAnagrams(strs: string[]): string[][] {
  const anagrams: {[key: string]: string[]} = {};
  for (let word of strs) {
    const sortedWord = word.split('').sort().join();
    if (!anagrams[sortedWord]){
      anagrams[sortedWord] = [];
    }
    anagrams[sortedWord].push(word);
  }
  const result: string[][] = [];
  for (let key in anagrams) {
    result.push(anagrams[key]);
  }
  return result;
};

const result1 = groupAnagrams(["eat","tea","tan","ate","nat","bat"]);
const expectedResult1 = [["bat"],["nat","tan"],["ate","eat","tea"]];
console.log(
  `Test 1 expecting: ${JSON.stringify(expectedResult1)} | Actual result: ${JSON.stringify(result1)}`
);

const result2 = groupAnagrams([""]);
const expectedResult2 = [[""]];
console.log(
  `Test 2 expecting: ${expectedResult2} | Actual result: ${JSON.stringify(result2)}`
);


const result3 = groupAnagrams(["a"]);
const expectedResult3 = [["a"]];
console.log(
  `Test 3 expecting: ${expectedResult3} | Actual result: ${JSON.stringify(result3)}`
);
