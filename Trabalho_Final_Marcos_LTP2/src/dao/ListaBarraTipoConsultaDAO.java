package dao;


//---------/ = SEPARA OS MÉTODOS

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Diretor;
import model.Filme;

public class ListaBarraTipoConsultaDAO {
	private Connection conexao;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public ListaBarraTipoConsultaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public ArrayList<Filme> getListaFilmesPorTipoConsulta(String tipoConsulta, String dados) {
		if (dados == null || dados.trim().equals("") && tipoConsulta.trim().equals("FILMES") || dados == null || dados.trim().equals("") && !tipoConsulta.trim().equals("Todos os Filmes")) {
			ArrayList<Filme> filme = new ArrayList<Filme>();
			Filme f = new Filme();
			f.setIdFilme(0);
			filme.add(f);
			return filme;
			
		} else if (dados != null && tipoConsulta.trim().equals("FILMES")) {			
			ArrayList<Filme> filme = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT filme.idfilme, filme.titulo, filme.titulo_ingles" +
											 " FROM filme WHERE filme.titulo LIKE ? OR filme.titulo_ingles LIKE ? OR filme.ano LIKE ? OR filme.genero LIKE ? OR filme.pontuacao LIKE ? ORDER BY filme.titulo;");
				ps.setString(1, "%" + dados +  "%");
				ps.setString(2, "%" + dados +  "%");
				ps.setString(3, "%" + dados +  "%");
				ps.setString(4, "%" + dados +  "%");
				ps.setString(5, "%" + dados +  "%");

				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					
					filme.add(f);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filme;	
			
		} else if (tipoConsulta.equals("Todos os Filmes")) {
			ArrayList<Filme> filme = new ArrayList<Filme>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, pontuacao FROM filme ORDER BY titulo");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Filme f = new Filme();
					f.setIdFilme(rs.getInt("idfilme"));
					f.setTitulo(rs.getString("titulo"));
					f.setTituloIngles(rs.getString("titulo_ingles"));
					f.setAno(rs.getInt("ano"));
					f.setPontuacao(rs.getDouble("pontuacao"));
					
					filme.add(f);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return filme;
			
		} else { throw new IllegalArgumentException();
		   }
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	//-------------------------------------------------------------------------------------------------------------------------------------------/
		
	public ArrayList<Diretor> getListaDiretoresPorTipoConsulta(String tipoConsulta, String dados) {
		if (dados == null || dados.trim().equals("") && tipoConsulta.trim().equals("DIRETORES") || dados == null || dados.trim().equals("") && !tipoConsulta.trim().equals("Todos os Diretores")) {
			ArrayList<Diretor> diretor = new ArrayList<Diretor>();
			Diretor d = new Diretor();
			d.setIdDiretor(0);
			diretor.add(d);
			return diretor;
			
		} else if (dados != null && tipoConsulta.trim().equals("DIRETORES")) {			
			ArrayList<Diretor> diretores = new ArrayList<Diretor>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT diretor.idfilme, diretor.iddiretor, diretor.diretor, diretor.descricao " +
											  "FROM diretor WHERE diretor.diretor LIKE ? OR diretor.descricao LIKE ? ORDER BY diretor.diretor;");
				ps.setString(1, "%" + dados +  "%");
				ps.setString(2, "%" + dados +  "%");

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
			
		} else if (tipoConsulta.equals("Todos os Diretores")) {
			ArrayList<Diretor> todosDiretores = new ArrayList<Diretor>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT iddiretor, idfilme, diretor, descricao FROM diretor ORDER BY diretor");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Diretor df = new Diretor();
					df.setIdDiretor(rs.getInt("iddiretor"));
					df.setIdFilme(rs.getInt("idfilme"));
					df.setDiretorNome(rs.getString("diretor"));
					df.setDescricao(rs.getString("descricao"));
					
					todosDiretores.add(df);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return todosDiretores;
			
		} else { throw new IllegalArgumentException();
			   }
		}
		
		//-------------------------------------------------------------------------------------------------------------------------------------------/
		//-------------------------------------------------------------------------------------------------------------------------------------------/
		//-------------------------------------------------------------------------------------------------------------------------------------------/ 
		
	public ArrayList<Ator> getListaAtoresPorTipoConsulta(String tipoConsulta, String dados) {
		if (dados == null || dados.trim().equals("") && tipoConsulta.trim().equals("ATORES") || dados == null || dados.trim().equals("") && !tipoConsulta.trim().equals("Todos os Atores")) {
			ArrayList<Ator> ator = new ArrayList<Ator>();
			Ator a = new Ator();
			a.setIdAtor(0);
			ator.add(a);
			return ator;
			
		} else if (dados != null && tipoConsulta.trim().equals("ATORES")) {			
			ArrayList<Ator> atores = new ArrayList<Ator>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT ator.idfilme, ator.idator, ator.ator, ator.papel, ator.descricao " +
											  "FROM ator WHERE ator.ator LIKE ? OR ator.papel LIKE ? OR ator.descricao LIKE ? ORDER BY ator.ator;");
				ps.setString(1, "%" + dados +  "%");
				ps.setString(2, "%" + dados +  "%");
				ps.setString(3, "%" + dados +  "%");

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
			
		} else if (tipoConsulta.equals("Todos os Atores")) {
			ArrayList<Ator> todosAtores = new ArrayList<Ator>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = conexao.prepareStatement("SELECT idator, idfilme, ator, papel, descricao FROM ator ORDER BY ator");
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Ator af = new Ator();
					af.setIdAtor(rs.getInt("idator"));
					af.setIdFilme(rs.getInt("idfilme"));
					af.setAtorNome(rs.getString("ator"));
					af.setPapel(rs.getString("papel"));
					af.setDescricao(rs.getString("descricao"));
					
					todosAtores.add(af);
				}

				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return todosAtores;
	
		} else { throw new IllegalArgumentException();
 			   }
		}
}
