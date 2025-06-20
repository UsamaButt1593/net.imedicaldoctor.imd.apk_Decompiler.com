package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

@SuppressLint({"LogConditional"})
public class Debug {
    public static void a(ViewGroup.LayoutParams layoutParams, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + str2 + "  " + layoutParams.getClass().getName());
        Field[] fields = layoutParams.getClass().getFields();
        for (Field field : fields) {
            try {
                Object obj = field.get(layoutParams);
                String name = field.getName();
                if (name.contains("To")) {
                    if (!obj.toString().equals("-1")) {
                        System.out.println(str2 + "       " + name + StringUtils.SPACE + obj);
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
    }

    public static void b(ViewGroup viewGroup, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + "  ";
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            System.out.println(str2 + "     " + k(childAt));
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Field[] fields = layoutParams.getClass().getFields();
            for (Field field : fields) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To")) {
                        if (!obj.toString().equals("-1")) {
                            System.out.println(str2 + "       " + field.getName() + StringUtils.SPACE + obj);
                        }
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static void c(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
        Class<?> cls = obj.getClass();
        System.out.println(str + "------------- " + cls.getName() + " --------------------");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint")) {
                    if (!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) {
                        if (!(obj2 instanceof Integer) || !obj2.toString().equals("0")) {
                            if (!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) {
                                if (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")) {
                                    System.out.println(str + "    " + field.getName() + StringUtils.SPACE + obj2);
                                }
                            }
                        }
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(str + "------------- " + cls.getSimpleName() + " --------------------");
    }

    public static String d(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Field[] fields = MotionEvent.class.getFields();
        for (Field field : fields) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt((Object) null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String e(int i2) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i2 + 2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String f() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String g() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String h() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String i(Context context, int i2) {
        if (i2 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i2);
        } catch (Exception unused) {
            return "?" + i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = "? " + r6[r1] + org.apache.commons.lang3.StringUtils.SPACE;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String j(android.content.Context r5, int[] r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r0.<init>()     // Catch:{ Exception -> 0x0025 }
            int r1 = r6.length     // Catch:{ Exception -> 0x0025 }
            r0.append(r1)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = "["
            r0.append(r1)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0025 }
            r1 = 0
        L_0x0013:
            int r2 = r6.length     // Catch:{ Exception -> 0x0025 }
            if (r1 >= r2) goto L_0x0062
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r2.<init>()     // Catch:{ Exception -> 0x0025 }
            r2.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = " "
            if (r1 != 0) goto L_0x0027
            java.lang.String r3 = ""
            goto L_0x0028
        L_0x0025:
            r5 = move-exception
            goto L_0x0074
        L_0x0027:
            r3 = r0
        L_0x0028:
            r2.append(r3)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0025 }
            android.content.res.Resources r3 = r5.getResources()     // Catch:{ NotFoundException -> 0x003a }
            r4 = r6[r1]     // Catch:{ NotFoundException -> 0x003a }
            java.lang.String r0 = r3.getResourceEntryName(r4)     // Catch:{ NotFoundException -> 0x003a }
            goto L_0x0050
        L_0x003a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r3.<init>()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r4 = "? "
            r3.append(r4)     // Catch:{ Exception -> 0x0025 }
            r4 = r6[r1]     // Catch:{ Exception -> 0x0025 }
            r3.append(r4)     // Catch:{ Exception -> 0x0025 }
            r3.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0025 }
        L_0x0050:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r3.<init>()     // Catch:{ Exception -> 0x0025 }
            r3.append(r2)     // Catch:{ Exception -> 0x0025 }
            r3.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0025 }
            int r1 = r1 + 1
            goto L_0x0013
        L_0x0062:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r5.<init>()     // Catch:{ Exception -> 0x0025 }
            r5.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r6 = "]"
            r5.append(r6)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0025 }
            return r5
        L_0x0074:
            java.lang.String r6 = "DEBUG"
            java.lang.String r5 = r5.toString()
            android.util.Log.v(r6, r5)
            java.lang.String r5 = "UNKNOWN"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.Debug.j(android.content.Context, int[]):java.lang.String");
    }

    public static String k(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String l(MotionLayout motionLayout, int i2) {
        return m(motionLayout, i2, -1);
    }

    public static String m(MotionLayout motionLayout, int i2, int i3) {
        int length;
        if (i2 == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = motionLayout.getContext().getResources().getResourceEntryName(i2);
        if (i3 == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > i3) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        if (resourceEntryName.length() <= i3 || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) {
            return resourceEntryName;
        }
        int length2 = (resourceEntryName.length() - i3) / length;
        return resourceEntryName.replaceAll(CharBuffer.allocate(length2).toString().replace(0, ClassUtils.PACKAGE_SEPARATOR_CHAR) + "_", "_");
    }

    public static void n(String str, String str2, int i2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i2, stackTrace.length - 1);
        String str3 = StringUtils.SPACE;
        for (int i3 = 1; i3 <= min; i3++) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            str3 = str3 + StringUtils.SPACE;
            Log.v(str, str2 + str3 + (".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") " + stackTrace[i3].getMethodName()) + str3);
        }
    }

    public static void o(String str, int i2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i2, stackTrace.length - 1);
        String str2 = StringUtils.SPACE;
        for (int i3 = 1; i3 <= min; i3++) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            str2 = str2 + StringUtils.SPACE;
            PrintStream printStream = System.out;
            printStream.println(str + str2 + (".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") ") + str2);
        }
    }
}
