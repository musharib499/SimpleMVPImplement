package com.example.user.simplemvpimplement.mvp;

import com.example.user.simplemvpimplement.models.Repo;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by User on 11/26/2017.
 */

public interface OnInteractorFinishedListener {
    void onNetworkSuccess(List<Repo> list, Response response);
    void onNetworkFailure(RetrofitError error);
    public void loadCommits(String username);
}
