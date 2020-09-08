package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.media.Rating;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class clothed extends AppCompatActivity {

    ImageView M,L,XL;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothed);

        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        LayerDrawable stars = (LayerDrawable)ratingBar.getProgressDrawable();

        stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP);
    }
}