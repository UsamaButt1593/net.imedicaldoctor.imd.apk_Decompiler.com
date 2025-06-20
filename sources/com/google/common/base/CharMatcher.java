package com.google.common.base;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.BitSet;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class CharMatcher implements Predicate<Character> {
    private static final int s = 65536;

    private static final class And extends CharMatcher {
        final CharMatcher X;
        final CharMatcher Y;

        And(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.X = (CharMatcher) Preconditions.E(charMatcher);
            this.Y = (CharMatcher) Preconditions.E(charMatcher2);
        }

        public boolean B(char c2) {
            return this.X.B(c2) && this.Y.B(c2);
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public void Q(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.X.Q(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.Y.Q(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            return "CharMatcher.and(" + this.X + ", " + this.Y + ")";
        }
    }

    private static final class Any extends NamedFastMatcher {
        static final Any Y = new Any();

        private Any() {
            super("CharMatcher.any()");
        }

        public int A(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        public boolean B(char c2) {
            return true;
        }

        public boolean C(CharSequence charSequence) {
            Preconditions.E(charSequence);
            return true;
        }

        public boolean E(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public CharMatcher F() {
            return CharMatcher.G();
        }

        public CharMatcher I(CharMatcher charMatcher) {
            Preconditions.E(charMatcher);
            return this;
        }

        public String M(CharSequence charSequence) {
            Preconditions.E(charSequence);
            return "";
        }

        public String N(CharSequence charSequence, char c2) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c2);
            return new String(cArr);
        }

        public String O(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }

        public String U(CharSequence charSequence) {
            Preconditions.E(charSequence);
            return "";
        }

        public CharMatcher b(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.E(charMatcher);
        }

        public String h(CharSequence charSequence, char c2) {
            return charSequence.length() == 0 ? "" : String.valueOf(c2);
        }

        public int i(CharSequence charSequence) {
            return charSequence.length();
        }

        public int n(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        public int o(CharSequence charSequence, int i2) {
            int length = charSequence.length();
            Preconditions.d0(i2, length);
            if (i2 == length) {
                return -1;
            }
            return i2;
        }
    }

    private static final class AnyOf extends CharMatcher {
        private final char[] X;

        public AnyOf(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.X = charArray;
            Arrays.sort(charArray);
        }

        public boolean B(char c2) {
            return Arrays.binarySearch(this.X, c2) >= 0;
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public void Q(BitSet bitSet) {
            for (char c2 : this.X) {
                bitSet.set(c2);
            }
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char a2 : this.X) {
                sb.append(CharMatcher.R(a2));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    private static final class Ascii extends NamedFastMatcher {
        static final Ascii Y = new Ascii();

        Ascii() {
            super("CharMatcher.ascii()");
        }

        public boolean B(char c2) {
            return c2 <= 127;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static final class BitSetMatcher extends NamedFastMatcher {
        private final BitSet Y;

        private BitSetMatcher(BitSet bitSet, String str) {
            super(str);
            this.Y = bitSet.length() + 64 < bitSet.size() ? (BitSet) bitSet.clone() : bitSet;
        }

        public boolean B(char c2) {
            return this.Y.get(c2);
        }

        /* access modifiers changed from: package-private */
        public void Q(BitSet bitSet) {
            bitSet.or(this.Y);
        }
    }

    private static final class BreakingWhitespace extends CharMatcher {
        static final CharMatcher X = new BreakingWhitespace();

        private BreakingWhitespace() {
        }

        public boolean B(char c2) {
            if (!(c2 == ' ' || c2 == 133 || c2 == 5760)) {
                if (c2 == 8199) {
                    return false;
                }
                if (!(c2 == 8287 || c2 == 12288 || c2 == 8232 || c2 == 8233)) {
                    switch (c2) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            return c2 >= 8192 && c2 <= 8202;
                    }
                }
            }
            return true;
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    private static final class Digit extends RangesMatcher {
        private static final String X2 = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";
        static final Digit Y2 = new Digit();

        private Digit() {
            super("CharMatcher.digit()", Z(), Y());
        }

        private static char[] Y() {
            char[] cArr = new char[37];
            for (int i2 = 0; i2 < 37; i2++) {
                cArr[i2] = (char) (X2.charAt(i2) + 9);
            }
            return cArr;
        }

        private static char[] Z() {
            return X2.toCharArray();
        }
    }

    static abstract class FastMatcher extends CharMatcher {
        FastMatcher() {
        }

        public CharMatcher F() {
            return new NegatedFastMatcher(this);
        }

        public final CharMatcher J() {
            return this;
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }
    }

    private static final class ForPredicate extends CharMatcher {
        private final Predicate<? super Character> X;

        ForPredicate(Predicate<? super Character> predicate) {
            this.X = (Predicate) Preconditions.E(predicate);
        }

        public boolean B(char c2) {
            return this.X.apply(Character.valueOf(c2));
        }

        /* renamed from: e */
        public boolean apply(Character ch) {
            return this.X.apply(Preconditions.E(ch));
        }

        public String toString() {
            return "CharMatcher.forPredicate(" + this.X + ")";
        }
    }

    private static final class InRange extends FastMatcher {
        private final char X;
        private final char Y;

        InRange(char c2, char c3) {
            Preconditions.d(c3 >= c2);
            this.X = c2;
            this.Y = c3;
        }

        public boolean B(char c2) {
            return this.X <= c2 && c2 <= this.Y;
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public void Q(BitSet bitSet) {
            bitSet.set(this.X, this.Y + 1);
        }

        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.R(this.X) + "', '" + CharMatcher.R(this.Y) + "')";
        }
    }

    private static final class Invisible extends RangesMatcher {
        private static final String X2 = "\u0000­؀؜۝܏࢐࣢ ᠎   ⁦　?﻿￹";
        private static final String Y2 = "  ­؅؜۝܏࢑࣢ ᠎‏ ⁤⁯　﻿￻";
        static final Invisible Z2 = new Invisible();

        private Invisible() {
            super("CharMatcher.invisible()", X2.toCharArray(), Y2.toCharArray());
        }
    }

    private static final class Is extends FastMatcher {
        private final char X;

        Is(char c2) {
            this.X = c2;
        }

        public boolean B(char c2) {
            return c2 == this.X;
        }

        public CharMatcher F() {
            return CharMatcher.s(this.X);
        }

        public CharMatcher I(CharMatcher charMatcher) {
            return charMatcher.B(this.X) ? charMatcher : CharMatcher.super.I(charMatcher);
        }

        public String N(CharSequence charSequence, char c2) {
            return charSequence.toString().replace(this.X, c2);
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public void Q(BitSet bitSet) {
            bitSet.set(this.X);
        }

        public CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.B(this.X) ? this : CharMatcher.G();
        }

        public String toString() {
            return "CharMatcher.is('" + CharMatcher.R(this.X) + "')";
        }
    }

    private static final class IsEither extends FastMatcher {
        private final char X;
        private final char Y;

        IsEither(char c2, char c3) {
            this.X = c2;
            this.Y = c3;
        }

        public boolean B(char c2) {
            return c2 == this.X || c2 == this.Y;
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public void Q(BitSet bitSet) {
            bitSet.set(this.X);
            bitSet.set(this.Y);
        }

        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.R(this.X) + CharMatcher.R(this.Y) + "\")";
        }
    }

    private static final class IsNot extends FastMatcher {
        private final char X;

        IsNot(char c2) {
            this.X = c2;
        }

        public boolean B(char c2) {
            return c2 != this.X;
        }

        public CharMatcher F() {
            return CharMatcher.q(this.X);
        }

        public CharMatcher I(CharMatcher charMatcher) {
            return charMatcher.B(this.X) ? CharMatcher.c() : this;
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public void Q(BitSet bitSet) {
            bitSet.set(0, this.X);
            bitSet.set(this.X + 1, 65536);
        }

        public CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.B(this.X) ? CharMatcher.super.b(charMatcher) : charMatcher;
        }

        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.R(this.X) + "')";
        }
    }

    private static final class JavaDigit extends CharMatcher {
        static final JavaDigit X = new JavaDigit();

        private JavaDigit() {
        }

        public boolean B(char c2) {
            return Character.isDigit(c2);
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    private static final class JavaIsoControl extends NamedFastMatcher {
        static final JavaIsoControl Y = new JavaIsoControl();

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        public boolean B(char c2) {
            return c2 <= 31 || (c2 >= 127 && c2 <= 159);
        }
    }

    private static final class JavaLetter extends CharMatcher {
        static final JavaLetter X = new JavaLetter();

        private JavaLetter() {
        }

        public boolean B(char c2) {
            return Character.isLetter(c2);
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    private static final class JavaLetterOrDigit extends CharMatcher {
        static final JavaLetterOrDigit X = new JavaLetterOrDigit();

        private JavaLetterOrDigit() {
        }

        public boolean B(char c2) {
            return Character.isLetterOrDigit(c2);
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    private static final class JavaLowerCase extends CharMatcher {
        static final JavaLowerCase X = new JavaLowerCase();

        private JavaLowerCase() {
        }

        public boolean B(char c2) {
            return Character.isLowerCase(c2);
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    private static final class JavaUpperCase extends CharMatcher {
        static final JavaUpperCase X = new JavaUpperCase();

        private JavaUpperCase() {
        }

        public boolean B(char c2) {
            return Character.isUpperCase(c2);
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    static abstract class NamedFastMatcher extends FastMatcher {
        private final String X;

        NamedFastMatcher(String str) {
            this.X = (String) Preconditions.E(str);
        }

        public final String toString() {
            return this.X;
        }
    }

    private static class Negated extends CharMatcher {
        final CharMatcher X;

        Negated(CharMatcher charMatcher) {
            this.X = (CharMatcher) Preconditions.E(charMatcher);
        }

        public boolean B(char c2) {
            return !this.X.B(c2);
        }

        public boolean C(CharSequence charSequence) {
            return this.X.E(charSequence);
        }

        public boolean E(CharSequence charSequence) {
            return this.X.C(charSequence);
        }

        public CharMatcher F() {
            return this.X;
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public void Q(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.X.Q(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public int i(CharSequence charSequence) {
            return charSequence.length() - this.X.i(charSequence);
        }

        public String toString() {
            return this.X + ".negate()";
        }
    }

    static class NegatedFastMatcher extends Negated {
        NegatedFastMatcher(CharMatcher charMatcher) {
            super(charMatcher);
        }

        public final CharMatcher J() {
            return this;
        }
    }

    private static final class None extends NamedFastMatcher {
        static final None Y = new None();

        private None() {
            super("CharMatcher.none()");
        }

        public int A(CharSequence charSequence) {
            Preconditions.E(charSequence);
            return -1;
        }

        public boolean B(char c2) {
            return false;
        }

        public boolean C(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean E(CharSequence charSequence) {
            Preconditions.E(charSequence);
            return true;
        }

        public CharMatcher F() {
            return CharMatcher.c();
        }

        public CharMatcher I(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.E(charMatcher);
        }

        public String M(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String N(CharSequence charSequence, char c2) {
            return charSequence.toString();
        }

        public String O(CharSequence charSequence, CharSequence charSequence2) {
            Preconditions.E(charSequence2);
            return charSequence.toString();
        }

        public String U(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String V(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String W(CharSequence charSequence) {
            return charSequence.toString();
        }

        public CharMatcher b(CharMatcher charMatcher) {
            Preconditions.E(charMatcher);
            return this;
        }

        public String h(CharSequence charSequence, char c2) {
            return charSequence.toString();
        }

        public int i(CharSequence charSequence) {
            Preconditions.E(charSequence);
            return 0;
        }

        public int n(CharSequence charSequence) {
            Preconditions.E(charSequence);
            return -1;
        }

        public int o(CharSequence charSequence, int i2) {
            Preconditions.d0(i2, charSequence.length());
            return -1;
        }
    }

    private static final class Or extends CharMatcher {
        final CharMatcher X;
        final CharMatcher Y;

        Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.X = (CharMatcher) Preconditions.E(charMatcher);
            this.Y = (CharMatcher) Preconditions.E(charMatcher2);
        }

        public boolean B(char c2) {
            return this.X.B(c2) || this.Y.B(c2);
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public void Q(BitSet bitSet) {
            this.X.Q(bitSet);
            this.Y.Q(bitSet);
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            return "CharMatcher.or(" + this.X + ", " + this.Y + ")";
        }
    }

    private static class RangesMatcher extends CharMatcher {
        private final String X;
        private final char[] Y;
        private final char[] Z;

        RangesMatcher(String str, char[] cArr, char[] cArr2) {
            this.X = str;
            this.Y = cArr;
            this.Z = cArr2;
            Preconditions.d(cArr.length == cArr2.length);
            int i2 = 0;
            while (i2 < cArr.length) {
                Preconditions.d(cArr[i2] <= cArr2[i2]);
                int i3 = i2 + 1;
                if (i3 < cArr.length) {
                    Preconditions.d(cArr2[i2] < cArr[i3]);
                }
                i2 = i3;
            }
        }

        public boolean B(char c2) {
            int binarySearch = Arrays.binarySearch(this.Y, c2);
            if (binarySearch >= 0) {
                return true;
            }
            int i2 = (~binarySearch) - 1;
            return i2 >= 0 && c2 <= this.Z[i2];
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public String toString() {
            return this.X;
        }
    }

    private static final class SingleWidth extends RangesMatcher {
        static final SingleWidth X2 = new SingleWidth();

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
        }
    }

    @VisibleForTesting
    static final class Whitespace extends NamedFastMatcher {
        static final int X2 = Integer.numberOfLeadingZeros(31);
        static final String Y = " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　";
        static final Whitespace Y2 = new Whitespace();
        static final int Z = 1682554634;

        Whitespace() {
            super("CharMatcher.whitespace()");
        }

        public boolean B(char c2) {
            return Y.charAt((Z * c2) >>> X2) == c2;
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public void Q(BitSet bitSet) {
            for (int i2 = 0; i2 < 32; i2++) {
                bitSet.set(Y.charAt(i2));
            }
        }
    }

    protected CharMatcher() {
    }

    public static CharMatcher G() {
        return None.Y;
    }

    public static CharMatcher H(CharSequence charSequence) {
        return d(charSequence).F();
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static CharMatcher L(int i2, BitSet bitSet, String str) {
        if (i2 == 0) {
            return G();
        }
        if (i2 == 1) {
            return q((char) bitSet.nextSetBit(0));
        }
        if (i2 != 2) {
            return t(i2, bitSet.length()) ? SmallCharMatcher.a0(bitSet, str) : new BitSetMatcher(bitSet, str);
        }
        char nextSetBit = (char) bitSet.nextSetBit(0);
        return r(nextSetBit, (char) bitSet.nextSetBit(nextSetBit + 1));
    }

    /* access modifiers changed from: private */
    public static String R(char c2) {
        char[] cArr = {ASCIIPropertyListParser.p, 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = BinTools.f30545a.charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public static CharMatcher S() {
        return SingleWidth.X2;
    }

    public static CharMatcher X() {
        return Whitespace.Y2;
    }

    public static CharMatcher c() {
        return Any.Y;
    }

    public static CharMatcher d(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return G();
        }
        if (length != 1) {
            return length != 2 ? new AnyOf(charSequence) : r(charSequence.charAt(0), charSequence.charAt(1));
        }
        return q(charSequence.charAt(0));
    }

    public static CharMatcher f() {
        return Ascii.Y;
    }

    public static CharMatcher g() {
        return BreakingWhitespace.X;
    }

    @Deprecated
    public static CharMatcher j() {
        return Digit.Y2;
    }

    private String k(CharSequence charSequence, int i2, int i3, char c2, StringBuilder sb, boolean z) {
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            if (!B(charAt)) {
                sb.append(charAt);
                z = false;
            } else if (!z) {
                sb.append(c2);
                z = true;
            }
            i2++;
        }
        return sb.toString();
    }

    public static CharMatcher l(Predicate<? super Character> predicate) {
        return predicate instanceof CharMatcher ? (CharMatcher) predicate : new ForPredicate(predicate);
    }

    public static CharMatcher m(char c2, char c3) {
        return new InRange(c2, c3);
    }

    @Deprecated
    public static CharMatcher p() {
        return Invisible.Z2;
    }

    public static CharMatcher q(char c2) {
        return new Is(c2);
    }

    private static IsEither r(char c2, char c3) {
        return new IsEither(c2, c3);
    }

    public static CharMatcher s(char c2) {
        return new IsNot(c2);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static boolean t(int i2, int i3) {
        return i2 <= 1023 && i3 > i2 * 64;
    }

    @Deprecated
    public static CharMatcher u() {
        return JavaDigit.X;
    }

    public static CharMatcher v() {
        return JavaIsoControl.Y;
    }

    @Deprecated
    public static CharMatcher w() {
        return JavaLetter.X;
    }

    @Deprecated
    public static CharMatcher x() {
        return JavaLetterOrDigit.X;
    }

    @Deprecated
    public static CharMatcher y() {
        return JavaLowerCase.X;
    }

    @Deprecated
    public static CharMatcher z() {
        return JavaUpperCase.X;
    }

    public int A(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (B(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean B(char c2);

    public boolean C(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!B(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean D(CharSequence charSequence) {
        return !E(charSequence);
    }

    public boolean E(CharSequence charSequence) {
        return n(charSequence) == -1;
    }

    public CharMatcher F() {
        return new Negated(this);
    }

    public CharMatcher I(CharMatcher charMatcher) {
        return new Or(this, charMatcher);
    }

    public CharMatcher J() {
        return Platform.i(this);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @J2ktIncompatible
    public CharMatcher K() {
        String str;
        BitSet bitSet = new BitSet();
        Q(bitSet);
        int cardinality = bitSet.cardinality();
        if (cardinality * 2 <= 65536) {
            return L(cardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i2 = 65536 - cardinality;
        final String charMatcher = toString();
        if (charMatcher.endsWith(".negate()")) {
            str = charMatcher.substring(0, charMatcher.length() - 9);
        } else {
            str = charMatcher + ".negate()";
        }
        return new NegatedFastMatcher(this, L(i2, bitSet, str)) {
            public String toString() {
                return charMatcher;
            }
        };
    }

    public String M(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int n2 = n(charSequence2);
        if (n2 == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        int i2 = 1;
        while (true) {
            n2++;
            while (n2 != charArray.length) {
                if (B(charArray[n2])) {
                    i2++;
                } else {
                    charArray[n2 - i2] = charArray[n2];
                    n2++;
                }
            }
            return new String(charArray, 0, n2 - i2);
        }
    }

    public String N(CharSequence charSequence, char c2) {
        String charSequence2 = charSequence.toString();
        int n2 = n(charSequence2);
        if (n2 == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        charArray[n2] = c2;
        while (true) {
            n2++;
            if (n2 >= charArray.length) {
                return new String(charArray);
            }
            if (B(charArray[n2])) {
                charArray[n2] = c2;
            }
        }
    }

    public String O(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return M(charSequence);
        }
        int i2 = 0;
        if (length == 1) {
            return N(charSequence, charSequence2.charAt(0));
        }
        String charSequence3 = charSequence.toString();
        int n2 = n(charSequence3);
        if (n2 == -1) {
            return charSequence3;
        }
        int length2 = charSequence3.length();
        StringBuilder sb = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append(charSequence3, i2, n2);
            sb.append(charSequence2);
            i2 = n2 + 1;
            n2 = o(charSequence3, i2);
        } while (n2 != -1);
        sb.append(charSequence3, i2, length2);
        return sb.toString();
    }

    public String P(CharSequence charSequence) {
        return F().M(charSequence);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @J2ktIncompatible
    public void Q(BitSet bitSet) {
        for (int i2 = 65535; i2 >= 0; i2--) {
            if (B((char) i2)) {
                bitSet.set(i2);
            }
        }
    }

    public String T(CharSequence charSequence, char c2) {
        int length = charSequence.length();
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < length && B(charSequence.charAt(i3))) {
            i3++;
        }
        int i4 = i2;
        while (i4 > i3 && B(charSequence.charAt(i4))) {
            i4--;
        }
        if (i3 == 0 && i4 == i2) {
            return h(charSequence, c2);
        }
        int i5 = i4 + 1;
        return k(charSequence, i3, i5, c2, new StringBuilder(i5 - i3), false);
    }

    public String U(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && B(charSequence.charAt(i2))) {
            i2++;
        }
        int i3 = length - 1;
        while (i3 > i2 && B(charSequence.charAt(i3))) {
            i3--;
        }
        return charSequence.subSequence(i2, i3 + 1).toString();
    }

    public String V(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!B(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, length).toString();
            }
        }
        return "";
    }

    public String W(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!B(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public CharMatcher b(CharMatcher charMatcher) {
        return new And(this, charMatcher);
    }

    @Deprecated
    /* renamed from: e */
    public boolean apply(Character ch) {
        return B(ch.charValue());
    }

    public String h(CharSequence charSequence, char c2) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (B(charAt)) {
                if (charAt != c2 || (i2 != length - 1 && B(charSequence.charAt(i2 + 1)))) {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i2);
                    sb.append(c2);
                    return k(charSequence, i2 + 1, length, c2, sb, true);
                }
                i2++;
            }
            i2++;
        }
        return charSequence.toString();
    }

    public int i(CharSequence charSequence) {
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (B(charSequence.charAt(i3))) {
                i2++;
            }
        }
        return i2;
    }

    public int n(CharSequence charSequence) {
        return o(charSequence, 0);
    }

    public int o(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        Preconditions.d0(i2, length);
        while (i2 < length) {
            if (B(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public String toString() {
        return super.toString();
    }
}
