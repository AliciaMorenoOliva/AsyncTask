package com.ng.a.asynctask;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String URL_IMAGEN = "https://i.ytimg.com/vi/JRXeaqYeyvA/hqdefault.jpg";

    public void mostrarImagenDescargada (Bitmap bitmap)
    {
        if (bitmap!=null){
            ImageView imageView = findViewById(R.id.imagen);
            imageView.setImageBitmap(bitmap);

        }else{
            Toast.makeText(this,"NO SE PUDO DESCARGAR",Toast.LENGTH_LONG).show();
        }

        //TODO mostrar imagen
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DescargarImagen descargarImagen= new DescargarImagen(this);
        descargarImagen.execute(URL_IMAGEN);
    }
}
