package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Diretor;
import model.Filme;

public class DetalhaObjetoDAO {
	private Connection conexao;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public DetalhaObjetoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public Filme getObjetoFilme(String consultaFilme) {
		Filme filme = new Filme();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, genero, pontuacao FROM filme WHERE titulo = ?");
			ps.setString(1, consultaFilme);
			
			rs = ps.executeQuery();
			
				filme.setIdFilme(rs.getInt("idfilme"));
				filme.setTitulo(rs.getString("titulo"));
				filme.setTituloIngles(rs.getString("titulo_ingles"));
				filme.setAno(rs.getInt("ano"));
				filme.setGenero(rs.getString("genero"));
				filme.setPontuacao(rs.getDouble("pontuacao"));
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filme;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
		public ArrayList<Diretor> getBarraDiretor(String consultaFilme) {
			ArrayList<Diretor> diretores = new ArrayList<Diretor>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT iddiretor, idfilme, diretor, descricao FROM diretoresfilme ORDER BY iddiretor");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Diretor df = new Diretor();
					df.setIdDiretor(rs.getInt("iddiretor"));
					df.setIdFilme(rs.getInt("idfilme"));
					df.setDiretorNome(rs.getString("diretor"));
					df.setDescricao(rs.getString("descricao"));
					
					diretores.add(df);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return diretores;
		}
		
		//-------------------------------------------------------------------------------------------------------------------------------------------/
		
		public ArrayList<Ator> getBarraAtor(String consultaFilme) {
			ArrayList<Ator> atores = new ArrayList<Ator>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT idator, idfilme, ator, papel, descricao FROM ator ORDER BY idator");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Ator af = new Ator();
					af.setIdAtor(rs.getInt("idator"));
					af.setIdFilme(rs.getInt("idfilme"));
					af.setAtorNome(rs.getString("ator"));
					af.setPapel(rs.getString("papel"));
					af.setDescricao(rs.getString("descricao"));
					
					atores.add(af);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return atores;
		}
	
}
