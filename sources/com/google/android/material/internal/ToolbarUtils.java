package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ToolbarUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<View> f21578a = new Comparator<View>() {
        /* renamed from: a */
        public int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    };

    private ToolbarUtils() {
    }

    @Nullable
    public static ActionMenuItemView a(@NonNull Toolbar toolbar, @IdRes int i2) {
        ActionMenuView b2 = b(toolbar);
        if (b2 == null) {
            return null;
        }
        for (int i3 = 0; i3 < b2.getChildCount(); i3++) {
            View childAt = b2.getChildAt(i3);
            if (childAt instanceof ActionMenuItemView) {
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                if (actionMenuItemView.getItemData().getItemId() == i2) {
                    return actionMenuItemView;
                }
            }
        }
        return null;
    }

    @Nullable
    public static ActionMenuView b(@NonNull Toolbar toolbar) {
        for (int i2 = 0; i2 < toolbar.getChildCount(); i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        r2 = (android.widget.ImageView) r2;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.widget.ImageView c(@androidx.annotation.NonNull androidx.appcompat.widget.Toolbar r5, @androidx.annotation.Nullable android.graphics.drawable.Drawable r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
        L_0x0005:
            int r2 = r5.getChildCount()
            if (r1 >= r2) goto L_0x0033
            android.view.View r2 = r5.getChildAt(r1)
            boolean r3 = r2 instanceof android.widget.ImageView
            if (r3 == 0) goto L_0x0030
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            android.graphics.drawable.Drawable r3 = r2.getDrawable()
            if (r3 == 0) goto L_0x0030
            android.graphics.drawable.Drawable$ConstantState r4 = r3.getConstantState()
            if (r4 == 0) goto L_0x0030
            android.graphics.drawable.Drawable$ConstantState r3 = r3.getConstantState()
            android.graphics.drawable.Drawable$ConstantState r4 = r6.getConstantState()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0030
            return r2
        L_0x0030:
            int r1 = r1 + 1
            goto L_0x0005
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ToolbarUtils.c(androidx.appcompat.widget.Toolbar, android.graphics.drawable.Drawable):android.widget.ImageView");
    }

    @Nullable
    public static ImageView d(@NonNull Toolbar toolbar) {
        return c(toolbar, toolbar.getLogo());
    }

    @Nullable
    public static ImageButton e(@NonNull Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i2 = 0; i2 < toolbar.getChildCount(); i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    @Nullable
    public static View f(@NonNull Toolbar toolbar) {
        ActionMenuView b2 = b(toolbar);
        if (b2 == null || b2.getChildCount() <= 1) {
            return null;
        }
        return b2.getChildAt(0);
    }

    @Nullable
    public static TextView g(@NonNull Toolbar toolbar) {
        List<TextView> h2 = h(toolbar, toolbar.getSubtitle());
        if (h2.isEmpty()) {
            return null;
        }
        return (TextView) Collections.max(h2, f21578a);
    }

    private static List<TextView> h(@NonNull Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < toolbar.getChildCount(); i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static TextView i(@NonNull Toolbar toolbar) {
        List<TextView> h2 = h(toolbar, toolbar.getTitle());
        if (h2.isEmpty()) {
            return null;
        }
        return (TextView) Collections.min(h2, f21578a);
    }
}
