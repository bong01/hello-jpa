package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /**
             * 삽입
             */
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");

//            em.persist(member);

            /**
             * 조회
             */
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            /**
             * 변경
             */
            //변경사항이 있으면 update 쿼리 실행
//            findMember.setName("HelloJPA");

            /**
             * JPQL
             */
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            /**
             * 비영속
             */
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            /**
             * 영속
             */
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            /**
             * 영속 엔티티의 동일성 보장
             */
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("result = " + (findMember1 == findMember2));


            /**
             * 트랜잭션을 지원하는 쓰기 지연
             */
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

            /**
             * 변경 감지
             */
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");

            /**
             * 플러시
             */
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();

            /**
             * 준영속
             */
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//
//            //특정 엔티티만 준영속
//            em.detach(member);
//
//            //영속성 컨텍스트를 완전히 초기화
//            em.clear();
//
//            Member findMember = em.find(Member.class, 150L);

            System.out.println("==============================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
