package DAOmysql;

import Classes.Venda;
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
public class DAOVenda {

    private Connection con = null;
    private static final String NOME = "root",
            SENHA = "";

    public void apagar(String id) throws Exception {
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("DELETE FROM venda WHERE idVenda = ?")) {
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

    public ArrayList<Venda> buscarTodos() throws Exception {
        ArrayList<Venda> resultados = new ArrayList<>();
        try {
            conectar();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM venda");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Venda temp = new Venda();
                // pega todos os atributos do Venda
                temp.setIdVenda(rs.getString("idVenda"));
                temp.setIdCliente(rs.getInt("idCliente"));
                temp.setTipoPagVenda(rs.getString("tipoPagamento"));
                temp.setTotalVenda(rs.getDouble("totalVenda"));
                temp.setDataVenda(new Date(rs.getDate("dataVenda").getTime()));
                temp.setDescontoVenda(rs.getDouble("descontoVenda"));

                resultados.add(temp);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar Venda 1");
        }
        return resultados;
    }

    public Venda buscar(String id) throws Exception {
        Venda resultados = null;
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM venda WHERE idVenda LIKE ? LIMIT 1")) {
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Venda temp = new Venda();
                    temp.setIdVenda(rs.getString("idVenda"));
                    temp.setIdCliente(rs.getInt("idCliente"));
                    temp.setTipoPagVenda(rs.getString("tipoPagamento"));
                    temp.setTotalVenda(rs.getDouble("totalVenda"));
                    temp.setDataVenda(new Date(rs.getDate("dataVenda").getTime()));
                    temp.setDescontoVenda(rs.getDouble("descontoVenda"));
                    resultados = temp;
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao buscar Venda");
        }
        return resultados;
    }

    public boolean insere(Venda novaVenda) throws Exception {
        boolean retorno = false;
        String sql = "INSERT INTO venda (idVenda, idCliente, dataVenda, tipoPagamento, descontoVenda, totalVenda)VALUES(?,?,?,?,?,?)";

        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, novaVenda.getIdVenda());
                stmt.setInt(2, novaVenda.getIdCliente());
                stmt.setString(3, novaVenda.getDataVenda().toString());
                stmt.setString(4, novaVenda.getTipoPagVenda());
                stmt.setDouble(5, novaVenda.getDescontoVenda());
                stmt.setDouble(6, novaVenda.getTotalVenda());
                
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

    public boolean atualizar(Venda novaVenda) throws Exception {
        boolean retorno = false;
        String sql = "UPDATE venda SET idCliente = ?, dataVenda = ?, tipoPagamento = ?,"
                + " descontoVenda = ?, totalVenda = ?  WHERE  idVenda = ?";
        try {
            conectar();
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, novaVenda.getIdCliente());
                stmt.setDate(2, (Date) novaVenda.getDataVenda());
                stmt.setString(3, novaVenda.getTipoPagVenda());
                stmt.setDouble(4, novaVenda.getDescontoVenda());
                stmt.setDouble(5, novaVenda.getTotalVenda());
                stmt.setString(6, novaVenda.getIdVenda());
                
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
