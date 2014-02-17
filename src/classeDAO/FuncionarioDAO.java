package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeNegocio.Coordenador;
import classeNegocio.Funcionario;

import app.App;

import conexao.Conexao;

public class FuncionarioDAO implements BaseDAO {
	
	private int opcao;
	private int id;
	private String var;
	
	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;
	
	public FuncionarioDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	@Override
	public void atualizar() throws SQLException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite a matr�cula do funcion�rio que quer atualizar"));
		sql = "select * from funcionario where idFuncionario="+id;
		
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		
		while(rs.next()){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o que quer atualizar\n1-Nome: "+rs.getString("nome")+"\n2-Cargo: "+rs.getInt("cargo_idCargo")+"\n3-Sal�rio: "+rs.getDouble("salario")+"\n4-Hor�rio de Entrada: "+rs.getString("horaEntrada")+"\n5-Hor�rio de Sa�da: "+rs.getString("horaSaida")));
			switch(opcao){
			case 1:
				var = JOptionPane.showInputDialog("Digite o novo nome do funcion�rio");
				sql = "UPDATE funcionario set nome = '"+var+"' where idFuncionario="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 2:
				var = JOptionPane.showInputDialog("Digite o novo c�digo do cargo do funcion�rio");
				sql = "UPDATE funcionario set cargo_idCargo = '"+var+"' where idFuncionario="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 3:
				var = JOptionPane.showInputDialog("Digite o novo sal�rio do funcion�rio");
				sql = "UPDATE funcionario set salario = '"+var+"' where idFuncionario="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 4:
				var = JOptionPane.showInputDialog("Digite o novo hor�rio de entrada do funcion�rio");
				sql = "UPDATE funcionario set horaEntrada = '"+var+"' where idFuncionario="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 5:
				var = JOptionPane.showInputDialog("Digite o novo hor�rio de sa�da funcion�rio");
				sql = "UPDATE funcionario set horaSaida = '"+var+"' where idFuncionario="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			}
		}
		App.main(null);

	}

	@Override
	public void deletar() throws SQLException, NumberFormatException,
			HeadlessException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo do funcion�rio que quer deletar"));
		sql = "delete from funcionario where idFuncionario = "+id;
		opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir o funcion�rio"+id+"?","Atenc�o",JOptionPane.YES_NO_OPTION);    
        if(opcao == JOptionPane.YES_OPTION){   
              stm = conn.prepareStatement(sql);
              stm.execute();
              JOptionPane.showMessageDialog(null, "Funcion�rio exclu�do");
          }
        App.main(null);
	}

	@Override
	public void pesquisar() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
	}

	@Override
	public void salvar(Object funcionario) throws SQLException, ClassNotFoundException {
		Funcionario novo = (Funcionario) funcionario;
		sql = "insert into funcionario (nome,cargo_idCargo,salario,horaEntrada,horaSaida) values (?,?,?,?,?)";
		
		stm = conn.prepareStatement(sql);
		stm.setString(1, novo.getNome());
		stm.setInt(2, novo.getIdCargo());
		stm.setDouble(3, novo.getSalario());
		stm.setString(4, novo.getHoraEntrada());
		stm.setString(5, novo.getHoraSaida());
		stm.execute();
		
		JOptionPane.showMessageDialog(null, "Funcion�rio cadastrado");
		App.main(null);
	}

}
