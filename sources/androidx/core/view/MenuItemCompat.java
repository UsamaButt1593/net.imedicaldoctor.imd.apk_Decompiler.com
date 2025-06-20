package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.internal.view.SupportMenuItem;

public final class MenuItemCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6433a = "MenuItemCompat";
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final int f6434b = 0;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final int f6435c = 1;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final int f6436d = 2;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final int f6437e = 4;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final int f6438f = 8;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        @DoNotInline
        static CharSequence b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        @DoNotInline
        static ColorStateList c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        @DoNotInline
        static PorterDuff.Mode d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        @DoNotInline
        static int e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        @DoNotInline
        static CharSequence f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        @DoNotInline
        static MenuItem g(MenuItem menuItem, char c2, int i2) {
            return menuItem.setAlphabeticShortcut(c2, i2);
        }

        @DoNotInline
        static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        @DoNotInline
        static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        @DoNotInline
        static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        @DoNotInline
        static MenuItem k(MenuItem menuItem, char c2, int i2) {
            return menuItem.setNumericShortcut(c2, i2);
        }

        @DoNotInline
        static MenuItem l(MenuItem menuItem, char c2, char c3, int i2, int i3) {
            return menuItem.setShortcut(c2, c3, i2, i3);
        }

        @DoNotInline
        static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean a(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean b(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @Nullable
    public static ActionProvider c(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).b();
        }
        Log.w(f6433a, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @Deprecated
    public static View d(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int e(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getAlphabeticModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(menuItem);
        }
        return 0;
    }

    @Nullable
    public static CharSequence f(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getContentDescription();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(menuItem);
        }
        return null;
    }

    @Nullable
    public static ColorStateList g(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintList();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.c(menuItem);
        }
        return null;
    }

    @Nullable
    public static PorterDuff.Mode h(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintMode();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.d(menuItem);
        }
        return null;
    }

    public static int i(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getNumericModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.e(menuItem);
        }
        return 0;
    }

    @Nullable
    public static CharSequence j(@NonNull MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getTooltipText();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.f(menuItem);
        }
        return null;
    }

    @Deprecated
    public static boolean k(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    @Nullable
    public static MenuItem l(@NonNull MenuItem menuItem, @Nullable ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).a(actionProvider);
        }
        Log.w(f6433a, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem m(MenuItem menuItem, int i2) {
        return menuItem.setActionView(i2);
    }

    @Deprecated
    public static MenuItem n(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void o(@NonNull MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c2, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.g(menuItem, c2, i2);
        }
    }

    public static void p(@NonNull MenuItem menuItem, @Nullable CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.h(menuItem, charSequence);
        }
    }

    public static void q(@NonNull MenuItem menuItem, @Nullable ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.i(menuItem, colorStateList);
        }
    }

    public static void r(@NonNull MenuItem menuItem, @Nullable PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.j(menuItem, mode);
        }
    }

    public static void s(@NonNull MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c2, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.k(menuItem, c2, i2);
        }
    }

    @Deprecated
    public static MenuItem t(MenuItem menuItem, final OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return OnActionExpandListener.this.onMenuItemActionCollapse(menuItem);
            }

            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return OnActionExpandListener.this.onMenuItemActionExpand(menuItem);
            }
        });
    }

    public static void u(@NonNull MenuItem menuItem, char c2, char c3, int i2, int i3) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setShortcut(c2, c3, i2, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.l(menuItem, c2, c3, i2, i3);
        }
    }

    @Deprecated
    public static void v(MenuItem menuItem, int i2) {
        menuItem.setShowAsAction(i2);
    }

    public static void w(@NonNull MenuItem menuItem, @Nullable CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.m(menuItem, charSequence);
        }
    }
}
