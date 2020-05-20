package model.entities;

import model.exceptions.InvalidAmountException;
import model.exceptions.NotEnoughBalanceException;
import model.exceptions.WithdrawLimitException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance = 0.0;
	private Double withdrawLimit = 0.0;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws InvalidAmountException {
		this.number = number;
		this.holder = holder;
		deposit(balance);
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) throws InvalidAmountException {
		if(amount <= 0.00) {
			throw new InvalidAmountException("Deposit amount must be greater than 0");
		}
		this.balance += amount;
	}
	
	public void withdraw(Double amount) throws WithdrawLimitException, NotEnoughBalanceException{
		if(amount > withdrawLimit) {
			throw new WithdrawLimitException("Amount exceds withdraw limit");
		} else if(amount > balance) {
			throw new NotEnoughBalanceException("Not enough balance");
		}
		this.balance -= amount;
	}
	

}
