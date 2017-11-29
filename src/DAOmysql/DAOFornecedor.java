package DAOmysql;

import Classes.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class DAOFornecedor {
    // Configura essas variáveis de acordo com o seu banco  

    private Connection con = null;
    private static final String NOME = "root",
            SENHA = "123456";

    public void remover(Fornecedor f) throws Exception {
        int id = f.getIdFornecedor();
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("DELETE FROM fornecedor WHERE id = ?")) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                stmt.close();
                
            }
        } catch (Exception e) {
            throw new Exception("Erro ao apagar Fornecedor");
        } finally {
            fechar();
        }
    }

    public ArrayList<Fornecedor> buscarTodos() throws Exception {
        ArrayList<Fornecedor> resultados = new ArrayList<>();
        try {
            conectar();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM fornecedor");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor temp = new Fornecedor();
                // pega todos os atributos do Fornecedor 
                temp.setIdFornecedor(rs.getInt("id"));
                temp.setNomeFornecedor(rs.getString("nome"));
                temp.setCnpjFornecedor(rs.getString("cnpj"));
                temp.setCidadeFornecedor(rs.getString("cidade"));
                temp.setEstadoFornecedor(rs.getString("estado"));
                temp.setCepFornecedor(rs.getString("cep"));
                temp.setBairroFornecedor(rs.getString("bairro"));
                temp.setLogradouroFornecedor(rs.getString("logradouro"));
                temp.setTelefoneFornecedor(rs.getString("telefone"));
                temp.setComplementoFornecedor(rs.getString("complemento"));
                temp.setNumeroFornecedor(rs.getInt("numero"));

                resultados.add(temp);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar pessoas");
        }
        return resultados;
    }

    public Fornecedor buscar(int id) throws Exception {
        Fornecedor resultados = null;
        try {
            conectar();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM fornecedor WHERE id LIKE ? LIMIT 1");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor temp = new Fornecedor();
                // pega todos os atributos do Fornecedor
                temp.setIdFornecedor(rs.getInt("id"));
                temp.setNomeFornecedor(rs.getString("nome"));
                temp.setCnpjFornecedor(rs.getString("cnpj"));
                temp.setCidadeFornecedor(rs.getString("cidade"));
                temp.setEstadoFornecedor(rs.getString("estado"));
                temp.setCepFornecedor(rs.getString("cep"));
                temp.setBairroFornecedor(rs.getString("bairro"));
                temp.setLogradouroFornecedor(rs.getString("logradouro"));
                temp.setTelefoneFornecedor(rs.getString("telefone"));
                temp.setComplementoFornecedor(rs.getString("complemento"));
                temp.setNumeroFornecedor(rs.getInt("numero"));
                resultados = temp;
            }
            return resultados;
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar Fornecedor");
        }

    }

    public boolean inserir(Fornecedor pessoaFornecedor) throws Exception {
        boolean retorno = false;
        try {
            conectar();
            String sql = "INSERT INTO fornecedor"
                    + "(id, nome, cnpj, cidade, estado, cep, bairro, logradouro, telefone, complemento, numero)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, pessoaFornecedor.getIdFornecedor());
                stmt.setString(2, pessoaFornecedor.getNomeFornecedor());
                stmt.setString(3, pessoaFornecedor.getCnpjFornecedor());
                stmt.setString(4, pessoaFornecedor.getCidadeFornecedor());
                stmt.setString(5, pessoaFornecedor.getEstadoFornecedor());
                stmt.setString(6, pessoaFornecedor.getCepFornecedor());
                stmt.setString(7, pessoaFornecedor.getBairroFornecedor());
                stmt.setString(8, pessoaFornecedor.getLogradouroFornecedor());
                stmt.setString(9, pessoaFornecedor.getTelefoneFornecedor());
                stmt.setString(10, pessoaFornecedor.getComplementoFornecedor());
                stmt.setInt(11, pessoaFornecedor.getNumeroFornecedor());
                stmt.executeUpdate();
                stmt.close();
            }
            retorno = true;
        } catch (Exception e) {
            throw new Exception("Erro ao inserir Fornecedor");
        } finally {
            fechar();
        }
        return retorno;
    }

    public boolean atualizar(Fornecedor pessoaFornecedor) throws Exception {
        boolean resultado = false;
        String sql = "UPDATE fornecedor SET nome = ?, cnpj = ?, cidade = ?, estado = ?, cep = ?, "
                + "bairro =?, logradouro = ?, telefone = ?, complemento = ?, numero =? WHERE  id = ?";
        try {
            conectar();

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, pessoaFornecedor.getNomeFornecedor());
                stmt.setString(2, pessoaFornecedor.getCnpjFornecedor());
                stmt.setString(3, pessoaFornecedor.getCidadeFornecedor());
                stmt.setString(4, pessoaFornecedor.getEstadoFornecedor());
                stmt.setString(5, pessoaFornecedor.getCepFornecedor());
                stmt.setString(6, pessoaFornecedor.getBairroFornecedor());
                stmt.setString(7, pessoaFornecedor.getLogradouroFornecedor());
                stmt.setString(8, pessoaFornecedor.getTelefoneFornecedor());
                stmt.setString(9, pessoaFornecedor.getComplementoFornecedor());
                stmt.setInt(10, pessoaFornecedor.getNumeroFornecedor());
                stmt.setInt(11, pessoaFornecedor.getIdFornecedor());
                stmt.executeUpdate();
                stmt.close();
            }
            resultado = true;
        } catch (Exception e) {
            throw new Exception("Erro ao Atualizar");
        } finally {
            fechar();
        }
        return resultado;
    }
    
    public int ultimoCodigo() throws Exception{
        int id = 0;
        for(Fornecedor f : this.buscarTodos()){
            id = f.getIdFornecedor();
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
