/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author pedro canassa
 */
public class Caixa {

    private double valorCaixa;
    private Date dataCaixa;
    private int idCaixa;

    public double getValorCaixa() {
        return valorCaixa;
    }

    public Date getDataCaixa() {
        return dataCaixa;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public void setValorCaixa(double valorCaixa) throws Exception {
        if (valorCaixa >= 0) {
            this.valorCaixa = valorCaixa;
        } else {
            throw new Exception("Valor Invalido");
        }
    }

    public void setDataCaixa(Date dataCaixa) throws Exception {
        Date dt = new Date();
        if (dataCaixa.after(dt)) {
            throw new Exception("Data Invalida");
        } else {
            this.dataCaixa = dataCaixa;
        }
    }

    public void setIdCaixa(int idCaixa) throws Exception {
        if (idCaixa > 0) {
            this.idCaixa = idCaixa;
        } else {
            throw new Exception("ID Invalido");
        }
    }

}
