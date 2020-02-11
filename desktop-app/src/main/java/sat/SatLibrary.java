package sat;

import com.sun.jna.Library;

public interface SatLibrary extends Library {
    public String ConsultarSAT(int sessionNumber);
}
