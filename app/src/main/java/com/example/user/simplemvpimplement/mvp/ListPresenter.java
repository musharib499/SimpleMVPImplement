package com.example.user.simplemvpimplement.mvp;

import com.example.user.simplemvpimplement.models.Repo;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by User on 11/26/2017.
 */

public class ListPresenter implements OnInteractorFinishedListener {

    private ListViewMVPInterface viewMVPInterface;
    private ListLoadDataInteractor interactor;
    public ListPresenter(ListViewMVPInterface view) {
       this.viewMVPInterface=view;
       interactor=new ListLoadDataInteractor(this);
    }

    @Override
    public void onNetworkSuccess(List<Repo> list, Response response) {
            viewMVPInterface.LoadedSuccess(list,response);
            viewMVPInterface.setProgressBar(false);
    }

    @Override
    public void onNetworkFailure(RetrofitError error) {
        viewMVPInterface.LoadedFailure(error);
        viewMVPInterface.setProgressBar(false);
    }

    @Override
    public void loadCommits(String username) {
     interactor.loadRecentCommits(username);
     viewMVPInterface.setProgressBar(true);
    }
}
