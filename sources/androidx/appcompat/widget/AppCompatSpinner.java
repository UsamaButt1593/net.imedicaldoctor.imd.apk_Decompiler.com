package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.TintableBackgroundView;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    @StyleableRes
    @SuppressLint({"ResourceType"})
    private static final int[] e3 = {16843505};
    private static final int f3 = 15;
    private static final String g3 = "AppCompatSpinner";
    private static final int h3 = 0;
    private static final int i3 = 1;
    private static final int j3 = -1;
    private final Context X2;
    private ForwardingListener Y2;
    private SpinnerAdapter Z2;
    private final boolean a3;
    private SpinnerPopup b3;
    int c3;
    final Rect d3;
    private final AppCompatBackgroundHelper s;

    @RequiresApi(23)
    private static final class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void a(@NonNull ThemedSpinnerAdapter themedSpinnerAdapter, @Nullable Resources.Theme theme) {
            if (!ObjectsCompat.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    @VisibleForTesting
    class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private ListAdapter X;
        private CharSequence Y;
        @VisibleForTesting
        AlertDialog s;

        DialogPopup() {
        }

        public boolean b() {
            AlertDialog alertDialog = this.s;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        public void c(Drawable drawable) {
            Log.e(AppCompatSpinner.g3, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public int d() {
            return 0;
        }

        public void dismiss() {
            AlertDialog alertDialog = this.s;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.s = null;
            }
        }

        public void f(int i2) {
            Log.e(AppCompatSpinner.g3, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public CharSequence g() {
            return this.Y;
        }

        public Drawable i() {
            return null;
        }

        public void j(CharSequence charSequence) {
            this.Y = charSequence;
        }

        public void l(int i2) {
            Log.e(AppCompatSpinner.g3, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void m(int i2) {
            Log.e(AppCompatSpinner.g3, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void n(int i2, int i3) {
            if (this.X != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.Y;
                if (charSequence != null) {
                    builder.setTitle(charSequence);
                }
                AlertDialog create = builder.D(this.X, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
                this.s = create;
                ListView q = create.q();
                q.setTextDirection(i2);
                q.setTextAlignment(i3);
                this.s.show();
            }
        }

        public int o() {
            return 0;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            AppCompatSpinner.this.setSelection(i2);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i2, this.X.getItemId(i2));
            }
            dismiss();
        }

        public int p() {
            return 0;
        }

        public void q(ListAdapter listAdapter) {
            this.X = listAdapter;
        }
    }

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private ListAdapter X;
        private SpinnerAdapter s;

        public DropDownAdapter(@Nullable SpinnerAdapter spinnerAdapter, @Nullable Resources.Theme theme) {
            this.s = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.X = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && C0020v.a(spinnerAdapter)) {
                Api23Impl.a(C0021w.a(spinnerAdapter), theme);
            } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() == null) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.X;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.s;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.s;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.s;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.s;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i2);
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.s;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.X;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.s;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.s;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    @VisibleForTesting
    class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        private CharSequence M3;
        ListAdapter N3;
        private final Rect O3 = new Rect();
        private int P3;

        public DropdownPopup(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            S(AppCompatSpinner.this);
            d0(true);
            j0(0);
            f0(new AdapterView.OnItemClickListener(AppCompatSpinner.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        DropdownPopup dropdownPopup = DropdownPopup.this;
                        AppCompatSpinner.this.performItemClick(view, i2, dropdownPopup.N3.getItemId(i2));
                    }
                    DropdownPopup.this.dismiss();
                }
            });
        }

        public CharSequence g() {
            return this.M3;
        }

        public void j(CharSequence charSequence) {
            this.M3 = charSequence;
        }

        public void m(int i2) {
            this.P3 = i2;
        }

        public void n(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean b2 = b();
            q0();
            a0(2);
            super.a();
            ListView k2 = k();
            k2.setChoiceMode(1);
            k2.setTextDirection(i2);
            k2.setTextAlignment(i3);
            l0(AppCompatSpinner.this.getSelectedItemPosition());
            if (!b2 && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final AnonymousClass2 r5 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        DropdownPopup dropdownPopup = DropdownPopup.this;
                        if (!dropdownPopup.r0(AppCompatSpinner.this)) {
                            DropdownPopup.this.dismiss();
                            return;
                        }
                        DropdownPopup.this.q0();
                        DropdownPopup.super.a();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r5);
                e0(new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r5);
                        }
                    }
                });
            }
        }

        public int p() {
            return this.P3;
        }

        public void q(ListAdapter listAdapter) {
            super.q(listAdapter);
            this.N3 = listAdapter;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x009a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void q0() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.i()
                if (r0 == 0) goto L_0x0024
                androidx.appcompat.widget.AppCompatSpinner r1 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r1 = r1.d3
                r0.getPadding(r1)
                androidx.appcompat.widget.AppCompatSpinner r0 = androidx.appcompat.widget.AppCompatSpinner.this
                boolean r0 = androidx.appcompat.widget.ViewUtils.b(r0)
                if (r0 == 0) goto L_0x001c
                androidx.appcompat.widget.AppCompatSpinner r0 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r0 = r0.d3
                int r0 = r0.right
                goto L_0x002e
            L_0x001c:
                androidx.appcompat.widget.AppCompatSpinner r0 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r0 = r0.d3
                int r0 = r0.left
                int r0 = -r0
                goto L_0x002e
            L_0x0024:
                androidx.appcompat.widget.AppCompatSpinner r0 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r0 = r0.d3
                r1 = 0
                r0.right = r1
                r0.left = r1
                r0 = 0
            L_0x002e:
                androidx.appcompat.widget.AppCompatSpinner r1 = androidx.appcompat.widget.AppCompatSpinner.this
                int r1 = r1.getPaddingLeft()
                androidx.appcompat.widget.AppCompatSpinner r2 = androidx.appcompat.widget.AppCompatSpinner.this
                int r2 = r2.getPaddingRight()
                androidx.appcompat.widget.AppCompatSpinner r3 = androidx.appcompat.widget.AppCompatSpinner.this
                int r3 = r3.getWidth()
                androidx.appcompat.widget.AppCompatSpinner r4 = androidx.appcompat.widget.AppCompatSpinner.this
                int r5 = r4.c3
                r6 = -2
                if (r5 != r6) goto L_0x007b
                android.widget.ListAdapter r5 = r8.N3
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.i()
                int r4 = r4.a(r5, r6)
                androidx.appcompat.widget.AppCompatSpinner r5 = androidx.appcompat.widget.AppCompatSpinner.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                androidx.appcompat.widget.AppCompatSpinner r6 = androidx.appcompat.widget.AppCompatSpinner.this
                android.graphics.Rect r6 = r6.d3
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L_0x0070
                r4 = r5
            L_0x0070:
                int r5 = r3 - r1
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
            L_0x0077:
                r8.U(r4)
                goto L_0x0085
            L_0x007b:
                r4 = -1
                if (r5 != r4) goto L_0x0082
                int r4 = r3 - r1
                int r4 = r4 - r2
                goto L_0x0077
            L_0x0082:
                r8.U(r5)
            L_0x0085:
                androidx.appcompat.widget.AppCompatSpinner r4 = androidx.appcompat.widget.AppCompatSpinner.this
                boolean r4 = androidx.appcompat.widget.ViewUtils.b(r4)
                if (r4 == 0) goto L_0x009a
                int r3 = r3 - r2
                int r1 = r8.H()
                int r3 = r3 - r1
                int r1 = r8.p()
                int r3 = r3 - r1
                int r0 = r0 + r3
                goto L_0x00a0
            L_0x009a:
                int r2 = r8.p()
                int r1 = r1 + r2
                int r0 = r0 + r1
            L_0x00a0:
                r8.f(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.q0():void");
        }

        /* access modifiers changed from: package-private */
        public boolean r0(View view) {
            return view.isAttachedToWindow() && view.getGlobalVisibleRect(this.O3);
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<AppCompatSpinner> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3134a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f3135b;

        /* renamed from: c  reason: collision with root package name */
        private int f3136c;

        /* renamed from: a */
        public void readProperties(@NonNull AppCompatSpinner appCompatSpinner, @NonNull PropertyReader propertyReader) {
            if (this.f3134a) {
                propertyReader.readObject(this.f3135b, appCompatSpinner.getBackgroundTintList());
                propertyReader.readObject(this.f3136c, appCompatSpinner.getBackgroundTintMode());
                return;
            }
            throw C0004e.a();
        }

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.f3135b = propertyMapper.mapObject("backgroundTint", R.attr.b0);
            this.f3136c = propertyMapper.mapObject("backgroundTintMode", R.attr.c0);
            this.f3134a = true;
        }
    }

    static class SavedState extends View.BaseSavedState {
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
        boolean s;

        SavedState(Parcel parcel) {
            super(parcel);
            this.s = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.s ? (byte) 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @VisibleForTesting
    interface SpinnerPopup {
        boolean b();

        void c(Drawable drawable);

        int d();

        void dismiss();

        void f(int i2);

        CharSequence g();

        Drawable i();

        void j(CharSequence charSequence);

        void l(int i2);

        void m(int i2);

        void n(int i2, int i3);

        int o();

        int p();

        void q(ListAdapter listAdapter);
    }

    public AppCompatSpinner(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i4 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i4 = Math.max(i4, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i4;
        }
        drawable.getPadding(this.d3);
        Rect rect = this.d3;
        return i4 + rect.left + rect.right;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.b3.n(getTextDirection(), getTextAlignment());
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        SpinnerPopup spinnerPopup = this.b3;
        return spinnerPopup != null ? spinnerPopup.d() : super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        SpinnerPopup spinnerPopup = this.b3;
        return spinnerPopup != null ? spinnerPopup.o() : super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        return this.b3 != null ? this.c3 : super.getDropDownWidth();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final SpinnerPopup getInternalPopup() {
        return this.b3;
    }

    public Drawable getPopupBackground() {
        SpinnerPopup spinnerPopup = this.b3;
        return spinnerPopup != null ? spinnerPopup.i() : super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.X2;
    }

    public CharSequence getPrompt() {
        SpinnerPopup spinnerPopup = this.b3;
        return spinnerPopup != null ? spinnerPopup.g() : super.getPrompt();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup spinnerPopup = this.b3;
        if (spinnerPopup != null && spinnerPopup.b()) {
            this.b3.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        if (this.b3 != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.s && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (!AppCompatSpinner.this.getInternalPopup().b()) {
                        AppCompatSpinner.this.b();
                    }
                    ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SpinnerPopup spinnerPopup = this.b3;
        savedState.s = spinnerPopup != null && spinnerPopup.b();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener = this.Y2;
        if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        SpinnerPopup spinnerPopup = this.b3;
        if (spinnerPopup == null) {
            return super.performClick();
        }
        if (spinnerPopup.b()) {
            return true;
        }
        b();
        return true;
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        SpinnerPopup spinnerPopup = this.b3;
        if (spinnerPopup != null) {
            spinnerPopup.m(i2);
            this.b3.f(i2);
            return;
        }
        super.setDropDownHorizontalOffset(i2);
    }

    public void setDropDownVerticalOffset(int i2) {
        SpinnerPopup spinnerPopup = this.b3;
        if (spinnerPopup != null) {
            spinnerPopup.l(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.b3 != null) {
            this.c3 = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        SpinnerPopup spinnerPopup = this.b3;
        if (spinnerPopup != null) {
            spinnerPopup.c(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(@DrawableRes int i2) {
        setPopupBackgroundDrawable(AppCompatResources.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        SpinnerPopup spinnerPopup = this.b3;
        if (spinnerPopup != null) {
            spinnerPopup.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.s;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public AppCompatSpinner(@NonNull Context context, int i2) {
        this(context, (AttributeSet) null, R.attr.Y2, i2);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.a3) {
            this.Z2 = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.b3 != null) {
            Context context = this.X2;
            if (context == null) {
                context = getContext();
            }
            this.b3.q(new DropDownAdapter(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Y2);
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public AppCompatSpinner(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i4) {
        this(context, attributeSet, i2, i4, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        if (r11 != null) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d A[SYNTHETIC, Splitter:B:10:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.d3 = r0
            android.content.Context r0 = r6.getContext()
            androidx.appcompat.widget.ThemeUtils.a(r6, r0)
            int[] r0 = androidx.appcompat.R.styleable.F5
            r1 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.G(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.AppCompatBackgroundHelper r2 = new androidx.appcompat.widget.AppCompatBackgroundHelper
            r2.<init>(r6)
            r6.s = r2
            if (r11 == 0) goto L_0x0029
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
        L_0x0026:
            r6.X2 = r2
            goto L_0x0039
        L_0x0029:
            int r11 = androidx.appcompat.R.styleable.K5
            int r11 = r0.u(r11, r1)
            if (r11 == 0) goto L_0x0037
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (int) r11)
            goto L_0x0026
        L_0x0037:
            r6.X2 = r7
        L_0x0039:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x006b
            int[] r11 = e3     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x0051 }
            if (r3 == 0) goto L_0x0053
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0053
        L_0x004e:
            r7 = move-exception
            r2 = r11
            goto L_0x0065
        L_0x0051:
            r3 = move-exception
            goto L_0x005b
        L_0x0053:
            r11.recycle()
            goto L_0x006b
        L_0x0057:
            r7 = move-exception
            goto L_0x0065
        L_0x0059:
            r3 = move-exception
            r11 = r2
        L_0x005b:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x004e }
            if (r11 == 0) goto L_0x006b
            goto L_0x0053
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.recycle()
        L_0x006a:
            throw r7
        L_0x006b:
            r11 = 1
            if (r10 == 0) goto L_0x00a8
            if (r10 == r11) goto L_0x0071
            goto L_0x00b8
        L_0x0071:
            androidx.appcompat.widget.AppCompatSpinner$DropdownPopup r10 = new androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
            android.content.Context r3 = r6.X2
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.X2
            int[] r4 = androidx.appcompat.R.styleable.F5
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.G(r3, r8, r4, r9, r1)
            int r3 = androidx.appcompat.R.styleable.J5
            r4 = -2
            int r3 = r1.q(r3, r4)
            r6.c3 = r3
            int r3 = androidx.appcompat.R.styleable.H5
            android.graphics.drawable.Drawable r3 = r1.h(r3)
            r10.c(r3)
            int r3 = androidx.appcompat.R.styleable.I5
            java.lang.String r3 = r0.w(r3)
            r10.j(r3)
            r1.I()
            r6.b3 = r10
            androidx.appcompat.widget.AppCompatSpinner$1 r1 = new androidx.appcompat.widget.AppCompatSpinner$1
            r1.<init>(r6, r10)
            r6.Y2 = r1
            goto L_0x00b8
        L_0x00a8:
            androidx.appcompat.widget.AppCompatSpinner$DialogPopup r10 = new androidx.appcompat.widget.AppCompatSpinner$DialogPopup
            r10.<init>()
            r6.b3 = r10
            int r1 = androidx.appcompat.R.styleable.I5
            java.lang.String r1 = r0.w(r1)
            r10.j(r1)
        L_0x00b8:
            int r10 = androidx.appcompat.R.styleable.G5
            java.lang.CharSequence[] r10 = r0.y(r10)
            if (r10 == 0) goto L_0x00d0
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = androidx.appcompat.R.layout.F
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00d0:
            r0.I()
            r6.a3 = r11
            android.widget.SpinnerAdapter r7 = r6.Z2
            if (r7 == 0) goto L_0x00de
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.Z2 = r2
        L_0x00de:
            androidx.appcompat.widget.AppCompatBackgroundHelper r7 = r6.s
            r7.e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
