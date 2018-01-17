package com.aapbd.mediaplayeraudio.ui.playlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aapbd.mediaplayeraudio.R;
import com.aapbd.mediaplayeraudio.RxBus;
import com.aapbd.mediaplayeraudio.data.model.PlayList;
import com.aapbd.mediaplayeraudio.data.source.AppRepository;
import com.aapbd.mediaplayeraudio.event.FavoriteChangeEvent;
import com.aapbd.mediaplayeraudio.event.PlayListCreatedEvent;
import com.aapbd.mediaplayeraudio.event.PlayListNowEvent;
import com.aapbd.mediaplayeraudio.event.PlayListUpdatedEvent;
import com.aapbd.mediaplayeraudio.ui.base.BaseFragment;
import com.aapbd.mediaplayeraudio.ui.base.adapter.OnItemClickListener;
import com.aapbd.mediaplayeraudio.ui.common.DefaultDividerDecoration;
import com.aapbd.mediaplayeraudio.ui.details.PlayListDetailsActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Indexables;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created with Android Studio.
 * User: ryan.hoo.j@gmail.com
 * Date: 9/1/16
 * Time: 9:58 PM
 * Desc: PlayListFragment
 */
public class PlayListFragment extends BaseFragment implements PlayListContract.View,
        EditPlayListDialogFragment.Callback, PlayListAdapter.AddPlayListCallback {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;




    private PlayListAdapter mAdapter;
    private int mEditIndex, mDeleteIndex;

    PlayListContract.Presenter mPresenter;
    private AdView mAdView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mAdView = (AdView)view. findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("4C1C57A5C2566E9BD0574201068A3E0E").build();
        mAdView.loadAd(adRequest);

        mAdapter = new PlayListAdapter(getActivity(), null);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                PlayList playList = mAdapter.getItem(position);

                Log.e("Song in init playlist", playList.getNumOfSongs()+" total");
                startActivity(PlayListDetailsActivity.launchIntentForPlayList(getActivity(), playList));
            }
        });
        mAdapter.setAddPlayListCallback(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DefaultDividerDecoration());

        new PlayListPresenter(AppRepository.getInstance(), this).subscribe();
        addIndexing();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unsubscribe();
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

    // RxBus Events

    @Override
    protected Subscription subscribeEvents() {
        return RxBus.getInstance().toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        if (o instanceof PlayListCreatedEvent) {
                            onPlayListCreatedEvent((PlayListCreatedEvent) o);
                        } else if (o instanceof FavoriteChangeEvent) {
                            onFavoriteChangeEvent((FavoriteChangeEvent) o);
                        } else if (o instanceof PlayListUpdatedEvent) {
                            onPlayListUpdatedEvent((PlayListUpdatedEvent) o);
                        }
                    }
                })
                .subscribe(RxBus.defaultSubscriber());
    }

    private void onPlayListCreatedEvent(PlayListCreatedEvent event) {
        mAdapter.getData().add(event.playList);
        mAdapter.notifyDataSetChanged();
        mAdapter.updateFooterView();
    }

    private void onFavoriteChangeEvent(FavoriteChangeEvent event) {
        // Update entire play lists
        mPresenter.loadPlayLists();
       /*
        Song song = event.song;
        List<PlayList> playLists = mAdapter.getData();
        if (playLists != null && playLists.size() > 1) {
            PlayList favorite = playLists.get(0);
            if (!favorite.isFavorite()) {
                // Find the favorite play list
                for (PlayList list : playLists) {
                    if (list.isFavorite()) {
                        favorite = list;
                        break;
                    }
                }
            }
            int index;
            if ((index = favorite.getSongs().indexOf(song)) != -1) {
                favorite.getSongs().remove(index);
            }
            favorite.addSong(song);
            mAdapter.notifyDataSetChanged();
        }
        */
    }

    public void onPlayListUpdatedEvent(PlayListUpdatedEvent event) {
        mPresenter.loadPlayLists();
    }

    // Adapter Callbacks

    @Override
    public void onAction(View actionView, final int position) {
        final PlayList playList = mAdapter.getItem(position);
        PopupMenu actionMenu = new PopupMenu(getActivity(), actionView, Gravity.END | Gravity.BOTTOM);
        actionMenu.inflate(R.menu.play_list_action);
        if (playList.isFavorite()) {
            actionMenu.getMenu().findItem(R.id.menu_item_rename).setVisible(false);
            actionMenu.getMenu().findItem(R.id.menu_item_delete).setVisible(false);
        }
        actionMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_item_play_now) {
                    PlayListNowEvent playListNowEvent = new PlayListNowEvent(playList, 0);
                    RxBus.getInstance().post(playListNowEvent);
                } else if (item.getItemId() == R.id.menu_item_rename) {
                    mEditIndex = position;
                    EditPlayListDialogFragment.editPlayList(playList)
                            .setCallback(PlayListFragment.this)
                            .show(getFragmentManager().beginTransaction(), "EditPlayList");
                } else if (item.getItemId() == R.id.menu_item_delete) {
                    mDeleteIndex = position;
                    mPresenter.deletePlayList(playList);
                }
                return true;
            }
        });
        actionMenu.show();
    }

    @Override
    public void onAddPlayList() {
        EditPlayListDialogFragment.createPlayList()
                .setCallback(PlayListFragment.this)
                .show(getFragmentManager().beginTransaction(), "CreatePlayList");
    }

    // Create or Edit Play List Callbacks

    @Override
    public void onCreated(final PlayList playList) {
        mPresenter.createPlayList(playList);
    }

    @Override
    public void onEdited(final PlayList playList) {
        mPresenter.editPlayList(playList);
    }

    // MVP View

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void handleError(Throwable error) {
        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPlayListsLoaded(List<PlayList> playLists) {
        mAdapter.setData(playLists);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPlayListCreated(PlayList playList) {
        mAdapter.getData().add(playList);
        mAdapter.notifyItemInserted(mAdapter.getData().size() - 1);
        mAdapter.updateFooterView();
    }

    @Override
    public void onPlayListEdited(PlayList playList) {
        mAdapter.getData().set(mEditIndex, playList);
        mAdapter.notifyItemChanged(mEditIndex);
        mAdapter.updateFooterView();
    }

    @Override
    public void onPlayListDeleted(PlayList playList) {
        mAdapter.getData().remove(mDeleteIndex);
        mAdapter.notifyItemRemoved(mDeleteIndex);
        mAdapter.updateFooterView();
    }

    @Override
    public void setPresenter(PlayListContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
