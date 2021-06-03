package me.donghyeon.prog;

public class Solution_prog_124나라의숫자 {
    public static String solution(int n) {
        String[] arr = {"4", "1", "2"};
        String answer = "";
        while(n > 0) {
            int mod = n % 3;
            n /= 3;
            if (mod == 0) n--;
            answer = arr[mod] + answer;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
