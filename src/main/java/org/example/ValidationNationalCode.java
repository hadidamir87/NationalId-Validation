package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class ValidationNationalCode implements NationalCodeBusiness {

//    LinkedList<NationalCode> listOfNationalCode = new LinkedList<>();

    @Override
    public void validateNationalCode(NationalCode nationalCode) {
        try {
            Integer.parseInt(nationalCode.getNumber());
            if (nationalCode.getNumber().length() < 8 || nationalCode.getNumber().length() > 10) {
                throw new Exception();
            }
        } catch (Exception e) {
            return;
        }
        repairOfNationalCode(nationalCode);

        verificationOfPersonUniqCode(nationalCode);
    }

    @Override
    public String getStateCode(NationalCode nationalCode) {

        return nationalCode.getNumber().substring(0, 3);
    }

    @Override
    public String getPersonUniqueCode(NationalCode nationalCode) {
        return nationalCode.getNumber().substring(3, 9);

    }


    public void repairOfNationalCode(NationalCode nationalCode) {
        switch (nationalCode.getNumber().length()) {
            case 8 -> nationalCode.setNumber("00" + nationalCode.getNumber());
            case 9 -> nationalCode.setNumber("0" + nationalCode.getNumber());
        }
    }

    public void verificationOfPersonUniqCode(NationalCode nationalCode) {

        int sum = 0;
        int result = 0;
        for (int i = 10; i > 1; i--) {
            sum += Integer.parseInt(String.valueOf(nationalCode.getNumber().charAt(10 - i))) * i;
        }
        if (sum % 11 < 2) {
            result = sum % 11;
        }
        if (result == Integer.parseInt(String.valueOf(nationalCode.getNumber().charAt(9)))) {
            nationalCode.setValid(true);
        } else {
            result = 11 - (sum % 11);
            if ((result == Integer.parseInt(String.valueOf(nationalCode.getNumber().charAt(9))))) {
                nationalCode.setValid(true);
            }
        }
    }
}
