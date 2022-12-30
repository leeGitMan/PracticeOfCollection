package lee.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import lee.kh.collection.model.vo.Student;

public class StudentService {
	
	Scanner sc = new Scanner(System.in);
	
	private List <Student> listOfStudent = new ArrayList<Student>();
	
	
	
	
	public void displayMenu() {
		
		
		int menuNum = 0;
		
		
		// displayMenu 출력하기
		do {
			
			System.out.println(" ===== 학생 메뉴 ===== ");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			// 1 ~ 4번까지 CRUD 
			System.out.println("5. 이름으로 검색(완전일치)");
			System.out.println("6. 이름으로 검색(포함일치)");
			System.out.println("0. 프로그램 종료");
			
			
			try {
				System.out.print("\n메뉴 번호 선택 >>");
				menuNum = sc.nextInt();
				sc.nextLine();
				
				// switch문으로 뭘 선택할지 정하기
				// 혹시나 다른 문자 입력하면 예외처리 해야하니깐
				// 예외 처리문 만들기
				
				
				switch(menuNum) {
				case 1: System.out.println(addStudent()); break;
				case 2: allForOne(); break;
				case 3: System.out.println( update()); break;
				case 4: System.out.println(remomomoveve()); break;
				case 5: searchName(); break;
				case 6: searchName1(); break;
				case 0: System.out.println("끄으으읏."); break;
				
				}
				
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("메뉴 숫자를 입력해주세요.");
				menuNum = -1;
				e.printStackTrace();
				break;
				
				
				
				
			}
		}while(menuNum != 0);
		
	}
	
	public String addStudent() {
		
		
		// 학생 추가
		// 뭐부터 할까...
		// 학생 정보 입력받고
		// 그 입력받은 값을 리스트에 넣기
		
		
		
		System.out.println("======== 학생 추가 ========");
		
		
		System.out.print("학생 이름 : ");
		String name = sc.next();
		
		System.out.print("학생 학년 : ");
		int grade = sc.nextInt();
		sc.nextLine();
		
		System.out.print("학생 반 : ");
		int classroom = sc.nextInt();
		sc.nextLine();
		
		
		// add는 boolean 형태로 true, false를 반환하니까 
		// if를 써서 성공이면
		// 리턴값에 성공
		// 실패하면 실패 이렇게 출력하게 하기
		
		
		if(listOfStudent.add(new Student(name,grade,classroom))) {
			return "성공";
		}
		return "실패";
	}
	
	
	
	public void allForOne() {
		
		
		System.out.println("===== 학생 정보 조회 =====");
		
		
		// 학생 정보 조회
		// 흠....뭐부터 헤ㅐ야하나...
		
		
		// 일단 리스트에 없으면 없다고 말해주기
		// 여기서 실수 해버렸네
		// == null 이 아니라
		// list는 isEmpty 쓰기
		// isEmpty --> 비어있니?
		// 당연히 반환은 boolean
		
		
		if(listOfStudent.isEmpty()) {
			System.out.println("없는데용");
			
		}
		
		// 있으면 출력해줘야함
		// 어떻게 해야하지?
		// 기억이 안난다...
		
		// 향상된 for문
		
		for(Student std : listOfStudent) {
			System.out.println(std);
			
		}		
	}
	
	
	
