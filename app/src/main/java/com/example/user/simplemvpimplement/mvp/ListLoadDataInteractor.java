package com.example.user.simplemvpimplement.mvp;

import com.example.user.simplemvpimplement.models.Repo;
import com.example.user.simplemvpimplement.retrofit.GithubService;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by User on 11/26/2017.
 */

public class ListLoadDataInteractor implements Callback<List<Repo>> {

    OnInteractorFinishedListener finishedListener;
    public ListLoadDataInteractor(OnInteractorFinishedListener listener) {
    this.finishedListener=listener;
    }

    private RestAdapter initRestAdapter(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://api.github.com")
                .build();
        return restAdapter;
    }

    public void loadRecentCommits(String username) {
        RestAdapter adapter = initRestAdapter();
        adapter.create(GithubService.class).listRepos(username, this);
    }



    @Override
    public void success(List<Repo> repos, Response response) {
        finishedListener.onNetworkSuccess(repos,response);

    }

    @Override
    public void failure(RetrofitError error) {
      finishedListener.onNetworkFailure(error);
    }
}
