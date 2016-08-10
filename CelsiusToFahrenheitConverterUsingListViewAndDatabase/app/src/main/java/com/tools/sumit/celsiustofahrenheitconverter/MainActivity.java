package com.tools.sumit.celsiustofahrenheitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.tools.sumit.celsiustofahrenheitconverter.persistence.ConversionDataSource;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.celsiusInput).setOnKeyListener(registerCelsiusConverter());
        findViewById(R.id.fahrenheitInput).setOnKeyListener(registerFahrenheitConverter());

    }

    @NonNull
    private View.OnKeyListener registerCelsiusConverter() {
        return new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN) return false;
                final EditText celsiusEdit = (EditText) findViewById(R.id.celsiusInput);
                final EditText fahrenheitEdit = (EditText) findViewById(R.id.fahrenheitInput);
                String celsiusStr = celsiusEdit.getText().toString();
                if(celsiusStr.isEmpty()){
                    fahrenheitEdit.setText("");
                }else{
                    Double celsiusVal = Double.parseDouble(celsiusStr);
                    Double fahrenheitResult = celsiusVal * 9/5 + 32;
                    fahrenheitEdit.setText(fahrenheitResult.toString());
                    new ConversionDataSource(view.getContext()).createConversion(celsiusVal + " celsius to "+ fahrenheitResult + " fahrenheit");
                }
                return false;
            }
        };
    }

    @NonNull
    private View.OnKeyListener registerFahrenheitConverter() {
        return new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                System.out.println(keyEvent.getAction());
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN) return false;
                final EditText celsiusEdit = (EditText) findViewById(R.id.celsiusInput);
                final EditText fahrenheitEdit = (EditText) findViewById(R.id.fahrenheitInput);
                String fahrenheitStr = fahrenheitEdit.getText().toString();
                if(fahrenheitStr.isEmpty()){
                    celsiusEdit.setText("");
                }else{
                    Double fahrenheitVal = Double.parseDouble(fahrenheitStr);
                    Double celsiusResult = (fahrenheitVal - 32) * 9/5;
                    celsiusEdit.setText(celsiusResult.toString());
                    new ConversionDataSource(view.getContext()).createConversion(fahrenheitVal + " fahrenheit to "+ celsiusResult + " celsius");
                }
                return false;
            }
        };
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(this, HistoryActivity.class);
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
