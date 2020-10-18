class DiceController {
	constructor(root, diceoutput) {
        this.root = root;
        this.dice = new Dice();
        this.diceoutput = diceoutput;
		this.run = this.run.bind(this);
		this.rollDice = this.rollDice.bind(this);
	}
	run() {
        let button = document.querySelector("button[data-dicebutton]");
        button.addEventListener("click", this.rollDice, true);
        let result = document.querySelector("span[data-diceoutput]");
        result.innerText = this.dice.roll();
    }
    rollDice() {
        this.diceoutput = this.dice.roll();
    }
}