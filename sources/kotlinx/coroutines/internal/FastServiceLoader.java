package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\b¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J.\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0019*\u00020\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00028\u00000\u001bH\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0000¢\u0006\u0004\b#\u0010$J1\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b%\u0010\u0011R\u0014\u0010'\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010&¨\u0006("}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "<init>", "()V", "Ljava/lang/Class;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "", "serviceClass", "a", "(Ljava/lang/Class;Ljava/lang/String;)Lkotlinx/coroutines/internal/MainDispatcherFactory;", "S", "service", "Ljava/lang/ClassLoader;", "loader", "", "c", "(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List;", "name", "b", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/net/URL;", "url", "f", "(Ljava/net/URL;)Ljava/util/List;", "R", "Ljava/util/jar/JarFile;", "Lkotlin/Function1;", "block", "h", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/io/BufferedReader;", "r", "g", "(Ljava/io/BufferedReader;)Ljava/util/List;", "d", "()Ljava/util/List;", "e", "Ljava/lang/String;", "PREFIX", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FastServiceLoader {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final FastServiceLoader f29345a = new FastServiceLoader();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f29346b = "META-INF/services/";

    private FastServiceLoader() {
    }

    private final MainDispatcherFactory a(Class<MainDispatcherFactory> cls, String str) {
        try {
            return cls.cast(Class.forName(str, true, cls.getClassLoader()).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final <S> S b(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> c(Class<S> cls, ClassLoader classLoader) {
        try {
            return e(cls, classLoader);
        } catch (Throwable unused) {
            return CollectionsKt.S5(ServiceLoader.load(cls, classLoader));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        kotlin.io.CloseableKt.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        kotlin.ExceptionsKt.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0076, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0077, code lost:
        kotlin.io.CloseableKt.a(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> f(java.net.URL r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "jar"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r1 = kotlin.text.StringsKt.s2(r0, r1, r2, r3, r4)
            if (r1 == 0) goto L_0x005c
            java.lang.String r6 = "jar:file:"
            java.lang.String r6 = kotlin.text.StringsKt.n5(r0, r6, r4, r3, r4)
            r1 = 33
            java.lang.String r6 = kotlin.text.StringsKt.u5(r6, r1, r4, r3, r4)
            java.lang.String r1 = "!/"
            java.lang.String r0 = kotlin.text.StringsKt.n5(r0, r1, r4, r3, r4)
            java.util.jar.JarFile r1 = new java.util.jar.JarFile
            r1.<init>(r6, r2)
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x0048 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0048 }
            java.util.zip.ZipEntry r3 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0048 }
            r3.<init>(r0)     // Catch:{ all -> 0x0048 }
            java.io.InputStream r0 = r1.getInputStream(r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r0, r3)     // Catch:{ all -> 0x0048 }
            r6.<init>(r2)     // Catch:{ all -> 0x0048 }
            kotlinx.coroutines.internal.FastServiceLoader r0 = f29345a     // Catch:{ all -> 0x004a }
            java.util.List r0 = r0.g(r6)     // Catch:{ all -> 0x004a }
            kotlin.io.CloseableKt.a(r6, r4)     // Catch:{ all -> 0x0048 }
            r1.close()
            return r0
        L_0x0048:
            r6 = move-exception
            goto L_0x0051
        L_0x004a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r6, r0)     // Catch:{ all -> 0x0048 }
            throw r2     // Catch:{ all -> 0x0048 }
        L_0x0051:
            throw r6     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0057 }
            throw r0
        L_0x0057:
            r0 = move-exception
            kotlin.ExceptionsKt.a(r6, r0)
            throw r6
        L_0x005c:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.io.InputStream r6 = r6.openStream()
            r1.<init>(r6)
            r0.<init>(r1)
            kotlinx.coroutines.internal.FastServiceLoader r6 = f29345a     // Catch:{ all -> 0x0074 }
            java.util.List r6 = r6.g(r0)     // Catch:{ all -> 0x0074 }
            kotlin.io.CloseableKt.a(r0, r4)
            return r6
        L_0x0074:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.f(java.net.URL):java.util.List");
    }

    private final List<String> g(BufferedReader bufferedReader) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return CollectionsKt.S5(linkedHashSet);
            }
            String obj = StringsKt.C5(StringsKt.v5(readLine, "#", (String) null, 2, (Object) null)).toString();
            int i2 = 0;
            while (i2 < obj.length()) {
                char charAt = obj.charAt(i2);
                if (charAt == '.' || Character.isJavaIdentifierPart(charAt)) {
                    i2++;
                } else {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        kotlin.ExceptionsKt.a(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <R> R h(java.util.jar.JarFile r3, kotlin.jvm.functions.Function1<? super java.util.jar.JarFile, ? extends R> r4) {
        /*
            r2 = this;
            r0 = 1
            java.lang.Object r4 = r4.f(r3)     // Catch:{ all -> 0x000f }
            kotlin.jvm.internal.InlineMarker.d(r0)
            r3.close()
            kotlin.jvm.internal.InlineMarker.c(r0)
            return r4
        L_0x000f:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0011 }
        L_0x0011:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r0)
            r3.close()     // Catch:{ all -> 0x001c }
            kotlin.jvm.internal.InlineMarker.c(r0)
            throw r1
        L_0x001c:
            r3 = move-exception
            kotlin.ExceptionsKt.a(r4, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.h(java.util.jar.JarFile, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public final List<MainDispatcherFactory> d() {
        MainDispatcherFactory mainDispatcherFactory;
        Class<MainDispatcherFactory> cls = MainDispatcherFactory.class;
        if (!FastServiceLoaderKt.a()) {
            return c(cls, cls.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = cls.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, cls.getClassLoader()).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = cls.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, cls.getClassLoader()).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 == null) {
                return arrayList;
            }
            arrayList.add(mainDispatcherFactory2);
            return arrayList;
        } catch (Throwable unused3) {
            return c(cls, cls.getClassLoader());
        }
    }

    @NotNull
    public final <S> List<S> e(@NotNull Class<S> cls, @NotNull ClassLoader classLoader) {
        ArrayList<T> list = Collections.list(classLoader.getResources(f29346b + cls.getName()));
        Intrinsics.o(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        for (T f2 : list) {
            CollectionsKt.n0(arrayList, f29345a.f(f2));
        }
        Set<String> X5 = CollectionsKt.X5(arrayList);
        if (!X5.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.Y(X5, 10));
            for (String b2 : X5) {
                arrayList2.add(f29345a.b(b2, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
