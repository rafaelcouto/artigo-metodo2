package sat;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Sat {

    private SatLibrary satLibrary;

    public Sat(Device device) throws IOException {
        this.satLibrary = device.getLibraryInstance();
    }

    public String consultar() {
        return satLibrary.ConsultarSAT(this.generateSession());
    }

    private int generateSession()
    {
        return ThreadLocalRandom.current().nextInt(100000, 999999);
    }

}
