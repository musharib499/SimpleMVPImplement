package com.example.user.simplemvpimplement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.simplemvpimplement.adapter.ListAdapter;
import com.example.user.simplemvpimplement.models.Repo;
import com.example.user.simplemvpimplement.mvp.ListPresenter;
import com.example.user.simplemvpimplement.mvp.ListViewMVPInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements ListViewMVPInterface {
    @BindView(R.id.repo_list_view)
     ListView listView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
     private ListPresenter presenter;
     private ListAdapter listAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter=new ListPresenter(this);
        listAdapter=new ListAdapter(this,null);
        listView.setAdapter(listAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadCommits("JakeWharton");
    }

    @Override
    public void LoadedSuccess(List<Repo> list, Response response) {
        listAdapter.clear();
        listAdapter.addAll(list);
    }

    @Override
    public void LoadedFailure(RetrofitError error) {

        Toast.makeText(this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setProgressBar(boolean show) {
     if (show) progressBar.setVisibility(View.VISIBLE);
             else progressBar.setVisibility(View.GONE);
    }
}
