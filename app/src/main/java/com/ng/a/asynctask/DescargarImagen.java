package com.ng.a.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import java.net.URL;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class DescargarImagen extends AsyncTask<String, Void, Bitmap> {

    private MainActivity pantalla_imagen;

    public DescargarImagen(MainActivity mainActivity)
    {
this.pantalla_imagen = mainActivity; //gurdo un referencia
    }

    @Override
    protected void onPreExecute() {
        Log.d("MIAPP", "Va a empezar la descarga");
        super.onPreExecute();
    }

    // la salida (en este caso la imagen obtenida)
    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;//imagen descargada
        InputStream in = null;//para manejar el cuerpo del HTTP
        int respuesta = -1;//para saber si ha ido bien o mal la comunicacion
        URL url = null;//direccion de la foto
        HttpURLConnection httpConn = null;//para manejar HTTP

        try
        {
            Log.d("MIAPP", "Descargando . . .");
            url = new URL(params[0]);
            httpConn = (HttpURLConnection) url.openConnection();

            respuesta = httpConn.getResponseCode();//status code
            if (respuesta == HttpURLConnection.HTTP_OK)//si es 200 es que ha ido bien
            {
                Log.d("MIAPP", "TIPO info" + httpConn.getContentType());
                in = httpConn.getInputStream();//leo el cuerpo
                bitmap = BitmapFactory.decodeStream(in);//decodificar el cuerpo del mensaje y construir la foto
                in.close();//llamada a cerrar
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.d(getClass().getCanonicalName(), "ERROR descargando la imagen", e);
        }

        return bitmap;

    }



    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        Log.d("MIAPP", "Finalizó la acyividad");
        this.pantalla_imagen.mostrarImagenDescargada(bitmap);

    }
}
