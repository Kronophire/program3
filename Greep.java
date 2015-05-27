import sofia.micro.greeps.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 * This class would create the Greep subclass,
 * superclass of Alien, and it would wander
 * around the Earth and trying to collect
 * as much tomato and send them back to their
 * ship.
 * 
 * @author Christopher Aska Toda (aska192)
 * @version 2.2.1-14 (2013.10.15)
 */
public class Greep extends Alien {
	// ~ Fields ................................................................

	// Remember--only boolean fields are allowed in the Greeps class

	// ~ Constructor ...........................................................
	// ----------------------------------------------------------
	/**
	 * Creates a new Greep object.
	 */
	public Greep() {
		super();
	}

	// ~ Methods ...............................................................

	/**
     * 
     */
	public void act() {
		int value = Random.generator().nextInt(5);

		if (!this.hasTomato()) {
			if (value == 0) {
				this.turn(RIGHT); // clockwise
				if (!this.sees(Tomato.class, HERE)
						&& !this.sees(Water.class, AHEAD)) {
					this.hop();

				}
			} else if (value == 1) {
				this.turn(LEFT); // anti-clockwise
				if (!this.sees(Tomato.class, HERE)
						&& !this.sees(Water.class, AHEAD)) {
					this.hop();

				}
			} else if (!this.sees(Tomato.class, HERE)
					&& !this.sees(Water.class, AHEAD)
					&& (value == 2 || value == 3 || value == 4)) {
				this.hop();

			}
			this.pickTomato();

		} else {
			//
			// if (this.hasTomato())
			// {
			// if (this.sees(Ship.class, HERE))
			// {
			// this.unloadTomato();
			// }
			// }
			this.movingTowardsShip();
			if (this.sees(Ship.class, HERE)) {
				this.unloadTomato();
			}
			// else if (this.sees(Tomato.class, HERE))
			// {
			// this.paint();
			//
			// if (this.sees(PaintTrail.class, AHEAD))
			// {
			// this.hop();
			// this.loadTomato(HERE);
			// }
			// }

		}
	}

	/**
     * 
     */
	public void pickTomato() {
		if (this.sees(Tomato.class, HERE)) {
			this.paint();

			if (this.sees(PaintTrail.class, AHEAD)
					|| this.sees(Greep.class, AHEAD)) {
				this.hop();
				this.loadTomato(HERE);
			}
		}
	}

	/**
     * 
     */
	public void returnToShip() {
		if (this.hasTomato() && this.sees(Ship.class, HERE)) {
			this.movingTowardsShip();
			this.unloadTomato();
		}
	}

	/**
     * 
     */
	public void movingTowardsShip() {
		if (!this.sees(Ship.class, HERE)) {
			this.turnTowardShip();
			if (this.isClear(AHEAD) || this.sees(Ship.class, AHEAD)
					|| this.sees(Greep.class, AHEAD)) {
				this.hop();
			} else if (!this.isClear(AHEAD) && this.isClear(RIGHT)
					&& this.isClear(LEFT)) {
				this.turn(RIGHT);
				this.hop();
			} else if (!this.isClear(AHEAD) && !this.isClear(RIGHT)
					&& this.isClear(LEFT)) {
				this.turn(LEFT);
				this.hop();
			} else if (!this.isClear(AHEAD) && !this.isClear(LEFT)
					&& this.isClear(RIGHT)) {
				this.turn(RIGHT);
				this.hop();
			} else if (!this.isClear(AHEAD) && !this.isClear(LEFT)
					&& !this.isClear(RIGHT)) {
				this.turn(RIGHT);
				this.turn(RIGHT);
				this.hop();
			}
		}
	}

}
