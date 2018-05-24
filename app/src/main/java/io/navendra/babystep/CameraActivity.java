package io.navendra.babystep;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CameraActivity extends AppCompatActivity {
    static String TAG = CameraActivity.class.getSimpleName();

    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        mImageView = findViewById(R.id.imageView);
    }

    //Code for Camera Open

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void CapturePhoto(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

    public void SharePhoto(View v){
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");
        Bitmap bitmap = ((BitmapDrawable) mImageView.getDrawable()).getBitmap();
        share.putExtra(Intent.EXTRA_STREAM, bitmap);
        startActivity(Intent.createChooser(share, "Share Image"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }
}
