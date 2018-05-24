package io.navendra.babystep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final Button button = findViewById(R.id.helloButton);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                OpenHelloWorldActivity();
//            }
//        });
//
//        final Button resultButton = findViewById(R.id.resultButton);
//        resultButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                OpenHelloWorldActivityForResult();
//            }
//        });

    }

    public void onHelloButtonClick(View v){
        OpenHelloWorldActivity();
    }

    public void onHResultButtonClick(View v){
        OpenHelloWorldActivityForResult();
    }


    //Starting An Activity - Function Start
    public void OpenHelloWorldActivity(){
        Intent openHelloActivityIntent = new Intent(this,HelloWorldActivity.class);
        // Verify that the intent will resolve to an activity
        if (openHelloActivityIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(openHelloActivityIntent);
        }else{
            Log.d(TAG,String.format(Constants.ACTIVITY_NOT_FOUND,HelloWorldActivity.TAG));
        }
    }
    //Starting An Activity - Function End


    //Starting An Activity For Result- Function Start
    public void OpenHelloWorldActivityForResult(){
        Intent resultIntent = new Intent(this,HelloWorldActivity.class);
        if (resultIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(resultIntent,1);
        }else{
            Log.d(TAG,String.format(Constants.ACTIVITY_NOT_FOUND,HelloWorldActivity.TAG));
        }
    }
    //Starting An Activity For Result- Function End


    // This method is called when the second activity finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == HelloWorldActivity.RESULT_FIRST_USER) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                // get String data from Intent
                String returnString = data.getStringExtra("hello");

                // set text view with string
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(returnString);
            }
        }
    }



}
