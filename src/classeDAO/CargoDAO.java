package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.App;
import classeNegocio.Cargo;
import conexao.Conexao;

public class CargoDAO implements BaseDAO {
	
	private int opcao;
	private int id;
	private String var;

	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;


	public CargoDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	@Override
	public void atualizar() throws SQLException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cargo que quer atualizar"));
		sql = "select * from cargo where idCargo="+id;

		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();

		while(rs.next()){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção do cargo que quer atualizar\n1-Nome do cargo: "+rs.getString("nome")+"\n2-Descrição: "+rs.getString("descricao")));
			switch(opcao){
			case 1:
				var = JOptionPane.showInputDialog("Digite o novo nome do cargo");
				sql = "UPDATE cargo set nome = '"+var+"' where idCargo="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 2:
				var = JOptionPane.showInputDialog("Digite a nova descrição do cargo");
				sql = "UPDATE cargo set descricao = '"+var+"' where idcargo="+id;
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
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cargo que quer deletar"));
		sql = "delete from cargo where idcargo = "+id;
		opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir o cargo "+id+"?","Atencão",JOptionPane.YES_NO_OPTION);    
		if(opcao == JOptionPane.YES_OPTION){   
			stm = conn.prepareStatement(sql);
			stm.execute();
			JOptionPane.showMessageDialog(null, "Cargo excluído");
		}
		App.main(null);
	}

	@Override
	public void pesquisar() {
		
	}

	@Override
	public void salvar(Object cargo) throws SQLException, ClassNotFoundException {
		Cargo novo = (Cargo) cargo;
		sql = "insert into cargo (nome,descricao) values (?,?)";

		stm = conn.prepareStatement(sql);
		stm.setString(1, novo.getNome());
		stm.setString(2, novo.getDescricao());
		stm.execute();

		JOptionPane.showMessageDialog(null, "Cargo cadastrado");
		App.main(null);
	}

}
