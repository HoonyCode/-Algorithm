package PROGRAMMERS;


public class PRO_큰수만들기_HoonyCode {

    class Solution {

        StringBuilder sb = new StringBuilder();

        public String solution(String number, int k) {

            int[] arr = new int[number.length()];

            for (int i = 0; i < number.length(); i++) {
                arr[i] = number.charAt(i) - '0';
            }

            makeAnswer(arr,0, arr.length, k, arr.length - k);

            return sb.toString();
        }


        void makeAnswer(int[] arr, int start, int end, int k, int total) {

            if (total == 0) return;

            if (k == 0){
                if (total != 0){
                    for (int i = end - total ; i < end ; i++){
                        sb.append(arr[i]);
                    }
                }

                return ;
            }

            int index = 0;
            int value = -1;
            for (int i = start; i <= start + k; i++) {
                if (arr[i] > value) {
                    value = arr[i];
                    index = i;
                }
            }
            sb.append(value);

            makeAnswer(arr, index + 1, end, k - (index - start), total - 1);
        }
    }
}
