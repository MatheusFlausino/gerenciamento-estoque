/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author matheusflausino
 */
public class Venda {
    private String idVenda;
    private int idCliente;
    private String tipoPagVenda;
    private Date dataVenda;
    private double totalVenda;
    private double descontoVenda;

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) throws Exception {
        if (idVenda.length() > 0) {
            this.idVenda = idVenda;
        } else {
            throw new Exception("ID Invalido");
        }
    }

    public String getTipoPagVenda() {
        return tipoPagVenda;
    }

    public void setTipoPagVenda(String tipoPagVenda) throws Exception {
        if (tipoPagVenda.isEmpty()) {
            throw new Exception("Pagamento Invalido");
        } else {
            this.tipoPagVenda = tipoPagVenda;
        }
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) throws Exception {
        Date dt = new Date();
        if (dataVenda.after(dt)) {
            throw new Exception("Data Invalida");
        } else {
            this.dataVenda = dataVenda;
        }
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) throws Exception {
        if (totalVenda > 0) {
            this.totalVenda = totalVenda;
        } else {
            throw new Exception("Valor Invalido");
        }
    }

    public double getDescontoVenda() {
        return descontoVenda;
    }

    public void setDescontoVenda(double descontoVenda) throws Exception {
        if (descontoVenda >= 0) {
            this.descontoVenda = descontoVenda;
        } else {
            throw new Exception("Desconto Invalido");
        }
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) throws Exception {
        if (idCliente > 0) {
            this.idCliente = idCliente;
        } else {
            throw new Exception("ID Invalido");
        }
    }

    
}
