/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constrants;

/**
 *
 * @author hoanghamhoc
 */
public enum Gender {
    MALE("M"), FEMALE("F"), NONE("N");
    String label;

    private Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
