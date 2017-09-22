/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author matheusflausino
 */
public class Estoque implements Serializable{
    private int idFornecedor;
    private int idProduto;
    private int idEstoque;
    private int qtdEstoque;
    
    public int getIdFornecedor(){
        return idFornecedor;
    }
    
    public void setIdFornecedor(int id) throws Exception{
        if(id > 0){
            this.idFornecedor = id;
        }else{
            throw new Exception("ID Invalido");
        }
    }
    
    public int getIdEstoque(){
        return idEstoque;
    }
    
    public void setIdEstoque(int id) throws Exception{
        if(id > 0){
            this.idEstoque = id;
        }else{
            throw new Exception("ID Invalido");
        }
    }
    
    public int getQtdEstoque(){
        return qtdEstoque;
    }
    
    public void setQtdEstoque(int qtd) throws Exception{
        if(qtd >0){
            this.qtdEstoque = qtd;
        }else{
            throw new Exception("Quantidade Invalida");
        }
    }
    
    public int getIdProduto(){
        return idProduto;
    }
    
    public void setIdProduto(int id) throws Exception{
        if(id > 0){
            this.idProduto = id;
        }else{
            throw new Exception("ID Invalido");
        }
    }
}
