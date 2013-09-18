package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import app.App;

import conexao.Conexao;

public class ExerciciosDAO implements BaseDAO {

	private int opcao;
	private int id;
	private String var;

	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;


	public ExerciciosDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	@Override
	public void atualizar() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar() throws SQLException, NumberFormatException,
	HeadlessException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void salvar(Object novo) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void pesquisar() throws SQLException, ClassNotFoundException {
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha o número do exercício que quer consultar - Entre 1 e 30"));
		switch(opcao){
		case 1:
			sql = "select nome from professor";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("nome"));
				System.out.println("**************************");
			}
			break;
		case 2:
			sql = "select email from aluno";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("email"));
				System.out.println("**************************");
			}
			break;
		case 3:
			sql = "select nome,salario from funcionario";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("nome"));
				System.out.println(rs.getDouble("salario")*0.15);
				System.out.println("**************************");
			}
			break;
		case 4:
			sql = "select nome from aluno where idade>18";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("nome"));
				System.out.println("**************************");
			}
			break;
		case 5:
			sql = "select nome from funcionario where nome like 'A%'";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("nome"));
				System.out.println("**************************");
			}
			break;
		case 6:
			sql = "select * from funcionario, cargo where idade>24 and funcionario.idade <36 order by idade";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("funcionario.idFuncionario")+" - "+rs.getString("cargo.nome")+" - "+rs.getString("funcionario.nome")+" - "+rs.getDouble("funcionario.salario")+" - "+rs.getInt("funcionario.idade")+" - "+rs.getString("funcionario.horaEntrada")+" - "+rs.getInt("funcionario.horaSaida"));
				System.out.println("**************************");
			}
			break;
		case 7:
			sql = "select substr(nome,1,3) from funcionario";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println("**************************");
			}
			break;
		case 8:
			sql = "select nome, length(nome) from disciplina";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getInt(2));
				System.out.println("**************************");
			}
			break;
		case 9:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do professor que quer consultar o salário"));
			sql = "select count(idDisciplina) as num,salario from disciplina,professor where professor.idProfessor = disciplina.professor_idProfessor";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				DecimalFormat df = new DecimalFormat("#,###.00");
				System.out.println (df.format(rs.getInt("num")*rs.getDouble("salario")));
				System.out.println("**************************");
			}
			break;
		case 10:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do aluno que quer consultar a data de matrícula"));
			sql = "select count(idDisciplina) as num,salario from disciplina,professor where professor.idProfessor = disciplina.professor_idProfessor";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				DecimalFormat df = new DecimalFormat("#,###.00");
				System.out.println (df.format(rs.getInt("num")*rs.getDouble("salario")));
				System.out.println("**************************");
			}
			break;
		case 11:
			sql = "select nome from disciplina";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println (rs.getString(1).toString().toUpperCase());
				System.out.println("**************************");
			}
			break;
		case 12:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso que quer consultar os alunos"));
			sql = "select aluno.nome,curso.nome from aluno,turma,curso where aluno.turma_idTurma = turma.idTurma and turma.curso_idCurso = "+id;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println (rs.getString("aluno.nome"));
				System.out.println("**************************");
			}
			break;
		case 13:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso que quer consultar as disciplinas"));
			sql = "select disciplina.nome from disciplina where disciplina.curso_idCurso = "+id;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println (rs.getString(1));
				System.out.println("**************************");
			}
			break;
		case 14:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso que quer consultar as turmas"));
			sql = "select turma.identificador from turma,curso where turma.curso_idCurso = "+id;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println (rs.getString(1));
				System.out.println("**************************");
			}
			break;
		case 15:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do professor que quer consultar as disciplinas"));
			sql = "select curso.nome, professor.nome, disciplina.nome from curso,professor,disciplina where professor.idProfessor = "+id+" and disciplina.professor_idProfessor="+id+" and curso.idCurso = disciplina.curso_idCurso";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println ("curso: "+rs.getString(1));
				System.out.println ("professor: "+rs.getString(2));
				System.out.println ("disciplina: "+rs.getString(3));
				System.out.println("**************************");
			}
			break;
		case 16:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do coordenador que quer consultar os cursos"));
			sql = "select curso.nome,coordenador.nome from curso,coordenador where coordenador.idCoordenador = "+id+" and coordenador.curso_idCurso = curso.idCurso";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println ("Curso: "+rs.getString(1));
				System.out.println ("Coordenador: "+rs.getString(2));
				System.out.println("**************************");
			}
			break;
		case 17:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso que quer consultar os professores e coordenadores"));
			sql = "select curso.nome,coordenador.nome, professor.nome, disciplina.nome from curso,coordenador,professor,disciplina where curso.idCurso = coordenador.curso_idCurso and disciplina.curso_idCurso=curso.idCurso and disciplina.professor_idProfessor = professor.idProfessor and curso.idCurso = "+id;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				System.out.println ("Curso: "+rs.getString(1));
				System.out.println ("Coordenador: "+rs.getString(2));
				System.out.println ("Professores");
				System.out.println ("Disciplina: "+rs.getString(4)+" Professor: "+rs.getString(3));
				System.out.println("**************************");
			}
			break;
		case 18:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso que quer consultar o número de alunos"));
			sql = "select count(aluno.ra), curso.nome from curso,aluno,turma where aluno.turma_idTurma = turma.idTurma and turma.curso_idCurso = curso.idCurso and curso.idCurso= "+id;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println ("Nome do curso "+rs.getString(2));
				System.out.println ("Número de alunos: "+rs.getString(1));
				System.out.println("**************************");
			}
			break;
		case 19:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da turma que quer consultar os nomes dos alunos"));
			sql = "select aluno.nome, turma.identificador from aluno,turma where aluno.turma_idTurma = turma.idTurma and turma.idTurma = "+id;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println ("Nome da turma "+rs.getString(2));
				System.out.println ("Nome do aluno: "+rs.getString(1));
				System.out.println("**************************");
			}
			break;
		case 20:
			var = JOptionPane.showInputDialog("Digite o nome da disciplina que quer consultar o nome dos professores");
			sql = "select disciplina.nome, professor.nome from disciplina, professor where disciplina.nome = '"+var+"' and disciplina.professor_idProfessor = professor.idProfessor";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println ("Nome da disciplina "+rs.getString(1));
				System.out.println ("Nome do professor: "+rs.getString(2));
				System.out.println("**************************");
			}
			break;
		case 21:
			sql = "select professor.nome from disciplina, professor where disciplina.professor_idProfessor = professor.idProfessor and idDisciplina = "+5;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			System.out.println("Professores de desenvolvimento de jogos");
			System.out.println("**************************");
			while(rs.next()){
				System.out.println ("Nome do professor: "+rs.getString(1));
				System.out.println("**************************");
			}
			break;
		case 22:
			sql = "select * from funcionario";
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			System.out.println("Nome --- Código do Cargo --- Salário --- Hora de Entrada --- Hora de Saída");
			while(rs.next()){
				System.out.println (rs.getString("nome")+"---"+rs.getString("cargo_idCargo")+"---"+rs.getDouble("salario")+"---"+rs.getString("horaEntrada")+"---"+rs.getString("horaSaida"));
				System.out.println("**************************");
			}
			break;
		case 23:
			var = JOptionPane.showInputDialog("Digite o código do título que quer contar os professores");
			sql = "select count(professor.idProfessor),titulo.nome from titulo,professor,titulo_has_professor where titulo_has_professor.titulo_idTitulo = titulo.idTitulo and titulo_has_professor.professor_idProfessor = professor.idProfessor and titulo_has_professor.titulo_idTitulo = "+var;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println("Nome do título: "+rs.getString("titulo.nome"));
				System.out.println ("Quantidade de professor: "+rs.getString(1));
				System.out.println("**************************");
			}
			break;
		case 24:
			var = JOptionPane.showInputDialog("Digite o código do título que quer agrupar os professores");
			sql = "select professor.nome,titulo.nome from titulo,professor,titulo_has_professor where titulo_has_professor.professor_idProfessor = professor.idProfessor and titulo_has_professor.titulo_idTitulo = titulo.idTitulo  and titulo_has_professor.titulo_idTitulo = "+var;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println("Nome do título: "+rs.getString("titulo.nome"));
				System.out.println ("professor: "+rs.getString("professor.nome"));
				System.out.println("**************************");
			}
			break;
		case 25:
			var = JOptionPane.showInputDialog("Ainda não fiz");
			sql = "select professor.nome,titulo.nome from titulo,professor,titulo_has_professor where titulo_has_professor.professor_idProfessor = professor.idProfessor and titulo_has_professor.titulo_idTitulo = titulo.idTitulo  and titulo_has_professor.titulo_idTitulo = "+var;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println("Nome do título: "+rs.getString("titulo.nome"));
				System.out.println ("professor: "+rs.getString("professor.nome"));
				System.out.println("**************************");
			}
			break;
		case 26:
			var = JOptionPane.showInputDialog("Digite o código do aluno que quer visualizar o histórico");
			sql = "select aluno.nome,disciplina.nome, historico.nota, historico.situacao from aluno,disciplina,historico where historico.aluno_ra = aluno.ra and historico.disciplina_idDisciplina = disciplina.idDisciplina and historico.aluno_ra = "+var;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println("Nome do aluno: "+rs.getString(1));
				System.out.println ("Nome da disciplina: "+rs.getString(2));
				System.out.println ("Nota: "+rs.getDouble(3));
				System.out.println ("Situação: "+rs.getString(4));
				System.out.println("**************************");
			}
			break;
		case 27:
			var = JOptionPane.showInputDialog("No texto não há informações para saber quando o aluno efetua rematrícula");
			sql = "select professor.nome,titulo.nome from titulo,professor,titulo_has_professor where titulo_has_professor.professor_idProfessor = professor.idProfessor and titulo_has_professor.titulo_idTitulo = titulo.idTitulo  and titulo_has_professor.titulo_idTitulo = "+var;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println("Nome do título: "+rs.getString("titulo.nome"));
				System.out.println ("professor: "+rs.getString("professor.nome"));
				System.out.println("**************************");
			}
			break;
		case 28:
			var = JOptionPane.showInputDialog("No texto não há informações para saber quando um aluno é novo no curso");
			sql = "select professor.nome,titulo.nome from titulo,professor,titulo_has_professor where titulo_has_professor.professor_idProfessor = professor.idProfessor and titulo_has_professor.titulo_idTitulo = titulo.idTitulo  and titulo_has_professor.titulo_idTitulo = "+var;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println("Nome do título: "+rs.getString("titulo.nome"));
				System.out.println ("professor: "+rs.getString("professor.nome"));
				System.out.println("**************************");
			}
			break;
		case 29:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da turma que quer consultar o número de alunos"));
			sql = "select count(aluno.ra), turma.identificador from aluno,turma where aluno.turma_idTurma = turma.idTurma and turma.idTurma = "+id;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println ("Nome da turma "+rs.getString(2));
				System.out.println ("Nome do aluno: "+rs.getString(1));
				System.out.println("**************************");
			}
			break;
		case 30:
			id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da turma que quer consultar o número de alunos"));
			sql = "select count(aluno.ra), turma.identificador, turma.periodo from aluno,turma where turma.idTurma = "+id+" and aluno.turma_idTurma = turma.idTurma and turma.periodo='manhã' or turma.periodo='tarde' or turma.periodo = 'noite'" ;
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				System.out.println ("Período "+rs.getString(3));
				System.out.println ("Nome da turma "+rs.getString(2));
				System.out.println ("Nome do aluno: "+rs.getString(1));
				System.out.println("**************************");
			}
			break;
		}
		App.main(null);
	}
}
