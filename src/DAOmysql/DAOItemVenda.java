package DAOmysql;

import Classes.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author matheusflausino
 */
/*
    private int IdProduto;
    private int IdVenda;
    private double PrecoProduto;
    private String nomeProduto;
*/
public class DAOItemVenda {
    
    private Connection con = null;
    private static final String NOME = "root",
            SENHA = "";

    public void apagar(String id) throws Exception {
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("DELETE FROM itemvenda WHERE idVenda = ?")) {
                stmt.setString(1, id);
                stmt.executeUpdate();
                stmt.close();
            }
        } catch (Exception e) {
            throw new Exception("Erro ao apagar Venda");
        } finally {
            fechar();
        }
    }

    public ArrayList<ItemVenda> buscarTodos() throws Exception {
        ArrayList<ItemVenda> resultados = new ArrayList<>();
        try {
            conectar();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM itemvenda");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ItemVenda temp = new ItemVenda();
                // pega todos os atributos do Venda
                temp.setIdVenda(rs.getString("idVenda"));
                temp.setIdProduto(rs.getInt("idProduto"));
                temp.setPrecoProduto(rs.getDouble("precoProduto"));
                temp.setNomeProduto(rs.getString("nomeProduto"));
                temp.setQtdProduto(rs.getInt("qtdProduto"));

                resultados.add(temp);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar Venda 1");
        }
        return resultados;
    }

    public ItemVenda buscar(String id) throws Exception {
        ItemVenda resultados = null;
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM itemvenda WHERE idVenda LIKE ? LIMIT 1")) {
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    ItemVenda temp = new ItemVenda();
                    // pega todos os atributos do Venda
                    temp.setIdVenda(rs.getString("idVenda"));
                    temp.setIdProduto(rs.getInt("idProduto"));
                    temp.setPrecoProduto(rs.getDouble("precoProduto"));
                    temp.setNomeProduto(rs.getString("nomeProduto"));
                    temp.setQtdProduto(rs.getInt("qtdProduto"));
                    
                    resultados = temp;
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar Venda");
        }
        return resultados;
    }

    public boolean insere(ItemVenda novoItemVenda) throws Exception {
        boolean retorno = false;
        String sql = "INSERT INTO itemvenda(idProduto,precoProduto,nomeProduto,idVenda,qtdProduto)" + 
                "VALUES(?,?,?,?,?)";

        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, novoItemVenda.getIdProduto());
                stmt.setDouble(2, novoItemVenda.getPrecoProduto());
                stmt.setString(3, novoItemVenda.getNomeProduto());
                stmt.setString(4, novoItemVenda.getIdVenda());
                stmt.setInt(5, novoItemVenda.getQtdProduto());
                
                stmt.executeUpdate();
                stmt.close();
            }
            retorno = true;
        } catch (Exception e) {
            throw new Exception("Erro ao inserir Venda");
        } finally {
            fechar();
        }
        return retorno;
    }

    public boolean atualizar(ItemVenda novoItemVenda) throws Exception {
        boolean retorno = false;
        String sql = "UPDATE itemvenda SET idProduto = ?, precoProduto = ?, nomeProduto = ?, qtdProduto = ?"
                + " WHERE  idVenda = ?";
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, novoItemVenda.getIdProduto());
                stmt.setDouble(2, novoItemVenda.getPrecoProduto());
                stmt.setString(3, novoItemVenda.getNomeProduto());
                stmt.setInt(4, novoItemVenda.getQtdProduto());
                stmt.setString(5, novoItemVenda.getIdVenda());
                
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
