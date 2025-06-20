package org.apache.commons.logging;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class LogFactory {
    public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
    public static final String FACTORY_PROPERTIES = "commons-logging.properties";
    public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
    protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
    static /* synthetic */ Class class$java$lang$Thread;
    static /* synthetic */ Class class$org$apache$commons$logging$LogFactory;
    protected static Hashtable factories = new Hashtable();

    protected LogFactory() {
    }

    private static void cacheFactory(ClassLoader classLoader, LogFactory logFactory) {
        if (classLoader != null && logFactory != null) {
            factories.put(classLoader, logFactory);
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private static LogFactory getCachedFactory(ClassLoader classLoader) {
        if (classLoader != null) {
            return (LogFactory) factories.get(classLoader);
        }
        return null;
    }

    protected static ClassLoader getContextClassLoader() throws LogConfigurationException {
        try {
            Class cls = class$java$lang$Thread;
            if (cls == null) {
                cls = class$("java.lang.Thread");
                class$java$lang$Thread = cls;
            }
            return (ClassLoader) cls.getMethod("getContextClassLoader", (Class[]) null).invoke(Thread.currentThread(), (Object[]) null);
        } catch (IllegalAccessException e2) {
            throw new LogConfigurationException("Unexpected IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getTargetException() instanceof SecurityException) {
                return null;
            }
            throw new LogConfigurationException("Unexpected InvocationTargetException", e3.getTargetException());
        } catch (NoSuchMethodException unused) {
            Class cls2 = class$org$apache$commons$logging$LogFactory;
            if (cls2 == null) {
                cls2 = class$(FACTORY_PROPERTY);
                class$org$apache$commons$logging$LogFactory = cls2;
            }
            return cls2.getClassLoader();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:3|4|5|(4:7|8|9|10)|12|13|(1:15)|(4:18|19|20|(6:22|23|25|26|27|(1:31)))|(1:36)|(3:38|(1:40)|41)|(2:43|(3:45|(2:48|46)|50))|49) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:22|23|25|26|27|(1:31)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004e */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[Catch:{ SecurityException -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.commons.logging.LogFactory getFactory() throws org.apache.commons.logging.LogConfigurationException {
        /*
            java.lang.String r0 = "org.apache.commons.logging.LogFactory"
            org.apache.commons.logging.LogFactory$1 r1 = new org.apache.commons.logging.LogFactory$1
            r1.<init>()
            java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)
            java.lang.ClassLoader r1 = (java.lang.ClassLoader) r1
            org.apache.commons.logging.LogFactory r2 = getCachedFactory(r1)
            if (r2 == 0) goto L_0x0014
            return r2
        L_0x0014:
            r3 = 0
            java.lang.String r4 = "commons-logging.properties"
            java.io.InputStream r4 = getResourceAsStream(r1, r4)     // Catch:{ IOException | SecurityException -> 0x0029 }
            if (r4 == 0) goto L_0x0029
            java.util.Properties r5 = new java.util.Properties     // Catch:{ IOException | SecurityException -> 0x0029 }
            r5.<init>()     // Catch:{ IOException | SecurityException -> 0x0029 }
            r5.load(r4)     // Catch:{ IOException | SecurityException -> 0x0028 }
            r4.close()     // Catch:{ IOException | SecurityException -> 0x0028 }
        L_0x0028:
            r3 = r5
        L_0x0029:
            java.lang.String r4 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0034 }
            if (r4 == 0) goto L_0x0035
            org.apache.commons.logging.LogFactory r2 = newFactory(r4, r1)     // Catch:{ SecurityException -> 0x0034 }
            goto L_0x0035
        L_0x0034:
        L_0x0035:
            if (r2 != 0) goto L_0x006d
            java.lang.String r4 = "META-INF/services/org.apache.commons.logging.LogFactory"
            java.io.InputStream r4 = getResourceAsStream(r1, r4)     // Catch:{ Exception -> 0x004c }
            if (r4 == 0) goto L_0x006d
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ UnsupportedEncodingException -> 0x004e }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ UnsupportedEncodingException -> 0x004e }
            java.lang.String r7 = "UTF-8"
            r6.<init>(r4, r7)     // Catch:{ UnsupportedEncodingException -> 0x004e }
            r5.<init>(r6)     // Catch:{ UnsupportedEncodingException -> 0x004e }
            goto L_0x0058
        L_0x004c:
            goto L_0x006d
        L_0x004e:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x004c }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x004c }
            r6.<init>(r4)     // Catch:{ Exception -> 0x004c }
            r5.<init>(r6)     // Catch:{ Exception -> 0x004c }
        L_0x0058:
            java.lang.String r4 = r5.readLine()     // Catch:{ Exception -> 0x004c }
            r5.close()     // Catch:{ Exception -> 0x004c }
            if (r4 == 0) goto L_0x006d
            java.lang.String r5 = ""
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x004c }
            if (r5 != 0) goto L_0x006d
            org.apache.commons.logging.LogFactory r2 = newFactory(r4, r1)     // Catch:{ Exception -> 0x004c }
        L_0x006d:
            if (r2 != 0) goto L_0x007b
            if (r3 == 0) goto L_0x007b
            java.lang.String r4 = r3.getProperty(r0)
            if (r4 == 0) goto L_0x007b
            org.apache.commons.logging.LogFactory r2 = newFactory(r4, r1)
        L_0x007b:
            if (r2 != 0) goto L_0x0091
            java.lang.Class r2 = class$org$apache$commons$logging$LogFactory
            if (r2 != 0) goto L_0x0087
            java.lang.Class r2 = class$(r0)
            class$org$apache$commons$logging$LogFactory = r2
        L_0x0087:
            java.lang.ClassLoader r0 = r2.getClassLoader()
            java.lang.String r2 = "org.apache.commons.logging.impl.LogFactoryImpl"
            org.apache.commons.logging.LogFactory r2 = newFactory(r2, r0)
        L_0x0091:
            if (r2 == 0) goto L_0x00b1
            cacheFactory(r1, r2)
            if (r3 == 0) goto L_0x00b1
            java.util.Enumeration r0 = r3.propertyNames()
        L_0x009c:
            boolean r1 = r0.hasMoreElements()
            if (r1 != 0) goto L_0x00a3
            goto L_0x00b1
        L_0x00a3:
            java.lang.Object r1 = r0.nextElement()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r4 = r3.getProperty(r1)
            r2.setAttribute(r1, r4)
            goto L_0x009c
        L_0x00b1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogFactory.getFactory():org.apache.commons.logging.LogFactory");
    }

    public static Log getLog(Class cls) throws LogConfigurationException {
        return getFactory().getInstance(cls);
    }

    private static InputStream getResourceAsStream(final ClassLoader classLoader, final String str) {
        return (InputStream) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                ClassLoader classLoader = classLoader;
                return classLoader != null ? classLoader.getResourceAsStream(str) : ClassLoader.getSystemResourceAsStream(str);
            }
        });
    }

    protected static LogFactory newFactory(final String str, final ClassLoader classLoader) throws LogConfigurationException {
        Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction() {
            static /* synthetic */ Class class$org$apache$commons$logging$LogFactory;

            static /* synthetic */ Class class$(String str) {
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException e2) {
                    throw new NoClassDefFoundError(e2.getMessage());
                }
            }

            public Object run() {
                Class<?> cls = null;
                try {
                    ClassLoader classLoader = classLoader;
                    if (classLoader != null) {
                        cls = classLoader.loadClass(str);
                        return (LogFactory) cls.newInstance();
                    }
                } catch (ClassNotFoundException e2) {
                    ClassLoader classLoader2 = classLoader;
                    Class cls2 = class$org$apache$commons$logging$LogFactory;
                    if (cls2 == null) {
                        cls2 = class$(LogFactory.FACTORY_PROPERTY);
                        class$org$apache$commons$logging$LogFactory = cls2;
                    }
                    if (classLoader2 == cls2.getClassLoader()) {
                        throw e2;
                    }
                } catch (NoClassDefFoundError e3) {
                    ClassLoader classLoader3 = classLoader;
                    Class cls3 = class$org$apache$commons$logging$LogFactory;
                    if (cls3 == null) {
                        cls3 = class$(LogFactory.FACTORY_PROPERTY);
                        class$org$apache$commons$logging$LogFactory = cls3;
                    }
                    if (classLoader3 == cls3.getClassLoader()) {
                        throw e3;
                    }
                } catch (ClassCastException e4) {
                    ClassLoader classLoader4 = classLoader;
                    Class cls4 = class$org$apache$commons$logging$LogFactory;
                    if (cls4 == null) {
                        cls4 = class$(LogFactory.FACTORY_PROPERTY);
                        class$org$apache$commons$logging$LogFactory = cls4;
                    }
                    if (classLoader4 == cls4.getClassLoader()) {
                        throw e4;
                    }
                } catch (Exception e5) {
                    if (cls != null) {
                        Class cls5 = class$org$apache$commons$logging$LogFactory;
                        if (cls5 == null) {
                            cls5 = class$(LogFactory.FACTORY_PROPERTY);
                            class$org$apache$commons$logging$LogFactory = cls5;
                        }
                        if (!cls5.isAssignableFrom(cls)) {
                            return new LogConfigurationException("The chosen LogFactory implementation does not extend LogFactory. Please check your configuration.", e5);
                        }
                    }
                    return new LogConfigurationException((Throwable) e5);
                }
                return (LogFactory) Class.forName(str).newInstance();
            }
        });
        if (!(doPrivileged instanceof LogConfigurationException)) {
            return (LogFactory) doPrivileged;
        }
        throw ((LogConfigurationException) doPrivileged);
    }

    public static void release(ClassLoader classLoader) {
        synchronized (factories) {
            try {
                LogFactory logFactory = (LogFactory) factories.get(classLoader);
                if (logFactory != null) {
                    logFactory.release();
                    factories.remove(classLoader);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void releaseAll() {
        synchronized (factories) {
            try {
                Enumeration elements = factories.elements();
                while (elements.hasMoreElements()) {
                    ((LogFactory) elements.nextElement()).release();
                }
                factories.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Object getAttribute(String str);

    public abstract String[] getAttributeNames();

    public abstract Log getInstance(Class cls) throws LogConfigurationException;

    public abstract Log getInstance(String str) throws LogConfigurationException;

    public abstract void release();

    public abstract void removeAttribute(String str);

    public abstract void setAttribute(String str, Object obj);

    public static Log getLog(String str) throws LogConfigurationException {
        return getFactory().getInstance(str);
    }
}
