package com.ng.a.asynctask;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String URL_IMAGEN = "https://i.ytimg.com/vi/JRXeaqYeyvA/hqdefault.jpg";
    private ProgressBar progressBar;


    public void mostrarImagenDescargada (Bitmap bitmap)
    {
        progressBar.setVisibility(View.INVISIBLE);
        if (bitmap!=null){
            ImageView imageView = findViewById(R.id.imagen);
            imageView.setImageBitmap(bitmap);

        }else{
            Toast.makeText(this,"NO SE PUDO DESCARGAR",Toast.LENGTH_LONG).show();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_circular);
        progressBar.setVisibility(View.VISIBLE);

        DescargarImagen descargarImagen= new DescargarImagen(this);
        descargarImagen.execute(URL_IMAGEN);
    }
}
