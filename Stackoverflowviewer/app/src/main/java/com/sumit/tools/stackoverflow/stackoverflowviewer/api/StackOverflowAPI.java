package com.sumit.tools.stackoverflow.stackoverflowviewer.api;

import com.sumit.tools.stackoverflow.stackoverflowviewer.dto.StackOverflowQuestions;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

public interface StackOverflowAPI {
    @GET("/2.2/questions?order=desc&sort=creation&site=stackoverflow")
    Call<StackOverflowQuestions> loadQuestions(@Query("tagged") String tags);
}
