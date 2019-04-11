package jogodaforca;
import java.util.Scanner;
public class JogoDaForca {
    private String[] palavras = new String[20];
    private int qtd =0;
    
    public void setPalavra(String a){
        this.palavras[qtd] = a;
        this.qtd++;
    }
    public String getPalavra(int qtd){
        return this.palavras[qtd];
    }
    public static void main(String[] args) {
        
        JogoDaForca teste = new JogoDaForca();
        teste.setPalavra("universidade");
        teste.setPalavra("computador");
        teste.setPalavra("arvore");
        teste.setPalavra("porta");
        teste.setPalavra("livro");
        teste.setPalavra("monitor");
        teste.setPalavra("futebol");
        teste.setPalavra("professor");
        teste.setPalavra("aluno");
        teste.setPalavra("objeto");
        teste.setPalavra("brinquedo");
        teste.setPalavra("jogo");
        teste.setPalavra("porto");
        teste.setPalavra("aeronave");
        teste.setPalavra("navio");
        teste.setPalavra("livre");
        teste.setPalavra("mercado");
        teste.setPalavra("imposto");
        teste.setPalavra("roubo");
        
        int i;
        int nmrSort = (int) ((Math.random()*20)-1);
        String palavraSort = teste.getPalavra(nmrSort);
        int length = palavraSort.length();
        char[] palavraSortChar = palavraSort.toCharArray();
        String[] palavraSortConv = new String[length];
        for(i=0;i<length;i++){
            palavraSortConv[i] = String.valueOf(palavraSortChar[i]);
        }
        String[] incognitas = new String[length];
        for(i=0;i<length;i++){
            incognitas[i] = "_";
            System.out.printf(incognitas[i]+" ");
        }
        System.out.println("");
        Scanner scanf = new Scanner(System.in);
        String[] letrasEsc = new String[26];
        char letraIns;
        int acertos=0, erros=0, rep=1, jogou=0, num=1;
        for(i=0;i<26;i++){
            letrasEsc[i] = " ";
        }
        
        while(acertos < length && erros < ((length/2) +1)){
            rep=1;
            jogou=0;
            System.out.println("==========================================");
            System.out.println("              Rodada " + num + "                  ");
            System.out.println("Letras ja usadas: ");
            for(i=0;i<26;i++){
                System.out.print(letrasEsc[i]+" ");
            }
            System.out.println("");
            System.out.println("Digite uma letra: ");
            letraIns = scanf.next().charAt(0);
            String strConvert = String.valueOf(letraIns);
            for(i=0;i<26;i++){
                if(letrasEsc[i].equals(strConvert)){
                    System.out.println("Letra já inserida anteriormente, ");
                    System.out.print("tente outra.");
                    rep=0;
                }
            }
            for(i=0;i<length;i++){
                if(rep == 1 && strConvert.equals(palavraSortConv[i])){
                    incognitas[i] = strConvert;
                    acertos++;
                    jogou=1;
                }
            }
            if(rep == 1 && jogou == 0){
                    erros++;
                }
            for(i=0;i<26;i++){
               if(rep == 1 && " ".equals(letrasEsc[i])){
                    letrasEsc[i] = strConvert;
                    rep = 0;
                }
            }
            System.out.println("");
            for(i=0;i<length;i++){
                System.out.print(incognitas[i] + " ");
            }
            System.out.println("");
            System.out.println("Limite de Erros: "+((length/2)+1));
            System.out.println("Erros: "+erros);
            num++;
        }
        if(acertos == length){
            System.out.println("=======================================");
            System.out.println("|              PARABÉNS               |");
            System.out.println("=======================================");
            System.out.println("A palavra era: "+palavraSort);
            System.out.println("Total de erros: "+erros);
            System.out.println("Total de tentativas: "+num);
        }
        if(erros == ((length/2) +1)){
            System.out.println("=======================================");
            System.out.println("|            GAME OVER                |");
            System.out.println("=======================================");
            System.out.println("A palavra era: "+palavraSort);
            System.out.println("Total de erros: "+erros);
            System.out.println("Total de tentativas: "+num);
        }
        System.out.println("Me da 10 professor, nunca te pedi nada <3");
    }
}