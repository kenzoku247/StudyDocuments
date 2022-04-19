import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Form {
    private ArrayList<Student> arrStudent = new ArrayList<>();
    private JTextField hoten_text;
    private JTextField ngaysinh_text;
    private JTextField diachi_text;
    private JTextField masv_text;
    private JButton input_bt;
    private JButton save_bt;
    private JButton cancel_bt;
    private JTextField email_text;
    private JTextField diem_text;
    private JPanel panelMain;
    private JCheckBox nam_CheckBox;
    private JCheckBox nu_CheckBox;

    public Form() {
        nam_CheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                nu_CheckBox.setEnabled(!nam_CheckBox.isSelected());
            }
        });
        nu_CheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                nam_CheckBox.setEnabled(!nu_CheckBox.isSelected());
            }
        });
        input_bt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String hoten = hoten_text.getText();
                String ngaysinh = ngaysinh_text.getText();
                String gioitinh="";
                if (nam_CheckBox.isSelected()){
                    gioitinh = "Nam";
                } else {gioitinh = "Nữ";}
                String diachi = diachi_text.getText();
                String masv = masv_text.getText();
                String email = email_text.getText();
                String str_diemtk = diem_text.getText();

                if(hoten.equals("")||ngaysinh.equals("")||diachi.equals("")
                        ||masv.equals("")||email.equals("")||str_diemtk.equals("")
                        ||(!nam_CheckBox.isSelected())||(!nu_CheckBox.isSelected()))
                {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin");
                }else {
                    float f_diemtk = Float.parseFloat(str_diemtk);
                    Student student = new Student(hoten, ngaysinh, gioitinh, diachi, masv, email, f_diemtk);
                    arrStudent.add(student);
                    JOptionPane.showMessageDialog(null, "Nhập thành công");
                    student.HienThi();
                }

            }
        });
        save_bt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                File f = new File("sinhvien.dat");
                FileWriter fw;
                try {
                    fw = new FileWriter(f);
                    BufferedWriter bw = new BufferedWriter(fw);
                    if(hoten_text.getText().equals("")||ngaysinh_text.getText().equals("")||diachi_text.getText().equals("")
                            ||masv_text.getText().equals("")||email_text.getText().equals("")||diem_text.getText().equals("")
                            ||(!nam_CheckBox.isSelected())||(!nu_CheckBox.isSelected()))
                    {
                        JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin");
                    }else {
                        for (int i = 0; i < arrStudent.size(); i++) {
                            bw.write(arrStudent.get(i).getHoTen() + "$" + arrStudent.get(i).getNgaySinh() + "$" + arrStudent.get(i).getGioiTinh() + "$"
                                    + arrStudent.get(i).getDiaChi() + "$" + arrStudent.get(i).getMaSV() + "$" + arrStudent.get(i).getEmail() + "$" + arrStudent.get(i).getDiemTK() + "\r\n");
                        }
                        bw.close();
                        fw.close();
                        JOptionPane.showMessageDialog(null, "Lưu thành công");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        });
        cancel_bt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                hoten_text.setText("");
                ngaysinh_text.setText("");
                diachi_text.setText("");
                masv_text.setText("");
                email_text.setText("");
                diem_text.setText("");
                if (nam_CheckBox.isSelected()){
                    nam_CheckBox.setSelected(false);
                    nu_CheckBox.setEnabled(true);
                } else {
                    nu_CheckBox.setSelected(false);
                    nam_CheckBox.setEnabled(true);
                }
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Nhap Du Lieu");
        frame.setContentPane(new Form().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
