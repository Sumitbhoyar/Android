package com.sumit.tools.stackoverflow.stackoverflowviewer.dto;

// This is used to map the JSON keys to the object by GSON
public class Question {

    public String title;
    public String link;
    public String question_id;

    @Override
    public String toString() {
        return(question_id);
    }
}
