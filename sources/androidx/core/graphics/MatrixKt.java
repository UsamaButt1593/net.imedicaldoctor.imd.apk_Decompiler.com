package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a!\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000b\u001a)\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroid/graphics/Matrix;", "m", "e", "(Landroid/graphics/Matrix;Landroid/graphics/Matrix;)Landroid/graphics/Matrix;", "", "h", "(Landroid/graphics/Matrix;)[F", "", "tx", "ty", "f", "(FF)Landroid/graphics/Matrix;", "sx", "sy", "c", "degrees", "px", "py", "a", "(FFF)Landroid/graphics/Matrix;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMatrix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Matrix.kt\nandroidx/core/graphics/MatrixKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
public final class MatrixKt {
    @NotNull
    public static final Matrix a(float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f2, f3, f4);
        return matrix;
    }

    public static /* synthetic */ Matrix b(float f2, float f3, float f4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        return a(f2, f3, f4);
    }

    @NotNull
    public static final Matrix c(float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f3);
        return matrix;
    }

    public static /* synthetic */ Matrix d(float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 1.0f;
        }
        return c(f2, f3);
    }

    @NotNull
    public static final Matrix e(@NotNull Matrix matrix, @NotNull Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    @NotNull
    public static final Matrix f(float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f2, f3);
        return matrix;
    }

    public static /* synthetic */ Matrix g(float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        return f(f2, f3);
    }

    @NotNull
    public static final float[] h(@NotNull Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
