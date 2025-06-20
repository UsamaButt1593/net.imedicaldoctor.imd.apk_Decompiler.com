package net.imedicaldoctor.imd.Fragments.CMEInfo;

import android.app.ActionBar;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.AesFlushingCipher;
import androidx.media3.datasource.C0194c;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.ui.PlayerView;
import com.google.common.net.HttpHeaders;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;

public class Player extends AppCompatActivity {
    public static ExoPlayer I3;
    long A3;
    String B3;
    private float C3;
    float D3 = 1.0f;
    float E3 = 1.2f;
    float F3 = 1.5f;
    float G3 = 2.0f;
    float H3 = 3.0f;
    PlayerView y3;
    Bundle z3;

    @UnstableApi
    public class InputStreamDataSource implements DataSource {

        /* renamed from: b  reason: collision with root package name */
        private final Context f29649b;

        /* renamed from: c  reason: collision with root package name */
        private final DataSpec f29650c;

        /* renamed from: d  reason: collision with root package name */
        private InputStream f29651d;

        /* renamed from: e  reason: collision with root package name */
        private long f29652e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f29653f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f29654g;

        /* renamed from: h  reason: collision with root package name */
        private byte[] f29655h;

        /* renamed from: i  reason: collision with root package name */
        private CompressHelper f29656i;

        public InputStreamDataSource(Context context, DataSpec dataSpec) {
            this.f29649b = context;
            this.f29650c = dataSpec;
        }

        private InputStream t(Context context, Uri uri) {
            try {
                Log.e("ConvertUri", uri.getPath());
                final FileInputStream fileInputStream = new FileInputStream(new File(uri.getPath()));
                Log.e("ConvertURI", "fileInputStream available : " + fileInputStream.available());
                fileInputStream.available();
                final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f29655h);
                AnonymousClass1 r2 = new SequenceInputStream(byteArrayInputStream, fileInputStream) {
                    public int available() throws IOException {
                        Log.e("PlayerResult", "Available : " + ((long) fileInputStream.available()));
                        return fileInputStream.available() - 16;
                    }

                    public long skip(long j2) throws IOException {
                        Log.e("PlayerResult", "Call Skip : " + j2);
                        if (j2 > PlaybackStateCompat.p3) {
                            byteArrayInputStream.skip(PlaybackStateCompat.p3);
                            fileInputStream.skip(j2 - PlaybackStateCompat.p3);
                        } else {
                            byteArrayInputStream.skip(j2);
                        }
                        Log.e("PlayerResult", "Skip : " + j2);
                        return j2;
                    }
                };
                Log.e("ConvertURI", "Combined available : " + r2.available());
                this.f29651d = r2;
                return r2;
            } catch (Exception e2) {
                Log.e("ConvertURI", "Error in creating inputstream");
                e2.printStackTrace();
                return null;
            }
        }

        @OptIn(markerClass = {UnstableApi.class})
        public long a(DataSpec dataSpec) throws IOException {
            this.f29654g = new byte[MetaDo.x];
            this.f29655h = new byte[1024];
            this.f29656i = new CompressHelper(Player.this.getApplicationContext());
            File file = new File(dataSpec.f9779a.getPath());
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.seek(file.length() - 1040);
            randomAccessFile.read(this.f29654g, 0, MetaDo.x);
            Log.e("Datasource open", "Scratch Length : " + this.f29654g.length);
            this.f29655h = this.f29656i.w(this.f29654g, "kaplan", "127");
            Log.e("Datasource open", "Scratch DE Length : " + this.f29655h.length);
            try {
                InputStream t = t(this.f29649b, dataSpec.f9779a);
                this.f29651d = t;
                long skip = t.skip(dataSpec.f9785g);
                Log.e("Player", "Skipped : " + skip + " , Dataspec position: " + dataSpec.f9785g + ", DS Length: " + dataSpec.f9786h);
                if (skip >= dataSpec.f9785g) {
                    long j2 = dataSpec.f9786h;
                    if (j2 != -1) {
                        this.f29652e = j2;
                    } else {
                        long available = (long) this.f29651d.available();
                        this.f29652e = available;
                        if (available == 2147483647L) {
                            this.f29652e = -1;
                        }
                    }
                    this.f29652e = this.f29652e;
                    Log.e("Player", "Bytes remaining " + this.f29652e);
                    this.f29653f = true;
                    return this.f29652e;
                }
                Log.e("Player", "Skipped is lower than position");
                throw new EOFException();
            } catch (IOException e2) {
                throw new IOException(e2);
            }
        }

