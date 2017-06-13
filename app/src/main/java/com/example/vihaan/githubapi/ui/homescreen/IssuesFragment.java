package com.example.vihaan.githubapi.ui.homescreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vihaan.githubapi.R;
import com.example.vihaan.githubapi.models.Issue;
import com.example.vihaan.githubapi.network.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vihaan on 13/06/17.
 */

public class IssuesFragment extends Fragment {


    public static IssuesFragment newInstance() {

        Bundle args = new Bundle();

        IssuesFragment fragment = new IssuesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCompositeDisposable = new CompositeDisposable();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_issues, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        loadJSON();
    }

    private CompositeDisposable mCompositeDisposable;
    private void loadJSON() {

        ApiService requestInterface = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService.class);

        mCompositeDisposable.add(requestInterface.getIssues()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }

    IssuesAdapter mIssuesAdapter;
    private void handleResponse(List<Issue> issues){

//        mAndroidArrayList = new ArrayList<>(Issue);
//        mAdapter = new DataAdapter(mAndroidArrayList);
//        mRecyclerView.setAdapter(mAdapter);

        mIssuesAdapter = new IssuesAdapter(getActivity(), issues);
        mRecyclerView.setAdapter(mIssuesAdapter);
    }

    private void handleError(Throwable error) {

        Toast.makeText(getActivity(), "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    private void initViews()
    {
        initRecyclerView();
    }


    private RecyclerView mRecyclerView;

    private void initRecyclerView() {

        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
    }

}
