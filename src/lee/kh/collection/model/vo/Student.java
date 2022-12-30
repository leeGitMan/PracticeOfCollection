package lee.kh.collection.model.vo;

import java.util.Objects;

public class Student {
	
	// 학년, 반, 이름
	
	private String name;
	private int grade;
	private int classroom;
	
	
	public Student() {
		
	}


	public Student(String name, int grade, int classroom) {
		
		this.grade = grade;
		this.classroom = classroom;
		this.name = name;
	}


	public int getGrade() {
		return grade;
	}


	public int getClassroom() {
		return classroom;
	}


	public String getName() {
		return name;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classroom=" + classroom + ", name=" + name + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(classroom, grade, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classroom == other.classroom && grade == other.grade && Objects.equals(name, other.name);
	}
	
	
	
	
	
	
	
	

	

}
