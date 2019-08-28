package com.example.mebel_system_consultant.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mebel_system_consultant.DetailsOfClients;
import com.example.mebel_system_consultant.R;
import com.example.mebel_system_consultant.api_serializer.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private List<UserInfo> userInfos;
    private List<UserInfo> userInfosFiltered;
    private Context context;

    public Myadapter(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
        userInfosFiltered = new ArrayList<>(userInfos);

    }


    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final UserInfo userInfo = userInfos.get(i);
        viewHolder.textViewHead.setText(userInfo.getName());
        viewHolder.textViewDesc.setText(userInfo.getPhone_number());
        viewHolder.textViewFilial.setText((CharSequence) userInfo.getVisitors()[0].getFilial());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsOfClients.class);
                String[] details = {userInfo.getVisitors()[0].getDate(), String.valueOf(userInfo.getVisitors()[0].getFilial()), userInfo.getVisitors()[0].getFind_out(), userInfo.getVisitors()[0].getFind_out(), userInfo.getVisitors()[0].getFind_out(),
                        userInfo.getCharacter(), userInfo.getStatus(),userInfo.getVisitors()[0].getOther_shop(),userInfo.getVisitors()[0].getCategory()[0].name,userInfo.getVisitors()[0].getName_furniture()[0].name,
                       userInfo.getVisitors()[0].getColor(),userInfo.getVisitors()[0].getConsultant().getName()};
                intent.putExtra("details", details);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return userInfos.size();
    }

    public void updateInfo(List<UserInfo> newUserInfo) {
        userInfos = new ArrayList<>();
        userInfos.add((UserInfo) newUserInfo);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView textViewFilial;
        public LinearLayout linearLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewHead = itemView.findViewById(R.id.TextViewHead);
            textViewDesc = itemView.findViewById(R.id.TextViewDescription);
            textViewFilial = itemView.findViewById(R.id.TextViewFilial);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }

    }
}
