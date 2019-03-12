package com.example.todasv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Regis_PDS_Cliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis__pds__cliente);
    }

    public void RegisPDS(View view){
        Intent regispds = new Intent(this, Registro_PDS.class);
        startActivity(regispds);
    }

    public void RegisCliente(View view){
        Intent regiscliente = new Intent(this, Registro_Cliente.class);
        startActivity(regiscliente);
    }
}
