package com.example.t32_emails_list;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MailAdapter extends RecyclerView.Adapter<MailViewHolder>{

    private List<EmailData> mEmailData;
    private Context mContext;

    public MailAdapter(Context mContext, List<EmailData> mEmailData) {
        this.mEmailData = mEmailData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //    25- Now you need to work on (onCreateViewHolder), here you need to inflate the recyclerview_mail_item.xml layout.


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_mail_item,
                viewGroup, false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MailViewHolder viewHolder, int position) {

        // 26- Finally you can initialize the views from recyclerview_mail_item.xml inside
        // (onBindViewHolder), you can set those views value individually by accessing
        // them through (mEmailData) list.

        viewHolder.mSender.setText(mEmailData.get(position).getmSender());
        viewHolder.mEmailTitle.setText(mEmailData.get(position).getmTitle());
        viewHolder.mEmailDetails.setText(mEmailData.get(position).getmDetails());
        viewHolder.mEmailTime.setText(mEmailData.get(position).getmTime());

        //change the icon leter to the first leter of the sender name
        viewHolder.mIcon.setText(mEmailData.get(position).getmSender().substring(0, 1));

        // random color for the icon on the email row
        Random mRandom = new Random();
        final int color = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        ((GradientDrawable) viewHolder.mIcon.getBackground()).setColor(color);

        viewHolder.mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewHolder.mFavorite.getColorFilter() != null) {
                    viewHolder.mFavorite.clearColorFilter();
                } else {
                    viewHolder.mFavorite.setColorFilter(ContextCompat.getColor(mContext,
                            R.color.colorOrange));
                }
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return mEmailData.size();
    }
}


class MailViewHolder extends RecyclerView.ViewHolder {

    //23- First you need to work on (MailViewHolder) class, here all you need to do is
    // reference the views from recyclerview_mail_item.xml

    TextView mIcon;
    TextView mSender;
    TextView mEmailTitle;
    TextView mEmailDetails;
    TextView mEmailTime;
    ImageView mFavorite;

    public MailViewHolder(@NonNull View itemView) {
        super(itemView);

        mIcon = itemView.findViewById(R.id.tvIcon);
        mSender = itemView.findViewById(R.id.tvEmailSender);
        mEmailTitle = itemView.findViewById(R.id.tvEmailTitle);
        mEmailDetails = itemView.findViewById(R.id.tvEmailDetails);
        mEmailTime = itemView.findViewById(R.id.tvEmailTime);
        mFavorite = itemView.findViewById(R.id.ivFavorite);
    }


}