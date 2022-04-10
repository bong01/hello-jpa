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

//            System.out.println("==============================");

            /**
             * @Enumerated
             */
//            Member member = new Member();
//            member.setId(1L);
//            member.setUsername("A");
//            member.setRoleType(RoleType.USER);
//
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setId(2L);
//            member2.setUsername("B");
//            member2.setRoleType(RoleType.ADMIN);
//
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setId(3L);
//            member3.setUsername("C");
//            member3.setRoleType(RoleType.GUEST);
//
//            em.persist(member3);

            /**
             * 기본 키 매핑 - IDENTITY
             */
//            Member member = new Member();
////            member.setId("ID_A");
//            member.setUsername("C");
//
//            //IDENTITY 전략은 em.persist() 시점에 즉시 INSERT SQL을 실행하고 DB에서 식별자를 조회
//            System.out.println("=======================");
//
//            em.persist(member);
//
//            System.out.println("member1.id = " + member.getId());
//            System.out.println("=======================");

            /**
             * 기본 키 매핑 - SEQUENCE
             */
            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("======================");

            em.persist(member1); //1, 51
            em.persist(member2); //MEM
            em.persist(member3); //MEM

            System.out.println("member1 = " + member1.getId());
            System.out.println("member2 = " + member2.getId());
            System.out.println("member3 = " + member3.getId());

            System.out.println("======================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
