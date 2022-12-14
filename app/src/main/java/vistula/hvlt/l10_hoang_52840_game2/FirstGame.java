package vistula.hvlt.l10_hoang_52840_game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class FirstGame extends AppCompatActivity {
    TextView tv_playerName;
    Button btn_play;
    Button btn_number1;
    Button btn_number2;
    Button btn_number3;
    TextView tv_scoreGame1;
    TextView tv_resultGame1;
    int scoreGame1 = 0;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_game);
        tv_playerName = findViewById(R.id.tv_playerName2);
        btn_play = findViewById(R.id.btn_play);
        btn_number1 = findViewById(R.id.btn_number1);
        btn_number2 = findViewById(R.id.btn_number2);
        btn_number3 = findViewById(R.id.btn_number3);
        tv_scoreGame1 = findViewById(R.id.tv_scoreGame1);
        tv_resultGame1 = findViewById(R.id.tv_resultGame1);
        Bundle bundle = getIntent().getExtras();
        String playerName = bundle.getString(ConstantVariables.PLAYER_NAME);
        tv_playerName.setText(playerName);
        tv_resultGame1.setText("0");
        tv_scoreGame1.setText("0");
    }

    public void generateNumbers(View view){
        Random rd = new Random();
        int number1 = rd.nextInt(100);
        int number2 = rd.nextInt(100);
        int number3 = rd.nextInt(100);
        btn_number1.setText(Integer.toString(number1));
        btn_number2.setText(Integer.toString(number2));
        btn_number3.setText(Integer.toString(number3));
        findBiggestNumber(number1, number2, number3);
    }

    private void findBiggestNumber(int a, int b, int c) {
        int max = a;
        max = Math.max(max, b);
        max = Math.max(max, c);
        result = max;
    }

    public void checkAnswer(Button btn){
        String str = btn.getText().toString();
        if(str == Integer.toString(result)){
            increaseScore();
        }else{
            decreaseScore();
        }
    }

    private void printResult(){
        tv_resultGame1.setText(Integer.toString(result));
    }
    private void printScore(){
        tv_scoreGame1.setText(Integer.toString(scoreGame1));
    }
    public void onClickNumber1(View view){
        checkAnswer(btn_number1);
        printResult();
        printScore();
    }
    public void onClickNumber2(View view){
        checkAnswer(btn_number2);
        printResult();
        printScore();
    }
    public void onClickNumber3(View view){
        checkAnswer(btn_number3);
        printResult();
        printScore();
    }

    private void increaseScore(){
        scoreGame1++;
    }

    private void decreaseScore() {
        if(scoreGame1 !=0){
            scoreGame1--;
        }else{
            scoreGame1 = 0;
        }
    }

    public void backToStart (View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(ConstantVariables.SCORE_GAME1, Integer.toString(scoreGame1));
        intent.putExtra(ConstantVariables.PLAYER_NAME, tv_playerName.getText().toString());
        startActivity(intent);
    }
    public void nextToGame2 (View view){
        Intent intent = new Intent(this, SecondGame.class);
        intent.putExtra(ConstantVariables.PLAYER_NAME, tv_playerName.getText().toString());
        startActivity(intent);
    }
}