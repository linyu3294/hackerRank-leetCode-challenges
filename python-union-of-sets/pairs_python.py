#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the pairs function below.
def pairs(k, arr):
    
    return len(set(arr) & set(x + k for x in arr))

if __name__ == '__main__':

    k = 2

    arr = [1,2,3,4,5,6,7,8]


    result = pairs(k, arr)

    print(result)
