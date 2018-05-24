package io.navendra.babystep;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HelloWorldActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);
        final Button button = findViewById(R.id.mainButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoBackToMainActivity();
            }
        });

    }

    public void GoBackToMainActivity(){
        Intent backToMain = new Intent(this,MainActivity.class);
        startActivity(backToMain);
    }
}
