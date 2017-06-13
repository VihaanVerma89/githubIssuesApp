package com.example.vihaan.githubapi.network;

import com.example.vihaan.githubapi.models.Issue;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vihaan on 13/06/17.
 */

public interface ApiService {

//    @GET("repos/ReactiveX/RxJava/issues?page=1&per_page=10")
//    Observable<List<Issue>> getIssues();

    @GET("repos/{owner}/{repo}/issues?page=1&per_page=10")
    Observable<List<Issue>> getIssues(@Path("owner") String repository, @Path("repo") String repo);
}
