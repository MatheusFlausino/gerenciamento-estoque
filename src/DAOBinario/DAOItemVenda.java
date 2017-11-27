/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOBinario;

import Classes.ItemVenda;
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
public class DAOItemVenda {

    private ArrayList<ItemVenda> db = new ArrayList(){};
    private static final String ARQUIVO = "dbitemvenda.obj";
    
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
    
    public final void leitura() throws Exception{
        ObjectInputStream leitor = Dados.leitorBinario(ARQUIVO);
        ItemVenda item;
        while((item = (ItemVenda) Dados.leObjeto(leitor)) != null){
            this.db.add(item);      
        }
    }
    
    public void gravaResultado()throws Exception{
        ObjectOutputStream escritor = Dados.escritorBinario(ARQUIVO, false);
        ItemVenda item;
        for(Iterator<ItemVenda> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            Dados.escreveObjeto(escritor, item);
        }
        escritor.flush();
        escritor.close();
    }
}
