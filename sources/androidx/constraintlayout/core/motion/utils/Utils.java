package androidx.constraintlayout.core.motion.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import org.apache.commons.lang3.StringUtils;

public class Utils {

    /* renamed from: a  reason: collision with root package name */
    static DebugHandle f4052a;

    public interface DebugHandle {
        void a(String str);
    }

    private static int a(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + 255;
    }

    public static void c(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String substring = (stackTraceElement.getMethodName() + "                  ").substring(0, 17);
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")" + "    ".substring(Integer.toString(stackTraceElement.getLineNumber()).length()) + substring;
        System.out.println(str2 + StringUtils.SPACE + str);
        DebugHandle debugHandle = f4052a;
        if (debugHandle != null) {
            debugHandle.a(str2 + StringUtils.SPACE + str);
        }
    }

    public static void d(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(str + " : " + str2);
    }

    public static void e(String str, int i2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i2, stackTrace.length - 1);
        String str2 = StringUtils.SPACE;
        for (int i3 = 1; i3 <= min; i3++) {
            StackTraceElement stackTraceElement = stackTrace[i3];
            str2 = str2 + StringUtils.SPACE;
            PrintStream printStream = System.out;
            printStream.println(str + str2 + (".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") " + stackTrace[i3].getMethodName()) + str2);
        }
    }

    public static void f(String str, String str2) {
        PrintStream printStream = System.err;
        printStream.println(str + " : " + str2);
    }

    public static int g(float f2, float f3, float f4, float f5) {
        int a2 = a((int) (f2 * 255.0f));
        int a3 = a((int) (f3 * 255.0f));
        return (a2 << 16) | (a((int) (f5 * 255.0f)) << 24) | (a3 << 8) | a((int) (f4 * 255.0f));
    }

    public static void h(DebugHandle debugHandle) {
        f4052a = debugHandle;
    }

    public static void i(String str) {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int b(float[] fArr) {
        int a2 = a((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
        int a3 = a((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
        return (a((int) (fArr[3] * 255.0f)) << 24) | (a2 << 16) | (a3 << 8) | a((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f));
    }
}
