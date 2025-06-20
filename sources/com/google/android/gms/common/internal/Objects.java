package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@KeepForSdk
public final class Objects {

    @KeepForSdk
    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        private final List f20253a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final Object f20254b;

        /* synthetic */ ToStringHelper(Object obj, zzai zzai) {
            Preconditions.r(obj);
            this.f20254b = obj;
        }

        @NonNull
        @KeepForSdk
        @CanIgnoreReturnValue
        public ToStringHelper a(@NonNull String str, @Nullable Object obj) {
            Preconditions.r(str);
            String valueOf = String.valueOf(obj);
            this.f20253a.add(str + "=" + valueOf);
            return this;
        }

        @NonNull
        @KeepForSdk
        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f20254b.getClass().getSimpleName());
            sb.append(ASCIIPropertyListParser.f18652j);
            int size = this.f20253a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((String) this.f20253a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(ASCIIPropertyListParser.f18653k);
            return sb.toString();
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static boolean a(@NonNull Bundle bundle, @NonNull Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> keySet = bundle.keySet();
        if (!keySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (String next : keySet) {
            if (!b(bundle.get(next), bundle2.get(next))) {
                return false;
            }
        }
        return true;
    }

    @KeepForSdk
    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @KeepForSdk
    public static int c(@NonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @NonNull
    @KeepForSdk
    public static ToStringHelper d(@NonNull Object obj) {
        return new ToStringHelper(obj, (zzai) null);
    }
}
