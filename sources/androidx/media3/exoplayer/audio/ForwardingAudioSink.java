package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioSink;
import java.nio.ByteBuffer;

@UnstableApi
public class ForwardingAudioSink implements AudioSink {

    /* renamed from: h  reason: collision with root package name */
    private final AudioSink f10898h;

    public ForwardingAudioSink(AudioSink audioSink) {
        this.f10898h = audioSink;
    }

    public void A(long j2) {
        this.f10898h.A(j2);
    }

    public void B() {
        this.f10898h.B();
    }

    public void C() {
        this.f10898h.C();
    }

    public int D(Format format) {
        return this.f10898h.D(format);
    }

    public boolean E(ByteBuffer byteBuffer, long j2, int i2) throws AudioSink.InitializationException, AudioSink.WriteException {
        return this.f10898h.E(byteBuffer, j2, i2);
    }

    public void a() {
        this.f10898h.a();
    }

    public boolean b(Format format) {
        return this.f10898h.b(format);
    }

    public boolean c() {
        return this.f10898h.c();
    }

    @Nullable
    public AudioAttributes d() {
        return this.f10898h.d();
    }

    public void e(int i2) {
        this.f10898h.e(i2);
    }

    public void f(PlaybackParameters playbackParameters) {
        this.f10898h.f(playbackParameters);
    }

    public void flush() {
        this.f10898h.flush();
    }

    public void g(float f2) {
        this.f10898h.g(f2);
    }

    public void h() {
        this.f10898h.h();
    }

    public void i(Clock clock) {
        this.f10898h.i(clock);
    }

    public void j(Format format, int i2, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        this.f10898h.j(format, i2, iArr);
    }

    public void k(AudioAttributes audioAttributes) {
        this.f10898h.k(audioAttributes);
    }

    public AudioOffloadSupport l(Format format) {
        return this.f10898h.l(format);
    }

    @RequiresApi(23)
    public void m(@Nullable AudioDeviceInfo audioDeviceInfo) {
        this.f10898h.m(audioDeviceInfo);
    }

    public boolean n() {
        return this.f10898h.n();
    }

    public void o() {
        this.f10898h.o();
    }

    public void p() throws AudioSink.WriteException {
        this.f10898h.p();
    }

    public boolean q() {
        return this.f10898h.q();
    }

    public PlaybackParameters r() {
        return this.f10898h.r();
    }

    public void reset() {
        this.f10898h.reset();
    }

    public void s(boolean z) {
        this.f10898h.s(z);
    }

    public void t(AuxEffectInfo auxEffectInfo) {
        this.f10898h.t(auxEffectInfo);
    }

    @RequiresApi(29)
    public void u(int i2, int i3) {
        this.f10898h.u(i2, i3);
    }

    public void v(AudioSink.Listener listener) {
        this.f10898h.v(listener);
    }

    @RequiresApi(29)
    public void w(int i2) {
        this.f10898h.w(i2);
    }

    public long x(boolean z) {
        return this.f10898h.x(z);
    }

    public void y() {
        this.f10898h.y();
    }

    public void z(@Nullable PlayerId playerId) {
        this.f10898h.z(playerId);
    }
}
