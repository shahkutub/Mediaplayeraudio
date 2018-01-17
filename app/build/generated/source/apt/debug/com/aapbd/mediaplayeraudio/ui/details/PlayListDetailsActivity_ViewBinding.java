// Generated code from Butter Knife. Do not modify!
package com.aapbd.mediaplayeraudio.ui.details;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aapbd.mediaplayeraudio.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlayListDetailsActivity_ViewBinding implements Unbinder {
  private PlayListDetailsActivity target;

  @UiThread
  public PlayListDetailsActivity_ViewBinding(PlayListDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PlayListDetailsActivity_ViewBinding(PlayListDetailsActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    target.emptyView = Utils.findRequiredView(source, R.id.text_view_empty, "field 'emptyView'");
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PlayListDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.recyclerView = null;
    target.emptyView = null;
    target.progressBar = null;
  }
}