        public Uri c() {
            return this.f29650c.f9779a;
        }

        public void close() throws IOException {
            try {
                InputStream inputStream = this.f29651d;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f29651d = null;
                if (this.f29653f) {
                    this.f29653f = false;
                }
            } catch (IOException e2) {
                throw new IOException(e2);
            } catch (Throwable th) {
                this.f29651d = null;
                if (this.f29653f) {
                    this.f29653f = false;
                }
                throw th;
            }
        }

        public void e(TransferListener transferListener) {
        }

        public /* synthetic */ Map getResponseHeaders() {
            return C0194c.a(this);
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            Log.e("Datasource Read", "offset: " + i2 + " , Readlength : " + i3);
            if (i3 == 0) {
                return 0;
            }
            long j2 = this.f29652e;
            if (j2 == 0) {
                return -1;
            }
            if (j2 != -1) {
                try {
                    i3 = (int) Math.min(j2, (long) i3);
                } catch (IOException e2) {
                    throw new IOException(e2);
                }
            }
            int read = this.f29651d.read(bArr, i2, i3);
            if (read != -1) {
                long j3 = this.f29652e;
                if (j3 != -1) {
                    this.f29652e = j3 - ((long) read);
                }
                return read;
            } else if (this.f29652e == -1) {
                return -1;
            } else {
                throw new IOException(new EOFException());
            }
        }
    }

    @UnstableApi
    public final class iMDDataSource implements DataSource {

        /* renamed from: b  reason: collision with root package name */
        private final DataSource f29658b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f29659c = new byte[MetaDo.x];

        /* renamed from: d  reason: collision with root package name */
        private byte[] f29660d = new byte[1024];

        /* renamed from: e  reason: collision with root package name */
        private final String f29661e;

        /* renamed from: f  reason: collision with root package name */
        private final CompressHelper f29662f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private AesFlushingCipher f29663g;

        public iMDDataSource(DataSource dataSource, String str) {
            this.f29658b = dataSource;
            this.f29662f = new CompressHelper(Player.this.getApplicationContext());
            this.f29661e = str;
        }

        @OptIn(markerClass = {UnstableApi.class})
        public long a(DataSpec dataSpec) throws IOException {
            Log.e("Datasource open", "URI " + this.f29661e);
            File file = new File(this.f29661e);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.seek(file.length() - 1040);
            randomAccessFile.read(this.f29659c, 0, MetaDo.x);
            long a2 = this.f29658b.a(dataSpec);
            Log.e("Datasource open", "DataLength : " + a2);
            Log.e("Datasource open", "Scratch Length : " + this.f29659c.length);
            this.f29660d = this.f29662f.w(this.f29659c, "kaplan", "127");
            Log.e("Datasource open", "Scratch DE Length : " + this.f29660d.length);
            return a2 - 16;
        }

        public Uri c() {
            return Uri.fromFile(Environment.getExternalStorageDirectory());
        }

        public void close() throws IOException {
            this.f29663g = null;
            this.f29658b.close();
        }

        public void e(TransferListener transferListener) {
            this.f29658b.e(transferListener);
        }

        public Map<String, List<String>> getResponseHeaders() {
            return this.f29658b.getResponseHeaders();
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            Log.e("Datasource Read", "offset: " + i2 + " , Readlength : " + i3);
            if (i3 == 0) {
                return 0;
            }
            if (i2 >= 1024) {
                return this.f29658b.read(bArr, i2, 1024);
            }
            int i4 = 1024 - i2;
            System.arraycopy(this.f29660d, i2, bArr, i2, i4);
            return i4;
        }
    }

    @UnstableApi
    public final class iMDDataSourceFactory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource f29665a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29666b;

        public iMDDataSourceFactory(DataSource dataSource, String str) {
            this.f29665a = dataSource;
            this.f29666b = str;
        }

        public DataSource a() {
            return new iMDDataSource(this.f29665a, this.f29666b);
        }
    }

    private void b1() {
        ExoPlayer exoPlayer = I3;
        if (exoPlayer != null) {
            exoPlayer.stop();
            I3.a();
            I3 = null;
        }
    }

    private void c1() {
        Bundle bundle;
        StringBuilder sb;
        Log.e("SaveLocation", "Starting");
        try {
            CompressHelper compressHelper = new CompressHelper(this);
            Bundle bundle2 = this.z3;
            ArrayList<Bundle> V = compressHelper.V(bundle2, "select * from logs where id = " + this.B3);
            ExoPlayer exoPlayer = I3;
            if (exoPlayer != null) {
                long z2 = exoPlayer.z2();
                long Q = I3.Q();
                Log.e("SaveLocation", "Position : " + z2);
                Log.e("SaveLocation", "Duration : " + Q);
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                if (V != null) {
                    if (V.size() != 0) {
                        bundle = this.z3;
                        sb = new StringBuilder();
                        sb.append("Update logs set duration=");
                        sb.append(Q);
                        sb.append(", position=");
                        sb.append(z2);
                        sb.append(", vDate='");
                        sb.append(format);
                        sb.append("' where id = ");
                        sb.append(this.B3);
                        compressHelper.m(bundle, sb.toString());
                    }
                }
                bundle = this.z3;
                sb = new StringBuilder();
                sb.append("Insert into logs values (");
                sb.append(this.B3);
                sb.append(",");
                sb.append(Q);
                sb.append(", ");
                sb.append(z2);
                sb.append(", '");
                sb.append(format);
                sb.append("')");
                compressHelper.m(bundle, sb.toString());
            }
        } catch (Exception unused) {
        }
    }

    public void Y0() {
        Context applicationContext;
        String str;
        float f2 = this.C3;
        float f3 = this.F3;
        if (f2 == f3) {
            this.C3 = this.G3;
            applicationContext = getApplicationContext();
            str = "2x";
        } else if (f2 == this.G3) {
            this.C3 = this.H3;
            applicationContext = getApplicationContext();
            str = "3x";
        } else if (f2 == this.H3) {
            this.C3 = this.D3;
            applicationContext = getApplicationContext();
            str = "1x";
        } else {
            float f4 = this.E3;
            if (f2 == f4) {
                this.C3 = f3;
                applicationContext = getApplicationContext();
                str = "1.5x";
            } else {
                if (f2 == this.D3) {
                    this.C3 = f4;
                    applicationContext = getApplicationContext();
                    str = "1.2x";
                }
                I3.f(new PlaybackParameters(this.C3));
            }
        }
        Toast.makeText(applicationContext, str, 0).show();
        I3.f(new PlaybackParameters(this.C3));
    }

    public float Z0() {
        return this.C3;
    }

    public boolean a1() {
        return I3.i() == 3 && I3.m0();
    }

    public void d1(float f2) {
        this.C3 = f2;
        I3.f(new PlaybackParameters(f2));
    }

    /* access modifiers changed from: protected */
    @OptIn(markerClass = {UnstableApi.class})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSharedPreferences("default_preferences", 0).getBoolean("dark", false)) {
            AppCompatDelegate.c0(2);
        } else {
            AppCompatDelegate.c0(1);
        }
        if (getSharedPreferences("default_preferences", 0).getBoolean("wakelock", true)) {
            getWindow().addFlags(128);
        }
        setContentView((int) R.layout.f1185activity_player);
        String stringExtra = getIntent().getStringExtra("Address");
        this.z3 = getIntent().getBundleExtra("DB");
        this.A3 = getIntent().getLongExtra(HttpHeaders.t0, 0);
        this.B3 = getIntent().getStringExtra("VideoID");
        this.y3 = (PlayerView) findViewById(R.id.f931exo_player_view);
        try {
            I3 = new ExoPlayer.Builder(this).w();
            DataSpec dataSpec = new DataSpec(Uri.parse(stringExtra));
            final InputStreamDataSource inputStreamDataSource = new InputStreamDataSource(this, dataSpec);
            try {
                inputStreamDataSource.a(dataSpec);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            ProgressiveMediaSource i2 = new ProgressiveMediaSource.Factory(new DataSource.Factory() {
                public DataSource a() {
                    return inputStreamDataSource;
                }
            }).c(MediaItem.d(inputStreamDataSource.c()));
            this.y3.setPlayer(I3);
            I3.A1(i2);
            I3.k();
            d1(this.D3);
            I3.i1(true);
            if (this.A3 != 0) {
                Log.e("Player", "Going to position : " + this.A3);
                I3.i0(0, this.A3);
            }
            final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    return true;
                }

                public void onLongPress(MotionEvent motionEvent) {
                    super.onLongPress(motionEvent);
                }
            });
            this.y3.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
            });
            getWindow().getDecorView().setSystemUiVisibility(4);
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        } catch (Exception e3) {
            Log.e("MainAcvtivity", " exoplayer error " + e3);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        c1();
        b1();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        c1();
        a1();
    }
}
