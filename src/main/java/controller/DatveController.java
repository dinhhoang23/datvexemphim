/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
 
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
 
import dao.DatveDao;
import etiny.Datve;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.DatveView;
/**
 *
 * @author nddh2
 */
public class DatveController {
    private DatveDao datveDao;
    private DatveView datveView;
 
    public DatveController(DatveView view) {
        this.datveView = view;
        datveDao = new DatveDao();
        view.addAddDatveListener(new AddDatveListener());
        view.addEdiDatveListener(new EditDatveListener());
        view.addDeleteDatveListener(new DeleteDatveListener());
        view.addClearListener(new ClearDatveListener());
        view.addListDatveSelectionListener(new ListDatveSelectionListener());
        view.addTimKiemFilmListener(new TimKiemFilmListener());
       
       
    }
 
    public void showDatveView() {
        List<Datve> datveList = datveDao.getListDatves();
        datveView.setVisible(true);
        datveView.showListDatves(datveList);
    }
 
    /**
   
     * chứa cài đặt cho sự kiện click button "Add"
     
     */
    class AddDatveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Datve datve = datveView.getDatveInfo();
            
            if (datve != null) {
                datveDao.add(datve);
                datveView.showDatve(datve);
                datveView.showListDatves(datveDao.getListDatves());
                datveView.showMessage("Thêm thành công!");
            }
        }
    }
    /**
     
     * chứa cài đặt cho sự kiện click button "Edit"
     
     */
    class EditDatveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Datve datve = datveView.getDatveInfo();
            if (datve != null) {
                datveDao.edit(datve);
                datveView.showDatve(datve);
                datveView.showListDatves(datveDao.getListDatves());
                datveView.showMessage("Cập nhật thành công!");
            }
        }
    }
 
    /**
     
     * chứa cài đặt cho sự kiện click button "Delete"
     
     */
    class DeleteDatveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Datve datve = datveView.getDatveInfo();
            if (datve != null) {
                datveDao.delete(datve);
                datveView.clearDatveInfo();
                datveView.showListDatves(datveDao.getListDatves());
                datveView.showMessage("Xóa thành công!");
            }
        }
    }
 
    /**
     
     * chứa cài đặt cho sự kiện click button "Clear"
    
     */
    class ClearDatveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            datveView.clearDatveInfo();
            
            
        }
    }
 
  
    class TimKiemFilmListener implements ActionListener {
        private JButton timKiembtn;
        private JTextField nameField;
        private JDialog dialog;
        public void actionPerformed(ActionEvent e) {
    dialog = new JDialog(datveView, "Tìm kiếm tên phim", true);
    dialog.setLocationRelativeTo(datveView);

    nameField = new JTextField(20);
    timKiembtn = new JButton("Tìm kiếm");
    timKiembtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (nameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Bạn chưa nhập tên phim.");
            } else {
                Datve datve = datveDao.findfilm(nameField.getText().trim());
                if (datve != null) {
                    datveView.showDatve(datve);
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Không tìm thấy phim.");
                }
            }
        }
    });

    JPanel panel1 = new JPanel();
    panel1.add(nameField);
    panel1.add(timKiembtn);

    dialog.getContentPane().add(panel1);
    dialog.pack();
    dialog.setVisible(true);
}
    }
 
    
     class ListDatveSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            datveView.fillDatveFromSelectedRow();
        }
    }
}
