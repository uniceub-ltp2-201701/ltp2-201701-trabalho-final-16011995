package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminModificaObjetoDAO {
	private Connection conexao;
	
	public AdminModificaObjetoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	//-------------------------------------------------------------------------------------------------------------------------------------------/
	public boolean incluiDiretor(String idFilme, String diretor, String descricaoDiretor){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			ps = conexao.prepareStatement("INSERT INTO diretor (idfilme, diretor, descricao) VALUES(?,?,?)");
			ps.setInt(1, Integer.parseInt(idFilme));
			ps.setString(2, diretor);
			ps.setString(3, descricaoDiretor);
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}	

	//-------------------------------------------------------------------------------------------------------------------------------------------/
	public boolean incluiAtor(String idFilme, String ator, String papel, String descricaoAtor){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			ps = conexao.prepareStatement("INSERT INTO ator (idfilme, ator, papel, descricao) VALUES(?,?,?,?)");
			ps.setInt(1, Integer.parseInt(idFilme));
			ps.setString(2, ator);
			ps.setString(3, papel);
			ps.setString(4, descricaoAtor);
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}	
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	public boolean incluiFilme(String titulo, String tituloIngles, String ano, String genero, String pontuacao) {
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			ps = conexao.prepareStatement("INSERT INTO filme (titulo, titulo_ingles, ano, genero, pontuacao) VALUES(?,?,?,?,?)");
			ps.setString(1, titulo);
			ps.setString(2, tituloIngles);
			ps.setInt(3, Integer.parseInt(ano));
			ps.setString(4, genero);
			ps.setDouble(5, Double.parseDouble(pontuacao));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	public boolean excluiDiretor(String idDiretor){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			ps = conexao.prepareStatement("DELETE FROM diretor WHERE iddiretor=?");
			ps.setInt(1, Integer.parseInt(idDiretor));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	public boolean excluiAtor(String idAtor){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			ps = conexao.prepareStatement("DELETE FROM ator WHERE idator=?");
			ps.setInt(1, Integer.parseInt(idAtor));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	public boolean excluiFilme(String idFilme){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			ps = conexao.prepareStatement("DELETE FROM filme WHERE idfilme=?");
			ps.setInt(1, Integer.parseInt(idFilme));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
}
