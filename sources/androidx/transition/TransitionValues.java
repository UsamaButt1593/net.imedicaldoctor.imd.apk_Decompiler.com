package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class TransitionValues {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f16094a = new HashMap();
    @SuppressLint({"UnknownNullness"})

    /* renamed from: b  reason: collision with root package name */
    public View f16095b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Transition> f16096c = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.f16095b == transitionValues.f16095b && this.f16094a.equals(transitionValues.f16094a);
    }

    public int hashCode() {
        return (this.f16095b.hashCode() * 31) + this.f16094a.hashCode();
    }

    @NonNull
    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f16095b + StringUtils.LF) + "    values:";
        for (String next : this.f16094a.keySet()) {
            str = str + "    " + next + ": " + this.f16094a.get(next) + StringUtils.LF;
        }
        return str;
    }

    public TransitionValues(@NonNull View view) {
        this.f16095b = view;
    }
}
