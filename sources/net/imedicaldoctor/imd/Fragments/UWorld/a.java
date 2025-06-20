package net.imedicaldoctor.imd.Fragments.UWorld;

import android.view.View;
import androidx.appcompat.widget.SearchView;

public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ SearchView s;

    public /* synthetic */ a(SearchView searchView) {
        this.s = searchView;
    }

    public final void onClick(View view) {
        this.s.setIconified(false);
    }
}
