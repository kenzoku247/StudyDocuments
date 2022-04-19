package De2_TuDien;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Search {
    private static ArrayList<Word> arrDict_search = new ArrayList<>();
    private JButton search_bt;
    private JPanel panelMain;
    private JLabel Title;
    private JTextField en_text;
    private JTextField vn_text;
    private JButton add_bt;
    private JLabel notice_text;
    private JButton yes_bt;
    private JButton no_bt;
    private JButton cancel_bt;

    public void Sort(){
        arrDict_search.sort(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return (o1.getEN().compareTo(o2.getEN()));
            }
        });
    }

    public String Search_Bin(String s){
        Sort();

        String vi=null;
        int left = 0;
        int right = arrDict_search.size() - 1;
        while(left<=right)
        {
            int center = left + (right-left)/2;
            int result = arrDict_search.get(center).getEN().compareTo(s);
//            System.out.println(result);
            if(result==0)
            {
                vi = arrDict_search.get(center).getVN();
                break;
            }
            else if(result>0)
            {
                right = center-1;
            }
            else if(result<0)
            {
                left = center+1;
            }
        }

        return vi;
    }

    public Search() {
        yes_bt.setVisible(false);
        no_bt.setVisible(false);
        notice_text.setVisible(false);
        cancel_bt.setVisible(false);
        search_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(en_text.getText(), "")){
                    JOptionPane.showMessageDialog(null, "Ban chua nhap gi ca");
                } else {
                String str_en = en_text.getText();
                String str_vn;
                str_vn = Search_Bin(str_en);
                if (str_vn == null){
                    vn_text.setText("");
                    yes_bt.setVisible(true);
                    no_bt.setVisible(true);
                    notice_text.setVisible(true);
                }
                else vn_text.setText(str_vn);
                }

            }
        });
        add_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vi = vn_text.getText();

                if(vi.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Chưa nhập nghĩa tiếng việt của từ "+en_text.getText());
                }
                else
                {
                    int id = arrDict_search.get(arrDict_search.size()-1).getID()+1;
                    Word w = new Word(id, en_text.getText(), vi);
                    arrDict_search.add(w);
                    JOptionPane.showMessageDialog(null, "Thêm từ mới thành công ");
                }
                for (Word w : arrDict_search){
                    w.HienThi();
                }
            }
        });
        yes_bt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                yes_bt.setVisible(false);
                no_bt.setVisible(false);
                notice_text.setVisible(false);
                vn_text.setEditable(true);
                search_bt.setEnabled(false);
                cancel_bt.setVisible(true);

            }
        });
        no_bt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                yes_bt.setVisible(false);
                no_bt.setVisible(false);
                notice_text.setVisible(false);
                en_text.setText("");
            }
        });
        cancel_bt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                en_text.setText("");
                vn_text.setEditable(false);
                search_bt.setEnabled(true);
                cancel_bt.setVisible(false);
            }
        });
    }



    public static void main(String[] args) {
        Dictionary Dict = new Dictionary();
        Dict.KhoiTao();
        arrDict_search = Dict.arrDict;
        for (Word w : arrDict_search){
            w.HienThi();
        }
        JFrame frame = new JFrame("Nhap Du Lieu");
        frame.setContentPane(new Search().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


}
