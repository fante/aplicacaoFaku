package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.App;
import classeNegocio.Titulo;
import classeNegocio.Turma;

import conexao.Conexao;

public class TituloDAO implements BaseDAO {
	
	private int opcao;
	private int id;
	private String var;

	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;


	public TituloDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	@Override
	public void atualizar() throws SQLException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do título que quer atualizar"));
		sql = "select * from titulo where idTitulo="+id;

		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();

		while(rs.next()){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer atualizar\n1-Nome do título: "+rs.getString("nome")+"\n2-Descrição: "+rs.getString("descricao")));
			switch(opcao){
			case 1:
				var = JOptionPane.showInputDialog("Digite o novo nome do título");
				sql = "UPDATE titulo set nome = '"+var+"' where idTitulo="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 2:
				var = JOptionPane.showInputDialog("Digite a nova descrição do título");
				sql = "UPDATE titulo set descricao = '"+var+"' where idTitulo="+id;
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
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do título que quer deletar"));
		sql = "delete from titulo where idTitulo = "+id;
		opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir o título "+id+"?","Atencão",JOptionPane.YES_NO_OPTION);    
		if(opcao == JOptionPane.YES_OPTION){   
			stm = conn.prepareStatement(sql);
			stm.execute();
			JOptionPane.showMessageDialog(null, "Título excluído");
		}
		App.main(null);
	}

	@Override
	public void pesquisar() {
		
	}

	@Override
	public void salvar(Object titulo) throws SQLException, ClassNotFoundException {
		Titulo novo = (Titulo) titulo;
		sql = "insert into titulo (nome,descricao) values (?,?)";

		stm = conn.prepareStatement(sql);
		stm.setString(1, novo.getNome());
		stm.setString(2, novo.getDescricao());
		stm.execute();

		JOptionPane.showMessageDialog(null, "Título cadastrado");
		App.main(null);
	}

}
