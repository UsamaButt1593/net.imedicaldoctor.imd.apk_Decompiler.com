package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {
    private static final int[] Y2 = {16842964, 16843049};
    private int X2;
    private MenuBuilder s;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public boolean a(MenuItemImpl menuItemImpl) {
        return this.s.P(menuItemImpl, 0);
    }

    public void e(MenuBuilder menuBuilder) {
        this.s = menuBuilder;
    }

    public int getWindowAnimations() {
        return this.X2;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        a((MenuItemImpl) getAdapter().getItem(i2));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray G = TintTypedArray.G(context, attributeSet, Y2, i2, 0);
        if (G.C(0)) {
            setBackgroundDrawable(G.h(0));
        }
        if (G.C(1)) {
            setDivider(G.h(1));
        }
        G.I();
    }
}
