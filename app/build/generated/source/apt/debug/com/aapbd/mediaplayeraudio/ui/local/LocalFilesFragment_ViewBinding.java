// Generated code from Butter Knife. Do not modify!
package com.aapbd.mediaplayeraudio.ui.local;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aapbd.mediaplayeraudio.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LocalFilesFragment_ViewBinding implements Unbinder {
  private LocalFilesFragment target;

  private View view2131230866;

  private View view2131230867;

  @UiThread
  public LocalFilesFragment_ViewBinding(final LocalFilesFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.radio_button_all, "method 'onSegmentedChecked'");
    view2131230866 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onSegmentedChecked(Utils.<RadioButton>castParam(p0, "onCheckedChanged", 0, "onSegmentedChecked", 0), p1);
      }
    });
    view = Utils.findRequiredView(source, R.id.radio_button_folder, "method 'onSegmentedChecked'");
    view2131230867 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onSegmentedChecked(Utils.<RadioButton>castParam(p0, "onCheckedChanged", 0, "onSegmentedChecked", 0), p1);
      }
    });
    target.segmentedControls = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.radio_button_all, "field 'segmentedControls'", RadioButton.class), 
        Utils.findRequiredViewAsType(source, R.id.radio_button_folder, "field 'segmentedControls'", RadioButton.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    LocalFilesFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.segmentedControls = null;

    ((CompoundButton) view2131230866).setOnCheckedChangeListener(null);
    view2131230866 = null;
    ((CompoundButton) view2131230867).setOnCheckedChangeListener(null);
    view2131230867 = null;
  }
}
