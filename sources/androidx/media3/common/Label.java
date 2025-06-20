package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public class Label {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9156c = Util.d1(0);

    /* renamed from: d  reason: collision with root package name */
    private static final String f9157d = Util.d1(1);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f9158a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9159b;

    public Label(@Nullable String str, String str2) {
        this.f9158a = Util.L1(str);
        this.f9159b = str2;
    }

    public static Label a(Bundle bundle) {
        return new Label(bundle.getString(f9156c), (String) Assertions.g(bundle.getString(f9157d)));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f9158a;
        if (str != null) {
            bundle.putString(f9156c, str);
        }
        bundle.putString(f9157d, this.f9159b);
        return bundle;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Label label = (Label) obj;
        return Util.g(this.f9158a, label.f9158a) && Util.g(this.f9159b, label.f9159b);
    }

    public int hashCode() {
        int hashCode = this.f9159b.hashCode() * 31;
        String str = this.f9158a;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
