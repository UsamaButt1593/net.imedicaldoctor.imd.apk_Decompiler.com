package com.bumptech.glide.request;

public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        private final boolean s;

        private RequestState(boolean z) {
            this.s = z;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.s;
        }
    }

    void a(Request request);

    boolean b();

    boolean c(Request request);

    boolean e(Request request);

    void g(Request request);

    RequestCoordinator i();

    boolean k(Request request);
}
