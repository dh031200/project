package com.example.projectsudoku;

import java.util.ArrayList;

public class Solution {
    static int[][] board = new int[9][9];
    static ArrayList<Location> location = new ArrayList<>();
    public static class Location{
        public int y;
        public int x;
        public Location(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                //todo :: board data load
                if(board[i][j] == 0)
                    location.add(new Location(i,j));
            }
        }
        BT(0, location.size());
    }

    public static void BT(int S, int L){
        if(S == L)
            return;
        boolean[] cNum = new boolean[10];
        for(int i=0;i<10;i++)
            cNum[i] = false;

        for (int i=0; i<9; i++) {
            cNum[board[location.get(S).y][i]] = true;
            cNum[board[i][location.get(S).x]] = true;
        }
        int y = location.get(S).y/3*3;
        int x = location.get(S).y/3*3;
        for (int i=y; i<y+3; i++) {
            for(int j=x; j<x+3; j++){
                cNum[board[i][j]] = true;
            }
        }
        for(int i = 1; i<=9;i++){
            if(cNum[i])
                continue;
            cNum[i] = true;
            board[location.get(S).y][location.get(S).x] = i;
            BT(S+1,L);
            if(board[location.get(location.size()-1).y][location.get(location.size()-1).x] != 0)
                break;
            board[location.get(S).y][location.get(S).x] = 0;
        }
    }
}
