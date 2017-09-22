/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOPapel;

import Classes.ItemVenda;
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
public class DAOItemVenda {

    private ArrayList<ItemVenda> db = new ArrayList(){};
    private static final String ARQUIVO = "dbitemvendatxt";
    
    public DAOItemVenda(){
        try {
            this.leitura();
        } catch (Exception ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ItemVenda buscar(int id) {
        ItemVenda item = null;
        int idList = 0;
        for(Iterator<ItemVenda> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            if (item.getIdProduto()== id)
                break;
        }
        
        idList = db.indexOf(item);
        return db.get(idList);
    }
    
    public boolean atualizar(ItemVenda item){
        int id = db.indexOf(item);
        if(id == -1){
            return false;
        }else{
            db.set(id, item);
            return true;
        }
    }
    
    public boolean remover(ItemVenda item){
        return db.remove(item);
    }
    
    public boolean inserir(ItemVenda item){
        return db.add(item);
    }
    
    public int ultimoCodigo(){
        if(db.isEmpty())
            return 0;
        ItemVenda e = this.db.get(this.db.size()-1);
        return e.getIdProduto()+1;
    }
    
    public void leitura() throws Exception {
        BufferedReader bReader = Dados.lerBanco(ARQUIVO);

        while(bReader.ready()){
            String linha = bReader.readLine();
            ItemVenda item = new ItemVenda();
            String[] line = linha.split("\\t");

            item.setIdProduto((int) Integer.parseInt(line[0]));
            item.setIdVenda(line[1]);
            item.setNomeProduto(line[2]);
            item.setPrecoProduto(Float.parseFloat(line[3]));
            item.setQtdProduto((int) Integer.parseInt(line[4]));

            this.db.add(item);
        }
        bReader.close();
    }
    
    public void gravaResultado()throws IOException{
        FileWriter escritor = Dados.gravarBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try(BufferedWriter escritorbuff = new BufferedWriter(escritor)){
            ItemVenda item;
            String linha;
            for(Iterator<ItemVenda> i = db.iterator(); i.hasNext(); ) {
                item = i.next();

                linha = item.getIdProduto()+"\t";
                linha +=(item.getIdVenda()+"\t");
                linha +=(item.getNomeProduto()+"\t");
                linha +=(item.getPrecoProduto()+"\t");
                linha +=(item.getQtdProduto()+"\n");


                escritorbuff.write(linha);
            }
            escritorbuff.flush();
            escritorbuff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
