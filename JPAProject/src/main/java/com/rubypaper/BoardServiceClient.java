package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class BoardServiceClient {
	public static void main(String[] args) {
		// EntityManager ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();// jpa�����̳�
		EntityTransaction tx = em.getTransaction();
		try {
			//�񿵼� ������ ��ƼƼ ��ü
			Board board = new Board();
			board.setTitle("JPA ����");
			board.setWriter("JPA ����");
			board.setContent("JPA ����");
			board.setCreateDate(new Date());
			board.setCnt(0L);

			// �� ��� ó��
			// tx���� (select������ tx�ʿ����)
//			tx.begin();
			//���� ���·� ����� persist(JPA�����ֿ̳� ���� ����), �ٵ� ���̺� �� ���� ����? -> insert
//			em.persist(board);
//			board.setTitle("����");//���� ���·� �ٲ���ִ� ��ü�� �������� �����ϸ� ���������� ������Ʈ �߻� -> update
			//writer�� updatable=false�̱� ������ ������Ʈ�ȵȴ�
			
//			Board board1 = em.find(Board.class, 1L);//���� ������ ������ž� �׷��ϱ� ���������̳ʴ� ����־� �״ϱ�db���� select�ؿ�
//			System.out.println(board1.toString()); //insert�� ������� select�½������ �ʴ´�.(�˻������ �ִµ�)
			//Board ��ƼƼ�� �����ϰ� seq�� �ڵ����� 1�� ������, ������ �갡 ���� �� ���ӻ��� > perisit > ���ӻ��� �� �� 1�� seq�� �ش��ϴ� ��ƼƼ�� db�� ������ db�� insert�� ������
			//�ٵ� ���� 1�� seq ��ƼƼ�� find�� ��  ���Ӽ� �����̳ʿ� 1���� ��û�ϰ� �ǰ� ���� 1�� ��ƼƼ�� ���ؽ�Ʈ�� �ִ»��¾� -> select���ϰ� �ٷ� �������ش�(�޸𸮿� �ִ�).
			//�׷��� �߿��Ѱ� ���� 2���� select�ҷ��� �� �� ���Ӽ� ���ؽ�Ʈ���� 1���ۿ� ������ db���� select�ؼ� ���Ӽ� ���ؽ�Ʈ�� �߰��Ѵ�(�޸𸮿� ����). �ٵ� �����̳ʻ��θ��� 1���������� �׷��� select��
//			select����� tx����� �ʿ����.
			//tx ����
//			tx.commit(); //�� �� ���ӻ��¿� �ִ� ��ü�� ���� �ٲٸ� �ڵ����� jpa�����̳ʰ� update�� ���ش�.
			//find�޼ҵ�� ����ȸ�ε� jpa�����̳ʰ�ü�� �����ϸ� select�� �ȵȴ�. jpa�� ���������� ���� ��ü�� db���� �����;� select�� �����̵ȴ�. ���ο� entity�� �����ϰ�db���������޾� ���ӻ��°��ȴ�.
			tx.begin();
			em.persist(board);
			
//			em.detach(board);//jpa�����̳��� ������ ���� �ʴ´�.
//			board.setTitle("�ؿ��ӻ��°� �Ǹ� ���� �ٲ㵵 ������Ʈ�� ���� �ʾƿ�");
//			em.merge(board);//�ؿ��ӻ��°� �� entity�� merge�� ���� �ٽ� ���ӻ��·� �ǵ��� �� �ִ�. �ٵ� ��������
//			board.setTitle("merge�� �ǵ��Ⱦ��.");
			em.remove(board);//�������´� jpa�����̳ʿ��� entity�� �����ϴ°̴ϴ�. �������´� ��ü�� ������ �� ���ӻ��¿� �����ϴ�. �޸𸮿��� �������� �ƴϴ�.
//			remove������ ��ü�� ��Ȱ���ϴ°��� �����ʴ� persist�� ��Ȱ���������� garbagecollection�� �����ϰ� ���ΰ� persist�� �ٽ� ������ ���� �� ����.

			tx.commit();
			

			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
