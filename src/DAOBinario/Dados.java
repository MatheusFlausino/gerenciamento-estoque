/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOBinario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author matheusflausino
 */
public class Dados {
    
    
    public static ObjectOutputStream escritorBinario(String arq, boolean append) {
        File dataDir = new File("src" + File.separator + "bd");
        File arquivo = new File(dataDir, arq);
        ObjectOutputStream out = null;

        try {
            FileOutputStream fos = new FileOutputStream(arquivo, append);
            out = new ObjectOutputStream(fos);
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }

    public static ObjectInputStream leitorBinario(String arq) {
        File dataDir = new File("src" + File.separator + "bd");
        File arquivo = new File(dataDir, arq);
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            ois = new ObjectInputStream(fis);
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo. " + erro);
        }
        return ois;
    }

    public static void escreveObjeto(ObjectOutputStream oos, Object obj) {
        try {
            oos.writeObject(obj);
        } catch (IOException erro) {
            System.out.println("Erro na escrita. " + erro);
        }
    }

    public static Object leObjeto(ObjectInputStream ois) {
        Object objlido = null;
        try {
            objlido = ois.readObject();
        } catch (ClassNotFoundException erro) {
            System.out.println("Classe nao encontrada. " + erro);
        } catch (java.io.EOFException erro) {
            System.out.println("Final de arquivo. " + erro);
        } catch (IOException erro) {
            System.out.println("Erro na leitura do objeto. " + erro);
        } finally {
            return objlido;
        }
    }
}
