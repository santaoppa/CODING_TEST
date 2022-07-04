package search;
import java.util.*;

public class BOJ7562 {
    public static int col, curX, curY, goalX, goalY;
    public static int map[][];
    public static boolean visited[][];
    public static int[] dx = {-2, -1, 1, 2, 2, 1 ,-1, -2};
    public static int[] dy = {-1, -2, -2, -1, 1 ,2 ,2, 1};

    public static void bfs(int x1, int y1, int x2, int y2) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x1, y1));
        visited[x1][y1] = true;

        while(!que.isEmpty()) {
            Node temp = que.poll();

            if(temp.getX() == x2 && temp.getY() == y2) break;

            for(int i=0; i<8; i++) {
                int nx = temp.getX() + dx[i];
                int ny = temp.getY() + dy[i];

                if(0<=nx && nx < col && 0 <= ny & ny < col && !visited[nx][ny] ){
                    visited[nx][ny] = true;
                    map[nx][ny] = map[temp.getX()][temp.getY()] + 1;
                    que.add(new Node(nx,ny));
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++) {
            col = sc.nextInt();
            map = new int[col][col];
            visited = new boolean[col][col];

            curX = sc.nextInt();
            curY = sc.nextInt();

            goalX = sc.nextInt();
            goalY = sc.nextInt();

            bfs(curX, curY, goalX, goalY);
            System.out.println(map[goalX][goalY]);
        }
    }
}