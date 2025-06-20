package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class AccessibilityRecordCompat {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityRecord f6687a;

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.f6687a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static AccessibilityRecordCompat A(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.f6687a));
    }

    public static void N(@NonNull AccessibilityRecord accessibilityRecord, int i2) {
        accessibilityRecord.setMaxScrollX(i2);
    }

    public static void P(@NonNull AccessibilityRecord accessibilityRecord, int i2) {
        accessibilityRecord.setMaxScrollY(i2);
    }

    public static void Y(@NonNull AccessibilityRecord accessibilityRecord, @Nullable View view, int i2) {
        accessibilityRecord.setSource(view, i2);
    }

    public static int j(@NonNull AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollX();
    }

    public static int l(@NonNull AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollY();
    }

    @Deprecated
    public static AccessibilityRecordCompat z() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    @Deprecated
    public void B() {
        this.f6687a.recycle();
    }

    @Deprecated
    public void C(int i2) {
        this.f6687a.setAddedCount(i2);
    }

    @Deprecated
    public void D(CharSequence charSequence) {
        this.f6687a.setBeforeText(charSequence);
    }

    @Deprecated
    public void E(boolean z) {
        this.f6687a.setChecked(z);
    }

    @Deprecated
    public void F(CharSequence charSequence) {
        this.f6687a.setClassName(charSequence);
    }

    @Deprecated
    public void G(CharSequence charSequence) {
        this.f6687a.setContentDescription(charSequence);
    }

    @Deprecated
    public void H(int i2) {
        this.f6687a.setCurrentItemIndex(i2);
    }

    @Deprecated
    public void I(boolean z) {
        this.f6687a.setEnabled(z);
    }

    @Deprecated
    public void J(int i2) {
        this.f6687a.setFromIndex(i2);
    }

    @Deprecated
    public void K(boolean z) {
        this.f6687a.setFullScreen(z);
    }

    @Deprecated
    public void L(int i2) {
        this.f6687a.setItemCount(i2);
    }

    @Deprecated
    public void M(int i2) {
        N(this.f6687a, i2);
    }

    @Deprecated
    public void O(int i2) {
        P(this.f6687a, i2);
    }

    @Deprecated
    public void Q(Parcelable parcelable) {
        this.f6687a.setParcelableData(parcelable);
    }

    @Deprecated
    public void R(boolean z) {
        this.f6687a.setPassword(z);
    }

    @Deprecated
    public void S(int i2) {
        this.f6687a.setRemovedCount(i2);
    }

    @Deprecated
    public void T(int i2) {
        this.f6687a.setScrollX(i2);
    }

    @Deprecated
    public void U(int i2) {
        this.f6687a.setScrollY(i2);
    }

    @Deprecated
    public void V(boolean z) {
        this.f6687a.setScrollable(z);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public void W(View view) {
        this.f6687a.setSource(view);
    }

    @Deprecated
    public void X(View view, int i2) {
        Y(this.f6687a, view, i2);
    }

    @Deprecated
    public void Z(int i2) {
        this.f6687a.setToIndex(i2);
    }

    @Deprecated
    public int a() {
        return this.f6687a.getAddedCount();
    }

    @Deprecated
    public CharSequence b() {
        return this.f6687a.getBeforeText();
    }

    @Deprecated
    public CharSequence c() {
        return this.f6687a.getClassName();
    }

    @Deprecated
    public CharSequence d() {
        return this.f6687a.getContentDescription();
    }

    @Deprecated
    public int e() {
        return this.f6687a.getCurrentItemIndex();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecord accessibilityRecord = this.f6687a;
        AccessibilityRecord accessibilityRecord2 = ((AccessibilityRecordCompat) obj).f6687a;
        return accessibilityRecord == null ? accessibilityRecord2 == null : accessibilityRecord.equals(accessibilityRecord2);
    }

    @Deprecated
    public int f() {
        return this.f6687a.getFromIndex();
    }

    @Deprecated
    public Object g() {
        return this.f6687a;
    }

    @Deprecated
    public int h() {
        return this.f6687a.getItemCount();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f6687a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public int i() {
        return j(this.f6687a);
    }

    @Deprecated
    public int k() {
        return l(this.f6687a);
    }

    @Deprecated
    public Parcelable m() {
        return this.f6687a.getParcelableData();
    }

    @Deprecated
    public int n() {
        return this.f6687a.getRemovedCount();
    }

    @Deprecated
    public int o() {
        return this.f6687a.getScrollX();
    }

    @Deprecated
    public int p() {
        return this.f6687a.getScrollY();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public AccessibilityNodeInfoCompat q() {
        return AccessibilityNodeInfoCompat.s2(this.f6687a.getSource());
    }

    @Deprecated
    public List<CharSequence> r() {
        return this.f6687a.getText();
    }

    @Deprecated
    public int s() {
        return this.f6687a.getToIndex();
    }

    @Deprecated
    public int t() {
        return this.f6687a.getWindowId();
    }

    @Deprecated
    public boolean u() {
        return this.f6687a.isChecked();
    }

    @Deprecated
    public boolean v() {
        return this.f6687a.isEnabled();
    }

    @Deprecated
    public boolean w() {
        return this.f6687a.isFullScreen();
    }

    @Deprecated
    public boolean x() {
        return this.f6687a.isPassword();
    }

    @Deprecated
    public boolean y() {
        return this.f6687a.isScrollable();
    }
}
