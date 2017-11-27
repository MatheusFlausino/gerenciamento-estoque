/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOBinario;

import Classes.Produto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private static final String ARQUIVO = "dbproduto.obj";
    
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
    
    public final void leitura() throws Exception{
        ObjectInputStream leitor = Dados.leitorBinario(ARQUIVO);
        Produto item;
        while((item = (Produto) Dados.leObjeto(leitor)) != null){
            this.db.add(item);      
        }
        leitor.close();
    }
    
    public void gravaResultado()throws Exception{
        ObjectOutputStream escritor = Dados.escritorBinario(ARQUIVO, false);
        Produto item;
        for(Iterator<Produto> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            Dados.escreveObjeto(escritor, item);
        }
        escritor.flush();
        escritor.close();
    }
}
