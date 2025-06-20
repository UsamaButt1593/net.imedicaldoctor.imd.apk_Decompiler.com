package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TypefaceEmojiSpan extends EmojiSpan {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static Paint f7685g;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private TextPaint f7686f;

    public TypefaceEmojiSpan(@NonNull TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        super(typefaceEmojiRasterizer);
    }

    @Nullable
    private TextPaint f(@Nullable CharSequence charSequence, int i2, int i3, Paint paint) {
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i2, i3, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (!(characterStyleArr.length == 1 && characterStyleArr[0] == this)) {
                    TextPaint textPaint = this.f7686f;
                    if (textPaint == null) {
                        textPaint = new TextPaint();
                        this.f7686f = textPaint;
                    }
                    textPaint.set(paint);
                    for (CharacterStyle updateDrawState : characterStyleArr) {
                        updateDrawState.updateDrawState(textPaint);
                    }
                    return textPaint;
                }
            }
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        } else if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        } else {
            return null;
        }
    }

    @NonNull
    private static Paint h() {
        if (f7685g == null) {
            TextPaint textPaint = new TextPaint();
            f7685g = textPaint;
            textPaint.setColor(EmojiCompat.c().g());
            f7685g.setStyle(Paint.Style.FILL);
        }
        return f7685g;
    }

    public void draw(@NonNull Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        float f3 = f2;
        int i7 = i4;
        int i8 = i6;
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = paint;
        TextPaint f4 = f(charSequence, i2, i3, textPaint);
        if (!(f4 == null || f4.bgColor == 0)) {
            g(canvas, f4, f2, f3 + ((float) e()), (float) i7, (float) i8);
        }
        if (EmojiCompat.c().r()) {
            canvas.drawRect(f2, (float) i7, f3 + ((float) e()), (float) i8, h());
        }
        TypefaceEmojiRasterizer d2 = d();
        float f5 = (float) i5;
        Canvas canvas2 = canvas;
        if (f4 != null) {
            textPaint = f4;
        }
        d2.a(canvas, f3, f5, textPaint);
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas, TextPaint textPaint, float f2, float f3, float f4, float f5) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f2, f4, f3, f5, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }
}
