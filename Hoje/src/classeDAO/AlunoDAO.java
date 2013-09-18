package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.App;

import classeNegocio.Aluno;
import conexao.Conexao;

public class AlunoDAO implements BaseDAO {
	
	private int opcao;
	private int id;
	private String var;
	
	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;
	
	
	public AlunoDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	@Override
	public void salvar(Object aluno) throws SQLException, ClassNotFoundException, HeadlessException {
		Aluno novo = (Aluno) aluno;
		sql = "insert into aluno (nome,email,idade,dataMatricula,turma_idTurma) values (?,?,?,?,?)";
		
		stm = conn.prepareStatement(sql);
		stm.setString(1, novo.getNome());
		stm.setString(2, novo.getEmail());
		stm.setInt(3, novo.getIdade());
		stm.setString(4, novo.getDataMatricula());
		stm.setInt(5, novo.getTurma());
		stm.execute();
		
		JOptionPane.showMessageDialog(null, "Aluno cadastrado");
		App.main(null);
	}

	@Override
	public void atualizar() throws SQLException, ClassNotFoundException, HeadlessException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do aluno que quer atualizar"));
		sql = "select * from aluno where ra="+id;
		
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		
		while(rs.next()){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer atualizar\n1-Nome: "+rs.getString("nome")+"\n2-Email: "+rs.getString("email")+"\n3-Idade: "+rs.getInt("idade")+"\n4-Data de Matrícula: "+rs.getString("dataMatricula")));
			switch(opcao){
			case 1:
				var = JOptionPane.showInputDialog("Digite o novo nome do aluno");
				sql = "UPDATE aluno set nome = '"+var+"' where ra="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 2:
				var = JOptionPane.showInputDialog("Digite o novo email do aluno");
				sql = "UPDATE aluno set email = '"+var+"' where ra="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 3:
				var = JOptionPane.showInputDialog("Digite a nova idade do aluno");
				sql = "UPDATE aluno set idade = '"+var+"' where ra="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 4:
				var = JOptionPane.showInputDialog("Digite a nova data de matriculoa do aluno");
				sql = "UPDATE aluno set dataMatricula = '"+var+"' where ra="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
				default: JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
		App.main(null);
	}

	@Override
	public void deletar() throws SQLException, NumberFormatException, HeadlessException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do aluno que quer deletar"));
		sql = "delete from aluno where ra = "+id;
		opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir o aluno"+id+"?","Atencão",JOptionPane.YES_NO_OPTION);    
        if(opcao == JOptionPane.YES_OPTION){   
              stm = conn.prepareStatement(sql);
              stm.execute();
              JOptionPane.showMessageDialog(null, "Aluno excluído");
          }
        App.main(null);
	}

	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub

	}

}
