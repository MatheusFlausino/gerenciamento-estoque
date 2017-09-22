# GERENCIAMENTO DE ESTOQUE

Projeto criado para a disciplina de Programação Desktop da Universidade Tecnológica Federal do Paraná, Câmpus Cornélio Procópio.
O desenvolvimento do projeto tem como o objetivo o estudos de 3(três) dierentes formas de armazenamento.
* [Armazenamento em arquivos](#armazenamento-arquivo)
* [Armazenamento em arquivos binários](#armazenamento-binario)
* [Armazenamento em banco de dados (SQL)](#armazenamento-bd)

## <a name=armazenamento-arquivo></a> Armazenamento em arquivo
* **import java.io.***

Oferece um conjunto de classes para se trabalhar com arquivos, diretórios e seus dados. Também oferece recursos para manipulação de dados durante o processo de leitura e gravação.

* **Classe File**

A sua função está relacionada com o caminho / diretório / endereço dos arquivos ou diretório que desejarmos manipular, não faz a manipulção do conteudo de arquivos.
Contém métodos para testar a existência de arquivos, apagar arquivos, criar diretórios, listar o conteúdo de diretórios,etc...


* **Classes de Reader e Write**

A maneira mais eficiente de ler um arquivo texto é usar o *FileReader* juntamente com um *BufferedReader*.
Para gravar, use o *FileWriter* juntamente com um *BufferedWriter*.

Exemplo de abertura de arquivo, escrita e leitura em um arquivo:

```java
  File f = new File("ArquivoCriado.txt");
  //EFETUANDO A ESCRITA
  try {
    FileWriter fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);

    bw.write("Esse texto está sendo inserido");
    bw.newLine(); //INSERE UMA NOVA LINHA
    bw.write("Continua sendo inserido em uma nova linha");

    bw.flush();
    bw.close();
  } catch (IOException e) {
    e.printStackTrace();
  }

  //EFETUANDO A LEITURA
  try {
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String s;

    //ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
    while ((s = br.readLine()) != null) {
      System.out.println(s);
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
```
## <a name=armazenamento-binario></a>Armazenamento em arquivos binários

Em desenvolvimento


## <a name=armazenamento-bd></a> Armazenamento em banco de dados (SQL) 

Em desenvolvimento


## Autores
FLAUSINO, Matheus // matheus.negocio [at] gmail.com

GATTO, Guilherme // guilherme.gatto.g [at] gmail.com
