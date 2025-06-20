package yuku.ambilwarna.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import yuku.ambilwarna.AmbilWarnaDialog;
import yuku.ambilwarna.R;

public class AmbilWarnaPreference extends Preference {
    int X;
    private final boolean s;

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        int s;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.s = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.s);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public AmbilWarnaPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = context.obtainStyledAttributes(attributeSet, R.styleable.f31959a).getBoolean(R.styleable.f31960b, false);
        setWidgetLayoutResource(R.layout.f31958b);
    }

    public void e(int i2) {
        this.X = i2;
        persistInt(i2);
        notifyChanged();
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        super.onBindView(view);
        View findViewById = view.findViewById(R.id.f31951h);
        if (findViewById != null) {
            findViewById.setBackgroundColor(this.X);
        }
    }

    /* access modifiers changed from: protected */
    public void onClick() {
        new AmbilWarnaDialog(getContext(), this.X, this.s, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            public void a(AmbilWarnaDialog ambilWarnaDialog, int i2) {
                if (AmbilWarnaPreference.this.callChangeListener(Integer.valueOf(i2))) {
                    AmbilWarnaPreference ambilWarnaPreference = AmbilWarnaPreference.this;
                    ambilWarnaPreference.X = i2;
                    boolean unused = ambilWarnaPreference.persistInt(i2);
                    AmbilWarnaPreference.this.notifyChanged();
                }
            }

            public void b(AmbilWarnaDialog ambilWarnaDialog) {
            }
        }).v();
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInteger(i2, 0));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.X = savedState.s;
        notifyChanged();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.s = this.X;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(boolean z, Object obj) {
        if (z) {
            this.X = getPersistedInt(this.X);
            return;
        }
        int intValue = ((Integer) obj).intValue();
        this.X = intValue;
        persistInt(intValue);
    }
}
