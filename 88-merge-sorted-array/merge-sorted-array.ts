
/**
 Do not return anything, modify nums1 in-place instead.
 */
 function merge(nums1: number[], m: number, nums2: number[], n: number): number[] {
    let j = 0;
    let k = 0;
    if (n < 1 ) {
      return nums1;
    }
    if (m < 1 && n >= 1) {
      for (let l = 0; l < nums2.length; l ++){
        nums1.splice(l, 0, nums2[l]);
      }
      return nums1.splice(0, n);
    }

    for (let i = 0; i < n + m + n; i ++) {
      if (nums2[k] <= nums1[j]) {
        nums1.splice(j, 0, nums2[k]);
          j++;
          k++;
          continue;
      }
      if (j - k === m) {
        nums1.splice(j, 0, nums2[k]);
        j++;
        k++;
        continue;
      }
      j++;
    }
   return nums1.splice(0, m+n);
 };

const test = () => {
  const result1 = merge([1,2,3,0,0,0], 3, [2,5,6], 3);
  const expectedResult1 = [1,2,2,3,5,6]
  console.log(
    `Test 1 expecting: ${expectedResult1} | Actual result: ${result1}`
  );

  const result2 = merge([1], 1, [], 0);
  const expectedResult2 = [1];
  console.log(
    `Test 2 expecting: ${expectedResult2} | Actual result: ${result2}`
  );

  const result3 = merge([0], 0, [1], 1);
  const expectedResult3 = [1];
  console.log(
    `Test 3 expecting: ${expectedResult3} | Actual result: ${result3}`
  );

  const result4 = merge([2,0], 1, [1], 1);
  const expectedResult4 = [1,2];
  console.log(
    `Test 4 expecting: ${expectedResult4} | Actual result: ${result4}`
  );

  const result6 = merge([1,2,3,0,0,0], 3, [4,5,6], 3);
  const expectedResult6 = [1,2,3,4,5,6];
  console.log(
    `Test 6 expecting: ${expectedResult6} | Actual result: ${result6}`
  );

  const result7 = merge([0,0,0,0,0], 0, [1,2,3,4,5], 5);
  const expectedResult7 = [1,2,3,4,5];
  console.log(
    `Test 7 expecting: ${expectedResult7} | Actual result: ${result7}`
  );

  const result8 = merge([-1,0,0,3,3,3,0,0,0], 6, [1,2,2], 3);
  const expectedResult8 = [-1,0,0,1,2,2,3,3,3];
  console.log(
    `Test 8 expecting: ${expectedResult8} | Actual result: ${result8}`
  );
};

test();