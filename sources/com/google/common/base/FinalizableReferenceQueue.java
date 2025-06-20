package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.ClassUtils;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public class FinalizableReferenceQueue implements Closeable {
    private static final String X2 = "com.google.common.base.internal.Finalizer";
    private static final Method Y2 = d(e(new SystemLoader(), new DecoupledLoader(), new DirectLoader()));
    /* access modifiers changed from: private */
    public static final Logger Z = Logger.getLogger(FinalizableReferenceQueue.class.getName());
    final PhantomReference<Object> X;
    final boolean Y;
    final ReferenceQueue<Object> s;

    static class DecoupledLoader implements FinalizerLoader {

        /* renamed from: a  reason: collision with root package name */
        private static final String f22262a = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

        DecoupledLoader() {
        }

        @CheckForNull
        public Class<?> a() {
            try {
                return c(b()).loadClass(FinalizableReferenceQueue.X2);
            } catch (Exception e2) {
                FinalizableReferenceQueue.Z.log(Level.WARNING, f22262a, e2);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public URL b() throws IOException {
            String str = FinalizableReferenceQueue.X2.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ".class";
            URL resource = getClass().getClassLoader().getResource(str);
            if (resource != null) {
                String url = resource.toString();
                if (url.endsWith(str)) {
                    return new URL(resource, url.substring(0, url.length() - str.length()));
                }
                throw new IOException("Unsupported path style: " + url);
            }
            throw new FileNotFoundException(str);
        }

        /* access modifiers changed from: package-private */
        public URLClassLoader c(URL url) {
            return new URLClassLoader(new URL[]{url}, (ClassLoader) null);
        }
    }

    static class DirectLoader implements FinalizerLoader {
        DirectLoader() {
        }

        public Class<?> a() {
            try {
                return Class.forName(FinalizableReferenceQueue.X2);
            } catch (ClassNotFoundException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    interface FinalizerLoader {
        @CheckForNull
        Class<?> a();
    }

    static class SystemLoader implements FinalizerLoader {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        static boolean f22263a;

        SystemLoader() {
        }

        @CheckForNull
        public Class<?> a() {
            if (f22263a) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass(FinalizableReferenceQueue.X2);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.Z.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public FinalizableReferenceQueue() {
        boolean z = true;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.s = referenceQueue;
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, referenceQueue);
        this.X = phantomReference;
        try {
            Y2.invoke((Object) null, new Object[]{FinalizableReference.class, referenceQueue, phantomReference});
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (Throwable th) {
            Z.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
            z = false;
        }
        this.Y = z;
    }

    static Method d(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", new Class[]{Class.class, ReferenceQueue.class, PhantomReference.class});
        } catch (NoSuchMethodException e2) {
            throw new AssertionError(e2);
        }
    }

    private static Class<?> e(FinalizerLoader... finalizerLoaderArr) {
        for (FinalizerLoader a2 : finalizerLoaderArr) {
            Class<?> a3 = a2.a();
            if (a3 != null) {
                return a3;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!this.Y) {
            while (true) {
                Reference<? extends Object> poll = this.s.poll();
                if (poll != null) {
                    poll.clear();
                    try {
                        ((FinalizableReference) poll).a();
                    } catch (Throwable th) {
                        Z.log(Level.SEVERE, "Error cleaning up after reference.", th);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void close() {
        this.X.enqueue();
        c();
    }
}
