/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etiny;
import java.io.Serializable;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "datve")
@XmlAccessorType(XmlAccessType.FIELD)
/**
 *
 * @author nddh2
 */
public class Datve implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Stt;
    private String film;
    private int sl;
    private String time;
    
    public Datve() {
    }
 

    public Datve(int Stt, String film, int sl, String time) {
        this.Stt = Stt;
        this.film = film;
        this.sl = sl;
        this.time = time;
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    
    
    
   
 
    
}
