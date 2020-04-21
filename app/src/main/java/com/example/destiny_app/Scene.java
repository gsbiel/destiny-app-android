package com.example.destiny_app;

import android.app.ExpandableListActivity;

public class Scene {
    private String title;
    private String option1;
    private String option2;
    private int option1_destination;
    private int option2_destination;

    Scene(String title, String option1, String option2, int dest1, int dest2){
        this.title = title;
        this.option1 = option1;
        this.option2 = option2;
        this.option1_destination = dest1;
        this.option2_destination = dest2;
    }

    public String getTitle(){
        return this.title;
    }

    public String getOption1(){
        return this.option1;
    }

    public String getOption2(){
        return this.option2;
    }

    public int getDestinationForOption(int number) throws Exception {
        if(number == 1){
            return this.option1_destination;
        }else if(number == 2){
            return this.option2_destination;
        }else{
            throw new Exception("Erro: Scene.java/getDestinationForOption() -> argumento 'number' é inválido.");
        }
    }
}
