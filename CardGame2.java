package practice;

import java.util.Random;
import java.util.Scanner;

class Card1 {
	String[] randomcard = { "a", "a", "b", "b", "c", "c", "d", "d", "e", "e", "f", "f", "g", "g", "h", "h" };// ī�忡 ��
																												// ��������
	static String[][] f = { { "*", "*", "*", "*" }, { "*", "*", "*", "*" }, { "*", "*", "*", "*" },
			{ "*", "*", "*", "*" } };// ī�尪�� ������ ����
}
class MixCard1 extends Card1 {// ī�带 �����ִ� Ŭ����
	Random r = new Random();
	int rn1, rn2;// 2���� �迭 f�� �� ��
	boolean check = false;// �ߺ��� üũ
	void mix() {// ī�带 �����ִ� �޼���
		for (int i = 0; i < 16; i++) {// ī�尡 16���̱⶧���� 16�� �ݺ����� ����
			while (check == false) {
				rn1 = r.nextInt(4);// 2�����迭 f�� ���� ���� �����Լ��� ����
				rn2 = r.nextInt(4);// 2�����迭 f�� ���� ���� �����Լ��� ����
				if (f[rn1][rn2] == "*") {// 2���� �迭���� ���� *���� �ƴ��� üũ�Ͽ� ���� �ο�
					check = true;
					f[rn1][rn2] = randomcard[i];
				} else {
					check = false;//2���� �迭 ���� ������ *�� �ƴ� �̹� ���� �������� �ٽ� while������ ���ư�
				}
			}
			check = false;//while���� �������� �ٽ� for������ ���ư� while������ �������� ����
		}
		for(int i=0;i<4;i++) {
			for(int j = 0;j<4;j++) {
				System.out.printf(f[i][j]);
			}
			System.out.println();
		}
	}
}

class ChooseCard1 extends MixCard1 {
	Scanner sc = new Scanner(System.in);
	int chcd;// ������ ī�� ��ȣ
	int chcd1, chcd2;// ù��°�� �Է¹��� ���� 2��°�� �Է¹��� ���� ������ ���ϴ� �Լ�(������ �ȵ�)
	int ten1, ten2;// ��
	int one1, one2;// ��
	int count = 0;// ���� ����
	boolean inif = false;//�̹� ����� ���� �Է¹ް� �˻����� �ʰ� if���� ���°��� �˻���
	static int turn = 0;//�ϼ��� �����ֱ� ���� �Լ�
	int k = 0;//for ���� �����ֱ����� �Լ�, �ϼ��� �������� �ȼ��������� ������
	public static void clearScreen() {//�ܼ�â�� �鿩����� 70ĭ �о
		for (int i = 0; i < 70; i++)
			System.out.println();
	}

