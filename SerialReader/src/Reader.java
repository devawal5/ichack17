import jssc.SerialPort; import jssc.SerialPortException;

import java.util.concurrent.TimeUnit;

public class Reader {

    public static void main(String[] args) {
        SerialPort serialPort = new SerialPort("/dev/ttyACM1");
        //SerialPort serialPort2 = new SerialPort("/dev/ttyACM2");
        try {
   //         serialPort.closePort();//Close serial port
            serialPort.openPort();//Open serial port
            serialPort.setParams(9600, 8, 1, 0);//Set params.
            //serialPort2.openPort();//Open serial port
            //serialPort2.setParams(9600, 8, 1, 0);//Set params.

            //byte[] buffer = serialPort.readBytes(10);//Read 10 bytes from serial port
            String bstring;
            while (true) {
                bstring = serialPort.readString(60);
                String[] splitted = bstring.split("_");
                System.out.println("A: "+ splitted[1]);
                //bstring = serialPort2.readString(50);
                //splitted = bstring.split("_");
                //System.out.println("B: "+ splitted[1]);
            }
//            serialPort.closePort();//Close serial port
            /*for (byte b :  buffer) {
                System.out.print(b + " ");
            }*/
        }
        catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }
}