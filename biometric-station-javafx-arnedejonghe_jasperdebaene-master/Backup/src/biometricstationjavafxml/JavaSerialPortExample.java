// Author: Arne

package biometricstationjavafxml;



public class JavaSerialPortExample {
    
   

    public static void main(String[] args) {
        
      
        SerialLineReceiver receiver = new SerialLineReceiver(1, 9600, false);
        
    
        receiver.setLineListener(new SerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {

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
                    System.out.println(serialData);

                    double temperature = Double.parseDouble(temperatureString);
                    System.out.println(temperature);

                    if (heartPulseString != emptyString) {
                        int heartPulse = Integer.parseInt(heartPulseString);
                        System.out.println(heartPulse);

                    }

                }

            }
        });
    }
}
