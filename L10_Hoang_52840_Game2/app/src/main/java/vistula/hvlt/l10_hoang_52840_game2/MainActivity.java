package vistula.hvlt.l10_hoang_52840_game2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_playerName;
    TextView tv_scoreGame1;
    TextView tv_scoreGame2;
    String score1 = "0";
    String score2 = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_scoreGame1 = findViewById(R.id.tv_score1);
        tv_scoreGame2 = findViewById(R.id.tv_score3);
        et_playerName = findViewById(R.id.et_name);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            score1 = bundle.getString(ConstantVariables.SCORE_GAME1);
            score2 = bundle.getString(ConstantVariables.SCORE_GAME2);
            String playerName = bundle.getString(ConstantVariables.PLAYER_NAME);
            et_playerName.setText(playerName);
            tv_scoreGame1.setText(score1);
            tv_scoreGame2.setText(score2);
        }else{
            tv_scoreGame1.setText("0");
            tv_scoreGame2.setText("0");
        }
    }
    public void goToGame1(View view){
        Intent intent = new Intent(this, FirstGame.class);
        intent.putExtra(ConstantVariables.PLAYER_NAME, et_playerName.getText().toString());
        startActivity(intent);
    }
    public void goToGame2(View view){
        Intent intent = new Intent(this, SecondGame.class);
        intent.putExtra(ConstantVariables.PLAYER_NAME, et_playerName.getText().toString());
        startActivity(intent);
    }
}