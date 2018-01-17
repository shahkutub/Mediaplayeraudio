package com.aapbd.mediaplayeraudio.ui.music;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.aapbd.mediaplayeraudio.data.model.Song;
import com.aapbd.mediaplayeraudio.player.PlayMode;
import com.aapbd.mediaplayeraudio.player.PlaybackService;
import com.aapbd.mediaplayeraudio.ui.base.BasePresenter;
import com.aapbd.mediaplayeraudio.ui.base.BaseView;

/**
 * Created with Android Studio.
 * User: ryan.hoo.j@gmail.com
 * Date: 9/12/16
 * Time: 8:27 AM
 * Desc: MusicPlayerContract
 */
/* package */ interface MusicPlayerContract {

    interface View extends BaseView<Presenter> {

        void handleError(Throwable error);

        void onPlaybackServiceBound(PlaybackService service);

        void onPlaybackServiceUnbound();

        void onSongSetAsFavorite(@NonNull Song song);

        void onSongUpdated(@Nullable Song song);

        void updatePlayMode(PlayMode playMode);

        void updatePlayToggle(boolean play);

        void updateFavoriteToggle(boolean favorite);
    }

    interface Presenter extends BasePresenter {

        void retrieveLastPlayMode();

        void setSongAsFavorite(Song song, boolean favorite);

        void bindPlaybackService();

        void unbindPlaybackService();
    }
}
