package com.example.vihaan.githubapi.ui.homescreen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

//        if(!TextUtils.isEmpty(user.getProfilePicUrl()))
//        {
//            Picasso.with(holder.userIV.getContext()).load(user.getProfilePicUrl()).into(holder.userIV);
//        }
//        holder.nameTV.setText(user.getName());
//        holder.messageTV.setText(message.getLastMessage());
//        holder.lastMessageTimeTV.setText(message.getLastMessageTime());
//
//        if(TextUtils.isEmpty(message.getUnreadMessageCount()))
//        {
//            holder.unreadMessageCountTV.setVisibility(View.GONE);
//        }
//        else
//        {
//            holder.unreadMessageCountTV.setVisibility(View.VISIBLE);
//            holder.unreadMessageCountTV.setText(Issue.getMessage().getUnreadMessageCount());
//        }
    }

    @Override
    public int getItemCount() {
        return mIssues.size();
    }

    public class IssueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//        RelativeLayout IssueRL;
//        CircleImageView userIV;
        TextView titleTV;
//        TextView messageTV;
//        TextView lastMessageTimeTV;
//        TextView unreadMessageCountTV;

        public IssueViewHolder(View v){
            super(v);
//            IssueRL = (RelativeLayout) v.findViewById(R.id.IssueRL);
//            userIV = (CircleImageView) v.findViewById(R.id.userIV);
            titleTV = (TextView) v.findViewById(R.id.titleTV);
//            messageTV = (TextView) v.findViewById(R.id.messageTV);
//            lastMessageTimeTV = (TextView) v.findViewById(R.id.lastMessageTimeTV);
//            unreadMessageCountTV= (TextView) v.findViewById(R.id.unreadMessageCountTV);
//            IssueRL.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

//            int position = getAdapterPosition();
//            if(position != RecyclerView.NO_POSITION){
//                Issue Issue = mIssues.get(position);
//                Intent intent = new Intent(mContext, IssueActivity.class);
//                intent.putExtra(IssueActivity.EXTRAS_Issue,Issue);
//                mContext.startActivity(intent);
//            }
        }
    }
}
