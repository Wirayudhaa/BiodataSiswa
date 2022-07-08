// Generated code from Butter Knife. Do not modify!
package com.Kelompok1.biodatasiswa.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.Kelompok1.biodatasiswa.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SiswaAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SiswaAdapter.ViewHolder target;

  @UiThread
  public SiswaAdapter$ViewHolder_ViewBinding(SiswaAdapter.ViewHolder target, View source) {
    this.target = target;

    target.imgView = Utils.findRequiredViewAsType(source, R.id.img_view, "field 'imgView'", ImageView.class);
    target.txtNameSiswa = Utils.findRequiredViewAsType(source, R.id.txt_name_siswa, "field 'txtNameSiswa'", TextView.class);
    target.btnDelete = Utils.findRequiredViewAsType(source, R.id.btnDelete, "field 'btnDelete'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SiswaAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgView = null;
    target.txtNameSiswa = null;
    target.btnDelete = null;
  }
}
