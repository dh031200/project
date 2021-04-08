package com.example.projectsudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaySdokuActivity extends AppCompatActivity {
    private static final int SIZE = 9;
    private TextView[][] tvList = new TextView[9][9];
    private LinearLayout[][] llList = new LinearLayout[9][9];

    private Integer[][] tvId = new Integer[][]{
            {R.id.tv0_0, R.id.tv0_1, R.id.tv0_2, R.id.tv0_3, R.id.tv0_4, R.id.tv0_5, R.id.tv0_6, R.id.tv0_7, R.id.tv0_8},
            {R.id.tv1_0, R.id.tv1_1, R.id.tv1_2, R.id.tv1_3, R.id.tv1_4, R.id.tv1_5, R.id.tv1_6, R.id.tv1_7, R.id.tv1_8},
            {R.id.tv2_0, R.id.tv2_1, R.id.tv2_2, R.id.tv2_3, R.id.tv2_4, R.id.tv2_5, R.id.tv2_6, R.id.tv2_7, R.id.tv2_8},
            {R.id.tv3_0, R.id.tv3_1, R.id.tv3_2, R.id.tv3_3, R.id.tv3_4, R.id.tv3_5, R.id.tv3_6, R.id.tv3_7, R.id.tv3_8},
            {R.id.tv4_0, R.id.tv4_1, R.id.tv4_2, R.id.tv4_3, R.id.tv4_4, R.id.tv4_5, R.id.tv4_6, R.id.tv4_7, R.id.tv4_8},
            {R.id.tv5_0, R.id.tv5_1, R.id.tv5_2, R.id.tv5_3, R.id.tv5_4, R.id.tv5_5, R.id.tv5_6, R.id.tv5_7, R.id.tv5_8},
            {R.id.tv6_0, R.id.tv6_1, R.id.tv6_2, R.id.tv6_3, R.id.tv6_4, R.id.tv6_5, R.id.tv6_6, R.id.tv6_7, R.id.tv6_8},
            {R.id.tv7_0, R.id.tv7_1, R.id.tv7_2, R.id.tv7_3, R.id.tv7_4, R.id.tv7_5, R.id.tv7_6, R.id.tv7_7, R.id.tv7_8},
            {R.id.tv8_0, R.id.tv8_1, R.id.tv8_2, R.id.tv8_3, R.id.tv8_4, R.id.tv8_5, R.id.tv8_6, R.id.tv8_7, R.id.tv8_8}};
    private Integer[][] llId = new Integer[][]{
            {R.id.ll0_0, R.id.ll0_1, R.id.ll0_2, R.id.ll0_3, R.id.ll0_4, R.id.ll0_5, R.id.ll0_6, R.id.ll0_7, R.id.ll0_8},
            {R.id.ll1_0, R.id.ll1_1, R.id.ll1_2, R.id.ll1_3, R.id.ll1_4, R.id.ll1_5, R.id.ll1_6, R.id.ll1_7, R.id.ll1_8},
            {R.id.ll2_0, R.id.ll2_1, R.id.ll2_2, R.id.ll2_3, R.id.ll2_4, R.id.ll2_5, R.id.ll2_6, R.id.ll2_7, R.id.ll2_8},
            {R.id.ll3_0, R.id.ll3_1, R.id.ll3_2, R.id.ll3_3, R.id.ll3_4, R.id.ll3_5, R.id.ll3_6, R.id.ll3_7, R.id.ll3_8},
            {R.id.ll4_0, R.id.ll4_1, R.id.ll4_2, R.id.ll4_3, R.id.ll4_4, R.id.ll4_5, R.id.ll4_6, R.id.ll4_7, R.id.ll4_8},
            {R.id.ll5_0, R.id.ll5_1, R.id.ll5_2, R.id.ll5_3, R.id.ll5_4, R.id.ll5_5, R.id.ll5_6, R.id.ll5_7, R.id.ll5_8},
            {R.id.ll6_0, R.id.ll6_1, R.id.ll6_2, R.id.ll6_3, R.id.ll6_4, R.id.ll6_5, R.id.ll6_6, R.id.ll6_7, R.id.ll6_8},
            {R.id.ll7_0, R.id.ll7_1, R.id.ll7_2, R.id.ll7_3, R.id.ll7_4, R.id.ll7_5, R.id.ll7_6, R.id.ll7_7, R.id.ll7_8},
            {R.id.ll8_0, R.id.ll8_1, R.id.ll8_2, R.id.ll8_3, R.id.ll8_4, R.id.ll8_5, R.id.ll8_6, R.id.ll8_7, R.id.ll8_8}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_sdoku);

        for(int i = 0; i < tvId.length; i++){
            for(int j = 0; j < tvId.length; j++){
                tvList[i][j] = findViewById(tvId[i][j]);
                llList[i][j] = findViewById(llId[i][j]);
            }
        }

        for(int i = 0; i < SIZE; i++){
            final int x = i;
            for(int j = 0; j < SIZE; j++){
                final int y = j;
                tvList[i][j].setOnClickListener(view -> {
                    findAway(x,y);

                });
            }

        }
    }

    private void findAway(int x, int y) {
        int block_X = (x/3)*3;
        int block_Y = (y/3)*3;

        for (int b_x = block_X; b_x < block_X+3; b_x++){
            for(int b_y = block_Y; b_y < block_Y+3; b_y++){
                tvList[b_x][b_y].setBackgroundColor(Color.GREEN);
            }
        }

        for(int k = 0; k < SIZE; k++){
            tvList[x][k].setBackgroundColor(Color.GREEN);
            tvList[k][y].setBackgroundColor(Color.GREEN);
        }
    }
}