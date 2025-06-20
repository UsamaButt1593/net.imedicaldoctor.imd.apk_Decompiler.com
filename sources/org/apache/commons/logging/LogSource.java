package org.apache.commons.logging;

import java.lang.reflect.Constructor;
import java.util.Hashtable;
import org.apache.commons.logging.impl.NoOpLog;

public class LogSource {
    protected static boolean jdk14IsAvailable;
    protected static boolean log4jIsAvailable;
    protected static Constructor logImplctor = null;
    protected static Hashtable logs = new Hashtable();

    /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|5|6|7|10|11|12|(1:14)|16|(3:22|23|(1:25)(2:26|(1:28)(2:29|31)))|18|19|20|21|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003c */
    static {
        /*
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            logs = r0
            r0 = 0
            log4jIsAvailable = r0
            jdk14IsAvailable = r0
            r1 = 0
            logImplctor = r1
            r2 = 1
            java.lang.String r3 = "org.apache.log4j.Logger"
            java.lang.Class.forName(r3)     // Catch:{ all -> 0x0018 }
            log4jIsAvailable = r2     // Catch:{ all -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            log4jIsAvailable = r0
        L_0x001a:
            java.lang.String r3 = "java.util.logging.Logger"
            java.lang.Class.forName(r3)     // Catch:{ all -> 0x0022 }
            jdk14IsAvailable = r2     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            jdk14IsAvailable = r0
        L_0x0024:
            java.lang.String r0 = "org.apache.commons.logging.log"
            java.lang.String r1 = java.lang.System.getProperty(r0)     // Catch:{ all -> 0x0033 }
            if (r1 != 0) goto L_0x0034
            java.lang.String r0 = "org.apache.commons.logging.Log"
            java.lang.String r1 = java.lang.System.getProperty(r0)     // Catch:{ all -> 0x0033 }
            goto L_0x0034
        L_0x0033:
        L_0x0034:
            java.lang.String r0 = "org.apache.commons.logging.impl.NoOpLog"
            if (r1 == 0) goto L_0x0040
        L_0x0038:
            setLogImplementation((java.lang.String) r1)     // Catch:{ all -> 0x003c }
            goto L_0x0051
        L_0x003c:
            setLogImplementation((java.lang.String) r0)     // Catch:{ all -> 0x0051 }
            goto L_0x0051
        L_0x0040:
            boolean r1 = log4jIsAvailable     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = "org.apache.commons.logging.impl.Log4JLogger"
            goto L_0x0038
        L_0x0047:
            boolean r1 = jdk14IsAvailable     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x004e
            java.lang.String r1 = "org.apache.commons.logging.impl.Jdk14Logger"
            goto L_0x0038
        L_0x004e:
            setLogImplementation((java.lang.String) r0)     // Catch:{ all -> 0x003c }
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogSource.<clinit>():void");
    }

    private LogSource() {
    }

    public static Log getInstance(Class cls) {
        return getInstance(cls.getName());
    }

    public static String[] getLogNames() {
        return (String[]) logs.keySet().toArray(new String[logs.size()]);
    }

    public static Log makeNewLogInstance(String str) {
        Log log;
        try {
            log = (Log) logImplctor.newInstance(new Object[]{str});
        } catch (Throwable unused) {
            log = null;
        }
        return log == null ? new NoOpLog(str) : log;
    }

    public static void setLogImplementation(Class cls) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException {
        logImplctor = cls.getConstructor(new Class[]{"".getClass()});
    }

    public static Log getInstance(String str) {
        Log log = (Log) logs.get(str);
        if (log != null) {
            return log;
        }
        Log makeNewLogInstance = makeNewLogInstance(str);
        logs.put(str, makeNewLogInstance);
        return makeNewLogInstance;
    }

    public static void setLogImplementation(String str) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException, ClassNotFoundException {
        try {
            logImplctor = Class.forName(str).getConstructor(new Class[]{"".getClass()});
        } catch (Throwable unused) {
            logImplctor = null;
        }
    }
}
