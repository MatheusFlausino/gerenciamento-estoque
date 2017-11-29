package DAOmysql;

import Classes.Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author matheusflausino
 */
public class DAOEstoque {
     private Connection con = null;
    private static final String NOME = "root",
            SENHA = "123456";

    public void remover(Estoque e) throws Exception {
        int id = e.getIdEstoque();
        
        conectar();
        try (PreparedStatement stmt = con.prepareStatement("DELETE FROM estoque WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        }
        
    }

    public ArrayList<Estoque> buscarTodos() throws Exception {
        ArrayList<Estoque> resultados = new ArrayList<>();
        try {
            conectar();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM estoque");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estoque temp = new Estoque();
                // pega todos os atributos do Estoque
                temp.setIdFornecedor(rs.getInt("idFornecedor"));
                temp.setIdProduto(rs.getInt("idProduto"));
                temp.setIdEstoque(rs.getInt("id"));
                temp.setQtdEstoque(rs.getInt("qtd"));

                resultados.add(temp);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar Estoque 1");
        }
        return resultados;
    }

    public Estoque buscar(int id) throws Exception {
        Estoque resultados = null;
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM estoque WHERE id LIKE ? LIMIT 1")) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Estoque temp = new Estoque();
                    // pega todos os atributos do Estoque
                    temp.setIdFornecedor(rs.getInt("idFornecedor"));
                    temp.setIdProduto(rs.getInt("idProduto"));
                    temp.setIdEstoque(rs.getInt("id"));
                    temp.setQtdEstoque(rs.getInt("qtd"));
                    resultados = temp;
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar Estoque");
        }
        return resultados;
    }

    public boolean inserir(Estoque novoEstoque) throws Exception {
        boolean retorno = false;
        String sql = "INSERT INTO estoque ( id, idFornecedor, idProduto, qtd) VALUES(?,?,?,?)";

        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, novoEstoque.getIdEstoque());
                stmt.setInt(2, novoEstoque.getIdFornecedor());
                stmt.setInt(3, novoEstoque.getIdProduto());
                stmt.setInt(4, novoEstoque.getQtdEstoque());

                stmt.executeUpdate();
                stmt.close();
            }
            retorno = true;
        } catch (Exception e) {
            throw new Exception("Erro ao inserir Estoque");
        } finally {
            fechar();
        }
        return retorno;
    }

    public boolean atualizar(Estoque atuaEstoque) throws Exception {
        boolean retorno = false;
        String sql = "UPDATE estoque SET idFornecedor = ?, qtd = ?, idProduto = ? WHERE  id = ?";
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, atuaEstoque.getIdFornecedor());
                stmt.setInt(2, atuaEstoque.getQtdEstoque());
                stmt.setInt(3, atuaEstoque.getIdProduto());
                stmt.setInt(4, atuaEstoque.getIdEstoque());

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
        for(Estoque e : this.buscarTodos()){
            id = e.getIdEstoque();
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
