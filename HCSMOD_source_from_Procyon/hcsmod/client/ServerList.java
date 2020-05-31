// 
// Decompiled by Procyon v0.5.36
// 

package hcsmod.client;

import java.util.ArrayList;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManager;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.TrustManager;
import java.nio.charset.Charset;
import javax.net.ssl.X509TrustManager;

public class ServerList implements Runnable, X509TrustManager
{
    private static final Charset UTF8;
    public static final TrustManager[] trustAllCerts;
    public static final List<pzuq> servers;
    
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
    
    @Override
    public void checkClientTrusted(final X509Certificate[] array, final String s) {
    }
    
    @Override
    public void checkServerTrusted(final X509Certificate[] array, final String s) {
    }
    
    public static void setupServerList() {
        downloadServerList();
        if (ServerList.servers.isEmpty()) {
            new Thread(new ServerList()).start();
        }
    }
    
    private static void downloadServerList() {
        try {
            final SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, ServerList.trustAllCerts, new SecureRandom());
            final SSLSocketFactory socketFactory = instance.getSocketFactory();
            try (final SSLSocket sslSocket = (SSLSocket)socketFactory.createSocket()) {
                sslSocket.connect(new InetSocketAddress("play.hcs.land", 4300), 9000);
                sslSocket.startHandshake();
                final DataOutputStream dataOutputStream = new DataOutputStream(sslSocket.getOutputStream());
                writeString("mcLauncher", dataOutputStream);
                writeString("file", dataOutputStream);
                dataOutputStream.writeUTF(System.getProperty("vz.dayz.servers", System.getProperty("dayzservers", "dayzservers.txt")));
                final DataInputStream dataInputStream = new DataInputStream(sslSocket.getInputStream());
                readString(dataInputStream);
                readString(dataInputStream);
                dataInputStream.readLong();
                readString(dataInputStream);
                readString(dataInputStream);
                dataInputStream.readUTF();
                final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream(), "UTF-8"));
                for (int intValue = Integer.valueOf(bufferedReader.readLine()), i = 0; i < intValue; ++i) {
                    final String line = bufferedReader.readLine();
                    final int index = line.indexOf(32);
                    final pzuq pzuq = new pzuq(line.substring(index + 1), line.substring(0, index));
                    pzuq._c = "?/?";
                    pzuq._d = pzuq._a;
                    ServerList.servers.add(pzuq);
                }
                if (sslSocket != null) {
                    sslSocket.close();
                }
            }
            catch (IOException ex) {
                Thread.sleep(1000L);
            }
        }
        catch (Exception ex2) {}
    }
    
    @Override
    public void run() {
        while (ServerList.servers.isEmpty()) {
            downloadServerList();
        }
    }
    
    public static String readString(final DataInput dataInput) throws IOException {
        final byte[] bytes = new byte[dataInput.readUnsignedByte()];
        dataInput.readFully(bytes);
        return new String(bytes, ServerList.UTF8);
    }
    
    public static void writeString(final String s, final DataOutput dataOutput) throws IOException {
        final byte[] bytes = s.getBytes(ServerList.UTF8);
        if (bytes.length > 255) {
            throw new IOException("String too long!");
        }
        dataOutput.writeByte(bytes.length);
        dataOutput.write(bytes);
    }
    
    static {
        UTF8 = Charset.forName("UTF-8");
        trustAllCerts = new TrustManager[] { new ServerList() };
        servers = new ArrayList<pzuq>();
    }
}
