package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void clearTextView2(View view) {
        TextView output = findViewById( R.id.textView2 );
//        Log.i( "button pressed", "onButtonClick: " + view.getContext().getText( view.getId() ));
        output.setText("0");
    }

    public void onButtonClick_1(View view) {
        Button button = findViewById( R.id.button_1 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );
    }

    public void onButtonClick_2(View view) {
        Button button = findViewById( R.id.button_2 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );
    }

    public void onButtonClick_3(View view) {
        Button button = findViewById( R.id.button_3 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );
    }

    public void onButtonClick_4(View view) {
        Button button = findViewById( R.id.button_4 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );
    }

    public void onButtonClick_5(View view) {
        Button button = findViewById( R.id.button_5 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );
    }

    public void onButtonClick_6(View view) {
        Button button = findViewById( R.id.button_6 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );
    }

    public void onButtonClick_7(View view) {
        Button button = findViewById( R.id.button_7 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );

    }
    public void onButtonClick_8(View view) {
        Button button = findViewById( R.id.button_8 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );
    }

    public void onButtonClick_9(View view) {
        Button button = findViewById( R.id.button_9 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );
    }

    public void onButtonClick_0(View view) {
        Button button = findViewById( R.id.button_10 );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2StartingZero();
        output.append(" " + button.getText() );
    }

    public void onButtonClick_digit(View view) {
        Button button = findViewById( R.id.button_digit );
        TextView output = findViewById( R.id.textView2 );
        if (! checkTextView2DigitFound()) {
            output.append( button.getText() );
        }
    }

    public void onButtonClick_multiply(View view) {
        Button button = findViewById( R.id.button_calculation_method_multiplication );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2MethodFound("*");
    }

    public void onButtonClick_divide(View view) {
        Button button = findViewById( R.id.button_calculation_method_multiplication );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2MethodFound("÷");
    }

    public void onButtonClick_plus(View view) {
        Button button = findViewById( R.id.button_calculation_method_addition );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2MethodFound("+");
    }

    public void onButtonClick_minus(View view) {
        Button button = findViewById( R.id.button_calculation_method_multiplication );
        TextView output = findViewById( R.id.textView2 );
        checkTextView2MethodFound("-");
    }

    public void onButtonClick_plusminus(View view) {
    }

    public void onButtonClick_equals(View view) {
    }

    private void checkTextView2StartingZero() {
        TextView output = findViewById( R.id.textView2 );
        if("0".equals( String.valueOf( output.getText()))) {
            output.setText( "" );
        }
    }

    private boolean checkTextView2DigitFound() {
        TextView output = findViewById( R.id.textView2 );
        return String.valueOf( output.getText()).contains( "." );
    }

    private void checkTextView2MethodFound(String method) {
        TextView output = findViewById( R.id.textView2 );
        output.setText(String.valueOf( output.getText() ).replaceAll( "\\D+$", "" ));
        output.append( " " + method );
    }
}
