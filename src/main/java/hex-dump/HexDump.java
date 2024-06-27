import java.io.File;
import java.io.FileInputStream;

public class HexDump {

  public static void main(String[] args) {
    if(args.length > 0){
      File f = new File(args[0]);
      try {
        int i=0; // stevilo prebranih znakov
        FileInputStream fis = new FileInputStream(f);
        String abc="";
        while(fis.available() > 0 && i < 1024) {
          int z = fis.read(); i++;
          abc += (z>=32 && z<128) ? (char)z : ".";
          System.out.printf("%02x ", z);
          if (i%8 == 0) System.out.print(" ");
          if (i%16 == 0) {
            System.out.printf("  |%s|\n", abc);
            abc = "";
          }
        }
        fis.close();
      } catch (Exception e) {
        System.out.println("Napaka: " + e.toString());
      }
    }
  }
}
