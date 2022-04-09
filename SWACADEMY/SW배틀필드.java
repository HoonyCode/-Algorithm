package algo;

import java.util.Scanner;

public class SW배틀필드 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1 ; t <= T ; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			index tank = new index();
			
			char[][] map = new char[H][];
			for(int i = 0 ; i < H ; i++) {
				map[i] = sc.next().toCharArray();
			}
			int N = sc.nextInt();
			char[] Todo = sc.next().toCharArray();
			
			
			for(int i = 0 ; i < H ; i++) {
				for(int j = 0 ; j < W ; j++) {
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						tank.r = i;
						tank.c = j;
						tank.dir = map[i][j];
						break;
					}
				}
			}
			for(int i = 0 ; i < N ; i++) {
				if(Todo[i] == 'U') {
					Up(map, H, W, tank);
				}else if(Todo[i] == 'D') {
					Down(map, H, W, tank);
				}else if(Todo[i] == 'R') {
					Right(map, H, W, tank);
				}else if(Todo[i] == 'L') {
					Left(map, H, W, tank);
				}else {// S일때
					Shoot(map, H, W, tank);
				}
			}
			
			sb.append("#"+t +" ");
			for(int i = 0 ; i < H ; i++) {
				for(int j = 0 ; j < W ; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void Up(char[][] map,int r, int c, index tank){
		tank.dir = '^';
		if(tank.r-1 >= 0 && map[tank.r-1][tank.c] == '.') {
			map[tank.r][tank.c] = '.';
			map[tank.r-1][tank.c] = tank.dir;
			tank.r--;
		}else {
			map[tank.r][tank.c]= tank.dir; 
		}
	}
	private static void Down(char[][] map,int r, int c, index tank){
		tank.dir = 'v';
		if(tank.r+1 < r && map[tank.r+1][tank.c] == '.') {
			map[tank.r][tank.c] = '.';
			map[tank.r+1][tank.c] = tank.dir;
			tank.r++;
		}else {
			map[tank.r][tank.c] = tank.dir;
		}
		
	}
	private static void Left(char[][] map,int r, int c, index tank){
		tank.dir = '<';
		if(tank.c-1 >= 0 && map[tank.r][tank.c-1] == '.') {
			map[tank.r][tank.c] = '.';
			map[tank.r][tank.c-1] = tank.dir;
			tank.c--;
		}else {
			map[tank.r][tank.c] = tank.dir;
		}
	}
	private static void Right(char[][] map,int r, int c, index tank){
		tank.dir = '>';
		if(tank.c+1 < c && map[tank.r][tank.c+1] == '.') {
			map[tank.r][tank.c] = '.';
			map[tank.r][tank.c+1] = tank.dir;
			tank.c++;
		}else {
			map[tank.r][tank.c] = tank.dir;
		}
	}
	private static void Shoot(char[][] map,int r, int c, index tank) {
		switch (tank.dir) {
		case '>' :
			for(int i = tank.c+1 ; i < c; i++) {
				if (map[tank.r][i] == '*') {
					map[tank.r][i] = '.';
					break;
				}
				if (map[tank.r][i] == '#')
					break;
			}
			break;
		case '<' :
			for(int i = tank.c-1 ; i >= 0; i--) {
				if (map[tank.r][i] == '*') {
					map[tank.r][i] = '.';
					break;
				}
				if (map[tank.r][i] == '#')
					break;
			}
			break;
		case '^' :
			for(int i = tank.r-1 ; i >= 0; i--) {
				if (map[i][tank.c] == '*') {
					map[i][tank.c] = '.';
					break;
				}
				if (map[i][tank.c] == '#')
					break;
			}
			break;
		case 'v' :
			for(int i = tank.r+1 ; i < r; i++) {
				if (map[i][tank.c] == '*') {
					map[i][tank.c] = '.';
					break;
				}
				if (map[i][tank.c] == '#')
					break;
			}
			break;
		}
	}
}

class index{
	int r; 
	int c;
	char dir;
	
}
