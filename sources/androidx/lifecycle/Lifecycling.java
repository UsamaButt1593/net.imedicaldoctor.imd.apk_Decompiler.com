package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import com.itextpdf.tool.xml.html.HTML;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00112\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00152\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00118\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00118\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR$\u0010!\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00110\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010 R2\u0010#\u001a \u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\"0\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010 ¨\u0006$"}, d2 = {"Landroidx/lifecycle/Lifecycling;", "", "<init>", "()V", "object", "Landroidx/lifecycle/LifecycleEventObserver;", "f", "(Ljava/lang/Object;)Landroidx/lifecycle/LifecycleEventObserver;", "Ljava/lang/reflect/Constructor;", "Landroidx/lifecycle/GeneratedAdapter;", "constructor", "a", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)Landroidx/lifecycle/GeneratedAdapter;", "Ljava/lang/Class;", "klass", "b", "(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;", "", "d", "(Ljava/lang/Class;)I", "g", "", "e", "(Ljava/lang/Class;)Z", "", "className", "c", "(Ljava/lang/String;)Ljava/lang/String;", "I", "REFLECTIVE_CALLBACK", "GENERATED_CALLBACK", "", "Ljava/util/Map;", "callbackCache", "", "classToAdapters", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Lifecycling {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Lifecycling f8543a = new Lifecycling();

    /* renamed from: b  reason: collision with root package name */
    private static final int f8544b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f8545c = 2;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Class<?>, Integer> f8546d = new HashMap();
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> f8547e = new HashMap();

    private Lifecycling() {
    }

    private final GeneratedAdapter a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            Object newInstance = constructor.newInstance(new Object[]{obj});
            Intrinsics.o(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return (GeneratedAdapter) newInstance;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private final Constructor<? extends GeneratedAdapter> b(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            Intrinsics.o(name, "fullPackage");
            if (name.length() != 0) {
                Intrinsics.o(canonicalName, "name");
                canonicalName = canonicalName.substring(name.length() + 1);
                Intrinsics.o(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            Intrinsics.o(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String c2 = c(canonicalName);
            if (name.length() != 0) {
                c2 = name + ClassUtils.PACKAGE_SEPARATOR_CHAR + c2;
            }
            Class<?> cls2 = Class.forName(c2);
            Intrinsics.n(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(new Class[]{cls});
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    @JvmStatic
    @NotNull
    public static final String c(@NotNull String str) {
        Intrinsics.p(str, "className");
        return StringsKt.i2(str, ".", "_", false, 4, (Object) null) + "_LifecycleAdapter";
    }

    private final int d(Class<?> cls) {
        Map<Class<?>, Integer> map = f8546d;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g2 = g(cls);
        map.put(cls, Integer.valueOf(g2));
        return g2;
    }

    private final boolean e(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    @JvmStatic
    @NotNull
    public static final LifecycleEventObserver f(@NotNull Object obj) {
        Intrinsics.p(obj, HTML.Tag.G0);
        boolean z = obj instanceof LifecycleEventObserver;
        boolean z2 = obj instanceof DefaultLifecycleObserver;
        if (z && z2) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, (LifecycleEventObserver) obj);
        }
        if (z2) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, (LifecycleEventObserver) null);
        }
        if (z) {
            return (LifecycleEventObserver) obj;
        }
        Class<?> cls = obj.getClass();
        Lifecycling lifecycling = f8543a;
        if (lifecycling.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends GeneratedAdapter>> list = f8547e.get(cls);
        Intrinsics.m(list);
        List list2 = list;
        if (list2.size() == 1) {
            return new SingleGeneratedAdapterObserver(lifecycling.a((Constructor) list2.get(0), obj));
        }
        int size = list2.size();
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
        for (int i2 = 0; i2 < size; i2++) {
            generatedAdapterArr[i2] = f8543a.a((Constructor) list2.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    private final int g(Class<?> cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> b2 = b(cls);
        if (b2 != null) {
            f8547e.put(cls, CollectionsKt.k(b2));
            return 2;
        } else if (ClassesInfoCache.f8498c.d(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            if (e(superclass)) {
                Intrinsics.o(superclass, "superclass");
                if (d(superclass) == 1) {
                    return 1;
                }
                List<Constructor<? extends GeneratedAdapter>> list = f8547e.get(superclass);
                Intrinsics.m(list);
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            Class[] interfaces = cls.getInterfaces();
            Intrinsics.o(interfaces, "klass.interfaces");
            for (Class cls2 : interfaces) {
                if (e(cls2)) {
                    Intrinsics.o(cls2, "intrface");
                    if (d(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    List<Constructor<? extends GeneratedAdapter>> list2 = f8547e.get(cls2);
                    Intrinsics.m(list2);
                    arrayList.addAll(list2);
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f8547e.put(cls, arrayList);
            return 2;
        }
    }
}
