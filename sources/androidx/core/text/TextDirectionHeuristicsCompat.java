package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f6203a = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f6204b = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f6205c;

    /* renamed from: d  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f6206d;

    /* renamed from: e  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f6207e = new TextDirectionHeuristicInternal(AnyStrong.f6212b, false);

    /* renamed from: f  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f6208f = TextDirectionHeuristicLocale.f6217b;

    /* renamed from: g  reason: collision with root package name */
    private static final int f6209g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final int f6210h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final int f6211i = 2;

    private static class AnyStrong implements TextDirectionAlgorithm {

        /* renamed from: b  reason: collision with root package name */
        static final AnyStrong f6212b = new AnyStrong(true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f6213a;

        private AnyStrong(boolean z) {
            this.f6213a = z;
        }

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z = false;
            while (i2 < i4) {
                int a2 = TextDirectionHeuristicsCompat.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i2++;
                    } else if (!this.f6213a) {
                        return 1;
                    }
                } else if (this.f6213a) {
                    return 0;
                }
                z = true;
                i2++;
            }
            if (z) {
                return this.f6213a ? 1 : 0;
            }
            return 2;
        }
    }

    private static class FirstStrong implements TextDirectionAlgorithm {

        /* renamed from: a  reason: collision with root package name */
        static final FirstStrong f6214a = new FirstStrong();

        private FirstStrong() {
        }

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                i5 = TextDirectionHeuristicsCompat.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i5;
        }
    }

    private interface TextDirectionAlgorithm {
        int a(CharSequence charSequence, int i2, int i3);
    }

    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {

        /* renamed from: a  reason: collision with root package name */
        private final TextDirectionAlgorithm f6215a;

        TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f6215a = textDirectionAlgorithm;
        }

        private boolean d(CharSequence charSequence, int i2, int i3) {
            int a2 = this.f6215a.a(charSequence, i2, i3);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return c();
            }
            return false;
        }

        public boolean a(char[] cArr, int i2, int i3) {
            return b(CharBuffer.wrap(cArr), i2, i3);
        }

        public boolean b(CharSequence charSequence, int i2, int i3) {
            if (charSequence != null && i2 >= 0 && i3 >= 0 && charSequence.length() - i3 >= i2) {
                return this.f6215a == null ? c() : d(charSequence, i2, i3);
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: protected */
        public abstract boolean c();
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f6216b;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.f6216b = z;
        }

        /* access modifiers changed from: protected */
        public boolean c() {
            return this.f6216b;
        }
    }

    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {

        /* renamed from: b  reason: collision with root package name */
        static final TextDirectionHeuristicLocale f6217b = new TextDirectionHeuristicLocale();

        TextDirectionHeuristicLocale() {
            super((TextDirectionAlgorithm) null);
        }

        /* access modifiers changed from: protected */
        public boolean c() {
            return TextUtilsCompat.a(Locale.getDefault()) == 1;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.f6214a;
        f6205c = new TextDirectionHeuristicInternal(firstStrong, false);
        f6206d = new TextDirectionHeuristicInternal(firstStrong, true);
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return 0;
            }
            switch (i2) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
