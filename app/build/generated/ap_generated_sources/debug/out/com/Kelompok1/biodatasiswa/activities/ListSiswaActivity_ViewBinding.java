// Generated code from Butter Knife. Do not modify!
package com.Kelompok1.biodatasiswa.activities;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.Kelompok1.biodatasiswa.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListSiswaActivity_ViewBinding implements Unbinder {
  private ListSiswaActivity target;

  private View view7f080080;

  @UiThread
  public ListSiswaActivity_ViewBinding(ListSiswaActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListSiswaActivity_ViewBinding(final ListSiswaActivity target, View source) {
    this.target = target;

    View view;
    target.rvSiswa = Utils.findRequiredViewAsType(source, R.id.rvSiswa, "field 'rvSiswa'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.fab, "field 'fab' and method 'onViewClicked'");
    target.fab = Utils.castView(view, R.id.fab, "field 'fab'", FloatingActionButton.class);
    view7f080080 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ListSiswaActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvSiswa = null;
    target.fab = null;

    view7f080080.setOnClickListener(null);
    view7f080080 = null;
  }
}
