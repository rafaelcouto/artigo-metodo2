package sat;

import com.sun.jna.Native;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

abstract public class Device {

    protected ArrayList<OsLib> osLibs = new ArrayList<OsLib>();

    public OsLib getCurrentOsLib() {

        ArchEnum currentArch = this.getCurrentArch();
        OsEnum currentOs = this.getCurrentOs();

        for (OsLib osLib : this.osLibs) {

            if (!osLib.getOs().equals(currentOs)) {
                continue;
            }

            if (osLib.isAvailable(currentArch)) {
                return osLib;
            }

        }

        return null;

    }

    private ArchEnum getCurrentArch() {
        String currentArch = System.getProperty("os.arch");
        if (currentArch.equals("x86")) return ArchEnum.x86;
        if (currentArch.equals("amd64")) return ArchEnum.amd64;
        return null;
    }

    private OsEnum getCurrentOs() {
        if (SystemUtils.IS_OS_WINDOWS) return OsEnum.WINDOWS;
        if (SystemUtils.IS_OS_LINUX) return OsEnum.LINUX;
        return null;
    }

    private String export() throws IOException {

        OsLib osLib = this.getCurrentOsLib();

        String[] libs = osLib.getLibs(this.getCurrentArch());
        String path = System.getProperty("user.dir");

        for(String lib: libs) {
            File target = new File(path + '/' + lib);
            if (!target.exists()) {
                File file = Native.extractFromResourcePath(lib);
                FileUtils.copyFile(file, target);
            }
        }

        System.setProperty("jna.library.path", path);

        return libs[0];
    }

    public boolean isAvailable() {
        return (this.getCurrentOsLib() != null);
    }

    public SatLibrary getLibraryInstance() throws IOException {
        String lib = this.export();
        return (SatLibrary) Native.load(lib, SatLibrary.class);
    }

}
