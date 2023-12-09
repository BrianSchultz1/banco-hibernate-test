package hbd;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hbd.entities.Aluno;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import hbd.entities.Item;


public class App {
    public static void main(String[] args) {
        System.out.println("Iniciando...");
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .build();

        try {
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Item.class)
                    .addAnnotatedClass(Aluno.class)
                    .buildMetadata()
                    .buildSessionFactory();
            sessionFactory.inTransaction(session -> {
                session.persist(new Item("Primeiro Evento", LocalDateTime.now()));
                session.persist(new Item("Segundo Evento", LocalDateTime.now()));
                session.persist(new Item("Terceiro Evento", LocalDateTime.now()));
            });
            sessionFactory.inTransaction(session -> {
                List<Item> itens = session.createQuery("from Item", Item.class).getResultList();
                System.out.println("Itens Encontrados:");
                itens.forEach(Item::print);
                System.out.println("Total de itens: " + itens.size());
            });
            List<Item> itensARemover = new ArrayList<>();
            sessionFactory.inTransaction(session -> {
                System.out.println("Procurando Segundo Evento:");
                itensARemover.addAll(session
                        .createNativeQuery("SELECT * FROM tbl_item WHERE it_titulo = :titulo_procurar", Item.class)
                        .setParameter("titulo_procurar", "Segundo Evento").getResultList());
                itensARemover.forEach(Item::print);
            });
            sessionFactory.inTransaction(session -> {
                System.out.println("Excluindo Segundo Evento:");
                Item itemARemover = session.get(Item.class, itensARemover.get(0).getId());
                session.remove(itemARemover);
            });
            sessionFactory.inTransaction(session -> {
                long total = (long) session.createQuery("select count(*) from Item", Long.class).uniqueResult();
                System.out.println("Total de Itens: " + total);
            });
            sessionFactory.inTransaction(session -> {
                System.out.println("Consulta: selecione o nome e a data de nascimento de todos os alunos");
                List<Aluno> alunos = session.createQuery("from Aluno", Aluno.class).getResultList();
                alunos.forEach(aluno -> System.out.println("Nome: " + aluno.getNome() + ", Data de Nascimento: " + aluno.getDataNascimento()));
            });
            sessionFactory.inTransaction(session -> {
                Aluno alunoUpdate = session.get(Aluno.class, 1L);
                if (alunoUpdate != null) {
                    System.out.println("Atualizando aluno");
                    alunoUpdate.setNome("Novo nome do aluno");
                    session.update(alunoUpdate);
                    System.out.println("Nome do aluno após a atualização: " + alunoUpdate.getNome());
                } else {
                    System.out.println("Aluno não pode ser encontrado");
                }

            });
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }
        System.out.println("Fim!");
    }
}
