package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarPresenter implements MenuPresenter {
    private NavigationBarMenuView X;
    private boolean Y = false;
    private int Z;
    private MenuBuilder s;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @NonNull
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        @Nullable
        ParcelableSparseArray X;
        int s;

        SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.s);
            parcel.writeParcelable(this.X, 0);
        }

        SavedState(@NonNull Parcel parcel) {
            this.s = parcel.readInt();
            this.X = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public void a(int i2) {
        this.Z = i2;
    }

    public void b(@NonNull NavigationBarMenuView navigationBarMenuView) {
        this.X = navigationBarMenuView;
    }

    public void c(@Nullable MenuBuilder menuBuilder, boolean z) {
    }

    public void d(boolean z) {
        if (!this.Y) {
            if (z) {
                this.X.c();
            } else {
                this.X.s();
            }
        }
    }

    public boolean e() {
        return false;
    }

    public boolean f(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean g(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    public int getId() {
        return this.Z;
    }

    public void h(@Nullable MenuPresenter.Callback callback) {
    }

    public void i(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.s = menuBuilder;
        this.X.e(menuBuilder);
    }

    public void j(@NonNull Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.X.r(savedState.s);
            this.X.p(BadgeUtils.g(this.X.getContext(), savedState.X));
        }
    }

    public void k(boolean z) {
        this.Y = z;
    }

    public boolean l(@Nullable SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Nullable
    public MenuView m(@Nullable ViewGroup viewGroup) {
        return this.X;
    }

    @NonNull
    public Parcelable n() {
        SavedState savedState = new SavedState();
        savedState.s = this.X.getSelectedItemId();
        savedState.X = BadgeUtils.h(this.X.getBadgeDrawables());
        return savedState;
    }
}
