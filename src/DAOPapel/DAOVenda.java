/*
 * Classes para troca de dados e conexão com banco de dados ( Cliente )
 */
package DAOPapel;

import Classes.Venda;
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
public class DAOVenda {

    private ArrayList<Venda> db = new ArrayList(){};
    private static final String ARQUIVO = "dbvenda.txt";
    
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
    
    public void leitura() throws Exception {
        BufferedReader bReader = Dados.lerBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        while(bReader.ready()){
            String linha = bReader.readLine();
            Venda item = new Venda();
            String[] line = linha.split("\\t");

            item.setIdVenda(line[0]);
            item.setIdCliente((int) Integer.parseInt(line[0]));
            item.setTipoPagVenda(line[1]);
            item.setDataVenda((Date)formatter.parse(line[2]));
            item.setDescontoVenda(Float.parseFloat(line[3]));
            item.setTotalVenda(Float.parseFloat(line[4]));
            this.db.add(item);
        }
        bReader.close();

    }
    
    public void gravaResultado()throws IOException{
        FileWriter escritor = Dados.gravarBanco(ARQUIVO);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try(BufferedWriter escritorbuff = new BufferedWriter(escritor)){
            Venda item;
            String linha;
            for(Iterator<Venda> i = db.iterator(); i.hasNext(); ) {
                item = i.next();

                linha = item.getIdVenda()+"\t";
                linha +=(item.getIdCliente()+"\t");
                linha +=(item.getTipoPagVenda()+"\t");
                linha +=(formatter.format(item.getDataVenda())+"\t");
                linha +=(item.getDescontoVenda()+"\t");
                linha +=(item.getTotalVenda()+"\n");

                escritorbuff.write(linha);
            }
            escritorbuff.flush();
            escritorbuff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
