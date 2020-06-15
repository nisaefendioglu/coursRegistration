/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kurskayit;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


/**
 *
 * @author Lenovo
 */
public class KursKayit {

       private int tc;
       private String ad;
       private String soyad;
       private int tel;

    KursKayit(ResultSet res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       public int gettc() {
             return tc;
       }
       public void settc(int tc) {
             this.tc = tc;
       }
       public String getIsim() {
             return ad;
       }
       public void setIsim(String ad) {
             this.ad = ad;
       }
       public String getSoyIsim() {
             return soyad;
       }
       public void setSoyIsim(String soyad) {
             this.soyad = soyad;
       }
       public int gettel() {
             return tel;
       }
       public void settel(int tel) {
             this.tel = tel;
       }          

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         kullaniciGiris kg = new kullaniciGiris();
         kg.setVisible(true);
       
        // TODO code application logic here
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
