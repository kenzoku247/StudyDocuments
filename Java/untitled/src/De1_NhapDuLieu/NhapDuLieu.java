package De1_NhapDuLieu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhapDuLieu {
    private ArrayList<SinhVienATTT> arrsvATTT = new ArrayList<>();
    private ArrayList<SinhVienMatMa> arrsvMM = new ArrayList<>();
    private JTextField maSV;
    private JTextField hoTen;
    private JTextField ngaySinh;
    private JTextField diemTB;
    private JButton save_bt;
    private JPanel panelMain;
    private JButton ATTT_bt;
    private JButton MatMa_bt;
    private JTextField hocPhi_text;
    private JTextField donVi_text;
    private JTextField luong_text;
    private JButton input_bt;
    private JCheckBox nam_CheckBox;
    private JCheckBox nu_CheckBox;

    public NhapDuLieu() {
        hocPhi_text.setEditable(false);
        donVi_text.setEditable(false);
        luong_text.setEditable(false);

        ATTT_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hocPhi_text.setEditable(true);
                if (luong_text.isEditable() || donVi_text.isEditable()){
                    luong_text.setText("");
                    luong_text.setEditable(false);
                    donVi_text.setText("");
                    donVi_text.setEditable(false);
                }
            }
        });

        MatMa_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donVi_text.setEditable(true);
                luong_text.setEditable(true);
                if (hocPhi_text.isEditable()){
                    hocPhi_text.setText("");
                    hocPhi_text.setEditable(false);
                }
            }
        });

        save_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hocPhi_text.isEditable()){
                    File f = new File("sinhvienantoan.dat");
                    FileWriter fw;
                    try {
                        fw = new FileWriter(f);
                        BufferedWriter bw = new BufferedWriter(fw);

                        for(int i=0; i<arrsvATTT.size(); i++)
                        {
                            bw.write(arrsvATTT.get(i).MaSV+"$"+arrsvATTT.get(i).HoTen+"$"+arrsvATTT.get(i).NgaySinh+"$"
                                    +arrsvATTT.get(i).GioiTinh+"$"+arrsvATTT.get(i).DiemTB+"$"+arrsvATTT.get(i).HocPhi+"$"+"\r\n");
                        }
                        bw.close();
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(NhapDuLieu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Lưu thành công");
                }else {
                    File f = new File("sinhvienmatma.dat");
                    FileWriter fw;
                    try {
                        fw = new FileWriter(f);
                        BufferedWriter bw = new BufferedWriter(fw);

                        for(int i=0; i<arrsvMM.size(); i++)
                        {
                            bw.write(arrsvMM.get(i).MaSV+"$"+arrsvMM.get(i).HoTen+"$"+arrsvMM.get(i).NgaySinh+"$"
                                    +arrsvMM.get(i).GioiTinh+"$"+arrsvMM.get(i).DiemTB+"$"+arrsvMM.get(i).DonVi+"$"+arrsvMM.get(i).Luong+"\r\n");
                        }
                        bw.close();
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(NhapDuLieu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Lưu thành công");}
            }
        });

        input_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str_msv = maSV.getText();
                String str_hoten = hoTen.getText();
                String str_ngaysinh = ngaySinh.getText();
                String str_gioitinh;
                if (nam_CheckBox.isSelected()){
                    str_gioitinh = "Nam";
                } else {
                    str_gioitinh = "Nu";
                }
                String str_diemtb = diemTB.getText();

                if (hocPhi_text.isEditable()){
                    String str_hocphi = hocPhi_text.getText();
                    if(str_msv.equals("")||str_hoten.equals("")||str_ngaysinh.equals("")
                            ||str_diemtb.equals("")||str_hocphi.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin");
                    }else{
                        float flo_diemtb = Float.parseFloat(str_diemtb);
                        int int_hocphi = Integer.parseInt(str_hocphi);
                        SinhVienATTT sv_at = new SinhVienATTT(str_msv, str_hoten, str_ngaysinh, str_gioitinh, flo_diemtb, int_hocphi);
                        arrsvATTT.add(sv_at);
                        JOptionPane.showMessageDialog(null, "Nhập thành công");
                    }
                } else {
                    String str_donvi = donVi_text.getText();
                    String str_luong = luong_text.getText();
                    if(str_msv.equals("")||str_hoten.equals("")||str_ngaysinh.equals("")
                            ||str_diemtb.equals("")||str_donvi.equals("")||str_luong.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin");
                    }else{
                        float flo_diemtb = Float.parseFloat(str_diemtb);
                        int int_luong = Integer.parseInt(str_luong);
                        SinhVienMatMa sv_mm = new SinhVienMatMa(str_msv, str_hoten, str_ngaysinh, str_gioitinh, flo_diemtb, str_donvi, int_luong);
                        arrsvMM.add(sv_mm);
                        JOptionPane.showMessageDialog(null, "Nhập thành công");
                    }
                }
//                for (SinhVienATTT svat : arrsvATTT){
//                    svat.HienTHiTT();
//                }

            }
        });

        nam_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nu_CheckBox.setEnabled(!nam_CheckBox.isSelected());
            }
        });
        nu_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nam_CheckBox.setEnabled(!nu_CheckBox.isSelected());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Nhap Du Lieu");
        frame.setContentPane(new NhapDuLieu().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
