package kotlin.collections.builders;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0018\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0016\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a/\u0010\u001c\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"E", "", "size", "", "d", "(I)[Ljava/lang/Object;", "T", "offset", "length", "", "j", "([Ljava/lang/Object;II)Ljava/lang/String;", "i", "([Ljava/lang/Object;II)I", "", "other", "", "h", "([Ljava/lang/Object;IILjava/util/List;)Z", "newSize", "e", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "index", "", "f", "([Ljava/lang/Object;I)V", "fromIndex", "toIndex", "g", "([Ljava/lang/Object;II)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
public final class ListBuilderKt {
    @NotNull
    public static final <E> E[] d(int i2) {
        if (i2 >= 0) {
            return new Object[i2];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    @NotNull
    public static final <T> T[] e(@NotNull T[] tArr, int i2) {
        Intrinsics.p(tArr, "<this>");
        T[] copyOf = Arrays.copyOf(tArr, i2);
        Intrinsics.o(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    public static final <E> void f(@NotNull E[] eArr, int i2) {
        Intrinsics.p(eArr, "<this>");
        eArr[i2] = null;
    }

    public static final <E> void g(@NotNull E[] eArr, int i2, int i3) {
        Intrinsics.p(eArr, "<this>");
        while (i2 < i3) {
            f(eArr, i2);
            i2++;
        }
    }

    /* access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i2, int i3, List<?> list) {
        if (i3 != list.size()) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!Intrinsics.g(tArr[i2 + i4], list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i2, int i3) {
        int i4 = 1;
        for (int i5 = 0; i5 < i3; i5++) {
            T t = tArr[i2 + i5];
            i4 = (i4 * 31) + (t != null ? t.hashCode() : 0);
        }
        return i4;
    }

    /* access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append("[");
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(tArr[i2 + i4]);
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "sb.toString()");
        return sb2;
    }
}
