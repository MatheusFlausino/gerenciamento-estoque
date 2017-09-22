/*
 Classe com os principais dados dos produtos
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author pedro e mathues
 */
public class Produto implements Serializable {

    private int idProduto;
    private String nomeProduto;
    private double precoProduto;
    private String fabricanteProduto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) throws Exception {
        if (nomeProduto.isEmpty()) {
            throw new Exception("Nome Invalido");
        } else if (nomeProduto.length() < 25) {
            this.nomeProduto = nomeProduto;
        } else {
            throw new Exception("Nome maior que 25 caracteres");
        }
    }


    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) throws Exception {
        if (idProduto >= 0) {
            this.idProduto = idProduto;
        } else {
            throw new Exception("ID Invalido");
        }
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) throws Exception {
        if (precoProduto > 0) {
            this.precoProduto = precoProduto;
        } else {
            throw new Exception("Preco Invalido");
        }
    }

    public String getFabricanteProduto() {
        return fabricanteProduto;
    }

    public void setFabricanteProduto(String fabricanteProduto) throws Exception {
        if (fabricanteProduto.isEmpty()) {
            throw new Exception("Nome Invalido");
        } else if (fabricanteProduto.length() < 25) {
            this.fabricanteProduto = fabricanteProduto;
        } else {
            throw new Exception("Nome maior que 25 caracteres");
        }
    }
}
