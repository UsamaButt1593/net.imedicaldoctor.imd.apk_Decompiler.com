package net.lingala.zip4j.progress;

public class ProgressMonitor {

    /* renamed from: a  reason: collision with root package name */
    private State f30653a;

    /* renamed from: b  reason: collision with root package name */
    private long f30654b;

    /* renamed from: c  reason: collision with root package name */
    private long f30655c;

    /* renamed from: d  reason: collision with root package name */
    private int f30656d;

    /* renamed from: e  reason: collision with root package name */
    private Task f30657e;

    /* renamed from: f  reason: collision with root package name */
    private String f30658f;

    /* renamed from: g  reason: collision with root package name */
    private Result f30659g;

    /* renamed from: h  reason: collision with root package name */
    private Exception f30660h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f30661i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f30662j;

    public enum Result {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    public enum State {
        READY,
        BUSY
    }

    public enum Task {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public ProgressMonitor() {
        n();
    }

    private void n() {
        this.f30657e = Task.NONE;
        this.f30653a = State.READY;
    }

    public void a() {
        this.f30659g = Result.SUCCESS;
        this.f30656d = 100;
        n();
    }

    public void b(Exception exc) {
        this.f30659g = Result.ERROR;
        this.f30660h = exc;
        n();
    }

    public void c() {
        n();
        this.f30658f = null;
        this.f30654b = 0;
        this.f30655c = 0;
        this.f30656d = 0;
    }

    public Task d() {
        return this.f30657e;
    }

    public Exception e() {
        return this.f30660h;
    }

    public String f() {
        return this.f30658f;
    }

    public int g() {
        return this.f30656d;
    }

    public Result h() {
        return this.f30659g;
    }

    public State i() {
        return this.f30653a;
    }

    public long j() {
        return this.f30654b;
    }

    public long k() {
        return this.f30655c;
    }

    public boolean l() {
        return this.f30661i;
    }

    public boolean m() {
        return this.f30662j;
    }

    public void o(boolean z) {
        this.f30661i = z;
    }

    public void p(Task task) {
        this.f30657e = task;
    }

    public void q(Exception exc) {
        this.f30660h = exc;
    }

    public void r(String str) {
        this.f30658f = str;
    }

    public void s(boolean z) {
        this.f30662j = z;
    }

    public void t(int i2) {
        this.f30656d = i2;
    }

    public void u(Result result) {
        this.f30659g = result;
    }

    public void v(State state) {
        this.f30653a = state;
    }

    public void w(long j2) {
        this.f30654b = j2;
    }

    public void x(long j2) {
        long j3 = this.f30655c + j2;
        this.f30655c = j3;
        long j4 = this.f30654b;
        if (j4 > 0) {
            int i2 = (int) ((j3 * 100) / j4);
            this.f30656d = i2;
            if (i2 > 100) {
                this.f30656d = 100;
            }
        }
        while (this.f30662j) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException unused) {
            }
        }
    }
}
