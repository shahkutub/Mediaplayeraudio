// Generated code from Butter Knife. Do not modify!
package com.aapbd.mediaplayeraudio.ui.music;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aapbd.mediaplayeraudio.R;
import com.aapbd.mediaplayeraudio.ui.widget.ShadowImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MusicPlayerFragment_ViewBinding implements Unbinder {
  private MusicPlayerFragment target;

  private View view2131230751;

  private View view2131230753;

  private View view2131230749;

  private View view2131230750;

  private View view2131230752;

  @UiThread
  public MusicPlayerFragment_ViewBinding(final MusicPlayerFragment target, View source) {
    this.target = target;

    View view;
    target.imageViewAlbum = Utils.findRequiredViewAsType(source, R.id.image_view_album, "field 'imageViewAlbum'", ShadowImageView.class);
    target.textViewName = Utils.findRequiredViewAsType(source, R.id.text_view_name, "field 'textViewName'", TextView.class);
    target.textViewArtist = Utils.findRequiredViewAsType(source, R.id.text_view_artist, "field 'textViewArtist'", TextView.class);
    target.textViewProgress = Utils.findRequiredViewAsType(source, R.id.text_view_progress, "field 'textViewProgress'", TextView.class);
    target.textViewDuration = Utils.findRequiredViewAsType(source, R.id.text_view_duration, "field 'textViewDuration'", TextView.class);
    target.seekBarProgress = Utils.findRequiredViewAsType(source, R.id.seek_bar, "field 'seekBarProgress'", SeekBar.class);
    view = Utils.findRequiredView(source, R.id.button_play_mode_toggle, "field 'buttonPlayModeToggle' and method 'onPlayModeToggleAction'");
    target.buttonPlayModeToggle = Utils.castView(view, R.id.button_play_mode_toggle, "field 'buttonPlayModeToggle'", ImageView.class);
    view2131230751 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPlayModeToggleAction(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.button_play_toggle, "field 'buttonPlayToggle' and method 'onPlayToggleAction'");
    target.buttonPlayToggle = Utils.castView(view, R.id.button_play_toggle, "field 'buttonPlayToggle'", ImageView.class);
    view2131230753 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPlayToggleAction(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.button_favorite_toggle, "field 'buttonFavoriteToggle' and method 'onFavoriteToggleAction'");
    target.buttonFavoriteToggle = Utils.castView(view, R.id.button_favorite_toggle, "field 'buttonFavoriteToggle'", ImageView.class);
    view2131230749 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onFavoriteToggleAction(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.button_play_last, "method 'onPlayLastAction'");
    view2131230750 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPlayLastAction(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.button_play_next, "method 'onPlayNextAction'");
    view2131230752 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onPlayNextAction(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MusicPlayerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageViewAlbum = null;
    target.textViewName = null;
    target.textViewArtist = null;
    target.textViewProgress = null;
    target.textViewDuration = null;
    target.seekBarProgress = null;
    target.buttonPlayModeToggle = null;
    target.buttonPlayToggle = null;
    target.buttonFavoriteToggle = null;

    view2131230751.setOnClickListener(null);
    view2131230751 = null;
    view2131230753.setOnClickListener(null);
    view2131230753 = null;
    view2131230749.setOnClickListener(null);
    view2131230749 = null;
    view2131230750.setOnClickListener(null);
    view2131230750 = null;
    view2131230752.setOnClickListener(null);
    view2131230752 = null;
  }
}
