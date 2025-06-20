package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {
    private static final long Z2 = 1;
    private static final StackTraceElement[] a3 = new StackTraceElement[0];
    private Key X;
    private String X2;
    private DataSource Y;
    @Nullable
    private Exception Y2;
    private Class<?> Z;
    private final List<Throwable> s;

    private static final class IndentedAppendable implements Appendable {
        private static final String Y = "";
        private static final String Z = "  ";
        private boolean X = true;
        private final Appendable s;

        IndentedAppendable(Appendable appendable) {
            this.s = appendable;
        }

        @NonNull
        private CharSequence a(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public Appendable append(char c2) throws IOException {
            boolean z = false;
            if (this.X) {
                this.X = false;
                this.s.append(Z);
            }
            if (c2 == 10) {
                z = true;
            }
            this.X = z;
            this.s.append(c2);
            return this;
        }

        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        public Appendable append(@Nullable CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.X) {
                this.X = false;
                this.s.append(Z);
            }
            if (a2.length() > 0 && a2.charAt(i3 - 1) == 10) {
                z = true;
            }
            this.X = z;
            this.s.append(a2, i2, i3);
            return this;
        }
    }

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable a2 : ((GlideException) th).e()) {
                a(a2, list);
            }
            return;
        }
        list.add(th);
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).i(appendable);
            } else {
                d(th, appendable);
            }
            i2 = i3;
        }
    }

    private static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void i(Appendable appendable) {
        d(this, appendable);
        b(e(), new IndentedAppendable(appendable));
    }

    public List<Throwable> e() {
        return this.s;
    }

    @Nullable
    public Exception f() {
        return this.Y2;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> g() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public String getMessage() {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.X2);
        String str4 = "";
        if (this.Z != null) {
            str = ", " + this.Z;
        } else {
            str = str4;
        }
        sb.append(str);
        if (this.Y != null) {
            str2 = ", " + this.Y;
        } else {
            str2 = str4;
        }
        sb.append(str2);
        if (this.X != null) {
            str4 = ", " + this.X;
        }
        sb.append(str4);
        List<Throwable> g2 = g();
        if (g2.isEmpty()) {
            return sb.toString();
        }
        if (g2.size() == 1) {
            str3 = "\nThere was 1 cause:";
        } else {
            sb.append("\nThere were ");
            sb.append(g2.size());
            str3 = " causes:";
        }
        sb.append(str3);
        for (Throwable next : g2) {
            sb.append(10);
            sb.append(next.getClass().getName());
            sb.append(ASCIIPropertyListParser.f18649g);
            sb.append(next.getMessage());
            sb.append(ASCIIPropertyListParser.f18650h);
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public void h(String str) {
        List<Throwable> g2 = g();
        int size = g2.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), g2.get(i2));
            i2 = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Key key, DataSource dataSource) {
        k(key, dataSource, (Class<?>) null);
    }

    /* access modifiers changed from: package-private */
    public void k(Key key, DataSource dataSource, Class<?> cls) {
        this.X = key;
        this.Y = dataSource;
        this.Z = cls;
    }

    public void l(@Nullable Exception exc) {
        this.Y2 = exc;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public void printStackTrace(PrintStream printStream) {
        i(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.X2 = str;
        setStackTrace(a3);
        this.s = list;
    }

    public void printStackTrace(PrintWriter printWriter) {
        i(printWriter);
    }
}
