package com.cooksys.ftd.assignments.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

interface IRational {

	/**
	 * @return the numerator of this rational number
	 */
	int getNumerator();

	/**
	 * @return the denominator of this rational number
	 */
	int getDenominator();

	/**
	 * Specializable constructor to take advantage of shared code between
	 * Rational and SimplifiedRational
	 * <p>
	 * Essentially, this method allows us to implement most of IRational methods
	 * directly in the interface while preserving the underlying type
	 *
	 * @param numerator
	 *            the numerator of the rational value to construct
	 * @param denominator
	 *            the denominator of the rational value to construct
	 * @return the constructed rational value
	 * @throws IllegalArgumentException
	 *             if the given denominator is 0
	 */
	IRational construct(int numerator, int denominator) throws IllegalArgumentException;

	/**
	 * negation of rational values
	 * <p>
	 * definition: `negate(n / d) = -n / d`
	 *
	 * @return the negation of this
	 */
	default IRational negate() {

		return construct(getNumerator() * -1, getDenominator());

	}

	/**
	 * inversion of rational values
	 * <p>
	 * definition: `invert(n / d) = d / n`
	 *
	 * @return the inversion of this
	 * @throws IllegalStateException
	 *             if the numerator of this rational value is 0
	 */
	default IRational invert() throws IllegalStateException {
		if (this.getNumerator() == 0) {
			throw new IllegalStateException();
		}
		
		IRational base = construct(this.getNumerator(), this.getDenominator());
		IRational inverted = construct(base.getDenominator(), base.getNumerator());
		return inverted;
	}

	/**
	 * addition of rational values
	 * <p>
	 * definition: `(n1 / d1) + (n2 / d2) = ((n1 * d2) + (n2 * d1)) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to add to this
	 * @return the sum of this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	default IRational add(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException();
		}
		
		int n1 = this.getNumerator();
		int d1 = this.getDenominator();
		int n2 = that.getNumerator();
		int d2 = that.getDenominator();
		
		IRational added = construct((n1 * d2) + (n2 * d1), d1 * d2);
		
		return added;

	}

	/**
	 * subtraction of rational values
	 * <p>
	 * definition: `(n1 / d1) - (n2 / d2) = ((n1 * d2) - (n2 * d1)) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to subtract from this
	 * @return the difference between this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	default IRational sub(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException();
		}
		
		int n1 = this.getNumerator();
		int d1 = this.getDenominator();
		int n2 = that.getNumerator();
		int d2 = that.getDenominator();
		
		IRational subtracted = construct((n1 * d2) - (n2 * d1), (d1 * d2));
		
		return subtracted;
	
	}

	/**
	 * multiplication of rational values
	 * <p>
	 * definition: `(n1 / d1) * (n2 / d2) = (n1 * n2) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to multiply this by
	 * @return the product of this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	default IRational mul(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException();
		}
		
		int n1 = this.getNumerator();
		int d1 = this.getDenominator();
		int n2 = that.getNumerator();
		int d2 = that.getDenominator();
		
		IRational multiplied = construct((n1 * n2), (d1 * d2));
		
		return multiplied;
	}

	/**
	 * division of rational values
	 * <p>
	 * definition: `(n1 / d1) / (n2 / d2) = (n1 * d2) / (d1 * n2)`
	 *
	 * @param that
	 *            the value to divide this by
	 * @return the ratio of this to that
	 * @throws IllegalArgumentException
	 *             if that is null or if the numerator of that is 0
	 */
	default IRational div(IRational that) throws IllegalArgumentException {
		if (that == null) {
			throw new IllegalArgumentException();
		}
		
		int n1 = this.getNumerator();
		int d1 = this.getDenominator();
		int n2 = that.getNumerator();
		int d2 = that.getDenominator();
		
		IRational divided = construct((n1 * d2), (d1 * n2));
		
		return divided;
	}
}
