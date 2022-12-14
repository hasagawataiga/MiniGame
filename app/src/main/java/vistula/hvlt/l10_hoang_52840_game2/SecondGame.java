package vistula.hvlt.l10_hoang_52840_game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondGame extends AppCompatActivity {
    TextView tv_playerName3;
    Button btn_letter1;
    Button btn_letter2;
    Button btn_letter3;
    Button btn_letter4;
    TextView tv_playerAnswer;
    TextView tv_resultGame2;
    TextView tv_scoreGame2;
    int scoreGame2 = 0;
    String result = "";
    String[] answerPool = {
            "door", "bill", "bird", "ball", "army", "acid", "also", "baby", "dust", "each",
            "bank", "bell", "bomb", "blue", "body", "bond", "book", "away", "earn", "edge",
            "area", "back", "base", "bear", "born", "bulk", "call", "card", "even", "down",
            "case", "cast", "chat", "city", "date", "deep", "desk", "disc", "fall", "fail",
            "dean", "debt", "deny", "dial", "diet", "draw", "dose", "dual", "file", "film",
            "fate", "feed", "feet", "fill", "find", "fine", "fear", "fast", "feel", "fact",
            "fuel", "game", "gate", "gear", "gift", "gene", "fund", "free", "from"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_game);
        Bundle bundle = getIntent().getExtras();
        String playerName = bundle.getString(ConstantVariables.PLAYER_NAME);
        tv_playerName3 = findViewById(R.id.tv_playerName3);
        tv_resultGame2 = findViewById(R.id.tv_resultGame2);
        tv_scoreGame2 = findViewById(R.id.tv_scoreGame2);
        btn_letter1 = findViewById(R.id.btn_letter1);
        btn_letter2 = findViewById(R.id.btn_letter2);
        btn_letter3 = findViewById(R.id.btn_letter3);
        btn_letter4 = findViewById(R.id.btn_letter4);
        tv_playerName3.setText(playerName);
        tv_resultGame2.setText("0");
        tv_scoreGame2.setText("0");
        tv_playerAnswer = findViewById(R.id.tv_playerAnswer);
        tv_playerAnswer.setText("");
    }

    public void generateRandomWord(View view){
        tv_playerAnswer.setText("");
        Random rd = new Random();
        int index = rd.nextInt(69);
        result = answerPool[index];
        int length = result.length();
        char ch[] = result.toCharArray();
        for (int i = 0; i < length; ++i) {
            int index2 = rd.nextInt(length - i);
            char tmp = ch[length - 1 - i];
            ch[length - 1 - i] = ch[index2];
            ch[index2] = tmp;
        }
        btn_letter1.setText(ch[0] + "");
        btn_letter2.setText(ch[1] + "");
        btn_letter3.setText(ch[2] + "");
        btn_letter4.setText(ch[3] + "");
    }

    public void addLetterToAnswer(View view){
        Button tmpButton;
        String str = tv_playerAnswer.getText().toString();
        switch (view.getId()) {
            case R.id.btn_letter1:
                tmpButton = findViewById(R.id.btn_letter1);
                str += tmpButton.getText().toString();
                break;
            case R.id.btn_letter2:
                tmpButton = findViewById(R.id.btn_letter2);
                str += tmpButton.getText().toString();
                break;
            case R.id.btn_letter3:
                tmpButton = findViewById(R.id.btn_letter3);
                str += tmpButton.getText().toString();
                break;
            case R.id.btn_letter4:
                tmpButton = findViewById(R.id.btn_letter4);
                str += tmpButton.getText().toString();
                break;
            default:
                break;
        }
        tv_playerAnswer.setText(str);
    }

    public void checkAnswer(View view){
        String answer = tv_playerAnswer.getText().toString();
        if(answer.equals(result)){
            increaseScoreGame2();
        }else{
            decreaseScoreGame2();
        }
        tv_resultGame2.setText(result);
        tv_scoreGame2.setText(Integer.toString(scoreGame2));
    }

    private void increaseScoreGame2(){
        scoreGame2++;
    }

    private void decreaseScoreGame2(){
        if(scoreGame2 != 0){
            scoreGame2--;
        }else{
            scoreGame2 = 0;
        }
    }

    public void backToStart(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(ConstantVariables.SCORE_GAME2, Integer.toString(scoreGame2));
        intent.putExtra(ConstantVariables.PLAYER_NAME, tv_playerName3.getText().toString());
        startActivity(intent);
    }
    public void nextToGame1(View view){
        Intent intent = new Intent(this, FirstGame.class);
        intent.putExtra(ConstantVariables.PLAYER_NAME, tv_playerName3.getText().toString());
        startActivity(intent);
    }
}