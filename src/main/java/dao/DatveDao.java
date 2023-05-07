/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
import etiny.Datve;
import etiny.DatveXML;
import utils.FileUtils;
/**
 *
 * @author nddh2
 */
public class DatveDao {
    private static final String STUDENT_FILE_NAME = "datve.xml";
    private List<Datve> listDatves;
 
    public DatveDao() {
        this.listDatves = readListDatves();
        if (listDatves == null) {
            listDatves = new ArrayList<Datve>();
        }
}
    public void writeListDatves(List<Datve> datves) {
        DatveXML datveXML = new DatveXML();
        datveXML.setDatve(datves);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, datveXML);
    }
    public List<Datve> readListDatves() {
        List<Datve> list = new ArrayList<Datve>();
        DatveXML datveXML = (DatveXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, DatveXML.class);
        if (datveXML != null) {
            list = datveXML.getDatve();
        }
        return list;
    }
    public void add(Datve datve) {
        int Stt = 1;
        if (listDatves != null && listDatves.size() > 0) {
            Stt = listDatves.size() + 1;
        }
        datve.setStt(Stt);
        listDatves.add(datve);
        writeListDatves(listDatves);
    }
    public void edit(Datve datve) {
        int size = listDatves.size();
        for (int i = 0; i < size; i++) {
            if (listDatves.get(i).getStt() == datve.getStt()) {
                
                listDatves.get(i).setSl(datve.getSl());
                listDatves.get(i).setFilm(datve.getFilm());
                listDatves.get(i).setTime(datve.getTime());
                writeListDatves(listDatves);
                break;
            }
        }
    }
    public boolean delete(Datve datve) {
        boolean isFound = false;
        int size = listDatves.size();
        for (int i = 0; i < size; i++) {
            if (listDatves.get(i).getStt() == datve.getStt()) {
                datve = listDatves.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listDatves.remove(datve);
            writeListDatves(listDatves);
            return true;
        }
        return false;
    }
    public Datve findfilm( String film){
        for (Datve datve : listDatves){
            if(datve.getFilm().equalsIgnoreCase(film)){
                return datve;
            }
        }
           return null; 
    }
    public List<Datve> getListDatves() {
        return listDatves;
    }
 
    public void setListDatves(List<Datve> listDatves) {
        this.listDatves = listDatves;
    }
}
    
    
