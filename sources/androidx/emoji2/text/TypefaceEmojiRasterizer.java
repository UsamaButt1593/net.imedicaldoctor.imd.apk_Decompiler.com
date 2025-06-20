package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.apache.commons.lang3.StringUtils;

@RequiresApi(19)
@AnyThread
public class TypefaceEmojiRasterizer {
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: d  reason: collision with root package name */
    static final int f7678d = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: e  reason: collision with root package name */
    static final int f7679e = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: f  reason: collision with root package name */
    static final int f7680f = 2;

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadLocal<MetadataItem> f7681g = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final int f7682a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final MetadataRepo f7683b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f7684c = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    TypefaceEmojiRasterizer(@NonNull MetadataRepo metadataRepo, @IntRange(from = 0) int i2) {
        this.f7683b = metadataRepo;
        this.f7682a = i2;
    }

    private MetadataItem h() {
        ThreadLocal<MetadataItem> threadLocal = f7681g;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.f7683b.g().J(metadataItem, this.f7682a);
        return metadataItem;
    }

    public void a(@NonNull Canvas canvas, float f2, float f3, @NonNull Paint paint) {
        Typeface j2 = this.f7683b.j();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(j2);
        Canvas canvas2 = canvas;
        canvas2.drawText(this.f7683b.f(), this.f7682a * 2, 2, f2, f3, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i2) {
        return h().F(i2);
    }

    public int c() {
        return h().I();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public short d() {
        return h().L();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e() {
        return this.f7684c & 3;
    }

    public int f() {
        return h().S();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int g() {
        return h().T();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public short i() {
        return h().U();
    }

    @NonNull
    public Typeface j() {
        return this.f7683b.j();
    }

    public int k() {
        return h().X();
    }

    public boolean l() {
        return h().O();
    }

    public boolean m() {
        return (this.f7684c & 4) > 0;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void n() {
        this.f7684c = m() ? 4 : 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void o(boolean z) {
        int e2 = e();
        if (z) {
            this.f7684c = e2 | 4;
        } else {
            this.f7684c = e2;
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void p(boolean z) {
        int i2 = this.f7684c & 4;
        this.f7684c = z ? i2 | 2 : i2 | 1;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(g()));
        sb.append(", codepoints:");
        int c2 = c();
        for (int i2 = 0; i2 < c2; i2++) {
            sb.append(Integer.toHexString(b(i2)));
            sb.append(StringUtils.SPACE);
        }
        return sb.toString();
    }
}
