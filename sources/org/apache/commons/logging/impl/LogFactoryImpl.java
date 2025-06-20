package org.apache.commons.logging.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

public class LogFactoryImpl extends LogFactory {
    private static final String LOG_INTERFACE = "org.apache.commons.logging.Log";
    public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
    protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$commons$logging$LogFactory;
    protected Hashtable attributes = new Hashtable();
    protected Hashtable instances = new Hashtable();
    private String logClassName;
    protected Constructor logConstructor = null;
    protected Class[] logConstructorSignature;
    protected Method logMethod;
    protected Class[] logMethodSignature;

    public LogFactoryImpl() {
        Class cls = class$java$lang$String;
        if (cls == null) {
            cls = class$("java.lang.String");
            class$java$lang$String = cls;
        }
        this.logConstructorSignature = new Class[]{cls};
        this.logMethod = null;
        Class cls2 = class$org$apache$commons$logging$LogFactory;
        if (cls2 == null) {
            cls2 = class$(LogFactory.FACTORY_PROPERTY);
            class$org$apache$commons$logging$LogFactory = cls2;
        }
        this.logMethodSignature = new Class[]{cls2};
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private static Class loadClass(final String str) throws ClassNotFoundException {
        Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction() {
            /* JADX WARNING: Can't wrap try/catch for region: R(5:0|(3:2|3|4)|5|6|7) */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
                return r0;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object run() {
                /*
                    r2 = this;
                    java.lang.ClassLoader r0 = org.apache.commons.logging.LogFactory.getContextClassLoader()
                    if (r0 == 0) goto L_0x000d
                    java.lang.String r1 = r1     // Catch:{ ClassNotFoundException -> 0x000d }
                    java.lang.Class r0 = r0.loadClass(r1)     // Catch:{ ClassNotFoundException -> 0x000d }
                    return r0
                L_0x000d:
                    java.lang.String r0 = r1     // Catch:{ ClassNotFoundException -> 0x0014 }
                    java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0014 }
                    return r0
                L_0x0014:
                    r0 = move-exception
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.LogFactoryImpl.AnonymousClass1.run():java.lang.Object");
            }
        });
        if (doPrivileged instanceof Class) {
            return (Class) doPrivileged;
        }
        throw ((ClassNotFoundException) doPrivileged);
    }

    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    public String[] getAttributeNames() {
        Vector vector = new Vector();
        Enumeration keys = this.attributes.keys();
        while (keys.hasMoreElements()) {
            vector.addElement((String) keys.nextElement());
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    public Log getInstance(Class cls) throws LogConfigurationException {
        return getInstance(cls.getName());
    }

    /* access modifiers changed from: protected */
    public String getLogClassName() {
        String str = this.logClassName;
        if (str != null) {
            return str;
        }
        String str2 = (String) getAttribute("org.apache.commons.logging.Log");
        this.logClassName = str2;
        if (str2 == null) {
            this.logClassName = (String) getAttribute(LOG_PROPERTY_OLD);
        }
        if (this.logClassName == null) {
            try {
                this.logClassName = System.getProperty("org.apache.commons.logging.Log");
            } catch (SecurityException unused) {
            }
        }
        if (this.logClassName == null) {
            try {
                this.logClassName = System.getProperty(LOG_PROPERTY_OLD);
            } catch (SecurityException unused2) {
            }
        }
        if (this.logClassName == null && isLog4JAvailable()) {
            this.logClassName = "org.apache.commons.logging.impl.Log4JLogger";
        }
        if (this.logClassName == null && isJdk14Available()) {
            this.logClassName = "org.apache.commons.logging.impl.Jdk14Logger";
        }
        if (this.logClassName == null && isJdk13LumberjackAvailable()) {
            this.logClassName = "org.apache.commons.logging.impl.Jdk13LumberjackLogger";
        }
        if (this.logClassName == null) {
            this.logClassName = "org.apache.commons.logging.impl.SimpleLog";
        }
        return this.logClassName;
    }

    /* access modifiers changed from: protected */
    public Constructor getLogConstructor() throws LogConfigurationException {
        Constructor constructor = this.logConstructor;
        if (constructor != null) {
            return constructor;
        }
        String logClassName2 = getLogClassName();
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass("org.apache.commons.logging.Log");
            Class loadClass2 = loadClass(logClassName2);
            if (loadClass2 == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("No suitable Log implementation for ");
                stringBuffer.append(logClassName2);
                throw new LogConfigurationException(stringBuffer.toString());
            } else if (!loadClass.isAssignableFrom(loadClass2)) {
                Class[] interfaces = loadClass2.getInterfaces();
                int i2 = 0;
                while (i2 < interfaces.length) {
                    if (!"org.apache.commons.logging.Log".equals(interfaces[i2].getName())) {
                        i2++;
                    } else {
                        throw new LogConfigurationException("Invalid class loader hierarchy.  You have more than one version of 'org.apache.commons.logging.Log' visible, which is not allowed.");
                    }
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Class ");
                stringBuffer2.append(logClassName2);
                stringBuffer2.append(" does not implement '");
                stringBuffer2.append("org.apache.commons.logging.Log");
                stringBuffer2.append("'.");
                throw new LogConfigurationException(stringBuffer2.toString());
            } else {
                try {
                    this.logMethod = loadClass2.getMethod("setLogFactory", this.logMethodSignature);
                } catch (Throwable unused) {
                    this.logMethod = null;
                }
                try {
                    Constructor constructor2 = loadClass2.getConstructor(this.logConstructorSignature);
                    this.logConstructor = constructor2;
                    return constructor2;
                } catch (Throwable th) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("No suitable Log constructor ");
                    stringBuffer3.append(this.logConstructorSignature);
                    stringBuffer3.append(" for ");
                    stringBuffer3.append(logClassName2);
                    throw new LogConfigurationException(stringBuffer3.toString(), th);
                }
            }
        } catch (Throwable th2) {
            throw new LogConfigurationException(th2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isJdk13LumberjackAvailable() {
        try {
            loadClass("java.util.logging.Logger");
            loadClass("org.apache.commons.logging.impl.Jdk13LumberjackLogger");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isJdk14Available() {
        try {
            loadClass("java.util.logging.Logger");
            loadClass("org.apache.commons.logging.impl.Jdk14Logger");
            return loadClass("java.lang.Throwable").getDeclaredMethod("getStackTrace", (Class[]) null) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isLog4JAvailable() {
        try {
            loadClass("org.apache.log4j.Logger");
            loadClass("org.apache.commons.logging.impl.Log4JLogger");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Log newInstance(String str) throws LogConfigurationException {
        try {
            Object[] objArr = {str};
            Log log = (Log) getLogConstructor().newInstance(objArr);
            Method method = this.logMethod;
            if (method != null) {
                objArr[0] = this;
                method.invoke(log, objArr);
            }
            return log;
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException != null) {
                throw new LogConfigurationException(targetException);
            }
            throw new LogConfigurationException((Throwable) e2);
        } catch (Throwable th) {
            throw new LogConfigurationException(th);
        }
    }

    public void release() {
        this.instances.clear();
    }

    public void removeAttribute(String str) {
        this.attributes.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        if (obj == null) {
            this.attributes.remove(str);
        } else {
            this.attributes.put(str, obj);
        }
    }

    public Log getInstance(String str) throws LogConfigurationException {
        Log log = (Log) this.instances.get(str);
        if (log != null) {
            return log;
        }
        Log newInstance = newInstance(str);
        this.instances.put(str, newInstance);
        return newInstance;
    }
}
