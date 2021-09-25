import java.util.Comparator;

/*
 * Classe que sobrescreve a função compare da classe comparator, para se adequar as condições do problema 
 */
public class Sort implements Comparator<Time>{
	public int compare(Time A, Time B) {
		//testa se tem pontuação diferente
		if(A.getPontos() != B.getPontos()) {
			if(A.getPontos() < B.getPontos()) return 1;
			
			return -1;
		}
		
		//caso a pontuação seja igual, testa se o cestaAverage é diferente
		if(A.cestaAverage() != B.cestaAverage()) { 
			if(A.cestaAverage() < B.cestaAverage()) return 1;
			
			return -1;
		}

		//permanecendo o empate, testa quem fez mais gols
		if(A.getFeitos() != B.getFeitos()) {
			if(A.getFeitos() < B.getFeitos()) return 1;
			
			return -1;
		}
		
		//caso o empate se mantenha, testa e retorna o que tem menor indice
		if(A.getIndice() > B.getIndice()) return 1;
		
		return -1;
	}
}
