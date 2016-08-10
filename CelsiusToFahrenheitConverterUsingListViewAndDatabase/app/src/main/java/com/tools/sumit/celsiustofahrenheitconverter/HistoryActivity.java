package com.tools.sumit.celsiustofahrenheitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tools.sumit.celsiustofahrenheitconverter.domain.Conversion;
import com.tools.sumit.celsiustofahrenheitconverter.persistence.ConversionDataSource;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        List<String> allConversions = new ConversionDataSource(getApplicationContext()).getAllConversions();

        ListView listView = (ListView) findViewById(R.id.historyList);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.fragment_loglist, allConversions);
        listView.setAdapter(adapter);
    }
}
