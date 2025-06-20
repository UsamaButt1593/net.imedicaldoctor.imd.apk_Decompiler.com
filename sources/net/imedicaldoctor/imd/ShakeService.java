package net.imedicaldoctor.imd;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class ShakeService extends Service implements SensorEventListener {
    private Sensor X;
    private float X2;
    private float Y;
    private float Z;
    private SensorManager s;

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        this.X2 = this.Z;
        float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3) + (f4 * f4)));
        this.Z = sqrt;
        float f5 = (this.Y * 0.9f) + (sqrt - this.X2);
        this.Y = f5;
        if (f5 > 11.0f) {
            LocalBroadcastManager.b(this).d(new Intent("Shake"));
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.s = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        this.X = defaultSensor;
        this.s.registerListener(this, defaultSensor, 2, new Handler());
        return 1;
    }
}
