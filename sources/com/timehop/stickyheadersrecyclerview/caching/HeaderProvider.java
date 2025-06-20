package com.timehop.stickyheadersrecyclerview.caching;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public interface HeaderProvider {
    View a(RecyclerView recyclerView, int i2);

    void c();
}
