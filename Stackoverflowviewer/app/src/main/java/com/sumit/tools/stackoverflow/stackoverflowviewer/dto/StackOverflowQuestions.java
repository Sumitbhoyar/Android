package com.sumit.tools.stackoverflow.stackoverflowviewer.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOverflowQuestions  {
    public List<Question> items;
    public static final Map<String, Question> ITEM_MAP = new HashMap<String, Question>();

    public void populateItems(){
        for (Question question: items) {
            ITEM_MAP.put(question.question_id, question);
        }
    }

}
