package com.google.common.base;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class MoreObjects {

    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        private final String f22271a;

        /* renamed from: b  reason: collision with root package name */
        private final ValueHolder f22272b;

        /* renamed from: c  reason: collision with root package name */
        private ValueHolder f22273c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f22274d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f22275e;

        private static final class UnconditionalValueHolder extends ValueHolder {
            private UnconditionalValueHolder() {
                super();
            }
        }

        private static class ValueHolder {
            @CheckForNull

            /* renamed from: a  reason: collision with root package name */
            String f22276a;
            @CheckForNull

            /* renamed from: b  reason: collision with root package name */
            Object f22277b;
            @CheckForNull

            /* renamed from: c  reason: collision with root package name */
            ValueHolder f22278c;

            private ValueHolder() {
            }
        }

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f22272b = valueHolder;
            this.f22273c = valueHolder;
            this.f22274d = false;
            this.f22275e = false;
            this.f22271a = (String) Preconditions.E(str);
        }

        private ValueHolder h() {
            ValueHolder valueHolder = new ValueHolder();
            this.f22273c.f22278c = valueHolder;
            this.f22273c = valueHolder;
            return valueHolder;
        }

        @CanIgnoreReturnValue
        private ToStringHelper i(@CheckForNull Object obj) {
            h().f22277b = obj;
            return this;
        }

        @CanIgnoreReturnValue
        private ToStringHelper j(String str, @CheckForNull Object obj) {
            ValueHolder h2 = h();
            h2.f22277b = obj;
            h2.f22276a = (String) Preconditions.E(str);
            return this;
        }

        private UnconditionalValueHolder k() {
            UnconditionalValueHolder unconditionalValueHolder = new UnconditionalValueHolder();
            this.f22273c.f22278c = unconditionalValueHolder;
            this.f22273c = unconditionalValueHolder;
            return unconditionalValueHolder;
        }

        @CanIgnoreReturnValue
        private ToStringHelper l(Object obj) {
            k().f22277b = obj;
            return this;
        }

        @CanIgnoreReturnValue
        private ToStringHelper m(String str, Object obj) {
            UnconditionalValueHolder k2 = k();
            k2.f22277b = obj;
            k2.f22276a = (String) Preconditions.E(str);
            return this;
        }

        private static boolean u(Object obj) {
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() == 0;
            }
            if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            }
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            if (obj instanceof Optional) {
                return !((Optional) obj).e();
            }
            return obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        @CanIgnoreReturnValue
        public ToStringHelper a(String str, char c2) {
            return m(str, String.valueOf(c2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper b(String str, double d2) {
            return m(str, String.valueOf(d2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper c(String str, float f2) {
            return m(str, String.valueOf(f2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper d(String str, int i2) {
            return m(str, String.valueOf(i2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper e(String str, long j2) {
            return m(str, String.valueOf(j2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper f(String str, @CheckForNull Object obj) {
            return j(str, obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper g(String str, boolean z) {
            return m(str, String.valueOf(z));
        }

        @CanIgnoreReturnValue
        public ToStringHelper n(char c2) {
            return l(String.valueOf(c2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper o(double d2) {
            return l(String.valueOf(d2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper p(float f2) {
            return l(String.valueOf(f2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper q(int i2) {
            return l(String.valueOf(i2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper r(long j2) {
            return l(String.valueOf(j2));
        }

        @CanIgnoreReturnValue
        public ToStringHelper s(@CheckForNull Object obj) {
            return i(obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper t(boolean z) {
            return l(String.valueOf(z));
        }

        public String toString() {
            boolean z = this.f22274d;
            boolean z2 = this.f22275e;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f22271a);
            sb.append(ASCIIPropertyListParser.f18652j);
            String str = "";
            for (ValueHolder valueHolder = this.f22272b.f22278c; valueHolder != null; valueHolder = valueHolder.f22278c) {
                Object obj = valueHolder.f22277b;
                if (!(valueHolder instanceof UnconditionalValueHolder)) {
                    if (obj == null) {
                        if (z) {
                        }
                    } else if (z2 && u(obj)) {
                    }
                }
                sb.append(str);
                String str2 = valueHolder.f22276a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append(ASCIIPropertyListParser.f18654l);
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append(deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
            sb.append(ASCIIPropertyListParser.f18653k);
            return sb.toString();
        }

        @CanIgnoreReturnValue
        public ToStringHelper v() {
            this.f22274d = true;
            return this;
        }
    }

    private MoreObjects() {
    }

    public static <T> T a(@CheckForNull T t, @CheckForNull T t2) {
        if (t != null) {
            return t;
        }
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper b(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper c(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper d(String str) {
        return new ToStringHelper(str);
    }
}
