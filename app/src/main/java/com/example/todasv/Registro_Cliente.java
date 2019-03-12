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

public class Registro_Cliente extends AppCompatActivity {
Button  registrar;
EditText nombre, apellido,cc,fecha,tel,correo,pass;
    String server_URL="HTTP://ippp /archivo.php";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__cliente);
        registrar = (Button)findViewById(R.id.Registro);
        nombre= (EditText)findViewById(R.id.nombre);
        apellido= (EditText)findViewById(R.id.apelliod);
        cc= (EditText)findViewById(R.id.cc);
        fecha= (EditText)findViewById(R.id.fecha);
        tel= (EditText)findViewById(R.id.tel) ;
        correo= (EditText)findViewById(R.id.correo);
        pass= (EditText)findViewById(R.id.pass);


        builder= new AlertDialog.Builder(Registro_Cliente.this);
        registrar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                final  String c,clave,nomb,apelli,email,fechaexpe,n_tel;

                c= cc.getText().toString();
                clave=pass.getText().toString();
                nomb=nombre.getText().toString();
                apelli=apellido.getText().toString();
                email=correo.getText().toString();
                fechaexpe=fecha.getText().toString();
                n_tel=tel.getText().toString();

                StringRequest SRequest =  new StringRequest(StringRequest.Method.POST, server_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        builder.setTitle("respuest de servidor");
                        builder.setMessage("Responde : "+ response);
                        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                cc.setText("");
                                pass.setText("");
                                nombre.setText("");
                                apellido.setText("");
                                 correo .setText("");
                                 tel.setText("");
                                 fecha.setText("");
                            }
                        });
                        AlertDialog alerta =builder.create();
                        alerta.show();
                    }
                }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registro_Cliente.this,"error.. ",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String > parametros  = new HashMap<String , String >();
                        //Creo que van los datos de php
                        parametros.put("nombre",nomb);
                        parametros.put("apellido",apelli);
                        parametros.put("fecha",fechaexpe);
                        parametros.put("correo",email);
                        parametros.put("tel",n_tel);
                        parametros .put("cedula",c);
                        parametros.put("clave",clave);

                        return parametros;
                    }
                };

                MySingleron.getInstance(Registro_Cliente.this).addTorequestque(SRequest);

            }
        });






    }

    public void pasarTipoArreglo(View view){
        Intent pasartipoarre = new Intent(this, tipo_de_arreglo.class);
        startActivity(pasartipoarre);


    }
}
