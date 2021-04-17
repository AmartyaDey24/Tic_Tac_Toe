package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView instruction;

    public Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, restart;

    int PLAYER_O = 0;
    int PLAYER_X = 1;

    int activePlayer = PLAYER_O;

    int[] filledPos = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    boolean isGameActive = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instruction = findViewById(R.id.inst);
        instruction.setText("O turn");
        restart = findViewById(R.id.restart);

        bt0 = findViewById(R.id.btn0);
        bt1 = findViewById(R.id.btn1);
        bt2 = findViewById(R.id.btn2);
        bt3 = findViewById(R.id.btn3);
        bt4 = findViewById(R.id.btn4);
        bt5 = findViewById(R.id.btn5);
        bt6 = findViewById(R.id.btn6);
        bt7 = findViewById(R.id.btn7);
        bt8 = findViewById(R.id.btn8);

        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (!isGameActive)
            return;

        Button clickedBtn = findViewById(v.getId());
        int clickedTag = Integer.parseInt(v.getTag().toString());

        if (filledPos[clickedTag] != -1) {
            return;
        }

        filledPos[clickedTag] = activePlayer;

        if (activePlayer == PLAYER_O) {
            clickedBtn.setText("O");
            activePlayer = PLAYER_X;
            instruction.setText("X turn");
        } else {
            clickedBtn.setText("X");
            activePlayer = PLAYER_O;
            instruction.setText("O turn");
        }

        checkForWin();

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reset();

            }
        });
    }

    private void checkForWin() {
        int[][] winningPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        for (int i = 0; i < 8; i++) {
            int val0 = winningPos[i][0];
            int val1 = winningPos[i][1];
            int val2 = winningPos[i][2];

            if (filledPos[val0] == filledPos[val1] && filledPos[val1] == filledPos[val2]) {
                if (filledPos[val0] != -1) {

                    isGameActive = false;

                    if (filledPos[val0] == PLAYER_O)
                        instruction.setText("O  is  WINNER!!");
                    else
                        instruction.setText("X  is  WINNER!!");
                }
            }
        }


    }

    private void reset() {
        activePlayer = PLAYER_O;
        instruction.setText("O turn");
        filledPos = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        bt0.setText("");
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");

        bt0.setBackground(getDrawable(android.R.color.darker_gray));
        bt1.setBackground(getDrawable(android.R.color.darker_gray));
        bt2.setBackground(getDrawable(android.R.color.darker_gray));
        bt3.setBackground(getDrawable(android.R.color.darker_gray));
        bt4.setBackground(getDrawable(android.R.color.darker_gray));
        bt5.setBackground(getDrawable(android.R.color.darker_gray));
        bt6.setBackground(getDrawable(android.R.color.darker_gray));
        bt7.setBackground(getDrawable(android.R.color.darker_gray));
        bt8.setBackground(getDrawable(android.R.color.darker_gray));
        isGameActive = true;
    }
}