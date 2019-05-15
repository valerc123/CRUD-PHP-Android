package com.example.crud;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etid, etproducto, etvalor, etcategoria, etdescripcion;
    Button btnbuscar, btninsertar, btneliminar, btnactualizar;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etid = findViewById(R.id.etid);
        etproducto = findViewById(R.id.etproducto);
        etvalor = findViewById(R.id.etvalor);
        etcategoria = findViewById(R.id.etcategoria);
        etdescripcion = findViewById(R.id.etdescripcion);
        btnbuscar = findViewById(R.id.btnbuscar);
        btninsertar = findViewById(R.id.btninsertar);
        btneliminar = findViewById(R.id.btneliminar);
        btnactualizar = findViewById(R.id.btnactualizar);
    }

    private void serviciohttp(String URL)
    {
        // se pasa como parametro( metodo url, acciones, listener)
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "Operación exitosa", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Hubo un error en la petición" + error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            //              clave valor
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("id", etid.getText().toString());
                parametros.put("producto", etproducto.getText().toString());
                parametros.put("categoria", etcategoria.getText().toString());
                parametros.put("descripcion", etdescripcion.getText().toString());
                parametros.put("valor", etvalor.getText().toString());
                return parametros;
            }
        };
        //procesa las peticiones realizadas para que la libreria pueda procesarlas
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    //insertar
    public void insertarProducto(View view) {
        serviciohttp("http://192.168.43.175:82/crud/insert_product.php"); // la carpeta con el crud en el C
    }
}
