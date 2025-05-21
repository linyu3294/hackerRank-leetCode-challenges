function merge(intervals) {
    var sorted = mergeSort(intervals);
    return mergeInterval(sorted);
}
;
function mergeSort(intervals) {
    if (intervals.length <= 1) {
        return intervals;
    }
    var mid = Math.floor(intervals.length / 2);
    var left = merge(intervals.slice(0, mid));
    var right = merge(intervals.slice(mid));
    var result = sort(left, right);
    return result;
}
function sort(left, right) {
    var i = 0;
    var j = 0;
    var result = [];
    while (i < left.length && j < right.length) {
        if (left[i][0] < right[j][0]) {
            result.push(left[i]);
            i++;
        }
        else {
            result.push(right[j]);
            j++;
        }
    }
    return result.concat(left.slice(i).concat(right.slice(j)));
}
function mergeInterval(interval) {
    var l = 1;
    while (l < interval.length) {
        if (interval[l][1] <= interval[l - 1][1]) {
            // console.log(`\n\ninterval ${JSON.stringify(interval[l])} < interval ${JSON.stringify(interval[l-1])}`)
            interval.splice(l, 1);
            // console.log(`new interval ${JSON.stringify(interval)}`)
        }
        else if (interval[l][1] > interval[l - 1][1] && interval[l][0] <= interval[l - 1][1]) {
            // console.log(`\n\ninterval ${JSON.stringify(interval[l])} Overlapping interval ${JSON.stringify(interval[l-1])}`)
            interval[l - 1][1] = interval[l][1];
            interval.splice(l, 1);
            // console.log(`new interval ${JSON.stringify(interval)}`)
        }
        else if (interval[l][0] > interval[l - 1][1]) {
            l++;
        }
    }
    return interval;
}
function mergeRemaining(result, rest) {
    for (var _i = 0, rest_1 = rest; _i < rest_1.length; _i++) {
        var interval = rest_1[_i];
        if (result.length === 0) {
            result.push(interval);
            continue;
        }
        var last = result[result.length - 1];
        if (interval[0] === last[0] && interval[1] === last[1])
            continue;
        if (interval[0] <= last[1]) {
            last[1] = Math.max(last[1], interval[1]);
        }
        else {
            result.push(interval);
        }
    }
    return result;
}
function combine(left, right) {
    var result = [];
    var i = 0;
    var j = 0;
    while (i < left.length && j < right.length) {
        var x = left[i][0];
        var y = left[i][1];
        var u = right[j][0];
        var v = right[j][1];
        console.log("\n\n i: ".concat(i, ", j: ").concat(j));
        console.log("left: ".concat(JSON.stringify(left)));
        console.log("right: ".concat(JSON.stringify(right)));
        if (y < u) {
            console.log("left ends before right starts — no overlap");
            result.push(left[i]);
            i++;
        }
        else if (v < x) {
            console.log("right ends before left starts — no overlap | v < x");
            console.log("left[".concat(i, "] u: ").concat(x, " v: ").concat(y));
            console.log("right[".concat(j, "]: x: ").concat(u, " y: ").concat(v));
            result.push(right[j]);
            j++;
        }
        else {
            // they overlap
            if (x <= u && y >= u) {
                console.log("left starts first and overlaps right | x <=u && y >= u");
                console.log("left[".concat(i, "] u: ").concat(x, " v: ").concat(y));
                console.log("right[".concat(j, "]: x: ").concat(u, " y: ").concat(v));
                left[i][1] = Math.max(left[i][1], right[j][1]);
                j++;
            }
            else if (u <= x && v >= x) {
                console.log("right starts first and overlaps left");
                right[j][1] = Math.max(left[i][1], right[j][1]);
                i++;
            }
        }
        console.log("result: ".concat(JSON.stringify(result)));
    }
    if (result) {
        // Merge the remaining intervals into result cleanly
        result = mergeRemaining(result, left.slice(i));
        result = mergeRemaining(result, right.slice(j));
    }
    return result;
}
;
var result1 = merge([[1, 3], [2, 6], [8, 10], [15, 18]]);
var expectedResult1 = [[1, 6], [8, 10], [15, 18]];
console.log("Test 1 expecting: ".concat(JSON.stringify(expectedResult1), " | Actual result: ").concat(JSON.stringify(result1)));
var result2 = merge([[1, 4], [4, 5]]);
var expectedResult2 = [[1, 5]];
console.log("Test 2 expecting: ".concat(JSON.stringify(expectedResult2), " | Actual result: ").concat(JSON.stringify(result2)));
var result3 = merge([[1, 4], [1, 4]]);
var expectedResult3 = [[1, 4]];
console.log("Test 3 expecting: ".concat(JSON.stringify(expectedResult3), " | Actual result: ").concat(JSON.stringify(result3)));
var result4 = merge([[4, 5], [1, 4], [0, 1]]);
var expectedResult4 = [[0, 5]];
console.log("Test 4 expecting: ".concat(JSON.stringify(expectedResult4), " | Actual result: ").concat(JSON.stringify(result4)));
var result5 = merge([[1, 4], [0, 4]]);
var expectedResult5 = [[0, 4]];
console.log("Test 5 expecting: ".concat(JSON.stringify(expectedResult5), " | Actual result: ").concat(JSON.stringify(result5)));
var result6 = merge([[2, 3], [5, 5], [2, 2], [3, 4], [3, 4]]);
var expectedResult6 = [[2, 4], [5, 5]];
console.log("Test 6 expecting: ".concat(JSON.stringify(expectedResult6), " | Actual result: ").concat(JSON.stringify(result6)));
var result7 = merge([[3, 3], [1, 1], [0, 2], [2, 2], [1, 2], [1, 3], [1, 1], [3, 3], [2, 3], [4, 6]]);
var expectedResult7 = [[0, 3], [4, 6]];
console.log("Test 7 expecting: ".concat(JSON.stringify(expectedResult7), " | Actual result: ").concat(JSON.stringify(result7)));
