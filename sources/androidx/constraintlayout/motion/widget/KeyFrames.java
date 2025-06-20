package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KeyFrames {

    /* renamed from: b  reason: collision with root package name */
    public static final int f4408b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static final String f4409c = "CustomMethod";

    /* renamed from: d  reason: collision with root package name */
    private static final String f4410d = "CustomAttribute";

    /* renamed from: e  reason: collision with root package name */
    static HashMap<String, Constructor<? extends Key>> f4411e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final String f4412f = "KeyFrames";

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, ArrayList<Key>> f4413a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        f4411e = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor((Class[]) null));
            f4411e.put(TypedValues.PositionType.f4010a, KeyPosition.class.getConstructor((Class[]) null));
            f4411e.put(TypedValues.CycleType.f3962a, KeyCycle.class.getConstructor((Class[]) null));
            f4411e.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor((Class[]) null));
            f4411e.put(TypedValues.TriggerType.f4038a, KeyTrigger.class.getConstructor((Class[]) null));
        } catch (NoSuchMethodException e2) {
            Log.e(f4412f, "unable to load", e2);
        }
    }

    public KeyFrames() {
    }

    static String f(int i2, Context context) {
        return context.getResources().getResourceEntryName(i2);
    }

    public void a(MotionController motionController) {
        ArrayList arrayList = this.f4413a.get(-1);
        if (arrayList != null) {
            motionController.b(arrayList);
        }
    }

    public void b(MotionController motionController) {
        ArrayList arrayList = this.f4413a.get(Integer.valueOf(motionController.f4457c));
        if (arrayList != null) {
            motionController.b(arrayList);
        }
        ArrayList arrayList2 = this.f4413a.get(-1);
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Key key = (Key) it2.next();
                if (key.g(((ConstraintLayout.LayoutParams) motionController.f4456b.getLayoutParams()).c0)) {
                    motionController.a(key);
                }
            }
        }
    }

    public void c(Key key) {
        if (!this.f4413a.containsKey(Integer.valueOf(key.f4376b))) {
            this.f4413a.put(Integer.valueOf(key.f4376b), new ArrayList());
        }
        ArrayList arrayList = this.f4413a.get(Integer.valueOf(key.f4376b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> d(int i2) {
        return this.f4413a.get(Integer.valueOf(i2));
    }

    public Set<Integer> e() {
        return this.f4413a.keySet();
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        HashMap<String, ConstraintAttribute> hashMap;
        Exception e2;
        Key key;
        try {
            int eventType = xmlPullParser.getEventType();
            Key key2 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (f4411e.containsKey(name)) {
                        try {
                            Constructor constructor = f4411e.get(name);
                            if (constructor != null) {
                                key = (Key) constructor.newInstance((Object[]) null);
                                try {
                                    key.f(context, Xml.asAttributeSet(xmlPullParser));
                                    c(key);
                                } catch (Exception e3) {
                                    e2 = e3;
                                    Log.e(f4412f, "unable to create ", e2);
                                    key2 = key;
                                    eventType = xmlPullParser.next();
                                }
                                key2 = key;
                            } else {
                                throw new NullPointerException("Keymaker for " + name + " not found");
                            }
                        } catch (Exception e4) {
                            Key key3 = key2;
                            e2 = e4;
                            key = key3;
                            Log.e(f4412f, "unable to create ", e2);
                            key2 = key;
                            eventType = xmlPullParser.next();
                        }
                    } else {
                        if (name.equalsIgnoreCase("CustomAttribute")) {
                            if (key2 != null) {
                                hashMap = key2.f4379e;
                                if (hashMap == null) {
                                }
                            }
                        } else if (!(!name.equalsIgnoreCase("CustomMethod") || key2 == null || (hashMap = key2.f4379e) == null)) {
                        }
                        ConstraintAttribute.q(context, xmlPullParser, hashMap);
                    }
                } else if (eventType == 3) {
                    if (ViewTransition.z.equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }
}
