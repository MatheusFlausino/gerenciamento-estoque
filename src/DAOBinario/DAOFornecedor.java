/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOBinario;

import Classes.Fornecedor;
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
 */
public class DAOFornecedor {

    private ArrayList<Fornecedor> db = new ArrayList(){};
    private static final String ARQUIVO = "dbfornecedor.obj";
    
    public DAOFornecedor(){
        try {
            this.leitura();
        } catch (Exception ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Fornecedor buscar(int id) {
        Fornecedor item = null;
        int idList = 0;
        for(Iterator<Fornecedor> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            if (item.getIdFornecedor() == id)
                break;
        }
        
        idList = db.indexOf(item);
        return db.get(idList);
    }
    
    public boolean atualizar(Fornecedor fornecedor){
        int id = db.indexOf(fornecedor);
        if(id == -1){
            return false;
        }else{
            db.set(id, fornecedor);
            return true;
        }
    }
    
    public boolean remover(Fornecedor fornecedor){
        return db.remove(fornecedor);
    }
    
    public boolean inserir(Fornecedor fornecedor){
        return db.add(fornecedor);
    }
    
    public int ultimoCodigo(){
        if(db.isEmpty())
            return 0;
        Fornecedor e = this.db.get(this.db.size()-1);
        return e.getIdFornecedor()+1;
    }
    
    public final void leitura() throws Exception{
        ObjectInputStream leitor = Dados.leitorBinario(ARQUIVO);
        Fornecedor item;
        while((item = (Fornecedor) Dados.leObjeto(leitor)) != null){
            this.db.add(item);      
        }
        leitor.close();
    }
    
    public void gravaResultado()throws Exception{
        ObjectOutputStream escritor = Dados.escritorBinario(ARQUIVO, false);
        Fornecedor item;
        for(Iterator<Fornecedor> i = db.iterator(); i.hasNext(); ) {
            item = i.next();
            Dados.escreveObjeto(escritor, item);
        }
        escritor.flush();
        escritor.close();
    }
}
