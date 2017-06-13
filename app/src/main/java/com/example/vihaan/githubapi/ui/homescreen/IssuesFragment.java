package com.example.vihaan.githubapi.ui.homescreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vihaan.githubapi.R;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_issues, container, false);
        return view;
    }
}
