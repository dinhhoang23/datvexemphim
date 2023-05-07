/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import dao.UserDao;
import etiny.User;
import view.DatveView;
import view.LoginView;

/**
 *
 * @author nddh2
 */
public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private DatveView datveView;
    
     
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }
     
    public void showLoginView() {
        loginView.setVisible(true);
    }
     
    /**
     * Lớp LoginListener 
     * chứa cài đặt cho sự kiện click button "Login"
     
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý 
                datveView = new DatveView();
                DatveController datveController = new DatveController(datveView);
                datveController.showDatveView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
