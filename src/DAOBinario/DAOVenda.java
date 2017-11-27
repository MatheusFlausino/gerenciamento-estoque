/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOBinario;

import Classes.Venda;
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
public class DAOVenda {

    private ArrayList<Venda> db = new ArrayList(){};
    private static final String ARQUIVO = "dbvenda.obj";
    
    public DAOVenda(){
        try {
            this.leitura();
        } catch (Exception ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Venda buscar(String id) {
        Venda item = null;
        int idList = 0;
        for(Iterator<Venda> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            if (item.getIdVenda().equals(id))
                break;
        }
        
        idList = db.indexOf(item);
        return db.get(idList);
    }
    
    public boolean atualizar(Venda venda){
        int id = db.indexOf(venda);
        if(id == -1){
            return false;
        }else{
            db.set(id, venda);
            return true;
        }
    }
    
    public boolean remover(Venda venda){
        return db.remove(venda);
    }
    
    public boolean inserir(Venda venda){
        return db.add(venda);
    }
    
    public final void leitura() throws Exception{
        ObjectInputStream leitor = Dados.leitorBinario(ARQUIVO);
        Venda item;
        while((item = (Venda) Dados.leObjeto(leitor)) != null){
            this.db.add(item);      
        }
        leitor.close();
    }
    
    public void gravaResultado()throws Exception{
        ObjectOutputStream escritor = Dados.escritorBinario(ARQUIVO, false);
        Venda item;
        for(Iterator<Venda> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            Dados.escreveObjeto(escritor, item);
        }
        escritor.flush();
        escritor.close();
    }
}
