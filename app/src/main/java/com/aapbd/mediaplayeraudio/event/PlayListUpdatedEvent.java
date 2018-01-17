package com.aapbd.mediaplayeraudio.event;

import com.aapbd.mediaplayeraudio.data.model.PlayList;

/**
 * Created with Android Studio.
 * User: ryan.hoo.j@gmail.com
 * Date: 9/14/16
 * Time: 1:08 AM
 * Desc: PlayListUpdatedEvent
 */
public class PlayListUpdatedEvent {

    PlayList playList;

    public PlayListUpdatedEvent(PlayList playList) {
        this.playList = playList;
    }
}