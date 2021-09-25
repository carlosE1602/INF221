/*
 * Classe usada para representar um time guardando seus dados e fazendo os calculos
 * necessários com eles
 */
public class Time{
	private int indice, feitos = 0, sofridos = 0, pontos = 0;
	
	public int getIndice() { return this.indice; }
	
	public int getFeitos() { return this.feitos; }
	
	public int getSofridos() { return this.sofridos; }
	
	public int getPontos() { return this.pontos; }
	
	public void addPontos(int pts) {this.pontos += pts;}
	
	public void addFeitos(int n) { this.feitos += n;}
	
	public void addSofridos(int n) { this.sofridos += n;}
	
	public void setIndice(int i) {this.indice += i;}
	
	//adiciona as cesta marcadas e sofrida e calcula a pontuação 2 pra vitoria 1 pra derrota
	//não tem empate
	public void partida(int feitos, int sofridos) {
		this.addFeitos(feitos);
		this.addSofridos(sofridos);
		
		if(feitos > sofridos) this.addPontos(2);
		else this.addPontos(1);
	}
	
	//calcula a cesta average feitos/sofridos, se sofridos for = 0 retorna apenas os feitos
	public double cestaAverage() { 
		if(getSofridos() == 0) return this.feitos;
		double feitos = getFeitos();
		return feitos/getSofridos(); 
	}
	
}
