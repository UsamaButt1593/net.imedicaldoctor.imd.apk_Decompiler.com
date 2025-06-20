package androidx.transition;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TransitionInflater {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f16080b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    private static final ArrayMap<String, Constructor<?>> f16081c = new ArrayMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final Context f16082a;

    private TransitionInflater(@NonNull Context context) {
        this.f16082a = context;
    }

    private Object a(AttributeSet attributeSet, Class<?> cls, String str) {
        Object newInstance;
        Class<? extends U> asSubclass;
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        if (attributeValue != null) {
            try {
                ArrayMap<String, Constructor<?>> arrayMap = f16081c;
                synchronized (arrayMap) {
                    Constructor<? extends U> constructor = arrayMap.get(attributeValue);
                    if (constructor == null && (asSubclass = Class.forName(attributeValue, false, this.f16082a.getClassLoader()).asSubclass(cls)) != null) {
                        constructor = asSubclass.getConstructor(f16080b);
                        constructor.setAccessible(true);
                        arrayMap.put(attributeValue, constructor);
                    }
                    newInstance = constructor.newInstance(new Object[]{this.f16082a, attributeSet});
                }
                return newInstance;
            } catch (Exception e2) {
                throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e2);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
    }

    @Nullable
    private Transition b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        Transition transition2;
        PathMotion patternPathMotion;
        int depth = xmlPullParser.getDepth();
        TransitionSet transitionSet = transition instanceof TransitionSet ? (TransitionSet) transition : null;
        loop0:
        while (true) {
            transition2 = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if ("fade".equals(name)) {
                            transition2 = new Fade(this.f16082a, attributeSet);
                        } else if ("changeBounds".equals(name)) {
                            transition2 = new ChangeBounds(this.f16082a, attributeSet);
                        } else if ("slide".equals(name)) {
                            transition2 = new Slide(this.f16082a, attributeSet);
                        } else if ("explode".equals(name)) {
                            transition2 = new Explode(this.f16082a, attributeSet);
                        } else if ("changeImageTransform".equals(name)) {
                            transition2 = new ChangeImageTransform(this.f16082a, attributeSet);
                        } else if ("changeTransform".equals(name)) {
                            transition2 = new ChangeTransform(this.f16082a, attributeSet);
                        } else if ("changeClipBounds".equals(name)) {
                            transition2 = new ChangeClipBounds(this.f16082a, attributeSet);
                        } else if (TypedValues.TransitionType.f4029f.equals(name)) {
                            transition2 = new AutoTransition(this.f16082a, attributeSet);
                        } else if ("changeScroll".equals(name)) {
                            transition2 = new ChangeScroll(this.f16082a, attributeSet);
                        } else if ("transitionSet".equals(name)) {
                            transition2 = new TransitionSet(this.f16082a, attributeSet);
                        } else if ("transition".equals(name)) {
                            transition2 = (Transition) a(attributeSet, Transition.class, "transition");
                        } else if ("targets".equals(name)) {
                            e(xmlPullParser, attributeSet, transition);
                        } else {
                            if ("arcMotion".equals(name)) {
                                if (transition != null) {
                                    patternPathMotion = new ArcMotion(this.f16082a, attributeSet);
                                } else {
                                    throw new RuntimeException("Invalid use of arcMotion element");
                                }
                            } else if ("pathMotion".equals(name)) {
                                if (transition != null) {
                                    patternPathMotion = (PathMotion) a(attributeSet, PathMotion.class, "pathMotion");
                                } else {
                                    throw new RuntimeException("Invalid use of pathMotion element");
                                }
                            } else if (!"patternPathMotion".equals(name)) {
                                throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                            } else if (transition != null) {
                                patternPathMotion = new PatternPathMotion(this.f16082a, attributeSet);
                            } else {
                                throw new RuntimeException("Invalid use of patternPathMotion element");
                            }
                            transition.u1(patternPathMotion);
                        }
                        if (transition2 == null) {
                            continue;
                        } else {
                            if (!xmlPullParser.isEmptyElementTag()) {
                                b(xmlPullParser, attributeSet, transition2);
                            }
                            if (transitionSet != null) {
                                break;
                            } else if (transition != null) {
                                throw new InflateException("Could not add transition to another transition.");
                            }
                        }
                    }
                }
            }
            transitionSet.R1(transition2);
        }
        return transition2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        return r1;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.transition.TransitionManager c(org.xmlpull.v1.XmlPullParser r5, android.util.AttributeSet r6, @androidx.annotation.NonNull android.view.ViewGroup r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r4 = this;
            int r0 = r5.getDepth()
            r1 = 0
        L_0x0005:
            int r2 = r5.next()
            r3 = 3
            if (r2 != r3) goto L_0x0012
            int r3 = r5.getDepth()
            if (r3 <= r0) goto L_0x0054
        L_0x0012:
            r3 = 1
            if (r2 == r3) goto L_0x0054
            r3 = 2
            if (r2 == r3) goto L_0x0019
            goto L_0x0005
        L_0x0019:
            java.lang.String r2 = r5.getName()
            java.lang.String r3 = "transitionManager"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x002b
            androidx.transition.TransitionManager r1 = new androidx.transition.TransitionManager
            r1.<init>()
            goto L_0x0005
        L_0x002b:
            java.lang.String r3 = "transition"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0039
            r4.h(r6, r5, r7, r1)
            goto L_0x0005
        L_0x0039:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unknown scene name: "
            r7.append(r0)
            java.lang.String r5 = r5.getName()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L_0x0054:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionInflater.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.ViewGroup):androidx.transition.TransitionManager");
    }

    @NonNull
    public static TransitionInflater d(@NonNull Context context) {
        return new TransitionInflater(context);
    }

    private void e(XmlPullParser xmlPullParser, AttributeSet attributeSet, @NonNull Transition transition) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (xmlPullParser.getName().equals(TypedValues.AttributesType.M)) {
                    TypedArray obtainStyledAttributes = this.f16082a.obtainStyledAttributes(attributeSet, Styleable.f16034a);
                    int l2 = TypedArrayUtils.l(obtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                    if (l2 != 0) {
                        transition.d(l2);
                    } else {
                        int l3 = TypedArrayUtils.l(obtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                        if (l3 != 0) {
                            transition.E(l3, true);
                        } else {
                            String m2 = TypedArrayUtils.m(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                            if (m2 != null) {
                                transition.g(m2);
                            } else {
                                String m3 = TypedArrayUtils.m(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                                if (m3 != null) {
                                    transition.J(m3, true);
                                } else {
                                    String m4 = TypedArrayUtils.m(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                    if (m4 != null) {
                                        try {
                                            transition.G(Class.forName(m4), true);
                                        } catch (ClassNotFoundException e2) {
                                            obtainStyledAttributes.recycle();
                                            throw new RuntimeException("Could not create " + m4, e2);
                                        }
                                    } else {
                                        String m5 = TypedArrayUtils.m(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                        if (m5 != null) {
                                            transition.f(Class.forName(m5));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obtainStyledAttributes.recycle();
                } else {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
            }
        }
    }

    private void h(AttributeSet attributeSet, XmlPullParser xmlPullParser, @NonNull ViewGroup viewGroup, TransitionManager transitionManager) throws Resources.NotFoundException {
        Transition f2;
        TypedArray obtainStyledAttributes = this.f16082a.obtainStyledAttributes(attributeSet, Styleable.f16035b);
        int l2 = TypedArrayUtils.l(obtainStyledAttributes, xmlPullParser, "transition", 2, -1);
        int l3 = TypedArrayUtils.l(obtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        Scene scene = null;
        Scene d2 = l3 < 0 ? null : Scene.d(viewGroup, l3, this.f16082a);
        int l4 = TypedArrayUtils.l(obtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        if (l4 >= 0) {
            scene = Scene.d(viewGroup, l4, this.f16082a);
        }
        if (l2 >= 0 && (f2 = f(l2)) != null) {
            if (scene == null) {
                throw new RuntimeException("No toScene for transition ID " + l2);
            } else if (d2 == null) {
                transitionManager.n(scene, f2);
            } else {
                transitionManager.m(d2, scene, f2);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Nullable
    public Transition f(int i2) {
        XmlResourceParser xml = this.f16082a.getResources().getXml(i2);
        try {
            Transition b2 = b(xml, Xml.asAttributeSet(xml), (Transition) null);
            xml.close();
            return b2;
        } catch (XmlPullParserException e2) {
            throw new InflateException(e2.getMessage(), e2);
        } catch (IOException e3) {
            throw new InflateException(xml.getPositionDescription() + ": " + e3.getMessage(), e3);
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    @Nullable
    public TransitionManager g(int i2, @NonNull ViewGroup viewGroup) {
        XmlResourceParser xml = this.f16082a.getResources().getXml(i2);
        try {
            TransitionManager c2 = c(xml, Xml.asAttributeSet(xml), viewGroup);
            xml.close();
            return c2;
        } catch (XmlPullParserException e2) {
            InflateException inflateException = new InflateException(e2.getMessage());
            inflateException.initCause(e2);
            throw inflateException;
        } catch (IOException e3) {
            InflateException inflateException2 = new InflateException(xml.getPositionDescription() + ": " + e3.getMessage());
            inflateException2.initCause(e3);
            throw inflateException2;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
