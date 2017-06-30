<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme"%>
<%@ page import="model.Ator"%>
<%@ page import="model.Diretor"%>
<%@ page import='java.util.ArrayList'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FILME</title>
</head>
<body>
<%
Filme filme = (Filme) request.getAttribute("filme");

ArrayList<Diretor> diretoresFilme = (ArrayList<Diretor>) request.getAttribute("diretoresFilme");

ArrayList<Ator> atoresFilme = (ArrayList<Ator>) request.getAttribute("atoresFilme");

		if(filme.getIdFilme() == 0) {
   		out.println("</TABLE>" +
					"<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH><FONT size='7' color='#FFFFFF'>" +
					"É Nessesário a Inserção de Dados para a Pesquisa Ser Efetuada</FONT></TH>");
		}  else {
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println("<HTML><HEAD><TITLE>DETALHES FILME PT</TITLE>" + "<link href='css/bootstrap.min.css' rel='stylesheet'>" + "</HEAD>" +
						"<BODY>" +
    			        "<TABLE style='width:100%' bgcolor='#800000'><TR><TH bgcolor='#800000'></TH></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH style='width:100%' bgcolor='#333333'><FONT size='+1' color='#FFFFFF'>Filme "
    					+ "''" + filme.getTitulo() + "''" + "</FONT></TH>");
				
					
						//-------------------------------------------------------------------------------------------------------------------------------------------/
		    out.println("<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#FFCC00'><TR><TH bgcolor='#ffcc00'></TH></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
						
						"<TABLE bordercolor='#262626' border='1' style='width:100%' bgcolor='#333333'>" +
						"<TR>" +
						"<TH style='width:10%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "ID FILME" +    	"</FONT>" + "</TH>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "TITULO" +	    "</FONT>" + "</TH>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "TITULO INGLES" +	"</FONT>" + "</TH>" +
						"<TH style='width:08%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "ANO" + 		 	"</FONT>" + "</TH>" +
						"<TH style='width:22%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "Genero" +   	"</FONT>" + "</TH>" +
						"<TH style='width:30%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "PONTUACAO" + 	"</FONT>" + "</TH>" +
						"</TR>" +
					
						//-------------------------------------------------------------------------------------------------------------------------------------------/
						"<TR>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getIdFilme() +      "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getTitulo() + 	    "</FONT>" + "</TH>" + 
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getTituloIngles() + "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getAno() +          "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getGenero() +    "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getPontuacao() +    "</FONT>" + "</TH>" +
						"</TR>" +
						"</TABLE>");
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println("<TABLE style='width:100%' bgcolor='#FFCC00'><TR><TH bgcolor='#ffcc00'></TH></TR></TABLE>" +
			        	"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
						
						"<TABLE bordercolor='#262626' border='1' style='width:100%' bgcolor='#333333'>" +
						"<TR>" +
						"<TH style='width:10%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "ID ATOR" + 	"</FONT>" + "</TH>" +			
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "ATORES" +  	"</FONT>" + "</TH>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "PAPEL" +   	"</FONT>" + "</TH>" +
						"<TH style='width:60%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "DESCRICAO" + "</FONT>" + "</TH>" +
						"</TR>");
	
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			for (int i = 0; i < atoresFilme.size(); i++) {
			out.println("<TR>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getIdAtor() +    "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getAtorNome() +      "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getPapel() + 	  "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getDescricao() + "</FONT>" + "</TH>" +
						"</TR>");
				}
			out.println("</TABLE>");
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println("<TABLE style='width:100%' bgcolor='#FFCC00'><TR><TH bgcolor='#ffcc00'></TH></TR></TABLE>" +
			        	"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
					
						"<TABLE bordercolor='#262626' border='1' style='width:100%' bgcolor='#333333'>" +
						"<TR>" +
						"<TH style='width:10%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "ID DIRETOR" + "</FONT>" + "</TH>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "DIRETORES" +  "</FONT>" + "</TH>" +
						"<TH style='width:75%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "DESCRICAO" +  "</FONT>" + "</TH>" +
						"</TR>");
	
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			for (int i = 0; i < diretoresFilme.size(); i++) {
			out.println("<TR>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getIdDiretor() + "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getDiretorNome() +   "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getDescricao() + "</FONT>" + "</TH>" +
						"</TR>");

				}
			out.println("</TABLE>");
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println("<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
	    			    "<TABLE style='width:100%' bgcolor='#800000'><TR><TH bgcolor='#800000'></TH></TR></TABLE>" +
	    				"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>");
			
			out.println("<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH style='width:100%' bgcolor='#333333'><FONT size='+1' color='#FFFFFF'>EDITE OS DADOS FAZENDO LOGIN COMO ADMINISTRADOR</FONT></TH>" +
						"<TABLE style='width:100%'>" +
						"<form action='/Trabalho_Final_Marcos_LTP2/login' method='POST'>" +
						"<TR><TD style='width:05%' bgcolor='#333333'><FONT color='#FFFFFF'>Usuário: </FONT></TD>" +
						"<TD style='width:09%' bgcolor='#D9D9D9'><input type='text' name='usuario'></TD>" +
						"<TD style='width:05%' bgcolor='#333333'></TD>" +
						"<TD style='width:81%' bgcolor='#333333'></TD></TR>" +
						"<TR><TD style='width:05%' bgcolor='#333333'><FONT color='#FFFFFF'>Senha: </FONT></TD>" +
						"<TD style='width:09%' bgcolor='#D9D9D9'><input type='password' name='senha'></TD>" +
						"<TD style='width:05%' bgcolor='#262626'><input style='width:100%' type='hidden' name='idfilme' value='" + filme.getIdFilme() + "'></TD>" +
						"<TD style='width:05%' bgcolor='#262626'><input type='hidden' name='tipoLogin' value='loginFilme'><input type='submit' value='Buscar'>" +
						"<TD style='width:81%' bgcolor='#333333'></TD></TR>" +
						"</form>" +
						"</TABLE>");
		}		
%>		
</body>
</html>	
			
