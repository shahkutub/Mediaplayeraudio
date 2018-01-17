// Generated code from Butter Knife. Do not modify!
package com.aapbd.mediaplayeraudio.ui.local.all;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aapbd.mediaplayeraudio.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LocalMusicItemView_ViewBinding implements Unbinder {
  private LocalMusicItemView target;

  @UiThread
  public LocalMusicItemView_ViewBinding(LocalMusicItemView target) {
    this(target, target);
  }

  @UiThread
  public LocalMusicItemView_ViewBinding(LocalMusicItemView target, View source) {
    this.target = target;

    target.textViewName = Utils.findRequiredViewAsType(source, R.id.text_view_name, "field 'textViewName'", TextView.class);
    target.textViewArtist = Utils.findRequiredViewAsType(source, R.id.text_view_artist, "field 'textViewArtist'", TextView.class);
    target.textViewDuration = Utils.findRequiredViewAsType(source, R.id.text_view_duration, "field 'textViewDuration'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LocalMusicItemView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewName = null;
    target.textViewArtist = null;
    target.textViewDuration = null;
  }
}
