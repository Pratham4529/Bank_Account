package com.aurionpro.model;

	public class OverdraftLimitExceededException extends RuntimeException {

	    private final double attemptedAmount;

	    public OverdraftLimitExceededException(double attemptedAmount) {
	        super("Overdraft limit exceeded. Attempted to debit: " + attemptedAmount);
	        this.attemptedAmount = attemptedAmount;
	    }

	    public double getAttemptedAmount() {
	        return attemptedAmount;
	    }
	}

