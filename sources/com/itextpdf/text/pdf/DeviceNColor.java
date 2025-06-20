package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

public class DeviceNColor extends ExtendedColor {
    float[] A;
    PdfDeviceNColor z;

    public DeviceNColor(PdfDeviceNColor pdfDeviceNColor, float[] fArr) {
        super(6);
        if (pdfDeviceNColor.d().length == fArr.length) {
            this.z = pdfDeviceNColor;
            this.A = fArr;
            return;
        }
        throw new RuntimeException(MessageLocalization.b("devicen.color.shall.have.the.same.number.of.colorants.as.the.destination.DeviceN.color.space", new Object[0]));
    }

    public boolean equals(Object obj) {
        if (obj instanceof DeviceNColor) {
            DeviceNColor deviceNColor = (DeviceNColor) obj;
            int length = deviceNColor.A.length;
            float[] fArr = this.A;
            if (length == fArr.length) {
                int i2 = 0;
                for (float f2 : fArr) {
                    if (f2 != deviceNColor.A[i2]) {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.z.hashCode();
        for (float valueOf : this.A) {
            hashCode ^= Float.valueOf(valueOf).hashCode();
        }
        return hashCode;
    }

    public PdfDeviceNColor m() {
        return this.z;
    }

    public float[] n() {
        return this.A;
    }
}
