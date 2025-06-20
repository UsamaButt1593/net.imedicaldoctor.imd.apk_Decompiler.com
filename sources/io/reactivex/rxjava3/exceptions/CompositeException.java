package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.annotations.NonNull;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    private static final long Z = 3026362227162912146L;
    private final String X;
    private Throwable Y;
    private final List<Throwable> s;

    static final class ExceptionOverview extends RuntimeException {
        private static final long s = 3875212506787802066L;

        ExceptionOverview(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    static abstract class PrintStreamOrWriter {
        PrintStreamOrWriter() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Object obj);
    }

    static final class WrappedPrintStream extends PrintStreamOrWriter {

        /* renamed from: a  reason: collision with root package name */
        private final PrintStream f28370a;

        WrappedPrintStream(PrintStream printStream) {
            this.f28370a = printStream;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            this.f28370a.println(obj);
        }
    }

    static final class WrappedPrintWriter extends PrintStreamOrWriter {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f28371a;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.f28371a = printWriter;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            this.f28371a.println(obj);
        }
    }

    public CompositeException(@NonNull Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Object obj : iterable) {
                if (obj instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) obj).b());
                } else {
                    linkedHashSet.add(obj == null ? new NullPointerException("Throwable was null!") : obj);
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List<Throwable> unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.s = unmodifiableList;
            this.X = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append(10);
        for (StackTraceElement append : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(append);
            sb.append(10);
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    private void c(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(10);
        }
        int i2 = 1;
        for (Throwable a2 : this.s) {
            sb.append("  ComposedException ");
            sb.append(i2);
            sb.append(" :\n");
            a(sb, a2, "\t");
            i2++;
        }
        printStreamOrWriter.a(sb.toString());
    }

    @NonNull
    public List<Throwable> b() {
        return this.s;
    }

    public int d() {
        return this.s.size();
    }

    @NonNull
    public synchronized Throwable getCause() {
        Throwable th;
        int i2;
        try {
            if (this.Y == null) {
                String property = System.getProperty("line.separator");
                if (this.s.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Multiple exceptions (");
                    sb.append(this.s.size());
                    sb.append(")");
                    sb.append(property);
                    for (Throwable next : this.s) {
                        int i3 = 0;
                        while (true) {
                            if (next == null) {
                                break;
                            }
                            for (int i4 = 0; i4 < i3; i4++) {
                                sb.append("  ");
                            }
                            sb.append("|-- ");
                            sb.append(next.getClass().getCanonicalName());
                            sb.append(": ");
                            String message = next.getMessage();
                            if (message == null || !message.contains(property)) {
                                sb.append(message);
                                sb.append(property);
                            } else {
                                sb.append(property);
                                for (String str : message.split(property)) {
                                    for (int i5 = 0; i5 < i3 + 2; i5++) {
                                        sb.append("  ");
                                    }
                                    sb.append(str);
                                    sb.append(property);
                                }
                            }
                            int i6 = 0;
                            while (true) {
                                i2 = i3 + 2;
                                if (i6 >= i2) {
                                    break;
                                }
                                sb.append("  ");
                                i6++;
                            }
                            StackTraceElement[] stackTrace = next.getStackTrace();
                            if (stackTrace.length > 0) {
                                sb.append("at ");
                                sb.append(stackTrace[0]);
                                sb.append(property);
                            }
                            if (!identityHashMap.containsKey(next)) {
                                identityHashMap.put(next, Boolean.TRUE);
                                next = next.getCause();
                                i3++;
                            } else {
                                Throwable cause = next.getCause();
                                if (cause != null) {
                                    for (int i7 = 0; i7 < i2; i7++) {
                                        sb.append("  ");
                                    }
                                    sb.append("|-- ");
                                    sb.append("(cause not expanded again) ");
                                    sb.append(cause.getClass().getCanonicalName());
                                    sb.append(": ");
                                    sb.append(cause.getMessage());
                                    sb.append(property);
                                }
                            }
                        }
                    }
                    th = new ExceptionOverview(sb.toString().trim());
                } else {
                    th = this.s.get(0);
                }
                this.Y = th;
            }
        } finally {
            while (true) {
            }
        }
        return this.Y;
    }

    @NonNull
    public String getMessage() {
        return this.X;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeException(@NonNull Throwable... thArr) {
        this((Iterable<? extends Throwable>) thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public void printStackTrace(PrintStream printStream) {
        c(new WrappedPrintStream(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        c(new WrappedPrintWriter(printWriter));
    }
}
