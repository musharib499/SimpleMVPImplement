package com.example.user.simplemvpimplement.retrofit;


import com.example.user.simplemvpimplement.models.Repo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by jpotts18 on 5/12/15.
 */

public interface GithubService {
    @GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, Callback<List<Repo>> callback);
}