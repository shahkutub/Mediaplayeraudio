// Generated code from Butter Knife. Do not modify!
package com.aapbd.mediaplayeraudio.ui.local.all;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aapbd.mediaplayeraudio.R;
import com.aapbd.mediaplayeraudio.ui.widget.RecyclerViewFastScroller;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AllLocalMusicFragment_ViewBinding implements Unbinder {
  private AllLocalMusicFragment target;

  @UiThread
  public AllLocalMusicFragment_ViewBinding(AllLocalMusicFragment target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    target.fastScroller = Utils.findRequiredViewAsType(source, R.id.fast_scroller, "field 'fastScroller'", RecyclerViewFastScroller.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    target.emptyView = Utils.findRequiredView(source, R.id.text_view_empty, "field 'emptyView'");
  }

  @Override
  @CallSuper
  public void unbind() {
    AllLocalMusicFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.fastScroller = null;
    target.progressBar = null;
    target.emptyView = null;
  }
}
