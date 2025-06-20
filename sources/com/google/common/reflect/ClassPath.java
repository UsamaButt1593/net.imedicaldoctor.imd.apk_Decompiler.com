package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

@ElementTypesAreNonnullByDefault
public final class ClassPath {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f22979b = Logger.getLogger(ClassPath.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final Splitter f22980c = Splitter.j(StringUtils.SPACE).g();

    /* renamed from: d  reason: collision with root package name */
    private static final String f22981d = ".class";

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableSet<ResourceInfo> f22982a;

    public static final class ClassInfo extends ResourceInfo {

        /* renamed from: d  reason: collision with root package name */
        private final String f22983d;

        ClassInfo(File file, String str, ClassLoader classLoader) {
            super(file, str, classLoader);
            this.f22983d = ClassPath.e(str);
        }

        public String g() {
            return this.f22983d;
        }

        public String h() {
            return Reflection.b(this.f22983d);
        }

        public String i() {
            int lastIndexOf = this.f22983d.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return CharMatcher.m('0', '9').V(this.f22983d.substring(lastIndexOf + 1));
            }
            String h2 = h();
            return h2.isEmpty() ? this.f22983d : this.f22983d.substring(h2.length() + 1);
        }

        public boolean j() {
            return this.f22983d.indexOf(36) == -1;
        }

        public Class<?> k() {
            try {
                return this.f22988c.loadClass(this.f22983d);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public String toString() {
            return this.f22983d;
        }
    }

    static final class LocationInfo {

        /* renamed from: a  reason: collision with root package name */
        final File f22984a;

        /* renamed from: b  reason: collision with root package name */
        private final ClassLoader f22985b;

        LocationInfo(File file, ClassLoader classLoader) {
            this.f22984a = (File) Preconditions.E(file);
            this.f22985b = (ClassLoader) Preconditions.E(classLoader);
        }

        private void b(File file, Set<File> set, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        c(file, builder);
                    } else {
                        e(file, set, builder);
                    }
                }
            } catch (SecurityException e2) {
                Logger a2 = ClassPath.f22979b;
                a2.warning("Cannot access " + file + ": " + e2);
            }
        }

        private void c(File file, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            HashSet hashSet = new HashSet();
            hashSet.add(file.getCanonicalFile());
            d(file, "", hashSet, builder);
        }

