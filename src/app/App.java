package app;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.ExerciciosDAO;
import classeNegocio.Aluno;
import classeNegocio.Cargo;
import classeNegocio.Coordenador;
import classeNegocio.Curso;
import classeNegocio.Disciplina;
import classeNegocio.Funcionario;
import classeNegocio.Historico;
import classeNegocio.Professor;
import classeNegocio.Titulo;
import classeNegocio.Turma;

public class App {

	private static int opcao;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer realizar\n1-Cadastrar\n2-Deletar\n3-Atualizar\n4-Exercícios"));
		switch(opcao){
		case 1:
			salvar();
			break;
		case 2:
			deletar();
			break;
		case 3:
			atualizar();
			break;
		case 4:
			verExercicios();
		}
	}

	private static void atualizar() throws ClassNotFoundException, SQLException {
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer atualizar\n1-Aluno\n2-Professor\n3-Curso\n4-Disciplina\n5-Coordenador\n6-Turma\n7-Título\n8-Cargo\n9-Histórico\n10-Funcionário"));
		switch(opcao){
		case 1:
			Aluno aluno = new Aluno();
			aluno.atualizar();
			break;
		case 2:
			Professor professor = new Professor();
			professor.atualizar();
			break;
		case 3:
			Curso curso = new Curso();
			curso.atualizar();
			break;
		case 4:
			Disciplina disciplina = new Disciplina();
			disciplina.atualizar();
			break;
		case 5:
			Coordenador coordenador = new Coordenador();
			coordenador.atualizar();
			break;
		case 6:
			Turma turma = new Turma();
			turma.atualizar();
			break;
		case 7:
			Titulo titulo = new Titulo();
			titulo.atualizar();
			break;
		case 8:
			Cargo cargo = new Cargo();
			cargo.atualizar();
			break;
		case 9:
			Historico historico = new Historico();
			historico.atualizar();
			break;
		case 10:
			Funcionario funcionario = new Funcionario();
			funcionario.atualizar();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Código inválido");
			break;
		}
	}

	private static void deletar() throws ClassNotFoundException, SQLException {
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer deletar\n1-Aluno\n2-Professor\n3-Curso\n4-Disciplina\n5-Coordenador\n6-Turma\n7-Título\n8-Cargo\n9-Histórico\n10-Funcionário"));
		switch(opcao){
		case 1:
			Aluno aluno = new Aluno();
			aluno.deletar();
			break;
		case 2:
			Professor professor = new Professor();
			professor.deletar();
			break;
		case 3:
			Curso curso = new Curso();
			curso.deletar();
			break;
		case 4:
			Disciplina disciplina = new Disciplina();
			disciplina.deletar();
			break;
		case 5:
			Coordenador coordenador = new Coordenador();
			coordenador.deletar();
			break;
		case 6:
			Turma turma = new Turma();
			turma.deletar();
			break;
		case 7:
			Titulo titulo = new Titulo();
			titulo.deletar();
			break;
		case 8:
			Cargo cargo = new Cargo();
			cargo.deletar();
			break;
		case 9:
			Historico historico = new Historico();
			historico.deletar();
			break;
		case 10:
			Funcionario funcionario = new Funcionario();
			funcionario.deletar();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Código inválido");
			break;
		}
	}

	private static void salvar() throws ClassNotFoundException, SQLException {
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer cadastrar\n1-Aluno\n2-Professor\n3-Curso\n4-Disciplina\n5-Coordenador\n6-Turma\n7-Título\n8-Cargo\n9-Histórico\n10-Funcionário"));
		switch(opcao){
		case 1:
			Aluno aluno = new Aluno();
			aluno.salvar();
			break;
		case 2:
			Professor professor = new Professor();
			professor.salvar();
			break;
		case 3:
			Curso curso = new Curso();
			curso.salvar();
			break;
		case 4:
			Disciplina disciplina = new Disciplina();
			disciplina.salvar();
			break;
		case 5:
			Coordenador coordenador = new Coordenador();
			coordenador.salvar();
			break;
		case 6:
			Turma turma = new Turma();
			turma.salvar();
			break;
		case 7:
			Titulo titulo = new Titulo();
			titulo.salvar();
			break;
		case 8:
			Cargo cargo = new Cargo();
			cargo.salvar();
			break;
		case 9:
			Historico historico = new Historico();
			historico.salvar();
			break;
		case 10:
			Funcionario funcionario = new Funcionario();
			funcionario.salvar();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Código inválido");
			break;
		}
		App.main(null);
	}

	private static void verExercicios() throws SQLException, ClassNotFoundException {
		ExerciciosDAO exercicios = new ExerciciosDAO();
		exercicios.pesquisar();
	}
}
