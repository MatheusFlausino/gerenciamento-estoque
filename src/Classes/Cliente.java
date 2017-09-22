/*
    Classe com os principais dados dos clientes
 */
package Classes;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pedro
 *
 */
public class Cliente implements Serializable {

    private String nomeCliente;
    private int idCliente;
    private String cpfCliente;
    private Date dataNascCliente;
    private String cepCLiente;
    private String logradouroCLiente;
    private int numeroCliente;
    private String bairroCliente;
    private String cidadeCliente;
    private String complementoCliente;
    private String estadoCliente;
    private String telefoneCliente;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) throws Exception {
        if (nomeCliente.isEmpty()) {
            throw new Exception("Nome Invalido");
        } else if (nomeCliente.length() < 45) {
            this.nomeCliente = nomeCliente;
        } else {
            throw new Exception("Nome maior que 45 caracteres");
        }
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) throws Exception {
        if (idCliente >= 0) {
            this.idCliente = idCliente;
        } else {
            throw new Exception("ID Invalido");
        }
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) throws Exception {
        cpfCliente = cpfCliente.replaceAll("\\D+", "");
        if (cpfCliente.length() == 11) {
            this.cpfCliente = cpfCliente;
        } else {
            throw new Exception("CPF Invalido");
        }
    }

    public Date getDataNascCliente() {
        return dataNascCliente;
    }

    public void setDataNascCliente(Date dataNascCliente) throws Exception {
        Date dt = new Date();
        if (dataNascCliente.after(dt)) {
            throw new Exception("Data Invalida");
        } else {
            this.dataNascCliente = dataNascCliente;
        }
    }

    public String getCepCliente() {
        return cepCLiente;
    }

    public void setCepCliente(String cepCLiente) throws Exception {
        cepCLiente = cepCLiente.replaceAll("\\D+", "");
        if (cepCLiente.length() == 8) {
            this.cepCLiente = cepCLiente;
        } else {
            throw new Exception("CEP Invalido");
        }
    }

    public String getLogradouroCliente() {
        return logradouroCLiente;
    }

    public void setLogradouroCliente(String logradouroCLiente) throws Exception {
        if (logradouroCLiente.isEmpty()) {
            throw new Exception("Logradouro Invalido");
        } else if (logradouroCLiente.length() < 45) {
            this.logradouroCLiente = logradouroCLiente;
        } else {
            throw new Exception("Logradouro maior que 45 caracteres");
        }
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) throws Exception {
        if (numeroCliente > 0) {
            this.numeroCliente = numeroCliente;
        } else {
            throw new Exception("Numero Invalido");
        }
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) throws Exception {
        if (bairroCliente.isEmpty()) {
            throw new Exception("Bairro Invalido");
        } else if (bairroCliente.length() < 45) {
            this.bairroCliente = bairroCliente;
        } else {
            throw new Exception("Bairro maior que 45 caracteres");
        }
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) throws Exception {
        if (cidadeCliente.isEmpty()) {
            throw new Exception("Cidade Invalida");
        } else if (cidadeCliente.length() < 45) {
            this.cidadeCliente = cidadeCliente;
        } else {
            throw new Exception("Cidade maior que 45 caracteres");
        }
    }

    public String getComplementoCliente() {
        return complementoCliente;
    }

    public void setComplementoCliente(String complementoCliente) {
        this.complementoCliente = complementoCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) throws Exception {
        if (estadoCliente.isEmpty()) {
            throw new Exception("Estado Invalido");
        } else if (estadoCliente.length() < 45) {
            this.estadoCliente = estadoCliente;
        } else {
            throw new Exception("Estado maior que 45 caracteres");
        }
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) throws Exception {
        telefoneCliente = telefoneCliente.replaceAll("\\D+", "");
        if ((telefoneCliente.length() == 10) || (telefoneCliente.length() == 11)) {
            this.telefoneCliente = telefoneCliente;
        } else {
            throw new Exception("Telefone Invalido");
        }
    }

    public Cliente() {
    }

}
