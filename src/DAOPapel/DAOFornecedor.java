/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOPapel;

import Classes.Fornecedor;
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
 */
public class DAOFornecedor {

    private ArrayList<Fornecedor> db = new ArrayList(){};
    private static final String ARQUIVO = "dbfornecedor.txt";
    
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
    
    public void leitura() throws Exception {
        BufferedReader bReader = Dados.lerBanco(ARQUIVO);
        while(bReader.ready()){
            String linha = bReader.readLine();
            Fornecedor item = new Fornecedor();
            String[] line = linha.split("\\t");

            item.setIdFornecedor((int) Integer.parseInt(line[0]));
            item.setNomeFornecedor(line[1]);
            item.setCnpjFornecedor(line[2]);
            item.setTelefoneFornecedor(line[3]);
            item.setLogradouroFornecedor(line[4]);
            item.setNumeroFornecedor((int) Integer.parseInt(line[5]));
            item.setBairroFornecedor(line[6]);
            item.setCidadeFornecedor(line[7]);
            item.setEstadoFornecedor(line[8]);
            item.setCepFornecedor(line[9]);
            item.setComplementoFornecedor(line[10]);

            this.db.add(item);
        }
        bReader.close();
    }
    
    public void gravaResultado()throws Exception{
        FileWriter escritor = Dados.gravarBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try(BufferedWriter escritorbuff = new BufferedWriter(escritor)){
            Fornecedor item;
            String linha;
            for(Iterator<Fornecedor> i = db.iterator(); i.hasNext(); ) {
                item = i.next();

                linha = item.getIdFornecedor()+"\t";
                linha +=(item.getNomeFornecedor()+"\t");
                linha +=(item.getCnpjFornecedor()+"\t");
                linha +=(item.getTelefoneFornecedor()+"\t");
                linha +=(item.getLogradouroFornecedor()+"\t");
                linha +=(item.getNumeroFornecedor()+"\t");
                linha +=(item.getBairroFornecedor()+"\t");
                linha +=(item.getCidadeFornecedor()+"\t");
                linha +=(item.getEstadoFornecedor()+"\t");
                linha +=(item.getCepFornecedor()+"\t");
                linha +=(item.getComplementoFornecedor()+"\n");


                escritorbuff.write(linha);
            }
            escritorbuff.flush();
            escritorbuff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
