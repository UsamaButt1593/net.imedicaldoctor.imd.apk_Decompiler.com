package com.dd;

class StateManager {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18586a;

    /* renamed from: b  reason: collision with root package name */
    private int f18587b;

    public StateManager(CircularProgressButton circularProgressButton) {
        this.f18586a = circularProgressButton.isEnabled();
        this.f18587b = circularProgressButton.getProgress();
    }

    public void a(CircularProgressButton circularProgressButton) {
        if (circularProgressButton.getProgress() != b()) {
            circularProgressButton.setProgress(circularProgressButton.getProgress());
        } else if (circularProgressButton.isEnabled() != c()) {
            circularProgressButton.setEnabled(circularProgressButton.isEnabled());
        }
    }

    public int b() {
        return this.f18587b;
    }

    public boolean c() {
        return this.f18586a;
    }

    public void d(CircularProgressButton circularProgressButton) {
        this.f18587b = circularProgressButton.getProgress();
    }
}
