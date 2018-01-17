package com.aapbd.mediaplayeraudio.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RadioButton;
import com.aapbd.mediaplayeraudio.R;
import com.aapbd.mediaplayeraudio.player.Player;
import com.aapbd.mediaplayeraudio.ui.base.BaseActivity;
import com.aapbd.mediaplayeraudio.ui.base.BaseFragment;
import com.aapbd.mediaplayeraudio.ui.local.LocalFilesFragment;
import com.aapbd.mediaplayeraudio.ui.music.MusicPlayerFragment;
import com.aapbd.mediaplayeraudio.ui.playlist.PlayListFragment;
import com.aapbd.mediaplayeraudio.ui.settings.SettingsFragment;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Indexables;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class MainActivity extends BaseActivity {

    private static  int DEFAULT_PAGE_INDEX = 2; // it will open the song list screen

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindViews({R.id.radio_button_play_list, R.id.radio_button_music, R.id.radio_button_local_files, R.id.radio_button_settings})
    List<RadioButton> radioButtons;

    String[] mTitles;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    private FirebaseAnalytics mFirebaseAnalytics;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        MobileAds.initialize(getApplicationContext(), getString(R.string.admobappid));




        // Main Controls' Titles
        mTitles = getResources().getStringArray(R.array.mp_main_titles);

        // Fragments
        BaseFragment[] fragments = new BaseFragment[mTitles.length];
        fragments[0] = new PlayListFragment();
        fragments[1] = new MusicPlayerFragment();
        fragments[2] = new LocalFilesFragment();
        fragments[3] = new SettingsFragment();


        // Inflate ViewPager
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), mTitles, fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount() - 1);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.mp_margin_large));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Empty
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Empty
            }

            @Override
            public void onPageSelected(int position) {
                radioButtons.get(position).setChecked(true);

                LogEvent("User is browsing", position+"");
            }
        });

        /*
        open  screen based on media player status initially
         */

        try {
            if (Player.getInstance().isPlaying()) {
                DEFAULT_PAGE_INDEX = 1;
            } else {
                DEFAULT_PAGE_INDEX = 2;
            }
        }catch (Exception e)
        {

        }
        radioButtons.get(DEFAULT_PAGE_INDEX).setChecked(true);

        addIndexing();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @OnCheckedChanged({R.id.radio_button_play_list, R.id.radio_button_music, R.id.radio_button_local_files, R.id.radio_button_settings})
    public void onRadioButtonChecked(RadioButton button, boolean isChecked) {
        if (isChecked) {
            onItemChecked(radioButtons.indexOf(button));
        }
    }

    private void onItemChecked(int position) {
        viewPager.setCurrentItem(position);
        toolbar.setTitle(mTitles[position]);
    }


    private void LogEvent(String s1, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "visible page");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, s1+" "+s);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "text");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
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
