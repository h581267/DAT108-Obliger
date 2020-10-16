class DiceController {

	constructor(root) {
		this.root = root;

		this.dice = new Dice();
		this.rollDice = this.rollDice.bind(this);
		this.run = this.run.bind(this);
	}

	run() {

		const rootElement = document.getElementById(this.root);
		const button = document.querySelector("button[data-dicebutton]");
		button.addEventListener("click", this.rollDice);

		const output = document.querySelector("text[data-diceoutput]");
		output.textContent = this.dice.value;

	}
}

function rollDice() {
	return this.dice.roll();
}

const controller = new DiceController("root");
document.addEventListener("DOMContetLoaded", controller.run());

