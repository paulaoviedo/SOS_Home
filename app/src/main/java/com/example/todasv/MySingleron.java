package com.example.todasv;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleron {
    private static MySingleron intance;
    private RequestQueue requestQ;
    private static Context context;

    private MySingleron(Context context) {
        context = context;
        requestQ = getRequestQ();
    }

    public static synchronized MySingleron getInstance(Context context) {

        if (intance == null) {
            intance = new MySingleron(context);
        }
return  intance;
        }


    public RequestQueue getRequestQ() {
        if (requestQ == null) {
            requestQ = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQ;
    }


    public <T>void addTorequestque(Request<T> request){
        requestQ.add(request);
    }
}
