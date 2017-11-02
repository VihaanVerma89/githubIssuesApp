package com.example.vihaan.githubapi.ui.homescreen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vihaan.githubapi.R;
import com.example.vihaan.githubapi.models.Issue;

import java.util.List;

/**
 * Created by vihaan on 13/06/17.
 */

public class IssuesAdapter extends RecyclerView.Adapter<IssuesAdapter.IssueViewHolder> {


    private List<Issue> mIssues;
    private Context mContext;

    public IssuesAdapter(Context context, List<Issue> Issues) {
        mContext = context;
        mIssues = Issues;
    }

    @Override
    public IssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_issue, parent, false);
        return new IssueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IssueViewHolder holder, int position) {

        Issue issue = mIssues.get(position);
        holder.titleTV.setText(issue.getTitle());
        holder.numberTV.setText("#"+issue.getNumber() +" "+ issue.getState() +"ed" + " by " + issue.getUser().getLogin());

        if(issue.getComments() > 0)
        {
            holder.commentIV.setVisibility(View.VISIBLE);
            holder.commentCountTV.setVisibility(View.VISIBLE);
            holder.commentCountTV.setText(issue.getComments()+"");
        }
    }

    @Override
    public int getItemCount() {
        return mIssues.size();
    }

    public class IssueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTV;
        TextView numberTV;
        ImageView commentIV;
        TextView commentCountTV;


        public IssueViewHolder(View v){
            super(v);
            titleTV = (TextView) v.findViewById(R.id.titleTV);
            numberTV= (TextView) v.findViewById(R.id.numberTV);
            commentCountTV= (TextView) v.findViewById(R.id.commentCountTV);
            commentIV = (ImageView) v.findViewById(R.id.commentIV);
        }

        @Override
        public void onClick(View v) {
        }
    }
}
