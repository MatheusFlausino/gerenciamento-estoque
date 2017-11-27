/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOBinario;

import Classes.Estoque;
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
public class DAOEstoque {

    private ArrayList<Estoque> db = new ArrayList(){};
    private static final String ARQUIVO = "dbestoque.obj";
    
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
        ObjectInputStream leitor = Dados.leitorBinario(ARQUIVO);
        Estoque item;
        while((item = (Estoque) Dados.leObjeto(leitor)) != null){
             
            this.db.add(item);
        }
        leitor.close();
    }
    
    public void gravaResultado()throws Exception{
        ObjectOutputStream escritor = Dados.escritorBinario(ARQUIVO, false);
        Estoque item;
        for(Iterator<Estoque> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            Dados.escreveObjeto(escritor, item);
        }
        escritor.flush();
        escritor.close();
    }
}
