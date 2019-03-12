package com.example.todasv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class tipo_de_arreglo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_de_arreglo);
    }

    public void pasarDescriProblema(View view){
        Intent pasardescproblem = new Intent(this, describir_problema.class);
        startActivity(pasardescproblem);
    }
}
