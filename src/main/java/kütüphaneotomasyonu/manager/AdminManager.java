package kütüphaneotomasyonu.manager;

import kütüphaneotomasyonu.form.AdminHomePage;
import kütüphaneotomasyonu.form.AdminLogin;
import kütüphaneotomasyonu.form.HomePage;
import kütüphaneotomasyonu.dal.IAdmin;
import kütüphaneotomasyonu.dal.OracleAdminDal;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import kütüphaneotomasyonu.dal.IMember;
import kütüphaneotomasyonu.dal.OracleMemberDal;

public class AdminManager extends PersonManager implements IAdminManager {


    public void adminLoginValidator(String userName, String userPassword) {
        IAdmin adminLoginDatabase = new OracleAdminDal();

        try {

            if (adminLoginDatabase.adminLogin(userName, userPassword)) {
                AdminLogin adminLogin = new AdminLogin();
                adminLogin.userName = userName;
                adminLogin.password = userPassword;
                
                AdminHomePage adminHomeForm = new AdminHomePage();

                adminHomeForm.setVisible(true);
                javax.swing.JFrame adminLoginDispose = new AdminLogin();
                adminLoginDispose.dispose();

            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Hesap Bilgileri Yanlış", "Hata", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException exception) {
            exception.getErrorCode();
            exception.getMessage();
        }
    }


    public void adminRegisterControl(String userPasswordV, String userPasswordRepeatV, String name, String surname, String userName, String userPassword) {
        if (name.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "AD BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (surname.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "SOYAD BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (userName.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "KULLANICI ADI BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (userPassword.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "ŞİFRE BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (userPasswordRepeatV.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "ŞİFRE TEKRAR BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else {

            if (userPasswordV.equals(userPasswordRepeatV)) {
                IAdmin adminRegisterDatabase = new OracleAdminDal();
                try {
                    adminRegisterDatabase.adminRegister(name, surname, userName, userPassword);
                    HomePage a=new HomePage();
                    a.disable();
                } catch (SQLException exception) {
                    exception.getErrorCode();
                    exception.getMessage();
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Şifre ve Şifre Tekrar aynı olmak zorunda", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public void announcementsControl(String areaAnnouncements) {
        if (areaAnnouncements.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "DUYURU BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            IAdmin announcements = new OracleAdminDal();
            try {
                announcements.announcementAdd(areaAnnouncements);
            } catch (SQLException exception) {
                exception.getErrorCode();
                exception.getMessage();
            }
        }
    }


    public void booksAddControl(String bookName, String authorName, String publishingHouse, String bookType) {
        if (bookName.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "KİTAP ADI BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (authorName.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "YAZAR ADI BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (publishingHouse.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "YAYIN EVİ BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (bookType.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "KİTAP TÜRÜ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            IAdmin booksAdd = new OracleAdminDal();
            try {
                booksAdd.bookAdd(bookName, authorName, publishingHouse, bookType);
            } catch (SQLException exception) {
                exception.getErrorCode();
                exception.getMessage();
            }
        }
    }


    public void membersAddControl(String userPasswordV, String userPasswordRepeatV, String name, String surname, String userName, String userPassword) {
        if (name.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "AD BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (surname.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "SOYAD BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (userName.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "KULLANICI ADI BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (userPassword.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "ŞİFRE BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else if (userPasswordRepeatV.length() == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "ŞİFRE TEKRAR BOŞ BIRAKILAMAZ", "BOŞ BIRAKILAMAZ", JOptionPane.INFORMATION_MESSAGE);
        } else {

            if (userPasswordV.equals(userPasswordRepeatV)) {
                IMember memberRegisterDatabase = new OracleMemberDal();
                try {
                    memberRegisterDatabase.memberRegister(name, surname, userName, userPassword);
                } catch (SQLException exception) {
                    exception.getErrorCode();
                    exception.getMessage();
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Şifre ve Şifre Tekrar aynı olmak zorunda", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }

    }


    public void memberDelete(JTable tblBooksList) throws SQLException {
        OracleAdminDal memberDelete1 = new OracleAdminDal();

        try {
            int index2 = tblBooksList.getSelectedRow();
            tblBooksList.getValueAt(index2, 0);

            memberDelete1.memberDelete(tblBooksList.getValueAt(index2, 0));
            IAdmin bookList = new OracleAdminDal();
            bookList.populateTableMembers(tblBooksList);
        } catch (SQLException exception) {
            exception.getErrorCode();
            exception.getMessage();
        }catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Üye Seçmediniz");
        }
    }


    public void memberUpdate(JTable tblBooksList, String name, String surname, String userName, String password) throws SQLException {
        OracleAdminDal memberUpdate1 = new OracleAdminDal();

        try {
            int index2 = tblBooksList.getSelectedRow();
            tblBooksList.getValueAt(index2, 0);

            memberUpdate1.memberUpdate(tblBooksList.getValueAt(index2, 0), name, surname, userName, password);
            IAdmin bookList = new OracleAdminDal();
            bookList.populateTableMembers(tblBooksList);
        } catch (SQLException exception) {
            exception.getErrorCode();
            exception.getMessage();
        }catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Üye Seçmediniz");
        }

    }
}
