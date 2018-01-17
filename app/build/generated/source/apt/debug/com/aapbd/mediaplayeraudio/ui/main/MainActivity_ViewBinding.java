// Generated code from Butter Knife. Do not modify!
package com.aapbd.mediaplayeraudio.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aapbd.mediaplayeraudio.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131230870;

  private View view2131230869;

  private View view2131230868;

  private View view2131230871;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.radio_button_play_list, "method 'onRadioButtonChecked'");
    view2131230870 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onRadioButtonChecked(Utils.<RadioButton>castParam(p0, "onCheckedChanged", 0, "onRadioButtonChecked", 0), p1);
      }
    });
    view = Utils.findRequiredView(source, R.id.radio_button_music, "method 'onRadioButtonChecked'");
    view2131230869 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onRadioButtonChecked(Utils.<RadioButton>castParam(p0, "onCheckedChanged", 0, "onRadioButtonChecked", 0), p1);
      }
    });
    view = Utils.findRequiredView(source, R.id.radio_button_local_files, "method 'onRadioButtonChecked'");
    view2131230868 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onRadioButtonChecked(Utils.<RadioButton>castParam(p0, "onCheckedChanged", 0, "onRadioButtonChecked", 0), p1);
      }
    });
    view = Utils.findRequiredView(source, R.id.radio_button_settings, "method 'onRadioButtonChecked'");
    view2131230871 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onRadioButtonChecked(Utils.<RadioButton>castParam(p0, "onCheckedChanged", 0, "onRadioButtonChecked", 0), p1);
      }
    });
    target.radioButtons = Utils.listOf(
        Utils.findRequiredViewAsType(source, R.id.radio_button_play_list, "field 'radioButtons'", RadioButton.class), 
        Utils.findRequiredViewAsType(source, R.id.radio_button_music, "field 'radioButtons'", RadioButton.class), 
        Utils.findRequiredViewAsType(source, R.id.radio_button_local_files, "field 'radioButtons'", RadioButton.class), 
        Utils.findRequiredViewAsType(source, R.id.radio_button_settings, "field 'radioButtons'", RadioButton.class));
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.viewPager = null;
    target.radioButtons = null;

    ((CompoundButton) view2131230870).setOnCheckedChangeListener(null);
    view2131230870 = null;
    ((CompoundButton) view2131230869).setOnCheckedChangeListener(null);
    view2131230869 = null;
    ((CompoundButton) view2131230868).setOnCheckedChangeListener(null);
    view2131230868 = null;
    ((CompoundButton) view2131230871).setOnCheckedChangeListener(null);
    view2131230871 = null;
  }
}
