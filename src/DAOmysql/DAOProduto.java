package DAOmysql;

import Classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro e Matheus
 */
public class DAOProduto {

    private Connection con = null;
    private static final String NOME = "root",
            SENHA = "";

    public void remover(Produto p) throws Exception {
        int id = p.getIdProduto();
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?")) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                stmt.close();
            }
        } catch (Exception e) {
            throw new Exception("Erro ao apagar Produto");
        } finally {
            fechar();
        }
    }

    public ArrayList<Produto> buscarTodos() throws Exception {
        ArrayList<Produto> resultados = new ArrayList<>();
        try {
            conectar();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM produto");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto temp = new Produto();
                // pega todos os atributos do Produto
                temp.setNomeProduto(rs.getString("nome"));
                temp.setIdProduto(rs.getInt("id"));
                temp.setPrecoProduto(rs.getDouble("preco"));
                temp.setFabricanteProduto(rs.getString("fabricante"));

                resultados.add(temp);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar Produto 1");
        }
        return resultados;
    }

    public Produto buscar(int id) throws Exception {
        Produto resultados = null;
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM produto WHERE id LIKE ? LIMIT 1")) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Produto temp = new Produto();
                    // pega todos os atributos do Produto
                    temp.setNomeProduto(rs.getString("nome"));
                    temp.setIdProduto(rs.getInt("id"));
                    temp.setPrecoProduto(rs.getDouble("preco"));
                    temp.setFabricanteProduto(rs.getString("fabricante"));
                    resultados = temp;
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar Produto");
        }
        return resultados;
    }

    public boolean inserir(Produto novoProduto) throws Exception {
        boolean retorno = false;
        String sql = "INSERT INTO produto ( id, nome, preco, fabricante) VALUES(?,?,?,?)";

        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, novoProduto.getIdProduto());
                stmt.setString(2, novoProduto.getNomeProduto());
                stmt.setDouble(3, novoProduto.getPrecoProduto());
                stmt.setString(4, novoProduto.getFabricanteProduto());

                stmt.executeUpdate();
                stmt.close();
            }
            retorno = true;
        } catch (Exception e) {
            throw new Exception("Erro ao inserir Produto");
        } finally {
            fechar();
        }
        return retorno;
    }

    public boolean atualizar(Produto atuaProduto) throws Exception {
        boolean retorno = false;
        String sql = "UPDATE produto SET nome = ? , preco = ?, fabricante = ? WHERE  id = ?";
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, atuaProduto.getNomeProduto());
                stmt.setDouble(2, atuaProduto.getPrecoProduto());
                stmt.setString(3, atuaProduto.getFabricanteProduto());
                stmt.setInt(4, atuaProduto.getIdProduto());

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
        for(Produto p : this.buscarTodos()){
            id = p.getIdProduto();
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
