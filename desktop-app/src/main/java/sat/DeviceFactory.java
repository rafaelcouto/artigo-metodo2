package sat;

public class DeviceFactory {

    public static Device build(String name) {

        switch (name) {
            case "emulator":
                return (new EmulatorDevice());
        }

        return null;

    }

}
