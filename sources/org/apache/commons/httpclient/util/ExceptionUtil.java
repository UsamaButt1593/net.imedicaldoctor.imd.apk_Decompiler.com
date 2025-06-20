package org.apache.commons.httpclient.util;

import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExceptionUtil {
    private static final Method INIT_CAUSE_METHOD = getInitCauseMethod();
    private static final Log LOG;
    private static final Class SOCKET_TIMEOUT_CLASS = SocketTimeoutExceptionClass();
    static /* synthetic */ Class class$java$lang$Throwable;
    static /* synthetic */ Class class$org$apache$commons$httpclient$util$ExceptionUtil;

    static {
        Class cls = class$org$apache$commons$httpclient$util$ExceptionUtil;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.util.ExceptionUtil");
            class$org$apache$commons$httpclient$util$ExceptionUtil = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    private static Class SocketTimeoutExceptionClass() {
        try {
            return Class.forName("java.net.SocketTimeoutException");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private static Method getInitCauseMethod() {
        try {
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            Class[] clsArr = {cls};
            Class cls2 = class$java$lang$Throwable;
            if (cls2 == null) {
                cls2 = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls2;
            }
            return cls2.getMethod("initCause", clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static void initCause(Throwable th, Throwable th2) {
        Method method = INIT_CAUSE_METHOD;
        if (method != null) {
            try {
                method.invoke(th, new Object[]{th2});
            } catch (Exception e2) {
                LOG.warn("Exception invoking Throwable.initCause", e2);
            }
        }
    }

    public static boolean isSocketTimeoutException(InterruptedIOException interruptedIOException) {
        Class cls = SOCKET_TIMEOUT_CLASS;
        if (cls != null) {
            return cls.isInstance(interruptedIOException);
        }
        return true;
    }
}
