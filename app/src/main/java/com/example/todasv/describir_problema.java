package com.example.todasv;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class describir_problema extends AppCompatActivity {
Button continuar;
EditText nombre,descripcion,fecha;
    String server_URL="HTTP://ippp /archivo.php";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_describir_problema);
        continuar = (Button)findViewById(R.id.Registro);
        nombre= (EditText)findViewById(R.id.nombrepro);
        descripcion= (EditText)findViewById(R.id.descripcionproblema);
        fecha= (EditText)findViewById(R.id.fechapro);
        builder= new AlertDialog.Builder(describir_problema.this);
        continuar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                final  String nom,descrip,fecha_trabajo;

                nom= nombre.getText().toString();
                descrip=descripcion.getText().toString();
                fecha_trabajo=fecha.getText().toString();

                StringRequest SRequest =  new StringRequest(StringRequest.Method.POST, server_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("respuest de servidor");
                        builder.setMessage("Responde : "+ response);
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                nombre.setText("");
                                descripcion.setText("");
                                fecha.setText("");

                                Intent pasarselectrabajador = new Intent(describir_problema.this, seleccionar_trabajador.class);
                                startActivity(pasarselectrabajador);
                            }
                        });
                        AlertDialog alerta =builder.create();
                        alerta.show();
                    }
                }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(describir_problema.this,"error.. ",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String > parametros  = new HashMap<String , String >();
                        //Creo que van los datos de php

                        parametros .put("nombre",nom);
                        parametros.put("descripcion",descrip);
                        parametros.put("fecha",fecha_trabajo);
                        return parametros;
                    }
                };

                MySingleron.getInstance(describir_problema.this).addTorequestque(SRequest);
            }
        });






    }


}
