package com.aapbd.mediaplayeraudio.ui.local;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import com.aapbd.mediaplayeraudio.R;
import com.aapbd.mediaplayeraudio.ui.base.BaseFragment;
import com.aapbd.mediaplayeraudio.ui.local.all.AllLocalMusicFragment;
import com.aapbd.mediaplayeraudio.ui.local.folder.FolderFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Indexables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio.
 * User: ryan.hoo.j@gmail.com
 * Date: 9/1/16
 * Time: 9:58 PM
 * Desc: LocalFilesFragment
 */
public class LocalFilesFragment extends BaseFragment {

    // private static final String TAG = "LocalFilesFragment";

    static final int DEFAULT_SEGMENT_INDEX = 0;

    @BindViews({R.id.radio_button_all, R.id.radio_button_folder})
    List<RadioButton> segmentedControls;

    List<Fragment> mFragments = new ArrayList<>(2);
    private AdView mAdView;

    final int[] FRAGMENT_CONTAINER_IDS = {
            R.id.layout_fragment_container_all, R.id.layout_fragment_container_folder
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments.add(new AllLocalMusicFragment());
        mFragments.add(new FolderFragment());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_local_files, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mAdView = (AdView)view. findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("4C1C57A5C2566E9BD0574201068A3E0E").build();
        mAdView.loadAd(adRequest);


        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            Fragment fragment = mFragments.get(i);
            fragmentTransaction.add(FRAGMENT_CONTAINER_IDS[i], fragment, fragment.getTag());
            fragmentTransaction.hide(fragment);
        }
        fragmentTransaction.commit();

        segmentedControls.get(DEFAULT_SEGMENT_INDEX).setChecked(true);
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

    @OnCheckedChanged({R.id.radio_button_all, R.id.radio_button_folder})
    public void onSegmentedChecked(RadioButton radioButton, boolean isChecked) {
        int index = segmentedControls.indexOf(radioButton);
        Fragment fragment = mFragments.get(index);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (isChecked) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.hide(fragment);
        }
        fragmentTransaction.commit();
    }
}
