package com.company;

import javax.management.AttributeList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static List<String> permute(int max) {
    List<String> result = new ArrayList<String>();
    recurBuild(result, "",0, 0,  max);
    return result;
  }


  public static void recurBuild(List <String> result, String str, int open, int close, int max) {
    if (str.length() == max * 2){
      System.out.println(str);
      result.add(str);
    }
    if (open < max){
      recurBuild(result, str + "(", open +1, close, max);
    }
    if (close < open) {
      recurBuild(result, str + ")", open , close+1, max);
    }
  }

  // main()
  public static void main(String[] args) {
    List<String> test = permute(4);
    System.out.println(Arrays.asList(test));

//    System.out.println(
//        "(((()))), ()((())), (()(())), ((()())), ()(()()), (()()()), ((())()), ()(())(), (()())(), ((()))(), ()()()(), ()()(()), (())(()), (())()()");
  }
}
