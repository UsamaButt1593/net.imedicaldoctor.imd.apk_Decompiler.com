package org.apache.commons.lang3.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class ExceptionUtils {
    private static final String[] CAUSE_METHOD_NAMES = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    static final String WRAPPED_MARKER = " [wrapped] ";

    @Deprecated
    public static Throwable getCause(Throwable th) {
        return getCause(th, CAUSE_METHOD_NAMES);
    }

    private static Throwable getCauseUsingMethodName(Throwable th, String str) {
        Method method;
        try {
            method = th.getClass().getMethod(str, (Class[]) null);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
            try {
                return (Throwable) method.invoke(th, (Object[]) null);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            }
        }
        return null;
    }

    @Deprecated
    public static String[] getDefaultCauseMethodNames() {
        return (String[]) ArrayUtils.clone((T[]) CAUSE_METHOD_NAMES);
    }

    public static String getMessage(Throwable th) {
        if (th == null) {
            return "";
        }
        String shortClassName = ClassUtils.getShortClassName(th, (String) null);
        String message = th.getMessage();
        return shortClassName + ": " + StringUtils.defaultString(message);
    }

    public static Throwable getRootCause(Throwable th) {
        List<Throwable> throwableList = getThrowableList(th);
        if (throwableList.size() < 2) {
            return null;
        }
        return throwableList.get(throwableList.size() - 1);
    }

    public static String getRootCauseMessage(Throwable th) {
        Throwable rootCause = getRootCause(th);
        if (rootCause != null) {
            th = rootCause;
        }
        return getMessage(th);
    }

    public static String[] getRootCauseStackTrace(Throwable th) {
        List<String> list;
        String str;
        if (th == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] throwables = getThrowables(th);
        int length = throwables.length;
        ArrayList arrayList = new ArrayList();
        int i2 = length - 1;
        List<String> stackFrameList = getStackFrameList(throwables[i2]);
        while (true) {
            int i3 = length - 1;
            if (i3 < 0) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (i3 != 0) {
                list = getStackFrameList(throwables[length - 2]);
                removeCommonFrames(stackFrameList, list);
            } else {
                list = stackFrameList;
            }
            if (i3 == i2) {
                str = throwables[i3].toString();
            } else {
                str = WRAPPED_MARKER + throwables[i3].toString();
            }
            arrayList.add(str);
            for (int i4 = 0; i4 < stackFrameList.size(); i4++) {
                arrayList.add(stackFrameList.get(i4));
            }
            stackFrameList = list;
            length = i3;
        }
    }

    static List<String> getStackFrameList(Throwable th) {
        StringTokenizer stringTokenizer = new StringTokenizer(getStackTrace(th), SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().isEmpty()) {
                arrayList.add(nextToken);
                z = true;
            } else if (z) {
                break;
            }
        }
        return arrayList;
    }

    static String[] getStackFrames(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static int getThrowableCount(Throwable th) {
        return getThrowableList(th).size();
    }

    public static List<Throwable> getThrowableList(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = getCause(th);
        }
        return arrayList;
    }

    public static Throwable[] getThrowables(Throwable th) {
        List<Throwable> throwableList = getThrowableList(th);
        return (Throwable[]) throwableList.toArray(new Throwable[throwableList.size()]);
    }

    private static int indexOf(Throwable th, Class<?> cls, int i2, boolean z) {
        if (!(th == null || cls == null)) {
            if (i2 < 0) {
                i2 = 0;
            }
            Throwable[] throwables = getThrowables(th);
            if (i2 >= throwables.length) {
                return -1;
            }
            if (z) {
                while (i2 < throwables.length) {
                    if (cls.isAssignableFrom(throwables[i2].getClass())) {
                        return i2;
                    }
                    i2++;
                }
            } else {
                while (i2 < throwables.length) {
                    if (cls.equals(throwables[i2].getClass())) {
                        return i2;
                    }
                    i2++;
                }
            }
        }
        return -1;
    }

    public static int indexOfThrowable(Throwable th, Class<?> cls) {
        return indexOf(th, cls, 0, false);
    }

    public static int indexOfType(Throwable th, Class<?> cls) {
        return indexOf(th, cls, 0, true);
    }

    public static void printRootCauseStackTrace(Throwable th) {
        printRootCauseStackTrace(th, System.err);
    }

    public static void removeCommonFrames(List<String> list, List<String> list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int size = list.size() - 1;
        int size2 = list2.size() - 1;
        while (size >= 0 && size2 >= 0) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
            size2--;
        }
    }

    @Deprecated
    public static Throwable getCause(Throwable th, String[] strArr) {
        Throwable causeUsingMethodName;
        if (th == null) {
            return null;
        }
        if (strArr == null) {
            strArr = CAUSE_METHOD_NAMES;
        }
        for (String str : strArr) {
            if (str != null && (causeUsingMethodName = getCauseUsingMethodName(th, str)) != null) {
                return causeUsingMethodName;
            }
        }
        return null;
    }

    public static String[] getStackFrames(Throwable th) {
        return th == null ? ArrayUtils.EMPTY_STRING_ARRAY : getStackFrames(getStackTrace(th));
    }

    public static int indexOfThrowable(Throwable th, Class<?> cls, int i2) {
        return indexOf(th, cls, i2, false);
    }

    public static int indexOfType(Throwable th, Class<?> cls, int i2) {
        return indexOf(th, cls, i2, true);
    }

    public static void printRootCauseStackTrace(Throwable th, PrintStream printStream) {
        if (th != null) {
            if (printStream != null) {
                for (String println : getRootCauseStackTrace(th)) {
                    printStream.println(println);
                }
                printStream.flush();
                return;
            }
            throw new IllegalArgumentException("The PrintStream must not be null");
        }
    }

    public static void printRootCauseStackTrace(Throwable th, PrintWriter printWriter) {
        if (th != null) {
            if (printWriter != null) {
                for (String println : getRootCauseStackTrace(th)) {
                    printWriter.println(println);
                }
                printWriter.flush();
                return;
            }
            throw new IllegalArgumentException("The PrintWriter must not be null");
        }
    }
}
