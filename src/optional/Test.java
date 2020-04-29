package optional;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Optional<Computer> computer = Optional.of(new Computer());
        String version = computer.flatMap(Computer::getSoundcard)
                .flatMap(Soundcard::getUSB)
                .map(USB::getVersion)
                .orElse("UNKNOWN");

        String version2 = computer.flatMap(Computer::getSoundcard)
                .flatMap(Soundcard::getUSB)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
    }
}

class Computer {
    private Optional<Soundcard> soundcard;

    public Optional<Soundcard> getSoundcard() {
        return soundcard;
    }
}

class Soundcard {
    private Optional<USB> usb;

    public Optional<USB> getUSB() {
        return usb;
    }
}

class USB {
    public String getVersion() {
        return "1.1.1";
    }
}