function merge(intervals: number[][]): number[][] {
  const sorted = mergeSort(intervals);

  return mergeInterval(sorted);
};

function mergeSort(intervals: number[][]): number[][] {
  if (intervals.length <= 1) {
    return intervals;
  }

  const mid =  Math.floor(intervals.length / 2);
  let left = merge(intervals.slice(0, mid));
  let right = merge(intervals.slice(mid));

  const result = sort(left, right);
  return result;
}

function sort (left: number[][], right: number[][]): number[][] {
  let i = 0;
  let j = 0;
  let result: number[][] = [];

  while (i < left.length && j < right.length) {
    if (left[i][0] < right[j][0]) {
      result.push(left[i]);
      i++;
    } else{
      result.push(right[j]);
      j++;
    }
  }
  
  return result.concat(left.slice(i).concat(right.slice(j)));
}


function mergeInterval(interval: number[][]): number[][] {
  let l = 1;
  while (l < interval.length){ 
    if (interval[l][1] <= interval[l-1][1]) {
      interval.splice(l, 1);
    }
    else if (interval[l][1] > interval[l-1][1] && interval[l][0] <= interval[l-1][1]) {
      interval[l-1][1] = interval[l][1];
      interval.splice(l, 1);
    }
    else if (interval[l][0] > interval[l-1][1]) {
      l++;
    }
  }
  return interval;
}


// function mergeRemaining(result: number[][], rest: number[][]): number[][] {
//   for (const interval of rest) {
//     if (result.length === 0) {
//       result.push([...interval]);
//       continue;
//     }
//     const last = result[result.length - 1];
//     if (interval[0] <= last[1]) {
//       last[1] = Math.max(last[1], interval[1]);
//     } else {
//       result.push([...interval]);
//     }
//   }
//   return result;
// }

// function combine(left: number[][], right: number[][]): number[][] {
//   let result: number[][] = [];
//   let i = 0;
//   let j = 0;

//   while (i < left.length && j < right.length) {
//     let interval: number[];
//     if (left[i][0] < right[j][0]) {
//       interval = [...left[i]];
//       i++;
//     } else {
//       interval = [...right[j]];
//       j++;
//     }

//     if (result.length === 0) {
//       result.push(interval);
//     } else {
//       const last = result[result.length - 1];
//       if (interval[0] <= last[1]) {
//         last[1] = Math.max(last[1], interval[1]);
//       } else {
//         result.push(interval);
//       }
//     }
//   }

//   // Process remaining items in left and right
//   result = mergeRemaining(result, left.slice(i));
//   result = mergeRemaining(result, right.slice(j));

//   return result;
// }

const result1 = merge([[1,3],[2,6],[8,10],[15,18]]);
const expectedResult1 = [[1,6],[8,10],[15,18]];
console.log(
  `Test 1 expecting: ${JSON.stringify(expectedResult1)} | Actual result: ${JSON.stringify(result1)}`
);

const result2 = merge([[1,4],[4,5]]);
const expectedResult2 = [[1,5]];
console.log(
  `Test 2 expecting: ${JSON.stringify(expectedResult2)} | Actual result: ${JSON.stringify(result2)}`
);

const result3 = merge([[1,4], [1,4]]);
const expectedResult3 = [[1,4]];
console.log(
  `Test 3 expecting: ${JSON.stringify(expectedResult3)} | Actual result: ${JSON.stringify(result3)}`
);

const result4 = merge([[4,5],[1,4],[0,1]]);
const expectedResult4 = [[0,5]];
console.log(
  `Test 4 expecting: ${JSON.stringify(expectedResult4)} | Actual result: ${JSON.stringify(result4)}`
);

const result5 = merge([[1,4],[0,4]]);
const expectedResult5 = [[0,4]];
console.log(
  `Test 5 expecting: ${JSON.stringify(expectedResult5)} | Actual result: ${JSON.stringify(result5)}`
);

const result6 = merge([[2,3],[5,5],[2,2],[3,4],[3,4]]);
const expectedResult6 = [[2,4],[5,5]];
console.log(
  `Test 6 expecting: ${JSON.stringify(expectedResult6)} | Actual result: ${JSON.stringify(result6)}`
);

const result7 = merge([[3,3],[1,1],[0,2],[2,2],[1,2],[1,3],[1,1],[3,3],[2,3],[4,6]]);
const expectedResult7 = [[0,3],[4,6]];
console.log(
  `Test 7 expecting: ${JSON.stringify(expectedResult7)} | Actual result: ${JSON.stringify(result7)}`
);


