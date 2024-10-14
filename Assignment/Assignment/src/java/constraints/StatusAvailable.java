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
public enum StatusAvailable {
    //enum này cho status của account(nếu notavailable thì đã bị ban acc hoặc ko còn bán loại hoa đó nữa)
    Available(0), NotAvailable(1);
    int codeAvailabel;

    private StatusAvailable(int codeAvailabel) {
        this.codeAvailabel = codeAvailabel;
    }

    public int getCodeAvailabel() {
        return codeAvailabel;
    }

    public void setCodeAvailabel(int codeAvailabel) {
        this.codeAvailabel = codeAvailabel;
    }

}
