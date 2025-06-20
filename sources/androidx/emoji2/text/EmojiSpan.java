package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi(19)
public abstract class EmojiSpan extends ReplacementSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Paint.FontMetricsInt f7637a = new Paint.FontMetricsInt();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final TypefaceEmojiRasterizer f7638b;

    /* renamed from: c  reason: collision with root package name */
    private short f7639c = -1;

    /* renamed from: d  reason: collision with root package name */
    private short f7640d = -1;

    /* renamed from: e  reason: collision with root package name */
    private float f7641e = 1.0f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    EmojiSpan(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Preconditions.m(typefaceEmojiRasterizer, "rasterizer cannot be null");
        this.f7638b = typefaceEmojiRasterizer;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int a() {
        return this.f7640d;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int b() {
        return d().g();
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final float c() {
        return this.f7641e;
    }

    @NonNull
    public final TypefaceEmojiRasterizer d() {
        return this.f7638b;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final int e() {
        return this.f7639c;
    }

    public int getSize(@NonNull Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i2, int i3, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f7637a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f7637a;
        this.f7641e = (((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f) / ((float) this.f7638b.f());
        this.f7640d = (short) ((int) (((float) this.f7638b.f()) * this.f7641e));
        short k2 = (short) ((int) (((float) this.f7638b.k()) * this.f7641e));
        this.f7639c = k2;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f7637a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return k2;
    }
}
