package com.aapbd.mediaplayeraudio.event;

import com.aapbd.mediaplayeraudio.data.model.PlayList;

/**
 * Created with Android Studio.
 * User: ryan.hoo.j@gmail.com
 * Date: 9/10/16
 * Time: 10:36 PM
 * Desc: PlayListCreatedEvent
 */
public class PlayListCreatedEvent {

    public PlayList playList;

    public PlayListCreatedEvent(PlayList playList) {
        this.playList = playList;
    }
}
