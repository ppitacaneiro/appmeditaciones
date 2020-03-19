package com.example.pablo.appmeditaciones;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pablo.appmeditaciones.Modelos.Mandala;

public class MandalaActivity extends AppCompatActivity {

    Mandala mandala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandala);

        mandala = (Mandala) getIntent().getExtras().getSerializable("mandala");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(hasFocus){
            final ImageView imageViewMandala = (ImageView) findViewById(R.id.imageViewMandala);



            String uri = "@drawable/" + mandala.getGrafico();
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            final Drawable imagen = ContextCompat.getDrawable(getApplicationContext(), imageResource);

            imageViewMandala.setImageDrawable(getResources().getDrawable(R.drawable.reverso));

            imageViewMandala.animate().withLayer()
                    .rotationY(90)
                    .setDuration(1000)
                    .withEndAction(
                            new Runnable() {
                                @Override public void run() {
                                    imageViewMandala.setImageDrawable(imagen);

                                    // second quarter turn
                                    float scale = getApplicationContext().getResources().getDisplayMetrics().density;
                                    float distance = imageViewMandala.getCameraDistance() * (scale + (scale / 3));
                                    imageViewMandala.setCameraDistance(distance);
                                    imageViewMandala.setRotationY(-90);
                                    imageViewMandala.animate().withLayer()
                                            .rotationY(0)
                                            .setDuration(1000)
                                            .start();
                                }
                            }
                    ).start();

            imageViewMandala.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MandalaActivity.this, DetallesMandalaActivity.class);
                    intent.putExtra("mandala", mandala);
                    startActivity(intent);
                }
            });
        }
    }
}
