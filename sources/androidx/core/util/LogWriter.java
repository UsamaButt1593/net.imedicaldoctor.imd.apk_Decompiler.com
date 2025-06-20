package androidx.core.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.Writer;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class LogWriter extends Writer {
    private StringBuilder X = new StringBuilder(128);
    private final String s;

    public LogWriter(String str) {
        this.s = str;
    }

    private void b() {
        if (this.X.length() > 0) {
            Log.d(this.s, this.X.toString());
            StringBuilder sb = this.X;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        b();
    }

    public void flush() {
        b();
    }

    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == 10) {
                b();
            } else {
                this.X.append(c2);
            }
        }
    }
}
