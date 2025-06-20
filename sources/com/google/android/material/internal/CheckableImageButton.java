package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] c3 = {16842912};
    private boolean Z2;
    private boolean a3;
    private boolean b3;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        boolean Y;

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel);
        }

        private void b(@NonNull Parcel parcel) {
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.Y = z;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public CheckableImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean a() {
        return this.a3;
    }

    public boolean b() {
        return this.b3;
    }

    public boolean isChecked() {
        return this.Z2;
    }

    public int[] onCreateDrawableState(int i2) {
        if (!this.Z2) {
            return super.onCreateDrawableState(i2);
        }
        int[] iArr = c3;
        return View.mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.Y);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Y = this.Z2;
        return savedState;
    }

    public void setCheckable(boolean z) {
        if (this.a3 != z) {
            this.a3 = z;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z) {
        if (this.a3 && this.Z2 != z) {
            this.Z2 = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z) {
        this.b3 = z;
    }

    public void setPressed(boolean z) {
        if (this.b3) {
            super.setPressed(z);
        }
    }

    public void toggle() {
        setChecked(!this.Z2);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.K1);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a3 = true;
        this.b3 = true;
        ViewCompat.H1(this, new AccessibilityDelegateCompat() {
            public void f(View view, @NonNull AccessibilityEvent accessibilityEvent) {
                super.f(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.h1(CheckableImageButton.this.a());
                accessibilityNodeInfoCompat.i1(CheckableImageButton.this.isChecked());
            }
        });
    }
}
