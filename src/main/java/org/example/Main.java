package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        LinkedList<NationalCode> listOfNationalCode = new LinkedList<>();
        ValidationNationalCode validationNationalCode = new ValidationNationalCode();
        while (true) {
            System.out.print("enter your national code :");
            String nationalCodeFromUser = myObj.nextLine();
            if (nationalCodeFromUser.equals("exit")) {

                break;
            }
            NationalCode nationalCode = new NationalCode(nationalCodeFromUser, new Date(), false);
            validationNationalCode.validateNationalCode(nationalCode);
            listOfNationalCode.add(nationalCode);
        }
        listOfNationalCode.stream().sorted(new Comparator<NationalCode>() {
            @Override
            public int compare(NationalCode o1, NationalCode o2) {

                return Integer.parseInt(o1.getNumber())-Integer.parseInt(o2.getNumber());
            }
        }).forEach(System.out::println);

    }
}