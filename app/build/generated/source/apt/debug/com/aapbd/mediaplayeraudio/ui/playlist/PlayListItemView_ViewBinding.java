// Generated code from Butter Knife. Do not modify!
package com.aapbd.mediaplayeraudio.ui.playlist;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aapbd.mediaplayeraudio.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayListItemView_ViewBinding implements Unbinder {
  private PlayListItemView target;

  @UiThread
  public PlayListItemView_ViewBinding(PlayListItemView target) {
    this(target, target);
  }

  @UiThread
  public PlayListItemView_ViewBinding(PlayListItemView target, View source) {
    this.target = target;

    target.imageViewAlbum = Utils.findRequiredViewAsType(source, R.id.image_view_album, "field 'imageViewAlbum'", ImageView.class);
    target.textViewName = Utils.findRequiredViewAsType(source, R.id.text_view_name, "field 'textViewName'", TextView.class);
    target.textViewInfo = Utils.findRequiredViewAsType(source, R.id.text_view_info, "field 'textViewInfo'", TextView.class);
    target.buttonAction = Utils.findRequiredView(source, R.id.layout_action, "field 'buttonAction'");
  }

  @Override
  @CallSuper
  public void unbind() {
    PlayListItemView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageViewAlbum = null;
    target.textViewName = null;
    target.textViewInfo = null;
    target.buttonAction = null;
  }
}
