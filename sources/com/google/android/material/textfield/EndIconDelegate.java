package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate {

    /* renamed from: a  reason: collision with root package name */
    final TextInputLayout f22040a;

    /* renamed from: b  reason: collision with root package name */
    final EndCompoundLayout f22041b;

    /* renamed from: c  reason: collision with root package name */
    final Context f22042c;

    /* renamed from: d  reason: collision with root package name */
    final CheckableImageButton f22043d;

    EndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        this.f22040a = endCompoundLayout.s;
        this.f22041b = endCompoundLayout;
        this.f22042c = endCompoundLayout.getContext();
        this.f22043d = endCompoundLayout.t();
    }

    /* access modifiers changed from: package-private */
    public void a(Editable editable) {
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* access modifiers changed from: package-private */
    @StringRes
    public int c() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @DrawableRes
    public int d() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener g() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i2) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void n(@Nullable EditText editText) {
    }

    /* access modifiers changed from: package-private */
    public void o(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* access modifiers changed from: package-private */
    public void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: package-private */
    public void q(boolean z) {
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        this.f22041b.P(false);
    }

    /* access modifiers changed from: package-private */
    public void s() {
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
    }
}
