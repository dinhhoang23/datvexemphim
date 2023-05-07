/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etiny;
import java.util.List;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "datves")
@XmlAccessorType(XmlAccessType.FIELD)
/**
 *
 * @author nddh2
 */
public class DatveXML {
     
    private List<Datve> datve;
 
    public List<Datve> getDatve() {
        return datve;
    }
 
    public void setDatve(List<Datve> datve) {
        this.datve = datve;
    }
}
