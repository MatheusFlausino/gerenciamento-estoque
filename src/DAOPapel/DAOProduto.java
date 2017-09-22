/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOPapel;

import Classes.Produto;
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
public class DAOProduto {

    private ArrayList<Produto> db = new ArrayList(){};
    private static final String ARQUIVO = "dbproduto.txt";
    
    public DAOProduto(){
        try {
            this.leitura();
        } catch (Exception ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Produto buscar(int id) {
        Produto item = null;
        int idList = 0;
        for(Iterator<Produto> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            if (item.getIdProduto()== id)
                break;
        }
        
        idList = db.indexOf(item);
        return db.get(idList);
    }
    
    public boolean atualizar(Produto produto){
        int id = db.indexOf(produto);
        if(id == -1){
            return false;
        }else{
            db.set(id, produto);
            return true;
        }
    }
    
    public boolean remover(Produto produto){
        return db.remove(produto);
    }
    
    public boolean inserir(Produto produto){
        return db.add(produto);
    }
    
    public int ultimoCodigo(){
        if(db.isEmpty())
            return 0;
        Produto e = this.db.get(this.db.size()-1);
        return e.getIdProduto()+1;
    }
    
    public void leitura() throws Exception {
        BufferedReader bReader = Dados.lerBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        while(bReader.ready()){
            String linha = bReader.readLine();
            Produto item = new Produto();
            String[] line = linha.split("\\t");

            item.setIdProduto((int) Integer.parseInt(line[0]));
            item.setNomeProduto(line[1]);
            item.setPrecoProduto(Float.parseFloat(line[2]));
            item.setFabricanteProduto(line[3]);

            this.db.add(item);
        }
        bReader.close();
        
    }
    
    
    public void gravaResultado()throws IOException{
        FileWriter escritor = Dados.gravarBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try(BufferedWriter escritorbuff = new BufferedWriter(escritor)){
            Produto item;
            String linha;
            for(Iterator<Produto> i = db.iterator(); i.hasNext(); ) {
                item = i.next();

                linha = item.getIdProduto()+"\t";
                linha +=(item.getNomeProduto()+"\t");
                linha +=(item.getPrecoProduto()+"\t");
                linha +=(item.getFabricanteProduto()+"\n");

                escritorbuff.write(linha);
            }
            escritorbuff.flush();
            escritorbuff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
