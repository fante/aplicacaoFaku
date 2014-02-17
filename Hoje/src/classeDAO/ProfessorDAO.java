package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.App;
import classeNegocio.Aluno;
import classeNegocio.Professor;
import conexao.Conexao;

public class ProfessorDAO implements BaseDAO{
	
	private int opcao;
	private int id;
	private String var;
	
	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;
	
	public ProfessorDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

@Override
public void atualizar() throws SQLException, ClassNotFoundException {
	id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do aluno que quer atualizar"));
	sql = "select * from professor where idProfessor="+id;
	
	stm = conn.prepareStatement(sql);
	rs = stm.executeQuery();
	
	while(rs.next()){
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer atualizar\n1-Nome: "+rs.getString("nome")+"\n2-Salário: "+rs.getDouble("salario")));
		switch(opcao){
		case 1:
			var = JOptionPane.showInputDialog("Digite o novo nome do professor");
			sql = "UPDATE professor set nome = '"+var+"' where idProfessor="+id;
			System.out.println(sql);
			stm = conn.prepareStatement(sql);
			stm.execute(sql);
			JOptionPane.showMessageDialog(null, "Dado atualizado");
			break;
		case 2:
			var = JOptionPane.showInputDialog("Digite o novo salário do professor");
			sql = "UPDATE professor set salario = '"+var+"' where idProfessor="+id;
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
public void deletar() throws SQLException, NumberFormatException,HeadlessException, ClassNotFoundException {
	id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do professor que quer deletar"));
	sql = "delete from professor where idProfessor = "+id;
	opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir o professor "+id+"?","Atencão",JOptionPane.YES_NO_OPTION);    
    if(opcao == JOptionPane.YES_OPTION){   
          stm = conn.prepareStatement(sql);
          stm.execute();
          JOptionPane.showMessageDialog(null, "professor excluído");
      }
    App.main(null);
}

@Override
public void pesquisar() {
	// TODO Auto-generated method stub
	
}

@Override
public void salvar(Object professor) throws SQLException, ClassNotFoundException {

	Professor novo = (Professor) professor;
	sql = "insert into professor (nome,salario) values (?,?)";
	
	stm = conn.prepareStatement(sql);
	stm.setString(1, novo.getNome());
	stm.setDouble(2, novo.getSalario());
	
	stm.execute();
	
	JOptionPane.showMessageDialog(null, "Professor cadastrado");
	App.main(null);
}
}