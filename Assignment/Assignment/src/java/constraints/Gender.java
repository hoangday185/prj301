/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constraints;

/**
 *
 * @author hoanghamhoc
 */
public enum Gender {
    Male(1),
    Female(2),
    Unknow(3);
    int codeGender;

    private Gender(int codeGender) {
        this.codeGender = codeGender;
    }

    public int getCodeGender() {
        return codeGender;
    }

    public void setCodeGender(int codeGender) {
        this.codeGender = codeGender;
    }

}
