package com.example.destiny_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button option1;
    Button option2;
    TextView storyLabel;
    DestinyBrain destinyBrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.destinyBrain = new DestinyBrain();
        this.catchReferencesForUIElements();
        this.registerForUIEvents();
        this.updateStory();
    }

    private void catchReferencesForUIElements(){
        this.option1 = findViewById(R.id.firstChoice);
        this.option2 = findViewById(R.id.secondChoice);
        this.storyLabel = findViewById(R.id.sceneLabel);
    }

    private void registerForUIEvents(){

        this.option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    destinyBrain.updateSceneForOption(1);
                    updateStory();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        this.option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    destinyBrain.updateSceneForOption(2);
                    updateStory();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void updateStory(){
        this.storyLabel.setText(this.destinyBrain.getCurrentStory());
        String[] options = this.destinyBrain.getCurrentOptions();
        this.option1.setText(options[0]);
        this.option2.setText(options[1]);
    }
}
