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
public enum StatusOrder {
    OrderSuccessfull(1),
    Shipping(2),
    ShipSuccessfull(3),
    Fail(4);
    int code;

    private StatusOrder(int code) {
        this.code = code;
    }

    public int getStatusCode() {
        return code;
    }

    public void setStatusCode(int code) {
        this.code = code;
    }
}
