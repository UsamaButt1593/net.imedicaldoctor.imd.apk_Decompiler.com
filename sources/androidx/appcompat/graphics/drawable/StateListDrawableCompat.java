package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StateListDrawableCompat extends DrawableContainerCompat {
    private static final String k3 = "StateListDrawableCompat";
    private static final boolean l3 = false;
    private StateListState i3;
    private boolean j3;

    static class StateListState extends DrawableContainerCompat.DrawableContainerState {
        int[][] J;

        StateListState(StateListState stateListState, StateListDrawableCompat stateListDrawableCompat, Resources resources) {
            super(stateListState, stateListDrawableCompat, resources);
            if (stateListState != null) {
                this.J = stateListState.J;
            } else {
                this.J = new int[g()][];
            }
        }

        /* access modifiers changed from: package-private */
        public int D(int[] iArr, Drawable drawable) {
            int a2 = a(drawable);
            this.J[a2] = iArr;
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int E(int[] iArr) {
            int[][] iArr2 = this.J;
            int i2 = i();
            for (int i3 = 0; i3 < i2; i3++) {
                if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                    return i3;
                }
            }
            return -1;
        }

        @NonNull
        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, (Resources) null);
        }

        public void r(int i2, int i3) {
            super.r(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.J, 0, iArr, 0, i2);
            this.J = iArr;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.J[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.J = iArr2;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new StateListDrawableCompat(this, resources);
        }
    }

    public StateListDrawableCompat() {
        this((StateListState) null, (Resources) null);
    }

    private void w(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        StateListState stateListState = this.i3;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next2 == 3) {
                    return;
                }
                if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, R.styleable.w);
                    int resourceId = s.getResourceId(R.styleable.x, -1);
                    Drawable j2 = resourceId > 0 ? ResourceManagerInternal.h().j(context, resourceId) : null;
                    s.recycle();
                    int[] p = p(attributeSet);
                    if (j2 == null) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next == 2) {
                            j2 = Compatibility.Api21Impl.a(resources, xmlPullParser, attributeSet, theme);
                        } else {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                    }
                    stateListState.D(p, j2);
                }
            } else {
                return;
            }
        }
    }

    private void x(TypedArray typedArray) {
        StateListState stateListState = this.i3;
        stateListState.f2864d |= Compatibility.Api21Impl.b(typedArray);
        stateListState.f2869i = typedArray.getBoolean(R.styleable.s, stateListState.f2869i);
        stateListState.f2872l = typedArray.getBoolean(R.styleable.t, stateListState.f2872l);
        stateListState.A = typedArray.getInt(R.styleable.u, stateListState.A);
        stateListState.B = typedArray.getInt(R.styleable.v, stateListState.B);
        stateListState.x = typedArray.getBoolean(R.styleable.q, stateListState.x);
    }

    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    public void b() {
        super.b();
        this.j3 = false;
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.i(drawableContainerState);
        if (drawableContainerState instanceof StateListState) {
            this.i3 = (StateListState) drawableContainerState;
        }
    }

    public boolean isStateful() {
        return true;
    }

    @NonNull
    public Drawable mutate() {
        if (!this.j3 && super.mutate() == this) {
            this.i3.v();
            this.j3 = true;
        }
        return this;
    }

    public void n(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.i3.D(iArr, drawable);
            onStateChange(getState());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public StateListState c() {
        return new StateListState(this.i3, this, (Resources) null);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int E = this.i3.E(iArr);
        if (E < 0) {
            E = this.i3.E(StateSet.WILD_CARD);
        }
        return h(E) || onStateChange;
    }

    /* access modifiers changed from: package-private */
    public int[] p(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i2 = 0;
        for (int i4 = 0; i4 < attributeCount; i4++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i4);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i5 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i5;
            }
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.i3.i();
    }

    /* access modifiers changed from: package-private */
    public Drawable r(int i2) {
        return this.i3.h(i2);
    }

    /* access modifiers changed from: package-private */
    public int s(int[] iArr) {
        return this.i3.E(iArr);
    }

    /* access modifiers changed from: package-private */
    public StateListState t() {
        return this.i3;
    }

    /* access modifiers changed from: package-private */
    public int[] u(int i2) {
        return this.i3.J[i2];
    }

    public void v(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, R.styleable.p);
        setVisible(s.getBoolean(R.styleable.r, true), true);
        x(s);
        m(resources);
        s.recycle();
        w(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    StateListDrawableCompat(@Nullable StateListState stateListState) {
        if (stateListState != null) {
            i(stateListState);
        }
    }

    StateListDrawableCompat(StateListState stateListState, Resources resources) {
        i(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }
}
