package dao;

//OBS: EU UTILIZO CADA UM DESSES TIPOS DE COMENTARIOS AQUI PARA DIFERENCIAR O QUE REALMENTE IMPORTA E O QUE EH APENAS COMPLEMENTO NOS MEUS PROGRAMAS JAVA!      

//= PROGRAMACAO OBRIGATORIA PARA FUNCIONAR A PROVA1!
/*  = NECESSARIO CASO QUEIRA RETORNAR OS DADOS DE MANEIRA MAIS ORGANIZADA. BOM LEMBRAR QUE OS QUE ESTIVEREM COMENTADOS DESSA MANEIRA, NECESSITAM ESTAR ATIVOS PARA QUE ESSE PROGRAMA RODE */
/** = DESNECESSARIO = IMPLEMENTACAO OPCIONAL, APENAS POR ORGANIZACAO */
//_________________________________________________________________________________________________________________________________________________________________*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Diretor;
import model.Filme;

public class DetalhaObjetosFilmeDAO {
	private Connection conexao;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/
	
	public DetalhaObjetosFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public Filme getFilme(String idFilme) {
		Filme f = new Filme();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("SELECT idfilme, titulo, titulo_ingles, ano, genero, pontuacao FROM filme WHERE idfilme=?");
			ps.setString(1, idFilme);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				f.setIdFilme(rs.getInt("idfilme"));
				f.setTitulo(rs.getString("titulo"));
				f.setTituloIngles(rs.getString("titulo_ingles"));
				f.setAno(rs.getInt("ano"));
				f.setGenero(rs.getString("genero"));
				f.setPontuacao(rs.getDouble("pontuacao"));
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------/

	public ArrayList<Ator> getAtoresFilme(String idFilme){
		ArrayList<Ator> atoresFilme = new ArrayList<Ator>();
		PreparedStatement ps = null;
		ResultSet rs = null;		

			try {
				ps = conexao.prepareStatement("SELECT idator, idfilme, ator, papel, descricao FROM ator WHERE idfilme=?");				
				ps.setString(1, idFilme);
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					atoresFilme.add(new Ator(
					rs.getInt("idator"),
					rs.getInt("idfilme"),
					rs.getString("ator"),
					rs.getString("papel"),
					rs.getString("descricao")));
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return atoresFilme;
		}

//-------------------------------------------------------------------------------------------------------------------------------------------/

	public ArrayList<Diretor> getDiretoresFilme(String idFilme){
		ArrayList<Diretor> diretoresFilme = new ArrayList<Diretor>();
		PreparedStatement ps = null;
		ResultSet rs = null;		

			try {
				ps = conexao.prepareStatement("SELECT iddiretor, idfilme, diretor, descricao FROM diretor WHERE idfilme=?");				
				ps.setString(1, idFilme);
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					diretoresFilme.add(new Diretor(
					rs.getInt("iddiretor"),
					rs.getInt("idfilme"),
					rs.getString("diretor"),
					rs.getString("descricao")));
				}
				
				rs.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return diretoresFilme;
		}
}
