package biometricstationjavafxml;

public class SerialParser {

    SerialLineReceiver receiver = new SerialLineReceiver(1, 9600, false);

    private double temperature;
    private int heartPulse;

    public void setTemperature(SerialData data) {

        String serialData = data.getDataAsString();
        int start = serialData.indexOf("[") + 1;
        int split1 = serialData.indexOf("|");
        int split2 = split1 + 2;
        int split3 = serialData.indexOf("|", split1 + 1) - 1;
        int split4 = split3 + 2;
        int end = serialData.indexOf("]");
        int checksum = split1 + split3;
        String emptyString = "";

        if (start < 0 || split1 < 0 || split2 < 0 || end < 0) {

        } else if (checksum > 20) {

        } else {
            String temperatureString = serialData.substring(start, split1);
            String heartPulseString = serialData.substring(split2, split3);
            String accelerationString = serialData.substring(split4, end);

            double newTemperature = Double.parseDouble(temperatureString);
            temperature = newTemperature;

        }

    }

    public void setHeartbeat(SerialData data) {

        String serialData = data.getDataAsString();
        int start = serialData.indexOf("[") + 1;
        int split1 = serialData.indexOf("|");
        int split2 = split1 + 2;
        int split3 = serialData.indexOf("|", split1 + 1) - 1;
        int split4 = split3 + 2;
        int end = serialData.indexOf("]");
        int checksum = split1 + split3;
        String emptyString = "";

        if (start < 0 || split1 < 0 || split2 < 0 || end < 0) {

        } else if (checksum > 20) {

        } else {
            String temperatureString = serialData.substring(start, split1);
            String heartPulseString = serialData.substring(split2, split3);
            String accelerationString = serialData.substring(split4, end);

            if (heartPulseString != emptyString) {
                int newHeartPulse = Integer.parseInt(heartPulseString);
                heartPulse = newHeartPulse;

            }

        }

    }

    public double getTemperature() {
        return temperature;
    }

    public int getHeartPulse() {
        return heartPulse;
    }

}