        private void d(File file, String str, Set<File> set, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                ClassPath.f22979b.warning("Cannot read directory " + file);
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isDirectory()) {
                    File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        d(canonicalFile, str + name + "/", set, builder);
                        set.remove(canonicalFile);
                    }
                } else {
                    String str2 = str + name;
                    if (!str2.equals("META-INF/MANIFEST.MF")) {
                        builder.g(ResourceInfo.e(file2, str2, this.f22985b));
                    }
                }
            }
        }

        private void e(File file, Set<File> set, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    UnmodifiableIterator<File> k2 = ClassPath.h(file, jarFile.getManifest()).iterator();
                    while (k2.hasNext()) {
                        File next = k2.next();
                        if (set.add(next.getCanonicalFile())) {
                            b(next, set, builder);
                        }
                    }
                    f(jarFile, builder);
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                } finally {
                    try {
                        jarFile.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (IOException unused3) {
            }
        }

        private void f(JarFile jarFile, ImmutableSet.Builder<ResourceInfo> builder) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().equals("META-INF/MANIFEST.MF")) {
                    builder.g(ResourceInfo.e(new File(jarFile.getName()), nextElement.getName(), this.f22985b));
                }
            }
        }

        public final File a() {
            return this.f22984a;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof LocationInfo)) {
                return false;
            }
            LocationInfo locationInfo = (LocationInfo) obj;
            return this.f22984a.equals(locationInfo.f22984a) && this.f22985b.equals(locationInfo.f22985b);
        }

        public ImmutableSet<ResourceInfo> g() throws IOException {
            return h(new HashSet());
        }

        public ImmutableSet<ResourceInfo> h(Set<File> set) throws IOException {
            ImmutableSet.Builder r = ImmutableSet.r();
            set.add(this.f22984a);
            b(this.f22984a, set, r);
            return r.e();
        }

        public int hashCode() {
            return this.f22984a.hashCode();
        }

        public String toString() {
            return this.f22984a.toString();
        }
    }

    public static class ResourceInfo {

        /* renamed from: a  reason: collision with root package name */
        private final File f22986a;

        /* renamed from: b  reason: collision with root package name */
        private final String f22987b;

        /* renamed from: c  reason: collision with root package name */
        final ClassLoader f22988c;

        ResourceInfo(File file, String str, ClassLoader classLoader) {
            this.f22986a = (File) Preconditions.E(file);
            this.f22987b = (String) Preconditions.E(str);
            this.f22988c = (ClassLoader) Preconditions.E(classLoader);
        }

        static ResourceInfo e(File file, String str, ClassLoader classLoader) {
            return str.endsWith(ClassPath.f22981d) ? new ClassInfo(file, str, classLoader) : new ResourceInfo(file, str, classLoader);
        }

        public final ByteSource a() {
            return Resources.a(f());
        }

        public final CharSource b(Charset charset) {
            return Resources.b(f(), charset);
        }

        /* access modifiers changed from: package-private */
        public final File c() {
            return this.f22986a;
        }

        public final String d() {
            return this.f22987b;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ResourceInfo)) {
                return false;
            }
            ResourceInfo resourceInfo = (ResourceInfo) obj;
            return this.f22987b.equals(resourceInfo.f22987b) && this.f22988c == resourceInfo.f22988c;
        }

        public final URL f() {
            URL resource = this.f22988c.getResource(this.f22987b);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.f22987b);
        }

        public int hashCode() {
            return this.f22987b.hashCode();
        }

        public String toString() {
            return this.f22987b;
        }
    }

    private ClassPath(ImmutableSet<ResourceInfo> immutableSet) {
        this.f22982a = immutableSet;
    }

    public static ClassPath b(ClassLoader classLoader) throws IOException {
        ImmutableSet<LocationInfo> m2 = m(classLoader);
        HashSet hashSet = new HashSet();
        UnmodifiableIterator<LocationInfo> k2 = m2.iterator();
        while (k2.hasNext()) {
            hashSet.add(k2.next().a());
        }
        ImmutableSet.Builder r = ImmutableSet.r();
        UnmodifiableIterator<LocationInfo> k3 = m2.iterator();
        while (k3.hasNext()) {
            r.c(k3.next().h(hashSet));
        }
        return new ClassPath(r.e());
    }

    private static ImmutableList<URL> d(ClassLoader classLoader) {
        if (classLoader instanceof URLClassLoader) {
            return ImmutableList.D(((URLClassLoader) classLoader).getURLs());
        }
        return classLoader.equals(ClassLoader.getSystemClassLoader()) ? n() : ImmutableList.I();
    }

    @VisibleForTesting
    static String e(String str) {
        return str.substring(0, str.length() - 6).replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @VisibleForTesting
    static ImmutableMap<File, ClassLoader> f(ClassLoader classLoader) {
        LinkedHashMap c0 = Maps.c0();
        ClassLoader parent = classLoader.getParent();
        if (parent != null) {
            c0.putAll(f(parent));
        }
        UnmodifiableIterator<URL> k2 = d(classLoader).iterator();
        while (k2.hasNext()) {
            URL next = k2.next();
            if (next.getProtocol().equals(Annotation.k3)) {
                File o = o(next);
                if (!c0.containsKey(o)) {
                    c0.put(o, classLoader);
                }
            }
        }
        return ImmutableMap.g(c0);
    }

    @VisibleForTesting
    static URL g(File file, String str) throws MalformedURLException {
        return new URL(file.toURI().toURL(), str);
    }

    @VisibleForTesting
    static ImmutableSet<File> h(File file, @CheckForNull Manifest manifest) {
        if (manifest == null) {
            return ImmutableSet.K();
        }
        ImmutableSet.Builder r = ImmutableSet.r();
        String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
        if (value != null) {
            for (String next : f22980c.n(value)) {
                try {
                    URL g2 = g(file, next);
                    if (g2.getProtocol().equals(Annotation.k3)) {
                        r.g(o(g2));
                    }
                } catch (MalformedURLException unused) {
                    Logger logger = f22979b;
                    logger.warning("Invalid Class-Path entry: " + next);
                }
            }
        }
        return r.e();
    }

    static ImmutableSet<LocationInfo> m(ClassLoader classLoader) {
        ImmutableSet.Builder r = ImmutableSet.r();
        UnmodifiableIterator<Map.Entry<File, ClassLoader>> k2 = f(classLoader).entrySet().iterator();
        while (k2.hasNext()) {
            Map.Entry next = k2.next();
            r.g(new LocationInfo((File) next.getKey(), (ClassLoader) next.getValue()));
        }
        return r.e();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:3|4|5|7|8|15|12|1) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0039, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0050, code lost:
        r4 = f22979b;
        r5 = java.util.logging.Level.WARNING;
        r4.log(r5, "malformed classpath entry: " + r2, r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003b */
    @com.google.common.annotations.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.common.collect.ImmutableList<java.net.URL> n() {
        /*
            com.google.common.collect.ImmutableList$Builder r0 = com.google.common.collect.ImmutableList.r()
            com.google.common.base.StandardSystemProperty r1 = com.google.common.base.StandardSystemProperty.PATH_SEPARATOR
            java.lang.String r1 = r1.c()
            com.google.common.base.Splitter r1 = com.google.common.base.Splitter.j(r1)
            com.google.common.base.StandardSystemProperty r2 = com.google.common.base.StandardSystemProperty.JAVA_CLASS_PATH
            java.lang.String r2 = r2.c()
            java.lang.Iterable r1 = r1.n(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x001c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0069
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.io.File r3 = new java.io.File     // Catch:{ SecurityException -> 0x003b }
            r3.<init>(r2)     // Catch:{ SecurityException -> 0x003b }
            java.net.URI r3 = r3.toURI()     // Catch:{ SecurityException -> 0x003b }
            java.net.URL r3 = r3.toURL()     // Catch:{ SecurityException -> 0x003b }
            r0.g(r3)     // Catch:{ SecurityException -> 0x003b }
            goto L_0x001c
        L_0x0039:
            r3 = move-exception
            goto L_0x0050
        L_0x003b:
            java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0039 }
            java.lang.String r4 = "file"
            java.io.File r5 = new java.io.File     // Catch:{ MalformedURLException -> 0x0039 }
            r5.<init>(r2)     // Catch:{ MalformedURLException -> 0x0039 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ MalformedURLException -> 0x0039 }
            r6 = 0
            r3.<init>(r4, r6, r5)     // Catch:{ MalformedURLException -> 0x0039 }
            r0.g(r3)     // Catch:{ MalformedURLException -> 0x0039 }
            goto L_0x001c
        L_0x0050:
            java.util.logging.Logger r4 = f22979b
            java.util.logging.Level r5 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "malformed classpath entry: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r4.log(r5, r2, r3)
            goto L_0x001c
        L_0x0069:
            com.google.common.collect.ImmutableList r0 = r0.e()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.ClassPath.n():com.google.common.collect.ImmutableList");
    }

    @VisibleForTesting
    static File o(URL url) {
        Preconditions.d(url.getProtocol().equals(Annotation.k3));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }

    public ImmutableSet<ClassInfo> c() {
        return FluentIterable.D(this.f22982a).x(ClassInfo.class).V();
    }

    public ImmutableSet<ResourceInfo> i() {
        return this.f22982a;
    }

    public ImmutableSet<ClassInfo> j() {
        return FluentIterable.D(this.f22982a).x(ClassInfo.class).t(new a()).V();
    }

    public ImmutableSet<ClassInfo> k(String str) {
        Preconditions.E(str);
        ImmutableSet.Builder r = ImmutableSet.r();
        UnmodifiableIterator<ClassInfo> k2 = j().iterator();
        while (k2.hasNext()) {
            ClassInfo next = k2.next();
            if (next.h().equals(str)) {
                r.g(next);
            }
        }
        return r.e();
    }

    public ImmutableSet<ClassInfo> l(String str) {
        Preconditions.E(str);
        String str2 = str + ClassUtils.PACKAGE_SEPARATOR_CHAR;
        ImmutableSet.Builder r = ImmutableSet.r();
        UnmodifiableIterator<ClassInfo> k2 = j().iterator();
        while (k2.hasNext()) {
            ClassInfo next = k2.next();
            if (next.g().startsWith(str2)) {
                r.g(next);
            }
        }
        return r.e();
    }
}
