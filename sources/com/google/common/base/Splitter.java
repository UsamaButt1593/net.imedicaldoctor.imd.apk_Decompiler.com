package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Splitter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharMatcher f22281a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f22282b;

    /* renamed from: c  reason: collision with root package name */
    private final Strategy f22283c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f22284d;

    public static final class MapSplitter {

        /* renamed from: c  reason: collision with root package name */
        private static final String f22289c = "Chunk [%s] is not a valid entry";

        /* renamed from: a  reason: collision with root package name */
        private final Splitter f22290a;

        /* renamed from: b  reason: collision with root package name */
        private final Splitter f22291b;

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.f22290a = splitter;
            this.f22291b = (Splitter) Preconditions.E(splitter2);
        }

        public Map<String, String> a(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String next : this.f22290a.n(charSequence)) {
                Iterator a2 = this.f22291b.p(next);
                Preconditions.u(a2.hasNext(), f22289c, next);
                String str = (String) a2.next();
                Preconditions.u(!linkedHashMap.containsKey(str), "Duplicate key [%s] found.", str);
                Preconditions.u(a2.hasNext(), f22289c, next);
                linkedHashMap.put(str, (String) a2.next());
                Preconditions.u(!a2.hasNext(), f22289c, next);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    private static abstract class SplittingIterator extends AbstractIterator<String> {
        final boolean X2;
        final CharSequence Y;
        int Y2 = 0;
        final CharMatcher Z;
        int Z2;

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.Z = splitter.f22281a;
            this.X2 = splitter.f22282b;
            this.Z2 = splitter.f22284d;
            this.Y = charSequence;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
            if (r0 >= r1) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
            if (r6.Z.B(r6.Y.charAt(r0)) == false) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
            if (r1 <= r0) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
            if (r6.Z.B(r6.Y.charAt(r1 - 1)) == false) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
            r1 = r1 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
            if (r6.X2 == false) goto L_0x005e;
         */
        @javax.annotation.CheckForNull
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String a() {
            /*
                r6 = this;
            L_0x0000:
                int r0 = r6.Y2
            L_0x0002:
                int r1 = r6.Y2
                r2 = -1
                if (r1 == r2) goto L_0x008e
                int r1 = r6.f(r1)
                if (r1 != r2) goto L_0x0016
                java.lang.CharSequence r1 = r6.Y
                int r1 = r1.length()
                r6.Y2 = r2
                goto L_0x001c
            L_0x0016:
                int r3 = r6.e(r1)
                r6.Y2 = r3
            L_0x001c:
                int r3 = r6.Y2
                if (r3 != r0) goto L_0x002f
                int r3 = r3 + 1
                r6.Y2 = r3
                java.lang.CharSequence r1 = r6.Y
                int r1 = r1.length()
                if (r3 <= r1) goto L_0x0002
                r6.Y2 = r2
                goto L_0x0002
            L_0x002f:
                if (r0 >= r1) goto L_0x0042
                com.google.common.base.CharMatcher r3 = r6.Z
                java.lang.CharSequence r4 = r6.Y
                char r4 = r4.charAt(r0)
                boolean r3 = r3.B(r4)
                if (r3 == 0) goto L_0x0042
                int r0 = r0 + 1
                goto L_0x002f
            L_0x0042:
                if (r1 <= r0) goto L_0x0057
                com.google.common.base.CharMatcher r3 = r6.Z
                java.lang.CharSequence r4 = r6.Y
                int r5 = r1 + -1
                char r4 = r4.charAt(r5)
                boolean r3 = r3.B(r4)
                if (r3 == 0) goto L_0x0057
                int r1 = r1 + -1
                goto L_0x0042
            L_0x0057:
                boolean r3 = r6.X2
                if (r3 == 0) goto L_0x005e
                if (r0 != r1) goto L_0x005e
                goto L_0x0000
            L_0x005e:
                int r3 = r6.Z2
                r4 = 1
                if (r3 != r4) goto L_0x0080
                java.lang.CharSequence r1 = r6.Y
                int r1 = r1.length()
                r6.Y2 = r2
            L_0x006b:
                if (r1 <= r0) goto L_0x0083
                com.google.common.base.CharMatcher r2 = r6.Z
                java.lang.CharSequence r3 = r6.Y
                int r4 = r1 + -1
                char r3 = r3.charAt(r4)
                boolean r2 = r2.B(r3)
                if (r2 == 0) goto L_0x0083
                int r1 = r1 + -1
                goto L_0x006b
            L_0x0080:
                int r3 = r3 - r4
                r6.Z2 = r3
            L_0x0083:
                java.lang.CharSequence r2 = r6.Y
                java.lang.CharSequence r0 = r2.subSequence(r0, r1)
                java.lang.String r0 = r0.toString()
                return r0
            L_0x008e:
                java.lang.Object r0 = r6.b()
                java.lang.String r0 = (java.lang.String) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Splitter.SplittingIterator.a():java.lang.String");
        }

        /* access modifiers changed from: package-private */
        public abstract int e(int i2);

        /* access modifiers changed from: package-private */
        public abstract int f(int i2);
    }

    private interface Strategy {
        Iterator<String> a(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.G(), Integer.MAX_VALUE);
    }

    public static Splitter e(final int i2) {
        Preconditions.e(i2 > 0, "The length may not be less than 1");
        return new Splitter(new Strategy() {
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int e(int i2) {
                        return i2;
                    }

                    public int f(int i2) {
                        int i3 = i2 + i2;
                        if (i3 < this.Y.length()) {
                            return i3;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    public static Splitter h(char c2) {
        return i(CharMatcher.q(c2));
    }

    public static Splitter i(final CharMatcher charMatcher) {
        Preconditions.E(charMatcher);
        return new Splitter(new Strategy() {
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    /* access modifiers changed from: package-private */
                    public int e(int i2) {
                        return i2 + 1;
                    }

                    /* access modifiers changed from: package-private */
                    public int f(int i2) {
                        return CharMatcher.this.o(this.Y, i2);
                    }
                };
            }
        });
    }

    public static Splitter j(final String str) {
        Preconditions.e(str.length() != 0, "The separator may not be the empty string.");
        return str.length() == 1 ? h(str.charAt(0)) : new Splitter(new Strategy() {
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int e(int i2) {
                        return i2 + str.length();
                    }

                    public int f(int i2) {
                        int length = str.length();
                        int length2 = this.Y.length() - length;
                        while (i2 <= length2) {
                            int i3 = 0;
                            while (i3 < length) {
                                if (this.Y.charAt(i3 + i2) != str.charAt(i3)) {
                                    i2++;
                                } else {
                                    i3++;
                                }
                            }
                            return i2;
                        }
                        return -1;
                    }
                };
            }
        });
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static Splitter k(Pattern pattern) {
        return m(new JdkPattern(pattern));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static Splitter l(String str) {
        return m(Platform.a(str));
    }

    static Splitter m(final CommonPattern commonPattern) {
        Preconditions.u(!commonPattern.d("").d(), "The pattern may not match the empty string: %s", commonPattern);
        return new Splitter(new Strategy() {
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                final CommonMatcher d2 = CommonPattern.this.d(charSequence);
                return new SplittingIterator(this, splitter, charSequence) {
                    public int e(int i2) {
                        return d2.a();
                    }

                    public int f(int i2) {
                        if (d2.c(i2)) {
                            return d2.f();
                        }
                        return -1;
                    }
                };
            }
        });
    }

    /* access modifiers changed from: private */
    public Iterator<String> p(CharSequence charSequence) {
        return this.f22283c.a(this, charSequence);
    }

    public Splitter f(int i2) {
        Preconditions.k(i2 > 0, "must be greater than zero: %s", i2);
        return new Splitter(this.f22283c, this.f22282b, this.f22281a, i2);
    }

    public Splitter g() {
        return new Splitter(this.f22283c, true, this.f22281a, this.f22284d);
    }

    public Iterable<String> n(final CharSequence charSequence) {
        Preconditions.E(charSequence);
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return Splitter.this.p(charSequence);
            }

            public String toString() {
                Joiner p = Joiner.p(", ");
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                StringBuilder f2 = p.f(sb, this);
                f2.append(']');
                return f2.toString();
            }
        };
    }

    public List<String> o(CharSequence charSequence) {
        Preconditions.E(charSequence);
        Iterator<String> p = p(charSequence);
        ArrayList arrayList = new ArrayList();
        while (p.hasNext()) {
            arrayList.add(p.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter q() {
        return r(CharMatcher.X());
    }

    public Splitter r(CharMatcher charMatcher) {
        Preconditions.E(charMatcher);
        return new Splitter(this.f22283c, this.f22282b, charMatcher, this.f22284d);
    }

    public MapSplitter s(char c2) {
        return t(h(c2));
    }

    public MapSplitter t(Splitter splitter) {
        return new MapSplitter(splitter);
    }

    public MapSplitter u(String str) {
        return t(j(str));
    }

    private Splitter(Strategy strategy, boolean z, CharMatcher charMatcher, int i2) {
        this.f22283c = strategy;
        this.f22282b = z;
        this.f22281a = charMatcher;
        this.f22284d = i2;
    }
}
