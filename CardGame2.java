package practice;

import java.util.Random;
import java.util.Scanner;

class Card1 {
	String[] randomcard = { "a", "a", "b", "b", "c", "c", "d", "d", "e", "e", "f", "f", "g", "g", "h", "h" };// 카드에 들어갈
																												// 랜덤변수
	static String[][] f = { { "*", "*", "*", "*" }, { "*", "*", "*", "*" }, { "*", "*", "*", "*" },
			{ "*", "*", "*", "*" } };// 카드값을 저장할 공간
}
class MixCard1 extends Card1 {// 카드를 섞어주는 클래스
	Random r = new Random();
	int rn1, rn2;// 2차원 배열 f의 행 열
	boolean check = false;// 중복값 체크
	void mix() {// 카드를 섞어주는 메서드
		for (int i = 0; i < 16; i++) {// 카드가 16장이기때문에 16번 반복문을 돌림
			while (check == false) {
				rn1 = r.nextInt(4);// 2차원배열 f의 행의 값을 랜덤함수로 받음
				rn2 = r.nextInt(4);// 2차원배열 f의 열의 값을 랜덤함수로 받음
				if (f[rn1][rn2] == "*") {// 2차원 배열안의 값이 *인지 아닌지 체크하여 값을 부여
					check = true;
					f[rn1][rn2] = randomcard[i];
				} else {
					check = false;//2차원 배열 안의 내용이 *이 아닌 이미 값이 들어가있으면 다시 while문으로 돌아감
				}
			}
			check = false;//while문을 빠져나와 다시 for문으로 돌아가 while문으로 들어가기위한 대입
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
	int chcd;// 뒤집을 카드 번호
	int chcd1, chcd2;// 첫번째에 입력받은 수와 2번째에 입력받은 수가 같은지 비교하는 함수(같으면 안됨)
	int ten1, ten2;// 행
	int one1, one2;// 열
	int count = 0;// 맞춘 개수
	boolean inif = false;//이미 맞췄던 수를 입력받고 검사하지 않게 if문에 들어가는것을 검사함
	static int turn = 0;//턴수를 세어주기 위한 함수
	int k = 0;//for 문을 돌려주기위한 함수, 턴수를 세어줄지 안세어줄지를 결정함
	public static void clearScreen() {//콘솔창을 들여쓰기로 70칸 밀어냄
		for (int i = 0; i < 70; i++)
			System.out.println();
	}

	void Choose() {// 카드를 고르는 메서드
		while (count != 8) {// 8짝의 카드를 다 맞췄을때 while문이 멈춤
			if(k<3) {//카드를 잘못입력했을 때를 제외한 나머지 상황에서 턴수를 세어줌.
				turn++;//턴수를 늘려줌
				clearScreen();//들여쓰기로 인한 화면 clear 호출
			}
			for (int i = 0; i < 4; i++) {// 입력받은 수를 구분하여 2차원 배열을 보여줌
				for (int j = 0; j < 4; j++) {
					if (f[i][j] == "X") {//이미 맞춘 카드는 X로 값이 바뀌기 때문에 X를 출력
						System.out.print("X ");
					} else {//아직 맞추지 않은 카드는 
						System.out.print(". ");
					}
				}
				System.out.println();
			}
			for (k = 0; k < 2; k++) {
				chcd = sc.nextInt();// 카드 번호 입력 받기

				chcd--;// 인덱스번호로 맞춰주기
				if (chcd > 16) {// 입력한 숫자가 카드 개수보다 클때
					System.out.println("입력하신 숫자가 카드 개수보다 큽니다");
					k = 3;
					continue;
				}
				if (k == 0) {// 첫번째 수를 받은 뒤 2차원 배열의 인덱스 구분
					chcd1 = chcd;//1번째 입력받은 값을 chcd1에다가 넣음
					ten1 = chcd / 4; // 0
					one1 = chcd % 4; // 2
					if (chcd > 16 || f[ten1][one1] == "X") {// 이미 골랐던 카드인지 아닌지 체크
						System.out.println("이미 맞춘 카드입니다. 다시입력하세요");
						k = 3;//이미 맞춘카드를 잘못입력하였을때 그 턴수를 세어주지 않기위한 k값
						inif = true;//이미 골랐던 카드를 골랐기 때문에 if문을 통과하지 않음
						continue;
					}
					for (int i = 0; i < 4; i++) {// 입력받은 수를 구분하여 2차원 배열을 보여줌
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
				} else {// 두번째 수를 받은 뒤 2차원 배열의 인덱스 구분 3
					chcd2 = chcd;//2번째 입력받은 수를 chcd2에다가 대입
					if (chcd1 == chcd2) {//chcd1과 chcd2를 비교하여 이 전과 같은 
						System.out.println("이 전과  동일한 카드를 뒤집었습니다. 다시입력하세요");
						k = 0;
						continue;
					}
					ten2 = chcd / 4; // 1
					one2 = chcd % 4; // 1
					if (chcd > 16 || f[ten1][one1] == "X" || f[ten2][one2] == "X") {// 이미 골랐던 카드인지 아닌지 체크
						System.out.println("이미 맞춘 카드입니다. 다시입력하세요");
						k = 0;
						inif = true;//이미 골랐던 카드를 골랐기 때문에 if문을 통과하지 않음
					}

					
				}

			}
			if (f[ten1][one1] == f[ten2][one2] && inif == false) {// 입력받은 두수의 인덱스에 있는 문자가 같을 때
				count++;//몇쌍을 맞췄는지 세어줌(while문 종료조건)
				System.out.println(count + "개 맞췄습니다!");//맞춘 개수 출력
				f[ten1][one1] = "X";//카드 짝을 맞추면 그 값을 X로 바꿔줌
				f[ten2][one2] = "X";
				try {
					System.out.println("짝을 맞추셨습니다! 5초동안 확인 후 입력해주세요.");
					for (int i = 0; i < 4; i++) {// 입력받은 수를 구분하여 2차원 배열을 보여줌
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
					Thread.sleep(5000);//짝을 맞춘뒤 5초간 카드 상황을 보여줌
				} catch(InterruptedException e) {
					e.printStackTrace();
				}

			}
			else if(k<3){//카드의 값을 맞추지 못했을때(잘못입력햇을때엔 if문에 들어가지 않음)
				try {
					System.out.println("선택하신 카드입니다. 5초동안 확인 후 입력하여주세요.");
					for (int i = 0; i < 4; i++) {// 입력받은 수를 구분하여 2차원 배열을 보여줌
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
					Thread.sleep(5000);//짝을 맞추지 못했을 때 5초간 자신이 뒤집었던 카드를 외울수있는 시간을 줌
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			inif = false;//if문 검사 체크변수 초기화
		}
	}
}

class Finish extends ChooseCard1 {
	void print() {
		System.out.println("모든 짝을 전부 맞췄습니다. 당신은 " + turn + "번의 턴을 사용하였습니다.");
	}
}

public class CardGame2 {
	public static void main(String[] args) {
		MixCard1 m = new MixCard1();
		m.mix();// 카드섞기
		ChooseCard1 c = new ChooseCard1();
		c.Choose();// 카드 고르기
		Finish f = new Finish();
		f.print();//게임이 끝난 후 자신이 사용한 턴 수와 함께 문구 출력
	}
}
//hdfd
//gceb
//hefa
//cbga