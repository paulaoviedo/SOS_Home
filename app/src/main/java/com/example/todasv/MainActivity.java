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
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
Button iniciar ;
EditText cc , pass;
String server_URL="HTTP://ippp /archivo.php";
AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = (Button)findViewById(R.id.botonlogin);
        cc =(EditText) findViewById(R.id.cc);
        pass=(EditText) findViewById(R.id.clavelogin);
        builder= new AlertDialog.Builder(MainActivity.this);
        iniciar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                final  String c,clave;

                c= cc.getText().toString();
                clave=pass.getText().toString();
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
                            }
                        });
                        AlertDialog alerta =builder.create();
                        alerta.show();
                    }
                }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"error.. ",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String > parametros  = new HashMap<String , String >();

                        parametros .put("cedula",c);
                        parametros.put("clave",clave);
                        return parametros;
                    }
                };

                MySingleron.getInstance(MainActivity.this).addTorequestque(SRequest);
            }
        });






    }

    public void pasarRegistroPDSyCli(View view){
        Intent pasaregis = new Intent(this, Regis_PDS_Cliente.class);
        startActivity(pasaregis);
    }


}
