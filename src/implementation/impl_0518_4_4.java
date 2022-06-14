package implementation;

import java.util.Scanner;

public class impl_0518_4_4 {

    public static int[][] map;   // 맵
    public static int[][] visit; // 방문여부
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int d; // 게임 캐릭터가 바라보는 방향 d

    public static void turn_left(){ // 현재 방향을 기준으로 왼쪽 방향으로 회전
        d -= 1;
        if(d == -1) d = 3;  // 북(0)일 때는 서쪽으로 회전
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 맵의 세로 크기 n과 가로크기 m을 입력받음
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        visit = new int[n][m];

        // 게임 캐릭터가 있는 칸의 좌표 x,y
        int x = sc.nextInt();
        int y = sc.nextInt();
        d = sc.nextInt();
        visit[x][y] = 1;
        int visit_cnt = 1; // 방문한 칸
        int turn_cnt = 0;  // 4가지 방향 확인 여부

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        while(true){
            turn_left(); // 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향으로부터 차례대로 갈 곳을 정한다.
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 2-1. 회전한 방향의 해당 칸에 방문한 적이 없고 && 맵의 해당 칸이 0이면 해당 위치로 이동
            if(visit[nx][ny] == 0 && map[nx][ny] == 0){
                visit[nx][ny] = 1; //방문 처리
                x = nx;
                y = ny;
                visit_cnt += 1;
                turn_cnt = 0;
                continue;
            }else{
                // 2-2. 회전한 방향에 가보지 않은 칸이 없을 때
                turn_cnt += 1;
            }

            // 3. 네 방향 모두 이미 방문한 칸이거나 바다일 경우
            if(turn_cnt == 4){
                nx = x - dx[d];
                ny = y - dy[d];

                if(map[nx][ny] == 0){
                    //3-1. 가능하다면 한 칸 뒤로
                    x = nx;
                    y = ny;
                    turn_cnt = 0;
                }else break; //3-2. 한칸 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
            }
        }
        System.out.println(visit_cnt);
    }
}
