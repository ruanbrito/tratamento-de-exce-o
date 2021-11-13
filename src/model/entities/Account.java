package model.entities;

import model.exception.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}

	public void withdraw(Double amount) throws DomainException {

		if (amount > getWithdrawLimit()) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (amount > getBalance()) {
			throw new DomainException("Not enough balance");
		}
		 this.balance -= amount;
		System.out.println("New balance: " + String.format("%.2f", this.balance));
	}

}
