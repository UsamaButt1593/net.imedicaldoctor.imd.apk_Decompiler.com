package org.apache.commons.logging.impl;

import com.itextpdf.text.pdf.PdfBoolean;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import org.apache.commons.logging.Log;

public class SimpleLog implements Log, Serializable {
    protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_FATAL = 6;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_OFF = 7;
    public static final int LOG_LEVEL_TRACE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    static /* synthetic */ Class class$java$lang$Thread = null;
    static /* synthetic */ Class class$org$apache$commons$logging$impl$SimpleLog = null;
    protected static DateFormat dateFormatter = null;
    protected static String dateTimeFormat = null;
    protected static boolean showDateTime = false;
    protected static boolean showLogName = false;
    protected static boolean showShortName = false;
    protected static final Properties simpleLogProps;
    protected static final String systemPrefix = "org.apache.commons.logging.simplelog.";
    protected int currentLogLevel;
    protected String logName;
    private String shortLogName = null;

    static {
        Properties properties = new Properties();
        simpleLogProps = properties;
        showLogName = false;
        showShortName = true;
        showDateTime = false;
        dateTimeFormat = DEFAULT_DATE_TIME_FORMAT;
        dateFormatter = null;
        InputStream resourceAsStream = getResourceAsStream("simplelog.properties");
        if (resourceAsStream != null) {
            try {
                properties.load(resourceAsStream);
                resourceAsStream.close();
            } catch (IOException unused) {
            }
        }
        showLogName = getBooleanProperty("org.apache.commons.logging.simplelog.showlogname", showLogName);
        showShortName = getBooleanProperty("org.apache.commons.logging.simplelog.showShortLogname", showShortName);
        boolean booleanProperty = getBooleanProperty("org.apache.commons.logging.simplelog.showdatetime", showDateTime);
        showDateTime = booleanProperty;
        if (booleanProperty) {
            dateTimeFormat = getStringProperty("org.apache.commons.logging.simplelog.dateTimeFormat", dateTimeFormat);
            try {
                dateFormatter = new SimpleDateFormat(dateTimeFormat);
            } catch (IllegalArgumentException unused2) {
                dateTimeFormat = DEFAULT_DATE_TIME_FORMAT;
                dateFormatter = new SimpleDateFormat(dateTimeFormat);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SimpleLog(java.lang.String r8) {
        /*
            r7 = this;
            r7.<init>()
            r0 = 0
            r7.shortLogName = r0
            r7.logName = r8
            r0 = 3
            r7.setLevel(r0)
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = "org.apache.commons.logging.simplelog.log."
            r1.append(r2)
            java.lang.String r3 = r7.logName
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = getStringProperty(r1)
            java.lang.String r3 = java.lang.String.valueOf(r8)
            java.lang.String r4 = "."
        L_0x0029:
            int r3 = r3.lastIndexOf(r4)
            r5 = 0
            if (r1 != 0) goto L_0x0050
            r6 = -1
            if (r3 > r6) goto L_0x0034
            goto L_0x0050
        L_0x0034:
            java.lang.String r8 = r8.substring(r5, r3)
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = getStringProperty(r1)
            java.lang.String r3 = java.lang.String.valueOf(r8)
            goto L_0x0029
        L_0x0050:
            if (r1 != 0) goto L_0x0058
            java.lang.String r8 = "org.apache.commons.logging.simplelog.defaultlog"
            java.lang.String r1 = getStringProperty(r8)
        L_0x0058:
            java.lang.String r8 = "all"
            boolean r8 = r8.equalsIgnoreCase(r1)
            if (r8 == 0) goto L_0x0064
            r7.setLevel(r5)
            goto L_0x00af
        L_0x0064:
            java.lang.String r8 = "trace"
            boolean r8 = r8.equalsIgnoreCase(r1)
            if (r8 == 0) goto L_0x0071
            r8 = 1
        L_0x006d:
            r7.setLevel(r8)
            goto L_0x00af
        L_0x0071:
            java.lang.String r8 = "debug"
            boolean r8 = r8.equalsIgnoreCase(r1)
            if (r8 == 0) goto L_0x007b
            r8 = 2
            goto L_0x006d
        L_0x007b:
            java.lang.String r8 = "info"
            boolean r8 = r8.equalsIgnoreCase(r1)
            if (r8 == 0) goto L_0x0087
            r7.setLevel(r0)
            goto L_0x00af
        L_0x0087:
            java.lang.String r8 = "warn"
            boolean r8 = r8.equalsIgnoreCase(r1)
            if (r8 == 0) goto L_0x0091
            r8 = 4
            goto L_0x006d
        L_0x0091:
            java.lang.String r8 = "error"
            boolean r8 = r8.equalsIgnoreCase(r1)
            if (r8 == 0) goto L_0x009b
            r8 = 5
            goto L_0x006d
        L_0x009b:
            java.lang.String r8 = "fatal"
            boolean r8 = r8.equalsIgnoreCase(r1)
            if (r8 == 0) goto L_0x00a5
            r8 = 6
            goto L_0x006d
        L_0x00a5:
            java.lang.String r8 = "off"
            boolean r8 = r8.equalsIgnoreCase(r1)
            if (r8 == 0) goto L_0x00af
            r8 = 7
            goto L_0x006d
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.SimpleLog.<init>(java.lang.String):void");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private static boolean getBooleanProperty(String str, boolean z) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? z : PdfBoolean.l3.equalsIgnoreCase(stringProperty);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:? A[ExcHandler: NoSuchMethodException (unused java.lang.NoSuchMethodException), SYNTHETIC, Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.ClassLoader getContextClassLoader() {
        /*
            r0 = 0
            java.lang.Class r1 = class$java$lang$Thread     // Catch:{ NoSuchMethodException -> 0x0021 }
            if (r1 != 0) goto L_0x000d
            java.lang.String r1 = "java.lang.Thread"
            java.lang.Class r1 = class$(r1)     // Catch:{ NoSuchMethodException -> 0x0021 }
            class$java$lang$Thread = r1     // Catch:{ NoSuchMethodException -> 0x0021 }
        L_0x000d:
            java.lang.String r2 = "getContextClassLoader"
            java.lang.reflect.Method r1 = r1.getMethod(r2, r0)     // Catch:{ NoSuchMethodException -> 0x0021 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ InvocationTargetException -> 0x001f, NoSuchMethodException -> 0x0021 }
            java.lang.Object r1 = r1.invoke(r2, r0)     // Catch:{ InvocationTargetException -> 0x001f, NoSuchMethodException -> 0x0021 }
            java.lang.ClassLoader r1 = (java.lang.ClassLoader) r1     // Catch:{ InvocationTargetException -> 0x001f, NoSuchMethodException -> 0x0021 }
            r0 = r1
            goto L_0x0038
        L_0x001f:
            r1 = move-exception
            goto L_0x0023
        L_0x0021:
            goto L_0x0038
        L_0x0023:
            java.lang.Throwable r2 = r1.getTargetException()     // Catch:{ NoSuchMethodException -> 0x0021 }
            boolean r2 = r2 instanceof java.lang.SecurityException     // Catch:{ NoSuchMethodException -> 0x0021 }
            if (r2 == 0) goto L_0x002c
            goto L_0x0038
        L_0x002c:
            org.apache.commons.logging.LogConfigurationException r2 = new org.apache.commons.logging.LogConfigurationException     // Catch:{ NoSuchMethodException -> 0x0021 }
            java.lang.String r3 = "Unexpected InvocationTargetException"
            java.lang.Throwable r1 = r1.getTargetException()     // Catch:{ NoSuchMethodException -> 0x0021 }
            r2.<init>(r3, r1)     // Catch:{ NoSuchMethodException -> 0x0021 }
            throw r2     // Catch:{ NoSuchMethodException -> 0x0021 }
        L_0x0038:
            if (r0 != 0) goto L_0x004a
            java.lang.Class r0 = class$org$apache$commons$logging$impl$SimpleLog
            if (r0 != 0) goto L_0x0046
            java.lang.String r0 = "org.apache.commons.logging.impl.SimpleLog"
            java.lang.Class r0 = class$(r0)
            class$org$apache$commons$logging$impl$SimpleLog = r0
        L_0x0046:
            java.lang.ClassLoader r0 = r0.getClassLoader()
        L_0x004a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.SimpleLog.getContextClassLoader():java.lang.ClassLoader");
    }

    private static InputStream getResourceAsStream(final String str) {
        return (InputStream) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                ClassLoader access$000 = SimpleLog.getContextClassLoader();
                return access$000 != null ? access$000.getResourceAsStream(str) : ClassLoader.getSystemResourceAsStream(str);
            }
        });
    }

    private static String getStringProperty(String str) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        return str2 == null ? simpleLogProps.getProperty(str) : str2;
    }

    public final void debug(Object obj) {
        if (isLevelEnabled(2)) {
            log(2, obj, (Throwable) null);
        }
    }

    public final void error(Object obj) {
        if (isLevelEnabled(5)) {
            log(5, obj, (Throwable) null);
        }
    }

    public final void fatal(Object obj) {
        if (isLevelEnabled(6)) {
            log(6, obj, (Throwable) null);
        }
    }

    public int getLevel() {
        return this.currentLogLevel;
    }

    public final void info(Object obj) {
        if (isLevelEnabled(3)) {
            log(3, obj, (Throwable) null);
        }
    }

    public final boolean isDebugEnabled() {
        return isLevelEnabled(2);
    }

    public final boolean isErrorEnabled() {
        return isLevelEnabled(5);
    }

    public final boolean isFatalEnabled() {
        return isLevelEnabled(6);
    }

    public final boolean isInfoEnabled() {
        return isLevelEnabled(3);
    }

    /* access modifiers changed from: protected */
    public boolean isLevelEnabled(int i2) {
        return i2 >= this.currentLogLevel;
    }

    public final boolean isTraceEnabled() {
        return isLevelEnabled(1);
    }

    public final boolean isWarnEnabled() {
        return isLevelEnabled(4);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void log(int r4, java.lang.Object r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            boolean r1 = showDateTime
            if (r1 == 0) goto L_0x001c
            java.text.DateFormat r1 = dateFormatter
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            java.lang.String r1 = r1.format(r2)
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
        L_0x001c:
            switch(r4) {
                case 1: goto L_0x0032;
                case 2: goto L_0x002f;
                case 3: goto L_0x002c;
                case 4: goto L_0x0029;
                case 5: goto L_0x0026;
                case 6: goto L_0x0020;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0035
        L_0x0020:
            java.lang.String r4 = "[FATAL] "
        L_0x0022:
            r0.append(r4)
            goto L_0x0035
        L_0x0026:
            java.lang.String r4 = "[ERROR] "
            goto L_0x0022
        L_0x0029:
            java.lang.String r4 = "[WARN] "
            goto L_0x0022
        L_0x002c:
            java.lang.String r4 = "[INFO] "
            goto L_0x0022
        L_0x002f:
            java.lang.String r4 = "[DEBUG] "
            goto L_0x0022
        L_0x0032:
            java.lang.String r4 = "[TRACE] "
            goto L_0x0022
        L_0x0035:
            boolean r4 = showShortName
            java.lang.String r1 = " - "
            if (r4 == 0) goto L_0x006a
            java.lang.String r4 = r3.shortLogName
            if (r4 != 0) goto L_0x005d
            java.lang.String r4 = r3.logName
            java.lang.String r2 = "."
            int r2 = r4.lastIndexOf(r2)
            int r2 = r2 + 1
            java.lang.String r4 = r4.substring(r2)
            r3.shortLogName = r4
            java.lang.String r2 = "/"
            int r2 = r4.lastIndexOf(r2)
            int r2 = r2 + 1
            java.lang.String r4 = r4.substring(r2)
            r3.shortLogName = r4
        L_0x005d:
            java.lang.String r4 = r3.shortLogName
        L_0x005f:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.append(r4)
            r0.append(r1)
            goto L_0x0071
        L_0x006a:
            boolean r4 = showLogName
            if (r4 == 0) goto L_0x0071
            java.lang.String r4 = r3.logName
            goto L_0x005f
        L_0x0071:
            java.lang.String r4 = java.lang.String.valueOf(r5)
            r0.append(r4)
            if (r6 == 0) goto L_0x00a4
            java.lang.String r4 = " <"
            r0.append(r4)
            java.lang.String r4 = r6.toString()
            r0.append(r4)
            java.lang.String r4 = ">"
            r0.append(r4)
            java.io.StringWriter r4 = new java.io.StringWriter
            r5 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5)
            java.io.PrintWriter r5 = new java.io.PrintWriter
            r5.<init>(r4)
            r6.printStackTrace(r5)
            r5.close()
            java.lang.String r4 = r4.toString()
            r0.append(r4)
        L_0x00a4:
            r3.write(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.SimpleLog.log(int, java.lang.Object, java.lang.Throwable):void");
    }

    public void setLevel(int i2) {
        this.currentLogLevel = i2;
    }

    public final void trace(Object obj) {
        if (isLevelEnabled(1)) {
            log(1, obj, (Throwable) null);
        }
    }

    public final void warn(Object obj) {
        if (isLevelEnabled(4)) {
            log(4, obj, (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    public void write(StringBuffer stringBuffer) {
        System.err.println(stringBuffer.toString());
    }

    private static String getStringProperty(String str, String str2) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? str2 : stringProperty;
    }

    public final void debug(Object obj, Throwable th) {
        if (isLevelEnabled(2)) {
            log(2, obj, th);
        }
    }

    public final void error(Object obj, Throwable th) {
        if (isLevelEnabled(5)) {
            log(5, obj, th);
        }
    }

    public final void fatal(Object obj, Throwable th) {
        if (isLevelEnabled(6)) {
            log(6, obj, th);
        }
    }

    public final void info(Object obj, Throwable th) {
        if (isLevelEnabled(3)) {
            log(3, obj, th);
        }
    }

    public final void trace(Object obj, Throwable th) {
        if (isLevelEnabled(1)) {
            log(1, obj, th);
        }
    }

    public final void warn(Object obj, Throwable th) {
        if (isLevelEnabled(4)) {
            log(4, obj, th);
        }
    }
}
