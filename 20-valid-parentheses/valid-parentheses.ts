
function isOpeningType (g: string): boolean {
  if (g === '{' || g === '(' || g === '[') {
    return true;
  }
  return false;
}

function isClosingType (g: string): boolean {
  if (g === '}' || g === ')' || g === ']') {
    return true;
  }
  return false;
}

function isValidClosure (g: string, gPrime: string) {

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

function isValid(s: string): boolean {
  let stack: string[] = [];
  return recursiveVerify(s, 0, stack);
};

function recursiveVerify(s: string, index: number, stack: string[]): boolean {
  // console.log(`\n\nindex: ${ index }`)
  // console.log(`s: ${ s[index] }`)
  // console.log(`left neighbour: ${ s[index-1] }`)
  // console.log(`right neighbour: ${ s[index+1] }`)
  // console.log(``)
  if (index === s.length) {
    return true;
  }
  if (isOpeningType(s[index])) {
    stack.push(s[index]);
    return recursiveVerify(s, index+1, stack);
  }
  else if (isClosingType(s[index])){
    const poppedItem = stack.pop();
    console.log(`popped item: ${poppedItem}`)
    if (!poppedItem){
      return false;
    }
    if (isValidClosure(poppedItem, s[index])){
      console.log(`popped item: ${poppedItem}`)
      return recursiveVerify(s, index+1, stack);
    }
    return false;
  }
  return false;
}

const result1 = isValid("");
const expectedResult1 = true;
console.log(
  `Test 1 expecting: ${expectedResult1} | Actual result: ${result1}`
);

const result2 = isValid("()[]{}");
const expectedResult2 = true;
console.log(
  `Test 2 expecting: ${expectedResult2} | Actual result: ${JSON.stringify(result2)}`
);

const result3 = isValid("(]");
const expectedResult3 = false;
console.log(
  `Test 3 expecting: ${expectedResult3} | Actual result: ${JSON.stringify(result3)}`
);

const result4 = isValid("([])");
const expectedResult4 = true;
console.log(
  `Test 4 expecting: ${expectedResult4} | Actual result: ${JSON.stringify(result4)}`
);
