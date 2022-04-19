package De2_TuDien;

import javax.swing.*;
import java.util.ArrayList;

public class Dictionary{
    ArrayList<Word> arrDict = new ArrayList<>();

    public void KhoiTao(){
        Word w1 = new Word(1, "hello", "xin chào");
        Word w2 = new Word(2, "class", "lớp");
        Word w3 = new Word(3, "java", "lập trình java");
        Word w4 = new Word(4, "orange", "quả cam");
        Word w5 = new Word(5, "banana", "quả chuối");
        Word w6 = new Word(6, "english", "tiếng anh");
        Word w7 = new Word(7, "bag", "cặp, túi xách");
        Word w8 = new Word(8, "pen", "cái bút");
        Word w9 = new Word(9, "pencil", "bút chì");
        Word w10 = new Word(10, "table", "bàn");
        Word w11 = new Word(11, "chair", "ghế");
        arrDict.add(w1);
        arrDict.add(w2);
        arrDict.add(w3);
        arrDict.add(w4);
        arrDict.add(w5);
        arrDict.add(w6);
        arrDict.add(w7);
        arrDict.add(w8);
        arrDict.add(w9);
        arrDict.add(w10);
        arrDict.add(w11);
    }

    public void NhapDuLieu(){

    }




}
