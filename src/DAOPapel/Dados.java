/*
 * Classe de Conexao com os Dados
 */
package DAOPapel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Pedro e Matheus
 */
public class Dados {
    
    public static BufferedReader lerBanco(String arquivo) throws IOException{
        File dataDir = new File("src" + File.separator + "bd");
        File f = new File(dataDir, arquivo);
        FileReader reader = new FileReader(f);
        BufferedReader bReader = new BufferedReader(reader);
        return bReader;
    }
    
    public static FileWriter gravarBanco(String arquivo)throws IOException{
        File dataDir = new File("src" + File.separator + "bd");
        File f = new File(dataDir, arquivo);
        FileWriter escritor = new FileWriter(f, false);
        return escritor;
    }
}
