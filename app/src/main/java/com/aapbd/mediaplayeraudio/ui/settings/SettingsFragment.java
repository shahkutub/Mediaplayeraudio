package com.aapbd.mediaplayeraudio.ui.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aapbd.mediaplayeraudio.R;
import com.aapbd.mediaplayeraudio.ui.base.BaseFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Indexables;

/**
 * Created with Android Studio.
 * User: ryan.hoo.j@gmail.com
 * Date: 9/1/16
 * Time: 9:59 PM
 * Desc: SettingsFragment
 */
public class SettingsFragment extends BaseFragment {

    private AdView mAdView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdView = (AdView)view. findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("4C1C57A5C2566E9BD0574201068A3E0E").build();
        mAdView.loadAd(adRequest);

        addIndexing();

    }

    private void addIndexing() {

        Indexable noteToIndex = Indexables.noteDigitalDocumentBuilder()
                .setName(getString(R.string.mp_app_name))
                .setText(getString(R.string.mp_fragment_title_music))
                .setUrl("https://play.google.com/store/apps/details?id=com.aapbd.mediaplayeraudio")
                .build();



        Task<Void> task = FirebaseAppIndex.getInstance().update(noteToIndex);
        task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.e("sldfks", "App Indexing API: Successfully added note to index");
            }
        });

        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.e("sdfsd", "App Indexing API: Failed to add note to index. " + exception
                        .getMessage());
            }
        });
    }
}
