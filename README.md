# GERENCIAMENTO DE ESTOQUE

Projeto criado para a disciplina de Programação Desktop da Universidade Tecnológica Federal do Paraná, Câmpus Cornélio Procópio.
O desenvolvimento do projeto tem como o objetivo o estudo da linguagem de programação Java e o estudo de 3(três) diferentes formas de armazenamento.
- [X] [Armazenamento em arquivos](#armazenamento-em-arquivo)
- [X] [Armazenamento em arquivos binários](#armazenamento-em-arquivos-binários)
- [ ] [Armazenamento em banco de dados (SQL)](#armazenamento-em-banco-de-dados-sql)

## Armazenamento em arquivo
* ***import java.io.****

Oferece um conjunto de classes para se trabalhar com arquivos, diretórios e seus dados. Também oferece recursos para manipulação de dados durante o processo de leitura e gravação.

* ***Classe File***

A sua função está relacionada com o caminho / diretório / endereço dos arquivos ou diretório que desejarmos manipular, não faz a manipulção do conteudo de arquivos.
Contém métodos para testar a existência de arquivos, apagar arquivos, criar diretórios, listar o conteúdo de diretórios,etc...


* ***Classes de Reader e Write***

A maneira mais eficiente de ler um arquivo texto é usar o **FileReader** juntamente com um **BufferedReader**.
Para gravar, use o **FileWriter** juntamente com um **BufferedWriter**.

Exemplo de abertura, escrita e leitura de um arquivo:
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
  
## Armazenamento em arquivos binários

* ***InputStream***

Essa classe nos permite fazer a leitura de um fluxo de dados (Stream) em bytes, um byte por vez.
Ela é uma classe abstrata, que é implementada por outras classes como **FileInputStream**, **BufferedInputStream**, **DataInputStream** e etc.

O método *read()* retorna um valor inteiro que contém o byte que foi lido, enquanto for diferente de -1 a leitura ainda não acabou.
Para transformar um determinado byte em algum tipo de dado, podemos utilizar o Cast assim garantimos a conversão dos dados.

O **FileInputStream** permite a leitura de um arquivo porem ele só retorna um byte de cada vez, então foi implementada a classe **BufferedInputStream** que lê um bloco inteiro de bytes, com isso gera menos requisições ao SO com isso ganhando mais velocidade.

Com a classe **InputStream** podemos utilizar os métodos *read(byte[])* ou *read(byte[], int offset, int length)*, em ambos são passados como parâmetro uma variavel de um determinado tipo, no primeiro método a quantidade de bytes que ele irá retornar é de acordo com as bytes da variavel passada, já o segundo método você insere o começo (*offset*) e o tamanho a a quantidade (*length*) de bytes que será retornado.

Exemplo de abertura e leitura de um arquivo:

```java
  InputStream istream;
  try {
    istream = new BufferedInputStream( new FileInputStream("ArquivoCriado.obj") );
    byte[] data = new byte[5];
    istream.read(data);
    for(int i =0; i < 5 ; i++){
      System.out.println((char) data[i]);
    }

    istream.close();
    
  } catch (FileNotFoundException ex) {
    ex.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  }
```

* ***OutputStream***

Essa é a classe de escrita, capaz de enviar dados a um determinado Stream. Também é uma classe abstrata que é implementada por algumas classes: **BufferedOutputStream**, **FileOutputStream** e etc.
Ela utiliza o método *write(byte)* para a escrita dos arquivos passando por ele 1 byte a cada escreta. Assim como no **InputStream** no **OutputStream** tempos também o *write(bytes[])* e o *write(byte[], int offset, int length)* podendo agilizar o processo e enviar um array de bytes.

Para o **OutputStream** temos também os métodos *flush()* e *close()*.
O *flush()* libera o fluxo de saída e força qualquer bytes de saída em buffer para serem gravados, ou seja, se algum byte tiver sido armazenado em buffer, esse byte deve ser imediatamente gravados no destino pretendido, se o destino for um arquivo em disco o *flush()* só garante que  os bytes sejam enviados para o sistema operacional para escrita, não garante que eles realmente sejam escritos em um dispositivo físico, como uma unidade de disco.
O *close()* fecha o fluxo de dados que estão sendo gravados e libera todos os dados daquele fluxo, uma vez fechado o mesmo fluxo não pode ser reaberto e nem executar novas operações.

```java
  OutputStream output = null;
  try {
    output = new FileOutputStream("/tmp/input_text");
    byte[] bytes = new byte[] {'A','B', 'D', 'E'};
    int count = bytes.length;

    while (count >= 0) {
           output.write(bytes);
           count--;
    }

  }finally{                 
    if (output != null){
      output.close();
    }
  }
```

## Armazenamento em banco de dados (SQL) 

Em desenvolvimento

## Referências

[Class InputStream; Oracle](https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html)

[Class OutputStream; Oracle](https://docs.oracle.com/javase/7/docs/api/java/io/OutputStream.html)

[Classe InputStream e Outputstream em Java; Devmedia](http://www.devmedia.com.br/classe-inputstream-e-outputstream-em-java/32007)


## Autores

FLAUSINO, Matheus // matheus.negocio [at] gmail.com

GATTO, Guilherme // guilherme.gatto.g [at] gmail.com
