package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public class Joiner {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f22265a;

    public static final class MapJoiner {

        /* renamed from: a  reason: collision with root package name */
        private final Joiner f22269a;

        /* renamed from: b  reason: collision with root package name */
        private final String f22270b;

        private MapJoiner(Joiner joiner, String str) {
            this.f22269a = joiner;
            this.f22270b = (String) Preconditions.E(str);
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A a(A a2, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return b(a2, iterable.iterator());
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A b(A a2, Iterator<? extends Map.Entry<?, ?>> it2) throws IOException {
            Preconditions.E(a2);
            if (it2.hasNext()) {
                while (true) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    a2.append(this.f22269a.r(entry.getKey()));
                    a2.append(this.f22270b);
                    a2.append(this.f22269a.r(entry.getValue()));
                    if (!it2.hasNext()) {
                        break;
                    }
                    a2.append(this.f22269a.f22265a);
                }
            }
            return a2;
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A c(A a2, Map<?, ?> map) throws IOException {
            return a(a2, map.entrySet());
        }

        @CanIgnoreReturnValue
        public StringBuilder d(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return e(sb, iterable.iterator());
        }

        @CanIgnoreReturnValue
        public StringBuilder e(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it2) {
            try {
                b(sb, it2);
                return sb;
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        @CanIgnoreReturnValue
        public StringBuilder f(StringBuilder sb, Map<?, ?> map) {
            return d(sb, map.entrySet());
        }

        public String g(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return h(iterable.iterator());
        }

        public String h(Iterator<? extends Map.Entry<?, ?>> it2) {
            return e(new StringBuilder(), it2).toString();
        }

        public String i(Map<?, ?> map) {
            return g(map.entrySet());
        }

        public MapJoiner j(String str) {
            return new MapJoiner(this.f22269a.s(str), this.f22270b);
        }
    }

    private Joiner(Joiner joiner) {
        this.f22265a = joiner.f22265a;
    }

    private static Iterable<Object> j(@CheckForNull final Object obj, @CheckForNull final Object obj2, final Object[] objArr) {
        Preconditions.E(objArr);
        return new AbstractList<Object>() {
            @CheckForNull
            public Object get(int i2) {
                return i2 != 0 ? i2 != 1 ? objArr[i2 - 2] : obj2 : obj;
            }

            public int size() {
                return objArr.length + 2;
            }
        };
    }

    public static Joiner o(char c2) {
        return new Joiner(String.valueOf(c2));
    }

    public static Joiner p(String str) {
        return new Joiner(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A b(A a2, Iterable<? extends Object> iterable) throws IOException {
        return d(a2, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A c(A a2, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) throws IOException {
        return b(a2, j(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A d(A a2, Iterator<? extends Object> it2) throws IOException {
        Preconditions.E(a2);
        if (it2.hasNext()) {
            while (true) {
                a2.append(r(it2.next()));
                if (!it2.hasNext()) {
                    break;
                }
                a2.append(this.f22265a);
            }
        }
        return a2;
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A e(A a2, Object[] objArr) throws IOException {
        return b(a2, Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder f(StringBuilder sb, Iterable<? extends Object> iterable) {
        return h(sb, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder g(StringBuilder sb, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return f(sb, j(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder h(StringBuilder sb, Iterator<? extends Object> it2) {
        try {
            d(sb, it2);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder i(StringBuilder sb, Object[] objArr) {
        return f(sb, Arrays.asList(objArr));
    }

    public final String k(Iterable<? extends Object> iterable) {
        return m(iterable.iterator());
    }

    public final String l(@CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return k(j(obj, obj2, objArr));
    }

    public final String m(Iterator<? extends Object> it2) {
        return h(new StringBuilder(), it2).toString();
    }

    public final String n(Object[] objArr) {
        return k(Arrays.asList(objArr));
    }

    public Joiner q() {
        return new Joiner(this) {
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0035 A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            public <A extends java.lang.Appendable> A d(A r3, java.util.Iterator<? extends java.lang.Object> r4) throws java.io.IOException {
                /*
                    r2 = this;
                    java.lang.String r0 = "appendable"
                    com.google.common.base.Preconditions.F(r3, r0)
                    java.lang.String r0 = "parts"
                    com.google.common.base.Preconditions.F(r4, r0)
                L_0x000a:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L_0x001f
                    java.lang.Object r0 = r4.next()
                    if (r0 == 0) goto L_0x000a
                L_0x0016:
                    com.google.common.base.Joiner r1 = com.google.common.base.Joiner.this
                    java.lang.CharSequence r0 = r1.r(r0)
                    r3.append(r0)
                L_0x001f:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L_0x0035
                    java.lang.Object r0 = r4.next()
                    if (r0 == 0) goto L_0x001f
                    com.google.common.base.Joiner r1 = com.google.common.base.Joiner.this
                    java.lang.String r1 = r1.f22265a
                    r3.append(r1)
                    goto L_0x0016
                L_0x0035:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Joiner.AnonymousClass2.d(java.lang.Appendable, java.util.Iterator):java.lang.Appendable");
            }

            public Joiner s(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            public MapJoiner u(String str) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    /* access modifiers changed from: package-private */
    public CharSequence r(@CheckForNull Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public Joiner s(final String str) {
        Preconditions.E(str);
        return new Joiner(this) {
            public Joiner q() {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            /* access modifiers changed from: package-private */
            public CharSequence r(@CheckForNull Object obj) {
                return obj == null ? str : Joiner.this.r(obj);
            }

            public Joiner s(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public MapJoiner t(char c2) {
        return u(String.valueOf(c2));
    }

    public MapJoiner u(String str) {
        return new MapJoiner(str);
    }

    private Joiner(String str) {
        this.f22265a = (String) Preconditions.E(str);
    }
}
