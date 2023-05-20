package org.example;

import java.util.Date;

public class NationalCode {
    private String number;

    private Date dateOfInsertion;
    private Boolean isValid;

    public NationalCode() {
    }

    public NationalCode(String number, Date dateOfInsertion, Boolean isValid) {
        this.number = number;
        this.dateOfInsertion = dateOfInsertion;
        this.isValid = isValid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateOfInsertion() {
        return dateOfInsertion;
    }

    public void setDateOfInsertion(Date dateOfInsertion) {
        this.dateOfInsertion = dateOfInsertion;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "NationalCode{" +
                "number='" + number + '\'' +
                ", dateOfInsertion=" + dateOfInsertion +
                ", isValid=" + isValid +
                '}'+"\n";
    }
}