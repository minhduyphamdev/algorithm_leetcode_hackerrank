package java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
  public void combineParenthesis(List<String> parenthesis, int pos, int countLeft, int countRight, int n, StringBuilder builder) {
    if(pos == n*2) {
      parenthesis.add(builder.toString());
      return;
    }

    if(countLeft <n) {
      builder.append('(');
      combineParenthesis(parenthesis, pos+1, countLeft+1, countRight, n, builder);
      builder.deleteCharAt(builder.length()-1);
    }
    if(countLeft > countRight) {
      builder.append(')');
      combineParenthesis(parenthesis, pos+1, countLeft, countRight+1, n, builder);
      builder.deleteCharAt(builder.length() - 1);
    }
  }
  // public List<String> generateParenthesis(int n) {
  //   List<String> parenthesis = new ArrayList<>();
  //   StringBuilder builder = new StringBuilder();
  //   combineParenthesis(parenthesis, 0, 0, 0, n, builder);

  //   return parenthesis;
  // }

  public List<String> generateParenthesis(int n) {
    List<String> parenthesis = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    // generate(parenthesis, 0, 0, 0, n, builder);
    generateCases(parenthesis, builder, n, 0,0);

    return parenthesis;
  }

  public void generateCases(List<String> res, StringBuilder builder, int n, int len, int numOfOpen) {
    if(len == n*2) {
      res.add(new String(builder.toString()));
      return;
    }

    if(numOfOpen < n) {
        builder.append('(');
        generateCases(res, builder, n, len+1, numOfOpen+1);
        builder.deleteCharAt(builder.length()-1);
    }
    
    if(len < 2*numOfOpen) {
      builder.append(')');
      generateCases(res, builder, n, len+1, numOfOpen);
      builder.deleteCharAt(builder.length()-1);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<String> result = new GenerateParentheses().generateParenthesis(n);
    for(String s: result) {
      System.out.println(s);
    }
  }
}
