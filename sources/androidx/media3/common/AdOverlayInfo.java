package androidx.media3.common;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class AdOverlayInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final int f9057d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9058e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f9059f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static final int f9060g = 4;

    /* renamed from: a  reason: collision with root package name */
    public final View f9061a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9062b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String f9063c;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final View f9064a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9065b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f9066c;

        public Builder(View view, int i2) {
            this.f9064a = view;
            this.f9065b = i2;
        }

        public AdOverlayInfo a() {
            return new AdOverlayInfo(this.f9064a, this.f9065b, this.f9066c);
        }

        @CanIgnoreReturnValue
        public Builder b(@Nullable String str) {
            this.f9066c = str;
            return this;
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Purpose {
    }

    @UnstableApi
    @Deprecated
    public AdOverlayInfo(View view, int i2) {
        this(view, i2, (String) null);
    }

    @UnstableApi
    @Deprecated
    public AdOverlayInfo(View view, int i2, @Nullable String str) {
        this.f9061a = view;
        this.f9062b = i2;
        this.f9063c = str;
    }
}