	void Choose() {// ī�带 ���� �޼���
		while (count != 8) {// 8¦�� ī�带 �� �������� while���� ����
			if(k<3) {//ī�带 �߸��Է����� ���� ������ ������ ��Ȳ���� �ϼ��� ������.
				turn++;//�ϼ��� �÷���
				clearScreen();//�鿩����� ���� ȭ�� clear ȣ��
			}
			for (int i = 0; i < 4; i++) {// �Է¹��� ���� �����Ͽ� 2���� �迭�� ������
				for (int j = 0; j < 4; j++) {
					if (f[i][j] == "X") {//�̹� ���� ī��� X�� ���� �ٲ�� ������ X�� ���
						System.out.print("X ");
					} else {//���� ������ ���� ī��� 
						System.out.print(". ");
					}
				}
				System.out.println();
			}
			for (k = 0; k < 2; k++) {
				chcd = sc.nextInt();// ī�� ��ȣ �Է� �ޱ�

				chcd--;// �ε�����ȣ�� �����ֱ�
				if (chcd > 16) {// �Է��� ���ڰ� ī�� �������� Ŭ��
					System.out.println("�Է��Ͻ� ���ڰ� ī�� �������� Ů�ϴ�");
					k = 3;
					continue;
				}
				if (k == 0) {// ù��° ���� ���� �� 2���� �迭�� �ε��� ����
					chcd1 = chcd;//1��° �Է¹��� ���� chcd1���ٰ� ����
					ten1 = chcd / 4; // 0
					one1 = chcd % 4; // 2
					if (chcd > 16 || f[ten1][one1] == "X") {// �̹� ����� ī������ �ƴ��� üũ
						System.out.println("�̹� ���� ī���Դϴ�. �ٽ��Է��ϼ���");
						k = 3;//�̹� ����ī�带 �߸��Է��Ͽ����� �� �ϼ��� �������� �ʱ����� k��
						inif = true;//�̹� ����� ī�带 ����� ������ if���� ������� ����
						continue;
					}
					for (int i = 0; i < 4; i++) {// �Է¹��� ���� �����Ͽ� 2���� �迭�� ������
						for (int j = 0; j < 4; j++) {
							if (i == ten1 && j == one1) {
								System.out.print(f[ten1][one1] + " ");
							} else if (f[i][j] == "X") {
								System.out.print("X ");
							} else {
								System.out.print(". ");
							}
						}
						System.out.println();
					}
				} else {// �ι�° ���� ���� �� 2���� �迭�� �ε��� ���� 3
					chcd2 = chcd;//2��° �Է¹��� ���� chcd2���ٰ� ����
					if (chcd1 == chcd2) {//chcd1�� chcd2�� ���Ͽ� �� ���� ���� 
						System.out.println("�� ����  ������ ī�带 ���������ϴ�. �ٽ��Է��ϼ���");
						k = 0;
						continue;
					}
					ten2 = chcd / 4; // 1
					one2 = chcd % 4; // 1
					if (chcd > 16 || f[ten1][one1] == "X" || f[ten2][one2] == "X") {// �̹� ����� ī������ �ƴ��� üũ
						System.out.println("�̹� ���� ī���Դϴ�. �ٽ��Է��ϼ���");
						k = 0;
						inif = true;//�̹� ����� ī�带 ����� ������ if���� ������� ����
					}

					
				}

			}
			if (f[ten1][one1] == f[ten2][one2] && inif == false) {// �Է¹��� �μ��� �ε����� �ִ� ���ڰ� ���� ��
				count++;//����� ������� ������(while�� ��������)
				System.out.println(count + "�� ������ϴ�!");//���� ���� ���
				f[ten1][one1] = "X";//ī�� ¦�� ���߸� �� ���� X�� �ٲ���
				f[ten2][one2] = "X";
				try {
					System.out.println("¦�� ���߼̽��ϴ�! 5�ʵ��� Ȯ�� �� �Է����ּ���.");
					for (int i = 0; i < 4; i++) {// �Է¹��� ���� �����Ͽ� 2���� �迭�� ������
						for (int j = 0; j < 4; j++) {
							if (i == ten1 && j == one1) {
								System.out.print(f[ten1][one1] + " ");
							} else if (i == ten2 && j == one2) {
								System.out.print(f[ten2][one2] + " ");

							} else if (f[i][j] == "X") {
								System.out.print("X ");
							} else {
								System.out.print(". ");
							}
						}
						System.out.println();
					}
					Thread.sleep(5000);//¦�� ����� 5�ʰ� ī�� ��Ȳ�� ������
				} catch(InterruptedException e) {
					e.printStackTrace();
				}

			}
			else if(k<3){//ī���� ���� ������ ��������(�߸��Է��������� if���� ���� ����)
				try {
					System.out.println("�����Ͻ� ī���Դϴ�. 5�ʵ��� Ȯ�� �� �Է��Ͽ��ּ���.");
					for (int i = 0; i < 4; i++) {// �Է¹��� ���� �����Ͽ� 2���� �迭�� ������
						for (int j = 0; j < 4; j++) {
							if (i == ten1 && j == one1) {
								System.out.print(f[ten1][one1] + " ");
							} else if (i == ten2 && j == one2) {
								System.out.print(f[ten2][one2] + " ");

							} else if (f[i][j] == "X") {
								System.out.print("X ");
							} else {
								System.out.print(". ");
							}
						}
						System.out.println();
					}
					Thread.sleep(5000);//¦�� ������ ������ �� 5�ʰ� �ڽ��� �������� ī�带 �ܿ���ִ� �ð��� ��
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			inif = false;//if�� �˻� üũ���� �ʱ�ȭ
		}
	}
}

class Finish extends ChooseCard1 {
	void print() {
		System.out.println("��� ¦�� ���� ������ϴ�. ����� " + turn + "���� ���� ����Ͽ����ϴ�.");
	}
}

public class CardGame2 {
	public static void main(String[] args) {
		MixCard1 m = new MixCard1();
		m.mix();// ī�弯��
		ChooseCard1 c = new ChooseCard1();
		c.Choose();// ī�� ����
		Finish f = new Finish();
		f.print();//������ ���� �� �ڽ��� ����� �� ���� �Բ� ���� ���
	}
}
//hdfd
//gceb
//hefa
//cbga