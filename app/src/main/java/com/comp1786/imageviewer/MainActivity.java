package com.comp1786.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button backButton;
    private Button forwardButton;

    private int[] imageResourceIds;
    private int currentImageIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        backButton = findViewById(R.id.btnBack);
        forwardButton = findViewById(R.id.btnForward);

        imageResourceIds = new int[] {
                R.drawable.image_1,
                R.drawable.image_2,
                R.drawable.image_3,
                R.drawable.image_4,
                R.drawable.image_5
        };

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImageIndex > 0) {
                    currentImageIndex--;
                    updateImageView();
                }
            }
        });
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImageIndex < imageResourceIds.length - 1) {
                    currentImageIndex++;
                    updateImageView();
                }
            }
        });
        currentImageIndex = 0;
        updateImageView();
    }
    private void updateImageView() {
        imageView.setImageResource(imageResourceIds[currentImageIndex]);
    }
}