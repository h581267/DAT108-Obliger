"use strict"

class Dice {
	constructor(maxNumber = 6) {
		this.maxnumber = maxNumber;
		this.value = null;
	}

	roll() {
		this.value = 1 + Math.trunc(this.maxnumber * Math.random());
	}
}
