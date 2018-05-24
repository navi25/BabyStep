package io.navendra.babystep;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HelloWorldActivity extends AppCompatActivity {

    static String TAG = HelloWorldActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);
    }

    public void GoBackToMainActivity(View v){
        Intent backToMain = new Intent(this,MainActivity.class);
        if (backToMain.resolveActivity(getPackageManager()) != null) {
            startActivity(backToMain);
        }else{
            Log.d(TAG,String.format(Constants.ACTIVITY_NOT_FOUND,MainActivity.TAG));
        }

    }

    public void GoBackWithResult(View v){
        Intent backWithResult = new Intent();
        backWithResult.putExtra("hello", "Hey Dude! How have you been?");
        setResult(RESULT_OK, backWithResult);
        finish();
    }



}
