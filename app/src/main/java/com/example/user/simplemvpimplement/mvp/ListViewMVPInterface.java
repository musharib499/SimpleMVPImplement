package com.example.user.simplemvpimplement.mvp;

import com.example.user.simplemvpimplement.models.Repo;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by User on 11/26/2017.
 */

public interface ListViewMVPInterface {
    void LoadedSuccess(List<Repo> list, Response response);
    void LoadedFailure(RetrofitError error);
    void setProgressBar(boolean show);

}
