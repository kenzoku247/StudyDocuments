package Bai_4;

import java.util.Objects;
import java.util.Scanner;
public class Input {

    Scanner sc = new Scanner(System.in);

    public Object input(String type){
        Object value = null;
        if (Objects.equals(type, "int")) {
            int value;
            System.out.println(type);
        }
        else if (Objects.equals(type, "string")){
            String value;
            System.out.println(type);
        }
        else if (Objects.equals(type, "char")){
            Character value;
            System.out.println(type);
        }

        return value;

    }
}
