/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOPapel;

import Classes.Estoque;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Flausino
 * 
 */
public class DAOEstoque {

    private ArrayList<Estoque> db = new ArrayList(){};
    private static final String ARQUIVO = "dbestoque.txt";
    
    public DAOEstoque(){
        try {
            this.leitura();
        } catch (Exception ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Estoque buscar(int id) {
        Estoque item = null;
        int idList = 0;
        for(Iterator<Estoque> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            if (item.getIdEstoque()== id)
                break;
        }
        
        idList = db.indexOf(item);
        return db.get(idList);
    }
    
    public boolean atualizar(Estoque estoque){
        int id = db.indexOf(estoque);
        if(id == -1){
            return false;
        }else{
            db.set(id, estoque);
            return true;
        }
    }
    
    public boolean remover(Estoque estoque){
        return db.remove(estoque);
    }
    
    public boolean inserir(Estoque estoque){
        return db.add(estoque);
    }
    
    public int ultimoCodigo(){
        if(db.isEmpty())
            return 0;
        Estoque e = this.db.get(this.db.size()-1);
        return e.getIdEstoque()+1;
    }
    
    public void leitura() throws Exception {
        BufferedReader bReader = Dados.lerBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        while(bReader.ready()){
            String linha = bReader.readLine();
            Estoque item = new Estoque();
            String[] line = linha.split("\\t");

            item.setIdEstoque((int) Integer.parseInt(line[0]));
            item.setIdFornecedor((int) Integer.parseInt(line[1]));
            item.setIdProduto((int) Integer.parseInt(line[2]));
            item.setQtdEstoque((int) Integer.parseInt(line[3]));

            this.db.add(item);
        }
        bReader.close();
    }
    
    public void gravaResultado()throws IOException{
        FileWriter escritor = Dados.gravarBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try(BufferedWriter escritorbuff = new BufferedWriter(escritor)){
            Estoque item;
            String linha;
            for(Iterator<Estoque> i = db.iterator(); i.hasNext(); ) {
                item = i.next();

                linha = item.getIdEstoque()+"\t";
                linha +=(item.getIdFornecedor()+"\t");
                linha +=(item.getIdProduto()+"\t");
                linha +=(item.getQtdEstoque()+"\n");

                escritorbuff.write(linha);
            }
            escritorbuff.flush();
            escritorbuff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
