package DAOmysql;

import Classes.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro e Matheus
 */
public class DAOCliente {

    private Connection con = null;
    private static final String NOME = "root",
            SENHA = "";

    public void remover(Cliente cliente) throws Exception {
        int id = cliente.getIdCliente();
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("DELETE FROM cliente WHERE id = ?")) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                stmt.close();
            }
        } catch (Exception e) {
            throw new Exception("Erro ao apagar Cliente");
        } finally {
            fechar();
        }
    }

    public ArrayList<Cliente> buscarTodos() throws Exception {
        ArrayList<Cliente> resultados = new ArrayList<>();
        try {
            conectar();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente temp = new Cliente();
                // pega todos os atributos do Cliente
                temp.setIdCliente(rs.getInt("id"));
                temp.setNomeCliente(rs.getString("nome"));
                temp.setDataNascCliente(new Date(rs.getDate("datanasc").getTime()));
                temp.setCpfCliente(rs.getString("cpf"));
                temp.setCidadeCliente(rs.getString("cidade"));
                temp.setEstadoCliente(rs.getString("estado"));
                temp.setCepCliente(rs.getString("cep"));
                temp.setBairroCliente(rs.getString("bairro"));
                temp.setLogradouroCliente(rs.getString("logradouro"));
                temp.setTelefoneCliente(rs.getString("telefone"));
                temp.setComplementoCliente(rs.getString("complemento"));
                temp.setNumeroCliente(rs.getInt("numero"));

                resultados.add(temp);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar Cliente 1");
        }
        return resultados;
    }

    public Cliente buscar(int id) throws Exception {
        Cliente resultados = null;
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM cliente WHERE id LIKE ? LIMIT 1")) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Cliente temp = new Cliente();
                    // pega todos os atributos do Cliente
                    temp.setIdCliente(rs.getInt("id"));
                    temp.setNomeCliente(rs.getString("nome"));
                    temp.setDataNascCliente(new Date(rs.getDate("datanasc").getTime()));
                    temp.setCpfCliente(rs.getString("cpf"));
                    temp.setCidadeCliente(rs.getString("cidade"));
                    temp.setEstadoCliente(rs.getString("estado"));
                    temp.setCepCliente(rs.getString("cep"));
                    temp.setBairroCliente(rs.getString("bairro"));
                    temp.setLogradouroCliente(rs.getString("logradouro"));
                    temp.setTelefoneCliente(rs.getString("telefone"));
                    temp.setComplementoCliente(rs.getString("complemento"));
                    temp.setNumeroCliente(rs.getInt("numero"));
                    resultados = temp;
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar Cliente");
        }
        return resultados;
    }

    public boolean inserir(Cliente pessoaCliente) throws Exception {
        boolean retorno = false;
        String sql = "INSERT INTO cliente ( nome, cpf, datanasc, cidade, estado, cep, bairro, logradouro, telefone, complemento, numero, id)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, pessoaCliente.getNomeCliente());
                stmt.setString(2, pessoaCliente.getCpfCliente());
                stmt.setDate(3, (Date) pessoaCliente.getDataNascCliente());
                stmt.setString(4, pessoaCliente.getCidadeCliente());
                stmt.setString(5, pessoaCliente.getEstadoCliente());
                stmt.setString(6, pessoaCliente.getCepCliente());
                stmt.setString(7, pessoaCliente.getBairroCliente());
                stmt.setString(8, pessoaCliente.getLogradouroCliente());
                stmt.setString(9, pessoaCliente.getTelefoneCliente());
                stmt.setString(10, pessoaCliente.getComplementoCliente());
                stmt.setInt(11, pessoaCliente.getNumeroCliente());
                stmt.setInt(12, pessoaCliente.getIdCliente());
                stmt.executeUpdate();
                stmt.close();
            }
            retorno = true;
        } catch (Exception e) {
            throw new Exception("Erro ao inserir Cliente");
        } finally {
            fechar();
        }
        return retorno;
    }

    public boolean atualizar(Cliente pessoaCliente) throws Exception {
        boolean retorno = false;
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, datanasc = ?, cidade = ?, estado = ?, "
                + "cep = ?, bairro = ?, logradouro = ?, telefone = ?, complemento = ?, numero = ? WHERE  id = ?";
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, pessoaCliente.getNomeCliente());
                stmt.setString(2, pessoaCliente.getCpfCliente());
                stmt.setDate(3, (Date) pessoaCliente.getDataNascCliente());
                stmt.setString(4, pessoaCliente.getCidadeCliente());
                stmt.setString(5, pessoaCliente.getEstadoCliente());
                stmt.setString(6, pessoaCliente.getCepCliente());
                stmt.setString(7, pessoaCliente.getBairroCliente());
                stmt.setString(8, pessoaCliente.getLogradouroCliente());
                stmt.setString(9, pessoaCliente.getTelefoneCliente());
                stmt.setString(10, pessoaCliente.getComplementoCliente());
                stmt.setInt(11, pessoaCliente.getNumeroCliente());
                stmt.setInt(12, pessoaCliente.getIdCliente());
                stmt.executeUpdate();
                stmt.close();
            }
            retorno = true;
        } catch (Exception e) {
            throw new Exception("Erro ao Atualizar");
        } finally {
            fechar();
        }
        return retorno;
    }

    public int ultimoCodigo() throws Exception{
        int id = 0;
        for(Cliente c : this.buscarTodos()){
            id = c.getIdCliente();
        }
        return id;
    }
    private void conectar() throws Exception {
        con = new Dados().conexao(NOME, SENHA);
        System.out.println("Conectado!");
    }

    private void fechar() throws Exception {
        try {
            con.close();
            System.out.println("Conexão Fechada");
        } catch (SQLException e) {
            throw new Exception("Erro ao fechar conexão");
        }
    }
}
