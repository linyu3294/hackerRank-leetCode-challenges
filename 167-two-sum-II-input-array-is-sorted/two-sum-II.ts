
/**
 Do not return anything, modify nums1 in-place instead.
 */
 function twoSum(numbers: number[], target: number): number[] {
  // Use a plain object to store number -> index mapping
  const indexMap: { [key: number]: number } = {};

  for (let i = 0; i < numbers.length; i++) {
    const num = numbers[i];
    const complement = target - num;

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
 
 const result1 = twoSum([2,7,11,15], 9);
 const expectedResult1 = [1,2]
 console.log(
   `Test 1 expecting: ${expectedResult1} | Actual result: ${result1}`
 );
 
 const result2 = twoSum([2,3,4], 6);
 const expectedResult2 = [1,3];
 console.log(
   `Test 2 expecting: ${expectedResult2} | Actual result: ${result2}`
 );