package com.google.common.io;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;
import okio.Utf8;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class BaseEncoding {

    /* renamed from: a  reason: collision with root package name */
    private static final BaseEncoding f22725a;

    /* renamed from: b  reason: collision with root package name */
    private static final BaseEncoding f22726b;

    /* renamed from: c  reason: collision with root package name */
    private static final BaseEncoding f22727c;

    /* renamed from: d  reason: collision with root package name */
    private static final BaseEncoding f22728d;

    /* renamed from: e  reason: collision with root package name */
    private static final BaseEncoding f22729e = new Base16Encoding("base16()", BinTools.f30545a);

    private static final class Alphabet {

        /* renamed from: a  reason: collision with root package name */
        private final String f22734a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final char[] f22735b;

        /* renamed from: c  reason: collision with root package name */
        final int f22736c;

        /* renamed from: d  reason: collision with root package name */
        final int f22737d;

        /* renamed from: e  reason: collision with root package name */
        final int f22738e;

        /* renamed from: f  reason: collision with root package name */
        final int f22739f;

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f22740g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean[] f22741h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f22742i;

        Alphabet(String str, char[] cArr) {
            this(str, cArr, c(cArr), false);
        }

        private static byte[] c(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i2 = 0; i2 < cArr.length; i2++) {
                char c2 = cArr[i2];
                boolean z = true;
                Preconditions.f(c2 < 128, "Non-ASCII character: %s", c2);
                if (bArr[c2] != -1) {
                    z = false;
                }
                Preconditions.f(z, "Duplicate character: %s", c2);
                bArr[c2] = (byte) i2;
            }
            return bArr;
        }

        private boolean f() {
            for (char c2 : this.f22735b) {
                if (Ascii.c(c2)) {
                    return true;
                }
            }
            return false;
        }

        private boolean g() {
            for (char d2 : this.f22735b) {
                if (Ascii.d(d2)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(char c2) {
            return c2 <= 127 && this.f22740g[c2] != -1;
        }

        /* access modifiers changed from: package-private */
        public int d(char c2) throws DecodingException {
            if (c2 <= 127) {
                byte b2 = this.f22740g[c2];
                if (b2 != -1) {
                    return b2;
                }
                if (c2 <= ' ' || c2 == 127) {
                    throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c2));
                }
                throw new DecodingException("Unrecognized character: " + c2);
            }
            throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c2));
        }

        /* access modifiers changed from: package-private */
        public char e(int i2) {
            return this.f22735b[i2];
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Alphabet)) {
                return false;
            }
            Alphabet alphabet = (Alphabet) obj;
            return this.f22742i == alphabet.f22742i && Arrays.equals(this.f22735b, alphabet.f22735b);
        }

        /* access modifiers changed from: package-private */
        public Alphabet h() {
            if (this.f22742i) {
                return this;
            }
            byte[] bArr = this.f22740g;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            int i2 = 65;
            while (true) {
                boolean z = true;
                if (i2 <= 90) {
                    int i3 = i2 | 32;
                    byte[] bArr2 = this.f22740g;
                    byte b2 = bArr2[i2];
                    byte b3 = bArr2[i3];
                    if (b2 == -1) {
                        copyOf[i2] = b3;
                    } else {
                        if (b3 != -1) {
                            z = false;
                        }
                        Preconditions.j0(z, "Can't ignoreCase() since '%s' and '%s' encode different values", (char) i2, (char) i3);
                        copyOf[i3] = b2;
                    }
                    i2++;
                } else {
                    return new Alphabet(this.f22734a + ".ignoreCase()", this.f22735b, copyOf, true);
                }
            }
        }

        public int hashCode() {
            return Arrays.hashCode(this.f22735b) + (this.f22742i ? 1231 : 1237);
        }

        /* access modifiers changed from: package-private */
        public boolean i(int i2) {
            return this.f22741h[i2 % this.f22738e];
        }

        /* access modifiers changed from: package-private */
        public Alphabet j() {
            if (!g()) {
                return this;
            }
            Preconditions.h0(!f(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f22735b.length];
            int i2 = 0;
            while (true) {
                char[] cArr2 = this.f22735b;
                if (i2 >= cArr2.length) {
                    break;
                }
                cArr[i2] = Ascii.e(cArr2[i2]);
                i2++;
            }
            Alphabet alphabet = new Alphabet(this.f22734a + ".lowerCase()", cArr);
            return this.f22742i ? alphabet.h() : alphabet;
        }

        public boolean k(char c2) {
            byte[] bArr = this.f22740g;
            return c2 < bArr.length && bArr[c2] != -1;
        }

        /* access modifiers changed from: package-private */
        public Alphabet l() {
            if (!f()) {
                return this;
            }
            Preconditions.h0(!g(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f22735b.length];
            int i2 = 0;
            while (true) {
                char[] cArr2 = this.f22735b;
                if (i2 >= cArr2.length) {
                    break;
                }
                cArr[i2] = Ascii.h(cArr2[i2]);
                i2++;
            }
            Alphabet alphabet = new Alphabet(this.f22734a + ".upperCase()", cArr);
            return this.f22742i ? alphabet.h() : alphabet;
        }

        public String toString() {
            return this.f22734a;
        }

        private Alphabet(String str, char[] cArr, byte[] bArr, boolean z) {
            this.f22734a = (String) Preconditions.E(str);
            this.f22735b = (char[]) Preconditions.E(cArr);
            try {
                int p = IntMath.p(cArr.length, RoundingMode.UNNECESSARY);
                this.f22737d = p;
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(p);
                int i2 = 1 << (3 - numberOfTrailingZeros);
                this.f22738e = i2;
                this.f22739f = p >> numberOfTrailingZeros;
                this.f22736c = cArr.length - 1;
                this.f22740g = bArr;
                boolean[] zArr = new boolean[i2];
                for (int i3 = 0; i3 < this.f22739f; i3++) {
                    zArr[IntMath.g(i3 * 8, this.f22737d, RoundingMode.CEILING)] = true;
                }
                this.f22741h = zArr;
                this.f22742i = z;
            } catch (ArithmeticException e2) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e2);
            }
        }
    }

    static final class Base16Encoding extends StandardBaseEncoding {

        /* renamed from: k  reason: collision with root package name */
        final char[] f22743k;

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, (Character) null);
            this.f22743k = new char[512];
            Preconditions.d(alphabet.f22735b.length == 16);
            for (int i2 = 0; i2 < 256; i2++) {
                this.f22743k[i2] = alphabet.e(i2 >>> 4);
                this.f22743k[i2 | 256] = alphabet.e(i2 & 15);
            }
        }

        /* access modifiers changed from: package-private */
        public BaseEncoding E(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base16Encoding(alphabet);
        }

        /* access modifiers changed from: package-private */
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.E(bArr);
            if (charSequence.length() % 2 != 1) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < charSequence.length()) {
                    bArr[i3] = (byte) ((this.f22747f.d(charSequence.charAt(i2)) << 4) | this.f22747f.d(charSequence.charAt(i2 + 1)));
                    i2 += 2;
                    i3++;
                }
                return i3;
            }
            throw new DecodingException("Invalid input length " + charSequence.length());
        }

        /* access modifiers changed from: package-private */
        public void n(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.E(appendable);
            Preconditions.f0(i2, i2 + i3, bArr.length);
            for (int i4 = 0; i4 < i3; i4++) {
                byte b2 = bArr[i2 + i4] & 255;
                appendable.append(this.f22743k[b2]);
                appendable.append(this.f22743k[b2 | 256]);
            }
        }

        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }
    }

    static final class Base64Encoding extends StandardBaseEncoding {
        private Base64Encoding(Alphabet alphabet, @CheckForNull Character ch) {
            super(alphabet, ch);
            Preconditions.d(alphabet.f22735b.length == 64);
        }

        /* access modifiers changed from: package-private */
        public BaseEncoding E(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base64Encoding(alphabet, ch);
        }

        /* access modifiers changed from: package-private */
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.E(bArr);
            CharSequence z = z(charSequence);
            if (this.f22747f.i(z.length())) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < z.length()) {
                    int i4 = i2 + 2;
                    int d2 = (this.f22747f.d(z.charAt(i2)) << 18) | (this.f22747f.d(z.charAt(i2 + 1)) << 12);
                    int i5 = i3 + 1;
                    bArr[i3] = (byte) (d2 >>> 16);
                    if (i4 < z.length()) {
                        int i6 = i2 + 3;
                        int d3 = d2 | (this.f22747f.d(z.charAt(i4)) << 6);
                        int i7 = i3 + 2;
                        bArr[i5] = (byte) ((d3 >>> 8) & 255);
                        if (i6 < z.length()) {
                            i2 += 4;
                            i3 += 3;
                            bArr[i7] = (byte) ((d3 | this.f22747f.d(z.charAt(i6))) & 255);
                        } else {
                            i3 = i7;
                            i2 = i6;
                        }
                    } else {
                        i3 = i5;
                        i2 = i4;
                    }
                }
                return i3;
            }
            throw new DecodingException("Invalid input length " + z.length());
        }

        /* access modifiers changed from: package-private */
        public void n(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.E(appendable);
            int i4 = i2 + i3;
            Preconditions.f0(i2, i4, bArr.length);
            while (i3 >= 3) {
                int i5 = i2 + 2;
                int i6 = (bArr[i2 + 1] & 255) << 8;
                i2 += 3;
                byte b2 = i6 | ((bArr[i2] & 255) << 16) | (bArr[i5] & 255);
                appendable.append(this.f22747f.e(b2 >>> 18));
                appendable.append(this.f22747f.e((b2 >>> 12) & 63));
                appendable.append(this.f22747f.e((b2 >>> 6) & 63));
                appendable.append(this.f22747f.e(b2 & Utf8.f31404a));
                i3 -= 3;
            }
            if (i2 < i4) {
                D(appendable, bArr, i2, i4 - i2);
            }
        }

        Base64Encoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }
    }

    public static final class DecodingException extends IOException {
        DecodingException(String str) {
            super(str);
        }

        DecodingException(Throwable th) {
            super(th);
        }
    }

    static final class SeparatedBaseEncoding extends BaseEncoding {

        /* renamed from: f  reason: collision with root package name */
        private final BaseEncoding f22744f;

        /* renamed from: g  reason: collision with root package name */
        private final String f22745g;

        /* renamed from: h  reason: collision with root package name */
        private final int f22746h;

        SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i2) {
            this.f22744f = (BaseEncoding) Preconditions.E(baseEncoding);
            this.f22745g = (String) Preconditions.E(str);
            this.f22746h = i2;
            Preconditions.k(i2 > 0, "Cannot add a separator after every %s chars", i2);
        }

        public BaseEncoding A() {
            return this.f22744f.A().C(this.f22745g, this.f22746h);
        }

        public BaseEncoding B(char c2) {
            return this.f22744f.B(c2).C(this.f22745g, this.f22746h);
        }

        public BaseEncoding C(String str, int i2) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        public boolean f(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                char charAt = charSequence.charAt(i2);
                if (this.f22745g.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.f22744f.f(sb);
        }

        /* access modifiers changed from: package-private */
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                char charAt = charSequence.charAt(i2);
                if (this.f22745g.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.f22744f.i(bArr, sb);
        }

        @GwtIncompatible
        @J2ktIncompatible
        public InputStream k(Reader reader) {
            return this.f22744f.k(BaseEncoding.s(reader, this.f22745g));
        }

        /* access modifiers changed from: package-private */
        public void n(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            this.f22744f.n(BaseEncoding.x(appendable, this.f22745g, this.f22746h), bArr, i2, i3);
        }

        @GwtIncompatible
        @J2ktIncompatible
        public OutputStream p(Writer writer) {
            return this.f22744f.p(BaseEncoding.y(writer, this.f22745g, this.f22746h));
        }

        public BaseEncoding r() {
            return this.f22744f.r().C(this.f22745g, this.f22746h);
        }

        public BaseEncoding t() {
            return this.f22744f.t().C(this.f22745g, this.f22746h);
        }

        public String toString() {
            return this.f22744f + ".withSeparator(\"" + this.f22745g + "\", " + this.f22746h + ")";
        }

        /* access modifiers changed from: package-private */
        public int u(int i2) {
            return this.f22744f.u(i2);
        }

        /* access modifiers changed from: package-private */
        public int v(int i2) {
            int v = this.f22744f.v(i2);
            return v + (this.f22745g.length() * IntMath.g(Math.max(0, v - 1), this.f22746h, RoundingMode.FLOOR));
        }

        public BaseEncoding w() {
            return this.f22744f.w().C(this.f22745g, this.f22746h);
        }

        /* access modifiers changed from: package-private */
        public CharSequence z(CharSequence charSequence) {
            return this.f22744f.z(charSequence);
        }
    }

    static class StandardBaseEncoding extends BaseEncoding {

        /* renamed from: f  reason: collision with root package name */
        final Alphabet f22747f;
        @CheckForNull

        /* renamed from: g  reason: collision with root package name */
        final Character f22748g;
        @CheckForNull
        @LazyInit

        /* renamed from: h  reason: collision with root package name */
        private volatile BaseEncoding f22749h;
        @CheckForNull
        @LazyInit

        /* renamed from: i  reason: collision with root package name */
        private volatile BaseEncoding f22750i;
        @CheckForNull
        @LazyInit

        /* renamed from: j  reason: collision with root package name */
        private volatile BaseEncoding f22751j;

        StandardBaseEncoding(Alphabet alphabet, @CheckForNull Character ch) {
            this.f22747f = (Alphabet) Preconditions.E(alphabet);
            Preconditions.u(ch == null || !alphabet.k(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f22748g = ch;
        }

        public BaseEncoding A() {
            BaseEncoding baseEncoding = this.f22749h;
            if (baseEncoding == null) {
                Alphabet l2 = this.f22747f.l();
                baseEncoding = l2 == this.f22747f ? this : E(l2, this.f22748g);
                this.f22749h = baseEncoding;
            }
            return baseEncoding;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r0 = r2.f22748g;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.common.io.BaseEncoding B(char r3) {
            /*
                r2 = this;
                com.google.common.io.BaseEncoding$Alphabet r0 = r2.f22747f
                int r0 = r0.f22737d
                r1 = 8
                int r1 = r1 % r0
                if (r1 == 0) goto L_0x001f
                java.lang.Character r0 = r2.f22748g
                if (r0 == 0) goto L_0x0014
                char r0 = r0.charValue()
                if (r0 != r3) goto L_0x0014
                goto L_0x001f
            L_0x0014:
                com.google.common.io.BaseEncoding$Alphabet r0 = r2.f22747f
                java.lang.Character r3 = java.lang.Character.valueOf(r3)
                com.google.common.io.BaseEncoding r3 = r2.E(r0, r3)
                return r3
            L_0x001f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.B(char):com.google.common.io.BaseEncoding");
        }

        public BaseEncoding C(String str, int i2) {
            boolean z = false;
            for (int i3 = 0; i3 < str.length(); i3++) {
                Preconditions.u(!this.f22747f.k(str.charAt(i3)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.f22748g;
            if (ch != null) {
                if (str.indexOf(ch.charValue()) < 0) {
                    z = true;
                }
                Preconditions.u(z, "Separator (%s) cannot contain padding character", str);
            }
            return new SeparatedBaseEncoding(this, str, i2);
        }

        /* access modifiers changed from: package-private */
        public void D(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.E(appendable);
            Preconditions.f0(i2, i2 + i3, bArr.length);
            int i4 = 0;
            Preconditions.d(i3 <= this.f22747f.f22739f);
            long j2 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                j2 = (j2 | ((long) (bArr[i2 + i5] & 255))) << 8;
            }
            int i6 = ((i3 + 1) * 8) - this.f22747f.f22737d;
            while (i4 < i3 * 8) {
                Alphabet alphabet = this.f22747f;
                appendable.append(alphabet.e(((int) (j2 >>> (i6 - i4))) & alphabet.f22736c));
                i4 += this.f22747f.f22737d;
            }
            if (this.f22748g != null) {
                while (i4 < this.f22747f.f22739f * 8) {
                    appendable.append(this.f22748g.charValue());
                    i4 += this.f22747f.f22737d;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public BaseEncoding E(Alphabet alphabet, @CheckForNull Character ch) {
            return new StandardBaseEncoding(alphabet, ch);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            return this.f22747f.equals(standardBaseEncoding.f22747f) && Objects.equals(this.f22748g, standardBaseEncoding.f22748g);
        }

        public boolean f(CharSequence charSequence) {
            Preconditions.E(charSequence);
            CharSequence z = z(charSequence);
            if (!this.f22747f.i(z.length())) {
                return false;
            }
            for (int i2 = 0; i2 < z.length(); i2++) {
                if (!this.f22747f.b(z.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.f22747f.hashCode() ^ Objects.hashCode(this.f22748g);
        }

        /* access modifiers changed from: package-private */
        public int i(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Alphabet alphabet;
            Preconditions.E(bArr);
            CharSequence z = z(charSequence);
            if (this.f22747f.i(z.length())) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < z.length()) {
                    long j2 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        alphabet = this.f22747f;
                        if (i4 >= alphabet.f22738e) {
                            break;
                        }
                        j2 <<= alphabet.f22737d;
                        if (i2 + i4 < z.length()) {
                            j2 |= (long) this.f22747f.d(z.charAt(i5 + i2));
                            i5++;
                        }
                        i4++;
                    }
                    int i6 = alphabet.f22739f;
                    int i7 = (i6 * 8) - (i5 * alphabet.f22737d);
                    int i8 = (i6 - 1) * 8;
                    while (i8 >= i7) {
                        bArr[i3] = (byte) ((int) ((j2 >>> i8) & 255));
                        i8 -= 8;
                        i3++;
                    }
                    i2 += this.f22747f.f22738e;
                }
                return i3;
            }
            throw new DecodingException("Invalid input length " + z.length());
        }

        @GwtIncompatible
        @J2ktIncompatible
        public InputStream k(final Reader reader) {
            Preconditions.E(reader);
            return new InputStream() {
                int X = 0;
                int Y = 0;
                boolean Z = false;
                int s = 0;

                public void close() throws IOException {
                    reader.close();
                }

                public int read() throws IOException {
                    int i2;
                    while (true) {
                        int read = reader.read();
                        if (read != -1) {
                            this.Y++;
                            char c2 = (char) read;
                            Character ch = StandardBaseEncoding.this.f22748g;
                            if (ch == null || ch.charValue() != c2) {
                                if (!this.Z) {
                                    int i3 = this.s;
                                    Alphabet alphabet = StandardBaseEncoding.this.f22747f;
                                    int i4 = i3 << alphabet.f22737d;
                                    this.s = i4;
                                    int d2 = alphabet.d(c2) | i4;
                                    this.s = d2;
                                    int i5 = this.X + StandardBaseEncoding.this.f22747f.f22737d;
                                    this.X = i5;
                                    if (i5 >= 8) {
                                        int i6 = i5 - 8;
                                        this.X = i6;
                                        return (d2 >> i6) & 255;
                                    }
                                } else {
                                    throw new DecodingException("Expected padding character but found '" + c2 + "' at index " + this.Y);
                                }
                            } else if (this.Z || ((i2 = this.Y) != 1 && StandardBaseEncoding.this.f22747f.i(i2 - 1))) {
                                this.Z = true;
                            }
                        } else if (this.Z || StandardBaseEncoding.this.f22747f.i(this.Y)) {
                            return -1;
                        } else {
                            throw new DecodingException("Invalid input length " + this.Y);
                        }
                    }
                    throw new DecodingException("Padding cannot start at index " + this.Y);
                }

                public int read(byte[] bArr, int i2, int i3) throws IOException {
                    int i4 = i3 + i2;
                    Preconditions.f0(i2, i4, bArr.length);
                    int i5 = i2;
                    while (i5 < i4) {
                        int read = read();
                        if (read == -1) {
                            int i6 = i5 - i2;
                            if (i6 == 0) {
                                return -1;
                            }
                            return i6;
                        }
                        bArr[i5] = (byte) read;
                        i5++;
                    }
                    return i5 - i2;
                }
            };
        }

        /* access modifiers changed from: package-private */
        public void n(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.E(appendable);
            Preconditions.f0(i2, i2 + i3, bArr.length);
            int i4 = 0;
            while (i4 < i3) {
                D(appendable, bArr, i2 + i4, Math.min(this.f22747f.f22739f, i3 - i4));
                i4 += this.f22747f.f22739f;
            }
        }

        @GwtIncompatible
        @J2ktIncompatible
        public OutputStream p(final Writer writer) {
            Preconditions.E(writer);
            return new OutputStream() {
                int X = 0;
                int Y = 0;
                int s = 0;

                public void close() throws IOException {
                    int i2 = this.X;
                    if (i2 > 0) {
                        int i3 = this.s;
                        Alphabet alphabet = StandardBaseEncoding.this.f22747f;
                        writer.write(alphabet.e((i3 << (alphabet.f22737d - i2)) & alphabet.f22736c));
                        this.Y++;
                        if (StandardBaseEncoding.this.f22748g != null) {
                            while (true) {
                                int i4 = this.Y;
                                StandardBaseEncoding standardBaseEncoding = StandardBaseEncoding.this;
                                if (i4 % standardBaseEncoding.f22747f.f22738e == 0) {
                                    break;
                                }
                                writer.write(standardBaseEncoding.f22748g.charValue());
                                this.Y++;
                            }
                        }
                    }
                    writer.close();
                }

                public void flush() throws IOException {
                    writer.flush();
                }

                public void write(int i2) throws IOException {
                    this.s = (i2 & 255) | (this.s << 8);
                    int i3 = this.X + 8;
                    while (true) {
                        this.X = i3;
                        int i4 = this.X;
                        Alphabet alphabet = StandardBaseEncoding.this.f22747f;
                        int i5 = alphabet.f22737d;
                        if (i4 >= i5) {
                            writer.write(alphabet.e((this.s >> (i4 - i5)) & alphabet.f22736c));
                            this.Y++;
                            i3 = this.X - StandardBaseEncoding.this.f22747f.f22737d;
                        } else {
                            return;
                        }
                    }
                }
            };
        }

        public BaseEncoding r() {
            BaseEncoding baseEncoding = this.f22751j;
            if (baseEncoding == null) {
                Alphabet h2 = this.f22747f.h();
                baseEncoding = h2 == this.f22747f ? this : E(h2, this.f22748g);
                this.f22751j = baseEncoding;
            }
            return baseEncoding;
        }

        public BaseEncoding t() {
            BaseEncoding baseEncoding = this.f22750i;
            if (baseEncoding == null) {
                Alphabet j2 = this.f22747f.j();
                baseEncoding = j2 == this.f22747f ? this : E(j2, this.f22748g);
                this.f22750i = baseEncoding;
            }
            return baseEncoding;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f22747f);
            if (8 % this.f22747f.f22737d != 0) {
                if (this.f22748g == null) {
                    str = ".omitPadding()";
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f22748g);
                    str = "')";
                }
                sb.append(str);
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public int u(int i2) {
            return (int) (((((long) this.f22747f.f22737d) * ((long) i2)) + 7) / 8);
        }

        /* access modifiers changed from: package-private */
        public int v(int i2) {
            Alphabet alphabet = this.f22747f;
            return alphabet.f22738e * IntMath.g(i2, alphabet.f22739f, RoundingMode.CEILING);
        }

        public BaseEncoding w() {
            return this.f22748g == null ? this : E(this.f22747f, (Character) null);
        }

        /* access modifiers changed from: package-private */
        public CharSequence z(CharSequence charSequence) {
            Preconditions.E(charSequence);
            Character ch = this.f22748g;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        StandardBaseEncoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }
    }

    static {
        Character valueOf = Character.valueOf(ASCIIPropertyListParser.f18654l);
        f22725a = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        f22726b = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        f22727c = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        f22728d = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
    }

    BaseEncoding() {
    }

    public static BaseEncoding a() {
        return f22729e;
    }

    public static BaseEncoding b() {
        return f22727c;
    }

    public static BaseEncoding c() {
        return f22728d;
    }

    public static BaseEncoding d() {
        return f22725a;
    }

    public static BaseEncoding e() {
        return f22726b;
    }

    private static byte[] q(byte[] bArr, int i2) {
        if (i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    @GwtIncompatible
    @J2ktIncompatible
    static Reader s(final Reader reader, final String str) {
        Preconditions.E(reader);
        Preconditions.E(str);
        return new Reader() {
            public void close() throws IOException {
                reader.close();
            }

            /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: 
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            public int read() throws java.io.IOException {
                /*
                    r3 = this;
                L_0x0000:
                    java.io.Reader r0 = r1
                    int r0 = r0.read()
                    r1 = -1
                    if (r0 == r1) goto L_0x0012
                    java.lang.String r1 = r2
                    char r2 = (char) r0
                    int r1 = r1.indexOf(r2)
                    if (r1 >= 0) goto L_0x0000
                L_0x0012:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.AnonymousClass3.read():int");
            }

            public int read(char[] cArr, int i2, int i3) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    static Appendable x(Appendable appendable, String str, int i2) {
        Preconditions.E(appendable);
        Preconditions.E(str);
        Preconditions.d(i2 > 0);
        return new Appendable(i2, appendable, str) {
            final /* synthetic */ int X;
            final /* synthetic */ Appendable Y;
            final /* synthetic */ String Z;
            int s;

            {
                this.X = r1;
                this.Y = r2;
                this.Z = r3;
                this.s = r1;
            }

            public Appendable append(char c2) throws IOException {
                if (this.s == 0) {
                    this.Y.append(this.Z);
                    this.s = this.X;
                }
                this.Y.append(c2);
                this.s--;
                return this;
            }

            public Appendable append(@CheckForNull CharSequence charSequence) {
                throw new UnsupportedOperationException();
            }

            public Appendable append(@CheckForNull CharSequence charSequence, int i2, int i3) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @GwtIncompatible
    @J2ktIncompatible
    static Writer y(final Writer writer, String str, int i2) {
        final Appendable x = x(writer, str, i2);
        return new Writer() {
            public void close() throws IOException {
                writer.close();
            }

            public void flush() throws IOException {
                writer.flush();
            }

            public void write(int i2) throws IOException {
                x.append((char) i2);
            }

            public void write(char[] cArr, int i2, int i3) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    public abstract BaseEncoding A();

    public abstract BaseEncoding B(char c2);

    public abstract BaseEncoding C(String str, int i2);

    public abstract boolean f(CharSequence charSequence);

    public final byte[] g(CharSequence charSequence) {
        try {
            return h(charSequence);
        } catch (DecodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] h(CharSequence charSequence) throws DecodingException {
        CharSequence z = z(charSequence);
        byte[] bArr = new byte[u(z.length())];
        return q(bArr, i(bArr, z));
    }

    /* access modifiers changed from: package-private */
    public abstract int i(byte[] bArr, CharSequence charSequence) throws DecodingException;

    @GwtIncompatible
    @J2ktIncompatible
    public final ByteSource j(final CharSource charSource) {
        Preconditions.E(charSource);
        return new ByteSource() {
            public InputStream m() throws IOException {
                return BaseEncoding.this.k(charSource.m());
            }
        };
    }

    @GwtIncompatible
    @J2ktIncompatible
    public abstract InputStream k(Reader reader);

    public String l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public final String m(byte[] bArr, int i2, int i3) {
        Preconditions.f0(i2, i2 + i3, bArr.length);
        StringBuilder sb = new StringBuilder(v(i3));
        try {
            n(sb, bArr, i2, i3);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void n(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException;

    @GwtIncompatible
    @J2ktIncompatible
    public final ByteSink o(final CharSink charSink) {
        Preconditions.E(charSink);
        return new ByteSink() {
            public OutputStream c() throws IOException {
                return BaseEncoding.this.p(charSink.b());
            }
        };
    }

    @GwtIncompatible
    @J2ktIncompatible
    public abstract OutputStream p(Writer writer);

    public abstract BaseEncoding r();

    public abstract BaseEncoding t();

    /* access modifiers changed from: package-private */
    public abstract int u(int i2);

    /* access modifiers changed from: package-private */
    public abstract int v(int i2);

    public abstract BaseEncoding w();

    /* access modifiers changed from: package-private */
    public CharSequence z(CharSequence charSequence) {
        return (CharSequence) Preconditions.E(charSequence);
    }
}
