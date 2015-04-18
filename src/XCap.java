import java.util.Scanner;
import javax.swing.JOptionPane;


public class XCap {
	
	public static void main(String[] args) {
		
		String nome1 = "Rivan";
		String nome2 = "Apolo";
		
		Scanner entrada = new Scanner (System.in);
		String [] en = new String[9];
		int [] numeros = new int[5];
		
		int [][]  nRivan = {{21, 13, 02, 03, 23},{16, 12, 03, 8, 29}, {18,17, 05, 8, 21}, 
							{14, 12,  8, 10, 18 }, {21, 19, 17, 18, 29} };
		
		int [][]  nApolo = {{07, 06, 29, 8, 01},{14, 10, 22, 17, 02},{11, 07, 27, 13, 04},
							{20, 10, 27,  22, 06},{15, 13, 26, 17, 10}};
		
		en = JOptionPane.showInputDialog(null,"Insira o número","Resultado XCap",JOptionPane.PLAIN_MESSAGE).split(" ");
		
		for (int a = 0; a< en.length; a++ ){
			int v = Integer.parseInt(en[a]);
			numeros[a] = v;
		}
		
		for( int c: numeros){
			System.out.println(c);
		}
		
		
	// Aposta Rivan
		boolean retornoRivan = verificaPorOrdem(nRivan, numeros);
		int[] retorno2Rivan = verificaForaDeOrdem2(nRivan, numeros);
		
		
	// Aposta Apolo
		boolean retornoApolo = verificaPorOrdem(nApolo, numeros);
		int [] retorno2Apolo = verificaForaDeOrdem2(nApolo, numeros);
		
		JOptionPane.showMessageDialog(null,textoDeApresentação(nome1,nRivan,numeros,retornoRivan,retorno2Rivan)+"\n\n"+ textoDeApresentação(nome2,nApolo,numeros,retornoApolo,retorno2Apolo));

	}
	
	public static String textoDeApresentação(String nome, int [][] nPessoa ,int [] numerosSemanal, boolean r1, int[] r2){
		String txt2 = "";
		for( int c: numerosSemanal){
			txt2+= " "+ c + " ";
		}
		
		String txt = "Números da semana:\n"+ txt2;
		if(r1 == true){
			txt+="\nParabéns, "+nome+ " você ganhou o prêmio máximo semanal!\n";
		}else{
			txt+="\nNão foi dessa vez que "+ nome +" ganhou o prêmio máximo semanal\n";
		}
		txt+= "Seus números:";
		
		String df = "";
		for(int i =0; i < 5; i++){
			for( int h = 0; h< 5; h++){
				if(h==4){
					df+= nPessoa[i][h] + "\n";
				}else{
					df+= nPessoa[i][h] + " -" + " ";
				}
			}	
		}
		txt+= "\n"+ df;
		boolean flag = false;
		for( int w =0; w< 5; w++){
			if (r2[w]==5){
				flag = true;
			}
		}
		if(flag== true){
			txt+= "\nParabéns, "+nome+" ganhou o prêmio mínimo da semana!\n";
		}else{
			txt+= "\nNão foi dessa vez que "+nome+" ganhou o pêmio mínimo da semana\n";
		}
		
		txt+="Seus Acertos, "+nome+":\n";
		String fr = "";
		fr+="1a linha "+ r2[0]+ " Acerto(s)\n";
		fr+="2a linha "+ r2[1]+ " Acerto(s)\n";
		fr+="3a linha "+ r2[2]+ " Acerto(s)\n";
		fr+="4a linha "+ r2[3]+ " Acerto(s)\n";
		fr+="5a linha "+ r2[4]+ " Acerto(s)\n";
		txt+=fr;	
		
		return txt;
	}
	
	public static boolean verificaPorOrdem(int [][] aposta ,int [] numeros){
		for(int a=0; a < 5; a++){
			if(aposta[a][0]==numeros[0] && aposta[a][1]== numeros[1] &&
					aposta[a][2]==numeros[2] && aposta[a][3] == numeros[3]&&
					aposta[a][4]== numeros[4]){
				return true;
			}
		}
		return false;		
	}

	public static int[] verificaForaDeOrdem2(int [][] aposta ,int [] numeros){
		int[] contagem = new int[5];
		int cont =0;
		
		for (int b = 0; b< 5; b++){
			for( int c = 0; c < 5; c++){
				if(aposta[b][c]==numeros[b]){
					cont+=1;
				}
			}
			contagem[b]=cont;	
		}
		return contagem;
		}

}
