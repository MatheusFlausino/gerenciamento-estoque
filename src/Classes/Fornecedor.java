/*
    Classe com os principais dados dos Fornecedores
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author pedro
 */
public class Fornecedor implements Serializable {

    private String nomeFornecedor;
    private int idFornecedor;
    private String cnpjFornecedor;
    private String cepFornecedor;
    private String logradouroFornecedor;
    private String complementoFornecedor;
    private int numeroFornecedor;
    private String bairroFornecedor;
    private String cidadeFornecedor;
    private String estadoFornecedor;
    private String telefoneFornecedor;

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) throws Exception {
        if (nomeFornecedor.isEmpty()) {
            throw new Exception("Nome Invalido");
        } else if (nomeFornecedor.length() < 45) {
            this.nomeFornecedor = nomeFornecedor;
        } else {
            throw new Exception("Nome maior que 45 caracteres");
        }
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) throws Exception {
        if (idFornecedor >= 0) {
            this.idFornecedor = idFornecedor;
        } else {
            throw new Exception("ID Invalido");
        }
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) throws Exception {
        cnpjFornecedor = cnpjFornecedor.replaceAll("\\D+", "");
        if (cnpjFornecedor.length() == 14) {
            this.cnpjFornecedor = cnpjFornecedor;
        } else {
            throw new Exception("CNPJ Invalido");
        }
    }

    public String getCepFornecedor() {
        return cepFornecedor;
    }

    public void setCepFornecedor(String cepFornecedor) throws Exception {
        cepFornecedor = cepFornecedor.replaceAll("\\D+", "");
        if (cepFornecedor.length() == 8) {
            this.cepFornecedor = cepFornecedor;
        } else {
            throw new Exception("CEP Invalido");
        }
    }

    public String getLogradouroFornecedor() {
        return logradouroFornecedor;
    }

    public void setLogradouroFornecedor(String logradouroFornecedor) throws Exception {
        if (logradouroFornecedor.isEmpty()) {
            throw new Exception("Logradouro Invalido");
        } else if (logradouroFornecedor.length() < 45) {
            this.logradouroFornecedor = logradouroFornecedor;
        } else {
            throw new Exception("Logradouro maior que 45 caracteres");
        }
    }

    public int getNumeroFornecedor() {
        return numeroFornecedor;
    }

    public void setNumeroFornecedor(int numeroFornecedor) throws Exception {
        if (numeroFornecedor > 0) {
            this.numeroFornecedor = numeroFornecedor;
        } else {
            throw new Exception("Numero Invalido");
        }
    }

    public String getBairroFornecedor() {
        return bairroFornecedor;
    }

    public void setBairroFornecedor(String bairroFornecedor) throws Exception {
        if (bairroFornecedor.isEmpty()) {
            throw new Exception("Bairro Invalido");
        } else if (bairroFornecedor.length() < 45) {
            this.bairroFornecedor = bairroFornecedor;
        } else {
            throw new Exception("Bairro maior que 45 caracteres");
        }
    }

    public String getEstadoFornecedor() {
        return estadoFornecedor;
    }

    public void setEstadoFornecedor(String estadoFornecedor) throws Exception {
        if (estadoFornecedor.isEmpty()) {
            throw new Exception("Estado Invalido");
        } else if (estadoFornecedor.length() < 45) {
            this.estadoFornecedor = estadoFornecedor;
        } else {
            throw new Exception("Estado maior que 45 caracteres");
        }
    }

    public String getCidadeFornecedor() {
        return cidadeFornecedor;
    }

    public void setCidadeFornecedor(String cidadeFornecedor) throws Exception {
        if (cidadeFornecedor.isEmpty()) {
            throw new Exception("Cidade Invalida");
        } else if (cidadeFornecedor.length() < 45) {
            this.cidadeFornecedor = cidadeFornecedor;
        } else {
            throw new Exception("Cidade maior que 45 caracteres");
        }
    }

    public String getComplementoFornecedor() {
        return complementoFornecedor;
    }

    public void setComplementoFornecedor(String complementoFornecedor) {
        this.complementoFornecedor = complementoFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) throws Exception {
        telefoneFornecedor = telefoneFornecedor.replaceAll("\\D+", "");
        if ((telefoneFornecedor.length() == 10) || (telefoneFornecedor.length() == 11)) {
            this.telefoneFornecedor = telefoneFornecedor;
        } else {
            throw new Exception("Telefone Invalido");
        }
    }

    public Fornecedor() {
    }
}
