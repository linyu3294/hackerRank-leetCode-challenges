function isOpeningType(g) {
    if (g === '{' || g === '(' || g === '[') {
        return true;
    }
    return false;
}
function isClosingType(g) {
    if (g === '}' || g === ')' || g === ']') {
        return true;
    }
    return false;
}
function isValidClosure(g, gPrime) {
    if (g === '{' && gPrime === '}') {
        return true;
    }
    else if (g === '(' && gPrime === ')') {
        return true;
    }
    else if (g === '[' && gPrime === ']') {
        return true;
    }
    return false;
}
function isValid(s) {
    var stack = [];
    return recursiveVerify(s, 0, stack);
}
;
function recursiveVerify(s, index, stack) {
    console.log("\n\nindex: ".concat(index));
    console.log("s: ".concat(s[index]));
    console.log("left neighbour: ".concat(s[index - 1]));
    console.log("right neighbour: ".concat(s[index + 1]));
    console.log("");
    if (index === s.length) {
        return true;
    }
    if (isOpeningType(s[index])) {
        stack.push(s[index]);
        return recursiveVerify(s, index + 1, stack);
    }
    else if (isClosingType(s[index])) {
        var poppedItem = stack.pop();
        console.log("popped item: ".concat(poppedItem));
        if (!poppedItem) {
            return false;
        }
        if (isValidClosure(poppedItem, s[index])) {
            console.log("popped item: ".concat(poppedItem));
            return recursiveVerify(s, index + 1, stack);
        }
        return false;
    }
    return false;
}
var result1 = isValid("");
var expectedResult1 = true;
console.log("Test 1 expecting: ".concat(expectedResult1, " | Actual result: ").concat(result1));
var result2 = isValid("()[]{}");
var expectedResult2 = true;
console.log("Test 2 expecting: ".concat(expectedResult2, " | Actual result: ").concat(JSON.stringify(result2)));
var result3 = isValid("(]");
var expectedResult3 = false;
console.log("Test 3 expecting: ".concat(expectedResult3, " | Actual result: ").concat(JSON.stringify(result3)));
var result4 = isValid("([])");
var expectedResult4 = true;
console.log("Test 4 expecting: ".concat(expectedResult4, " | Actual result: ").concat(JSON.stringify(result4)));
