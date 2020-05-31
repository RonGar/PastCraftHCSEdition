/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  anli
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.tuor
 *  uhen$1
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import net.minecraft.client.tuor;

/*
 * Exception performing whole class analysis.
 */
@SideOnly(value=Side.CLIENT)
public class uhen
extends Thread {
    public static SSLSocketFactory _a;
    public final anli _b;

    public uhen(anli anli2) {
        this._b = anli2;
    }

    @Override
    public void run() {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection)new URL(anli._a((anli)this._b)).openConnection(tuor._E()._Q());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(false);
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection)httpURLConnection).setSSLSocketFactory(_a);
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() / 100 != 2) {
                return;
            }
            BufferedImage bufferedImage = ImageIO.read(httpURLConnection.getInputStream());
            if (anli._b((anli)this._b) != null) {
                bufferedImage = anli._b((anli)this._b)._a(bufferedImage);
            }
            this._b._a(bufferedImage);
        }
        catch (Exception exception) {
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    public static {
        TrustManager[] arrtrustManager = new TrustManager[]{new /* Unavailable Anonymous Inner Class!! */};
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, arrtrustManager, new SecureRandom());
            _a = sSLContext.getSocketFactory();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        }
        catch (KeyManagementException keyManagementException) {}
    }
}

