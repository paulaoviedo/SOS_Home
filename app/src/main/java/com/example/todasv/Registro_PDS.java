package com.example.todasv;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Registro_PDS extends AppCompatActivity {
    Button registrar;
    EditText nombre, apellido,cc,fecha,tel,correo,pass,profesio;
    String server_URL="HTTP://ippp /archivo.php";
    AlertDialog.Builder builder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__pds);



        registrar = (Button)findViewById(R.id.Siguiente);
        nombre= (EditText)findViewById(R.id.nombre);
        apellido= (EditText)findViewById(R.id.apelliod);
        cc= (EditText)findViewById(R.id.cc);
        fecha= (EditText)findViewById(R.id.fecha);
        tel= (EditText)findViewById(R.id.tel) ;
        correo= (EditText)findViewById(R.id.correo);
        pass= (EditText)findViewById(R.id.pass);
        profesio=(EditText)findViewById(R.id.profe);

        builder= new AlertDialog.Builder(Registro_PDS.this);
        registrar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                final  String c,clave,nomb,apelli,email,fechaexpe,n_tel,profes;


                c= cc.getText().toString();
                clave=pass.getText().toString();
                nomb=nombre.getText().toString();
                apelli=apellido.getText().toString();
                email=correo.getText().toString();
                fechaexpe=fecha.getText().toString();
                n_tel=tel.getText().toString();
                profes=profesio.getText().toString();

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
                                profesio.setTag("");

                                Intent registrarse = new Intent(Registro_PDS.this, MainActivity.class);
                                startActivity(registrarse);
                            }
                        });
                        AlertDialog alerta =builder.create();
                        alerta.show();
                    }
                }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registro_PDS.this,"error.. ",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String > parametros  = new HashMap<String , String >();

                        parametros.put("nombre",nomb);
                        parametros.put("apellido",apelli);
                        parametros.put("fecha",fechaexpe);
                        parametros.put("correo",email);
                        parametros.put("tel",n_tel);
                        parametros .put("cedula",c);
                        parametros.put("clave",clave);
                        parametros.put("profesion",profes);

                        return parametros;
                    }
                };

                MySingleron.getInstance(Registro_PDS.this).addTorequestque(SRequest);

            }
        });

    }


}
