package com.example.projectsudoku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaySdokuActivity extends AppCompatActivity {
    private static final int WHITE = 0;
    private static final int BLACK = 1;
    private static final int SIZE = 9;

    private RelativeLayout rtMain;
    private LinearLayout llMain;

    private ArrayList<TextView> numList = new ArrayList<>();
    private TextView[][] tvList = new TextView[9][9];
    private LinearLayout[][] llList = new LinearLayout[9][9];

    private int color;
    private int clearColor;
    private int choiceColor;

    final String[] words = new String[] {"흰색", "검정"};


    private Integer[] tvNumId = new Integer[]
            {R.id.tvNum1, R.id.tvNum2, R.id.tvNum3, R.id.tvNum4, R.id.tvNum5, R.id.tvNum6, R.id.tvNum7, R.id.tvNum8, R.id.tvNum9};

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

    private int x_position = 0;
    private int y_position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_sdoku);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        findViewByIdFunc();

        eventHandlerFunc();

        setBackgroundColor(0);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                showDialogThemes();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialogThemes() {
        new AlertDialog.Builder(this).setTitle("선택").setSingleChoiceItems(words, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setBackgroundColor(which);

            }
        }).setPositiveButton("closed", null).show();

    }

    private void setBackgroundColor(int choice){
        switch(choice){
            case WHITE:
                rtMain.setBackgroundColor(Color.WHITE);
                llMain.setBackgroundColor(Color.WHITE);
                color = 0xFFDCDCDC;
                clearColor = Color.WHITE;
                choiceColor = 0xFF00BFFF;
                break;
            case BLACK:
                rtMain.setBackgroundColor(0xFF272424);
                color = 0xFF9A9A9A;
                clearColor = 0xFF272424;
                choiceColor = 0xFF00BFFF;
                break;
            default:
                break;
        }

        for(int i = 0; i < llList.length; i++){
            for(int k = 0; k < llList.length; k++){
                tvList[i][k].setBackgroundColor(clearColor);
            }
        }
    }




    private void eventHandlerFunc() {

        //스도쿠판 터치시 색칠
        for (int i = 0; i < SIZE; i++) {
            final int x = i;
            for (int j = 0; j < SIZE; j++) {
                final int y = j;

                tvList[i][j].setOnClickListener(view -> {


                    deleteAway();

                    findAway(x, y);
                    tvList[x][y].setBackgroundColor(choiceColor);
                    //색칠된거 지우는 위치 숫자넣는위치 저장
                    x_position = x;
                    y_position = y;
                });
            }
        }//end of for

        //터치시 해당 위치에 숫자입력
        for (int i = 0; i < numList.size(); i++) {
            final int num = i + 1;
            numList.get(i).setOnClickListener(v -> {
                tvList[x_position][y_position].setText(String.valueOf(num));
            });
        }
    }

    private void findViewByIdFunc() {

        rtMain = findViewById(R.id.rtMain);
        llMain = findViewById(R.id.llMain);

        for (int i = 0; i < tvId.length; i++) {
            for (int j = 0; j < tvId.length; j++) {
                tvList[i][j] = findViewById(tvId[i][j]);
                llList[i][j] = findViewById(llId[i][j]);
            }
        }

        for (int i = 0; i < tvNumId.length; i++) {
            numList.add(findViewById(tvNumId[i]));
        }
    }

    //이전에 색칠된 칸 색칠 지우기
    private void deleteAway() {
        int block_X = (x_position / 3) * 3;
        int block_Y = (y_position / 3) * 3;


        for (int b_x = block_X; b_x < block_X + 3; b_x++) {
            for (int b_y = block_Y; b_y < block_Y + 3; b_y++) {
                tvList[b_x][b_y].setBackgroundColor(clearColor);
            }
        }

        for (int k = 0; k < SIZE; k++) {
            tvList[x_position][k].setBackgroundColor(clearColor);
            tvList[k][y_position].setBackgroundColor(clearColor);
        }
    }

    //터치시 해당되는 9칸과 가로 세로 색칠
    private void findAway(int x, int y) {
        int block_X = (x / 3) * 3;
        int block_Y = (y / 3) * 3;


        for (int b_x = block_X; b_x < block_X + 3; b_x++) {
            for (int b_y = block_Y; b_y < block_Y + 3; b_y++) {
                tvList[b_x][b_y].setBackgroundColor(color);
            }
        }

        for (int k = 0; k < SIZE; k++) {
            tvList[x][k].setBackgroundColor(color);
            tvList[k][y].setBackgroundColor(color);
        }
    }
}