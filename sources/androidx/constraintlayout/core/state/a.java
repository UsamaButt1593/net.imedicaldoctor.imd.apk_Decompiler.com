package androidx.constraintlayout.core.state;

public final /* synthetic */ class a implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4149a;

    public /* synthetic */ a(String str) {
        this.f4149a = str;
    }

    public final float getInterpolation(float f2) {
        return Transition.Q(this.f4149a, f2);
    }
}
