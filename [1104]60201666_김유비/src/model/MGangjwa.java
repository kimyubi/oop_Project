package model;

import java.io.PrintWriter;
import java.util.Scanner;

import valueObject.VGangjwa;

public class MGangjwa extends MModel {
	private Scanner scanner;
	private PrintWriter printWriter;
	private String id;
	private String name;
	private String lecturer;
	private String credit;
	private String time;

	public MGangjwa(Scanner scanner) {
		this.scanner = scanner;
	}

	public MGangjwa(PrintWriter printWriter, VGangjwa vGangjwa) {
		
		this.printWriter = printWriter;

		this.id = vGangjwa.getId();
		this.name = vGangjwa.getName();
		this.lecturer = vGangjwa.getLecturer();
		this.credit = vGangjwa.getCredit();
		this.time = vGangjwa.getTime();
	}

	public void read() {
		this.id = scanner.next();
		this.name = scanner.next();
		this.lecturer = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();

	}

	public void save() {
		this.printWriter.print(this.getId() + " ");
		this.printWriter.print(this.getName() + " ");
		this.printWriter.print(this.getLecturer() + " ");
		this.printWriter.print(this.getCredit() + " ");
		this.printWriter.println(this.getTime());
		this.printWriter.flush();
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLecturer() {
		return lecturer;
	}

	public String getCredit() {
		return credit;
	}

	public String getTime() {
		return time;
	}

}
