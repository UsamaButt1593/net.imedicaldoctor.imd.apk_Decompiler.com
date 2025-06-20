package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SpreadBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Object> f28970a;

    public SpreadBuilder(int i2) {
        this.f28970a = new ArrayList<>(i2);
    }

    public void a(Object obj) {
        this.f28970a.add(obj);
    }

    public void b(Object obj) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    ArrayList<Object> arrayList = this.f28970a;
                    arrayList.ensureCapacity(arrayList.size() + objArr.length);
                    Collections.addAll(this.f28970a, objArr);
                }
            } else if (obj instanceof Collection) {
                this.f28970a.addAll((Collection) obj);
            } else if (obj instanceof Iterable) {
                for (Object add : (Iterable) obj) {
                    this.f28970a.add(add);
                }
            } else if (obj instanceof Iterator) {
                Iterator it2 = (Iterator) obj;
                while (it2.hasNext()) {
                    this.f28970a.add(it2.next());
                }
            } else {
                throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            }
        }
    }

    public int c() {
        return this.f28970a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f28970a.toArray(objArr);
    }
}
