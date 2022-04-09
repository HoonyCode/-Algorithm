//import java.util.HashMap;
//import java.util.Map;
//
//public class RPO프렌즈4차블록 {
//    public static void main(String[] args) {
//
//    }
//
//    public int solution(int m, int n, String[] board) {
//        int answer = 0;
//
//        Map<Character, Integer> name = new HashMap<>();
//
//        name.put('R', 0);
//        name.put('M', 1);
//        name.put('A', 2);
//        name.put('F', 3);
//        name.put('N', 4);
//        name.put('T', 5);
//        name.put('J', 6);
//        name.put('C', 7);
//
//
//        int[][] map = new int[m][n];
//
//        for (int i = 0 ; i < m ; i++){
//            for (int j = 0; j < n ; j++){
//                map[i][j] = name.get(board[i].charAt(j));
//            }
//        }
//
//
//        while (searchBlock(n, m, map)){
//            deleteBlock(n, m, map);
//        }
//
//        return answer;
//    }
//
//    private int[][] deleteBlock(int n, int m, int[][] map) {
//
//    }
//
//
//    public boolean searchBlock(int n,int m, int[][] map){
//        boolean[][] submap = new boolean[m][n];
//
//        boolean flag;
//        for (int i = 0 ; i < m -1 ; i ++){
//            for (int j = 0 ; j < n -1 ; j++){
//                if (map[i][j] == map[i][j+1] && map[i+1][j+1] == map[i+1][j] && map[i][j] == map[i+1][j]){
//                    submap[i][j] = true;
//                    submap[i+1][j] = true;
//                    submap[i][j+1] = true;
//                    submap[i+1][j+1] = true;
//                    flag = true;
//                }
//            }
//        }
//
//        return flag;
//    }
//}
//