	public String update() throws InputMismatchException {
		
		// 인덱스 번호도 필요
		
		int index = 0;
		
		
		System.out.print(" === 학생 정보 수정할 인덱스 번호 입력 === ");
		index = sc.nextInt();
		sc.nextLine();
		
		
		// *** 주의 ***
		// 리턴이 있는 메서드니깐
		// if 다음에도 return을 써라
		// 학생 정보가 비어있으면 안댐
		// isEmpty
		if(listOfStudent.isEmpty()) {
			return "학생 정보가 비었네용";
		}
		// 인덱스 범위를 초과해서는 안댐
		else if(index < 0) {
			return "마이너스는 노노";
			
		// 인덱스 번호가 음수면 안댐
		}else if(index > listOfStudent.size()) {
			return "인덱스 초과아아아아아ㅏ";
			
		}else {
			
			System.out.println();
			System.out.println(index + "번째 학생 수정할게용");
			System.out.println(listOfStudent.get(index));
			
			
			System.out.print("학생 이름 : ");
			String name = sc.next();
			
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			sc.nextLine();
			
			System.out.print("학생 반 : ");
			int classroom = sc.nextInt();
			sc.nextLine();
		
			// 자 이제 이걸 다 받았으니 set으로 옮기자
			//set 도 마찬가지로 new 하고 해야함
			
			Student temp = listOfStudent.set(index, new Student(name, grade, classroom));
			
			return temp + " 수정 완료 ~~~ 치킨 먹고싶다";
			
		}
	}
	
	
	
	public String remomomoveve() throws InputMismatchException {
		
	
		int index = 0;
		
	
		System.out.print(" === 학생 정보 삭제할 인덱스 번호 입력 === ");
		index = sc.nextInt();
		sc.nextLine();
		
		
		// *** 주의 ***
		// 리턴이 있는 메서드니깐
		// if 다음에도 return을 써라
		// 학생 정보가 비어있으면 안댐
		// isEmpty
		if(listOfStudent.isEmpty()) {
			return "학생 정보가 비었네용";
		}
		// 인덱스 범위를 초과해서는 안댐
		else if(index < 0) {
			return "마이너스는 노노";
			
		// 인덱스 번호가 음수면 안댐
		}else if(index > listOfStudent.size()) {
			return "인덱스 초과아아아아아ㅏ";
		}
		else {
			
			System.out.println();
			System.out.println(index + "번째 학생 삭제 할게용");
			System.out.println(listOfStudent.get(index));
			
			System.out.println();
			System.out.println("근데 진짜 할까요? (Y/N)");
			
			char yes = sc.next().toUpperCase().charAt(0);
			
			if(yes == 'Y') {
				
				Student tempRemove = listOfStudent.remove(index);
				
				return tempRemove + " 이 놈 삭제 완료 \n";
				
				
			}else {
				return "삭제할 수 없었다...";
				
			}
		}
	}
	
	
	
	
	public void searchName() {
		
		System.out.println(" === 학생 이름 검색(완전 일치) === ");
		
		
		// 학생 이름으로 검색하기
		// 일단 먼저 학생 검색
		
		
		if(listOfStudent.isEmpty()) {
			System.out.println("없는데용?");
			System.out.println();
		}else {

			System.out.print("학생의 이름을 입력하시오.");
			String input = sc.next();

			for(Student std : listOfStudent) {
				if(input.equals(std.getName())) {
					System.out.println("찾는 이름 : " + std.getName());
				}
			}
		}
	}
	
	
	public void searchName1() {
		
		System.out.println(" === 학생 이름 검색(부분 일치) === ");
		
		// 학생 이름 검색하기
		// 부분 검색
		// contains 쓰기
		
		boolean flag = true;
		
		
		
		
		
		if(listOfStudent.isEmpty()) {
			System.out.println("비었네용");
		}
		else {
			System.out.print("검색할 사람의 이름 혹은 부분 이름 입력");
			String input = sc.next();
			
			for(Student std : listOfStudent) {
				if(std.getName().contains(input)) {
					System.out.println(std.getName());
					flag =false;
				}
			}
			if(flag) {
				System.out.println("없네용");
				
			}
		}
		
		
		
		
//		System.out.print("검색할 이름 혹은 부분적인 거 입력 ");
//		String input = sc.next();
//		
//		if(listOfStudent.isEmpty()) {
//			System.out.println("비었네용");
//			System.out.println();
//		}
//		else {
//			for(Student std : listOfStudent) {
//				if(std.getName().contains(input)) {
//					System.out.println(std.getName());
//				
//				}
//			}
//		}	
	}
}


