package Repository;

import Controller.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class UsuarioRepository {
    private final Session session;

    public UsuarioRepository() {
        assert new Configuration().configure("hibernate.cfg.xml") != null;
        session = new Configuration().configure("hibernate.cfg.xml").clone;().openSession();
    }

    public void saveUser(Usuario usuario) {
        Transaction transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
    }

    public Usuario getUserById(int id) {
        return session.get(Usuario.class, id);
    }

    public List<UsuarioRepository> getAllUsers() {
        return session.createQuery("FROM User", UsuarioRepository.class).list();
    }

    public void updateUser(UsuarioRepository user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    public void deleteUser(int id) {
        Transaction transaction = session.beginTransaction();
        UsuarioRepository usuarioRepository = session.get(UsuarioRepository.class, id);
        if (usuarioRepository != null) {
            session.delete(usuarioRepository);
        }
        transaction.commit();
    }

    private static class Configuration {
        public Object configure(String s) {
            return null;
        }
    }
}


