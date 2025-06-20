package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a9\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007j\u0002`\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0004\b\t\u0010\n\u001a1\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a8\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007j\u0002`\b2\u0014\b\u0004\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0007H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0014\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\"\u0010\u0017\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0012H\u0010¢\u0006\u0004\b\u0017\u0010\u0015\"\u0014\u0010\u001a\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001c*(\b\u0002\u0010\u001e\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00072\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007¨\u0006\u001f"}, d2 = {"", "E", "exception", "h", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/Class;", "clz", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "b", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "Ljava/lang/reflect/Constructor;", "constructor", "c", "(Ljava/lang/reflect/Constructor;)Lkotlin/jvm/functions/Function1;", "block", "g", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "", "defaultValue", "f", "(Ljava/lang/Class;I)I", "accumulator", "d", "a", "I", "throwableFields", "Lkotlinx/coroutines/internal/CtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "ctorCache", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ExceptionsConstructorKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f29343a = f(Throwable.class, -1);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final CtorCache f29344b;

    static {
        CtorCache ctorCache;
        try {
            ctorCache = FastServiceLoaderKt.a() ? WeakMapCtorCache.f29408a : ClassValueCtorCache.f29334a;
        } catch (Throwable unused) {
            ctorCache = WeakMapCtorCache.f29408a;
        }
        f29344b = ctorCache;
    }

    /* access modifiers changed from: private */
    public static final <E extends Throwable> Function1<Throwable, Throwable> b(Class<E> cls) {
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = ExceptionsConstructorKt$createConstructor$nullResult$1.X;
        if (f29343a != f(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        for (Constructor c2 : ArraysKt.Mv(cls.getConstructors(), new ExceptionsConstructorKt$createConstructor$$inlined$sortedByDescending$1())) {
            Function1<Throwable, Throwable> c3 = c(c2);
            if (c3 != null) {
                return c3;
            }
        }
        return exceptionsConstructorKt$createConstructor$nullResult$1;
    }

    private static final Function1<Throwable, Throwable> c(Constructor<?> constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4(constructor);
        }
        Class<Throwable> cls = Throwable.class;
        Class<String> cls2 = String.class;
        if (length == 1) {
            Class cls3 = parameterTypes[0];
            if (Intrinsics.g(cls3, cls)) {
                return new ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$2(constructor);
            }
            if (Intrinsics.g(cls3, cls2)) {
                return new ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && Intrinsics.g(parameterTypes[0], cls2) && Intrinsics.g(parameterTypes[1], cls)) {
            return new ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    private static final int d(Class<?> cls, int i2) {
        Class<? super Object> superclass;
        do {
            Field[] declaredFields = r5.getDeclaredFields();
            int length = declaredFields.length;
            int i3 = 0;
            Class<? super Object> cls2 = cls;
            for (int i4 = 0; i4 < length; i4++) {
                if (!Modifier.isStatic(declaredFields[i4].getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return i2;
    }

    static /* synthetic */ int e(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return d(cls, i2);
    }

    private static final int f(Class<?> cls, int i2) {
        Integer num;
        JvmClassMappingKt.i(cls);
        try {
            Result.Companion companion = Result.X;
            num = Result.b(Integer.valueOf(e(cls, 0, 1, (Object) null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            num = Result.b(ResultKt.a(th));
        }
        Integer valueOf = Integer.valueOf(i2);
        if (Result.i(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    private static final Function1<Throwable, Throwable> g(Function1<? super Throwable, ? extends Throwable> function1) {
        return new ExceptionsConstructorKt$safeCtor$1(function1);
    }

    @Nullable
    public static final <E extends Throwable> E h(@NotNull E e2) {
        E e3;
        if (!(e2 instanceof CopyableThrowable)) {
            return (Throwable) f29344b.a(e2.getClass()).f(e2);
        }
        try {
            Result.Companion companion = Result.X;
            e3 = Result.b(((CopyableThrowable) e2).a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            e3 = Result.b(ResultKt.a(th));
        }
        if (Result.i(e3)) {
            e3 = null;
        }
        return (Throwable) e3;
    }
}
