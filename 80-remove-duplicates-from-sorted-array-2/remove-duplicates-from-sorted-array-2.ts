function removeDuplicates(nums: number[]): number {
  let i = 2;
  let k = 0;
  for (let j = 2; j < nums.length; j++) {
    if (nums[j] !== nums[i-2]) {
      nums[i] = nums[j];
      i++;
    }
  }
  return i;
};

const result1 = removeDuplicates([1,1,1,2,2,3]);
const expectedResult1 = [1,1,2,2,3,-1]
console.log(
  `Test 1 expecting: ${expectedResult1} | Actual result: ${result1}`
);

const result2 = removeDuplicates([0,0,1,1,1,1,2,3,3]);
const expectedResult2 = [0,0,1,1,2,3,3,-1,-1];
console.log(
  `Test 2 expecting: ${expectedResult2} | Actual result: ${result2}`
);
