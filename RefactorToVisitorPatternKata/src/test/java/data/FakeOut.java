package data;

import java.io.*;

public class FakeOut extends PrintStream {

    private StringBuffer sb = new StringBuffer();

    public FakeOut(OutputStream out) {
        super(out);
    }

    public FakeOut() throws FileNotFoundException, IOException {
        super((OutputStream) new FileOutputStream(File.createTempFile("fake", "out")));
    }

    @Override
    public void println(String x) {
        sb.append(x);
        sb.append("\n");
    }

    public String getOut() {
        return sb.toString();
    }

}
