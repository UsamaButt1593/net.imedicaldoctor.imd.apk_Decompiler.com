package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@Immutable
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
    private static final long X = 0;
    final HashFunction[] s;

    AbstractCompositeHashFunction(HashFunction... hashFunctionArr) {
        for (HashFunction E : hashFunctionArr) {
            Preconditions.E(E);
        }
        this.s = hashFunctionArr;
    }

    private Hasher l(final Hasher[] hasherArr) {
        return new Hasher() {
            public Hasher a(double d2) {
                for (Hasher a2 : hasherArr) {
                    a2.a(d2);
                }
                return this;
            }

            public Hasher b(short s) {
                for (Hasher b2 : hasherArr) {
                    b2.b(s);
                }
                return this;
            }

            public Hasher c(boolean z) {
                for (Hasher c2 : hasherArr) {
                    c2.c(z);
                }
                return this;
            }

            public Hasher d(float f2) {
                for (Hasher d2 : hasherArr) {
                    d2.d(f2);
                }
                return this;
            }

            public Hasher e(int i2) {
                for (Hasher e2 : hasherArr) {
                    e2.e(i2);
                }
                return this;
            }

            public Hasher f(long j2) {
                for (Hasher f2 : hasherArr) {
                    f2.f(j2);
                }
                return this;
            }

            public Hasher g(byte[] bArr) {
                for (Hasher g2 : hasherArr) {
                    g2.g(bArr);
                }
                return this;
            }

            public Hasher h(byte b2) {
                for (Hasher h2 : hasherArr) {
                    h2.h(b2);
                }
                return this;
            }

            public Hasher i(CharSequence charSequence) {
                for (Hasher i2 : hasherArr) {
                    i2.i(charSequence);
                }
                return this;
            }

            public Hasher j(byte[] bArr, int i2, int i3) {
                for (Hasher j2 : hasherArr) {
                    j2.j(bArr, i2, i3);
                }
                return this;
            }

            public Hasher k(char c2) {
                for (Hasher k2 : hasherArr) {
                    k2.k(c2);
                }
                return this;
            }

            public Hasher l(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                for (Hasher l2 : hasherArr) {
                    Java8Compatibility.d(byteBuffer, position);
                    l2.l(byteBuffer);
                }
                return this;
            }

            public Hasher m(CharSequence charSequence, Charset charset) {
                for (Hasher m2 : hasherArr) {
                    m2.m(charSequence, charset);
                }
                return this;
            }

            public <T> Hasher n(@ParametricNullness T t, Funnel<? super T> funnel) {
                for (Hasher n2 : hasherArr) {
                    n2.n(t, funnel);
                }
                return this;
            }

            public HashCode o() {
                return AbstractCompositeHashFunction.this.m(hasherArr);
            }
        };
    }

    public Hasher b() {
        int length = this.s.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i2 = 0; i2 < length; i2++) {
            hasherArr[i2] = this.s[i2].b();
        }
        return l(hasherArr);
    }

    public Hasher k(int i2) {
        Preconditions.d(i2 >= 0);
        int length = this.s.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i3 = 0; i3 < length; i3++) {
            hasherArr[i3] = this.s[i3].k(i2);
        }
        return l(hasherArr);
    }

    /* access modifiers changed from: package-private */
    public abstract HashCode m(Hasher[] hasherArr);
}
