package com.sumit.tools.stackoverflow.stackoverflowviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void search(View view){
        Intent intent = new Intent(this, QuestionListActivity.class);
        EditText searchQuery = (EditText) findViewById(R.id.searchCriteria);
        String queryText = searchQuery.getText().toString();
        if(queryText.isEmpty()){
            return;
        }
        intent.putExtra("searchQuery", queryText);
        startActivity(intent);
    }
}
