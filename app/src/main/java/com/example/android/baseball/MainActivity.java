package com.example.android.baseball;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

import static android.R.attr.id;
import static com.example.android.baseball.R.id._11_teamA;
import static com.example.android.baseball.R.id._11_teamB;
import static com.example.android.baseball.R.id.hit_a;
import static com.example.android.baseball.R.id.hit_b;
import static com.example.android.baseball.R.string.pitch;

public class MainActivity extends AppCompatActivity {

    int score_a = 0;
    int score_b = 0;
    int pitchNum = 1;
    int hitA = 0;
    int hitB = 0;
    int errA = 0;
    int errB = 0;
    int pitch_score_a = 0;
    int pitch_score_b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayScore(score_a, score_b);
        displayPitchNum(pitchNum);
        displayRunA(score_a);
        displayRunB(score_b);
        displayHitA(hitA);
        displayHitB(hitB);
        displayErrA(errA);
        displayErrB(errB);
        displayPitchScoreA(pitch_score_a);
        displayPitchScoreB(pitch_score_b);
    }

    public void displayScore(int scoreA, int scoreB) {
        TextView scoreView = (TextView) findViewById(R.id.score);
        String msg = score_a + ":" + score_b;
        scoreView.setText(msg);
    }

    public void displayRunA(int run) {
        TextView runView = (TextView) findViewById(R.id._10_teamA);
        String r = "" + run;
        runView.setText(r);
    }

    public void displayRunB(int run) {
        TextView runView = (TextView) findViewById(R.id._10_teamB);
        String r = "" + run;
        runView.setText(r);
    }

    public void displayPitchNum(int num) {
        TextView pitchView = (TextView) findViewById(R.id.pitch);
        String pitchMsg;
        pitchMsg = "Pitch  " + num;
        pitchView.setText(pitchMsg);
    }

    public void displayPitchScoreA(int score) {
        Context context = this;
        int id = getResources().getIdentifier(String.format(Locale.US, "_%d_teamA", pitchNum), "id", context.getPackageName());
        TextView aPitchView = (TextView) findViewById(id);
        String pitchMsg = "" + score;
        aPitchView.setText(pitchMsg);
    }

    public void displayPitchScoreB(int score) {
        Context context = this;
        int id = getResources().getIdentifier(String.format(Locale.US, "_%d_teamB", pitchNum), "id", context.getPackageName());
        TextView aPitchView = (TextView) findViewById(id);
        String pitchMsg = "" + score;
        aPitchView.setText(pitchMsg);
    }

    public void displayHitA(int hit) {
        TextView hitView = (TextView) findViewById(_11_teamA);
        String h = "" + hit;
        hitView.setText(h);
    }

    public void displayHitB(int hit) {
        TextView hitView = (TextView) findViewById(_11_teamB);
        String h = "" + hit;
        hitView.setText(h);
    }

    public void displayErrA(int err) {
        TextView errView = (TextView) findViewById(R.id._12_teamA);
        String e = "" + err;
        errView.setText(e);
    }

    public void displayErrB(int err) {
        TextView errView = (TextView) findViewById(R.id._12_teamB);
        String e = "" + err;
        errView.setText(e);
    }

    public void run(View view) {
        switch (view.getId()) {
            case R.id.run_a:
                score_a += 1;
                pitch_score_a += 1;
                displayScore(score_a, score_b);
                displayRunA(score_a);
                displayPitchScoreA(pitch_score_a);
                break;
            case R.id.run_b:
                score_b += 1;
                pitch_score_b += 1;
                displayScore(score_a, score_b);
                displayRunB(score_b);
                displayPitchScoreB(pitch_score_b);
                break;
        }
    }

    public void hit(View view) {
        switch (view.getId()) {
            case hit_a:
                hitA += 1;
                displayHitA(hitA);
                break;
            case hit_b:
                hitB += 1;
                displayHitB(hitB);
                break;
        }
    }

    public void err(View view) {
        switch (view.getId()) {
            case R.id.err_a:
                errA += 1;
                displayErrA(errA);
                break;
            case R.id.err_b:
                errB += 1;
                displayErrB(errB);
                break;
        }
    }

    public void nextPitch(View view) {
        if (pitchNum >= 9) {
            return;
        }
        pitchNum += 1;
        displayPitchNum(pitchNum);
        pitch_score_a = 0;
        pitch_score_b = 0;
        displayPitchScoreA(pitch_score_a);
        displayPitchScoreB(pitch_score_b);
    }

    public void reset(View view) {
        score_a = 0;
        score_b = 0;
        pitchNum = 1;
        hitA = 0;
        hitB = 0;
        errA = 0;
        errB = 0;
        pitch_score_a = 0;
        pitch_score_b = 0;
        String Null = "";
        Context context = this;
        for (int i = 1; i <= 12; i++) {
            int id1 = getResources().getIdentifier(String.format(Locale.US, "_%d_teamB", i), "id", context.getPackageName());
            int id2 = getResources().getIdentifier(String.format(Locale.US, "_%d_teamA", i), "id", context.getPackageName());
            TextView clrView1 = (TextView) findViewById(id1);
            TextView clrView2 = (TextView) findViewById(id2);
            clrView1.setText(Null);
            clrView2.setText(Null);
        }
        displayScore(score_a, score_b);
        displayPitchNum(pitchNum);
        displayPitchScoreA(0);
        displayPitchScoreB(0);
        displayHitA(0);
        displayHitB(0);
        displayErrA(0);
        displayErrB(0);
        displayRunA(0);
        displayRunB(0);
    }
}
