// Generated code from Butter Knife. Do not modify!
package com.aapbd.mediaplayeraudio.ui.local.filesystem;

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

public class FileItemView_ViewBinding implements Unbinder {
  private FileItemView target;

  @UiThread
  public FileItemView_ViewBinding(FileItemView target) {
    this(target, target);
  }

  @UiThread
  public FileItemView_ViewBinding(FileItemView target, View source) {
    this.target = target;

    target.imageViewFile = Utils.findRequiredViewAsType(source, R.id.image_view_file, "field 'imageViewFile'", ImageView.class);
    target.textViewName = Utils.findRequiredViewAsType(source, R.id.text_view_name, "field 'textViewName'", TextView.class);
    target.textViewInfo = Utils.findRequiredViewAsType(source, R.id.text_view_info, "field 'textViewInfo'", TextView.class);
    target.textViewDate = Utils.findRequiredViewAsType(source, R.id.text_view_date, "field 'textViewDate'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FileItemView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageViewFile = null;
    target.textViewName = null;
    target.textViewInfo = null;
    target.textViewDate = null;
  }
}
