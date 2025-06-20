package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001aA\u0010\n\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\n\u0010\u000b\u001aK\u0010\u000f\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001aU\u0010\u0011\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0011\u0010\u0012\u001aA\u0010\u0013\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0013\u0010\u000b\u001a7\u0010\u0016\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a5\u0010\u001a\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a5\u0010\u001d\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001c2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001aM\u0010$\u001a\u00020\u0002*\u00020\u00002\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b$\u0010%\u001aM\u0010&\u001a\u00020\u0002*\u00020\u00002\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b&\u0010\u0012\u001a5\u0010)\u001a\u00020\u0002*\u00020\u00002\u0006\u0010(\u001a\u00020'2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroid/graphics/Canvas;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "j", "(Landroid/graphics/Canvas;Lkotlin/jvm/functions/Function1;)V", "", "x", "y", "o", "(Landroid/graphics/Canvas;FFLkotlin/jvm/functions/Function1;)V", "degrees", "pivotX", "pivotY", "h", "(Landroid/graphics/Canvas;FFFLkotlin/jvm/functions/Function1;)V", "k", "(Landroid/graphics/Canvas;FFFFLkotlin/jvm/functions/Function1;)V", "m", "Landroid/graphics/Matrix;", "matrix", "f", "(Landroid/graphics/Canvas;Landroid/graphics/Matrix;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Rect;", "clipRect", "d", "(Landroid/graphics/Canvas;Landroid/graphics/Rect;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/RectF;", "e", "(Landroid/graphics/Canvas;Landroid/graphics/RectF;Lkotlin/jvm/functions/Function1;)V", "", "left", "top", "right", "bottom", "b", "(Landroid/graphics/Canvas;IIIILkotlin/jvm/functions/Function1;)V", "a", "Landroid/graphics/Path;", "clipPath", "c", "(Landroid/graphics/Canvas;Landroid/graphics/Path;Lkotlin/jvm/functions/Function1;)V", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class CanvasKt {
    public static final void a(@NotNull Canvas canvas, float f2, float f3, float f4, float f5, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipRect(f2, f3, f4, f5);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void b(@NotNull Canvas canvas, int i2, int i3, int i4, int i5, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipRect(i2, i3, i4, i5);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void c(@NotNull Canvas canvas, @NotNull Path path, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void d(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void e(@NotNull Canvas canvas, @NotNull RectF rectF, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void f(@NotNull Canvas canvas, @NotNull Matrix matrix, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static /* synthetic */ void g(Canvas canvas, Matrix matrix, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            matrix = new Matrix();
        }
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void h(@NotNull Canvas canvas, float f2, float f3, float f4, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static /* synthetic */ void i(Canvas canvas, float f2, float f3, float f4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        int save = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void j(@NotNull Canvas canvas, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void k(@NotNull Canvas canvas, float f2, float f3, float f4, float f5, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static /* synthetic */ void l(Canvas canvas, float f2, float f3, float f4, float f5, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f5 = 0.0f;
        }
        int save = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void m(@NotNull Canvas canvas, float f2, float f3, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.skew(f2, f3);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static /* synthetic */ void n(Canvas canvas, float f2, float f3, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        int save = canvas.save();
        canvas.skew(f2, f3);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static final void o(@NotNull Canvas canvas, float f2, float f3, @NotNull Function1<? super Canvas, Unit> function1) {
        int save = canvas.save();
        canvas.translate(f2, f3);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }

    public static /* synthetic */ void p(Canvas canvas, float f2, float f3, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        int save = canvas.save();
        canvas.translate(f2, f3);
        try {
            function1.f(canvas);
        } finally {
            InlineMarker.d(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        }
    }
}
