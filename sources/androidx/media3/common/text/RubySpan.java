package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class RubySpan implements LanguageFeatureSpan {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9476c = Util.d1(0);

    /* renamed from: d  reason: collision with root package name */
    private static final String f9477d = Util.d1(1);

    /* renamed from: a  reason: collision with root package name */
    public final String f9478a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9479b;

    public RubySpan(String str, int i2) {
        this.f9478a = str;
        this.f9479b = i2;
    }

    public static RubySpan a(Bundle bundle) {
        return new RubySpan((String) Assertions.g(bundle.getString(f9476c)), bundle.getInt(f9477d));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(f9476c, this.f9478a);
        bundle.putInt(f9477d, this.f9479b);
        return bundle;
    }
}
