package studentApp;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagment {
	Scanner input = new Scanner(System.in);
	ArrayList<Student> arrayList = new ArrayList<Student>();

	public void menu() {

		String forYes = "y";
		String unos;

		while (forYes.equals("y")) {
			System.out.println("1 - > Ako zelite dodati studenta.");
			System.out.println("2 - > Ako zelite zelite ispisati studenta.");
			System.out.println("3 - > Ako zelite promjeniti podatke jednog studenta.");
			System.out.println("4 - > Ako zelite obrisati jednog studenta.");
			System.out.println("5 - > Ako zelite ispisati sve studente.");
			System.out.println("****************************************************");
			System.out.println("\n");
			System.out.println("Unesite odgovarajuci broj:");
			unos = input.nextLine();

			switch (unos) {
			case "1":
				addStudent();

				break;
			case "2":
				viewOneStudent();

				break;
			case "3":
				changeOneStudent();

				break;
			case "4":
				deleteOneStudent();

				break;
			case "5":
				printAllStudent();
				break;
			default:
				System.out.println("Pogrešan unos.");
				break;
			}

			System.out.println("Da li zelite nastaviti (y/n): ");
			forYes = input.nextLine();
		}

	}

	public boolean isEmpty() {
		return arrayList.isEmpty();
	}

///////////////////////////////////////////1
	public void addStudent() {

		Student student = new Student();

		System.out.print("Unesite ime:");
		String ime = input.nextLine();

		System.out.print("Unesite prezime:");
		String prezime = input.nextLine();

		System.out.print("Unesite datum roðenja (dd/MM/yy):");
		String dob = input.nextLine();

		System.out.print("Unesite broj indexa:");
		String brIndexa = input.nextLine();

		while (checkId(id()) == false || checkIndexNumber(brIndexa) == false) {

			System.out.println("***Pogrešan unos. Pokušajte ponovo.***");

			System.out.print("Unesite ime:");
			ime = input.nextLine();

			System.out.print("Unesite prezime:");
			prezime = input.nextLine();

			System.out.print("Unesite datum roðenja (dd/MM/yy):");
			dob = input.nextLine();

			System.out.print("Unesite broj indexa:");
			brIndexa = input.nextLine();
		}

		student.setStudentId(id());
		student.setFirstName(ime);
		student.setLastName(prezime);
		student.setDob(dob);
		student.setIndexNumber(brIndexa);
		arrayList.add(new Student(student.getStudentId(), student.getFirstName(), student.getLastName(),
				student.getDob(), student.getIndexNumber()));

		System.out.println("***Student je dodan.***");

	}

	/*
	 * public String index() { char letter; int number; String sum = "";
	 * 
	 * for (int i = 0; i < 3; i++) { number = (int) (Math.random() * 10); sum = sum
	 * + number;
	 * 
	 * }
	 * 
	 * sum=sum + "-";
	 * 
	 * for (int i = 0; i < 3; i++) { letter = (char) (Math.random() * (90 - 65 + 1)
	 * + 65); sum = sum + letter;
	 * 
	 * } return sum; }
	 */
	public String id() {
		char letter;
		String sum = "";
		for (int i = 0; i < 10; i++) {
			letter = (char) (Math.random() * (90 - 65 + 1) + 65);
			sum = sum + letter;

		}
		return sum;
	}

	public boolean checkId(String id) {
		for (Student e : arrayList) {
			if (e.getStudentId().equals(id)) {
				return false;
			}
		}
		return true;

	}

	public boolean checkIndexNumber(String index) {
		for (Student e : arrayList) {

			if (e.getIndexNumber().equals(index)) {
				return false;
			}

		}
		return true;
	}

///////////////////////////2
	public void viewOneStudent() {
		if (isEmpty() == true) {
			System.out.println("Lista je prazna.");
		} else {

			System.out.print("Unesite Id:");
			String id = input.nextLine();

			while (checkIdForOneStudent(id) == false) {
				System.out.println("***Id ne postoji, pokusajte ponovo.***");

				System.out.print("Unesite Id:");
				id = input.nextLine();
			}

			printOneStudent(id);
		}
	}

	public boolean checkIdForOneStudent(String id) {
		for (Student e : arrayList) {

			if (e.getStudentId().equals(id)) {
				return true;
			}

		}
		return false;
	}

	public void printOneStudent(String id) {
		for (Student e : arrayList) {

			if (e.getStudentId().equals(id)) {
				System.out.println(e);
			}

		}
	}

////////////////////////////////////////////3
	public void changeOneStudent() {
		if (isEmpty() == true) {
			System.out.println("Lista je prazna.");
		} else {
			System.out.print("Unesite Id:");
			String id = input.nextLine();

			while (checkIdForOneStudent(id) == false) {
				System.out.println("***Id ne postoji, pokusajte ponovo.***");
				System.out.println();

				System.out.print("Unesite Id:");
				id = input.nextLine();
			}
			editOneStudent(id);

		}

	}

	public void editOneStudent(String _id) {

		System.out.print("Unesite ime:");
		String ime = input.nextLine();

		System.out.print("Unesite prezime:");
		String prezime = input.nextLine();

		System.out.print("Unesite datum roðenja (dd/MM/yy):");
		String dob = input.nextLine();

		System.out.print("Unesite broj indexa:");
		String brIndexa = input.nextLine();

		while (checkIndexNumber(brIndexa) == false) {

			System.out.println("***Pogrešan unos. Pokušajte ponovo.***");
			System.out.println();

			System.out.print("Unesite ime:");
			ime = input.nextLine();

			System.out.print("Unesite prezime:");
			prezime = input.nextLine();

			System.out.print("Unesite datum roðenja (dd/MM/yy):");
			dob = input.nextLine();

			System.out.print("Unesite broj indexa:");
			brIndexa = input.nextLine();
		}

		for (Student e : arrayList) {
			if (e.getStudentId().equals(_id)) {

				e.setFirstName(ime);
				e.setLastName(prezime);
				e.setDob(dob);
				e.setIndexNumber(brIndexa);
			}
		}
	}

//////////////////////////////////////////////////////////4
	public void deleteOneStudent() {
		if (isEmpty() == true) {
			System.out.println("Lista je prazna.");
		} else {

			System.out.print("Unesite Id:");
			String id = input.nextLine();

			while (checkIdForOneStudent(id) == false) {
				System.out.println("Id ne postoji, pokusajte ponovo.");

				System.out.print("Unesite Id:");
				id = input.nextLine();
			}

			printOneStudent(id);

			System.out.print("Da li želite obrisati navedenog studenta (d for yes):");
			String odgovor = input.nextLine();

			if (odgovor.equals("d")) {

				for (Student e : arrayList) {

					if (e.getStudentId().equals(id)) {
						arrayList.remove(e);

						System.out.println("Student je obrisan.");
					}
				}
			} else {
				System.out.println("Student nije obrisan.");

			}
		}
	}

////////////////////////////////////////5
	public void printAllStudent() {
		if (isEmpty() == true) {
			System.out.println("Lista je prazna.");
		} else {
			System.out.println("All Students");
			System.out.println("******************************************");

			for (Student e : arrayList) {

				System.out.println("Id broj: " + e.getStudentId());
				System.out.println("Ime: " + e.getFirstName());
				System.out.println("Prezime: " + e.getLastName());
				System.out.println("Datum roðenja: " + e.getDob());
				System.out.println("Broj indexa: " + e.getIndexNumber());

				System.out.println("----------------------------------------------");
				System.out.println("\n");
			}

		}
	}
}
