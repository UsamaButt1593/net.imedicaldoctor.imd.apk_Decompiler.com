package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPath {

    /* renamed from: c  reason: collision with root package name */
    public static final KeyPath f17118c = new KeyPath("COMPOSITION");

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f17119a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private KeyPathElement f17120b;

    private KeyPath(KeyPath keyPath) {
        this.f17119a = new ArrayList(keyPath.f17119a);
        this.f17120b = keyPath.f17120b;
    }

    private boolean b() {
        List<String> list = this.f17119a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath a(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f17119a.add(str);
        return keyPath;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i2) {
        if (i2 >= this.f17119a.size()) {
            return false;
        }
        boolean z = i2 == this.f17119a.size() - 1;
        String str2 = this.f17119a.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.f17119a.size() + -2 && b())) && (str2.equals(str) || str2.equals("*"));
        } else if (!z && this.f17119a.get(i2 + 1).equals(str)) {
            return i2 == this.f17119a.size() + -2 || (i2 == this.f17119a.size() + -3 && b());
        } else {
            if (z) {
                return true;
            }
            int i3 = i2 + 1;
            if (i3 < this.f17119a.size() - 1) {
                return false;
            }
            return this.f17119a.get(i3).equals(str);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPathElement d() {
        return this.f17120b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i2) {
        if (f(str)) {
            return 0;
        }
        if (!this.f17119a.get(i2).equals("**")) {
            return 1;
        }
        return (i2 != this.f17119a.size() - 1 && this.f17119a.get(i2 + 1).equals(str)) ? 2 : 0;
    }

    public String g() {
        return this.f17119a.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i2) {
        if (f(str)) {
            return true;
        }
        if (i2 >= this.f17119a.size()) {
            return false;
        }
        return this.f17119a.get(i2).equals(str) || this.f17119a.get(i2).equals("**") || this.f17119a.get(i2).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean i(String str, int i2) {
        return "__container".equals(str) || i2 < this.f17119a.size() - 1 || this.f17119a.get(i2).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath j(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f17120b = keyPathElement;
        return keyPath;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f17119a);
        sb.append(",resolved=");
        sb.append(this.f17120b != null);
        sb.append(ASCIIPropertyListParser.f18653k);
        return sb.toString();
    }

    public KeyPath(String... strArr) {
        this.f17119a = Arrays.asList(strArr);
    }
}
