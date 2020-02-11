package sat;

public class EmulatorDevice extends Device {

    public EmulatorDevice() {

        // Windows
        OsLib windows = new OsLib(OsEnum.WINDOWS);
        windows.setLibs86(new String[]{"SAT.dll"});
        this.osLibs.add(windows);

    }


}
