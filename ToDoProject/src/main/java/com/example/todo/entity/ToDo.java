package com.example.todo.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TODO_SYS")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workId;
	private String workName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate target;
	private String workStatus;
	
	
	public ToDo() {
	}
	
	public ToDo(int workId, String workName, LocalDate target, String workStatus) {
		super();
		this.workId = workId;
		this.workName = workName;
		this.target = target;
		this.workStatus = workStatus;
	}

	public int getworkId() {
		return workId;
	}
	public void setId(int workId) {
		this.workId = workId;
	}
	
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public LocalDate getTarget() {
		return target;
	}
	public void setTarget(LocalDate target) {
		this.target = target;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	@Override
	public String toString() {
		return "ToDo [workId=" + workId + ", workName=" + workName + ", target=" + target + ", workStatus=" + workStatus
				+ "]";
	}
	
	
	
	
	
	
	
}
