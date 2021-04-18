package com.example.projectsudoku;

import java.util.ArrayList;

public class InitBoard {
    static int[][] board = new int[9][9];
    static ArrayList<Location> location = new ArrayList<>();

    public static class Location {
        public int y;
        public int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        int selector = (int) (Math.random() * 4 + 1);
        ArrayList<Integer> lineNum = new ArrayList<>();
        while (lineNum.size() < 9) {
            int num = (int) (Math.random() * 9 + 1);
            if (!lineNum.contains(num))
                lineNum.add(num);
        }
        switch (selector) {
            case 1:
                for (int i = 0; i < 9; i++) {
                    board[i][i] = lineNum.get(i);
                }
                break;
            case 2:
                for (int i = 0; i < 9; i++) {
                    board[9 - i - 1][i] = lineNum.get(i);
                }
                break;
            case 3:
                for (int i = 0; i < 9; i++) {
                    board[i][0] = lineNum.get(i);
                }
                break;
            case 4:
                for (int i = 0; i < 9; i++) {
                    board[0][i] = lineNum.get(i);
                }
                break;

        }

//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//        System.out.println();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0)
                    location.add(new Location(i, j));
            }
        }
        BT(0, location.size());

//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static void BT(int S, int L) {
        if (S == L)
            return;
        boolean[] cNum = new boolean[10];
        for (int i = 0; i < 10; i++)
            cNum[i] = false;

        for (int i = 0; i < 9; i++) {
            cNum[board[location.get(S).y][i]] = true;
            cNum[board[i][location.get(S).x]] = true;
        }
        int y = location.get(S).y / 3 * 3;
        int x = location.get(S).x / 3 * 3;
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                cNum[board[i][j]] = true;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (cNum[i])
                continue;
            cNum[i] = true;
            board[location.get(S).y][location.get(S).x] = i;
            BT(S + 1, L);
            if (board[location.get(location.size() - 1).y][location.get(location.size() - 1).x] != 0)
                break;
            board[location.get(S).y][location.get(S).x] = 0;
        }
    }
}