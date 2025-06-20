package androidx.core.internal.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ActionProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface SupportMenuItem extends MenuItem {

    /* renamed from: g  reason: collision with root package name */
    public static final int f5945g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5946h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5947i = 2;

    /* renamed from: j  reason: collision with root package name */
    public static final int f5948j = 4;

    /* renamed from: k  reason: collision with root package name */
    public static final int f5949k = 8;

    @NonNull
    SupportMenuItem a(@Nullable ActionProvider actionProvider);

    @Nullable
    ActionProvider b();

    boolean c();

    boolean collapseActionView();

    boolean d();

    boolean expandActionView();

    @Nullable
    View getActionView();

    int getAlphabeticModifiers();

    @Nullable
    CharSequence getContentDescription();

    @Nullable
    ColorStateList getIconTintList();

    @Nullable
    PorterDuff.Mode getIconTintMode();

    int getNumericModifiers();

    @Nullable
    CharSequence getTooltipText();

    boolean isActionViewExpanded();

    @NonNull
    MenuItem setActionView(int i2);

    @NonNull
    MenuItem setActionView(@Nullable View view);

    @NonNull
    MenuItem setAlphabeticShortcut(char c2, int i2);

    @NonNull
    /* bridge */ /* synthetic */ MenuItem setContentDescription(@Nullable CharSequence charSequence);

    @NonNull
    SupportMenuItem setContentDescription(@Nullable CharSequence charSequence);

    @NonNull
    MenuItem setIconTintList(@Nullable ColorStateList colorStateList);

    @NonNull
    MenuItem setIconTintMode(@Nullable PorterDuff.Mode mode);

    @NonNull
    MenuItem setNumericShortcut(char c2, int i2);

    @NonNull
    MenuItem setShortcut(char c2, char c3, int i2, int i3);

    void setShowAsAction(int i2);

    @NonNull
    MenuItem setShowAsActionFlags(int i2);

    @NonNull
    /* bridge */ /* synthetic */ MenuItem setTooltipText(@Nullable CharSequence charSequence);

    @NonNull
    SupportMenuItem setTooltipText(@Nullable CharSequence charSequence);
}
