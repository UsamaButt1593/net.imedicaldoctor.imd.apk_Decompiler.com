package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public interface TrackSelection {

    /* renamed from: a  reason: collision with root package name */
    public static final int f12409a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f12410b = 10000;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    int c(Format format);

    TrackGroup d();

    int getType();

    Format i(int i2);

    int k(int i2);

    int length();

    int v(int i2);
}
