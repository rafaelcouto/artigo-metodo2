package sat;

public class OsLib {

    private OsEnum os;

    private String[] libs86;
    private String[] libs64;

    public OsLib(OsEnum os) {
        this.setOs(os);
    }

    public OsEnum getOs() {
        return os;
    }

    public void setOs(OsEnum os) {
        this.os = os;
    }

    public void setLibs86(String[] libs86) {
        this.libs86 = libs86;
    }

    public void setLibs64(String[] libs64) {
        this.libs64 = libs64;
    }

    public String[] getLibs(ArchEnum arch) {

        if (arch.equals(ArchEnum.x86)) {
            return this.libs86;
        }

        if (arch.equals(ArchEnum.amd64)) {
            return this.libs64;
        }

        return null;
    }

    public boolean isAvailable(ArchEnum arch) {
        String[] libs = this.getLibs(arch);

        if (libs == null) {
            return false;
        }

        return (libs.length > 0);
    }

}
