package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f*\u00020\u0000H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Ljava/lang/StackTraceElement;", "e", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "b", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "c", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)I", "expected", "actual", "", "a", "(II)V", "", "", "d", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "I", "COROUTINES_DEBUG_METADATA_VERSION", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,134:1\n37#2,2:135\n*S KotlinDebug\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n*L\n131#1:135,2\n*E\n"})
public final class DebugMetadataKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f28805a = 1;

    private static final void a(int i2, int i3) {
        if (i3 > i2) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
        }
    }

    private static final DebugMetadata b(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SinceKotlin(version = "1.3")
    @Nullable
    @JvmName(name = "getSpilledVariableFieldMapping")
    public static final String[] d(@NotNull BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.p(baseContinuationImpl, "<this>");
        DebugMetadata b2 = b(baseContinuationImpl);
        if (b2 == null) {
            return null;
        }
        a(1, b2.v());
        ArrayList arrayList = new ArrayList();
        int c2 = c(baseContinuationImpl);
        int[] i2 = b2.i();
        int length = i2.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2[i3] == c2) {
                arrayList.add(b2.s()[i3]);
                arrayList.add(b2.n()[i3]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @SinceKotlin(version = "1.3")
    @Nullable
    @JvmName(name = "getStackTraceElement")
    public static final StackTraceElement e(@NotNull BaseContinuationImpl baseContinuationImpl) {
        String str;
        Intrinsics.p(baseContinuationImpl, "<this>");
        DebugMetadata b2 = b(baseContinuationImpl);
        if (b2 == null) {
            return null;
        }
        a(1, b2.v());
        int c2 = c(baseContinuationImpl);
        int i2 = c2 < 0 ? -1 : b2.l()[c2];
        String b3 = ModuleNameRetriever.f28806a.b(baseContinuationImpl);
        if (b3 == null) {
            str = b2.c();
        } else {
            str = b3 + '/' + b2.c();
        }
        return new StackTraceElement(str, b2.m(), b2.f(), i2);
    }
}
