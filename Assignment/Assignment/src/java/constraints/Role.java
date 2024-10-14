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
public enum Role {
    ADMIN(1), SHIPPER(2), CUSTOMER(3);
    int codeRole;

    private Role(int codeRole) {
        this.codeRole = codeRole;
    }

    public int getRole() {
        return codeRole;
    }

    public void setRole(int codeRole) {
        this.codeRole = codeRole;
    }
}
