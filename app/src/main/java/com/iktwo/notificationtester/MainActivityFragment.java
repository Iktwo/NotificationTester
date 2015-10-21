package com.iktwo.notificationtester;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityFragment extends Fragment {
    public static final int TEXT_NOTIFICATION_ID = 8;

    @Bind(R.id.edit_text_title)
    EditText editTextTitle;

    @Bind(R.id.edit_text_message)
    EditText editTextMessage;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button_text_notification)
    public void submit(View view) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getActivity())
                        .setSmallIcon(R.drawable.ic_message_white_24dp)
                        .setContentTitle(editTextTitle.getText())
                        .setContentText(editTextMessage.getText());

        NotificationManager mNotificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(TEXT_NOTIFICATION_ID, mBuilder.build());
    }
}
