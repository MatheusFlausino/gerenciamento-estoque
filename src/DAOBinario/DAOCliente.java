/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOBinario;

import Classes.Cliente;
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
public class DAOCliente {

    private ArrayList<Cliente> db = new ArrayList(){};
    private static final String ARQUIVO = "dbcliente.obj";
    
    public DAOCliente(){
        try {
            this.leitura();
        }catch (Exception ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente buscar(int id) {
        Cliente item = null;
        int idList = 0;
        for(Iterator<Cliente> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            if (item.getIdCliente() == id)
                break;
        }
        
        idList = db.indexOf(item);
        return db.get(idList);
    }
    
    public boolean atualizar(Cliente cliente){
        int id = db.indexOf(cliente);
        if(id == -1){
            return false;
        }else{
            db.set(id, cliente);
            return true;
        }
    }
    
    public boolean remover(Cliente cliente){
        return db.remove(cliente);
    }
    
    public boolean inserir(Cliente cliente){
        return db.add(cliente);
    }
    
    public int ultimoCodigo(){
        if(db.isEmpty())
            return 0;
            Cliente e = this.db.get(this.db.size()-1);
            return e.getIdCliente()+1;
    }
    
    public final void leitura() throws Exception{
        ObjectInputStream leitor = Dados.leitorBinario(ARQUIVO);
        Cliente item;
        while((item = (Cliente) Dados.leObjeto(leitor)) != null){
            this.db.add(item);      
        }
        leitor.close();
    }
    
    public void gravaResultado()throws Exception{
        ObjectOutputStream escritor = Dados.escritorBinario(ARQUIVO, false);
        Cliente item;
        for(Iterator<Cliente> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            Dados.escreveObjeto(escritor, item);
        }
        escritor.flush();
        escritor.close();
    }
}
