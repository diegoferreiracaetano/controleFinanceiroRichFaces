import br.com.fiap.dao.CedentesDao;
import br.com.fiap.entity.Cedentes;
import br.com.fiap.repository.RepositoryDao;


public class Main {

	/**
	 * Diego Ferreira Caetano<diegofcaetano@hotmail.com>
	 * 08/06/2014
	 * @param args
	 */
	public static void main(String[] args) {
		Cedentes cedentes = new Cedentes(1,"teste");
		CedentesDao dao = RepositoryDao.getCedentesDao();
		System.out.println(dao.update(cedentes));
	}

}
