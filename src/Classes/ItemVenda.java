/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author matheusflausino
 */
public class ItemVenda {
    private int IdProduto;
    private String IdVenda;
    private double PrecoProduto;
    private String NomeProduto;
    private int qtdProduto;

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int IdProduto) throws Exception {
        if (IdProduto > 0) {
            this.IdProduto = IdProduto;
        } else {
            throw new Exception("ID Invalido");
        }
    }

    public String getIdVenda() {
        return IdVenda;
    }

    public void setIdVenda(String IdVenda) throws Exception {
        if (IdVenda.length() > 0) {
            this.IdVenda = IdVenda;
        } else {
            throw new Exception("ID Invalido");
        }
    }

    public double getPrecoProduto() {
        return PrecoProduto;
    }

    public void setPrecoProduto(double PrecoProduto) throws Exception {
        if (PrecoProduto > 0) {
            this.PrecoProduto = PrecoProduto;
        } else {
            throw new Exception("Preco Invalido");
        }
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) throws Exception {
        if (nomeProduto.isEmpty()) {
            throw new Exception("Nome Invalido");
        } else if (nomeProduto.length() < 25) {
            this.NomeProduto = nomeProduto;
        } else {
            throw new Exception("Nome maior que 25 caracteres");
        }
    }
    public int getQtdProduto(){
        return qtdProduto;
    }
    public void setQtdProduto(int qtdProduto) throws  Exception {
        if (qtdProduto > 0){
            this.qtdProduto = qtdProduto;
        }else{
            throw new Exception("Quantidade Invalida");
        }
    }
}
