package models;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDao {
    FabricaConexao fc  = new FabricaConexao(
			"root", "jdbc:mysql://localhost/biblio", "1234");
    public void inserir(Funcionario a){
        String sql = "INSERT INTO usuario (nome, cpf, telefone, email, atribuicao, status_emprestimo)"
				+ "VALUES (?, ?, ?, ?, 'funcionario', 1)";
		try {
			PreparedStatement ps = 
					fc.getConnection().prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getCpf());
			ps.setString(3, a.getTelefone());
			ps.setString(4, a.getEmail());

			int rowAffected = ps.executeUpdate();
			if(rowAffected == 1) {
				System.out.println("SUCESSO ao inserir Pessoa");
			}else {
				System.out.println("ERR - Linhas "+rowAffected);
			}
			
		}catch(SQLException e) {
			System.out.println("Erro ao inserir Pessoa");
		}
    }
    
    public void emprestar(Funcionario a, String id){
        a.emprestar(id);
    }
    public void devolver(Funcionario a){
        a.devolver();
    }
}
