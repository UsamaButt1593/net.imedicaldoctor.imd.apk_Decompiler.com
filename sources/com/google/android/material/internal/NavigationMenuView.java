package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuView extends RecyclerView implements MenuView {
    public NavigationMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void e(MenuBuilder menuBuilder) {
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
