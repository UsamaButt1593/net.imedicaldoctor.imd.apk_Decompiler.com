package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n12524#2,2:3043\n1687#2,6:3045\n1795#2,6:3051\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n*L\n199#1:3043,2\n201#1:3045,6\n202#1:3051,6\n*E\n"})
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$5", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "()Z", "element", "c", "(F)Z", "", "index", "d", "(I)Ljava/lang/Float;", "g", "(F)I", "h", "b", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class ArraysKt___ArraysJvmKt$asList$5 extends AbstractList<Float> implements RandomAccess {
    final /* synthetic */ float[] X;

    ArraysKt___ArraysJvmKt$asList$5(float[] fArr) {
        this.X = fArr;
    }

    public int b() {
        return this.X.length;
    }

    public boolean c(float f2) {
        for (float floatToIntBits : this.X) {
            if (Float.floatToIntBits(floatToIntBits) == Float.floatToIntBits(f2)) {
                return true;
            }
        }
        return false;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Float)) {
            return false;
        }
        return c(((Number) obj).floatValue());
    }

    @NotNull
    /* renamed from: d */
    public Float get(int i2) {
        return Float.valueOf(this.X[i2]);
    }

    public int g(float f2) {
        float[] fArr = this.X;
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Float.floatToIntBits(fArr[i2]) == Float.floatToIntBits(f2)) {
                return i2;
            }
        }
        return -1;
    }

    public int h(float f2) {
        float[] fArr = this.X;
        int length = fArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i2 = length - 1;
            if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f2)) {
                return length;
            }
            if (i2 < 0) {
                return -1;
            }
            length = i2;
        }
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        return g(((Number) obj).floatValue());
    }

    public boolean isEmpty() {
        return this.X.length == 0;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        return h(((Number) obj).floatValue());
    }
}
