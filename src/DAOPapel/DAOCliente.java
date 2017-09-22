/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOPapel;

import Classes.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
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
public class DAOCliente {

    private ArrayList<Cliente> db = new ArrayList(){};
    private static final String ARQUIVO = "dbcliente.txt";
    
    public DAOCliente(){
        try {
            this.leitura();
        } catch (Exception ex) {
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
    
    public void leitura() throws Exception {
        BufferedReader bReader = Dados.lerBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        while(bReader.ready()){
            String linha = bReader.readLine();
            Cliente item = new Cliente();
            String[] line = linha.split("\\t");

            item.setIdCliente((int) Integer.parseInt(line[0]));
            item.setNomeCliente(line[1]);
            item.setCpfCliente(line[2]);
            item.setDataNascCliente((Date)formatter.parse(line[3]));
            item.setTelefoneCliente(line[4]);
            item.setLogradouroCliente(line[5]);
            item.setNumeroCliente((int) Integer.parseInt(line[6]));
            item.setBairroCliente(line[7]);
            item.setCidadeCliente(line[8]);
            item.setEstadoCliente(line[9]);
            item.setCepCliente(line[10]);
            item.setComplementoCliente(line[11]);

            this.db.add(item);
        }
        bReader.close();
    }
    
    public void gravaResultado()throws IOException{
        FileWriter escritor = Dados.gravarBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try(BufferedWriter escritorbuff = new BufferedWriter(escritor)){
            Cliente item;
            String linha;
            for(Iterator<Cliente> i = db.iterator(); i.hasNext(); ) {
                item = i.next();

                linha = item.getIdCliente()+"\t";
                linha +=(item.getNomeCliente()+"\t");
                linha +=(item.getCpfCliente()+"\t");
                linha +=(formatter.format(item.getDataNascCliente())+"\t");
                linha +=(item.getTelefoneCliente()+"\t");
                linha +=(item.getLogradouroCliente()+"\t");
                linha +=(item.getNumeroCliente()+"\t");
                linha +=(item.getBairroCliente()+"\t");
                linha +=(item.getCidadeCliente()+"\t");
                linha +=(item.getEstadoCliente()+"\t");
                linha +=(item.getCepCliente()+"\t");
                linha +=(item.getComplementoCliente()+"\n");


                escritorbuff.write(linha);
            }
            escritorbuff.flush();
            escritorbuff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
