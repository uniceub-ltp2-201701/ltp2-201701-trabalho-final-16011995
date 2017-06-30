package model;

public class Filme {
	private int idFilme;
	private String titulo;
	private String tituloIngles;
	private int ano;
	private String genero;
	private double pontuacao;
	
	public Filme(){
	}
	
	public Filme(int idFilme, String titulo, String tituloIngles, int ano, String genero,
			double pontuacao) {
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.tituloIngles = tituloIngles;
		this.ano = ano;
		this.genero = genero;
		this.pontuacao = pontuacao;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTituloIngles() {
		return tituloIngles;
	}

	public void setTituloIngles(String tituloIngles) {
		this.tituloIngles = tituloIngles;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPontuacao() { //OPCIONAL
		if (pontuacao >=0 & pontuacao <=10) {
			return pontuacao + " " + "estrelas";
		} else { 
			return "pontuacao nao registrada";
		}
	}
	

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
