package surroundedRegions;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * <p/>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p/>
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p/>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Solution {
    private char[][] board;
    private int height;
    private int width;
    private int[][] movepos = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        this.board = board;
        this.height = board.length;
        this.width = board[0].length;
        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O') {
                solve(i, 0);
            }
            if (board[i][width - 1] == 'O') {
                solve(i, width - 1);
            }
        }
        for (int i = 0; i < width; i++) {
            if (board[0][i] == 'O') {
                solve(0, i);
            }
            if (board[height - 1][i] == 'O') {
                solve(height - 1, i);
            }
        }
        clear();
    }

    private void clear() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void solve(int mx, int my) {
        Stack<int[]> points = new Stack<int[]>();
        Stack<Integer> poses = new Stack<Integer>();
        points.add(new int[]{mx, my});
        poses.add(-1);

        while (!points.isEmpty()) {
            int[] p = points.peek();
            board[p[0]][p[1]] = 'M';

            int pos = poses.pop() + 1;
            if (pos == movepos.length) {
                points.pop();
            } else {
                while (pos < movepos.length) {
                    int nx = p[0] + movepos[pos][0];
                    int ny = p[1] + movepos[pos][1];
                    if (nx >= 0 && nx < height && ny >= 0 && ny < width && board[nx][ny] == 'O') {
                        points.add(new int[]{nx, ny});
                        poses.add(pos);
                        poses.add(-1);
                        break;
                    }
                    pos++;
                }
                if (pos == movepos.length) {
                    points.pop();
                }
            }
        }
    }

    @Test
    public void test() {
        String[] b = {
                "XXXX", "XOOO", "XXOX", "XOXX"};
        char[][] board = new char[4][4];
        for (int i = 0; i < 4; i++) {
            board[i] = b[i].toCharArray();
        }
        solve(board);
        assertEquals("XXXX", new String(board[0]));
        assertEquals("XOOO", new String(board[1]));
        assertEquals("XXOX", new String(board[2]));
        assertEquals("XOXX", new String(board[3]));

        b = new String[]{"XOOOOOOOOOOOOOOOOOOO", "OXOOOOXOOOOOOOOOOOXX", "OOOOOOOOXOOOOOOOOOOX", "OOXOOOOOOOOOOOOOOOXO", "OOOOOXOOOOXOOOOOXOOX", "XOOOXOOOOOXOXOXOXOXO", "OOOOXOOXOOOOOXOOXOOO", "XOOOXXXOXOOOOXXOXOOO", "OOOOOXXXXOOOOXOOXOOO", "XOOOOXOOOOOOXXOOXOOX", "OOOOOOOOOOXOOXOOOXOX", "OOOOXOXOOXXOOOOOXOOO", "XXOOOOOXOOOOOOOOOOOO", "OXOXOOOXOXOOOXOXOXOO", "OOXOOOOOOOXOOOOOXOXO", "XXOOOOOOOOXOXXOOOXOO", "OOXOOOOOOOXOOXOXOXOO", "OOOXOOOOOXXXOOXOOOXO", "OOOOOOOOOOOOOOOOOOOO", "XOOOOXOOOXXOOXOXOXOO"};
        board = new char[b.length][];
        for (int i = 0; i < b.length; i++) {
            board[i] = b[i].toCharArray();
        }
        solve(board);
    }
}
