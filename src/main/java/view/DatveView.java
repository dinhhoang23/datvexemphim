/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
 
import etiny.Datve;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
/**
 *
 * @author nddh2
 */
public class DatveView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;

    private JButton addDatveBtn;
    private JButton editDatveBtn;
    private JButton deleteDatveBtn;
    private JButton clearBtn;
    private JButton timKiemFilmBtn;
    private JButton timkiemBtn;
    private JLabel dinhdang;
    private JLabel dinhdang1;
    
    private JScrollPane jScrollPaneDatveTable;
    private JScrollPane jScrollPaneFilm;
    private JTable datveTable;
     
    private JLabel SttLabel;
    private JLabel slLabel;
    private JLabel filmLabel;
    private JLabel timeLabel;
     
    private JTextField SttField;
    private JTextField slField;
    private JTextArea filmTA;
    private JTextField timeField;
     
    // định nghĩa các cột của bảng 
    private String [] columnNames = new String [] {
            "STT","Số vé", "Thời gian", "Tên phim"};
    
    private Object data = new Object [][] {};
     
    public DatveView() {
        initComponents();
    }
 
    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addDatveBtn = new JButton("Add");
        editDatveBtn = new JButton("Edit");
        deleteDatveBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        timKiemFilmBtn = new JButton("Tìm kiếm tên film");
        dinhdang =new JLabel("Định dạng");
        dinhdang1 = new JLabel("dd-MM-yyyy HH:mm:ss");
        
        // khởi tạo bảng
        jScrollPaneDatveTable = new JScrollPane();
        datveTable = new JTable();
         
        // khởi tạo các label
        SttLabel = new JLabel("STT");
        
        slLabel = new JLabel("Số vé");
        filmLabel = new JLabel("Tên phim");
        timeLabel = new JLabel("Thời gian");
         
        // khởi tạo các trường nhập dữ liệu 
        SttField = new JTextField(6);
        SttField.setEditable(false);
       
        slField = new JTextField(6);
        filmTA = new JTextArea();
        filmTA.setColumns(15);
        filmTA.setRows(5);
        jScrollPaneFilm = new JScrollPane();
        jScrollPaneFilm.setViewportView(filmTA);
        timeField = new JTextField(6);
        timeField.setColumns(15);
         
        // cài đặt các cột và data cho bảng 
        datveTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneDatveTable.setViewportView(datveTable);
        jScrollPaneDatveTable.setPreferredSize(new Dimension (480, 300));
         
         // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý 
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneDatveTable);
         
        panel.add(addDatveBtn);
        panel.add(editDatveBtn);
        panel.add(deleteDatveBtn);
        panel.add(clearBtn);
        panel.add(timKiemFilmBtn);
        panel.add(dinhdang);
        panel.add(dinhdang1);
         
        panel.add(SttLabel);
        
        panel.add(slLabel);
        panel.add(filmLabel);
        panel.add(timeLabel);
         
        panel.add(SttField);
        
        panel.add(slField);
        panel.add(jScrollPaneFilm);
        panel.add(timeField);
         
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, SttLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, SttLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addDatveBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addDatveBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editDatveBtn, 60, SpringLayout.WEST, addDatveBtn);
        layout.putConstraint(SpringLayout.NORTH, editDatveBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteDatveBtn, 60, SpringLayout.WEST, editDatveBtn);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteDatveBtn);
        
        layout.putConstraint(SpringLayout.NORTH, deleteDatveBtn, 240, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, slLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, slLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, filmLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, filmLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, timeLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, timeLabel, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dinhdang, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dinhdang, 220, SpringLayout.NORTH, panel);
         
        layout.putConstraint(SpringLayout.WEST, SttField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, SttField, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, slField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, slField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneFilm, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneFilm, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, timeField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, timeField, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dinhdang1, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dinhdang1, 220, SpringLayout.NORTH, panel);
        
         
        layout.putConstraint(SpringLayout.WEST, jScrollPaneDatveTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneDatveTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, timKiemFilmBtn, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, timKiemFilmBtn, 330, SpringLayout.NORTH, panel);
         
        
         
        this.add(panel);
        this.pack();
        this.setTitle("Thông tin vé");
        this.setSize(800, 420);
        editDatveBtn.setEnabled(false);
        deleteDatveBtn.setEnabled(false);
        // enable Add button
        addDatveBtn.setEnabled(true);
        
    }
     
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
     
    /**
     * hiển thị list student vào bảng 
     * 
     * @param list
     */
    public void showListDatves(List<Datve> list) {
        int size = list.size();
        
        Object [][] datves = new Object[size][4];
        for (int i = 0; i < size; i++) {
            datves[i][0] = list.get(i).getStt();
            datves[i][1] = list.get(i).getSl();
            datves[i][2] = list.get(i).getTime();
            datves[i][3] = list.get(i).getFilm();
            
        }
        datveTable.setModel(new DefaultTableModel(datves, columnNames));
    }
     
    /**
     * điền thông tin của hàng được chọn từ bảng 
     * vào các trường tương ứng 
     */
    public void fillDatveFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = datveTable.getSelectedRow();
        if (row >= 0) {
            SttField.setText(datveTable.getModel().getValueAt(row, 0).toString());
            slField.setText(datveTable.getModel().getValueAt(row, 1).toString());
            timeField.setText(datveTable.getModel().getValueAt(row, 2).toString());
            filmTA.setText(datveTable.getModel().getValueAt(row, 3).toString());
            
            // enable Edit and Delete buttons
            editDatveBtn.setEnabled(true);
            deleteDatveBtn.setEnabled(true);
            // disable Add button
            addDatveBtn.setEnabled(false);
        }
    }
    /**
     * xóa thông tin 
     */
    public void clearDatveInfo() {
        SttField.setText("");
        slField.setText("");
        
        filmTA.setText("");
        timeField.setText("");
        editDatveBtn.setEnabled(false);
        deleteDatveBtn.setEnabled(false);
        // enable Add button
        addDatveBtn.setEnabled(true);
    }
     
    /**
     * hiện thị thông tin 
     * 
     * @param datve
     *
     */
    public void showDatve(Datve datve) {
        SttField.setText("" + datve.getStt());
        
        slField.setText("" + datve.getSl());
        filmTA.setText(datve.getFilm());
        timeField.setText("" + datve.getTime());
        
        // enable Edit and Delete buttons
        editDatveBtn.setEnabled(true);
        deleteDatveBtn.setEnabled(true);
        // disable Add button
        addDatveBtn.setEnabled(false);
    }
    
     
    /**
     * lấy thông tin
     * 
     * @return
     */
    public Datve getDatveInfo() {
        // validate student
        if ( !validateSl() || !validateFilm()|| !validateTime()) {
            return null;
        }
        try {
            Datve datve = new Datve();
            if (SttField.getText() != null && !"".equals(SttField.getText())) {
                datve.setStt(Integer.parseInt(SttField.getText()));
            }
            
            datve.setSl(Byte.parseByte(slField.getText().trim()));
            datve.setFilm(filmTA.getText().trim());
            datve.setTime(timeField.getText().trim());
            return datve;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
      
    
     
    private boolean validateFilm() {
        String film = filmTA.getText();
        if (film == null || "".equals(film.trim())) {
            filmTA.requestFocus();
            showMessage("Tên phim không được trống.");
            return false;
        }
        return true;
    }
     
    private boolean validateSl() {
        try {
            Byte sl = Byte.parseByte(slField.getText().trim());
            if (sl < 0 || sl > 100) {
                slField.requestFocus();
                showMessage("số vé không hợp lệ, vé nên trong khoảng 1 đến 100.");
                return false;
            }
        } catch (Exception e) {
            slField.requestFocus();
            showMessage("số vé không hợp lệ!");
            return false;
        }
        return true;
    }
    private boolean validateTime() {
        String time = timeField.getText();
        if (time == null || "".equals(time.trim())) {
            timeField.requestFocus();
            showMessage("Thời gian không được bỏ trống");
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(time);
           
        } catch (Exception e) {
            timeField.requestFocus();
            showMessage("Nhap sai dinh dang!");
            return false;
            
        }
    
          return true;
    }
    
 
    
     
    public void actionPerformed(ActionEvent e) {
    }
     
    public void valueChanged(ListSelectionEvent e) {
    }
     
    public void addAddDatveListener(ActionListener listener) {
        addDatveBtn.addActionListener(listener);
    }
    public void addEdiDatveListener(ActionListener listener) {
        editDatveBtn.addActionListener(listener);
    }
    
    public void addDeleteDatveListener(ActionListener listener) {
        deleteDatveBtn.addActionListener(listener);
    }
     public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    public void addListDatveSelectionListener(ListSelectionListener listener) {
        datveTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void addTimKiemFilmListener (ActionListener listener){
        timKiemFilmBtn.addActionListener(listener);
    }
}
